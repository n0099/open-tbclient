package com.alipay.sdk.app;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class EnvUtils {
    public static /* synthetic */ Interceptable $ic;
    public static EnvEnum mEnv;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class EnvEnum {
        public static final /* synthetic */ EnvEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EnvEnum ONLINE;
        public static final EnvEnum SANDBOX;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-347485089, "Lcom/alipay/sdk/app/EnvUtils$EnvEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-347485089, "Lcom/alipay/sdk/app/EnvUtils$EnvEnum;");
                    return;
                }
            }
            ONLINE = new EnvEnum("ONLINE", 0);
            EnvEnum envEnum = new EnvEnum("SANDBOX", 1);
            SANDBOX = envEnum;
            $VALUES = new EnvEnum[]{ONLINE, envEnum};
        }

        public EnvEnum(String str, int i2) {
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

        public static EnvEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnvEnum) Enum.valueOf(EnvEnum.class, str) : (EnvEnum) invokeL.objValue;
        }

        public static EnvEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnvEnum[]) $VALUES.clone() : (EnvEnum[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2070463511, "Lcom/alipay/sdk/app/EnvUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2070463511, "Lcom/alipay/sdk/app/EnvUtils;");
                return;
            }
        }
        mEnv = EnvEnum.ONLINE;
    }

    public EnvUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static EnvEnum geEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? mEnv : (EnvEnum) invokeV.objValue;
    }

    public static boolean isSandBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? mEnv == EnvEnum.SANDBOX : invokeV.booleanValue;
    }

    public static void setEnv(EnvEnum envEnum) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, envEnum) == null) {
            mEnv = envEnum;
        }
    }
}
