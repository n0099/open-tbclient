package com.baidu.ar.arplay.core.renderer;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class OutputFillMode {
    public static final /* synthetic */ OutputFillMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final OutputFillMode KeepRatioCrop;
    public static final OutputFillMode KeepRatioFill;
    public static final OutputFillMode StretchToFill;
    public transient /* synthetic */ FieldHolder $fh;
    public final int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1472024354, "Lcom/baidu/ar/arplay/core/renderer/OutputFillMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1472024354, "Lcom/baidu/ar/arplay/core/renderer/OutputFillMode;");
                return;
            }
        }
        StretchToFill = new OutputFillMode("StretchToFill", 0, 0);
        KeepRatioFill = new OutputFillMode("KeepRatioFill", 1, 1);
        OutputFillMode outputFillMode = new OutputFillMode("KeepRatioCrop", 2, 2);
        KeepRatioCrop = outputFillMode;
        $VALUES = new OutputFillMode[]{StretchToFill, KeepRatioFill, outputFillMode};
    }

    public OutputFillMode(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = i3;
    }

    public static OutputFillMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OutputFillMode) Enum.valueOf(OutputFillMode.class, str) : (OutputFillMode) invokeL.objValue;
    }

    public static OutputFillMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OutputFillMode[]) $VALUES.clone() : (OutputFillMode[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
