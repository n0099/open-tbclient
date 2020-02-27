package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.chatmessage.request.IMFetchConfigMsg;
import com.baidu.android.imsdk.internal.IMSocketAddrProvider;
import com.baidu.android.imsdk.mcast.McastManagerImpl;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.IMService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class IMConnection {
    public static final int ERROR_LOGIN_FAIL = 7;
    private static final int MAX_RETRY_TIMES = 10;
    private static final int MSG_ID_SEND_MSG_TIMEOUT = 1;
    private static final double RECONNECTION_TIME_COEFFICIENT = 0.3d;
    private static final int RECONNECTION_TIME_INTERVAL = 30;
    private static final int SOCKET_CONNECTING_TIMOUT = 5000;
    private static final int SOCKET_TIMEOUT = 60000;
    private static final String TAG = "IMConnection";
    private static volatile IMConnection mConnectionInstance;
    private Context mContext;
    private IMessageHandler mMessageHandler;
    private ReadThread mReadThread;
    private SendThread mSendThread;
    private long mStartConnTime;
    private Object mSync = new Object();
    private long mNowId = 0;
    private long mLastReadWriteTime = 0;
    private Object mOutputSync = new Object();
    private boolean mClose = false;
    private boolean mStoped = false;
    private int mDelayTimes = -1;
    private String mConnectIps = "";
    private Runnable mReconnectRunnable = new Runnable() { // from class: com.baidu.android.imsdk.internal.IMConnection.2
        @Override // java.lang.Runnable
        public void run() {
            if (!IMService.isSmallFlow) {
                IMConnection.this.internalConnect(false);
            }
        }
    };
    private Runnable mSocketTimeoutRunnable = new Runnable() { // from class: com.baidu.android.imsdk.internal.IMConnection.3
        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - IMConnection.this.mLastReadWriteTime > 60000) {
                LogUtils.i(IMConnection.TAG, " SOCKET_TIMEOUT-- Socket heartbeat timeout !! --");
                IMConnection.this.disconnectedByPeer();
                return;
            }
            LogUtils.i(IMConnection.TAG, " SOCKET_TIMEOUT-- Socket heartbeat check ok !! --");
        }
    };
    private HashMap<Long, Message> mSendMessageMap = new HashMap<>();
    private Map<Integer, Boolean> mSocketNeedCloseMap = new TreeMap();
    private AtomicInteger mConnectId = new AtomicInteger(0);
    private AtomicInteger mFailedNumber = new AtomicInteger(0);
    private AtomicBoolean mConnected = new AtomicBoolean(false);
    private AtomicBoolean mConnectting = new AtomicBoolean(false);
    private Handler mHandler = new MyHandler(Looper.getMainLooper());

    static /* synthetic */ long access$2108(IMConnection iMConnection) {
        long j = iMConnection.mNowId;
        iMConnection.mNowId = 1 + j;
        return j;
    }

    private IMConnection(Context context) {
        this.mContext = context.getApplicationContext();
        this.mMessageHandler = new MessageHandler(this.mContext);
    }

    public static IMConnection getInstance(Context context) {
        if (mConnectionInstance == null) {
            synchronized (IMConnection.class) {
                if (mConnectionInstance == null) {
                    mConnectionInstance = new IMConnection(context);
                }
            }
        }
        return mConnectionInstance;
    }

    public void connect() {
        this.mFailedNumber.set(0);
        this.mStoped = false;
        connectImpl(false);
    }

    public void internalConnect(boolean z) {
        if (z) {
            this.mFailedNumber.set(0);
        }
        this.mStoped = false;
        connectImpl(true);
    }

    private void connectImpl(final boolean z) {
        if (!IMService.isSmallFlow) {
            if (this.mConnected.get() || this.mConnectting.get()) {
                LogUtils.i(TAG, "Connect return. mConnected:" + this.mConnected.get() + " mConnectting:" + this.mConnectting.get());
            } else if (!AccountManager.isLogin(this.mContext)) {
                LogUtils.d(TAG, "Token is not set");
            } else {
                this.mConnectting.set(true);
                this.mHandler.removeCallbacks(this.mReconnectRunnable);
                Utility.writeLoginFlag(this.mContext, "10Y", "connect begin");
                LogUtils.i(TAG, "will get socket address .......");
                IMSocketAddrProvider.getInstance(this.mContext).getSocketAddr(new IMSocketAddrProvider.IGetSocketAddrListener() { // from class: com.baidu.android.imsdk.internal.IMConnection.1
                    @Override // com.baidu.android.imsdk.internal.IMSocketAddrProvider.IGetSocketAddrListener
                    public void onGetSocketAddrResult(String str) {
                        LogUtils.i(IMConnection.TAG, "get socket address = " + str);
                        Utility.writeLoginFlag(IMConnection.this.mContext, "14N_0", "socketConnect :" + str);
                        String str2 = Constants.URL_SOCKET_SERVER;
                        int i = Constants.SOCKET_PORT_SSL;
                        try {
                            str2 = str.split(":")[0];
                            i = Integer.valueOf(str.split(":")[1]).intValue();
                        } catch (Exception e) {
                            e.printStackTrace();
                            new IMTrack.CrashBuilder(IMConnection.this.mContext).exception(Log.getStackTraceString(e)).build();
                        }
                        boolean submitForNetWork = TaskManager.getInstance(IMConnection.this.mContext).submitForNetWork(new ConnectTask(z, str2, i, Integer.valueOf(IMConnection.this.mConnectId.incrementAndGet())));
                        LogUtils.i(IMConnection.TAG, "ConnectTask add to ThreadPool = " + submitForNetWork);
                        if (!submitForNetWork) {
                            IMConnection.this.mConnectting.set(false);
                            TaskManager.getInstance(IMConnection.this.mContext).clearTask();
                            LogUtils.d(IMConnection.TAG, "getUrlAsync..will disconnectedByPeer..." + str);
                            IMConnection.this.disconnectedByPeer();
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes3.dex */
    private final class ConnectTask implements Runnable {
        Integer mConnectTaskId;
        String mIp;
        boolean mIsInternalAction;
        int mPort;

        public ConnectTask(boolean z, String str, int i, Integer num) {
            this.mIsInternalAction = z;
            this.mIp = str;
            this.mPort = i;
            this.mConnectTaskId = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LogUtils.d(IMConnection.TAG, "ConnectTask run...id=" + this.mConnectTaskId + ", thread=" + Thread.currentThread().getName());
                LogUtils.d(IMConnection.TAG, "ConnectTask run...mConnected.get()=" + IMConnection.this.mConnected.get() + ", mIsInternalAction=" + this.mIsInternalAction + ", logined=" + LoginManager.getInstance(IMConnection.this.mContext).getCurrentState());
                if (!IMConnection.this.mConnected.get() || !this.mIsInternalAction) {
                    IMConnection.this.initReadAndSendThread();
                    ConnectTimeOutTask connectTimeOutTask = new ConnectTimeOutTask(this.mConnectTaskId);
                    IMConnection.this.mHandler.postDelayed(connectTimeOutTask, 5000L);
                    IMConnection.this.mStartConnTime = System.currentTimeMillis();
                    IMConnection.this.mConnectIps = this.mIp + ":" + this.mPort;
                    Utility.writeLoginFlag(IMConnection.this.mContext, "14N", "socketConnect :" + IMConnection.this.mConnectIps);
                    LogUtils.d(IMConnection.TAG, "ConnectTask run...socketConnect...thread=" + Thread.currentThread().getName());
                    SocketState socketConnect = IMConnection.this.mMessageHandler.socketConnect(this.mIp, this.mPort);
                    LogUtils.d(IMConnection.TAG, "ConnectTask run...state back...thread=" + Thread.currentThread().getName());
                    if (socketConnect != null && socketConnect.mSocketEnvOk.booleanValue()) {
                        synchronized (IMConnection.this.mSocketNeedCloseMap) {
                            LogUtils.d(IMConnection.TAG, "ConnectTask run...synchronized (mSocketNeedCloseMap)...thread=" + Thread.currentThread().getName());
                            IMConnection.this.mHandler.removeCallbacks(connectTimeOutTask);
                            connectTimeOutTask.setStoped();
                            if (IMConnection.this.mSocketNeedCloseMap.get(this.mConnectTaskId) == null) {
                                LogUtils.d(IMConnection.TAG, "ConnectTask run...no timeout...thread=" + Thread.currentThread().getName());
                                IMConnection.this.mMessageHandler.setCurrentSocketState(socketConnect);
                            } else {
                                LogUtils.d(IMConnection.TAG, "ConnectTask run...timeout...thread=" + Thread.currentThread().getName());
                                if (IMConnection.this.mConnected.get()) {
                                    LogUtils.d(IMConnection.TAG, "ConnectTask run...timeout...connected=true...thread=" + Thread.currentThread().getName());
                                    IMConnection.this.closeSocketState(socketConnect);
                                    if (this.mIsInternalAction) {
                                        IMConnection.this.mMessageHandler.onSessionOpened();
                                    }
                                    return;
                                } else if (!socketConnect.mSocketCreateOk.booleanValue()) {
                                    LogUtils.d(IMConnection.TAG, "ConnectTask run...!state.mSocketCreateOk...thread=" + Thread.currentThread().getName());
                                    IMConnection.this.closeSocketState(socketConnect);
                                    return;
                                } else {
                                    LogUtils.d(IMConnection.TAG, "ConnectTask run...state.mSocketCreateOk...thread=" + Thread.currentThread().getName());
                                    IMConnection.this.mMessageHandler.setCurrentSocketState(socketConnect);
                                }
                            }
                            IMConnection.this.mFailedNumber.set(0);
                            IMConnection.this.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_OK, "connect ok");
                            LogUtils.i(IMConnection.TAG, "ConnectTask run...create Socket ok, thread=" + Thread.currentThread().getName());
                            Utility.writeLoginFlag(IMConnection.this.mContext, "16Y", "connect ok");
                            IMSocketAddrProvider.getInstance(IMConnection.this.mContext).onSuccessSocketAddr(this.mIp + ":" + this.mPort);
                            IMConnection.this.mConnected.set(true);
                            IMConnection.this.mClose = false;
                            IMConnection.this.mReadThread = new ReadThread();
                            IMConnection.this.mReadThread.start();
                            IMConnection.this.mSendThread = new SendThread();
                            IMConnection.this.mSendThread.start();
                            if (this.mIsInternalAction) {
                                LogUtils.i(IMConnection.TAG, "ConnectTask run...onSessionOpened...thread=" + Thread.currentThread().getName());
                                IMConnection.this.mMessageHandler.onSessionOpened();
                            }
                            LogUtils.d(IMConnection.TAG, "connectImpl time:" + SystemClock.currentThreadTimeMillis());
                            IMConnection.this.mConnectting.set(false);
                            return;
                        }
                    }
                    LogUtils.d(IMConnection.TAG, "ConnectTask run...（state == null || !state.mSocketEnvOk）...thread=" + Thread.currentThread().getName());
                    Utility.writeLoginFlag(IMConnection.this.mContext, "15N", "connect env error");
                    IMConnection.this.mHandler.removeCallbacks(connectTimeOutTask);
                    IMConnection.this.mConnectting.set(false);
                    LogUtils.d(IMConnection.TAG, "!state.mSocketEnvOk..will disconnectedByPeer...");
                    IMConnection.this.disconnectedByPeer();
                    IMConnection.this.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_ENV_FAIL, "env error");
                    return;
                }
                IMConnection.this.mMessageHandler.onSessionOpened();
            } catch (Exception e) {
                LogUtils.e(IMConnection.TAG, "connectRunable", e);
                IMConnection.this.mConnectting.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSocketState(SocketState socketState) {
        Utility.writeLoginFlag(this.mContext, "15N_1", "connecting but socket close ");
        LogUtils.d(TAG, "closeSocketState....thread=" + Thread.currentThread().getName());
        try {
            if (socketState.mSocket != null) {
                socketState.mSocket.close();
                socketState.mSocket = null;
            }
            if (socketState.mInputStream != null) {
                socketState.mInputStream.close();
                socketState.mInputStream = null;
            }
            if (socketState.mOutputStream != null) {
                socketState.mOutputStream.close();
                socketState.mOutputStream = null;
            }
        } catch (IOException e) {
            LogUtils.e(TAG, "destroy:" + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initReadAndSendThread() {
        LogUtils.d(TAG, "initReadAndSendThread...thread=" + Thread.currentThread().getName());
        if (this.mReadThread != null && this.mReadThread.isAlive()) {
            this.mReadThread.interrupt();
            LogUtils.d(TAG, "mReadThread interupt");
        }
        if (this.mSendThread != null && this.mSendThread.isAlive()) {
            this.mSendThread.interrupt();
            LogUtils.d(TAG, "mSendThread interupt");
        }
    }

    public boolean isConnected() {
        return this.mConnected.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectTrack(int i, String str) {
        if (this.mConnectIps.contains(Constants.URL_SOCKET_SERVER) && !this.mMessageHandler.mSocketIp.isEmpty()) {
            this.mConnectIps = this.mMessageHandler.mSocketIp + ":" + Constants.URL_SOCKET_PORT;
        }
        this.mConnectIps += ":" + RequsetNetworkUtils.getNetInfo(this.mContext);
        LogUtils.d(TAG, "connectTrack ext:" + this.mConnectIps);
        new IMTrack.ConnectionBuilder(this.mContext).startTime(this.mStartConnTime).stopTime(System.currentTimeMillis()).aliasId(i).reason(str).ext(this.mConnectIps).retryCount(this.mFailedNumber.get()).build();
        this.mConnectIps = "";
    }

    public void stop() {
        LogUtils.i(TAG, "---stop---");
        this.mClose = true;
        this.mStoped = true;
        this.mHandler.removeCallbacks(this.mReconnectRunnable);
        destroy();
    }

    public void sendMessage(Message message, boolean z) {
        boolean z2;
        synchronized (this.mMessageHandler.getMessageQueue()) {
            if (message instanceof IMUserLoginByTokenMsg) {
                Utility.writeLoginFlag(this.mContext, "16Y_2", "send Logig msg");
                z2 = true;
            } else {
                z2 = z;
            }
            if (message instanceof IMFetchConfigMsg ? true : z2) {
                this.mMessageHandler.getMessageQueue().addFirst(message);
            } else {
                this.mMessageHandler.getMessageQueue().add(message);
            }
            this.mMessageHandler.getMessageQueue().notifyAll();
            if (!this.mConnected.get() && !this.mConnectting.get()) {
                if (message instanceof IMUserLoginByTokenMsg) {
                    connect();
                } else {
                    internalConnect(true);
                }
            }
        }
    }

    public void sendEmptyMessage() {
        synchronized (this.mMessageHandler.getMessageQueue()) {
            this.mMessageHandler.getMessageQueue().notifyAll();
            if (!this.mConnected.get() && !this.mConnectting.get()) {
                internalConnect(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class ReadThread extends Thread {
        ReadThread() {
            setName("IM-IMConnection-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!IMConnection.this.mClose) {
                try {
                    try {
                        Message readMessage = IMConnection.this.mMessageHandler.readMessage();
                        IMConnection.this.mHandler.removeCallbacks(IMConnection.this.mSocketTimeoutRunnable);
                        if (readMessage != null) {
                            readMessage.isSending(false);
                            LogUtils.d(IMConnection.TAG, "ReadThread receive msg :" + readMessage.toString());
                            if (!readMessage.isHeartbeat()) {
                                synchronized (IMConnection.this.mSync) {
                                    LogUtils.d(IMConnection.TAG, "SOCKET_TIMEOUT read response...");
                                    IMConnection.this.mMessageHandler.handleMessage(readMessage, (Message) IMConnection.this.mSendMessageMap.remove(Long.valueOf(readMessage.getMsgId())), true);
                                }
                            }
                            synchronized (IMConnection.this.mSync) {
                                if (IMConnection.this.mSendMessageMap.size() != 0) {
                                    IMConnection.this.mLastReadWriteTime = System.currentTimeMillis();
                                    LogUtils.d(IMConnection.TAG, "SOCKET_TIMEOUT read ...");
                                    IMConnection.this.mHandler.postDelayed(IMConnection.this.mSocketTimeoutRunnable, 60000L);
                                }
                            }
                        }
                        McastManagerImpl.getInstance(IMConnection.this.mContext).setMcastQuickHeartBeat();
                    } catch (IOException e) {
                        LogUtils.e(IMConnection.TAG, "ReadThread exception: " + e, e);
                        IMConnection.this.mStoped = false;
                        IMConnection.this.disconnectedByPeer();
                        return;
                    }
                } catch (Exception e2) {
                    LogUtils.e(LogUtils.TAG, "onStartCommand", e2);
                    IMConnection.this.mStoped = false;
                    IMConnection.this.disconnectedByPeer();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class SendThread extends Thread {
        SendThread() {
            setName("IM-IMConnection-SendThread");
        }

        /* JADX WARN: Removed duplicated region for block: B:113:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:135:0x0005 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:? -> B:110:0x02a1). Please submit an issue!!! */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Message message;
            while (!IMConnection.this.mClose) {
                try {
                    try {
                    } catch (InterruptedException e) {
                        e = e;
                        message = null;
                    }
                    synchronized (IMConnection.this.mMessageHandler.getMessageQueue()) {
                        try {
                            if (IMConnection.this.mMessageHandler.getMessageQueue().size() == 0) {
                                if (IMSDK.getInstance(IMConnection.this.mContext).getUk() > 0) {
                                    message = IMCmdQueueHelper.getFirstIdleCmdQueueMsg(IMConnection.this.mContext);
                                    if (message == null) {
                                        try {
                                            IMConnection.this.mMessageHandler.getMessageQueue().wait();
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                throw th;
                                                break;
                                            } catch (InterruptedException e2) {
                                                e = e2;
                                                LogUtils.e(IMConnection.TAG, "SendThread wait exception: " + e);
                                                IMConnection.this.mMessageHandler.handleMessage(message, null, false);
                                                IMConnection.this.disconnectedByPeer();
                                                if (message == null) {
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    IMConnection.this.mMessageHandler.getMessageQueue().wait();
                                    message = null;
                                }
                            } else if (IMConnection.this.mMessageHandler.getMessageQueue().size() > 0) {
                                Message first = IMConnection.this.mMessageHandler.getMessageQueue().getFirst();
                                if (first != null) {
                                    try {
                                        if (!first.isHeartbeat() && first.getType() != 50 && first.getUk() == 0) {
                                            synchronized (IMConnection.this.mMessageHandler.getMessageQueue()) {
                                                IMConnection.this.mMessageHandler.getMessageQueue().wait();
                                            }
                                            message = first;
                                        }
                                    } catch (Throwable th2) {
                                        message = first;
                                        th = th2;
                                        throw th;
                                        break;
                                        break;
                                    }
                                }
                                message = IMConnection.this.mMessageHandler.getMessageQueue().removeFirst();
                            } else {
                                message = null;
                            }
                            if (message == null) {
                                try {
                                    if (IMConnection.this.mClose) {
                                        IMConnection.this.mMessageHandler.handleMessage(message, null, false);
                                        return;
                                    }
                                    if (message.getType() != 50 && message.getUk() <= 0) {
                                        if (IMSDK.getInstance(IMConnection.this.mContext).getUk() > 0) {
                                            message.setUk(IMSDK.getInstance(IMConnection.this.mContext).getUk());
                                        } else {
                                            IMConnection.this.mMessageHandler.handleMessage(message, null, false);
                                            return;
                                        }
                                    }
                                    message.isSending(true);
                                    message.onMsgSending(IMConnection.this.mContext);
                                    message.setAppid(AccountManager.getAppid(IMConnection.this.mContext));
                                    message.setMsgId(IMConnection.access$2108(IMConnection.this));
                                    if (!message.isHeartbeat() && message.isNeedReplay()) {
                                        synchronized (IMConnection.this.mSync) {
                                            if (IMConnection.this.mSendMessageMap.isEmpty()) {
                                                IMConnection.this.mHandler.removeCallbacks(IMConnection.this.mSocketTimeoutRunnable);
                                                IMConnection.this.mLastReadWriteTime = System.currentTimeMillis();
                                                LogUtils.d(IMConnection.TAG, "SOCKET_TIMEOUT send ...");
                                                IMConnection.this.mHandler.postDelayed(IMConnection.this.mSocketTimeoutRunnable, 60000L);
                                            }
                                        }
                                    }
                                    LogUtils.d(IMConnection.TAG, "Send Msg:" + message.toString());
                                    if (message.getType() == 50) {
                                        Utility.writeLoginFlag(IMConnection.this.mContext, "17N", "Send LoginMsg request");
                                    }
                                    synchronized (IMConnection.this.mOutputSync) {
                                        IMConnection.this.mMessageHandler.socketWrite(message);
                                    }
                                    if (!message.isHeartbeat() && message.isNeedReplay()) {
                                        synchronized (IMConnection.this.mSync) {
                                            IMConnection.this.mSendMessageMap.put(Long.valueOf(message.getMsgId()), message);
                                        }
                                    } else if (!message.isHeartbeat() && !message.isNeedReplay()) {
                                        message.handleMessageResult(IMConnection.this.mContext, null, 0, "sucess");
                                    }
                                } catch (Exception e3) {
                                    LogUtils.e(LogUtils.TAG, "SendThread:", e3);
                                    if (message.getType() == 50) {
                                        Utility.writeLoginFlag(IMConnection.this.mContext, "17N_1", "Send LoginMsg exception");
                                    }
                                    IMConnection.this.mMessageHandler.handleMessage(message, null, false);
                                    IMConnection.this.disconnectedByPeer();
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            message = null;
                        }
                    }
                } catch (Exception e4) {
                    LogUtils.e(LogUtils.TAG, "onStartCommand", e4);
                    IMConnection.this.disconnectedByPeer();
                    return;
                }
            }
        }
    }

    private void fatalAllMessage() {
        synchronized (this.mMessageHandler.getMessageQueue()) {
            while (this.mMessageHandler.getMessageQueue().size() > 0) {
                this.mMessageHandler.handleMessage(this.mMessageHandler.getMessageQueue().removeFirst(), null, false);
            }
        }
        synchronized (this.mSync) {
            for (Long l : this.mSendMessageMap.keySet()) {
                Message message = this.mSendMessageMap.get(l);
                if (message != null) {
                    this.mMessageHandler.handleMessage(message, null, false);
                }
            }
            this.mSendMessageMap.clear();
        }
    }

    public boolean shouldRetryLogin() {
        return !this.mStoped && this.mFailedNumber.get() < 10 && IMUserLoginByTokenMsg.sRetrytimes < 7;
    }

    public void disconnectedByPeer() {
        if (!IMService.isSmallFlow) {
            LogUtils.i(TAG, "disconnectedByPeer, mStoped == " + this.mStoped);
            connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_STOP, "connect stop");
            fatalAllMessage();
            if (!this.mStoped) {
                destroy();
                this.mFailedNumber.incrementAndGet();
                if (this.mFailedNumber.get() < 10 && IMUserLoginByTokenMsg.sRetrytimes < 7) {
                    LogUtils.d(TAG, "now total create times....." + this.mFailedNumber.get());
                    long computeDelayTime = computeDelayTime(this.mFailedNumber.get() + IMUserLoginByTokenMsg.sRetrytimes);
                    this.mHandler.postDelayed(this.mReconnectRunnable, computeDelayTime);
                    LogUtils.i(TAG, "Schedule retry-- retry times: " + this.mFailedNumber + " time delay: " + computeDelayTime);
                }
            }
        }
    }

    private long computeDelayTime(int i) {
        if (this.mDelayTimes < 0) {
            this.mDelayTimes = new Random().nextInt(30) % 31;
        }
        return ((long) ((Math.pow(2.0d, i) * RECONNECTION_TIME_COEFFICIENT) + this.mDelayTimes)) * 1000;
    }

    private void destroy() {
        if (!IMService.isSmallFlow) {
            LogUtils.i(TAG, "destroy");
            Utility.sendConnectionStateBroadCast(this.mContext, 2);
            this.mHandler.removeCallbacks(this.mSocketTimeoutRunnable);
            this.mClose = true;
            if (this.mMessageHandler != null) {
                synchronized (this.mMessageHandler.getMessageQueue()) {
                    this.mMessageHandler.getMessageQueue().notifyAll();
                }
                this.mMessageHandler.onSessionClosed();
                try {
                    this.mMessageHandler.socketClose();
                } catch (Exception e) {
                    this.mMessageHandler.setCurrentSocketState(null);
                    LogUtils.e(LogUtils.TAG, "Exception destroy:", e);
                }
            }
            this.mConnected.set(false);
            this.mConnectting.set(false);
            BIMManager.connectStatusNotify(1);
        }
    }

    /* loaded from: classes3.dex */
    private class ConnectTimeOutTask implements Runnable {
        Integer mConnectTaskId;
        boolean mTaskStoped = false;

        ConnectTimeOutTask(Integer num) {
            this.mConnectTaskId = num;
        }

        void setStoped() {
            this.mTaskStoped = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (IMConnection.this.mSocketNeedCloseMap) {
                if (!this.mTaskStoped) {
                    IMConnection.this.mSocketNeedCloseMap.put(this.mConnectTaskId, true);
                    IMConnection.this.mConnectting.set(false);
                    LogUtils.d(IMConnection.TAG, "ConnectTimeOutTask....will disconnectedByPeer");
                    IMConnection.this.disconnectedByPeer();
                    Utility.writeLoginFlag(IMConnection.this.mContext, "14N_1", "socketConnect_timeout :" + IMConnection.this.mConnectIps);
                    IMConnection.this.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_TIMEOUT, "time out");
                }
            }
        }
    }

    public void sendHeartbeatMessage() {
        if (this.mMessageHandler != null) {
            this.mMessageHandler.sendHeartbeatMessage();
        }
    }

    /* loaded from: classes3.dex */
    private class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                long j = message.arg1;
                synchronized (IMConnection.this.mSync) {
                    if (IMConnection.this.mSendMessageMap.containsKey(Long.valueOf(j))) {
                        LogUtils.d(IMConnection.TAG, "send msg timeout!!! " + ((Message) IMConnection.this.mSendMessageMap.get(Long.valueOf(j))).toString());
                        IMConnection.this.mMessageHandler.handleMessage((Message) IMConnection.this.mSendMessageMap.remove(Long.valueOf(j)), null, false);
                    }
                }
            }
        }
    }
}
