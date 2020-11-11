package com.baidu.android.imsdk.account;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.recorder.MovieRecorder;
import com.baidu.imsdk.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes18.dex */
public class LoginManager {
    private static Context mContext;
    private static LoginManager mInstance = null;
    private ArrayList<ILoginListener> mLoginListeners;
    private String TAG = LoginManager.class.getSimpleName();
    LoginState mLoginState = LoginState.NOT_LOGIN;
    private int cidTryLoginedTimes = 1;
    private Runnable imLoginRunable = new Runnable() { // from class: com.baidu.android.imsdk.account.LoginManager.1
        @Override // java.lang.Runnable
        public void run() {
            LoginManager.this.imLogin(false);
        }
    };

    /* loaded from: classes18.dex */
    public enum LoginState {
        NOT_LOGIN,
        LOGINING,
        LOGINED
    }

    private LoginManager(Context context) {
        this.mLoginListeners = null;
        mContext = context.getApplicationContext();
        this.mLoginListeners = new ArrayList<>();
    }

    public static LoginManager getInstance(Context context) {
        synchronized (LoginManager.class) {
            if (mInstance == null) {
                mInstance = new LoginManager(context);
            }
        }
        return mInstance;
    }

    public synchronized boolean loginInternal(ILoginListener iLoginListener) {
        boolean z = false;
        synchronized (this) {
            printCurrentState();
            if (iLoginListener != null) {
                addListener(iLoginListener);
            }
            if (!this.mLoginState.equals(LoginState.LOGINING)) {
                if (this.mLoginState.equals(LoginState.LOGINED)) {
                    printCurrentState();
                    triggleLoginListenerCallBack(0, Constants.ERROR_MSG_SUCCESS);
                } else {
                    this.mLoginState = LoginState.LOGINING;
                    printCurrentState();
                    z = true;
                }
            }
        }
        return z;
    }

    private void printCurrentState() {
        LogUtils.d(this.TAG, getStateString());
    }

    private String getStateString() {
        if (this.mLoginState.equals(LoginState.LOGINING)) {
            return "logining";
        }
        if (this.mLoginState.equals(LoginState.LOGINED)) {
            return "logged";
        }
        return "not_login";
    }

    public synchronized void onLoginResultInternal(int i, String str) {
        LogUtils.d(this.TAG, "HB> onLoginResultInternal, responseCode = " + i + ", errMsg = " + str);
        if (i == 0) {
            this.mLoginState = LoginState.LOGINED;
            this.cidTryLoginedTimes = 1;
        } else if (i == 23 && AccountManagerImpl.getInstance(mContext).getLoginType() == 6 && this.cidTryLoginedTimes > 0) {
            BIMManager.login(null, AccountManagerImpl.getInstance(mContext).getCuid(), 6, AccountManagerImpl.getInstance(mContext).getFrom(), AccountManagerImpl.getInstance(mContext).getcFrom(), removeLoginListener());
            this.cidTryLoginedTimes--;
            this.mLoginState = LoginState.NOT_LOGIN;
        } else if (110 != i && 7 != i && 23 != i && 1004 != i && 1001 != i && 8010 != i) {
            LogUtils.d(this.TAG, "error :" + i + ", and retry ：" + IMUserLoginByTokenMsg.sRetrytimes + "， isLcp :" + a.azB);
            this.mLoginState = LoginState.NOT_LOGIN;
            if (a.azB && IMUserLoginByTokenMsg.sRetrytimes < 3) {
                imRetryLogin(i);
            } else if (!a.azB && IMConnection.getInstance(mContext).shouldRetryLogin()) {
                LogUtils.d(this.TAG, "IMConnection，im login ：" + IMUserLoginByTokenMsg.sRetrytimes);
                IMConnection.getInstance(mContext).disconnectedByPeer();
            }
        } else {
            this.mLoginState = LoginState.NOT_LOGIN;
        }
        printCurrentState();
        triggleLoginListenerCallBack(i, str);
    }

