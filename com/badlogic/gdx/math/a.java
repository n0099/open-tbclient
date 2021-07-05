package com.badlogic.gdx.math;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Random;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(950538001, "Lcom/badlogic/gdx/math/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(950538001, "Lcom/badlogic/gdx/math/a;");
                return;
            }
        }
        new Random();
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

    public static boolean c(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? Math.abs(f2 - f3) <= 1.0E-6f : invokeCommon.booleanValue;
    }
}
