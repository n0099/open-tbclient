package com.baidu.ar.bean;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class ScaleType {
    public static final /* synthetic */ ScaleType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ScaleType CENTER_CROP;
    public static final ScaleType CENTER_INSIDE;
    public static final ScaleType FIT_XY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-630461786, "Lcom/baidu/ar/bean/ScaleType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-630461786, "Lcom/baidu/ar/bean/ScaleType;");
                return;
            }
        }
        FIT_XY = new ScaleType("FIT_XY", 0);
        CENTER_INSIDE = new ScaleType("CENTER_INSIDE", 1);
        ScaleType scaleType = new ScaleType("CENTER_CROP", 2);
        CENTER_CROP = scaleType;
        $VALUES = new ScaleType[]{FIT_XY, CENTER_INSIDE, scaleType};
    }

    public ScaleType(String str, int i2) {
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

    public static ScaleType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ScaleType) Enum.valueOf(ScaleType.class, str) : (ScaleType) invokeL.objValue;
    }

    public static ScaleType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScaleType[]) $VALUES.clone() : (ScaleType[]) invokeV.objValue;
    }
}
