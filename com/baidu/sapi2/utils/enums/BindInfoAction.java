package com.baidu.sapi2.utils.enums;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class BindInfoAction {
    public static final /* synthetic */ BindInfoAction[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BindInfoAction BIND_EMAIL;
    public static final BindInfoAction BIND_MOBILE;
    public transient /* synthetic */ FieldHolder $fh;
    public String name;
    public String value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1504184109, "Lcom/baidu/sapi2/utils/enums/BindInfoAction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1504184109, "Lcom/baidu/sapi2/utils/enums/BindInfoAction;");
                return;
            }
        }
        BIND_MOBILE = new BindInfoAction("BIND_MOBILE", 0, "0", "绑定手机");
        BindInfoAction bindInfoAction = new BindInfoAction("BIND_EMAIL", 1, "1", "绑定邮箱");
        BIND_EMAIL = bindInfoAction;
        $VALUES = new BindInfoAction[]{BIND_MOBILE, bindInfoAction};
    }

    public BindInfoAction(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str4 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = str2;
        this.name = str3;
    }

    public static BindInfoAction valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (BindInfoAction) Enum.valueOf(BindInfoAction.class, str);
        }
        return (BindInfoAction) invokeL.objValue;
    }

    public static BindInfoAction[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (BindInfoAction[]) $VALUES.clone();
        }
        return (BindInfoAction[]) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.value;
        }
        return (String) invokeV.objValue;
    }
}
