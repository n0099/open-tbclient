package com.baidu.android.imsdk.account;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.request.IMUserLoginByTokenMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMSettings;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.u80;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class LoginManager {
    public static /* synthetic */ Interceptable $ic;
    public static Context mContext;
    public static volatile LoginManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public int cidTryLoginedTimes;
    public Runnable imLoginRunable;
    public ArrayList<ILoginListener> mLoginListeners;
    public volatile LoginState mLoginState;

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

        public LoginState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (LoginState) Enum.valueOf(LoginState.class, str);
            }
            return (LoginState) invokeL.objValue;
        }

        public static LoginState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (LoginState[]) $VALUES.clone();
            }
            return (LoginState[]) invokeV.objValue;
        }
    }

    public LoginManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    this.this$0.imLogin(false);
                }
            }
        };
        if (context != null) {
            mContext = context.getApplicationContext();
        }
        this.mLoginListeners = new ArrayList<>();
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
                setCurrentState(LoginState.LOGINING);
                printCurrentState();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static LoginManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                context = IMSettings.getsContext();
            }
            if (mInstance == null) {
                synchronized (LoginManager.class) {
                    if (mInstance == null) {
                        mInstance = new LoginManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (LoginManager) invokeL.objValue;
    }

    public void imRetryLogin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this.mLoginState) {
                printCurrentState();
                if (this.mLoginState == LoginState.LOGINING) {
                    return;
                }
                setCurrentState(LoginState.NOT_LOGIN);
                if (i != 4004 && i != 8010) {
                    imLogin(false);
                } else {
                    imLogin(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imLogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            int loginType = AccountManagerImpl.getInstance(mContext).getLoginType();
            BIMManager.setBIMContext(mContext);
            String str = this.TAG;
            LogUtils.d(str, "lcp，im login ：" + IMUserLoginByTokenMsg.sRetrytimes + ", loginType :" + loginType);
            if (!z) {
                if (loginType == 1) {
                    BIMManager.login(Utility.readUid(mContext), AccountManagerImpl.getInstance(mContext).getToken(), loginType, AccountManagerImpl.getInstance(mContext).getFrom(), AccountManagerImpl.getInstance(mContext).getcFrom(), removeLoginListener());
                    return;
                } else if (loginType == 6) {
                    BIMManager.login(null, AccountManagerImpl.getInstance(mContext).getCuid(), loginType, AccountManagerImpl.getInstance(mContext).getFrom(), AccountManagerImpl.getInstance(mContext).getcFrom(), removeLoginListener());
                    return;
                } else {
                    return;
                }
            }
            Handler handler = u80.c;
            if (handler != null) {
                handler.removeCallbacks(this.imLoginRunable);
                u80.c.postDelayed(this.imLoginRunable, 3000L);
            }
        }
    }

    private void printCurrentState() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (this.mLoginState.equals(LoginState.LOGINING)) {
                str = "logining";
            } else if (this.mLoginState.equals(LoginState.LOGINED)) {
                str = "logged";
            } else {
                str = "not_login";
            }
            LogUtils.d(this.TAG, str);
        }
    }

    public synchronized LoginState getCurrentState() {
        InterceptResult invokeV;
        LoginState loginState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                loginState = this.mLoginState;
            }
            return loginState;
        }
        return (LoginState) invokeV.objValue;
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

    public synchronized boolean isIMLogined() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.mLoginState == LoginState.LOGINED) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized ILoginListener removeLoginListener() {
        InterceptResult invokeV;
        ILoginListener iLoginListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                iLoginListener = null;
                if (!this.mLoginListeners.isEmpty()) {
                    iLoginListener = this.mLoginListeners.remove(0);
                }
            }
            return iLoginListener;
        }
        return (ILoginListener) invokeV.objValue;
    }

    private void triggleLoginListenerCallBack(int i, String str) {
        ArrayList<ILoginListener> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65542, this, i, str) == null) && (arrayList = this.mLoginListeners) != null && arrayList.size() != 0) {
            Iterator<ILoginListener> it = this.mLoginListeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onLoginResult(i, str);
                } catch (Error unused) {
                }
            }
        }
    }

    public synchronized void onLogoutResultInternal(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str) == null) {
            synchronized (this) {
                if (i == 0) {
                    setCurrentState(LoginState.NOT_LOGIN);
                }
                printCurrentState();
                if (this.mLoginListeners != null && this.mLoginListeners.size() != 0) {
                    this.mLoginListeners.clear();
                }
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

    public synchronized void logoutInternal(ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iLoginListener) == null) {
            synchronized (this) {
                setCurrentState(LoginState.NOT_LOGIN);
                printCurrentState();
            }
        }
    }

    public synchronized void setCurrentState(LoginState loginState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, loginState) == null) {
            synchronized (this) {
                this.mLoginState = loginState;
            }
        }
    }

    public synchronized void onLoginResultInternal(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
            synchronized (this) {
                LogUtils.d(this.TAG, "HB> onLoginResultInternal, responseCode = " + i + ", errMsg = " + str);
                if (i == 0) {
                    setCurrentState(LoginState.LOGINED);
                    this.cidTryLoginedTimes = 1;
                } else if (i == 23 && AccountManagerImpl.getInstance(mContext).getLoginType() == 6 && this.cidTryLoginedTimes > 0) {
                    imRetryLogin(i);
                    this.cidTryLoginedTimes--;
                    return;
                } else if (110 != i && 7 != i && 23 != i && 1004 != i && 1001 != i && 8010 != i) {
                    LogUtils.d(this.TAG, "error :" + i + ", and retry ：" + IMUserLoginByTokenMsg.sRetrytimes);
                    setCurrentState(LoginState.NOT_LOGIN);
                    if (IMUserLoginByTokenMsg.sRetrytimes < 3) {
                        imRetryLogin(i);
                    }
                    return;
                } else {
                    setCurrentState(LoginState.NOT_LOGIN);
                }
                printCurrentState();
                triggleLoginListenerCallBack(i, str);
            }
        }
    }

    public synchronized void triggleLogoutListener(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
            synchronized (this) {
                String str2 = this.TAG;
                LogUtils.d(str2, "triggleLogoutListener logout :" + this.mLoginListeners.size());
                imRetryLogin(i);
                if (this.mLoginListeners != null && this.mLoginListeners.size() != 0) {
                    Iterator<ILoginListener> it = this.mLoginListeners.iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().onLogoutResult(i, str, AccountManagerImpl.getInstance(mContext).getLoginType());
                        } catch (Error unused) {
                        }
                    }
                }
            }
        }
    }
}
