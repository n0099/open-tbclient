package com.baidu.swan.apps.statistic.interfacestability;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class SwanInterfaceType {
    public static final /* synthetic */ SwanInterfaceType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SwanInterfaceType ACCREDIT_DATA;
    public static final SwanInterfaceType AUTHORIZE;
    public static final SwanInterfaceType CHECK_SESSION;
    public static final SwanInterfaceType FACE_CHECK;
    public static final SwanInterfaceType LOGIN;
    public static final SwanInterfaceType NAVIGATE;
    public static final SwanInterfaceType OPEN_DATA;
    public static final SwanInterfaceType OPEN_ID;
    public static final SwanInterfaceType REAL_NAME_CHECK;
    public static final SwanInterfaceType SWAN_ID;
    public static final SwanInterfaceType UPDATE;
    public transient /* synthetic */ FieldHolder $fh;
    public final String classify;
    public final String interfaceName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2118733876, "Lcom/baidu/swan/apps/statistic/interfacestability/SwanInterfaceType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2118733876, "Lcom/baidu/swan/apps/statistic/interfacestability/SwanInterfaceType;");
                return;
            }
        }
        LOGIN = new SwanInterfaceType("LOGIN", 0, "cs_auth", "ma_login");
        CHECK_SESSION = new SwanInterfaceType("CHECK_SESSION", 1, "cs_auth", "ma_user_checksessionkey");
        OPEN_DATA = new SwanInterfaceType("OPEN_DATA", 2, "cs_auth", "ma_open_data");
        SWAN_ID = new SwanInterfaceType("SWAN_ID", 3, "cs_auth", "ma_user_swanid");
        OPEN_ID = new SwanInterfaceType("OPEN_ID", 4, "cs_auth", "ma_user_openid");
        AUTHORIZE = new SwanInterfaceType("AUTHORIZE", 5, "cs_auth", "ma_accredit_v1");
        ACCREDIT_DATA = new SwanInterfaceType("ACCREDIT_DATA", 6, "cs_auth", "ma_accredit_data");
        FACE_CHECK = new SwanInterfaceType("FACE_CHECK", 7, "cs_auth", "ma_authentication_facecheck");
        REAL_NAME_CHECK = new SwanInterfaceType("REAL_NAME_CHECK", 8, "cs_auth", "ma_authentication_realnamecheck");
        UPDATE = new SwanInterfaceType("UPDATE", 9, "cs_auth", "ma_update");
        SwanInterfaceType swanInterfaceType = new SwanInterfaceType("NAVIGATE", 10, "cs_common", "ma_navigate");
        NAVIGATE = swanInterfaceType;
        $VALUES = new SwanInterfaceType[]{LOGIN, CHECK_SESSION, OPEN_DATA, SWAN_ID, OPEN_ID, AUTHORIZE, ACCREDIT_DATA, FACE_CHECK, REAL_NAME_CHECK, UPDATE, swanInterfaceType};
    }

    public SwanInterfaceType(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str4 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.classify = str2;
        this.interfaceName = str3;
    }

    public static SwanInterfaceType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SwanInterfaceType) Enum.valueOf(SwanInterfaceType.class, str) : (SwanInterfaceType) invokeL.objValue;
    }

    public static SwanInterfaceType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SwanInterfaceType[]) $VALUES.clone() : (SwanInterfaceType[]) invokeV.objValue;
    }

    public String getClassify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.classify : (String) invokeV.objValue;
    }

    public String getInterfaceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.interfaceName : (String) invokeV.objValue;
    }
}
