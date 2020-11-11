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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes18.dex */
public final class IMSDK {
    private static final String TAG = "IMSDK";
    public static Handler mHandler;
    private static IMSDK mIMSDK = null;
    private Context mContext;
    public Heartbeat mHeartbeatOperator;
    private Object mIsAlive_lock = new Object();
    private Object mConnLock = new Object();
    private Boolean mIsAlive = false;
    private IMConnection mConnection = null;
    private long mUk = 0;
    private ArrayList<IHeartBeat> mHeartBeatListener = new ArrayList<>();
    private Runnable mHeartbeatRunnable = new Runnable() { // from class: com.baidu.android.imsdk.internal.IMSDK.2
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = IMSDK.this.mHeartBeatListener.iterator();
            while (it.hasNext()) {
                ((IHeartBeat) it.next()).onHeartBeat();
            }
        }
    };
    private Runnable mConnectRunnable = new Runnable() { // from class: com.baidu.android.imsdk.internal.IMSDK.5
        @Override // java.lang.Runnable
        public void run() {
            synchronized (IMSDK.this.mConnLock) {
                if (IMSDK.this.mConnection != null) {
                    IMSDK.this.mConnection.internalConnect(false);
                }
            }
        }
    };
    private Runnable mStartRunnable = new Runnable() { // from class: com.baidu.android.imsdk.internal.IMSDK.6
        @Override // java.lang.Runnable
        public void run() {
            IMSDK.this.handleOnStart(new Intent());
        }
    };

    private IMSDK(Context context) {
        this.mContext = null;
        this.mHeartbeatOperator = null;
        this.mContext = context;
        mHandler = new Handler(Looper.getMainLooper());
        IMManagerImpl.getInstance(context);
        this.mHeartbeatOperator = Heartbeat.getInstance(this.mContext, mHandler);
    }

    public static IMSDK getInstance(Context context) {
        synchronized (IMSDK.class) {
            if (mIMSDK == null) {
                mIMSDK = new IMSDK(context);
            }
        }
        return mIMSDK;
    }

    public boolean init() {
        synchronized (this.mIsAlive_lock) {
            synchronized (this.mConnLock) {
                this.mConnection = IMConnection.getInstance(this.mContext);
            }
            mHandler.postDelayed(this.mStartRunnable, 500L);
            registerHeartbeatListener(new IHeartBeat() { // from class: com.baidu.android.imsdk.internal.IMSDK.1
                @Override // com.baidu.android.imsdk.internal.IHeartBeat
                public void onHeartBeat() {
                    if (Utility.isUploadIMTrack(IMSDK.this.mContext)) {
                        IMTrackManager.uploadIMActionData(IMSDK.this.mContext);
                    }
                }
            });
            this.mIsAlive = true;
        }
        return true;
    }

    public void registerHeartbeatListener(IHeartBeat iHeartBeat) {
        if (!this.mHeartBeatListener.contains(iHeartBeat)) {
            this.mHeartBeatListener.add(iHeartBeat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeartbeatListener() {
        this.mHeartBeatListener.clear();
    }

    private void notifyHeartbeatListener() {
        TaskManager.getInstance(this.mContext).submitForLocalOperation(this.mHeartbeatRunnable);
    }

    public void setAlarmTimeout() {
        this.mHeartbeatOperator.startHeartbeat();
    }

    public boolean handleOnStart(Intent intent) {
        int loginType;
        LogUtils.d(TAG, "handleOnStart intent action = " + (intent != null ? intent.getAction() : ""));
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
            } else if (intent.hasExtra(Constants.EXTRA_DISCONNECT)) {
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
                final Message createNewMessage = MessageFactory.getInstance().createNewMessage(this.mContext, intent.getIntExtra("method", -1), intent);
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
                        TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.internal.IMSDK.3
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    createNewMessage.handleMessageResult(IMSDK.this.mContext, null, 1001, Constants.ERROR_MSG_NETWORK_ERROR);
                                } catch (Exception e) {
                                    try {
                                        createNewMessage.handleMessageResult(IMSDK.this.mContext, null, 1010, Constants.ERROR_MSG_PARAMETER_ERROR);
                                    } catch (Exception e2) {
                                        LogUtils.e(IMSDK.TAG, "UnKown ERROR! " + createNewMessage.getBody());
                                        new IMTrack.CrashBuilder(IMSDK.this.mContext).exception(Log.getStackTraceString(e)).build();
                                    }
                                    new IMTrack.CrashBuilder(IMSDK.this.mContext).exception(Log.getStackTraceString(e)).build();
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

    public void destory(final boolean z, final String str) {
        LogUtils.d(TAG, "destory");
        try {
            TaskManager.getInstance(this.mContext).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.internal.IMSDK.4
                @Override // java.lang.Runnable
                public void run() {
                    if (IMSDK.mIMSDK != null) {
                        if (z) {
                            Utility.setInitiativeDisconnect(IMSDK.this.mContext, z);
                        }
                        IMSDK.mIMSDK.doStop();
                        IMSDK.this.clearHeartbeatListener();
                    }
                    IMSDK.this.notifyLogout(str);
                }
            });
        } catch (Exception e) {
            notifyLogout(str);
            LogUtils.e(TAG, "crash when destory");
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLogout(String str) {
        IMListener removeListener = ListenerManager.getInstance().removeListener(str);
        if (removeListener != null && (removeListener instanceof ILoginListener)) {
            ((ILoginListener) removeListener).onLogoutResult(0, "", BIMManager.getLoginType(this.mContext));
        }
    }

    private boolean heartbeat() {
        LogUtils.d(TAG, "heartbeat notifyHeartbeatListener");
        notifyHeartbeatListener();
        if (this.mConnection != null) {
            if (!this.mConnection.isConnected()) {
                scheduleConnect();
            } else {
                this.mConnection.sendHeartbeatMessage();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStop() {
        LogUtils.d(TAG, "stop");
        synchronized (this.mIsAlive_lock) {
            if (this.mConnection != null) {
                synchronized (this.mConnLock) {
                    this.mConnection.stop();
                }
            }
        }
    }

    private void scheduleConnect() {
        mHandler.removeCallbacks(this.mConnectRunnable);
        mHandler.postDelayed(this.mConnectRunnable, 1000L);
    }

    public long getUk() {
        if (this.mUk == 0) {
            this.mUk = Utility.getUK(this.mContext);
        }
        return this.mUk;
    }

    public void setUk(long j) {
        this.mUk = j;
    }
}
