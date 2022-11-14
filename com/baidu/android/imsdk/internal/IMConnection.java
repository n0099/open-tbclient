package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.c80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class IMConnection {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mClose;
    public AtomicInteger mConnectId;
    public String mConnectIps;
    public AtomicBoolean mConnected;
    public AtomicBoolean mConnectting;
    public Context mContext;
    public int mDelayTimes;
    public AtomicInteger mFailedNumber;
    public Handler mHandler;
    public long mLastReadWriteTime;
    public IMessageHandler mMessageHandler;
    public long mNowId;
    public Object mOutputSync;
    public ReadThread mReadThread;
    public Runnable mReconnectRunnable;
    public HashMap<Long, Message> mSendMessageMap;
    public SendThread mSendThread;
    public Map<Integer, Boolean> mSocketNeedCloseMap;
    public Runnable mSocketTimeoutRunnable;
    public long mStartConnTime;
    public boolean mStoped;
    public Object mSync;

    /* loaded from: classes.dex */
    public final class ConnectTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer mConnectTaskId;
        public String mIp;
        public boolean mIsInternalAction;
        public int mPort;
        public final /* synthetic */ IMConnection this$0;

        public ConnectTask(IMConnection iMConnection, boolean z, String str, int i, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMConnection, Boolean.valueOf(z), str, Integer.valueOf(i), num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMConnection;
            this.mIsInternalAction = z;
            this.mIp = str;
            this.mPort = i;
            this.mConnectTaskId = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    LogUtils.d(IMConnection.TAG, "ConnectTask run...id=" + this.mConnectTaskId + ", thread=" + Thread.currentThread().getName());
                    LogUtils.d(IMConnection.TAG, "ConnectTask run...mConnected.get()=" + this.this$0.mConnected.get() + ", mIsInternalAction=" + this.mIsInternalAction + ", logined=" + LoginManager.getInstance(this.this$0.mContext).getCurrentState());
                    if (!this.this$0.mConnected.get() || !this.mIsInternalAction) {
                        this.this$0.initReadAndSendThread();
                        ConnectTimeOutTask connectTimeOutTask = new ConnectTimeOutTask(this.this$0, this.mConnectTaskId);
                        this.this$0.mHandler.postDelayed(connectTimeOutTask, 5000L);
                        this.this$0.mStartConnTime = System.currentTimeMillis();
                        IMConnection iMConnection = this.this$0;
                        iMConnection.mConnectIps = this.mIp + ":" + this.mPort;
                        Context context = this.this$0.mContext;
                        Utility.writeLoginFlag(context, "14N", "socketConnect :" + this.this$0.mConnectIps);
                        LogUtils.d(IMConnection.TAG, "ConnectTask run...socketConnect...thread=" + Thread.currentThread().getName());
                        SocketState socketConnect = this.this$0.mMessageHandler.socketConnect(this.mIp, this.mPort);
                        LogUtils.d(IMConnection.TAG, "ConnectTask run...state back...thread=" + Thread.currentThread().getName());
                        if (socketConnect != null && socketConnect.mSocketEnvOk.booleanValue()) {
                            synchronized (this.this$0.mSocketNeedCloseMap) {
                                LogUtils.d(IMConnection.TAG, "ConnectTask run...synchronized (mSocketNeedCloseMap)...thread=" + Thread.currentThread().getName());
                                this.this$0.mHandler.removeCallbacks(connectTimeOutTask);
                                connectTimeOutTask.setStoped();
                                if (this.this$0.mSocketNeedCloseMap.get(this.mConnectTaskId) == null) {
                                    LogUtils.d(IMConnection.TAG, "ConnectTask run...no timeout...thread=" + Thread.currentThread().getName());
                                    this.this$0.mMessageHandler.setCurrentSocketState(socketConnect);
                                } else {
                                    LogUtils.d(IMConnection.TAG, "ConnectTask run...timeout...thread=" + Thread.currentThread().getName());
                                    if (this.this$0.mConnected.get()) {
                                        LogUtils.d(IMConnection.TAG, "ConnectTask run...timeout...connected=true...thread=" + Thread.currentThread().getName());
                                        this.this$0.closeSocketState(socketConnect);
                                        if (this.mIsInternalAction) {
                                            this.this$0.mMessageHandler.onSessionOpened();
                                        }
                                        return;
                                    } else if (!socketConnect.mSocketCreateOk.booleanValue()) {
                                        LogUtils.d(IMConnection.TAG, "ConnectTask run...!state.mSocketCreateOk...thread=" + Thread.currentThread().getName());
                                        this.this$0.closeSocketState(socketConnect);
                                        return;
                                    } else {
                                        LogUtils.d(IMConnection.TAG, "ConnectTask run...state.mSocketCreateOk...thread=" + Thread.currentThread().getName());
                                        this.this$0.mMessageHandler.setCurrentSocketState(socketConnect);
                                    }
                                }
                                this.this$0.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_OK, "connect ok");
                                this.this$0.mFailedNumber.set(0);
                                LogUtils.i(IMConnection.TAG, "ConnectTask run...create Socket ok, thread=" + Thread.currentThread().getName());
                                Utility.writeLoginFlag(this.this$0.mContext, "16Y", "connect ok");
                                IMSocketAddrProvider iMSocketAddrProvider = IMSocketAddrProvider.getInstance(this.this$0.mContext);
                                iMSocketAddrProvider.onSuccessSocketAddr(this.mIp + ":" + this.mPort);
                                this.this$0.mConnected.set(true);
                                this.this$0.mClose = false;
                                this.this$0.mReadThread = new ReadThread(this.this$0);
                                this.this$0.mReadThread.start();
                                this.this$0.mSendThread = new SendThread(this.this$0);
                                this.this$0.mSendThread.start();
                                if (this.mIsInternalAction) {
                                    LogUtils.i(IMConnection.TAG, "ConnectTask run...onSessionOpened...thread=" + Thread.currentThread().getName());
                                    this.this$0.mMessageHandler.onSessionOpened();
                                }
                                LogUtils.d(IMConnection.TAG, "connectImpl time:" + SystemClock.currentThreadTimeMillis());
                                this.this$0.mConnectting.set(false);
                                return;
                            }
                        }
                        LogUtils.d(IMConnection.TAG, "ConnectTask run...（state == null || !state.mSocketEnvOk）...thread=" + Thread.currentThread().getName());
                        Utility.writeLoginFlag(this.this$0.mContext, "15N", "connect env error");
                        this.this$0.mHandler.removeCallbacks(connectTimeOutTask);
                        this.this$0.mConnectting.set(false);
                        LogUtils.d(IMConnection.TAG, "!state.mSocketEnvOk..will disconnectedByPeer...");
                        this.this$0.disconnectedByPeer();
                        this.this$0.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_ENV_FAIL, "env error");
                        return;
                    }
                    this.this$0.mMessageHandler.onSessionOpened();
                } catch (Exception e) {
                    LogUtils.e(IMConnection.TAG, "connectRunable", e);
                    this.this$0.mConnectting.set(false);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class ConnectTimeOutTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer mConnectTaskId;
        public boolean mTaskStoped;
        public final /* synthetic */ IMConnection this$0;

        public ConnectTimeOutTask(IMConnection iMConnection, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMConnection, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMConnection;
            this.mTaskStoped = false;
            this.mConnectTaskId = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0.mSocketNeedCloseMap) {
                    if (this.mTaskStoped) {
                        return;
                    }
                    this.this$0.mSocketNeedCloseMap.put(this.mConnectTaskId, Boolean.TRUE);
                    this.this$0.mConnectting.set(false);
                    LogUtils.d(IMConnection.TAG, "ConnectTimeOutTask....will disconnectedByPeer");
                    this.this$0.disconnectedByPeer();
                    Context context = this.this$0.mContext;
                    Utility.writeLoginFlag(context, "14N_1", "socketConnect_timeout :" + this.this$0.mConnectIps);
                    this.this$0.connectTrack(IMTrack.ConnectionBuilder.CONN_TYPE_SOCKET_CONNECTION_TIMEOUT, "time out");
                }
            }
        }

        public void setStoped() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mTaskStoped = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class MyHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMConnection this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyHandler(IMConnection iMConnection, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMConnection, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMConnection;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    long j = message.arg1;
                    synchronized (this.this$0.mSync) {
                        if (this.this$0.mSendMessageMap.containsKey(Long.valueOf(j))) {
                            LogUtils.d(IMConnection.TAG, "send msg timeout!!! " + ((Message) this.this$0.mSendMessageMap.get(Long.valueOf(j))).toString());
                            this.this$0.mMessageHandler.handleMessage((Message) this.this$0.mSendMessageMap.remove(Long.valueOf(j)), null, false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class ReadThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMConnection this$0;

        public ReadThread(IMConnection iMConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMConnection;
            setName("IM-IMConnection-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.this$0.mClose) {
                    try {
                        try {
                            Message readMessage = this.this$0.mMessageHandler.readMessage();
                            this.this$0.mHandler.removeCallbacks(this.this$0.mSocketTimeoutRunnable);
                            if (readMessage != null) {
                                readMessage.isSending(false);
                                LogUtils.d(IMConnection.TAG, "ReadThread receive msg :" + readMessage.toString());
                                if (!readMessage.isHeartbeat()) {
                                    synchronized (this.this$0.mSync) {
                                        LogUtils.d(IMConnection.TAG, "SOCKET_TIMEOUT read response...");
                                        this.this$0.mMessageHandler.handleMessage(readMessage, (Message) this.this$0.mSendMessageMap.remove(Long.valueOf(readMessage.getMsgId())), true);
                                    }
                                }
                                synchronized (this.this$0.mSync) {
                                    if (this.this$0.mSendMessageMap.size() != 0) {
                                        this.this$0.mLastReadWriteTime = System.currentTimeMillis();
                                        LogUtils.d(IMConnection.TAG, "SOCKET_TIMEOUT read ...");
                                        this.this$0.mHandler.postDelayed(this.this$0.mSocketTimeoutRunnable, 60000L);
                                    }
                                }
                            }
                            ConversationStudioManImpl.getInstance(this.this$0.mContext).setMcastQuickHeartBeat();
                        } catch (IOException e) {
                            LogUtils.e(IMConnection.TAG, "ReadThread exception: " + e, e);
                            this.this$0.mStoped = false;
                            this.this$0.disconnectedByPeer();
                            return;
                        }
                    } catch (Exception e2) {
                        LogUtils.e(LogUtils.TAG, "onStartCommand", e2);
                        this.this$0.mStoped = false;
                        this.this$0.disconnectedByPeer();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class SendThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMConnection this$0;

        public SendThread(IMConnection iMConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMConnection;
            setName("IM-IMConnection-SendThread");
        }

        /* JADX WARN: Removed duplicated region for block: B:110:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:130:0x0004 A[SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Message message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.this$0.mClose) {
                    try {
                        try {
                        } catch (InterruptedException e) {
                            e = e;
                            message = null;
                        }
                    } catch (Exception e2) {
                        LogUtils.e(LogUtils.TAG, "onStartCommand", e2);
                        this.this$0.disconnectedByPeer();
                        return;
                    }
                    synchronized (this.this$0.mMessageHandler.getMessageQueue()) {
                        try {
                            if (this.this$0.mMessageHandler.getMessageQueue().size() == 0) {
                                if (IMSDK.getInstance(this.this$0.mContext).getUk() > 0) {
                                    message = IMCmdQueueHelper.getFirstIdleCmdQueueMsg(this.this$0.mContext);
                                    if (message == null) {
                                        try {
                                            this.this$0.mMessageHandler.getMessageQueue().wait();
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                throw th;
                                                break;
                                            } catch (InterruptedException e3) {
                                                e = e3;
                                                LogUtils.e(IMConnection.TAG, "SendThread wait exception: " + e);
                                                this.this$0.mMessageHandler.handleMessage(message, null, false);
                                                this.this$0.disconnectedByPeer();
                                                if (message != null) {
                                                }
                                            }
                                        }
                                    }
                                    if (message != null) {
                                        try {
                                            if (this.this$0.mClose) {
                                                this.this$0.mMessageHandler.handleMessage(message, null, false);
                                                return;
                                            }
                                            if (message.getType() != 50 && message.getUk() <= 0) {
                                                if (IMSDK.getInstance(this.this$0.mContext).getUk() > 0) {
                                                    message.setUk(IMSDK.getInstance(this.this$0.mContext).getUk());
                                                } else {
                                                    this.this$0.mMessageHandler.handleMessage(message, null, false);
                                                    return;
                                                }
                                            }
                                            message.isSending(true);
                                            message.onMsgSending(this.this$0.mContext);
                                            message.setAppid(AccountManager.getAppid(this.this$0.mContext));
                                            message.setMsgId(IMConnection.access$2108(this.this$0));
                                            if (!message.isHeartbeat() && message.isNeedReplay()) {
                                                synchronized (this.this$0.mSync) {
                                                    if (this.this$0.mSendMessageMap.isEmpty()) {
                                                        this.this$0.mHandler.removeCallbacks(this.this$0.mSocketTimeoutRunnable);
                                                        this.this$0.mLastReadWriteTime = System.currentTimeMillis();
                                                        LogUtils.d(IMConnection.TAG, "SOCKET_TIMEOUT send ...");
                                                        this.this$0.mHandler.postDelayed(this.this$0.mSocketTimeoutRunnable, 60000L);
                                                    }
                                                }
                                            }
                                            LogUtils.d(IMConnection.TAG, "Send Msg:" + message.toString());
                                            if (message.getType() == 50) {
                                                Utility.writeLoginFlag(this.this$0.mContext, "17N", "Send LoginMsg request");
                                            }
                                            synchronized (this.this$0.mOutputSync) {
                                                this.this$0.mMessageHandler.socketWrite(message);
                                            }
                                            if (!message.isHeartbeat() && message.isNeedReplay()) {
                                                synchronized (this.this$0.mSync) {
                                                    this.this$0.mSendMessageMap.put(Long.valueOf(message.getMsgId()), message);
                                                }
                                            } else if (!message.isHeartbeat() && !message.isNeedReplay()) {
                                                message.handleMessageResult(this.this$0.mContext, null, 0, "sucess");
                                            }
                                        } catch (Exception e4) {
                                            LogUtils.e(LogUtils.TAG, "SendThread:", e4);
                                            if (message.getType() == 50) {
                                                Utility.writeLoginFlag(this.this$0.mContext, "17N_1", "Send LoginMsg exception");
                                            }
                                            this.this$0.mMessageHandler.handleMessage(message, null, false);
                                            this.this$0.disconnectedByPeer();
                                            return;
                                        }
                                    }
                                } else {
                                    this.this$0.mMessageHandler.getMessageQueue().wait();
                                    message = null;
                                    if (message != null) {
                                    }
                                }
                            } else {
                                if (this.this$0.mMessageHandler.getMessageQueue().size() > 0) {
                                    message = this.this$0.mMessageHandler.getMessageQueue().getFirst();
                                    if (message != null && !message.isHeartbeat() && message.getType() != 50 && message.getUk() == 0) {
                                        this.this$0.mMessageHandler.getMessageQueue().wait();
                                    } else {
                                        message = this.this$0.mMessageHandler.getMessageQueue().removeFirst();
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
                        LogUtils.e(LogUtils.TAG, "onStartCommand", e2);
                        this.this$0.disconnectedByPeer();
                        return;
                    }
                }
            }
        }
    }

    public IMConnection(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSync = new Object();
        this.mNowId = 0L;
        this.mLastReadWriteTime = 0L;
        this.mOutputSync = new Object();
        this.mClose = false;
        this.mStoped = false;
        this.mDelayTimes = -1;
        this.mConnectIps = "";
        this.mReconnectRunnable = new Runnable(this) { // from class: com.baidu.android.imsdk.internal.IMConnection.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IMConnection this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || c80.e) {
                    return;
                }
                this.this$0.internalConnect(false);
            }
        };
        this.mSocketTimeoutRunnable = new Runnable(this) { // from class: com.baidu.android.imsdk.internal.IMConnection.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IMConnection this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (System.currentTimeMillis() - this.this$0.mLastReadWriteTime > 60000) {
                        LogUtils.i(IMConnection.TAG, " SOCKET_TIMEOUT-- Socket heartbeat timeout !! --");
                        this.this$0.disconnectedByPeer();
                        return;
                    }
                    LogUtils.i(IMConnection.TAG, " SOCKET_TIMEOUT-- Socket heartbeat check ok !! --");
                }
            }
        };
        this.mContext = context.getApplicationContext();
        this.mSendMessageMap = new HashMap<>();
        this.mMessageHandler = new MessageHandler(this.mContext);
        this.mSocketNeedCloseMap = new TreeMap();
        this.mConnectId = new AtomicInteger(0);
        this.mFailedNumber = new AtomicInteger(0);
        this.mConnected = new AtomicBoolean(false);
        this.mConnectting = new AtomicBoolean(false);
        this.mHandler = new MyHandler(this, Looper.getMainLooper());
    }

    public static /* synthetic */ long access$2108(IMConnection iMConnection) {
        long j = iMConnection.mNowId;
        iMConnection.mNowId = 1 + j;
        return j;
    }

    public static IMConnection getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            if (mConnectionInstance == null) {
                synchronized (IMConnection.class) {
                    if (mConnectionInstance == null) {
                        mConnectionInstance = new IMConnection(context);
                    }
                }
            }
            return mConnectionInstance;
        }
        return (IMConnection) invokeL.objValue;
    }

    public void internalConnect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.mFailedNumber.set(0);
            }
            this.mStoped = false;
            connectImpl(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSocketState(SocketState socketState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, socketState) == null) {
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
    }

    private void connectImpl(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(65567, this, z) != null) || c80.e) {
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
            IMSocketAddrProvider.getInstance(this.mContext).getSocketAddr(new IMSocketAddrProvider.IGetSocketAddrListener(this, z) { // from class: com.baidu.android.imsdk.internal.IMConnection.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMConnection this$0;
                public final /* synthetic */ boolean val$isInternalAction;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isInternalAction = z;
                }

                /* JADX WARN: Removed duplicated region for block: B:21:0x00bc  */
                /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
                @Override // com.baidu.android.imsdk.internal.IMSocketAddrProvider.IGetSocketAddrListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onGetSocketAddrResult(String str) {
                    int i;
                    String str2;
                    String str3;
                    int i2;
                    boolean submitForNetWork;
                    int lastIndexOf;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        LogUtils.i(IMConnection.TAG, "get socket address = " + str);
                        Context context = this.this$0.mContext;
                        Utility.writeLoginFlag(context, "14N_0", "socketConnect :" + str);
                        try {
                            lastIndexOf = str.lastIndexOf(":");
                            i = Integer.valueOf(str.substring(lastIndexOf + 1)).intValue();
                        } catch (Exception e) {
                            e = e;
                            i = -1;
                        }
                        try {
                            str2 = str.substring(0, lastIndexOf);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e)).build();
                            str2 = null;
                            if (TextUtils.isEmpty(str2)) {
                            }
                            str3 = Constants.URL_SOCKET_SERVER;
                            i2 = 443;
                            TaskManager taskManager = TaskManager.getInstance(this.this$0.mContext);
                            IMConnection iMConnection = this.this$0;
                            submitForNetWork = taskManager.submitForNetWork(new ConnectTask(iMConnection, this.val$isInternalAction, str3, i2, Integer.valueOf(iMConnection.mConnectId.incrementAndGet())));
                            LogUtils.i(IMConnection.TAG, "ConnectTask add to ThreadPool = " + submitForNetWork);
                            if (submitForNetWork) {
                            }
                        }
                        if (TextUtils.isEmpty(str2) && i != -1) {
                            str3 = str2;
                            i2 = i;
                        } else {
                            str3 = Constants.URL_SOCKET_SERVER;
                            i2 = 443;
                        }
                        TaskManager taskManager2 = TaskManager.getInstance(this.this$0.mContext);
                        IMConnection iMConnection2 = this.this$0;
                        submitForNetWork = taskManager2.submitForNetWork(new ConnectTask(iMConnection2, this.val$isInternalAction, str3, i2, Integer.valueOf(iMConnection2.mConnectId.incrementAndGet())));
                        LogUtils.i(IMConnection.TAG, "ConnectTask add to ThreadPool = " + submitForNetWork);
                        if (submitForNetWork) {
                            this.this$0.mConnectting.set(false);
                            TaskManager.getInstance(this.this$0.mContext).clearTask();
                            LogUtils.d(IMConnection.TAG, "getUrlAsync..will disconnectedByPeer..." + str);
                            this.this$0.disconnectedByPeer();
                        }
                    }
                }
            });
            return;
        }
        LogUtils.i(TAG, "Connect return. mConnected:" + this.mConnected.get() + " mConnectting:" + this.mConnectting.get());
    }

    private long computeDelayTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, this, i)) == null) {
            if (this.mDelayTimes < 0) {
                this.mDelayTimes = new Random().nextInt(30) % 31;
            }
            return ((long) ((Math.pow(2.0d, i) * 0.3d) + this.mDelayTimes)) * 1000;
        }
        return invokeI.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectTrack(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65568, this, i, str) == null) {
            if (this.mConnectIps.contains(Constants.URL_SOCKET_SERVER) && !this.mMessageHandler.mSocketIp.isEmpty()) {
                this.mConnectIps = this.mMessageHandler.mSocketIp + ":" + Constants.URL_SOCKET_PORT;
            }
            this.mConnectIps += ":" + RequsetNetworkUtils.getNetInfo(this.mContext);
            int i2 = this.mFailedNumber.get();
            LogUtils.d(TAG, "connectTrack ext:" + this.mConnectIps + "， mFailedNumber ：" + i2 + "， reason ： " + str);
            long j = (long) i2;
            new IMTrack.ConnectionBuilder(this.mContext).startTime(this.mStartConnTime).stopTime(System.currentTimeMillis()).aliasId((long) i).reason(str).ext(this.mConnectIps).retryCount(j).build();
            if (this.mFailedNumber.get() >= 5 && i != 401201) {
                IMTrackManager.uploadIMRealAction(this.mContext, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(this.mStartConnTime).setStopTime(System.currentTimeMillis()).setAliasId(401206L).setReason(str).setExt(this.mConnectIps).setRetryCount(j).build()).build());
            }
            this.mConnectIps = "";
        }
    }

    private void destroy() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65569, this) != null) || c80.e) {
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
            } catch (Exception e) {
                this.mMessageHandler.setCurrentSocketState(null);
                LogUtils.e(LogUtils.TAG, "Exception destroy:", e);
            }
        }
        this.mConnected.set(false);
        this.mConnectting.set(false);
        BIMManager.connectStatusNotify(1);
    }

    private void fatalAllMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initReadAndSendThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            LogUtils.d(TAG, "initReadAndSendThread...thread=" + Thread.currentThread().getName());
            ReadThread readThread = this.mReadThread;
            if (readThread != null && readThread.isAlive()) {
                this.mReadThread.interrupt();
                LogUtils.d(TAG, "mReadThread interupt");
            }
            SendThread sendThread = this.mSendThread;
            if (sendThread != null && sendThread.isAlive()) {
                this.mSendThread.interrupt();
                LogUtils.d(TAG, "mSendThread interupt");
            }
        }
    }

    public void connect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mFailedNumber.set(0);
            this.mStoped = false;
            connectImpl(false);
        }
    }

    public boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mConnected.get();
        }
        return invokeV.booleanValue;
    }

    public void sendHeartbeatMessage() {
        IMessageHandler iMessageHandler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (iMessageHandler = this.mMessageHandler) != null) {
            iMessageHandler.sendHeartbeatMessage();
        }
    }

    public boolean shouldRetryLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.mStoped && this.mFailedNumber.get() < 10 && IMUserLoginByTokenMsg.sRetrytimes < 20) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            LogUtils.i(TAG, "---stop---");
            this.mClose = true;
            this.mStoped = true;
            this.mHandler.removeCallbacks(this.mReconnectRunnable);
            destroy();
        }
    }

    public void disconnectedByPeer() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || c80.e) {
            return;
        }
        LogUtils.i(TAG, "disconnectedByPeer, mStoped == " + this.mStoped);
        fatalAllMessage();
        if (this.mStoped) {
            return;
        }
        destroy();
        this.mFailedNumber.incrementAndGet();
        if (this.mFailedNumber.get() < 10 && IMUserLoginByTokenMsg.sRetrytimes < 20) {
            LogUtils.d(TAG, "now total create times....." + this.mFailedNumber.get());
            computeDelayTime(this.mFailedNumber.get() + IMUserLoginByTokenMsg.sRetrytimes);
            this.mHandler.postDelayed(this.mReconnectRunnable, 3000L);
            LogUtils.i(TAG, "Schedule retry-- retry times: " + this.mFailedNumber + " time delay: 3000");
        }
    }

    public void sendEmptyMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.mMessageHandler.getMessageQueue()) {
                this.mMessageHandler.getMessageQueue().notifyAll();
                if (!this.mConnected.get() && !this.mConnectting.get()) {
                    internalConnect(true);
                }
            }
        }
    }

    public void sendMessage(Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, message, z) == null) {
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
    }
}
