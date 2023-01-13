package com.baidu.ar.arplay.representation;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Number3D {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    public static Number3D _temp;
    public transient /* synthetic */ FieldHolder $fh;
    public float x;
    public float y;
    public float z;

    /* renamed from: com.baidu.ar.arplay.representation.Number3D$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$arplay$representation$Number3D$Axis;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-631428020, "Lcom/baidu/ar/arplay/representation/Number3D$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-631428020, "Lcom/baidu/ar/arplay/representation/Number3D$1;");
                    return;
                }
            }
            int[] iArr = new int[Axis.values().length];
            $SwitchMap$com$baidu$ar$arplay$representation$Number3D$Axis = iArr;
            try {
                iArr[Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$representation$Number3D$Axis[Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$representation$Number3D$Axis[Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Axis {
        public static final /* synthetic */ Axis[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Axis X;
        public static final Axis Y;
        public static final Axis Z;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1101310776, "Lcom/baidu/ar/arplay/representation/Number3D$Axis;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1101310776, "Lcom/baidu/ar/arplay/representation/Number3D$Axis;");
                    return;
                }
            }
            X = new Axis("X", 0);
            Y = new Axis("Y", 1);
            Axis axis = new Axis("Z", 2);
            Z = axis;
            $VALUES = new Axis[]{X, Y, axis};
        }

        public Axis(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Axis valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Axis) Enum.valueOf(Axis.class, str) : (Axis) invokeL.objValue;
        }

        public static Axis[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Axis[]) $VALUES.clone() : (Axis[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(508839609, "Lcom/baidu/ar/arplay/representation/Number3D;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(508839609, "Lcom/baidu/ar/arplay/representation/Number3D;");
                return;
            }
        }
        _temp = new Number3D();
    }

    public Number3D() {
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
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }

    public Number3D(double d, double d2, double d3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = (float) d;
        this.y = (float) d2;
        this.z = (float) d3;
    }

    public Number3D(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public Number3D(Number3D number3D) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {number3D};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.x = number3D.x;
        this.y = number3D.y;
        this.z = number3D.z;
    }

    public Number3D(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        if (strArr.length != 3) {
            Log.e(Number3D.class.getSimpleName(), "Number3D should be initialized with 3 values");
        }
        try {
            this.x = Float.parseFloat(strArr[0]);
            this.y = Float.parseFloat(strArr[1]);
            this.z = Float.parseFloat(strArr[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static Number3D add(Number3D number3D, Number3D number3D2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, number3D, number3D2)) == null) ? new Number3D(number3D.x + number3D2.x, number3D.y + number3D2.y, number3D.z + number3D2.z) : (Number3D) invokeLL.objValue;
    }

    public static Number3D cross(Number3D number3D, Number3D number3D2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, number3D, number3D2)) == null) {
            float f = number3D2.y;
            float f2 = number3D.z;
            float f3 = number3D2.z;
            float f4 = number3D.y;
            float f5 = number3D.x;
            float f6 = number3D2.x;
            return new Number3D((f * f2) - (f3 * f4), (f3 * f5) - (f2 * f6), (f6 * f4) - (f * f5));
        }
        return (Number3D) invokeLL.objValue;
    }

    public static float dot(Number3D number3D, Number3D number3D2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, number3D, number3D2)) == null) ? (number3D.x * number3D2.x) + (number3D.y * number3D2.y) + (number3D.z * number3D2.z) : invokeLL.floatValue;
    }

    public static Number3D getAxisVector(Axis axis) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, axis)) == null) {
            Number3D number3D = new Number3D();
            int i = AnonymousClass1.$SwitchMap$com$baidu$ar$arplay$representation$Number3D$Axis[axis.ordinal()];
            if (i == 1) {
                number3D.setAll(1.0f, 0.0f, 0.0f);
            } else if (i == 2) {
                number3D.setAll(0.0f, 1.0f, 0.0f);
            } else if (i == 3) {
                number3D.setAll(0.0f, 0.0f, 1.0f);
            }
            return number3D;
        }
        return (Number3D) invokeL.objValue;
    }

    public static Number3D getUpVector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new Number3D(0.0f, 1.0f, 0.0f) : (Number3D) invokeV.objValue;
    }

    public static Number3D lerp(Number3D number3D, Number3D number3D2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{number3D, number3D2, Float.valueOf(f)})) == null) {
            Number3D number3D3 = new Number3D();
            float f2 = number3D.x;
            number3D3.x = f2 + ((number3D2.x - f2) * f);
            float f3 = number3D.y;
            number3D3.y = f3 + ((number3D2.y - f3) * f);
            float f4 = number3D.z;
            number3D3.z = f4 + ((number3D2.z - f4) * f);
            return number3D3;
        }
        return (Number3D) invokeCommon.objValue;
    }

    public static Number3D multiply(Number3D number3D, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65548, null, number3D, f)) == null) ? new Number3D(number3D.x * f, number3D.y * f, number3D.z * f) : (Number3D) invokeLF.objValue;
    }

    public static Number3D multiply(Number3D number3D, Number3D number3D2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, number3D, number3D2)) == null) ? new Number3D(number3D.x * number3D2.x, number3D.y * number3D2.y, number3D.z * number3D2.z) : (Number3D) invokeLL.objValue;
    }

    public static Number3D subtract(Number3D number3D, Number3D number3D2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, number3D, number3D2)) == null) ? new Number3D(number3D.x - number3D2.x, number3D.y - number3D2.y, number3D.z - number3D2.z) : (Number3D) invokeLL.objValue;
    }

    public Number3D add(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.x += f;
            this.y += f2;
            this.z += f3;
            return this;
        }
        return (Number3D) invokeCommon.objValue;
    }

    public Number3D add(Number3D number3D) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, number3D)) == null) {
            this.x += number3D.x;
            this.y += number3D.y;
            this.z += number3D.z;
            return this;
        }
        return (Number3D) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public Number3D m30clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Number3D(this.x, this.y, this.z) : (Number3D) invokeV.objValue;
    }

    public Number3D cross(Number3D number3D) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, number3D)) == null) {
            _temp.setAllFrom(this);
            float f = number3D.y;
            Number3D number3D2 = _temp;
            float f2 = number3D2.z;
            float f3 = number3D.z;
            this.x = (f * f2) - (number3D2.y * f3);
            float f4 = number3D2.x;
            float f5 = number3D.x;
            this.y = (f3 * f4) - (f2 * f5);
            this.z = (f5 * number3D2.y) - (number3D.y * f4);
            return this;
        }
        return (Number3D) invokeL.objValue;
    }

    public float distanceTo(Number3D number3D) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, number3D)) == null) {
            float f = this.x;
            float f2 = number3D.x;
            float f3 = (f - f2) * (f - f2);
            float f4 = this.y;
            float f5 = number3D.y;
            float f6 = this.z;
            float f7 = number3D.z;
            return (float) Math.sqrt(f3 + ((f4 - f5) * (f4 - f5)) + ((f6 - f7) * (f6 - f7)));
        }
        return invokeL.floatValue;
    }

    public float dot(Number3D number3D) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, number3D)) == null) ? (this.x * number3D.x) + (this.y * number3D.y) + (this.z * number3D.z) : invokeL.floatValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            Number3D number3D = obj instanceof Number3D ? (Number3D) obj : null;
            return number3D != null && number3D.x == this.x && number3D.y == this.y && number3D.z == this.z;
        }
        return invokeL.booleanValue;
    }

    public String formatIntToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append((int) this.x);
            stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            stringBuffer.append((int) this.y);
            stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            stringBuffer.append((int) this.z);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public Quaternion getRotationTo(Number3D number3D) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, number3D)) == null) {
            Quaternion quaternion = new Quaternion();
            normalize();
            number3D.normalize();
            float dot = dot(this, number3D);
            if (dot >= 1.0f) {
                quaternion.loadIdentityQuat();
            }
            if (dot < -0.999999f) {
                Number3D cross = cross(getAxisVector(Axis.X), this);
                if (cross.length() == 0.0f) {
                    cross = cross(getAxisVector(Axis.Y), this);
                }
                cross.normalize();
                quaternion.setAxisAngle(new Vector3f(cross.x, cross.y, cross.z), (float) Math.toDegrees(3.141592653589793d));
            } else {
                double sqrt = Math.sqrt((dot + 1.0f) * 2.0f);
                double d = 1.0d / sqrt;
                Number3D cross2 = cross(this, number3D);
                float[] fArr = quaternion.points;
                fArr[0] = (float) (cross2.x * d);
                fArr[1] = (float) (cross2.y * d);
                fArr[2] = (float) (cross2.z * d);
                fArr[3] = (float) (sqrt * 0.5d);
                quaternion.normalize();
            }
            return quaternion;
        }
        return (Quaternion) invokeL.objValue;
    }

    public Number3D inverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new Number3D(-this.x, -this.y, -this.z) : (Number3D) invokeV.objValue;
    }

    public float length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            float f = this.x;
            float f2 = this.y;
            float f3 = (f * f) + (f2 * f2);
            float f4 = this.z;
            return (float) Math.sqrt(f3 + (f4 * f4));
        }
        return invokeV.floatValue;
    }

    public void lerpSelf(Number3D number3D, Number3D number3D2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{number3D, number3D2, Float.valueOf(f)}) == null) {
            float f2 = number3D.x;
            this.x = f2 + ((number3D2.x - f2) * f);
            float f3 = number3D.y;
            this.y = f3 + ((number3D2.y - f3) * f);
            float f4 = number3D.z;
            this.z = f4 + ((number3D2.z - f4) * f);
        }
    }

    public Number3D multiply(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f)) == null) {
            this.x *= f;
            this.y *= f;
            this.z *= f;
            return this;
        }
        return (Number3D) invokeF.objValue;
    }

    public void multiply(Number3D number3D) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, number3D) == null) {
            this.x *= number3D.x;
            this.y *= number3D.y;
            this.z *= number3D.z;
        }
    }

    public void multiply(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fArr) == null) {
            float f = this.x;
            float f2 = this.y;
            float f3 = this.z;
            this.x = (fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f3) + fArr[12];
            this.y = (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f3) + fArr[13];
            this.z = (f * fArr[2]) + (f2 * fArr[6]) + (f3 * fArr[10]) + fArr[14];
        }
    }

    public float normalize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            float f = this.x;
            float f2 = this.y;
            float f3 = (f * f) + (f2 * f2);
            float f4 = this.z;
            double sqrt = Math.sqrt(f3 + (f4 * f4));
            if (sqrt != 0.0d && sqrt != 1.0d) {
                sqrt = 1.0d / sqrt;
                this.x = (float) (this.x * sqrt);
                this.y = (float) (this.y * sqrt);
                this.z = (float) (this.z * sqrt);
            }
            return (float) sqrt;
        }
        return invokeV.floatValue;
    }

    public void project(float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, fArr) == null) || fArr == null || fArr.length <= 15) {
            return;
        }
        float f = this.x;
        float f2 = this.y;
        float f3 = (fArr[3] * f) + (fArr[7] * f2);
        float f4 = this.z;
        float f5 = f3 + (fArr[11] * f4) + fArr[15];
        setAll(((((fArr[0] * f) + (fArr[4] * f2)) + (fArr[8] * f4)) + fArr[12]) / f5, ((((fArr[1] * f) + (fArr[5] * f2)) + (fArr[9] * f4)) + fArr[13]) / f5, ((((f * fArr[2]) + (f2 * fArr[6])) + (f4 * fArr[10])) + fArr[14]) / f5);
    }

    public void rotateX(float f) {
        Number3D number3D;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f) == null) {
            double d = f;
            double cos = Math.cos(d);
            double sin = Math.sin(d);
            _temp.setAll(this.x, this.y, this.z);
            float f2 = _temp.z;
            this.y = (float) ((number3D.y * cos) - (f2 * sin));
            this.z = (float) ((number3D.y * sin) + (f2 * cos));
        }
    }

    public void rotateY(float f) {
        Number3D number3D;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f) == null) {
            double d = f;
            double cos = Math.cos(d);
            double sin = Math.sin(d);
            _temp.setAll(this.x, this.y, this.z);
            float f2 = _temp.z;
            this.x = (float) ((number3D.x * cos) + (f2 * sin));
            this.z = (float) ((number3D.x * (-sin)) + (f2 * cos));
        }
    }

    public void rotateZ(float f) {
        Number3D number3D;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f) == null) {
            double d = f;
            double cos = Math.cos(d);
            double sin = Math.sin(d);
            _temp.setAll(this.x, this.y, this.z);
            float f2 = _temp.y;
            this.x = (float) ((number3D.x * cos) - (f2 * sin));
            this.y = (float) ((number3D.x * sin) + (f2 * cos));
        }
    }

    public void setAll(double d, double d2, double d3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)}) == null) {
            this.x = (float) d;
            this.y = (float) d2;
            this.z = (float) d3;
        }
    }

    public void setAll(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.x = f;
            this.y = f2;
            this.z = f3;
        }
    }

    public void setAllFrom(Number3D number3D) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, number3D) == null) {
            this.x = number3D.x;
            this.y = number3D.y;
            this.z = number3D.z;
        }
    }

    public Number3D subtract(Number3D number3D) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, number3D)) == null) {
            this.x -= number3D.x;
            this.y -= number3D.y;
            this.z -= number3D.z;
            return this;
        }
        return (Number3D) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.x);
            stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            stringBuffer.append(this.y);
            stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            stringBuffer.append(this.z);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
