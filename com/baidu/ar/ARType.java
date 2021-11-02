package com.baidu.ar;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class ARType {
    public static final /* synthetic */ ARType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ARType CLOUD_IR;
    public static final ARType FACE;
    public static final ARType GAME;
    public static final ARType IMU;
    public static final ARType LBS;
    public static final ARType MARKER;
    public static final ARType NPC;
    public static final ARType ON_DEVICE_IR;
    public static final ARType TRACK_2D;
    public static final ARType TRACK_3D;
    public static final ARType UDT;
    public static final ARType VO;
    public static final ARType VPAS;
    public transient /* synthetic */ FieldHolder $fh;
    public int mTypeValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1235654592, "Lcom/baidu/ar/ARType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1235654592, "Lcom/baidu/ar/ARType;");
                return;
            }
        }
        TRACK_2D = new ARType("TRACK_2D", 0, 0);
        LBS = new ARType("LBS", 1, 1);
        GAME = new ARType("GAME", 2, 2);
        UDT = new ARType("UDT", 3, 3);
        NPC = new ARType("NPC", 4, 4);
        VO = new ARType("VO", 5, 5);
        ON_DEVICE_IR = new ARType("ON_DEVICE_IR", 6, 6);
        CLOUD_IR = new ARType("CLOUD_IR", 7, 7);
        IMU = new ARType("IMU", 8, 8);
        FACE = new ARType("FACE", 9, 10);
        VPAS = new ARType("VPAS", 10, 11);
        MARKER = new ARType("MARKER", 11, 12);
        ARType aRType = new ARType("TRACK_3D", 12, 13);
        TRACK_3D = aRType;
        $VALUES = new ARType[]{TRACK_2D, LBS, GAME, UDT, NPC, VO, ON_DEVICE_IR, CLOUD_IR, IMU, FACE, VPAS, MARKER, aRType};
    }

    public ARType(String str, int i2, int i3) {
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
        this.mTypeValue = i3;
    }

    public static ARType valueOf(int i2) {
        InterceptResult invokeI;
        ARType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (ARType aRType : values()) {
                if (aRType.getTypeValue() == i2) {
                    return aRType;
                }
            }
            return null;
        }
        return (ARType) invokeI.objValue;
    }

    public static ARType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ARType) Enum.valueOf(ARType.class, str) : (ARType) invokeL.objValue;
    }

    public static ARType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ARType[]) $VALUES.clone() : (ARType[]) invokeV.objValue;
    }

    public int getTypeValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mTypeValue : invokeV.intValue;
    }
}
