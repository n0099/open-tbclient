package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.chatmessage.request.IMFetchConfigMsg;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.internal.IMSocketAddrProvider;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.upload.action.IMTrackManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import d.a.r.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class IMConnection {
    public static final int ERROR_LOGIN_FAIL = 20;
    public static final int MAX_RETRY_TIMES = 10;
    public static final int MSG_ID_SEND_MSG_TIMEOUT = 1;
    public static final double RECONNECTION_TIME_COEFFICIENT = 0.3d;
    public static final int RECONNECTION_TIME_INTERVAL = 30;
    public static final long RETRY_DELAY_TIMES = 3000;
    public static final int SOCKET_CONNECTING_TIMOUT = 5000;
    public static final int SOCKET_TIMEOUT = 60000;
    public static final String TAG = "IMConnection";
    public static volatile IMConnection mConnectionInstance;
    public Context mContext;
    public IMessageHandler mMessageHandler;
    public ReadThread mReadThread;
    public SendThread mSendThread;
    public long mStartConnTime;
    public Object mSync = new Object();
    public long mNowId = 0;
    public long mLastReadWriteTime = 0;
    public Object mOutputSync = new Object();
    public boolean mClose = false;
    public boolean mStoped = false;
    public int mDelayTimes = -1;
    public String mConnectIps = "";
    public Runnable mReconnectRunnable = new Runnable() { // from class: com.baidu.android.imsdk.internal.IMConnection.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.f63831e) {
                return;
            }
            IMConnection.this.internalConnect(false);
        }
    };
    public Runnable mSocketTimeoutRunnable = new Runnable() { // from class: com.baidu.android.imsdk.internal.IMConnection.3
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
    public HashMap<Long, Message> mSendMessageMap = new HashMap<>();
    public Map<Integer, Boolean> mSocketNeedCloseMap = new TreeMap();
    public AtomicInteger mConnectId = new AtomicInteger(0);
    public AtomicInteger mFailedNumber = new AtomicInteger(0);
    public AtomicBoolean mConnected = new AtomicBoolean(false);
    public AtomicBoolean mConnectting = new AtomicBoolean(false);
    public Handler mHandler = new MyHandler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public final class ConnectTask implements Runnable {
        public Integer mConnectTaskId;
        public String mIp;
        public boolean mIsInternalAction;
        public int mPort;

        public ConnectTask(boolean z, String str, int i2, Integer num) {
            this.mIsInternalAction = z;
            this.mIp = str;
            this.mPort = i2;
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
                    IMConnection iMConnection = IMConnection.this;
                    iMConnection.mConnectIps = this.mIp + ":" + this.mPort;
                    Context context = IMConnection.this.mContext;
                    Utility.writeLoginFlag(context, "14N", "socketConnect :" + IMConnection.this.mConnectIps);
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
                            IMConnection.this.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_OK, "connect ok");
                            IMConnection.this.mFailedNumber.set(0);
                            LogUtils.i(IMConnection.TAG, "ConnectTask run...create Socket ok, thread=" + Thread.currentThread().getName());
                            Utility.writeLoginFlag(IMConnection.this.mContext, "16Y", "connect ok");
                            IMSocketAddrProvider iMSocketAddrProvider = IMSocketAddrProvider.getInstance(IMConnection.this.mContext);
                            iMSocketAddrProvider.onSuccessSocketAddr(this.mIp + ":" + this.mPort);
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
            } catch (Exception e2) {
                LogUtils.e(IMConnection.TAG, "connectRunable", e2);
                IMConnection.this.mConnectting.set(false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class ConnectTimeOutTask implements Runnable {
        public Integer mConnectTaskId;
        public boolean mTaskStoped = false;

        public ConnectTimeOutTask(Integer num) {
            this.mConnectTaskId = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (IMConnection.this.mSocketNeedCloseMap) {
                if (this.mTaskStoped) {
                    return;
                }
                IMConnection.this.mSocketNeedCloseMap.put(this.mConnectTaskId, Boolean.TRUE);
                IMConnection.this.mConnectting.set(false);
                LogUtils.d(IMConnection.TAG, "ConnectTimeOutTask....will disconnectedByPeer");
                IMConnection.this.disconnectedByPeer();
                Context context = IMConnection.this.mContext;
                Utility.writeLoginFlag(context, "14N_1", "socketConnect_timeout :" + IMConnection.this.mConnectIps);
                IMConnection.this.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_TIMEOUT, "time out");
            }
        }

        public void setStoped() {
            this.mTaskStoped = true;
        }
    }

    /* loaded from: classes.dex */
    public class MyHandler extends Handler {
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

    /* loaded from: classes.dex */
    public class ReadThread extends Thread {
        public ReadThread() {
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
                        ConversationStudioManImpl.getInstance(IMConnection.this.mContext).setMcastQuickHeartBeat();
                    } catch (IOException e2) {
                        LogUtils.e(IMConnection.TAG, "ReadThread exception: " + e2, e2);
                        IMConnection.this.mStoped = false;
                        IMConnection.this.disconnectedByPeer();
                        return;
                    }
                } catch (Exception e3) {
                    LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
                    IMConnection.this.mStoped = false;
                    IMConnection.this.disconnectedByPeer();
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class SendThread extends Thread {
        public SendThread() {
            setName("IM-IMConnection-SendThread");
        }

        /* JADX WARN: Removed duplicated region for block: B:107:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:125:0x0000 A[SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Message message;
            while (!IMConnection.this.mClose) {
                try {
                    try {
                    } catch (InterruptedException e2) {
                        e = e2;
                        message = null;
                    }
                } catch (Exception e3) {
                    LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
                    IMConnection.this.disconnectedByPeer();
                    return;
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
                                        } catch (InterruptedException e4) {
                                            e = e4;
                                            LogUtils.e(IMConnection.TAG, "SendThread wait exception: " + e);
                                            IMConnection.this.mMessageHandler.handleMessage(message, null, false);
                                            IMConnection.this.disconnectedByPeer();
                                            if (message != null) {
                                            }
                                        }
                                    }
                                }
                                if (message != null) {
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
                                    } catch (Exception e5) {
                                        LogUtils.e(LogUtils.TAG, "SendThread:", e5);
                                        if (message.getType() == 50) {
                                            Utility.writeLoginFlag(IMConnection.this.mContext, "17N_1", "Send LoginMsg exception");
                                        }
                                        IMConnection.this.mMessageHandler.handleMessage(message, null, false);
                                        IMConnection.this.disconnectedByPeer();
                                        return;
                                    }
                                }
                            } else {
                                IMConnection.this.mMessageHandler.getMessageQueue().wait();
                                message = null;
                                if (message != null) {
                                }
                            }
                        } else {
                            if (IMConnection.this.mMessageHandler.getMessageQueue().size() > 0) {
                                message = IMConnection.this.mMessageHandler.getMessageQueue().getFirst();
                                if (message == null || message.isHeartbeat() || message.getType() == 50 || message.getUk() != 0) {
                                    message = IMConnection.this.mMessageHandler.getMessageQueue().removeFirst();
                                } else {
                                    IMConnection.this.mMessageHandler.getMessageQueue().wait();
                                }
                                if (message != null) {
                                }
                            }
                            message = null;
                            if (message != null) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        message = null;
                    }
                    LogUtils.e(LogUtils.TAG, "onStartCommand", e3);
                    IMConnection.this.disconnectedByPeer();
                    return;
                }
            }
        }
    }

    public IMConnection(Context context) {
        this.mContext = context.getApplicationContext();
        this.mMessageHandler = new MessageHandler(this.mContext);
    }

    public static /* synthetic */ long access$2108(IMConnection iMConnection) {
        long j = iMConnection.mNowId;
        iMConnection.mNowId = 1 + j;
        return j;
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
        } catch (IOException e2) {
            LogUtils.e(TAG, "destroy:" + e2.getMessage(), e2);
        }
    }

    private long computeDelayTime(int i2) {
        if (this.mDelayTimes < 0) {
            this.mDelayTimes = new Random().nextInt(30) % 31;
        }
        return ((long) ((Math.pow(2.0d, i2) * 0.3d) + this.mDelayTimes)) * 1000;
    }

    private void connectImpl(final boolean z) {
        if (a.f63831e) {
            return;
        }
        if (!this.mConnected.get() && !this.mConnectting.get()) {
            if (!AccountManager.isLogin(this.mContext)) {
                LogUtils.d(TAG, "Token is not set");
                return;
            }
            this.mConnectting.set(true);
            this.mHandler.removeCallbacks(this.mReconnectRunnable);
            Utility.writeLoginFlag(this.mContext, "10Y", "connect begin");
            LogUtils.i(TAG, "will get socket address .......");
            IMSocketAddrProvider.getInstance(this.mContext).getSocketAddr(new IMSocketAddrProvider.IGetSocketAddrListener() { // from class: com.baidu.android.imsdk.internal.IMConnection.1
                /* JADX WARN: Removed duplicated region for block: B:19:0x00b8  */
                /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
                @Override // com.baidu.android.imsdk.internal.IMSocketAddrProvider.IGetSocketAddrListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onGetSocketAddrResult(String str) {
                    int i2;
                    String str2;
                    String str3;
                    int i3;
                    boolean submitForNetWork;
                    int lastIndexOf;
                    LogUtils.i(IMConnection.TAG, "get socket address = " + str);
                    Context context = IMConnection.this.mContext;
                    Utility.writeLoginFlag(context, "14N_0", "socketConnect :" + str);
                    try {
                        lastIndexOf = str.lastIndexOf(":");
                        i2 = Integer.valueOf(str.substring(lastIndexOf + 1)).intValue();
                    } catch (Exception e2) {
                        e = e2;
                        i2 = -1;
                    }
                    try {
                        str2 = str.substring(0, lastIndexOf);
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        new IMTrack.CrashBuilder(IMConnection.this.mContext).exception(Log.getStackTraceString(e)).build();
                        str2 = null;
                        if (TextUtils.isEmpty(str2)) {
                        }
                        str3 = Constants.URL_SOCKET_SERVER;
                        i3 = Constants.SOCKET_PORT_SSL;
                        TaskManager taskManager = TaskManager.getInstance(IMConnection.this.mContext);
                        IMConnection iMConnection = IMConnection.this;
                        submitForNetWork = taskManager.submitForNetWork(new ConnectTask(z, str3, i3, Integer.valueOf(iMConnection.mConnectId.incrementAndGet())));
                        LogUtils.i(IMConnection.TAG, "ConnectTask add to ThreadPool = " + submitForNetWork);
                        if (submitForNetWork) {
                        }
                    }
                    if (!TextUtils.isEmpty(str2) || i2 == -1) {
                        str3 = Constants.URL_SOCKET_SERVER;
                        i3 = Constants.SOCKET_PORT_SSL;
                    } else {
                        str3 = str2;
                        i3 = i2;
                    }
                    TaskManager taskManager2 = TaskManager.getInstance(IMConnection.this.mContext);
                    IMConnection iMConnection2 = IMConnection.this;
                    submitForNetWork = taskManager2.submitForNetWork(new ConnectTask(z, str3, i3, Integer.valueOf(iMConnection2.mConnectId.incrementAndGet())));
                    LogUtils.i(IMConnection.TAG, "ConnectTask add to ThreadPool = " + submitForNetWork);
                    if (submitForNetWork) {
                        IMConnection.this.mConnectting.set(false);
                        TaskManager.getInstance(IMConnection.this.mContext).clearTask();
                        LogUtils.d(IMConnection.TAG, "getUrlAsync..will disconnectedByPeer..." + str);
                        IMConnection.this.disconnectedByPeer();
                    }
                }
            });
            return;
        }
        LogUtils.i(TAG, "Connect return. mConnected:" + this.mConnected.get() + " mConnectting:" + this.mConnectting.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectTrack(int i2, String str) {
        if (this.mConnectIps.contains(Constants.URL_SOCKET_SERVER) && !this.mMessageHandler.mSocketIp.isEmpty()) {
            this.mConnectIps = this.mMessageHandler.mSocketIp + ":" + Constants.URL_SOCKET_PORT;
        }
        this.mConnectIps += ":" + RequsetNetworkUtils.getNetInfo(this.mContext);
        int i3 = this.mFailedNumber.get();
        LogUtils.d(TAG, "connectTrack ext:" + this.mConnectIps + "， mFailedNumber ：" + i3 + "， reason ： " + str);
        long j = (long) i3;
        new IMTrack.ConnectionBuilder(this.mContext).startTime(this.mStartConnTime).stopTime(System.currentTimeMillis()).aliasId((long) i2).reason(str).ext(this.mConnectIps).retryCount(j).build();
        if (this.mFailedNumber.get() >= 5 && i2 != 401201) {
            IMTrackManager.uploadIMRealAction(this.mContext, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(this.mStartConnTime).setStopTime(System.currentTimeMillis()).setAliasId(401206L).setReason(str).setExt(this.mConnectIps).setRetryCount(j).build()).build());
        }
        this.mConnectIps = "";
    }

    private void destroy() {
        if (a.f63831e) {
            return;
        }
        LogUtils.i(TAG, "destroy");
        Utility.sendConnectionStateBroadCast(this.mContext, 2);
        this.mHandler.removeCallbacks(this.mSocketTimeoutRunnable);
        this.mClose = true;
        IMessageHandler iMessageHandler = this.mMessageHandler;
        if (iMessageHandler != null) {
            synchronized (iMessageHandler.getMessageQueue()) {
                this.mMessageHandler.getMessageQueue().notifyAll();
            }
            this.mMessageHandler.onSessionClosed();
            try {
                this.mMessageHandler.socketClose();
            } catch (Exception e2) {
                this.mMessageHandler.setCurrentSocketState(null);
                LogUtils.e(LogUtils.TAG, "Exception destroy:", e2);
            }
        }
        this.mConnected.set(false);
        this.mConnectting.set(false);
        BIMManager.connectStatusNotify(1);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initReadAndSendThread() {
        LogUtils.d(TAG, "initReadAndSendThread...thread=" + Thread.currentThread().getName());
        ReadThread readThread = this.mReadThread;
        if (readThread != null && readThread.isAlive()) {
            this.mReadThread.interrupt();
            LogUtils.d(TAG, "mReadThread interupt");
        }
        SendThread sendThread = this.mSendThread;
        if (sendThread == null || !sendThread.isAlive()) {
            return;
        }
        this.mSendThread.interrupt();
        LogUtils.d(TAG, "mSendThread interupt");
    }

    public void connect() {
        this.mFailedNumber.set(0);
        this.mStoped = false;
        connectImpl(false);
    }

    public void disconnectedByPeer() {
        if (a.f63831e) {
            return;
        }
        LogUtils.i(TAG, "disconnectedByPeer, mStoped == " + this.mStoped);
        fatalAllMessage();
        if (this.mStoped) {
            return;
        }
        destroy();
        this.mFailedNumber.incrementAndGet();
        if (this.mFailedNumber.get() >= 10 || IMUserLoginByTokenMsg.sRetrytimes >= 20) {
            return;
        }
        LogUtils.d(TAG, "now total create times....." + this.mFailedNumber.get());
        computeDelayTime(this.mFailedNumber.get() + IMUserLoginByTokenMsg.sRetrytimes);
        this.mHandler.postDelayed(this.mReconnectRunnable, 3000L);
        LogUtils.i(TAG, "Schedule retry-- retry times: " + this.mFailedNumber + " time delay: 3000");
    }

    public void internalConnect(boolean z) {
        if (z) {
            this.mFailedNumber.set(0);
        }
        this.mStoped = false;
        connectImpl(true);
    }

    public boolean isConnected() {
        return this.mConnected.get();
    }

    public void sendEmptyMessage() {
        synchronized (this.mMessageHandler.getMessageQueue()) {
            this.mMessageHandler.getMessageQueue().notifyAll();
            if (!this.mConnected.get() && !this.mConnectting.get()) {
                internalConnect(true);
            }
        }
    }

    public void sendHeartbeatMessage() {
        IMessageHandler iMessageHandler = this.mMessageHandler;
        if (iMessageHandler != null) {
            iMessageHandler.sendHeartbeatMessage();
        }
    }

    public void sendMessage(Message message, boolean z) {
        synchronized (this.mMessageHandler.getMessageQueue()) {
            if (message instanceof IMUserLoginByTokenMsg) {
                Utility.writeLoginFlag(this.mContext, "16Y_2", "send Logig msg");
                z = true;
            }
            if (message instanceof IMFetchConfigMsg) {
                z = true;
            }
            if (z) {
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

    public boolean shouldRetryLogin() {
        return !this.mStoped && this.mFailedNumber.get() < 10 && IMUserLoginByTokenMsg.sRetrytimes < 20;
    }

    public void stop() {
        LogUtils.i(TAG, "---stop---");
        this.mClose = true;
        this.mStoped = true;
        this.mHandler.removeCallbacks(this.mReconnectRunnable);
        destroy();
    }
}
