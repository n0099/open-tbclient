package com.baidu.ar.arplay.core.engine.rotate;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class Orientation {
    public static final /* synthetic */ Orientation[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Orientation LANDSCAPE;
    public static final Orientation LANDSCAPE_REVERSE;
    public static final Orientation PORTRAIT;
    public static final Orientation PORTRAIT_REVERSE;
    public static final Orientation UNKNOWN;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDegree;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1872340744, "Lcom/baidu/ar/arplay/core/engine/rotate/Orientation;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1872340744, "Lcom/baidu/ar/arplay/core/engine/rotate/Orientation;");
                return;
            }
        }
        UNKNOWN = new Orientation(RomUtils.UNKNOWN, 0, -1);
        PORTRAIT = new Orientation("PORTRAIT", 1, 0);
        PORTRAIT_REVERSE = new Orientation("PORTRAIT_REVERSE", 2, 180);
        LANDSCAPE = new Orientation("LANDSCAPE", 3, 90);
        Orientation orientation = new Orientation("LANDSCAPE_REVERSE", 4, -90);
        LANDSCAPE_REVERSE = orientation;
        $VALUES = new Orientation[]{UNKNOWN, PORTRAIT, PORTRAIT_REVERSE, LANDSCAPE, orientation};
    }

    public Orientation(String str, int i2, int i3) {
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
        this.mDegree = i3;
    }

    public static Orientation valueOf(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == PORTRAIT.getDegree() ? PORTRAIT : i2 == PORTRAIT_REVERSE.getDegree() ? PORTRAIT_REVERSE : i2 == LANDSCAPE.getDegree() ? LANDSCAPE : i2 == LANDSCAPE_REVERSE.getDegree() ? LANDSCAPE_REVERSE : UNKNOWN : (Orientation) invokeI.objValue;
    }

    public static Orientation valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Orientation) Enum.valueOf(Orientation.class, str) : (Orientation) invokeL.objValue;
    }

    public static Orientation[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Orientation[]) $VALUES.clone() : (Orientation[]) invokeV.objValue;
    }

    public int getDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDegree : invokeV.intValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? String.valueOf(this.mDegree) : (String) invokeV.objValue;
    }
}
