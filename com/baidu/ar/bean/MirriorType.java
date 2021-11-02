package com.baidu.ar.bean;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class MirriorType {
    public static final /* synthetic */ MirriorType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MirriorType HORIZONTAL_MIRRIOR;
    public static final MirriorType NO_MIRRIOR;
    public static final MirriorType VERTICAL_MIRRIOR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(388212288, "Lcom/baidu/ar/bean/MirriorType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(388212288, "Lcom/baidu/ar/bean/MirriorType;");
                return;
            }
        }
        NO_MIRRIOR = new MirriorType("NO_MIRRIOR", 0);
        VERTICAL_MIRRIOR = new MirriorType("VERTICAL_MIRRIOR", 1);
        MirriorType mirriorType = new MirriorType("HORIZONTAL_MIRRIOR", 2);
        HORIZONTAL_MIRRIOR = mirriorType;
        $VALUES = new MirriorType[]{NO_MIRRIOR, VERTICAL_MIRRIOR, mirriorType};
    }

    public MirriorType(String str, int i2) {
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

    public static MirriorType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MirriorType) Enum.valueOf(MirriorType.class, str) : (MirriorType) invokeL.objValue;
    }

    public static MirriorType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MirriorType[]) $VALUES.clone() : (MirriorType[]) invokeV.objValue;
    }
}
