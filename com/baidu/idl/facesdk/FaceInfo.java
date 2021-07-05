package com.baidu.idl.facesdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FaceInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int face_id;
    public float[] headPose;
    public int[] is_live;
    public int[] landmarks;
    public int mAngle;
    public int mCenter_x;
    public int mCenter_y;
    public float mConf;
    public int mWidth;

    public FaceInfo(int i2, int i3, int i4, int i5, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWidth = i2;
        this.mAngle = i3;
        this.mCenter_y = i4;
        this.mCenter_x = i5;
        this.mConf = f2;
        this.landmarks = null;
        this.face_id = 0;
    }

    public void getRectPoints(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iArr) == null) {
            int[] iArr2 = iArr;
            double d2 = (this.mAngle * 3.14159d) / 180.0d;
            double cos = Math.cos(d2);
            double sin = Math.sin(d2);
            int i2 = this.mWidth;
            int i3 = (int) ((this.mCenter_x + ((i2 * cos) / 2.0d)) - ((i2 * sin) / 2.0d));
            int i4 = (int) (this.mCenter_y + ((sin * i2) / 2.0d) + ((cos * i2) / 2.0d));
            double d3 = (this.mAngle * 3.14159d) / 180.0d;
            double cos2 = Math.cos(d3) * 0.5d;
            double sin2 = Math.sin(d3) * 0.5d;
            if (iArr2 == null || iArr2.length == 0) {
                iArr2 = new int[8];
            }
            double d4 = i3;
            int i5 = this.mWidth;
            iArr2[0] = (int) ((d4 - (i5 * sin2)) - (i5 * cos2));
            double d5 = i4;
            iArr2[1] = (int) (((i5 * cos2) + d5) - (i5 * sin2));
            iArr2[2] = (int) ((d4 + (i5 * sin2)) - (i5 * cos2));
            iArr2[3] = (int) ((d5 - (cos2 * i5)) - (sin2 * i5));
            int i6 = i3 * 2;
            iArr2[4] = i6 - iArr2[0];
            int i7 = i4 * 2;
            iArr2[5] = i7 - iArr2[1];
            iArr2[6] = i6 - iArr2[2];
            iArr2[7] = i7 - iArr2[3];
        }
    }

    public int get_leftEyeState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int[] iArr = this.is_live;
            if (iArr == null || iArr.length != 11) {
                return 0;
            }
            return iArr[1];
        }
        return invokeV.intValue;
    }

    public int get_mouthState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int[] iArr = this.is_live;
            if (iArr == null || iArr.length != 11) {
                return 0;
            }
            return iArr[4];
        }
        return invokeV.intValue;
    }

    public int get_rightEyeState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = this.is_live;
            if (iArr == null || iArr.length != 11) {
                return 0;
            }
            return iArr[2];
        }
        return invokeV.intValue;
    }

    public boolean is_live() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int[] iArr = this.is_live;
            return iArr != null && iArr.length == 11 && 1 == iArr[0];
        }
        return invokeV.booleanValue;
    }

    public boolean is_live_head_down() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int[] iArr = this.is_live;
            return iArr != null && iArr.length == 11 && 1 == iArr[9];
        }
        return invokeV.booleanValue;
    }

    public boolean is_live_head_turn_left() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int[] iArr = this.is_live;
            return iArr != null && iArr.length == 11 && 1 == iArr[5];
        }
        return invokeV.booleanValue;
    }

    public boolean is_live_head_turn_right() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int[] iArr = this.is_live;
            return iArr != null && iArr.length == 11 && 1 == iArr[6];
        }
        return invokeV.booleanValue;
    }

    public boolean is_live_head_up() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int[] iArr = this.is_live;
            return iArr != null && iArr.length == 11 && 1 == iArr[8];
        }
        return invokeV.booleanValue;
    }

    public boolean is_live_mouth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int[] iArr = this.is_live;
            return iArr != null && iArr.length == 11 && 1 == iArr[3];
        }
        return invokeV.booleanValue;
    }

    public FaceInfo(int i2, int i3, int i4, int i5, float f2, int i6, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Integer.valueOf(i6), iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mWidth = i2;
        this.mAngle = i3;
        this.mCenter_y = i4;
        this.mCenter_x = i5;
        this.mConf = f2;
        this.landmarks = iArr;
        this.face_id = i6;
    }

    public FaceInfo(int i2, int i3, int i4, int i5, float f2, int i6, int[] iArr, float[] fArr, int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), Integer.valueOf(i6), iArr, fArr, iArr2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mWidth = i2;
        this.mAngle = i3;
        this.mCenter_y = i4;
        this.mCenter_x = i5;
        this.mConf = f2;
        this.landmarks = iArr;
        this.face_id = i6;
        this.headPose = fArr;
        this.is_live = iArr2;
    }
}
