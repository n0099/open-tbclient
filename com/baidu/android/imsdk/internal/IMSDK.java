package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.chatmessage.request.IMSendMsg;
import com.baidu.android.imsdk.chatuser.IGetUserStatusListener;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.upload.action.IMTrackManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class IMSDK {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMSDK";
    public static Handler mHandler;
    public static IMSDK mIMSDK;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mConnLock;
    public Runnable mConnectRunnable;
    public IMConnection mConnection;
    public Context mContext;
    public ArrayList<IHeartBeat> mHeartBeatListener;
    public Heartbeat mHeartbeatOperator;
    public Runnable mHeartbeatRunnable;
    public Boolean mIsAlive;
    public Object mIsAlive_lock;
    public Runnable mStartRunnable;
    public long mUk;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-723550544, "Lcom/baidu/android/imsdk/internal/IMSDK;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-723550544, "Lcom/baidu/android/imsdk/internal/IMSDK;");
        }
    }

    public IMSDK(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mIsAlive_lock = new Object();
        this.mConnLock = new Object();
        this.mIsAlive = Boolean.FALSE;
        this.mConnection = null;
        this.mUk = 0L;
        this.mHeartbeatOperator = null;
        this.mHeartBeatListener = new ArrayList<>();
        this.mHeartbeatRunnable = new Runnable(this) { // from class: com.baidu.android.imsdk.internal.IMSDK.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IMSDK this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    Iterator it = this.this$0.mHeartBeatListener.iterator();
                    while (it.hasNext()) {
                        ((IHeartBeat) it.next()).onHeartBeat();
                    }
                }
            }
        };
        this.mConnectRunnable = new Runnable(this) { // from class: com.baidu.android.imsdk.internal.IMSDK.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IMSDK this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    synchronized (this.this$0.mConnLock) {
                        if (this.this$0.mConnection != null) {
                            this.this$0.mConnection.internalConnect(false);
                        }
                    }
                }
            }
        };
        this.mStartRunnable = new Runnable(this) { // from class: com.baidu.android.imsdk.internal.IMSDK.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IMSDK this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    this.this$0.handleOnStart(new Intent());
                }
            }
        };
        this.mContext = context;
        mHandler = new Handler(Looper.getMainLooper());
        IMManagerImpl.getInstance(context);
        this.mHeartbeatOperator = Heartbeat.getInstance(this.mContext, mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeartbeatListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.mHeartBeatListener.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            LogUtils.d(TAG, IntentConfig.STOP);
            synchronized (this.mIsAlive_lock) {
                if (this.mConnection != null) {
                    synchronized (this.mConnLock) {
                        this.mConnection.stop();
                    }
                }
            }
        }
    }

    public static IMSDK getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            synchronized (IMSDK.class) {
                if (mIMSDK == null) {
                    mIMSDK = new IMSDK(context);
                }
            }
            return mIMSDK;
        }
        return (IMSDK) invokeL.objValue;
    }

    private boolean heartbeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            LogUtils.d(TAG, "heartbeat notifyHeartbeatListener");
            notifyHeartbeatListener();
            IMConnection iMConnection = this.mConnection;
            if (iMConnection != null) {
                if (!iMConnection.isConnected()) {
                    scheduleConnect();
                    return true;
                }
                this.mConnection.sendHeartbeatMessage();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void notifyHeartbeatListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(this.mHeartbeatRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLogout(String str) {
        IMListener removeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, this, str) == null) && (removeListener = ListenerManager.getInstance().removeListener(str)) != null && (removeListener instanceof ILoginListener)) {
            ((ILoginListener) removeListener).onLogoutResult(0, "", BIMManager.getLoginType(this.mContext));
        }
    }

    private void scheduleConnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            mHandler.removeCallbacks(this.mConnectRunnable);
            mHandler.postDelayed(this.mConnectRunnable, 1000L);
        }
    }

    public void destory(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
            LogUtils.d(TAG, "destory");
            try {
                TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable(this, z, str) { // from class: com.baidu.android.imsdk.internal.IMSDK.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IMSDK this$0;
                    public final /* synthetic */ boolean val$isinitiative;
                    public final /* synthetic */ String val$listenerKey;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z), str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$isinitiative = z;
                        this.val$listenerKey = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (IMSDK.mIMSDK != null) {
                                if (this.val$isinitiative) {
                                    Utility.setInitiativeDisconnect(this.this$0.mContext, this.val$isinitiative);
                                }
                                IMSDK.mIMSDK.doStop();
                                this.this$0.clearHeartbeatListener();
                            }
                            this.this$0.notifyLogout(this.val$listenerKey);
                        }
                    }
                });
            } catch (Exception e2) {
                notifyLogout(str);
                LogUtils.e(TAG, "crash when destory");
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    public long getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mUk == 0) {
                this.mUk = Utility.getUK(this.mContext);
            }
            return this.mUk;
        }
        return invokeV.longValue;
    }

    public boolean handleOnStart(Intent intent) {
        InterceptResult invokeL;
        int loginType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleOnStart intent action = ");
            sb.append(intent != null ? intent.getAction() : "");
            LogUtils.d(TAG, sb.toString());
            if (intent == null) {
                intent = new Intent();
                LogUtils.i(TAG, "--- handleOnStart by null intent!");
            }
            synchronized (this.mIsAlive_lock) {
                if (!this.mIsAlive.booleanValue()) {
                    if (intent.hasExtra(Constants.EXTRA_LISTENER_ID) && ((intent.hasExtra("method") && intent.getIntExtra("method", -1) == 52) || intent.getIntExtra("method", -1) == 21 || intent.hasExtra(Constants.EXTRA_DISCONNECT))) {
                        IMListener removeListener = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                        loginType = this.mContext != null ? BIMManager.getLoginType(this.mContext) : -1;
                        if (removeListener != null) {
                            if (removeListener instanceof ILoginListener) {
                                ((ILoginListener) removeListener).onLogoutResult(6, "IMSDK not alive", loginType);
                            } else if (removeListener instanceof IGetUserStatusListener) {
                                ((IGetUserStatusListener) removeListener).onGetUsersStatusResult(1001, Constants.ERROR_MSG_NETWORK_ERROR, null);
                            }
                        }
                    } else if (intent != null && intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                        ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                    }
                    return false;
                }
                mHandler.removeCallbacks(this.mStartRunnable);
                LogUtils.i(TAG, "-- handleOnStart -- " + intent.getAction());
                Utility.setInitiativeDisconnect(this.mContext, false);
                if (Constants.ACTION_STOP.equals(intent.getAction())) {
                    this.mHeartbeatOperator.cancelHearbeat();
                    return false;
                } else if (Constants.ACTION_START.equals(intent.getAction())) {
                    this.mConnection.internalConnect(true);
                    return true;
                } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                    return heartbeat();
                } else {
                    if (intent.hasExtra(Constants.EXTRA_DISCONNECT)) {
                        this.mHeartbeatOperator.cancelHearbeat();
                        destory(true, intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                        return true;
                    } else if (intent.hasExtra(Constants.EXTRA_CANCEL_ALARM)) {
                        this.mHeartbeatOperator.cancelHearbeat();
                        return true;
                    } else if (intent.hasExtra("method")) {
                        if (this.mConnection == null) {
                            LogUtils.e(TAG, "mConnection is null");
                            if (intent.getIntExtra("method", -1) == 52 && intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                                IMListener removeListener2 = ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                                loginType = this.mContext != null ? BIMManager.getLoginType(this.mContext) : -1;
                                if (removeListener2 != null && (removeListener2 instanceof ILoginListener)) {
                                    ((ILoginListener) removeListener2).onLogoutResult(6, "IMSDK mConnection is null", loginType);
                                }
                            } else if (intent != null && intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                                ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                            }
                            return false;
                        }
                        Message createNewMessage = MessageFactory.getInstance().createNewMessage(this.mContext, intent.getIntExtra("method", -1), intent);
                        if (createNewMessage != null) {
                            LogUtils.d(TAG, "msg is not null, msg=" + createNewMessage.getClass().getName());
                            if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                                createNewMessage.setListenerKey(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                            }
                            boolean z = !(createNewMessage instanceof IMSendMsg) || LoginManager.getInstance(this.mContext).getCurrentState().equals(LoginManager.LoginState.LOGINED);
                            boolean isNetworkAvailable = RequsetNetworkUtils.isNetworkAvailable(this.mContext);
                            if (isNetworkAvailable) {
                                if (z) {
                                    this.mConnection.sendMessage(createNewMessage, false);
                                } else {
                                    String token = AccountManager.getToken(this.mContext);
                                    LogUtils.d(TAG, "Send handShake Message token is: " + token);
                                    if (!TextUtils.isEmpty(token) && LoginManager.getInstance(this.mContext).loginInternal(null)) {
                                        this.mConnection.sendMessage(new IMUserLoginByTokenMsg(this.mContext, token, true, AccountManagerImpl.getInstance(this.mContext).getFrom(), AccountManagerImpl.getInstance(this.mContext).getcFrom()), true);
                                        LogUtils.d(TAG, "Logining");
                                    }
                                }
                            }
                            if (!isNetworkAvailable || !z) {
                                TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, createNewMessage) { // from class: com.baidu.android.imsdk.internal.IMSDK.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ IMSDK this$0;
                                    public final /* synthetic */ Message val$fMessage;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, createNewMessage};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.val$fMessage = createNewMessage;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            try {
                                                this.val$fMessage.handleMessageResult(this.this$0.mContext, null, 1001, Constants.ERROR_MSG_NETWORK_ERROR);
                                            } catch (Exception e2) {
                                                try {
                                                    this.val$fMessage.handleMessageResult(this.this$0.mContext, null, 1010, Constants.ERROR_MSG_PARAMETER_ERROR);
                                                } catch (Exception unused) {
                                                    LogUtils.e(IMSDK.TAG, "UnKown ERROR! " + this.val$fMessage.getBody());
                                                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                                                }
                                                new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                                            }
                                        }
                                    }
                                });
                            }
                        } else if (intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                            ListenerManager.getInstance().removeListener(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                        }
                        return true;
                    } else {
                        return true;
                    }
                }
            }
        }
        return invokeL.booleanValue;
    }

    public boolean init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.mIsAlive_lock) {
                synchronized (this.mConnLock) {
                    this.mConnection = IMConnection.getInstance(this.mContext);
                }
                mHandler.postDelayed(this.mStartRunnable, 500L);
                registerHeartbeatListener(new IHeartBeat(this) { // from class: com.baidu.android.imsdk.internal.IMSDK.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IMSDK this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.android.imsdk.internal.IHeartBeat
                    public void onHeartBeat() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && Utility.isUploadIMTrack(this.this$0.mContext)) {
                            IMTrackManager.uploadIMActionData(this.this$0.mContext);
                        }
                    }
                });
                this.mIsAlive = Boolean.TRUE;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void registerHeartbeatListener(IHeartBeat iHeartBeat) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iHeartBeat) == null) || this.mHeartBeatListener.contains(iHeartBeat)) {
            return;
        }
        this.mHeartBeatListener.add(iHeartBeat);
    }

    public void setAlarmTimeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mHeartbeatOperator.startHeartbeat();
        }
    }

    public void setUk(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.mUk = j2;
        }
    }
}
