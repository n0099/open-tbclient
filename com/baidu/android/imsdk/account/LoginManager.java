package com.baidu.android.imsdk.account;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.u.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class LoginManager {
    public static /* synthetic */ Interceptable $ic;
    public static Context mContext;
    public static LoginManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public int cidTryLoginedTimes;
    public Runnable imLoginRunable;
    public ArrayList<ILoginListener> mLoginListeners;
    public volatile LoginState mLoginState;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class LoginState {
        public static final /* synthetic */ LoginState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LoginState LOGINED;
        public static final LoginState LOGINING;
        public static final LoginState NOT_LOGIN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-256094180, "Lcom/baidu/android/imsdk/account/LoginManager$LoginState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-256094180, "Lcom/baidu/android/imsdk/account/LoginManager$LoginState;");
                    return;
                }
            }
            NOT_LOGIN = new LoginState("NOT_LOGIN", 0);
            LOGINING = new LoginState("LOGINING", 1);
            LoginState loginState = new LoginState("LOGINED", 2);
            LOGINED = loginState;
            $VALUES = new LoginState[]{NOT_LOGIN, LOGINING, loginState};
        }

        public LoginState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static LoginState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LoginState) Enum.valueOf(LoginState.class, str) : (LoginState) invokeL.objValue;
        }

        public static LoginState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LoginState[]) $VALUES.clone() : (LoginState[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1639219698, "Lcom/baidu/android/imsdk/account/LoginManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1639219698, "Lcom/baidu/android/imsdk/account/LoginManager;");
        }
    }

    public LoginManager(Context context) {
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
        this.TAG = LoginManager.class.getSimpleName();
        this.mLoginListeners = null;
        this.mLoginState = LoginState.NOT_LOGIN;
        this.cidTryLoginedTimes = 1;
        this.imLoginRunable = new Runnable(this) { // from class: com.baidu.android.imsdk.account.LoginManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LoginManager this$0;

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
                    this.this$0.imLogin(false);
                }
            }
        };
        mContext = context.getApplicationContext();
        this.mLoginListeners = new ArrayList<>();
    }

    public static LoginManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (LoginManager.class) {
                if (mInstance == null) {
                    mInstance = new LoginManager(context);
                }
            }
            return mInstance;
        }
        return (LoginManager) invokeL.objValue;
    }

    private String getStateString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.mLoginState.equals(LoginState.LOGINING) ? "logining" : this.mLoginState.equals(LoginState.LOGINED) ? "logged" : "not_login" : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imLogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
            int loginType = AccountManagerImpl.getInstance(mContext).getLoginType();
            String str = this.TAG;
            LogUtils.d(str, "lcp，im login ：" + IMUserLoginByTokenMsg.sRetrytimes + ", loginType :" + loginType);
            if (z) {
                Handler handler = a.f68191c;
                if (handler != null) {
                    handler.removeCallbacks(this.imLoginRunable);
                    a.f68191c.postDelayed(this.imLoginRunable, 3000L);
                }
            } else if (loginType == 1) {
                BIMManager.login(Utility.readUid(mContext), AccountManagerImpl.getInstance(mContext).getToken(), loginType, AccountManagerImpl.getInstance(mContext).getFrom(), AccountManagerImpl.getInstance(mContext).getcFrom(), removeLoginListener());
            } else if (loginType == 6) {
                BIMManager.login(null, AccountManagerImpl.getInstance(mContext).getCuid(), loginType, AccountManagerImpl.getInstance(mContext).getFrom(), AccountManagerImpl.getInstance(mContext).getcFrom(), removeLoginListener());
            }
        }
    }

    private void printCurrentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            LogUtils.d(this.TAG, getStateString());
        }
    }

    private void triggleLoginListenerCallBack(int i2, String str) {
        ArrayList<ILoginListener> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, this, i2, str) == null) || (arrayList = this.mLoginListeners) == null || arrayList.size() == 0) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iLoginListener) == null) {
            synchronized (this) {
                if (!this.mLoginListeners.contains(iLoginListener)) {
                    this.mLoginListeners.add(iLoginListener);
                }
            }
        }
    }

    public LoginState getCurrentState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLoginState : (LoginState) invokeV.objValue;
    }

    public synchronized ArrayList<ILoginListener> getLoginListener() {
        InterceptResult invokeV;
        ArrayList<ILoginListener> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                arrayList = this.mLoginListeners;
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void imRetryLogin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
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
    }

    public boolean isIMLogined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLoginState == LoginState.LOGINED : invokeV.booleanValue;
    }

    public synchronized boolean loginInternal(ILoginListener iLoginListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iLoginListener)) == null) {
            synchronized (this) {
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
        }
        return invokeL.booleanValue;
    }

    public synchronized void logoutInternal(ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iLoginListener) == null) {
            synchronized (this) {
                this.mLoginState = LoginState.NOT_LOGIN;
                printCurrentState();
            }
        }
    }

    public synchronized void onLoginResultInternal(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
            synchronized (this) {
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
                    LogUtils.d(this.TAG, "error :" + i2 + ", and retry ：" + IMUserLoginByTokenMsg.sRetrytimes + "， isLcp :" + a.f68193e);
                    this.mLoginState = LoginState.NOT_LOGIN;
                    if (a.f68193e && IMUserLoginByTokenMsg.sRetrytimes < 3) {
                        imRetryLogin(i2);
                    } else if (!a.f68193e && IMConnection.getInstance(mContext).shouldRetryLogin()) {
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
        }
    }

    public synchronized void onLogoutResultInternal(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            synchronized (this) {
                if (i2 == 0) {
                    this.mLoginState = LoginState.NOT_LOGIN;
                }
                printCurrentState();
                if (this.mLoginListeners != null && this.mLoginListeners.size() != 0) {
                    this.mLoginListeners.clear();
                }
            }
        }
    }

    public synchronized ILoginListener removeLoginListener() {
        InterceptResult invokeV;
        ILoginListener remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                remove = this.mLoginListeners.isEmpty() ? null : this.mLoginListeners.remove(0);
            }
            return remove;
        }
        return (ILoginListener) invokeV.objValue;
    }

    public synchronized void setCurrentState(LoginState loginState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, loginState) == null) {
            synchronized (this) {
                this.mLoginState = loginState;
            }
        }
    }

    public synchronized void triggleLogoutListener(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
            synchronized (this) {
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
    }
}
