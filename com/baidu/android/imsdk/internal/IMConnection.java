package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.chatmessage.request.IMFetchConfigMsg;
import com.baidu.android.imsdk.internal.IMUrlProvider;
import com.baidu.android.imsdk.mcast.McastManagerImpl;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public final class IMConnection {
    public static final int ERROR_LOGIN_FAIL = 7;
    private static final int MAX_RETRY_TIMES = 10;
    private static final int MSG_ID_SEND_MSG_TIMEOUT = 1;
    private static final double RECONNECTION_TIME_COEFFICIENT = 0.3d;
    private static final int RECONNECTION_TIME_INTERVAL = 30;
    private static final int SOCKET_CONNECTING_TIMOUT = 5000;
    private static final int SOCKET_TIMEOUT = 60000;
    private static final String TAG = "IMConnection";
    private Context mContext;
    IMessageHandler mMessageHandler;
    private ReadThread mReadThread;
    private HashMap<Long, Message> mSendMessageMap;
    private SendThread mSendThread;
    private long mStartConnTime;
    static boolean mLogined = false;
    private static volatile boolean mConnectting = false;
    private static IMConnection mConnection = null;
    private volatile boolean mConnected = false;
    private long mNowId = 0;
    private long mLastHearbeatTime = 0;
    private long mLastReadWriteTime = 0;
    private Object mOutputSync = new Object();
    private int mFailedNumber = 0;
    private boolean mClose = false;
    private boolean mStoped = false;
    Handler mHandler = new MyHandler(Looper.getMainLooper());
    private Object mSync = new Object();
    Map<Integer, Boolean> mSocketNeedCloseMap = new TreeMap();
    AtomicInteger mConnectId = new AtomicInteger(0);
    private int mDelayTimes = -1;
    private String mConnectIps = "";
    private Runnable mReconnectRunnable = new Runnable() { // from class: com.baidu.android.imsdk.internal.IMConnection.2
        @Override // java.lang.Runnable
        public void run() {
            IMConnection.this.internalConnect(false);
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

    static /* synthetic */ long access$1508(IMConnection iMConnection) {
        long j = iMConnection.mNowId;
        iMConnection.mNowId = 1 + j;
        return j;
    }

    private IMConnection(Context context) {
        this.mContext = null;
        this.mSendMessageMap = null;
        this.mContext = context;
        this.mSendMessageMap = new HashMap<>();
        this.mMessageHandler = new MessageHandler(this.mContext);
    }

    public static synchronized IMConnection getInstance(Context context) {
        IMConnection iMConnection;
        synchronized (IMConnection.class) {
            if (mConnection == null) {
                mConnection = new IMConnection(context.getApplicationContext());
            }
            iMConnection = mConnection;
        }
        return iMConnection;
    }

    /* loaded from: classes6.dex */
    class MyHandler extends Handler {
        public MyHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    long j = message.arg1;
                    synchronized (IMConnection.this.mSync) {
                        if (IMConnection.this.mSendMessageMap.containsKey(Long.valueOf(j))) {
                            LogUtils.d(IMConnection.TAG, "send msg timeout!!! " + ((Message) IMConnection.this.mSendMessageMap.get(Long.valueOf(j))).toString());
                            IMConnection.this.mMessageHandler.handleMessage((Message) IMConnection.this.mSendMessageMap.remove(Long.valueOf(j)), null, false);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void connect() {
        this.mFailedNumber = 0;
        this.mStoped = false;
        connectImpl(false);
    }

    public void internalConnect(boolean z) {
        if (z) {
            this.mFailedNumber = 0;
        }
        this.mStoped = false;
        connectImpl(true);
    }

    /* loaded from: classes6.dex */
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
                    boolean unused = IMConnection.mConnectting = false;
                    IMConnection.this.disconnectedByPeer();
                    IMConnection.this.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_TIMEOUT, "time out");
                }
            }
        }
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    public Context getContext() {
        return this.mContext;
    }

    private synchronized void connectImpl(final boolean z) {
        if (this.mConnected || mConnectting) {
            LogUtils.i(TAG, "Connect return. mConnected:" + this.mConnected + " mConnectting:" + mConnectting);
        } else if (!AccountManager.isLogin(this.mContext)) {
            LogUtils.d(TAG, "Token is not set");
        } else {
            mConnectting = true;
            this.mHandler.removeCallbacks(this.mReconnectRunnable);
            LogUtils.i(TAG, "do connecting with domain=" + Constants.URL_SOCKET_SERVER + ", port=" + Constants.URL_SOCKET_PORT);
            IMUrlProvider.getProvide(this.mContext).getUrlAsync(new IMUrlProvider.IGetUrlAsyncListener() { // from class: com.baidu.android.imsdk.internal.IMConnection.1
                @Override // com.baidu.android.imsdk.internal.IMUrlProvider.IGetUrlAsyncListener
                public void onGetUrlAsncResult(int i, String str, String str2) {
                    LogUtils.d(IMConnection.TAG, "-----try to connect ip:" + str2);
                    TaskManager.getInstance(IMConnection.this.mContext).submitForNetWork(new ConnectTask(z, str2, Integer.valueOf(IMConnection.this.mConnectId.incrementAndGet())));
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    final class ConnectTask implements Runnable {
        Integer mConnectTaskId;
        String mIp;
        boolean mIsInternalAction;

        public ConnectTask(boolean z, String str, Integer num) {
            this.mIsInternalAction = false;
            this.mIp = null;
            this.mConnectTaskId = null;
            this.mIsInternalAction = z;
            this.mIp = str;
            this.mConnectTaskId = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (IMConnection.this.mReadThread != null && IMConnection.this.mReadThread.isAlive()) {
                    IMConnection.this.mReadThread.interrupt();
                    LogUtils.d(IMConnection.TAG, "mReadThread interupt");
                }
                if (IMConnection.this.mSendThread != null && IMConnection.this.mSendThread.isAlive()) {
                    IMConnection.this.mSendThread.interrupt();
                    LogUtils.d(IMConnection.TAG, "mSendThread interupt");
                }
                ConnectTimeOutTask connectTimeOutTask = new ConnectTimeOutTask(this.mConnectTaskId);
                IMConnection.this.mHandler.postDelayed(connectTimeOutTask, 5000L);
                IMConnection.this.mStartConnTime = System.currentTimeMillis();
                IMConnection.this.mConnectIps = this.mIp + ":" + Constants.URL_SOCKET_PORT;
                SocketState socketConnect = IMConnection.this.mMessageHandler.socketConnect(this.mIp, Constants.URL_SOCKET_PORT);
                if (!socketConnect.mSocketEnvOk.booleanValue()) {
                    IMConnection.this.mHandler.removeCallbacks(connectTimeOutTask);
                    IMConnection.this.stop();
                    IMConnection.this.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_ENV_FAIL, "env error");
                    return;
                }
                synchronized (IMConnection.this.mSocketNeedCloseMap) {
                    IMConnection.this.mHandler.removeCallbacks(connectTimeOutTask);
                    connectTimeOutTask.setStoped();
                    if (IMConnection.this.mSocketNeedCloseMap.get(this.mConnectTaskId) == null) {
                        IMConnection.this.mMessageHandler.setCurrentSocketState(socketConnect);
                        IMConnection.this.mFailedNumber = 0;
                        IMConnection.this.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_OK, "connect ok");
                        LogUtils.i(IMConnection.TAG, "create Socket ok");
                        IMUrlProvider.onConnectSucess(IMConnection.this.mContext, this.mIp);
                        IMConnection.this.mConnected = true;
                        IMConnection.this.mClose = false;
                        IMConnection.this.mReadThread = new ReadThread();
                        IMConnection.this.mReadThread.start();
                        IMConnection.this.mSendThread = new SendThread();
                        IMConnection.this.mSendThread.start();
                        if (this.mIsInternalAction) {
                            IMConnection.this.mMessageHandler.onSessionOpened();
                        }
                        LogUtils.d(IMConnection.TAG, "connectImpl time:" + SystemClock.currentThreadTimeMillis());
                        boolean unused = IMConnection.mConnectting = false;
                        return;
                    }
                    IMConnection.this.mHandler.removeCallbacks(connectTimeOutTask);
                    if (socketConnect.mSocketCreateOk.booleanValue()) {
                        try {
                            if (socketConnect.mSocket != null) {
                                socketConnect.mSocket.close();
                                socketConnect.mSocket = null;
                            }
                            if (socketConnect.mInputStream != null) {
                                socketConnect.mInputStream.close();
                                socketConnect.mInputStream = null;
                            }
                            if (socketConnect.mOutputStream != null) {
                                socketConnect.mOutputStream.close();
                                socketConnect.mOutputStream = null;
                            }
                        } catch (IOException e) {
                            LogUtils.e(IMConnection.TAG, "destroy:" + e.getMessage(), e);
                        }
                    }
                }
            } catch (Exception e2) {
                LogUtils.e(IMConnection.TAG, "connectRunable", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectTrack(int i, String str) {
        if (this.mConnectIps.contains(Constants.URL_SOCKET_SERVER) && !this.mMessageHandler.mSocketIp.isEmpty()) {
            this.mConnectIps = this.mMessageHandler.mSocketIp + ":" + Constants.URL_SOCKET_PORT;
        }
        this.mConnectIps += ":" + IMUrlProvider.getCurrentPolicy() + ":" + RequsetNetworkUtils.getNetInfo(this.mContext);
        LogUtils.d(TAG, "connectTrack ext:" + this.mConnectIps);
        new IMTrack.ConnectionBuilder(this.mContext).startTime(this.mStartConnTime).stopTime(System.currentTimeMillis()).aliasId(i).reason(str).ext(this.mConnectIps).retryCount(this.mFailedNumber).build();
        this.mConnectIps = "";
    }

    public void stop() {
        LogUtils.i(TAG, "---stop---");
        this.mClose = true;
        this.mStoped = true;
        this.mHandler.removeCallbacks(this.mReconnectRunnable);
        IMUrlProvider.refresh(this.mContext, null, false);
        destroy();
    }

    public void sendMessage(Message message, boolean z) {
        synchronized (this.mMessageHandler.getMessageQueue()) {
            if (message instanceof IMFetchConfigMsg ? true : message instanceof IMUserLoginByTokenMsg ? true : z) {
                this.mMessageHandler.getMessageQueue().addFirst(message);
            } else {
                this.mMessageHandler.getMessageQueue().add(message);
            }
            this.mMessageHandler.getMessageQueue().notifyAll();
            if (!this.mConnected && !mConnectting) {
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
            if (!this.mConnected && !mConnectting) {
                internalConnect(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    class ReadThread extends Thread {
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

    /* loaded from: classes6.dex */
    class SendThread extends Thread {
        SendThread() {
            setName("IM-IMConnection-SendThread");
        }

        SendThread(OutputStream outputStream) {
            setName("IM-IMConnection-SendThread");
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:121:0x0003 A[SYNTHETIC] */
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
                                    message.isSending(true);
                                    message.onMsgSending(IMConnection.this.mContext);
                                    message.setUk(IMSDK.getInstance(IMConnection.this.mContext).getUk());
                                    message.setAppid(AccountManager.getAppid(IMConnection.this.mContext));
                                    message.setMsgId(IMConnection.access$1508(IMConnection.this));
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
        return !this.mStoped && this.mFailedNumber < 10 && IMUserLoginByTokenMsg.sRetrytimes < 7;
    }

    public void disconnectedByPeer() {
        LogUtils.i(TAG, "disconnectedByPeer, mStoped == " + this.mStoped);
        connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_STOP, "connect stop");
        fatalAllMessage();
        if (!this.mStoped) {
            destroy();
            this.mFailedNumber++;
            if (this.mFailedNumber < 10 && IMUserLoginByTokenMsg.sRetrytimes < 7) {
                long computeDelayTime = computeDelayTime(this.mFailedNumber + IMUserLoginByTokenMsg.sRetrytimes);
                this.mHandler.postDelayed(this.mReconnectRunnable, computeDelayTime);
                LogUtils.i(TAG, "Schedule retry-- retry times: " + this.mFailedNumber + " time delay: " + computeDelayTime);
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
                LogUtils.e(LogUtils.TAG, "Exception destroy:", e);
            }
        }
        this.mConnected = false;
        AccountManagerImpl.getInstance(this.mContext).connectStatusNotify(1);
    }

    public void sendHeartbeatMessage() {
        if (this.mMessageHandler != null) {
            this.mMessageHandler.sendHeartbeatMessage();
        }
    }
}
