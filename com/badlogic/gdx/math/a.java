package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.f0;
import c.b.b.q.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f0 a;

    /* renamed from: b  reason: collision with root package name */
    public short[] f31359b;

    /* renamed from: c  reason: collision with root package name */
    public float[] f31360c;

    /* renamed from: d  reason: collision with root package name */
    public int f31361d;

    /* renamed from: e  reason: collision with root package name */
    public final l f31362e;

    /* renamed from: f  reason: collision with root package name */
    public final f0 f31363f;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new f0();
        this.f31362e = new l();
        this.f31363f = new f0();
    }

    public static int b(float f2, float f3, float f4, float f5, float f6, float f7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)})) == null) ? (int) Math.signum((f2 * (f7 - f5)) + (f4 * (f3 - f7)) + (f6 * (f5 - f3))) : invokeCommon.intValue;
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            short[] sArr = this.f31359b;
            int i3 = sArr[i(i2)] * 2;
            int i4 = sArr[i2] * 2;
            int i5 = sArr[h(i2)] * 2;
            float[] fArr = this.f31360c;
            return b(fArr[i3], fArr[i3 + 1], fArr[i4], fArr[i4 + 1], fArr[i5], fArr[i5 + 1]);
        }
        return invokeI.intValue;
    }

    public f0 c(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fArr)) == null) ? d(fArr, 0, fArr.length) : (f0) invokeL.objValue;
    }

    public f0 d(float[] fArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, fArr, i2, i3)) == null) {
            this.f31360c = fArr;
            int i4 = i3 / 2;
            this.f31361d = i4;
            int i5 = i2 / 2;
            f0 f0Var = this.a;
            f0Var.b();
            f0Var.c(i4);
            f0Var.f27638b = i4;
            short[] sArr = f0Var.a;
            this.f31359b = sArr;
            if (b.a(fArr, i2, i3)) {
                for (short s = 0; s < i4; s = (short) (s + 1)) {
                    sArr[s] = (short) (i5 + s);
                }
            } else {
                int i6 = i4 - 1;
                for (int i7 = 0; i7 < i4; i7++) {
                    sArr[i7] = (short) ((i5 + i6) - i7);
                }
            }
            l lVar = this.f31362e;
            lVar.d();
            lVar.e(i4);
            for (int i8 = 0; i8 < i4; i8++) {
                lVar.a(a(i8));
            }
            f0 f0Var2 = this.f31363f;
            f0Var2.b();
            f0Var2.c(Math.max(0, i4 - 2) * 3);
            j();
            return f0Var2;
        }
        return (f0) invokeLII.objValue;
    }

    public final void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            short[] sArr = this.f31359b;
            f0 f0Var = this.f31363f;
            f0Var.a(sArr[i(i2)]);
            f0Var.a(sArr[i2]);
            f0Var.a(sArr[h(i2)]);
            this.a.d(i2);
            this.f31362e.f(i2);
            this.f31361d--;
        }
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f31361d;
            for (int i3 = 0; i3 < i2; i3++) {
                if (g(i3)) {
                    return i3;
                }
            }
            int[] iArr = this.f31362e.a;
            for (int i4 = 0; i4 < i2; i4++) {
                if (iArr[i4] != -1) {
                    return i4;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int[] iArr = this.f31362e.a;
            if (iArr[i2] == -1) {
                return false;
            }
            int i3 = i(i2);
            int h2 = h(i2);
            short[] sArr = this.f31359b;
            int i4 = sArr[i3] * 2;
            int i5 = sArr[i2] * 2;
            int i6 = sArr[h2] * 2;
            float[] fArr = this.f31360c;
            float f2 = fArr[i4];
            int i7 = 1;
            float f3 = fArr[i4 + 1];
            float f4 = fArr[i5];
            float f5 = fArr[i5 + 1];
            float f6 = fArr[i6];
            float f7 = fArr[i6 + 1];
            int h3 = h(h2);
            while (h3 != i3) {
                if (iArr[h3] != i7) {
                    int i8 = sArr[h3] * 2;
                    float f8 = fArr[i8];
                    float f9 = fArr[i8 + i7];
                    if (b(f6, f7, f2, f3, f8, f9) >= 0 && b(f2, f3, f4, f5, f8, f9) >= 0 && b(f4, f5, f6, f7, f8, f9) >= 0) {
                        return false;
                    }
                }
                h3 = h(h3);
                i7 = 1;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? (i2 + 1) % this.f31361d : invokeI.intValue;
    }

    public final int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 == 0) {
                i2 = this.f31361d;
            }
            return i2 - 1;
        }
        return invokeI.intValue;
    }

    public final void j() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int[] iArr = this.f31362e.a;
            while (true) {
                i2 = this.f31361d;
                int i3 = 0;
                if (i2 <= 3) {
                    break;
                }
                int f2 = f();
                e(f2);
                int i4 = i(f2);
                if (f2 != this.f31361d) {
                    i3 = f2;
                }
                iArr[i4] = a(i4);
                iArr[i3] = a(i3);
            }
            if (i2 == 3) {
                f0 f0Var = this.f31363f;
                short[] sArr = this.f31359b;
                f0Var.a(sArr[0]);
                f0Var.a(sArr[1]);
                f0Var.a(sArr[2]);
            }
        }
    }
}
