package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.t7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Vector3 implements Serializable, e<Vector3> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Vector3 X;
    public static final Vector3 Y;
    public static final Vector3 Z;
    public static final Vector3 Zero;
    public static final long serialVersionUID = 3840054589595372522L;
    public static final Matrix4 tmpMat;
    public transient /* synthetic */ FieldHolder $fh;
    public float x;
    public float y;
    public float z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(34217186, "Lcom/badlogic/gdx/math/Vector3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(34217186, "Lcom/badlogic/gdx/math/Vector3;");
                return;
            }
        }
        X = new Vector3(1.0f, 0.0f, 0.0f);
        Y = new Vector3(0.0f, 1.0f, 0.0f);
        Z = new Vector3(0.0f, 0.0f, 1.0f);
        Zero = new Vector3(0.0f, 0.0f, 0.0f);
        tmpMat = new Matrix4();
    }

    public Vector3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static float dot(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) ? (f * f4) + (f2 * f5) + (f3 * f6) : invokeCommon.floatValue;
    }

    public static float dst2(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            float f7 = f4 - f;
            float f8 = f5 - f2;
            float f9 = f6 - f3;
            return (f7 * f7) + (f8 * f8) + (f9 * f9);
        }
        return invokeCommon.floatValue;
    }

    public static float len(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)) : invokeCommon.floatValue;
    }

    public static float len2(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (f * f) + (f2 * f2) + (f3 * f3) : invokeCommon.floatValue;
    }

    public Vector3 crs(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, vector3)) == null) {
            float f = this.y;
            float f2 = vector3.z;
            float f3 = this.z;
            float f4 = vector3.y;
            float f5 = (f * f2) - (f3 * f4);
            float f6 = vector3.x;
            float f7 = this.x;
            return set(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6));
        }
        return (Vector3) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Vector3.class == obj.getClass()) {
                Vector3 vector3 = (Vector3) obj;
                return t7.a(this.x) == t7.a(vector3.x) && t7.a(this.y) == t7.a(vector3.y) && t7.a(this.z) == t7.a(vector3.z);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Vector3 fromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            int indexOf = str.indexOf(44, 1);
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(44, i);
            if (indexOf != -1 && indexOf2 != -1 && str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
                try {
                    return set(Float.parseFloat(str.substring(1, indexOf)), Float.parseFloat(str.substring(i, indexOf2)), Float.parseFloat(str.substring(indexOf2 + 1, str.length() - 1)));
                } catch (NumberFormatException unused) {
                }
            }
            throw new GdxRuntimeException("Malformed Vector3: " + str);
        }
        return (Vector3) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? ((((t7.a(this.x) + 31) * 31) + t7.a(this.y)) * 31) + t7.a(this.z) : invokeV.intValue;
    }

    public boolean idt(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, vector3)) == null) ? this.x == vector3.x && this.y == vector3.y && this.z == vector3.z : invokeL.booleanValue;
    }

    public boolean isUnit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? isUnit(1.0E-9f) : invokeV.booleanValue;
    }

    public boolean isZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.x == 0.0f && this.y == 0.0f && this.z == 0.0f : invokeV.booleanValue;
    }

    public float len2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            float f = this.x;
            float f2 = this.y;
            float f3 = (f * f) + (f2 * f2);
            float f4 = this.z;
            return f3 + (f4 * f4);
        }
        return invokeV.floatValue;
    }

    public Vector3 mul(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, matrix4)) == null) {
            float[] fArr = matrix4.val;
            float f = this.x;
            float f2 = this.y;
            float f3 = (fArr[0] * f) + (fArr[4] * f2);
            float f4 = this.z;
            return set(f3 + (fArr[8] * f4) + fArr[12], (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f4) + fArr[13], (f * fArr[2]) + (f2 * fArr[6]) + (f4 * fArr[10]) + fArr[14]);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 mul4x3(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, fArr)) == null) {
            float f = this.x;
            float f2 = this.y;
            float f3 = (fArr[0] * f) + (fArr[3] * f2);
            float f4 = this.z;
            return set(f3 + (fArr[6] * f4) + fArr[9], (fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f4) + fArr[10], (f * fArr[2]) + (f2 * fArr[5]) + (f4 * fArr[8]) + fArr[11]);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 prj(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, matrix4)) == null) {
            float[] fArr = matrix4.val;
            float f = this.x;
            float f2 = this.y;
            float f3 = (fArr[3] * f) + (fArr[7] * f2);
            float f4 = this.z;
            float f5 = 1.0f / ((f3 + (fArr[11] * f4)) + fArr[15]);
            return set(((fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f4) + fArr[12]) * f5, ((fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f4) + fArr[13]) * f5, ((f * fArr[2]) + (f2 * fArr[6]) + (f4 * fArr[10]) + fArr[14]) * f5);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 rot(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, matrix4)) == null) {
            float[] fArr = matrix4.val;
            float f = this.x;
            float f2 = this.y;
            float f3 = (fArr[0] * f) + (fArr[4] * f2);
            float f4 = this.z;
            return set(f3 + (fArr[8] * f4), (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f4), (f * fArr[2]) + (f2 * fArr[6]) + (f4 * fArr[10]));
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 rotate(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048650, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? mul(tmpMat.setToRotation(f2, f3, f4, f)) : (Vector3) invokeCommon.objValue;
    }

    public Vector3 rotateRad(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048652, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? mul(tmpMat.setToRotationRad(f2, f3, f4, f)) : (Vector3) invokeCommon.objValue;
    }

    public Vector3 setFromSpherical(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048664, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float c = d.c(f2);
            float o = d.o(f2);
            return set(d.c(f) * o, d.o(f) * o, c);
        }
        return (Vector3) invokeCommon.objValue;
    }

    public Vector3 slerp(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048673, this, vector3, f)) == null) {
            float dot = dot(vector3);
            double d = dot;
            if (d <= 0.9995d && d >= -0.9995d) {
                double acos = ((float) Math.acos(d)) * f;
                float sin = (float) Math.sin(acos);
                float f2 = vector3.x - (this.x * dot);
                float f3 = vector3.y - (this.y * dot);
                float f4 = vector3.z - (this.z * dot);
                float f5 = (f2 * f2) + (f3 * f3) + (f4 * f4);
                float sqrt = sin * (f5 >= 1.0E-4f ? 1.0f / ((float) Math.sqrt(f5)) : 1.0f);
                return m21scl((float) Math.cos(acos)).add(f2 * sqrt, f3 * sqrt, f4 * sqrt).m20nor();
            }
            return lerp(vector3, f);
        }
        return (Vector3) invokeLF.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return "(" + this.x + "," + this.y + "," + this.z + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public Vector3 traMul(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048680, this, matrix4)) == null) {
            float[] fArr = matrix4.val;
            float f = this.x;
            float f2 = this.y;
            float f3 = (fArr[0] * f) + (fArr[1] * f2);
            float f4 = this.z;
            return set(f3 + (fArr[2] * f4) + fArr[3], (fArr[4] * f) + (fArr[5] * f2) + (fArr[6] * f4) + fArr[7], (f * fArr[8]) + (f2 * fArr[9]) + (f4 * fArr[10]) + fArr[11]);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 unrotate(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, matrix4)) == null) {
            float[] fArr = matrix4.val;
            float f = this.x;
            float f2 = this.y;
            float f3 = (fArr[0] * f) + (fArr[1] * f2);
            float f4 = this.z;
            return set(f3 + (fArr[2] * f4), (fArr[4] * f) + (fArr[5] * f2) + (fArr[6] * f4), (f * fArr[8]) + (f2 * fArr[9]) + (f4 * fArr[10]));
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 untransform(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048682, this, matrix4)) == null) {
            float[] fArr = matrix4.val;
            float f = this.x - fArr[12];
            this.x = f;
            float f2 = this.y - fArr[12];
            this.y = f2;
            float f3 = this.z - fArr[12];
            this.z = f3;
            return set((fArr[0] * f) + (fArr[1] * f2) + (fArr[2] * f3), (fArr[4] * f) + (fArr[5] * f2) + (fArr[6] * f3), (f * fArr[8]) + (f2 * fArr[9]) + (f3 * fArr[10]));
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        set(f, f2, f3);
    }

    public static float dst(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            float f7 = f4 - f;
            float f8 = f5 - f2;
            float f9 = f6 - f3;
            return (float) Math.sqrt((f7 * f7) + (f8 * f8) + (f9 * f9));
        }
        return invokeCommon.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 add(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vector3)) == null) ? add(vector3.x, vector3.y, vector3.z) : (Vector3) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clamp */
    public Vector3 m16clamp(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float len2 = len2();
            if (len2 == 0.0f) {
                return this;
            }
            float f3 = f2 * f2;
            if (len2 > f3) {
                return m21scl((float) Math.sqrt(f3 / len2));
            }
            float f4 = f * f;
            return len2 < f4 ? m21scl((float) Math.sqrt(f4 / len2)) : this;
        }
        return (Vector3) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cpy */
    public Vector3 m17cpy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new Vector3(this) : (Vector3) invokeV.objValue;
    }

    public Vector3 crs(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = this.y;
            float f5 = this.z;
            float f6 = (f4 * f3) - (f5 * f2);
            float f7 = this.x;
            return set(f6, (f5 * f) - (f3 * f7), (f7 * f2) - (f4 * f));
        }
        return (Vector3) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public float dot(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, vector3)) == null) ? (this.x * vector3.x) + (this.y * vector3.y) + (this.z * vector3.z) : invokeL.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public float dst2(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, vector3)) == null) {
            float f = vector3.x - this.x;
            float f2 = vector3.y - this.y;
            float f3 = vector3.z - this.z;
            return (f * f) + (f2 * f2) + (f3 * f3);
        }
        return invokeL.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean epsilonEquals(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048598, this, vector3, f)) == null) ? vector3 != null && Math.abs(vector3.x - this.x) <= f && Math.abs(vector3.y - this.y) <= f && Math.abs(vector3.z - this.z) <= f : invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean hasOppositeDirection(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, vector3)) == null) ? dot(vector3) < 0.0f : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean hasSameDirection(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, vector3)) == null) ? dot(vector3) > 0.0f : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 interpolate(Vector3 vector3, float f, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{vector3, Float.valueOf(f), cVar})) == null) ? lerp(vector3, cVar.b(0.0f, 1.0f, f)) : (Vector3) invokeCommon.objValue;
    }

    public boolean isUnit(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048627, this, f)) == null) ? Math.abs(len2() - 1.0f) < f : invokeF.booleanValue;
    }

    public boolean isZero(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048629, this, f)) == null) ? len2() < f : invokeF.booleanValue;
    }

    public float len() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            float f = this.x;
            float f2 = this.y;
            float f3 = (f * f) + (f2 * f2);
            float f4 = this.z;
            return (float) Math.sqrt(f3 + (f4 * f4));
        }
        return invokeV.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 lerp(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048632, this, vector3, f)) == null) {
            float f2 = this.x;
            this.x = f2 + ((vector3.x - f2) * f);
            float f3 = this.y;
            this.y = f3 + ((vector3.y - f3) * f);
            float f4 = this.z;
            this.z = f4 + (f * (vector3.z - f4));
            return this;
        }
        return (Vector3) invokeLF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: limit */
    public Vector3 m18limit(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048634, this, f)) == null) ? m19limit2(f * f) : (Vector3) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: limit2 */
    public Vector3 m19limit2(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048636, this, f)) == null) {
            float len2 = len2();
            if (len2 > f) {
                m21scl((float) Math.sqrt(f / len2));
            }
            return this;
        }
        return (Vector3) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: nor */
    public Vector3 m20nor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            float len2 = len2();
            return (len2 == 0.0f || len2 == 1.0f) ? this : m21scl(1.0f / ((float) Math.sqrt(len2)));
        }
        return (Vector3) invokeV.objValue;
    }

    public Vector3 rotate(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048651, this, vector3, f)) == null) {
            tmpMat.setToRotation(vector3, f);
            return mul(tmpMat);
        }
        return (Vector3) invokeLF.objValue;
    }

    public Vector3 rotateRad(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048653, this, vector3, f)) == null) {
            tmpMat.setToRotationRad(vector3, f);
            return mul(tmpMat);
        }
        return (Vector3) invokeLF.objValue;
    }

    public Vector3 set(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048659, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.x = f;
            this.y = f2;
            this.z = f3;
            return this;
        }
        return (Vector3) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setLength */
    public Vector3 m22setLength(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048665, this, f)) == null) ? m23setLength2(f * f) : (Vector3) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setLength2 */
    public Vector3 m23setLength2(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048667, this, f)) == null) {
            float len2 = len2();
            return (len2 == 0.0f || len2 == f) ? this : m21scl((float) Math.sqrt(f / len2));
        }
        return (Vector3) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setToRandomDirection */
    public Vector3 m24setToRandomDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? setFromSpherical(d.k() * 6.2831855f, (float) Math.acos((d.k() * 2.0f) - 1.0f)) : (Vector3) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setZero */
    public Vector3 m25setZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            return this;
        }
        return (Vector3) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 sub(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, vector3)) == null) ? sub(vector3.x, vector3.y, vector3.z) : (Vector3) invokeL.objValue;
    }

    public Vector3 add(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? set(this.x + f, this.y + f2, this.z + f3) : (Vector3) invokeCommon.objValue;
    }

    public float dot(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (this.x * f) + (this.y * f2) + (this.z * f3) : invokeCommon.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public float dst(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, vector3)) == null) {
            float f = vector3.x - this.x;
            float f2 = vector3.y - this.y;
            float f3 = vector3.z - this.z;
            return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        }
        return invokeL.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinear(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048611, this, vector3, f)) == null) ? isOnLine(vector3, f) && hasSameDirection(vector3) : invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinearOpposite(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048615, this, vector3, f)) == null) ? isOnLine(vector3, f) && hasOppositeDirection(vector3) : invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isOnLine(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048619, this, vector3, f)) == null) {
            float f2 = this.y;
            float f3 = vector3.z;
            float f4 = this.z;
            float f5 = vector3.y;
            float f6 = (f2 * f3) - (f4 * f5);
            float f7 = vector3.x;
            float f8 = this.x;
            return len2(f6, (f4 * f7) - (f3 * f8), (f8 * f5) - (f2 * f7)) <= f;
        }
        return invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isPerpendicular(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, vector3)) == null) ? d.h(dot(vector3)) : invokeL.booleanValue;
    }

    public Vector3 mul(Matrix3 matrix3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, matrix3)) == null) {
            float[] fArr = matrix3.val;
            float f = this.x;
            float f2 = this.y;
            float f3 = (fArr[0] * f) + (fArr[3] * f2);
            float f4 = this.z;
            return set(f3 + (fArr[6] * f4), (fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f4), (f * fArr[2]) + (f2 * fArr[5]) + (f4 * fArr[8]));
        }
        return (Vector3) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 mulAdd(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048642, this, vector3, f)) == null) {
            this.x += vector3.x * f;
            this.y += vector3.y * f;
            this.z += vector3.z * f;
            return this;
        }
        return (Vector3) invokeLF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: scl */
    public Vector3 m21scl(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048654, this, f)) == null) ? set(this.x * f, this.y * f, this.z * f) : (Vector3) invokeF.objValue;
    }

    public Vector3 sub(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048675, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? set(this.x - f, this.y - f2, this.z - f3) : (Vector3) invokeCommon.objValue;
    }

    public Vector3 traMul(Matrix3 matrix3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, matrix3)) == null) {
            float[] fArr = matrix3.val;
            float f = this.x;
            float f2 = this.y;
            float f3 = (fArr[0] * f) + (fArr[1] * f2);
            float f4 = this.z;
            return set(f3 + (fArr[2] * f4), (fArr[3] * f) + (fArr[4] * f2) + (fArr[5] * f4), (f * fArr[6]) + (f2 * fArr[7]) + (f4 * fArr[8]));
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3(Vector3 vector3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        set(vector3);
    }

    public Vector3 add(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) ? set(this.x + f, this.y + f, this.z + f) : (Vector3) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinear(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, vector3)) == null) ? isOnLine(vector3) && hasSameDirection(vector3) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinearOpposite(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, vector3)) == null) ? isOnLine(vector3) && hasOppositeDirection(vector3) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isOnLine(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, vector3)) == null) {
            float f = this.y;
            float f2 = vector3.z;
            float f3 = this.z;
            float f4 = vector3.y;
            float f5 = (f * f2) - (f3 * f4);
            float f6 = vector3.x;
            float f7 = this.x;
            return len2(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6)) <= 1.0E-6f;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isPerpendicular(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048623, this, vector3, f)) == null) ? d.i(dot(vector3), f) : invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 scl(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, vector3)) == null) ? set(this.x * vector3.x, this.y * vector3.y, this.z * vector3.z) : (Vector3) invokeL.objValue;
    }

    public Vector3 sub(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048674, this, f)) == null) ? set(this.x - f, this.y - f, this.z - f) : (Vector3) invokeF.objValue;
    }

    public float dst2(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = f - this.x;
            float f5 = f2 - this.y;
            float f6 = f3 - this.z;
            return (f4 * f4) + (f5 * f5) + (f6 * f6);
        }
        return invokeCommon.floatValue;
    }

    public boolean epsilonEquals(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.abs(f - this.x) <= f4 && Math.abs(f2 - this.y) <= f4 && Math.abs(f3 - this.z) <= f4 : invokeCommon.booleanValue;
    }

    public Vector3 mul(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, quaternion)) == null) ? quaternion.transform(this) : (Vector3) invokeL.objValue;
    }

    public Vector3 scl(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048655, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? set(this.x * f, this.y * f2, this.z * f3) : (Vector3) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 set(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, vector3)) == null) ? set(vector3.x, vector3.y, vector3.z) : (Vector3) invokeL.objValue;
    }

    public Vector3(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fArr};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        set(fArr[0], fArr[1], fArr[2]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 mulAdd(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048643, this, vector3, vector32)) == null) {
            this.x += vector3.x * vector32.x;
            this.y += vector3.y * vector32.y;
            this.z += vector3.z * vector32.z;
            return this;
        }
        return (Vector3) invokeLL.objValue;
    }

    public Vector3 set(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, fArr)) == null) ? set(fArr[0], fArr[1], fArr[2]) : (Vector3) invokeL.objValue;
    }

    public float dst(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = f - this.x;
            float f5 = f2 - this.y;
            float f6 = f3 - this.z;
            return (float) Math.sqrt((f4 * f4) + (f5 * f5) + (f6 * f6));
        }
        return invokeCommon.floatValue;
    }

    public Vector3 set(Vector2 vector2, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048660, this, vector2, f)) == null) ? set(vector2.x, vector2.y, f) : (Vector3) invokeLF.objValue;
    }

    public Vector3(Vector2 vector2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector2, Float.valueOf(f)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        set(vector2.x, vector2.y, f);
    }

    public boolean epsilonEquals(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, vector3)) == null) ? epsilonEquals(vector3, 1.0E-6f) : invokeL.booleanValue;
    }

    public boolean epsilonEquals(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? epsilonEquals(f, f2, f3, 1.0E-6f) : invokeCommon.booleanValue;
    }
}
