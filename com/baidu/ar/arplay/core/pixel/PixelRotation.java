package com.baidu.ar.arplay.core.pixel;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class PixelRotation {
    public static final /* synthetic */ PixelRotation[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PixelRotation FlipHorizontal;
    public static final PixelRotation FlipVertical;
    public static final PixelRotation NoRotation;
    public static final PixelRotation Rotate180;
    public static final PixelRotation RotateLeft;
    public static final PixelRotation RotateRight;
    public static final PixelRotation RotateRightFlipHorizontal;
    public static final PixelRotation RotateRightFlipVertical;
    public transient /* synthetic */ FieldHolder $fh;
    public final int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1250936458, "Lcom/baidu/ar/arplay/core/pixel/PixelRotation;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1250936458, "Lcom/baidu/ar/arplay/core/pixel/PixelRotation;");
                return;
            }
        }
        NoRotation = new PixelRotation("NoRotation", 0, 0);
        RotateLeft = new PixelRotation("RotateLeft", 1, 1);
        RotateRight = new PixelRotation("RotateRight", 2, 2);
        FlipVertical = new PixelRotation("FlipVertical", 3, 3);
        FlipHorizontal = new PixelRotation("FlipHorizontal", 4, 4);
        RotateRightFlipVertical = new PixelRotation("RotateRightFlipVertical", 5, 5);
        RotateRightFlipHorizontal = new PixelRotation("RotateRightFlipHorizontal", 6, 6);
        PixelRotation pixelRotation = new PixelRotation("Rotate180", 7, 7);
        Rotate180 = pixelRotation;
        $VALUES = new PixelRotation[]{NoRotation, RotateLeft, RotateRight, FlipVertical, FlipHorizontal, RotateRightFlipVertical, RotateRightFlipHorizontal, pixelRotation};
    }

    public PixelRotation(String str, int i2, int i3) {
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

    public static PixelRotation valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PixelRotation) Enum.valueOf(PixelRotation.class, str) : (PixelRotation) invokeL.objValue;
    }

    public static PixelRotation[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PixelRotation[]) $VALUES.clone() : (PixelRotation[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
