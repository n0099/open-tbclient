package com.baidu.swan.cpu.booster.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class CpuType {
    public static final /* synthetic */ CpuType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CpuType Hisilicon;
    public static final CpuType Mtk;
    public static final CpuType QualComm;
    public static final CpuType Unknown;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1548704179, "Lcom/baidu/swan/cpu/booster/utils/CpuType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1548704179, "Lcom/baidu/swan/cpu/booster/utils/CpuType;");
                return;
            }
        }
        Hisilicon = new CpuType("Hisilicon", 0);
        QualComm = new CpuType("QualComm", 1);
        Mtk = new CpuType("Mtk", 2);
        CpuType cpuType = new CpuType("Unknown", 3);
        Unknown = cpuType;
        $VALUES = new CpuType[]{Hisilicon, QualComm, Mtk, cpuType};
    }

    public CpuType(String str, int i2) {
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

    public static CpuType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CpuType) Enum.valueOf(CpuType.class, str) : (CpuType) invokeL.objValue;
    }

    public static CpuType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CpuType[]) $VALUES.clone() : (CpuType[]) invokeV.objValue;
    }
}
