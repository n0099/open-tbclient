package com.baidu.sapi2.shell.result;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class WebAuthResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_CONTEXT_ERROR = 13;
    public static final int ERROR_CODE_NEED_BACK_PHONE_NO_REG = 12;
    public static final String ERROR_MSG_CONTEXT_ERROR = "请先进行登录";
    public static final String ERROR_MSG_NEED_BACK_PHONE_NO_REG = "手机号未注册";
    public transient /* synthetic */ FieldHolder $fh;
    public AccountType accountType;
    public Activity activity;
    public boolean isAccountFreeze;

    public void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void finishActivity(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class LoginType {
        public static /* synthetic */ Interceptable $ic;
        public static final LoginType FORCE_BIND;
        public static final LoginType GUIDE_BIND;
        public static final LoginType LOGIN;
        public static final LoginType LOGIN_PROTECT;
        public static final LoginType PHONE_REG;
        public static final LoginType SHARE_V1_CHOICE;
        public static final LoginType SHARE_V2_CHOICE;
        public static final /* synthetic */ LoginType[] b;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1690982660, "Lcom/baidu/sapi2/shell/result/WebAuthResult$LoginType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1690982660, "Lcom/baidu/sapi2/shell/result/WebAuthResult$LoginType;");
                    return;
                }
            }
            PHONE_REG = new LoginType("PHONE_REG", 0, "phonereg");
            LOGIN = new LoginType("LOGIN", 1, "login");
            LOGIN_PROTECT = new LoginType("LOGIN_PROTECT", 2, "apilogin");
            FORCE_BIND = new LoginType("FORCE_BIND", 3, "AccountBind");
            GUIDE_BIND = new LoginType("GUIDE_BIND", 4, "apibind");
            SHARE_V1_CHOICE = new LoginType("SHARE_V1_CHOICE", 5, ShareCallPacking.LOGIN_TYPE_SHARE_V1_CHOICE);
            LoginType loginType = new LoginType("SHARE_V2_CHOICE", 6, ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
            SHARE_V2_CHOICE = loginType;
            b = new LoginType[]{PHONE_REG, LOGIN, LOGIN_PROTECT, FORCE_BIND, GUIDE_BIND, SHARE_V1_CHOICE, loginType};
        }

        public LoginType(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = str2;
        }

        public static LoginType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (LoginType) Enum.valueOf(LoginType.class, str);
            }
            return (LoginType) invokeL.objValue;
        }

        public static LoginType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (LoginType[]) b.clone();
            }
            return (LoginType[]) invokeV.objValue;
        }

        public String getLoginType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }
    }

    public WebAuthResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.accountType = AccountType.UNKNOWN;
        this.isAccountFreeze = false;
        this.msgMap.put(12, ERROR_MSG_NEED_BACK_PHONE_NO_REG);
    }

    public String getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return SapiUtils.getLoginType();
        }
        return (String) invokeV.objValue;
    }
}
