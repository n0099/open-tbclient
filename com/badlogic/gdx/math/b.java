package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Random;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static Random a;
    public transient /* synthetic */ FieldHolder $fh;

    public static float b(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f < f2 ? f2 : f > f3 ? f3 : f : invokeCommon.floatValue;
    }

    public static int i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            if (i == 0) {
                return 1;
            }
            int i2 = i - 1;
            int i3 = i2 | (i2 >> 1);
            int i4 = i3 | (i3 >> 2);
            int i5 = i4 | (i4 >> 4);
            int i6 = i5 | (i5 >> 8);
            return (i6 | (i6 >> 16)) + 1;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final float[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            float f;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1361004333, "Lcom/badlogic/gdx/math/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1361004333, "Lcom/badlogic/gdx/math/b$a;");
                    return;
                }
            }
            a = new float[16384];
            for (int i = 0; i < 16384; i++) {
                a[i] = (float) Math.sin(((i + 0.5f) / 16384.0f) * 6.2831855f);
            }
            for (int i2 = 0; i2 < 360; i2 += 90) {
                a[((int) (45.511112f * i2)) & 16383] = (float) Math.sin(f * 0.017453292f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(950538032, "Lcom/badlogic/gdx/math/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(950538032, "Lcom/badlogic/gdx/math/b;");
                return;
            }
        }
        a = new RandomXS128();
    }

    public static float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return a.nextFloat();
        }
        return invokeV.floatValue;
    }

    public static float a(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (f2 == 0.0f) {
                int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i > 0) {
                    return 1.5707964f;
                }
                if (i == 0) {
                    return 0.0f;
                }
                return -1.5707964f;
            }
            float f3 = f / f2;
            float f4 = 3.1415927f;
            if (Math.abs(f3) < 1.0f) {
                float f5 = f3 / (((0.28f * f3) * f3) + 1.0f);
                if (f2 < 0.0f) {
                    if (f < 0.0f) {
                        f4 = -3.1415927f;
                    }
                    return f5 + f4;
                }
                return f5;
            }
            float f6 = 1.5707964f - (f3 / ((f3 * f3) + 0.28f));
            if (f < 0.0f) {
                return f6 - 3.1415927f;
            }
            return f6;
        }
        return invokeCommon.floatValue;
    }

    public static float c(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f)) == null) {
            return a.a[((int) ((f + 1.5707964f) * 2607.5945f)) & 16383];
        }
        return invokeF.floatValue;
    }

    public static float d(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f)) == null) {
            return a.a[((int) ((f + 90.0f) * 45.511112f)) & 16383];
        }
        return invokeF.floatValue;
    }

    public static boolean g(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65543, null, f)) == null) {
            if (Math.abs(f) <= 1.0E-6f) {
                return true;
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    public static float l(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65548, null, f)) == null) {
            return a.a[((int) (f * 2607.5945f)) & 16383];
        }
        return invokeF.floatValue;
    }

    public static float m(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65549, null, f)) == null) {
            return a.a[((int) (f * 45.511112f)) & 16383];
        }
        return invokeF.floatValue;
    }

    public static boolean e(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (Math.abs(f - f2) <= 1.0E-6f) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean f(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (Math.abs(f - f2) <= f3) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean h(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (Math.abs(f) <= f2) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static float k(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return f + (a.nextFloat() * (f2 - f));
        }
        return invokeCommon.floatValue;
    }
}
