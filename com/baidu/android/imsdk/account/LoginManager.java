package com.baidu.android.imsdk.account;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import d.a.s.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class LoginManager {
    public static Context mContext;
    public static LoginManager mInstance;
    public ArrayList<ILoginListener> mLoginListeners;
    public String TAG = LoginManager.class.getSimpleName();
    public volatile LoginState mLoginState = LoginState.NOT_LOGIN;
    public int cidTryLoginedTimes = 1;
    public Runnable imLoginRunable = new Runnable() { // from class: com.baidu.android.imsdk.account.LoginManager.1
        @Override // java.lang.Runnable
        public void run() {
            LoginManager.this.imLogin(false);
        }
    };

    /* loaded from: classes.dex */
    public enum LoginState {
        NOT_LOGIN,
        LOGINING,
        LOGINED
    }

    public LoginManager(Context context) {
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

    private String getStateString() {
        return this.mLoginState.equals(LoginState.LOGINING) ? "logining" : this.mLoginState.equals(LoginState.LOGINED) ? "logged" : "not_login";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imLogin(boolean z) {
        int loginType = AccountManagerImpl.getInstance(mContext).getLoginType();
        String str = this.TAG;
        LogUtils.d(str, "lcp，im login ：" + IMUserLoginByTokenMsg.sRetrytimes + ", loginType :" + loginType);
        if (z) {
            Handler handler = a.f68179c;
            if (handler != null) {
                handler.removeCallbacks(this.imLoginRunable);
                a.f68179c.postDelayed(this.imLoginRunable, 3000L);
            }
        } else if (loginType == 1) {
            BIMManager.login(Utility.readUid(mContext), AccountManagerImpl.getInstance(mContext).getToken(), loginType, AccountManagerImpl.getInstance(mContext).getFrom(), AccountManagerImpl.getInstance(mContext).getcFrom(), removeLoginListener());
        } else if (loginType == 6) {
            BIMManager.login(null, AccountManagerImpl.getInstance(mContext).getCuid(), loginType, AccountManagerImpl.getInstance(mContext).getFrom(), AccountManagerImpl.getInstance(mContext).getcFrom(), removeLoginListener());
        }
    }

    private void printCurrentState() {
        LogUtils.d(this.TAG, getStateString());
    }

    private void triggleLoginListenerCallBack(int i2, String str) {
        ArrayList<ILoginListener> arrayList = this.mLoginListeners;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<ILoginListener> it = this.mLoginListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onLoginResult(i2, str);
            } catch (Error e2) {
                new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    public synchronized void addListener(ILoginListener iLoginListener) {
        if (!this.mLoginListeners.contains(iLoginListener)) {
            this.mLoginListeners.add(iLoginListener);
        }
    }

    public LoginState getCurrentState() {
        return this.mLoginState;
    }

    public synchronized ArrayList<ILoginListener> getLoginListener() {
        return this.mLoginListeners;
    }

    public void imRetryLogin(int i2) {
        switch (i2) {
            case 4001:
                imLogin(false);
                return;
            case 4002:
            default:
                imLogin(false);
                return;
            case 4003:
            case 4004:
            case 4005:
                imLogin(true);
                return;
        }
    }

    public boolean isIMLogined() {
        return this.mLoginState == LoginState.LOGINED;
    }

    public synchronized boolean loginInternal(ILoginListener iLoginListener) {
        printCurrentState();
        if (iLoginListener != null) {
            addListener(iLoginListener);
        }
        if (this.mLoginState.equals(LoginState.LOGINING)) {
            return false;
        }
        if (this.mLoginState.equals(LoginState.LOGINED)) {
            printCurrentState();
            triggleLoginListenerCallBack(0, Constants.ERROR_MSG_SUCCESS);
            return false;
        }
        this.mLoginState = LoginState.LOGINING;
        printCurrentState();
        return true;
    }

    public synchronized void logoutInternal(ILoginListener iLoginListener) {
        this.mLoginState = LoginState.NOT_LOGIN;
        printCurrentState();
    }

    public synchronized void onLoginResultInternal(int i2, String str) {
        LogUtils.d(this.TAG, "HB> onLoginResultInternal, responseCode = " + i2 + ", errMsg = " + str);
        if (i2 == 0) {
            this.mLoginState = LoginState.LOGINED;
            this.cidTryLoginedTimes = 1;
        } else if (i2 == 23 && AccountManagerImpl.getInstance(mContext).getLoginType() == 6 && this.cidTryLoginedTimes > 0) {
            BIMManager.login(null, AccountManagerImpl.getInstance(mContext).getCuid(), 6, AccountManagerImpl.getInstance(mContext).getFrom(), AccountManagerImpl.getInstance(mContext).getcFrom(), removeLoginListener());
            this.cidTryLoginedTimes--;
            this.mLoginState = LoginState.NOT_LOGIN;
            return;
        } else if (110 != i2 && 7 != i2 && 23 != i2 && 1004 != i2 && 1001 != i2 && 8010 != i2) {
            LogUtils.d(this.TAG, "error :" + i2 + ", and retry ：" + IMUserLoginByTokenMsg.sRetrytimes + "， isLcp :" + a.f68181e);
            this.mLoginState = LoginState.NOT_LOGIN;
            if (a.f68181e && IMUserLoginByTokenMsg.sRetrytimes < 3) {
                imRetryLogin(i2);
            } else if (!a.f68181e && IMConnection.getInstance(mContext).shouldRetryLogin()) {
                LogUtils.d(this.TAG, "IMConnection，im login ：" + IMUserLoginByTokenMsg.sRetrytimes);
                IMConnection.getInstance(mContext).disconnectedByPeer();
            }
            return;
        } else {
            this.mLoginState = LoginState.NOT_LOGIN;
        }
        printCurrentState();
        triggleLoginListenerCallBack(i2, str);
    }

    public synchronized void onLogoutResultInternal(int i2, String str) {
        if (i2 == 0) {
            this.mLoginState = LoginState.NOT_LOGIN;
        }
        printCurrentState();
        if (this.mLoginListeners != null && this.mLoginListeners.size() != 0) {
            this.mLoginListeners.clear();
        }
    }

    public synchronized ILoginListener removeLoginListener() {
        return this.mLoginListeners.isEmpty() ? null : this.mLoginListeners.remove(0);
    }

    public synchronized void setCurrentState(LoginState loginState) {
        this.mLoginState = loginState;
    }

    public synchronized void triggleLogoutListener(int i2, String str) {
        this.mLoginState = LoginState.NOT_LOGIN;
        printCurrentState();
        String str2 = this.TAG;
        LogUtils.d(str2, "triggleLogoutListener logout :" + this.mLoginListeners.size());
        if (4001 == i2) {
            imLogin(false);
        } else if (4005 != i2 && 4003 != i2 && 4004 != i2) {
            if (this.mLoginListeners != null && this.mLoginListeners.size() != 0) {
                Iterator<ILoginListener> it = this.mLoginListeners.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLogoutResult(i2, str, AccountManagerImpl.getInstance(mContext).getLoginType());
                    } catch (Error e2) {
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
                    }
                }
                this.mLoginListeners.clear();
            }
        } else {
            imLogin(true);
        }
    }
}