    public void imRetryLogin(int i) {
        switch (i) {
            case 4001:
                imLogin(false);
                return;
            case MovieRecorder.ERROR_CODE_ON_STOP /* 4002 */:
            default:
                imLogin(false);
                return;
            case ResponseCode.ERROR_LOGIN_INVALID_REQUEST /* 4003 */:
            case ResponseCode.ERROR_LOGIN_LOGIN_FAILED /* 4004 */:
            case ResponseCode.ERROR_LOGIN_CALL_BACKEND_FAILED /* 4005 */:
                imLogin(true);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imLogin(boolean z) {
        int loginType = AccountManagerImpl.getInstance(mContext).getLoginType();
        LogUtils.d(this.TAG, "lcp，im login ：" + IMUserLoginByTokenMsg.sRetrytimes + ", loginType :" + loginType);
        if (!z) {
            if (loginType == 1) {
                BIMManager.login(Utility.readUid(mContext), AccountManagerImpl.getInstance(mContext).getToken(), loginType, AccountManagerImpl.getInstance(mContext).getFrom(), AccountManagerImpl.getInstance(mContext).getcFrom(), removeLoginListener());
            } else if (loginType == 6) {
                BIMManager.login(null, AccountManagerImpl.getInstance(mContext).getCuid(), loginType, AccountManagerImpl.getInstance(mContext).getFrom(), AccountManagerImpl.getInstance(mContext).getcFrom(), removeLoginListener());
            }
        } else if (a.mHandler != null) {
            a.mHandler.removeCallbacks(this.imLoginRunable);
            a.mHandler.postDelayed(this.imLoginRunable, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public synchronized void onLogoutResultInternal(int i, String str) {
        if (i == 0) {
            this.mLoginState = LoginState.NOT_LOGIN;
        }
        printCurrentState();
        if (this.mLoginListeners != null && this.mLoginListeners.size() != 0) {
            this.mLoginListeners.clear();
        }
    }

    public synchronized LoginState getCurrentState() {
        return this.mLoginState;
    }

    public boolean isIMLogined() {
        return this.mLoginState == LoginState.LOGINED;
    }

    public synchronized void setCurrentState(LoginState loginState) {
        this.mLoginState = loginState;
    }

    public synchronized void addListener(ILoginListener iLoginListener) {
        if (!this.mLoginListeners.contains(iLoginListener)) {
            this.mLoginListeners.add(iLoginListener);
        }
    }

    public synchronized ILoginListener removeLoginListener() {
        return this.mLoginListeners.isEmpty() ? null : this.mLoginListeners.remove(0);
    }

    public synchronized ArrayList<ILoginListener> getLoginListener() {
        return this.mLoginListeners;
    }

    public synchronized void logoutInternal(ILoginListener iLoginListener) {
        this.mLoginState = LoginState.NOT_LOGIN;
        printCurrentState();
    }

    private void triggleLoginListenerCallBack(int i, String str) {
        if (this.mLoginListeners != null && this.mLoginListeners.size() != 0) {
            Iterator<ILoginListener> it = this.mLoginListeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onLoginResult(i, str);
                } catch (Error e) {
                    new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                }
            }
        }
    }

    public synchronized void triggleLogoutListener(int i, String str) {
        if (this.mLoginListeners != null && this.mLoginListeners.size() != 0) {
            this.mLoginState = LoginState.NOT_LOGIN;
            printCurrentState();
            LogUtils.d(this.TAG, "triggleLogoutListener logout :" + this.mLoginListeners.size());
            if (4001 == i) {
                imLogin(false);
            } else if (4005 == i || 4003 == i || 4004 == i) {
                imLogin(true);
            } else {
                Iterator<ILoginListener> it = this.mLoginListeners.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLogoutResult(i, str, AccountManagerImpl.getInstance(mContext).getLoginType());
                    } catch (Error e) {
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e)).build();
                    }
                }
                this.mLoginListeners.clear();
            }
        }
    }
}
