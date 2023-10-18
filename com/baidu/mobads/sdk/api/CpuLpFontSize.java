package com.baidu.mobads.sdk.api;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class CpuLpFontSize {
    public static final /* synthetic */ CpuLpFontSize[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CpuLpFontSize EXTRA_LARGE;
    public static final CpuLpFontSize LARGE;
    public static final CpuLpFontSize REGULAR;
    public static final CpuLpFontSize SMALL;
    public static final CpuLpFontSize XX_LARGE;
    public transient /* synthetic */ FieldHolder $fh;
    public String mValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2075328262, "Lcom/baidu/mobads/sdk/api/CpuLpFontSize;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2075328262, "Lcom/baidu/mobads/sdk/api/CpuLpFontSize;");
                return;
            }
        }
        SMALL = new CpuLpFontSize("SMALL", 0, "sml");
        REGULAR = new CpuLpFontSize("REGULAR", 1, "reg");
        LARGE = new CpuLpFontSize("LARGE", 2, "lrg");
        EXTRA_LARGE = new CpuLpFontSize("EXTRA_LARGE", 3, "xlg");
        CpuLpFontSize cpuLpFontSize = new CpuLpFontSize("XX_LARGE", 4, "xxl");
        XX_LARGE = cpuLpFontSize;
        $VALUES = new CpuLpFontSize[]{SMALL, REGULAR, LARGE, EXTRA_LARGE, cpuLpFontSize};
    }

    public CpuLpFontSize(String str, int i, String str2) {
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
        this.mValue = str2;
    }

    public static CpuLpFontSize valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (CpuLpFontSize) Enum.valueOf(CpuLpFontSize.class, str);
        }
        return (CpuLpFontSize) invokeL.objValue;
    }

    public static CpuLpFontSize[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (CpuLpFontSize[]) $VALUES.clone();
        }
        return (CpuLpFontSize[]) invokeV.objValue;
    }

    public String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mValue;
        }
        return (String) invokeV.objValue;
    }
}
