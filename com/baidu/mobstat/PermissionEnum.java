package com.baidu.mobstat;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class PermissionEnum {
    public static /* synthetic */ Interceptable $ic;
    public static final PermissionEnum APP_LIST;
    public static final PermissionEnum LOCATION;
    public static final PermissionEnum READ_PHONE_STATE;
    public static final PermissionEnum STORAGE;
    public static final /* synthetic */ PermissionEnum[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1376484062, "Lcom/baidu/mobstat/PermissionEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1376484062, "Lcom/baidu/mobstat/PermissionEnum;");
                return;
            }
        }
        LOCATION = new PermissionEnum("LOCATION", 0);
        STORAGE = new PermissionEnum("STORAGE", 1);
        APP_LIST = new PermissionEnum("APP_LIST", 2);
        PermissionEnum permissionEnum = new PermissionEnum("READ_PHONE_STATE", 3);
        READ_PHONE_STATE = permissionEnum;
        a = new PermissionEnum[]{LOCATION, STORAGE, APP_LIST, permissionEnum};
    }

    public PermissionEnum(String str, int i) {
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

    public static PermissionEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PermissionEnum) Enum.valueOf(PermissionEnum.class, str);
        }
        return (PermissionEnum) invokeL.objValue;
    }

    public static PermissionEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PermissionEnum[]) a.clone();
        }
        return (PermissionEnum[]) invokeV.objValue;
    }
}
