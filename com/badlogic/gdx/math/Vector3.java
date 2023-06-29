package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.m7;
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

    public static float len2(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (f * f) + (f2 * f2) + (f3 * f3) : invokeCommon.floatValue;
    }

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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return "(" + this.x + "," + this.y + "," + this.z + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
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

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: cpy */
    public Vector3 m18cpy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new Vector3(this);
        }
        return (Vector3) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return ((((m7.a(this.x) + 31) * 31) + m7.a(this.y)) * 31) + m7.a(this.z);
        }
        return invokeV.intValue;
    }

    public boolean isUnit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return isUnit(1.0E-9f);
        }
        return invokeV.booleanValue;
    }

    public boolean isZero() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.x == 0.0f && this.y == 0.0f && this.z == 0.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: nor */
    public Vector3 m21nor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            float len2 = len2();
            if (len2 != 0.0f && len2 != 1.0f) {
                return m22scl(1.0f / ((float) Math.sqrt(len2)));
            }
            return this;
        }
        return (Vector3) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setToRandomDirection */
    public Vector3 m25setToRandomDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return setFromSpherical(d.k() * 6.2831855f, (float) Math.acos((d.k() * 2.0f) - 1.0f));
        }
        return (Vector3) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setZero */
    public Vector3 m26setZero() {
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

    public static float len(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        }
        return invokeCommon.floatValue;
    }

    public Vector3 add(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return set(this.x + f, this.y + f2, this.z + f3);
        }
        return (Vector3) invokeCommon.objValue;
    }

    public float dot(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return (this.x * f) + (this.y * f2) + (this.z * f3);
        }
        return invokeCommon.floatValue;
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

    public boolean epsilonEquals(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return epsilonEquals(f, f2, f3, 1.0E-6f);
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 interpolate(Vector3 vector3, float f, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{vector3, Float.valueOf(f), cVar})) == null) {
            return lerp(vector3, cVar.b(0.0f, 1.0f, f));
        }
        return (Vector3) invokeCommon.objValue;
    }

    public Vector3 scl(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048655, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return set(this.x * f, this.y * f2, this.z * f3);
        }
        return (Vector3) invokeCommon.objValue;
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

    public Vector3 sub(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048675, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return set(this.x - f, this.y - f2, this.z - f3);
        }
        return (Vector3) invokeCommon.objValue;
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

    /* JADX DEBUG: Method merged with bridge method */
    public boolean epsilonEquals(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048598, this, vector3, f)) == null) {
            if (vector3 == null || Math.abs(vector3.x - this.x) > f || Math.abs(vector3.y - this.y) > f || Math.abs(vector3.z - this.z) > f) {
                return false;
            }
            return true;
        }
        return invokeLF.booleanValue;
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
            if (len2(f6, (f4 * f7) - (f3 * f8), (f8 * f5) - (f2 * f7)) <= f) {
                return true;
            }
            return false;
        }
        return invokeLF.booleanValue;
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
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            return set(this.x + f, this.y + f, this.z + f);
        }
        return (Vector3) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public float dot(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, vector3)) == null) {
            return (this.x * vector3.x) + (this.y * vector3.y) + (this.z * vector3.z);
        }
        return invokeL.floatValue;
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

    public boolean epsilonEquals(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, vector3)) == null) {
            return epsilonEquals(vector3, 1.0E-6f);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean hasOppositeDirection(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, vector3)) == null) {
            if (dot(vector3) < 0.0f) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean hasSameDirection(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, vector3)) == null) {
            if (dot(vector3) > 0.0f) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean idt(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, vector3)) == null) {
            if (this.x == vector3.x && this.y == vector3.y && this.z == vector3.z) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinear(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, vector3)) == null) {
            if (isOnLine(vector3) && hasSameDirection(vector3)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinearOpposite(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, vector3)) == null) {
            if (isOnLine(vector3) && hasOppositeDirection(vector3)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isPerpendicular(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, vector3)) == null) {
            return d.h(dot(vector3));
        }
        return invokeL.booleanValue;
    }

    public boolean isUnit(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048627, this, f)) == null) {
            if (Math.abs(len2() - 1.0f) < f) {
                return true;
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    public boolean isZero(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048629, this, f)) == null) {
            if (len2() < f) {
                return true;
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: limit */
    public Vector3 m19limit(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048634, this, f)) == null) {
            return m20limit2(f * f);
        }
        return (Vector3) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: limit2 */
    public Vector3 m20limit2(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048636, this, f)) == null) {
            float len2 = len2();
            if (len2 > f) {
                m22scl((float) Math.sqrt(f / len2));
            }
            return this;
        }
        return (Vector3) invokeF.objValue;
    }

    public Vector3 mul(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, quaternion)) == null) {
            return quaternion.transform(this);
        }
        return (Vector3) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: scl */
    public Vector3 m22scl(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048654, this, f)) == null) {
            return set(this.x * f, this.y * f, this.z * f);
        }
        return (Vector3) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 set(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, vector3)) == null) {
            return set(vector3.x, vector3.y, vector3.z);
        }
        return (Vector3) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setLength */
    public Vector3 m23setLength(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048665, this, f)) == null) {
            return m24setLength2(f * f);
        }
        return (Vector3) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: setLength2 */
    public Vector3 m24setLength2(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048667, this, f)) == null) {
            float len2 = len2();
            if (len2 != 0.0f && len2 != f) {
                return m22scl((float) Math.sqrt(f / len2));
            }
            return this;
        }
        return (Vector3) invokeF.objValue;
    }

    public Vector3 sub(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048674, this, f)) == null) {
            return set(this.x - f, this.y - f, this.z - f);
        }
        return (Vector3) invokeF.objValue;
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
            if (len2(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6)) <= 1.0E-6f) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vector3)) == null) {
            return add(vector3.x, vector3.y, vector3.z);
        }
        return (Vector3) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 scl(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, vector3)) == null) {
            return set(this.x * vector3.x, this.y * vector3.y, this.z * vector3.z);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 set(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, fArr)) == null) {
            return set(fArr[0], fArr[1], fArr[2]);
        }
        return (Vector3) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Vector3 sub(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, vector3)) == null) {
            return sub(vector3.x, vector3.y, vector3.z);
        }
        return (Vector3) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clamp */
    public Vector3 m17clamp(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float len2 = len2();
            if (len2 == 0.0f) {
                return this;
            }
            float f3 = f2 * f2;
            if (len2 > f3) {
                return m22scl((float) Math.sqrt(f3 / len2));
            }
            float f4 = f * f;
            if (len2 < f4) {
                return m22scl((float) Math.sqrt(f4 / len2));
            }
            return this;
        }
        return (Vector3) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinear(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048611, this, vector3, f)) == null) {
            if (isOnLine(vector3, f) && hasSameDirection(vector3)) {
                return true;
            }
            return false;
        }
        return invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isCollinearOpposite(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048615, this, vector3, f)) == null) {
            if (isOnLine(vector3, f) && hasOppositeDirection(vector3)) {
                return true;
            }
            return false;
        }
        return invokeLF.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public boolean isPerpendicular(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048623, this, vector3, f)) == null) {
            return d.i(dot(vector3), f);
        }
        return invokeLF.booleanValue;
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

    public Vector3 set(Vector2 vector2, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048660, this, vector2, f)) == null) {
            return set(vector2.x, vector2.y, f);
        }
        return (Vector3) invokeLF.objValue;
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

    public boolean epsilonEquals(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (Math.abs(f - this.x) > f4 || Math.abs(f2 - this.y) > f4 || Math.abs(f3 - this.z) > f4) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Vector3.class != obj.getClass()) {
                return false;
            }
            Vector3 vector3 = (Vector3) obj;
            if (m7.a(this.x) == m7.a(vector3.x) && m7.a(this.y) == m7.a(vector3.y) && m7.a(this.z) == m7.a(vector3.z)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
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

    public Vector3 rotate(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048650, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            return mul(tmpMat.setToRotation(f2, f3, f4, f));
        }
        return (Vector3) invokeCommon.objValue;
    }

    public Vector3 rotateRad(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048652, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            return mul(tmpMat.setToRotationRad(f2, f3, f4, f));
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
                float f6 = 1.0f;
                if (f5 >= 1.0E-4f) {
                    f6 = 1.0f / ((float) Math.sqrt(f5));
                }
                float f7 = sin * f6;
                return m22scl((float) Math.cos(acos)).add(f2 * f7, f3 * f7, f4 * f7).m21nor();
            }
            return lerp(vector3, f);
        }
        return (Vector3) invokeLF.objValue;
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
}
