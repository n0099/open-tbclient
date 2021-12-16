package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Random;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static Random a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final float[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            float f2;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1360944751, "Lcom/badlogic/gdx/math/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1360944751, "Lcom/badlogic/gdx/math/d$a;");
                    return;
                }
            }
            a = new float[16384];
            for (int i2 = 0; i2 < 16384; i2++) {
                a[i2] = (float) Math.sin(((i2 + 0.5f) / 16384.0f) * 6.2831855f);
            }
            for (int i3 = 0; i3 < 360; i3 += 90) {
                a[((int) (45.511112f * i3)) & 16383] = (float) Math.sin(f2 * 0.017453292f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(950538094, "Lcom/badlogic/gdx/math/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(950538094, "Lcom/badlogic/gdx/math/d;");
                return;
            }
        }
        a = new RandomXS128();
    }

    public static float a(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f3 == 0.0f) {
                int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i2 > 0) {
                    return 1.5707964f;
                }
                return i2 == 0 ? 0.0f : -1.5707964f;
            }
            float f4 = f2 / f3;
            if (Math.abs(f4) >= 1.0f) {
                float f5 = 1.5707964f - (f4 / ((f4 * f4) + 0.28f));
                return f2 < 0.0f ? f5 - 3.1415927f : f5;
            }
            float f6 = f4 / (((0.28f * f4) * f4) + 1.0f);
            if (f3 < 0.0f) {
                return f6 + (f2 < 0.0f ? -3.1415927f : 3.1415927f);
            }
            return f6;
        }
        return invokeCommon.floatValue;
    }

    public static float b(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 < f3 ? f3 : f2 > f4 ? f4 : f2 : invokeCommon.floatValue;
    }

    public static float c(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f2)) == null) ? a.a[((int) ((f2 + 1.5707964f) * 2607.5945f)) & 16383] : invokeF.floatValue;
    }

    public static float d(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f2)) == null) ? a.a[((int) ((f2 + 90.0f) * 45.511112f)) & 16383] : invokeF.floatValue;
    }

    public static boolean e(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? Math.abs(f2 - f3) <= 1.0E-6f : invokeCommon.booleanValue;
    }

    public static boolean f(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? Math.abs(f2 - f3) <= f4 : invokeCommon.booleanValue;
    }

    public static boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? i2 != 0 && (i2 & (i2 + (-1))) == 0 : invokeI.booleanValue;
    }

    public static boolean h(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65544, null, f2)) == null) ? Math.abs(f2) <= 1.0E-6f : invokeF.booleanValue;
    }

    public static boolean i(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? Math.abs(f2) <= f3 : invokeCommon.booleanValue;
    }

    public static int j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            if (i2 == 0) {
                return 1;
            }
            int i3 = i2 - 1;
            int i4 = i3 | (i3 >> 1);
            int i5 = i4 | (i4 >> 2);
            int i6 = i5 | (i5 >> 4);
            int i7 = i6 | (i6 >> 8);
            return (i7 | (i7 >> 16)) + 1;
        }
        return invokeI.intValue;
    }

    public static float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a.nextFloat() : invokeV.floatValue;
    }

    public static float l(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65548, null, f2)) == null) ? a.nextFloat() * f2 : invokeF.floatValue;
    }

    public static float m(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f2 + (a.nextFloat() * (f3 - f2)) : invokeCommon.floatValue;
    }

    public static int n(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65550, null, i2, i3)) == null) ? i2 + a.nextInt((i3 - i2) + 1) : invokeII.intValue;
    }

    public static float o(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65551, null, f2)) == null) ? a.a[((int) (f2 * 2607.5945f)) & 16383] : invokeF.floatValue;
    }

    public static float p(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65552, null, f2)) == null) ? a.a[((int) (f2 * 45.511112f)) & 16383] : invokeF.floatValue;
    }
}
