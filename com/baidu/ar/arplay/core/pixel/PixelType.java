package com.baidu.ar.arplay.core.pixel;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class PixelType {
    public static final /* synthetic */ PixelType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PixelType ALPHA;
    public static final PixelType BGR;
    public static final PixelType BGRA;
    public static final PixelType BLUE;
    public static final PixelType GRAY;
    public static final PixelType GREEN;
    public static final PixelType I420;
    public static final PixelType NV12;
    public static final PixelType NV21;
    public static final PixelType RED;
    public static final PixelType RGB;
    public static final PixelType RGBA;
    public static final PixelType YV12;
    public transient /* synthetic */ FieldHolder $fh;
    public final int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(713037242, "Lcom/baidu/ar/arplay/core/pixel/PixelType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(713037242, "Lcom/baidu/ar/arplay/core/pixel/PixelType;");
                return;
            }
        }
        RGBA = new PixelType("RGBA", 0, 0);
        BGRA = new PixelType("BGRA", 1, 1);
        BGR = new PixelType("BGR", 2, 2);
        NV12 = new PixelType("NV12", 3, 3);
        NV21 = new PixelType("NV21", 4, 4);
        I420 = new PixelType("I420", 5, 5);
        YV12 = new PixelType("YV12", 6, 6);
        GRAY = new PixelType("GRAY", 7, 7);
        RGB = new PixelType("RGB", 8, 8);
        RED = new PixelType("RED", 9, 9);
        GREEN = new PixelType("GREEN", 10, 10);
        BLUE = new PixelType("BLUE", 11, 11);
        PixelType pixelType = new PixelType("ALPHA", 12, 12);
        ALPHA = pixelType;
        $VALUES = new PixelType[]{RGBA, BGRA, BGR, NV12, NV21, I420, YV12, GRAY, RGB, RED, GREEN, BLUE, pixelType};
    }

    public PixelType(String str, int i2, int i3) {
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

    public static PixelType valueOf(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == RGBA.getValue() ? RGBA : i2 == BGRA.getValue() ? BGRA : i2 == BGR.getValue() ? BGR : i2 == NV12.getValue() ? NV12 : i2 == NV21.getValue() ? NV21 : i2 == I420.getValue() ? I420 : i2 == YV12.getValue() ? YV12 : i2 == GRAY.getValue() ? GRAY : i2 == RGB.getValue() ? RGB : i2 == RED.getValue() ? RED : i2 == GREEN.getValue() ? GREEN : i2 == BLUE.getValue() ? BLUE : i2 == ALPHA.getValue() ? ALPHA : RGBA : (PixelType) invokeI.objValue;
    }

    public static PixelType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (PixelType) Enum.valueOf(PixelType.class, str) : (PixelType) invokeL.objValue;
    }

    public static PixelType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (PixelType[]) $VALUES.clone() : (PixelType[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
