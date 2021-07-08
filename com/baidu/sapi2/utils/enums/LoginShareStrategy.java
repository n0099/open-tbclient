package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class LoginShareStrategy {
    public static final /* synthetic */ LoginShareStrategy[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LoginShareStrategy CHOICE;
    public static final LoginShareStrategy DISABLED;
    public transient /* synthetic */ FieldHolder $fh;
    public String mStrValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1807303621, "Lcom/baidu/sapi2/utils/enums/LoginShareStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1807303621, "Lcom/baidu/sapi2/utils/enums/LoginShareStrategy;");
                return;
            }
        }
        DISABLED = new LoginShareStrategy("DISABLED", 0, "disabled");
        LoginShareStrategy loginShareStrategy = new LoginShareStrategy("CHOICE", 1, "choice");
        CHOICE = loginShareStrategy;
        $VALUES = new LoginShareStrategy[]{DISABLED, loginShareStrategy};
    }

    public LoginShareStrategy(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStrValue = str2;
    }

    public static LoginShareStrategy getDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? CHOICE : (LoginShareStrategy) invokeV.objValue;
    }

    public static LoginShareStrategy mapStrToValue(String str) {
        InterceptResult invokeL;
        LoginShareStrategy[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return getDefault();
            }
            for (LoginShareStrategy loginShareStrategy : values()) {
                if (str.equals(loginShareStrategy.getStrValue())) {
                    return loginShareStrategy;
                }
            }
            return getDefault();
        }
        return (LoginShareStrategy) invokeL.objValue;
    }

    public static LoginShareStrategy valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (LoginShareStrategy) Enum.valueOf(LoginShareStrategy.class, str) : (LoginShareStrategy) invokeL.objValue;
    }

    public static LoginShareStrategy[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (LoginShareStrategy[]) $VALUES.clone() : (LoginShareStrategy[]) invokeV.objValue;
    }

    public String getStrValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mStrValue : (String) invokeV.objValue;
    }
}
