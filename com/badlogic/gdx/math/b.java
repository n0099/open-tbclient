package com.badlogic.gdx.math;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
        new Vector2();
        new Vector2();
        new Vector2();
    }

    public static boolean a(float[] fArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, fArr, i2, i3)) == null) {
            if (i3 <= 2) {
                return false;
            }
            int i4 = (i3 + i2) - 2;
            float f2 = fArr[i4];
            float f3 = fArr[i4 + 1];
            float f4 = 0.0f;
            while (i2 <= i4) {
                float f5 = fArr[i2];
                float f6 = fArr[i2 + 1];
                f4 += (f2 * f6) - (f3 * f5);
                i2 += 2;
                f2 = f5;
                f3 = f6;
            }
            return f4 < 0.0f;
        }
        return invokeLII.booleanValue;
    }
}
