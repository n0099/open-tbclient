package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.t;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class Vector2 implements Serializable, e<Vector2> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Vector2 X;
    public static final Vector2 Y;
    public static final Vector2 Zero;
    public static final long serialVersionUID = 913902788239530931L;
    public transient /* synthetic */ FieldHolder $fh;
    public float x;
    public float y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(34217155, "Lcom/badlogic/gdx/math/Vector2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(34217155, "Lcom/badlogic/gdx/math/Vector2;");
                return;
            }
        }
        X = new Vector2(1.0f, 0.0f);
        Y = new Vector2(0.0f, 1.0f);
        Zero = new Vector2(0.0f, 0.0f);
    }

    public Vector2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static float dot(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (f2 * f4) + (f3 * f5) : invokeCommon.floatValue;
    }

    public static float dst2(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = f4 - f2;
            float f7 = f5 - f3;
            return (f6 * f6) + (f7 * f7);
        }
        return invokeCommon.floatValue;
    }

    public static float len(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (float) Math.sqrt((f2 * f2) + (f3 * f3)) : invokeCommon.floatValue;
    }

    public static float len2(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (f2 * f2) + (f3 * f3) : invokeCommon.floatValue;
    }

    @Deprecated
    public float angle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float atan2 = ((float) Math.atan2(this.y, this.x)) * 57.295776f;
            return atan2 < 0.0f ? atan2 + 360.0f : atan2;
        }
        return invokeV.floatValue;
    }

    public float angleDeg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float atan2 = ((float) Math.atan2(this.y, this.x)) * 57.295776f;
            return atan2 < 0.0f ? atan2 + 360.0f : atan2;
        }
        return invokeV.floatValue;
    }

    public float angleRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (float) Math.atan2(this.y, this.x) : invokeV.floatValue;
    }

    public float crs(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, vector2)) == null) ? (this.x * vector2.y) - (this.y * vector2.x) : invokeL.floatValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Vector2.class == obj.getClass()) {
                Vector2 vector2 = (Vector2) obj;
                return t.a(this.x) == t.a(vector2.x) && t.a(this.y) == t.a(vector2.y);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Vector2 fromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            int indexOf = str.indexOf(44, 1);
            if (indexOf != -1 && str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
                try {
                    return set(Float.parseFloat(str.substring(1, indexOf)), Float.parseFloat(str.substring(indexOf + 1, str.length() - 1)));
                } catch (NumberFormatException unused) {
                }
            }
            throw new GdxRuntimeException("Malformed Vector2: " + str);
        }
        return (Vector2) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? ((t.a(this.x) + 31) * 31) + t.a(this.y) : invokeV.intValue;
    }

    public boolean isUnit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? isUnit(1.0E-9f) : invokeV.booleanValue;
    }

    public boolean isZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.x == 0.0f && this.y == 0.0f : invokeV.booleanValue;
    }

    public float len2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            float f2 = this.x;
            float f3 = this.y;
            return (f2 * f2) + (f3 * f3);
        }
        return invokeV.floatValue;
    }

    public Vector2 mul(Matrix3 matrix3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, matrix3)) == null) {
            float f2 = this.x;
            float[] fArr = matrix3.val;
            float f3 = this.y;
            this.x = (fArr[0] * f2) + (fArr[3] * f3) + fArr[6];
            this.y = (f2 * fArr[1]) + (f3 * fArr[4]) + fArr[7];
            return this;
        }
        return (Vector2) invokeL.objValue;
    }

    @Deprecated
    public Vector2 rotate(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048649, this, f2)) == null) ? rotateRad(f2 * 0.017453292f) : (Vector2) invokeF.objValue;
    }

    public Vector2 rotate90(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i2)) == null) {
            float f2 = this.x;
            if (i2 >= 0) {
                this.x = -this.y;
                this.y = f2;
            } else {
                this.x = this.y;
                this.y = -f2;
            }
            return this;
        }
        return (Vector2) invokeI.objValue;
    }

    @Deprecated
    public Vector2 rotateAround(Vector2 vector2, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048651, this, vector2, f2)) == null) ? sub(vector2).rotateDeg(f2).add(vector2) : (Vector2) invokeLF.objValue;
    }

    public Vector2 rotateAroundDeg(Vector2 vector2, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048652, this, vector2, f2)) == null) ? sub(vector2).rotateDeg(f2).add(vector2) : (Vector2) invokeLF.objValue;
    }

    public Vector2 rotateAroundRad(Vector2 vector2, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048653, this, vector2, f2)) == null) ? sub(vector2).rotateRad(f2).add(vector2) : (Vector2) invokeLF.objValue;
    }

    public Vector2 rotateDeg(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048654, this, f2)) == null) ? rotateRad(f2 * 0.017453292f) : (Vector2) invokeF.objValue;
    }

    public Vector2 rotateRad(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048655, this, f2)) == null) {
            double d2 = f2;
            float cos = (float) Math.cos(d2);
            float sin = (float) Math.sin(d2);
            float f3 = this.x;
            float f4 = this.y;
            this.x = (f3 * cos) - (f4 * sin);
            this.y = (f3 * sin) + (f4 * cos);
            return this;
        }
        return (Vector2) invokeF.objValue;
    }

    @Deprecated
    public Vector2 setAngle(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048664, this, f2)) == null) ? setAngleRad(f2 * 0.017453292f) : (Vector2) invokeF.objValue;
    }

    public Vector2 setAngleDeg(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048665, this, f2)) == null) ? setAngleRad(f2 * 0.017453292f) : (Vector2) invokeF.objValue;
    }

    public Vector2 setAngleRad(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048666, this, f2)) == null) {
            set(len(), 0.0f);
            rotateRad(f2);
            return this;
        }
        return (Vector2) invokeF.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return "(" + this.x + "," + this.y + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public Vector2(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = f2;
        this.y = f3;
    }

    public static float dst(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = f4 - f2;
            float f7 = f5 - f3;
            return (float) Math.sqrt((f6 * f6) + (f7 * f7));
        }
        return invokeCommon.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector2 add(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vector2)) == null) {
            this.x += vector2.x;
            this.y += vector2.y;
            return this;
        }
        return (Vector2) invokeL.objValue;
    }

    @Deprecated
    public float angle(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vector2)) == null) ? ((float) Math.atan2(crs(vector2), dot(vector2))) * 57.295776f : invokeL.floatValue;
    }

    public float angleDeg(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vector2)) == null) {
            float atan2 = ((float) Math.atan2(vector2.crs(this), vector2.dot(this))) * 57.295776f;
            return atan2 < 0.0f ? atan2 + 360.0f : atan2;
        }
        return invokeL.floatValue;
    }

    public float angleRad(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vector2)) == null) ? (float) Math.atan2(vector2.crs(this), vector2.dot(this)) : invokeL.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clamp */
    public Vector2 m8clamp(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float len2 = len2();
            if (len2 == 0.0f) {
                return this;
            }
            float f4 = f3 * f3;
            if (len2 > f4) {
                return m13scl((float) Math.sqrt(f4 / len2));
            }
            float f5 = f2 * f2;
            return len2 < f5 ? m13scl((float) Math.sqrt(f5 / len2)) : this;
        }
        return (Vector2) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cpy */
    public Vector2 m9cpy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new Vector2(this) : (Vector2) invokeV.objValue;
    }

    public float crs(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (this.x * f3) - (this.y * f2) : invokeCommon.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public float dot(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, vector2)) == null) ? (this.x * vector2.x) + (this.y * vector2.y) : invokeL.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public float dst2(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, vector2)) == null) {
            float f2 = vector2.x - this.x;
            float f3 = vector2.y - this.y;
            return (f2 * f2) + (f3 * f3);
        }
        return invokeL.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean epsilonEquals(Vector2 vector2, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048603, this, vector2, f2)) == null) ? vector2 != null && Math.abs(vector2.x - this.x) <= f2 && Math.abs(vector2.y - this.y) <= f2 : invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean hasOppositeDirection(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, vector2)) == null) ? dot(vector2) < 0.0f : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean hasSameDirection(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, vector2)) == null) ? dot(vector2) > 0.0f : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector2 interpolate(Vector2 vector2, float f2, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{vector2, Float.valueOf(f2), cVar})) == null) ? lerp(vector2, cVar.a(f2)) : (Vector2) invokeCommon.objValue;
    }

    public boolean isUnit(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048631, this, f2)) == null) ? Math.abs(len2() - 1.0f) < f2 : invokeF.booleanValue;
    }

    public boolean isZero(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048633, this, f2)) == null) ? len2() < f2 : invokeF.booleanValue;
    }

    public float len() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            float f2 = this.x;
            float f3 = this.y;
            return (float) Math.sqrt((f2 * f2) + (f3 * f3));
        }
        return invokeV.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector2 lerp(Vector2 vector2, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048636, this, vector2, f2)) == null) {
            float f3 = 1.0f - f2;
            this.x = (this.x * f3) + (vector2.x * f2);
            this.y = (this.y * f3) + (vector2.y * f2);
            return this;
        }
        return (Vector2) invokeLF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: limit */
    public Vector2 m10limit(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048638, this, f2)) == null) ? m11limit2(f2 * f2) : (Vector2) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: limit2 */
    public Vector2 m11limit2(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048640, this, f2)) == null) {
            float len2 = len2();
            return len2 > f2 ? m13scl((float) Math.sqrt(f2 / len2)) : this;
        }
        return (Vector2) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: nor */
    public Vector2 m12nor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            float len = len();
            if (len != 0.0f) {
                this.x /= len;
                this.y /= len;
            }
            return this;
        }
        return (Vector2) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector2 set(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, vector2)) == null) {
            this.x = vector2.x;
            this.y = vector2.y;
            return this;
        }
        return (Vector2) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setLength */
    public Vector2 m14setLength(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048667, this, f2)) == null) ? m15setLength2(f2 * f2) : (Vector2) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setLength2 */
    public Vector2 m15setLength2(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048669, this, f2)) == null) {
            float len2 = len2();
            return (len2 == 0.0f || len2 == f2) ? this : m13scl((float) Math.sqrt(f2 / len2));
        }
        return (Vector2) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setToRandomDirection */
    public Vector2 m16setToRandomDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            float m = d.m(0.0f, 6.2831855f);
            return set(d.c(m), d.o(m));
        }
        return (Vector2) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setZero */
    public Vector2 m17setZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            this.x = 0.0f;
            this.y = 0.0f;
            return this;
        }
        return (Vector2) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector2 sub(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, vector2)) == null) {
            this.x -= vector2.x;
            this.y -= vector2.y;
            return this;
        }
        return (Vector2) invokeL.objValue;
    }

    public float dot(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (this.x * f2) + (this.y * f3) : invokeCommon.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public float dst(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, vector2)) == null) {
            float f2 = vector2.x - this.x;
            float f3 = vector2.y - this.y;
            return (float) Math.sqrt((f2 * f2) + (f3 * f3));
        }
        return invokeL.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinear(Vector2 vector2, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048615, this, vector2, f2)) == null) ? isOnLine(vector2, f2) && dot(vector2) > 0.0f : invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinearOpposite(Vector2 vector2, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048619, this, vector2, f2)) == null) ? isOnLine(vector2, f2) && dot(vector2) < 0.0f : invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isOnLine(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, vector2)) == null) ? d.h((this.x * vector2.y) - (this.y * vector2.x)) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isPerpendicular(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, vector2)) == null) ? d.h(dot(vector2)) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector2 mulAdd(Vector2 vector2, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048643, this, vector2, f2)) == null) {
            this.x += vector2.x * f2;
            this.y += vector2.y * f2;
            return this;
        }
        return (Vector2) invokeLF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: scl */
    public Vector2 m13scl(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048656, this, f2)) == null) {
            this.x *= f2;
            this.y *= f2;
            return this;
        }
        return (Vector2) invokeF.objValue;
    }

    public Vector2 add(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.x += f2;
            this.y += f3;
            return this;
        }
        return (Vector2) invokeCommon.objValue;
    }

    public float dst2(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = f2 - this.x;
            float f5 = f3 - this.y;
            return (f4 * f4) + (f5 * f5);
        }
        return invokeCommon.floatValue;
    }

    public boolean epsilonEquals(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.abs(f2 - this.x) <= f4 && Math.abs(f3 - this.y) <= f4 : invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinear(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, vector2)) == null) ? isOnLine(vector2) && dot(vector2) > 0.0f : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinearOpposite(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, vector2)) == null) ? isOnLine(vector2) && dot(vector2) < 0.0f : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isOnLine(Vector2 vector2, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048623, this, vector2, f2)) == null) ? d.i((this.x * vector2.y) - (this.y * vector2.x), f2) : invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isPerpendicular(Vector2 vector2, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048627, this, vector2, f2)) == null) ? d.i(dot(vector2), f2) : invokeLF.booleanValue;
    }

    public Vector2 set(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048661, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.x = f2;
            this.y = f3;
            return this;
        }
        return (Vector2) invokeCommon.objValue;
    }

    public Vector2 sub(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048675, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.x -= f2;
            this.y -= f3;
            return this;
        }
        return (Vector2) invokeCommon.objValue;
    }

    public Vector2(Vector2 vector2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        set(vector2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector2 mulAdd(Vector2 vector2, Vector2 vector22) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048644, this, vector2, vector22)) == null) {
            this.x += vector2.x * vector22.x;
            this.y += vector2.y * vector22.y;
            return this;
        }
        return (Vector2) invokeLL.objValue;
    }

    public Vector2 scl(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048657, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.x *= f2;
            this.y *= f3;
            return this;
        }
        return (Vector2) invokeCommon.objValue;
    }

    public float dst(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = f2 - this.x;
            float f5 = f3 - this.y;
            return (float) Math.sqrt((f4 * f4) + (f5 * f5));
        }
        return invokeCommon.floatValue;
    }

    public boolean epsilonEquals(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, vector2)) == null) ? epsilonEquals(vector2, 1.0E-6f) : invokeL.booleanValue;
    }

    public boolean epsilonEquals(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? epsilonEquals(f2, f3, 1.0E-6f) : invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector2 scl(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, vector2)) == null) {
            this.x *= vector2.x;
            this.y *= vector2.y;
            return this;
        }
        return (Vector2) invokeL.objValue;
    }
}
