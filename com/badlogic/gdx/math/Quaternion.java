package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.z2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Quaternion implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7661875440774897168L;
    public static Quaternion tmp1;
    public static Quaternion tmp2;
    public transient /* synthetic */ FieldHolder $fh;
    public float w;
    public float x;
    public float y;
    public float z;

    public static final float dot(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8)})) == null) ? (f * f5) + (f2 * f6) + (f3 * f7) + (f4 * f8) : invokeCommon.floatValue;
    }

    public static final float len2(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? (f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4) : invokeCommon.floatValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2093320070, "Lcom/badlogic/gdx/math/Quaternion;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2093320070, "Lcom/badlogic/gdx/math/Quaternion;");
                return;
            }
        }
        tmp1 = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
        tmp2 = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public Quaternion() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        idt();
    }

    public Quaternion conjugate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.x = -this.x;
            this.y = -this.y;
            this.z = -this.z;
            return this;
        }
        return (Quaternion) invokeV.objValue;
    }

    public Quaternion cpy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new Quaternion(this);
        }
        return (Quaternion) invokeV.objValue;
    }

    public float getAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return getAngleRad() * 57.295776f;
        }
        return invokeV.floatValue;
    }

    public float getAngleRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            float f = this.w;
            if (f > 1.0f) {
                f /= len();
            }
            return (float) (Math.acos(f) * 2.0d);
        }
        return invokeV.floatValue;
    }

    public int getGimbalPole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            float f = (this.y * this.x) + (this.z * this.w);
            if (f > 0.499f) {
                return 1;
            }
            if (f < -0.499f) {
                return -1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public float getPitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return getPitchRad() * 57.295776f;
        }
        return invokeV.floatValue;
    }

    public float getRoll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return getRollRad() * 57.295776f;
        }
        return invokeV.floatValue;
    }

    public float getYaw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return getYawRad() * 57.295776f;
        }
        return invokeV.floatValue;
    }

    public Quaternion idt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return set(0.0f, 0.0f, 0.0f, 1.0f);
        }
        return (Quaternion) invokeV.objValue;
    }

    public float len() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            float f = this.x;
            float f2 = this.y;
            float f3 = (f * f) + (f2 * f2);
            float f4 = this.z;
            float f5 = f3 + (f4 * f4);
            float f6 = this.w;
            return (float) Math.sqrt(f5 + (f6 * f6));
        }
        return invokeV.floatValue;
    }

    public float len2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            float f = this.x;
            float f2 = this.y;
            float f3 = (f * f) + (f2 * f2);
            float f4 = this.z;
            float f5 = f3 + (f4 * f4);
            float f6 = this.w;
            return f5 + (f6 * f6);
        }
        return invokeV.floatValue;
    }

    public Quaternion(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        set(f, f2, f3, f4);
    }

    public static final float len(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4));
        }
        return invokeCommon.floatValue;
    }

    public Quaternion add(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            this.x += f;
            this.y += f2;
            this.z += f3;
            this.w += f4;
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public float dot(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            return (this.x * f) + (this.y * f2) + (this.z * f3) + (this.w * f4);
        }
        return invokeCommon.floatValue;
    }

    public Quaternion(Quaternion quaternion) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {quaternion};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        set(quaternion);
    }

    public Quaternion add(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, quaternion)) == null) {
            this.x += quaternion.x;
            this.y += quaternion.y;
            this.z += quaternion.z;
            this.w += quaternion.w;
            return this;
        }
        return (Quaternion) invokeL.objValue;
    }

    public float dot(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, quaternion)) == null) {
            return (this.x * quaternion.x) + (this.y * quaternion.y) + (this.z * quaternion.z) + (this.w * quaternion.w);
        }
        return invokeL.floatValue;
    }

    public float getAngleAround(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, vector3)) == null) {
            return getAngleAround(vector3.x, vector3.y, vector3.z);
        }
        return invokeL.floatValue;
    }

    public float getAngleAroundRad(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, vector3)) == null) {
            return getAngleAroundRad(vector3.x, vector3.y, vector3.z);
        }
        return invokeL.floatValue;
    }

    public float getAxisAngle(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, vector3)) == null) {
            return getAxisAngleRad(vector3) * 57.295776f;
        }
        return invokeL.floatValue;
    }

    public Quaternion mul(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f)) == null) {
            this.x *= f;
            this.y *= f;
            this.z *= f;
            this.w *= f;
            return this;
        }
        return (Quaternion) invokeF.objValue;
    }

    public Quaternion set(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, quaternion)) == null) {
            return set(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
        }
        return (Quaternion) invokeL.objValue;
    }

    public Quaternion setFromMatrix(Matrix3 matrix3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, matrix3)) == null) {
            return setFromMatrix(false, matrix3);
        }
        return (Quaternion) invokeL.objValue;
    }

    public Quaternion(Vector3 vector3, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3, Float.valueOf(f)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        set(vector3, f);
    }

    public Quaternion setFromCross(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048625, this, vector3, vector32)) == null) {
            float f = vector3.y;
            float f2 = vector32.z;
            float f3 = vector3.z;
            float f4 = vector32.y;
            float f5 = (f * f2) - (f3 * f4);
            float f6 = vector32.x;
            float f7 = vector3.x;
            return setFromAxisRad(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6), (float) Math.acos(b.b(vector3.dot(vector32), -1.0f, 1.0f)));
        }
        return (Quaternion) invokeLL.objValue;
    }

    public Quaternion setFromMatrix(boolean z, Matrix3 matrix3) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048628, this, z, matrix3)) == null) {
            float[] fArr = matrix3.val;
            return setFromAxes(z, fArr[0], fArr[3], fArr[6], fArr[1], fArr[4], fArr[7], fArr[2], fArr[5], fArr[8]);
        }
        return (Quaternion) invokeZL.objValue;
    }

    public Quaternion slerp(Quaternion[] quaternionArr, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048632, this, quaternionArr, fArr)) == null) {
            set(quaternionArr[0]).exp(fArr[0]);
            for (int i = 1; i < quaternionArr.length; i++) {
                mul(tmp1.set(quaternionArr[i]).exp(fArr[i]));
            }
            nor();
            return this;
        }
        return (Quaternion) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Quaternion)) {
                return false;
            }
            Quaternion quaternion = (Quaternion) obj;
            if (z2.b(this.w) == z2.b(quaternion.w) && z2.b(this.x) == z2.b(quaternion.x) && z2.b(this.y) == z2.b(quaternion.y) && z2.b(this.z) == z2.b(quaternion.z)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public float getAxisAngleRad(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, vector3)) == null) {
            if (this.w > 1.0f) {
                nor();
            }
            float acos = (float) (Math.acos(this.w) * 2.0d);
            float f = this.w;
            double sqrt = Math.sqrt(1.0f - (f * f));
            if (sqrt < 9.999999974752427E-7d) {
                vector3.x = this.x;
                vector3.y = this.y;
                vector3.z = this.z;
            } else {
                vector3.x = (float) (this.x / sqrt);
                vector3.y = (float) (this.y / sqrt);
                vector3.z = (float) (this.z / sqrt);
            }
            return acos;
        }
        return invokeL.floatValue;
    }

    public Quaternion mul(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, quaternion)) == null) {
            float f = this.w;
            float f2 = quaternion.x;
            float f3 = this.x;
            float f4 = quaternion.w;
            float f5 = this.y;
            float f6 = quaternion.z;
            float f7 = this.z;
            float f8 = quaternion.y;
            this.x = (((f * f2) + (f3 * f4)) + (f5 * f6)) - (f7 * f8);
            this.y = (((f * f8) + (f5 * f4)) + (f7 * f2)) - (f3 * f6);
            this.z = (((f * f6) + (f7 * f4)) + (f3 * f8)) - (f5 * f2);
            this.w = (((f * f4) - (f3 * f2)) - (f5 * f8)) - (f7 * f6);
            return this;
        }
        return (Quaternion) invokeL.objValue;
    }

    public Quaternion mulLeft(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, quaternion)) == null) {
            float f = quaternion.w;
            float f2 = this.x;
            float f3 = quaternion.x;
            float f4 = this.w;
            float f5 = quaternion.y;
            float f6 = this.z;
            float f7 = quaternion.z;
            float f8 = this.y;
            this.x = (((f * f2) + (f3 * f4)) + (f5 * f6)) - (f7 * f8);
            this.y = (((f * f8) + (f5 * f4)) + (f7 * f2)) - (f3 * f6);
            this.z = (((f * f6) + (f7 * f4)) + (f3 * f8)) - (f5 * f2);
            this.w = (((f * f4) - (f3 * f2)) - (f5 * f8)) - (f7 * f6);
            return this;
        }
        return (Quaternion) invokeL.objValue;
    }

    public Quaternion exp(float f) {
        InterceptResult invokeF;
        float sin;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f)) == null) {
            float len = len();
            double d = len;
            float pow = (float) Math.pow(d, f);
            float acos = (float) Math.acos(this.w / len);
            if (Math.abs(acos) < 0.001d) {
                sin = (pow * f) / len;
            } else {
                sin = (float) ((pow * Math.sin(f * acos)) / (d * Math.sin(acos)));
            }
            this.w = (float) (pow * Math.cos(f * acos));
            this.x *= sin;
            this.y *= sin;
            this.z *= sin;
            nor();
            return this;
        }
        return (Quaternion) invokeF.objValue;
    }

    public void toMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, fArr) == null) {
            float f = this.x;
            float f2 = f * f;
            float f3 = this.y;
            float f4 = f * f3;
            float f5 = this.z;
            float f6 = f * f5;
            float f7 = this.w;
            float f8 = f * f7;
            float f9 = f3 * f3;
            float f10 = f3 * f5;
            float f11 = f3 * f7;
            float f12 = f5 * f5;
            float f13 = f5 * f7;
            fArr[0] = 1.0f - ((f9 + f12) * 2.0f);
            fArr[4] = (f4 - f13) * 2.0f;
            fArr[8] = (f6 + f11) * 2.0f;
            fArr[12] = 0.0f;
            fArr[1] = (f4 + f13) * 2.0f;
            fArr[5] = 1.0f - ((f12 + f2) * 2.0f);
            fArr[9] = (f10 - f8) * 2.0f;
            fArr[13] = 0.0f;
            fArr[2] = (f6 - f11) * 2.0f;
            fArr[6] = (f10 + f8) * 2.0f;
            fArr[10] = 1.0f - ((f2 + f9) * 2.0f);
            fArr[14] = 0.0f;
            fArr[3] = 0.0f;
            fArr[7] = 0.0f;
            fArr[11] = 0.0f;
            fArr[15] = 1.0f;
        }
    }

    public float getAngleAround(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return getAngleAroundRad(f, f2, f3) * 57.295776f;
        }
        return invokeCommon.floatValue;
    }

    public Quaternion setEulerAngles(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return setEulerAnglesRad(f * 0.017453292f, f2 * 0.017453292f, f3 * 0.017453292f);
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public float getAngleAroundRad(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float dot = Vector3.dot(this.x, this.y, this.z, f, f2, f3);
            float len2 = len2(f * dot, f2 * dot, f3 * dot, this.w);
            if (b.g(len2)) {
                return 0.0f;
            }
            if (dot < 0.0f) {
                f4 = -this.w;
            } else {
                f4 = this.w;
            }
            return (float) (Math.acos(b.b((float) (f4 / Math.sqrt(len2)), -1.0f, 1.0f)) * 2.0d);
        }
        return invokeCommon.floatValue;
    }

    public Quaternion setEulerAnglesRad(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            double d = f3 * 0.5f;
            float sin = (float) Math.sin(d);
            float cos = (float) Math.cos(d);
            double d2 = f2 * 0.5f;
            float sin2 = (float) Math.sin(d2);
            float cos2 = (float) Math.cos(d2);
            double d3 = f * 0.5f;
            float sin3 = (float) Math.sin(d3);
            float cos3 = (float) Math.cos(d3);
            float f4 = cos3 * sin2;
            float f5 = sin3 * cos2;
            float f6 = cos3 * cos2;
            float f7 = sin3 * sin2;
            this.x = (f4 * cos) + (f5 * sin);
            this.y = (f5 * cos) - (f4 * sin);
            this.z = (f6 * sin) - (f7 * cos);
            this.w = (f6 * cos) + (f7 * sin);
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public float getPitchRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int gimbalPole = getGimbalPole();
            if (gimbalPole == 0) {
                return (float) Math.asin(b.b(((this.w * this.x) - (this.z * this.y)) * 2.0f, -1.0f, 1.0f));
            }
            return gimbalPole * 3.1415927f * 0.5f;
        }
        return invokeV.floatValue;
    }

    public float getRollRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int gimbalPole = getGimbalPole();
            if (gimbalPole == 0) {
                float f = this.w;
                float f2 = this.z;
                float f3 = this.y;
                float f4 = this.x;
                return b.a(((f * f2) + (f3 * f4)) * 2.0f, 1.0f - (((f4 * f4) + (f2 * f2)) * 2.0f));
            }
            return gimbalPole * 2.0f * b.a(this.y, this.w);
        }
        return invokeV.floatValue;
    }

    public float getYawRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (getGimbalPole() == 0) {
                float f = this.y;
                float f2 = this.x;
                return b.a(((this.w * f) + (this.z * f2)) * 2.0f, 1.0f - (((f * f) + (f2 * f2)) * 2.0f));
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return ((((((z2.b(this.w) + 31) * 31) + z2.b(this.x)) * 31) + z2.b(this.y)) * 31) + z2.b(this.z);
        }
        return invokeV.intValue;
    }

    public boolean isIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (b.g(this.x) && b.g(this.y) && b.g(this.z) && b.e(this.w, 1.0f)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Quaternion nor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            float len2 = len2();
            if (len2 != 0.0f && !b.e(len2, 1.0f)) {
                float sqrt = (float) Math.sqrt(len2);
                this.w /= sqrt;
                this.x /= sqrt;
                this.y /= sqrt;
                this.z /= sqrt;
            }
            return this;
        }
        return (Quaternion) invokeV.objValue;
    }

    public void getSwingTwist(float f, float f2, float f3, Quaternion quaternion, Quaternion quaternion2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), quaternion, quaternion2}) == null) {
            float dot = Vector3.dot(this.x, this.y, this.z, f, f2, f3);
            quaternion2.set(f * dot, f2 * dot, f3 * dot, this.w).nor();
            if (dot < 0.0f) {
                quaternion2.mul(-1.0f);
            }
            quaternion.set(quaternion2).conjugate().mulLeft(this);
        }
    }

    public void getSwingTwist(Vector3 vector3, Quaternion quaternion, Quaternion quaternion2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, vector3, quaternion, quaternion2) == null) {
            getSwingTwist(vector3.x, vector3.y, vector3.z, quaternion, quaternion2);
        }
    }

    public boolean isIdentity(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048604, this, f)) == null) {
            if (b.h(this.x, f) && b.h(this.y, f) && b.h(this.z, f) && b.f(this.w, 1.0f, f)) {
                return true;
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    public Quaternion slerp(Quaternion[] quaternionArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, quaternionArr)) == null) {
            float length = 1.0f / quaternionArr.length;
            set(quaternionArr[0]).exp(length);
            for (int i = 1; i < quaternionArr.length; i++) {
                mul(tmp1.set(quaternionArr[i]).exp(length));
            }
            nor();
            return this;
        }
        return (Quaternion) invokeL.objValue;
    }

    public Vector3 transform(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, vector3)) == null) {
            tmp2.set(this);
            tmp2.conjugate();
            tmp2.mulLeft(tmp1.set(vector3.x, vector3.y, vector3.z, 0.0f)).mulLeft(this);
            Quaternion quaternion = tmp2;
            vector3.x = quaternion.x;
            vector3.y = quaternion.y;
            vector3.z = quaternion.z;
            return vector3;
        }
        return (Vector3) invokeL.objValue;
    }

    public Quaternion mul(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float f5 = this.w;
            float f6 = this.x;
            float f7 = this.y;
            float f8 = this.z;
            this.x = (((f5 * f) + (f6 * f4)) + (f7 * f3)) - (f8 * f2);
            this.y = (((f5 * f2) + (f7 * f4)) + (f8 * f)) - (f6 * f3);
            this.z = (((f5 * f3) + (f8 * f4)) + (f6 * f2)) - (f7 * f);
            this.w = (((f5 * f4) - (f6 * f)) - (f7 * f2)) - (f8 * f3);
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion mulLeft(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float f5 = this.x;
            float f6 = this.w;
            float f7 = this.z;
            float f8 = this.y;
            this.x = (((f4 * f5) + (f * f6)) + (f2 * f7)) - (f3 * f8);
            this.y = (((f4 * f8) + (f2 * f6)) + (f3 * f5)) - (f * f7);
            this.z = (((f4 * f7) + (f3 * f6)) + (f * f8)) - (f2 * f5);
            this.w = (((f4 * f6) - (f * f5)) - (f2 * f8)) - (f3 * f7);
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromAxisRad(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float len = Vector3.len(f, f2, f3);
            if (len == 0.0f) {
                return idt();
            }
            float f6 = 1.0f / len;
            if (f4 < 0.0f) {
                f5 = 6.2831855f - ((-f4) % 6.2831855f);
            } else {
                f5 = f4 % 6.2831855f;
            }
            double d = f5 / 2.0f;
            float sin = (float) Math.sin(d);
            return set(f * f6 * sin, f2 * f6 * sin, f6 * f3 * sin, (float) Math.cos(d)).nor();
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion set(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            this.x = f;
            this.y = f2;
            this.z = f3;
            this.w = f4;
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromAxis(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            return setFromAxisRad(f, f2, f3, f4 * 0.017453292f);
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion set(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048615, this, vector3, f)) == null) {
            return setFromAxis(vector3.x, vector3.y, vector3.z, f);
        }
        return (Quaternion) invokeLF.objValue;
    }

    public Quaternion setFromAxis(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048621, this, vector3, f)) == null) {
            return setFromAxis(vector3.x, vector3.y, vector3.z, f);
        }
        return (Quaternion) invokeLF.objValue;
    }

    public Quaternion setFromAxisRad(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048623, this, vector3, f)) == null) {
            return setFromAxisRad(vector3.x, vector3.y, vector3.z, f);
        }
        return (Quaternion) invokeLF.objValue;
    }

    public Quaternion setFromAxes(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9)})) == null) {
            return setFromAxes(false, f, f2, f3, f4, f5, f6, f7, f8, f9);
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromAxes(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9)})) == null) {
            if (z) {
                float len = 1.0f / Vector3.len(f, f2, f3);
                float len2 = 1.0f / Vector3.len(f4, f5, f6);
                float len3 = 1.0f / Vector3.len(f7, f8, f9);
                f *= len;
                f2 *= len;
                f3 *= len;
                f4 *= len2;
                f5 *= len2;
                f6 *= len2;
                f7 *= len3;
                f8 *= len3;
                f9 *= len3;
            }
            float f10 = f + f5 + f9;
            if (f10 >= 0.0f) {
                float sqrt = (float) Math.sqrt(f10 + 1.0f);
                this.w = sqrt * 0.5f;
                float f11 = 0.5f / sqrt;
                this.x = (f8 - f6) * f11;
                this.y = (f3 - f7) * f11;
                this.z = (f4 - f2) * f11;
            } else if (f > f5 && f > f9) {
                float sqrt2 = (float) Math.sqrt(((f + 1.0d) - f5) - f9);
                this.x = sqrt2 * 0.5f;
                float f12 = 0.5f / sqrt2;
                this.y = (f4 + f2) * f12;
                this.z = (f3 + f7) * f12;
                this.w = (f8 - f6) * f12;
            } else if (f5 > f9) {
                float sqrt3 = (float) Math.sqrt(((f5 + 1.0d) - f) - f9);
                this.y = sqrt3 * 0.5f;
                float f13 = 0.5f / sqrt3;
                this.x = (f4 + f2) * f13;
                this.z = (f8 + f6) * f13;
                this.w = (f3 - f7) * f13;
            } else {
                float sqrt4 = (float) Math.sqrt(((f9 + 1.0d) - f) - f5);
                this.z = sqrt4 * 0.5f;
                float f14 = 0.5f / sqrt4;
                this.x = (f3 + f7) * f14;
                this.y = (f8 + f6) * f14;
                this.w = (f4 - f2) * f14;
            }
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromCross(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            return setFromAxisRad((f2 * f6) - (f3 * f5), (f3 * f4) - (f6 * f), (f * f5) - (f2 * f4), (float) Math.acos(b.b(Vector3.dot(f, f2, f3, f4, f5, f6), -1.0f, 1.0f)));
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromMatrix(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, matrix4)) == null) {
            return setFromMatrix(false, matrix4);
        }
        return (Quaternion) invokeL.objValue;
    }

    public Quaternion setFromMatrix(boolean z, Matrix4 matrix4) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048629, this, z, matrix4)) == null) {
            float[] fArr = matrix4.val;
            return setFromAxes(z, fArr[0], fArr[4], fArr[8], fArr[1], fArr[5], fArr[9], fArr[2], fArr[6], fArr[10]);
        }
        return (Quaternion) invokeZL.objValue;
    }

    public Quaternion slerp(Quaternion quaternion, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048630, this, quaternion, f)) == null) {
            float f2 = (this.x * quaternion.x) + (this.y * quaternion.y) + (this.z * quaternion.z) + (this.w * quaternion.w);
            int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i < 0) {
                f2 = -f2;
            }
            float f3 = 1.0f - f;
            if (1.0f - f2 > 0.1d) {
                float acos = (float) Math.acos(f2);
                float sin = 1.0f / ((float) Math.sin(acos));
                f3 = ((float) Math.sin(f3 * acos)) * sin;
                f = ((float) Math.sin(f * acos)) * sin;
            }
            if (i < 0) {
                f = -f;
            }
            this.x = (this.x * f3) + (quaternion.x * f);
            this.y = (this.y * f3) + (quaternion.y * f);
            this.z = (this.z * f3) + (quaternion.z * f);
            this.w = (f3 * this.w) + (f * quaternion.w);
            return this;
        }
        return (Quaternion) invokeLF.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.x + "|" + this.y + "|" + this.z + "|" + this.w + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
