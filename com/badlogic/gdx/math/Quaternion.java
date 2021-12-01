package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes8.dex */
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

    public Quaternion(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        set(f2, f3, f4, f5);
    }

    public static final float dot(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9)})) == null) ? (f2 * f6) + (f3 * f7) + (f4 * f8) + (f5 * f9) : invokeCommon.floatValue;
    }

    public static final float len(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (float) Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5)) : invokeCommon.floatValue;
    }

    public static final float len2(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (f2 * f2) + (f3 * f3) + (f4 * f4) + (f5 * f5) : invokeCommon.floatValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new Quaternion(this) : (Quaternion) invokeV.objValue;
    }

    public float dot(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, quaternion)) == null) ? (this.x * quaternion.x) + (this.y * quaternion.y) + (this.z * quaternion.z) + (this.w * quaternion.w) : invokeL.floatValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Quaternion)) {
                Quaternion quaternion = (Quaternion) obj;
                return t.b(this.w) == t.b(quaternion.w) && t.b(this.x) == t.b(quaternion.x) && t.b(this.y) == t.b(quaternion.y) && t.b(this.z) == t.b(quaternion.z);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Quaternion exp(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f2)) == null) {
            float len = len();
            double d2 = len;
            float pow = (float) Math.pow(d2, f2);
            float acos = (float) Math.acos(this.w / len);
            float sin = ((double) Math.abs(acos)) < 0.001d ? (pow * f2) / len : (float) ((pow * Math.sin(f2 * acos)) / (d2 * Math.sin(acos)));
            this.w = (float) (pow * Math.cos(f2 * acos));
            this.x *= sin;
            this.y *= sin;
            this.z *= sin;
            nor();
            return this;
        }
        return (Quaternion) invokeF.objValue;
    }

    public float getAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getAngleRad() * 57.295776f : invokeV.floatValue;
    }

    public float getAngleAround(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? getAngleAroundRad(f2, f3, f4) * 57.295776f : invokeCommon.floatValue;
    }

    public float getAngleAroundRad(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float dot = Vector3.dot(this.x, this.y, this.z, f2, f3, f4);
            float len2 = len2(f2 * dot, f3 * dot, f4 * dot, this.w);
            if (d.h(len2)) {
                return 0.0f;
            }
            return (float) (Math.acos(d.b((float) ((dot < 0.0f ? -this.w : this.w) / Math.sqrt(len2)), -1.0f, 1.0f)) * 2.0d);
        }
        return invokeCommon.floatValue;
    }

    public float getAngleRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            float f2 = this.w;
            if (f2 > 1.0f) {
                f2 /= len();
            }
            return (float) (Math.acos(f2) * 2.0d);
        }
        return invokeV.floatValue;
    }

    public float getAxisAngle(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, vector3)) == null) ? getAxisAngleRad(vector3) * 57.295776f : invokeL.floatValue;
    }

    public float getAxisAngleRad(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, vector3)) == null) {
            if (this.w > 1.0f) {
                nor();
            }
            float acos = (float) (Math.acos(this.w) * 2.0d);
            float f2 = this.w;
            double sqrt = Math.sqrt(1.0f - (f2 * f2));
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

    public int getGimbalPole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            float f2 = (this.y * this.x) + (this.z * this.w);
            if (f2 > 0.499f) {
                return 1;
            }
            return f2 < -0.499f ? -1 : 0;
        }
        return invokeV.intValue;
    }

    public float getPitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? getPitchRad() * 57.295776f : invokeV.floatValue;
    }

    public float getPitchRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int gimbalPole = getGimbalPole();
            return gimbalPole == 0 ? (float) Math.asin(d.b(((this.w * this.x) - (this.z * this.y)) * 2.0f, -1.0f, 1.0f)) : gimbalPole * 3.1415927f * 0.5f;
        }
        return invokeV.floatValue;
    }

    public float getRoll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? getRollRad() * 57.295776f : invokeV.floatValue;
    }

    public float getRollRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int gimbalPole = getGimbalPole();
            if (gimbalPole == 0) {
                float f2 = this.w;
                float f3 = this.z;
                float f4 = this.y;
                float f5 = this.x;
                return d.a(((f2 * f3) + (f4 * f5)) * 2.0f, 1.0f - (((f5 * f5) + (f3 * f3)) * 2.0f));
            }
            return gimbalPole * 2.0f * d.a(this.y, this.w);
        }
        return invokeV.floatValue;
    }

    public void getSwingTwist(float f2, float f3, float f4, Quaternion quaternion, Quaternion quaternion2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), quaternion, quaternion2}) == null) {
            float dot = Vector3.dot(this.x, this.y, this.z, f2, f3, f4);
            quaternion2.set(f2 * dot, f3 * dot, f4 * dot, this.w).nor();
            if (dot < 0.0f) {
                quaternion2.mul(-1.0f);
            }
            quaternion.set(quaternion2).conjugate().mulLeft(this);
        }
    }

    public float getYaw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? getYawRad() * 57.295776f : invokeV.floatValue;
    }

    public float getYawRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (getGimbalPole() == 0) {
                float f2 = this.y;
                float f3 = this.x;
                return d.a(((this.w * f2) + (this.z * f3)) * 2.0f, 1.0f - (((f2 * f2) + (f3 * f3)) * 2.0f));
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? ((((((t.b(this.w) + 31) * 31) + t.b(this.x)) * 31) + t.b(this.y)) * 31) + t.b(this.z) : invokeV.intValue;
    }

    public Quaternion idt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? set(0.0f, 0.0f, 0.0f, 1.0f) : (Quaternion) invokeV.objValue;
    }

    public boolean isIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? d.h(this.x) && d.h(this.y) && d.h(this.z) && d.e(this.w, 1.0f) : invokeV.booleanValue;
    }

    public float len2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            float f2 = this.x;
            float f3 = this.y;
            float f4 = (f2 * f2) + (f3 * f3);
            float f5 = this.z;
            float f6 = f4 + (f5 * f5);
            float f7 = this.w;
            return f6 + (f7 * f7);
        }
        return invokeV.floatValue;
    }

    public Quaternion mul(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, quaternion)) == null) {
            float f2 = this.w;
            float f3 = quaternion.x;
            float f4 = this.x;
            float f5 = quaternion.w;
            float f6 = this.y;
            float f7 = quaternion.z;
            float f8 = this.z;
            float f9 = quaternion.y;
            this.x = (((f2 * f3) + (f4 * f5)) + (f6 * f7)) - (f8 * f9);
            this.y = (((f2 * f9) + (f6 * f5)) + (f8 * f3)) - (f4 * f7);
            this.z = (((f2 * f7) + (f8 * f5)) + (f4 * f9)) - (f6 * f3);
            this.w = (((f2 * f5) - (f4 * f3)) - (f6 * f9)) - (f8 * f7);
            return this;
        }
        return (Quaternion) invokeL.objValue;
    }

    public Quaternion mulLeft(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, quaternion)) == null) {
            float f2 = quaternion.w;
            float f3 = this.x;
            float f4 = quaternion.x;
            float f5 = this.w;
            float f6 = quaternion.y;
            float f7 = this.z;
            float f8 = quaternion.z;
            float f9 = this.y;
            this.x = (((f2 * f3) + (f4 * f5)) + (f6 * f7)) - (f8 * f9);
            this.y = (((f2 * f9) + (f6 * f5)) + (f8 * f3)) - (f4 * f7);
            this.z = (((f2 * f7) + (f8 * f5)) + (f4 * f9)) - (f6 * f3);
            this.w = (((f2 * f5) - (f4 * f3)) - (f6 * f9)) - (f8 * f7);
            return this;
        }
        return (Quaternion) invokeL.objValue;
    }

    public Quaternion nor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            float len2 = len2();
            if (len2 != 0.0f && !d.e(len2, 1.0f)) {
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

    public Quaternion set(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            this.x = f2;
            this.y = f3;
            this.z = f4;
            this.w = f5;
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setEulerAngles(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? setEulerAnglesRad(f2 * 0.017453292f, f3 * 0.017453292f, f4 * 0.017453292f) : (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setEulerAnglesRad(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            double d2 = f4 * 0.5f;
            float sin = (float) Math.sin(d2);
            float cos = (float) Math.cos(d2);
            double d3 = f3 * 0.5f;
            float sin2 = (float) Math.sin(d3);
            float cos2 = (float) Math.cos(d3);
            double d4 = f2 * 0.5f;
            float sin3 = (float) Math.sin(d4);
            float cos3 = (float) Math.cos(d4);
            float f5 = cos3 * sin2;
            float f6 = sin3 * cos2;
            float f7 = cos3 * cos2;
            float f8 = sin3 * sin2;
            this.x = (f5 * cos) + (f6 * sin);
            this.y = (f6 * cos) - (f5 * sin);
            this.z = (f7 * sin) - (f8 * cos);
            this.w = (f7 * cos) + (f8 * sin);
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromAxes(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f10)})) == null) ? setFromAxes(false, f2, f3, f4, f5, f6, f7, f8, f9, f10) : (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromAxis(Vector3 vector3, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048621, this, vector3, f2)) == null) ? setFromAxis(vector3.x, vector3.y, vector3.z, f2) : (Quaternion) invokeLF.objValue;
    }

    public Quaternion setFromAxisRad(Vector3 vector3, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048623, this, vector3, f2)) == null) ? setFromAxisRad(vector3.x, vector3.y, vector3.z, f2) : (Quaternion) invokeLF.objValue;
    }

    public Quaternion setFromCross(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048625, this, vector3, vector32)) == null) {
            float f2 = vector3.y;
            float f3 = vector32.z;
            float f4 = vector3.z;
            float f5 = vector32.y;
            float f6 = (f2 * f3) - (f4 * f5);
            float f7 = vector32.x;
            float f8 = vector3.x;
            return setFromAxisRad(f6, (f4 * f7) - (f3 * f8), (f8 * f5) - (f2 * f7), (float) Math.acos(d.b(vector3.dot(vector32), -1.0f, 1.0f)));
        }
        return (Quaternion) invokeLL.objValue;
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

    public Quaternion slerp(Quaternion quaternion, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048630, this, quaternion, f2)) == null) {
            float f3 = (this.x * quaternion.x) + (this.y * quaternion.y) + (this.z * quaternion.z) + (this.w * quaternion.w);
            int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
            if (i2 < 0) {
                f3 = -f3;
            }
            float f4 = 1.0f - f2;
            if (1.0f - f3 > 0.1d) {
                float acos = (float) Math.acos(f3);
                float sin = 1.0f / ((float) Math.sin(acos));
                f4 = ((float) Math.sin(f4 * acos)) * sin;
                f2 = ((float) Math.sin(f2 * acos)) * sin;
            }
            if (i2 < 0) {
                f2 = -f2;
            }
            this.x = (this.x * f4) + (quaternion.x * f2);
            this.y = (this.y * f4) + (quaternion.y * f2);
            this.z = (this.z * f4) + (quaternion.z * f2);
            this.w = (f4 * this.w) + (f2 * quaternion.w);
            return this;
        }
        return (Quaternion) invokeLF.objValue;
    }

    public void toMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, fArr) == null) {
            float f2 = this.x;
            float f3 = f2 * f2;
            float f4 = this.y;
            float f5 = f2 * f4;
            float f6 = this.z;
            float f7 = f2 * f6;
            float f8 = this.w;
            float f9 = f2 * f8;
            float f10 = f4 * f4;
            float f11 = f4 * f6;
            float f12 = f4 * f8;
            float f13 = f6 * f6;
            float f14 = f6 * f8;
            fArr[0] = 1.0f - ((f10 + f13) * 2.0f);
            fArr[4] = (f5 - f14) * 2.0f;
            fArr[8] = (f7 + f12) * 2.0f;
            fArr[12] = 0.0f;
            fArr[1] = (f5 + f14) * 2.0f;
            fArr[5] = 1.0f - ((f13 + f3) * 2.0f);
            fArr[9] = (f11 - f9) * 2.0f;
            fArr[13] = 0.0f;
            fArr[2] = (f7 - f12) * 2.0f;
            fArr[6] = (f11 + f9) * 2.0f;
            fArr[10] = 1.0f - ((f3 + f10) * 2.0f);
            fArr[14] = 0.0f;
            fArr[3] = 0.0f;
            fArr[7] = 0.0f;
            fArr[11] = 0.0f;
            fArr[15] = 1.0f;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.x + "|" + this.y + "|" + this.z + "|" + this.w + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
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

    public float dot(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (this.x * f2) + (this.y * f3) + (this.z * f4) + (this.w * f5) : invokeCommon.floatValue;
    }

    public float getAngleAround(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, vector3)) == null) ? getAngleAround(vector3.x, vector3.y, vector3.z) : invokeL.floatValue;
    }

    public boolean isIdentity(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048604, this, f2)) == null) ? d.i(this.x, f2) && d.i(this.y, f2) && d.i(this.z, f2) && d.f(this.w, 1.0f, f2) : invokeF.booleanValue;
    }

    public float len() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            float f2 = this.x;
            float f3 = this.y;
            float f4 = (f2 * f2) + (f3 * f3);
            float f5 = this.z;
            float f6 = f4 + (f5 * f5);
            float f7 = this.w;
            return (float) Math.sqrt(f6 + (f7 * f7));
        }
        return invokeV.floatValue;
    }

    public Quaternion setFromAxes(boolean z, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f10)})) == null) {
            if (z) {
                float len = 1.0f / Vector3.len(f2, f3, f4);
                float len2 = 1.0f / Vector3.len(f5, f6, f7);
                float len3 = 1.0f / Vector3.len(f8, f9, f10);
                f2 *= len;
                f3 *= len;
                f4 *= len;
                f5 *= len2;
                f6 *= len2;
                f7 *= len2;
                f8 *= len3;
                f9 *= len3;
                f10 *= len3;
            }
            float f11 = f2 + f6 + f10;
            if (f11 >= 0.0f) {
                float sqrt = (float) Math.sqrt(f11 + 1.0f);
                this.w = sqrt * 0.5f;
                float f12 = 0.5f / sqrt;
                this.x = (f9 - f7) * f12;
                this.y = (f4 - f8) * f12;
                this.z = (f5 - f3) * f12;
            } else if (f2 > f6 && f2 > f10) {
                float sqrt2 = (float) Math.sqrt(((f2 + 1.0d) - f6) - f10);
                this.x = sqrt2 * 0.5f;
                float f13 = 0.5f / sqrt2;
                this.y = (f5 + f3) * f13;
                this.z = (f4 + f8) * f13;
                this.w = (f9 - f7) * f13;
            } else if (f6 > f10) {
                float sqrt3 = (float) Math.sqrt(((f6 + 1.0d) - f2) - f10);
                this.y = sqrt3 * 0.5f;
                float f14 = 0.5f / sqrt3;
                this.x = (f5 + f3) * f14;
                this.z = (f9 + f7) * f14;
                this.w = (f4 - f8) * f14;
            } else {
                float sqrt4 = (float) Math.sqrt(((f10 + 1.0d) - f2) - f6);
                this.z = sqrt4 * 0.5f;
                float f15 = 0.5f / sqrt4;
                this.x = (f4 + f8) * f15;
                this.y = (f9 + f7) * f15;
                this.w = (f5 - f3) * f15;
            }
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromAxis(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? setFromAxisRad(f2, f3, f4, f5 * 0.017453292f) : (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromAxisRad(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float len = Vector3.len(f2, f3, f4);
            if (len == 0.0f) {
                return idt();
            }
            float f6 = 1.0f / len;
            double d2 = (f5 < 0.0f ? 6.2831855f - ((-f5) % 6.2831855f) : f5 % 6.2831855f) / 2.0f;
            float sin = (float) Math.sin(d2);
            return set(f2 * f6 * sin, f3 * f6 * sin, f6 * f4 * sin, (float) Math.cos(d2)).nor();
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromMatrix(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, matrix4)) == null) ? setFromMatrix(false, matrix4) : (Quaternion) invokeL.objValue;
    }

    public Quaternion() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        idt();
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

    public Quaternion setFromCross(float f2, float f3, float f4, float f5, float f6, float f7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)})) == null) ? setFromAxisRad((f3 * f7) - (f4 * f6), (f4 * f5) - (f7 * f2), (f2 * f6) - (f3 * f5), (float) Math.acos(d.b(Vector3.dot(f2, f3, f4, f5, f6, f7), -1.0f, 1.0f))) : (Quaternion) invokeCommon.objValue;
    }

    public Quaternion setFromMatrix(Matrix3 matrix3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, matrix3)) == null) ? setFromMatrix(false, matrix3) : (Quaternion) invokeL.objValue;
    }

    public Quaternion(Quaternion quaternion) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {quaternion};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        set(quaternion);
    }

    public Quaternion add(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            this.x += f2;
            this.y += f3;
            this.z += f4;
            this.w += f5;
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public void getSwingTwist(Vector3 vector3, Quaternion quaternion, Quaternion quaternion2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, vector3, quaternion, quaternion2) == null) {
            getSwingTwist(vector3.x, vector3.y, vector3.z, quaternion, quaternion2);
        }
    }

    public Quaternion set(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, quaternion)) == null) ? set(quaternion.x, quaternion.y, quaternion.z, quaternion.w) : (Quaternion) invokeL.objValue;
    }

    public float getAngleAroundRad(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, vector3)) == null) ? getAngleAroundRad(vector3.x, vector3.y, vector3.z) : invokeL.floatValue;
    }

    public Quaternion mul(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = this.w;
            float f7 = this.x;
            float f8 = this.y;
            float f9 = this.z;
            this.x = (((f6 * f2) + (f7 * f5)) + (f8 * f4)) - (f9 * f3);
            this.y = (((f6 * f3) + (f8 * f5)) + (f9 * f2)) - (f7 * f4);
            this.z = (((f6 * f4) + (f9 * f5)) + (f7 * f3)) - (f8 * f2);
            this.w = (((f6 * f5) - (f7 * f2)) - (f8 * f3)) - (f9 * f4);
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion mulLeft(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = this.x;
            float f7 = this.w;
            float f8 = this.z;
            float f9 = this.y;
            this.x = (((f5 * f6) + (f2 * f7)) + (f3 * f8)) - (f4 * f9);
            this.y = (((f5 * f9) + (f3 * f7)) + (f4 * f6)) - (f2 * f8);
            this.z = (((f5 * f8) + (f4 * f7)) + (f2 * f9)) - (f3 * f6);
            this.w = (((f5 * f7) - (f2 * f6)) - (f3 * f9)) - (f4 * f8);
            return this;
        }
        return (Quaternion) invokeCommon.objValue;
    }

    public Quaternion set(Vector3 vector3, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048615, this, vector3, f2)) == null) ? setFromAxis(vector3.x, vector3.y, vector3.z, f2) : (Quaternion) invokeLF.objValue;
    }

    public Quaternion(Vector3 vector3, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3, Float.valueOf(f2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        set(vector3, f2);
    }

    public Quaternion slerp(Quaternion[] quaternionArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, quaternionArr)) == null) {
            float length = 1.0f / quaternionArr.length;
            set(quaternionArr[0]).exp(length);
            for (int i2 = 1; i2 < quaternionArr.length; i2++) {
                mul(tmp1.set(quaternionArr[i2]).exp(length));
            }
            nor();
            return this;
        }
        return (Quaternion) invokeL.objValue;
    }

    public Quaternion mul(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f2)) == null) {
            this.x *= f2;
            this.y *= f2;
            this.z *= f2;
            this.w *= f2;
            return this;
        }
        return (Quaternion) invokeF.objValue;
    }

    public Quaternion slerp(Quaternion[] quaternionArr, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048632, this, quaternionArr, fArr)) == null) {
            set(quaternionArr[0]).exp(fArr[0]);
            for (int i2 = 1; i2 < quaternionArr.length; i2++) {
                mul(tmp1.set(quaternionArr[i2]).exp(fArr[i2]));
            }
            nor();
            return this;
        }
        return (Quaternion) invokeLL.objValue;
    }
}
