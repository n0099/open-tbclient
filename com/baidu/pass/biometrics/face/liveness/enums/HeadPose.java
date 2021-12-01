package com.baidu.pass.biometrics.face.liveness.enums;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class HeadPose {
    public static /* synthetic */ Interceptable $ic;
    public static final HeadPose DOWN;
    public static final HeadPose EYES_BLINK;
    public static final HeadPose MOUTH_OPEN;
    public static final HeadPose TURN_LEFT;
    public static final HeadPose TURN_RIGHT;
    public static final HeadPose UP;
    public static final /* synthetic */ HeadPose[] a;
    public transient /* synthetic */ FieldHolder $fh;
    public int index;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1675885487, "Lcom/baidu/pass/biometrics/face/liveness/enums/HeadPose;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1675885487, "Lcom/baidu/pass/biometrics/face/liveness/enums/HeadPose;");
                return;
            }
        }
        EYES_BLINK = new HeadPose("EYES_BLINK", 0, 0, 1);
        DOWN = new HeadPose("DOWN", 1, 1, 2);
        UP = new HeadPose("UP", 2, 2, 4);
        TURN_LEFT = new HeadPose("TURN_LEFT", 3, 3, 8);
        TURN_RIGHT = new HeadPose("TURN_RIGHT", 4, 4, 16);
        HeadPose headPose = new HeadPose("MOUTH_OPEN", 5, 5, 32);
        MOUTH_OPEN = headPose;
        a = new HeadPose[]{EYES_BLINK, DOWN, UP, TURN_LEFT, TURN_RIGHT, headPose};
    }

    public HeadPose(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.index = i3;
        this.value = i4;
    }

    public static HeadPose getHeadPoseByIndex(Integer num) {
        InterceptResult invokeL;
        HeadPose[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, num)) == null) {
            for (HeadPose headPose : values()) {
                if (num.intValue() == headPose.index) {
                    return headPose;
                }
            }
            return EYES_BLINK;
        }
        return (HeadPose) invokeL.objValue;
    }

    public static HeadPose getHeadPoseByValues(Integer num) {
        InterceptResult invokeL;
        HeadPose[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, num)) == null) {
            for (HeadPose headPose : values()) {
                if (num.intValue() == headPose.value) {
                    return headPose;
                }
            }
            return EYES_BLINK;
        }
        return (HeadPose) invokeL.objValue;
    }

    public static HeadPose valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (HeadPose) Enum.valueOf(HeadPose.class, str) : (HeadPose) invokeL.objValue;
    }

    public static HeadPose[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (HeadPose[]) a.clone() : (HeadPose[]) invokeV.objValue;
    }
}
