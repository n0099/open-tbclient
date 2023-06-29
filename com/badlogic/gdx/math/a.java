package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e7;
import com.baidu.tieba.y7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y7 a;
    public short[] b;
    public float[] c;
    public int d;
    public final e7 e;
    public final y7 f;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new y7();
        this.e = new e7();
        this.f = new y7();
    }

    public static int b(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            return (int) Math.signum((f * (f6 - f4)) + (f3 * (f2 - f6)) + (f5 * (f4 - f2)));
        }
        return invokeCommon.intValue;
    }

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            short[] sArr = this.b;
            int i2 = sArr[i(i)] * 2;
            int i3 = sArr[i] * 2;
            int i4 = sArr[h(i)] * 2;
            float[] fArr = this.c;
            return b(fArr[i2], fArr[i2 + 1], fArr[i3], fArr[i3 + 1], fArr[i4], fArr[i4 + 1]);
        }
        return invokeI.intValue;
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            short[] sArr = this.b;
            y7 y7Var = this.f;
            y7Var.a(sArr[i(i)]);
            y7Var.a(sArr[i]);
            y7Var.a(sArr[h(i)]);
            this.a.d(i);
            this.e.f(i);
            this.d--;
        }
    }

    public y7 c(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fArr)) == null) {
            return d(fArr, 0, fArr.length);
        }
        return (y7) invokeL.objValue;
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return (i + 1) % this.d;
        }
        return invokeI.intValue;
    }

    public final int i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i == 0) {
                i = this.d;
            }
            return i - 1;
        }
        return invokeI.intValue;
    }

    public y7 d(float[] fArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, fArr, i, i2)) == null) {
            this.c = fArr;
            int i3 = i2 / 2;
            this.d = i3;
            int i4 = i / 2;
            y7 y7Var = this.a;
            y7Var.b();
            y7Var.c(i3);
            y7Var.b = i3;
            short[] sArr = y7Var.a;
            this.b = sArr;
            if (b.a(fArr, i, i2)) {
                for (short s = 0; s < i3; s = (short) (s + 1)) {
                    sArr[s] = (short) (i4 + s);
                }
            } else {
                int i5 = i3 - 1;
                for (int i6 = 0; i6 < i3; i6++) {
                    sArr[i6] = (short) ((i4 + i5) - i6);
                }
            }
            e7 e7Var = this.e;
            e7Var.d();
            e7Var.e(i3);
            for (int i7 = 0; i7 < i3; i7++) {
                e7Var.a(a(i7));
            }
            y7 y7Var2 = this.f;
            y7Var2.b();
            y7Var2.c(Math.max(0, i3 - 2) * 3);
            j();
            return y7Var2;
        }
        return (y7) invokeLII.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.d;
            for (int i2 = 0; i2 < i; i2++) {
                if (g(i2)) {
                    return i2;
                }
            }
            int[] iArr = this.e.a;
            for (int i3 = 0; i3 < i; i3++) {
                if (iArr[i3] != -1) {
                    return i3;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int[] iArr = this.e.a;
            if (iArr[i] == -1) {
                return false;
            }
            int i2 = i(i);
            int h = h(i);
            short[] sArr = this.b;
            int i3 = sArr[i2] * 2;
            int i4 = sArr[i] * 2;
            int i5 = sArr[h] * 2;
            float[] fArr = this.c;
            float f = fArr[i3];
            int i6 = 1;
            float f2 = fArr[i3 + 1];
            float f3 = fArr[i4];
            float f4 = fArr[i4 + 1];
            float f5 = fArr[i5];
            float f6 = fArr[i5 + 1];
            int h2 = h(h);
            while (h2 != i2) {
                if (iArr[h2] != i6) {
                    int i7 = sArr[h2] * 2;
                    float f7 = fArr[i7];
                    float f8 = fArr[i7 + i6];
                    if (b(f5, f6, f, f2, f7, f8) >= 0 && b(f, f2, f3, f4, f7, f8) >= 0 && b(f3, f4, f5, f6, f7, f8) >= 0) {
                        return false;
                    }
                }
                h2 = h(h2);
                i6 = 1;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void j() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int[] iArr = this.e.a;
            while (true) {
                i = this.d;
                int i2 = 0;
                if (i <= 3) {
                    break;
                }
                int f = f();
                e(f);
                int i3 = i(f);
                if (f != this.d) {
                    i2 = f;
                }
                iArr[i3] = a(i3);
                iArr[i2] = a(i2);
            }
            if (i == 3) {
                y7 y7Var = this.f;
                short[] sArr = this.b;
                y7Var.a(sArr[0]);
                y7Var.a(sArr[1]);
                y7Var.a(sArr[2]);
            }
        }
    }
}
