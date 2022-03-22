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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f0 a;

    /* renamed from: b  reason: collision with root package name */
    public short[] f23783b;

    /* renamed from: c  reason: collision with root package name */
    public float[] f23784c;

    /* renamed from: d  reason: collision with root package name */
    public int f23785d;

    /* renamed from: e  reason: collision with root package name */
    public final l f23786e;

    /* renamed from: f  reason: collision with root package name */
    public final f0 f23787f;

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
        this.a = new f0();
        this.f23786e = new l();
        this.f23787f = new f0();
    }

    public static int b(float f2, float f3, float f4, float f5, float f6, float f7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)})) == null) ? (int) Math.signum((f2 * (f7 - f5)) + (f4 * (f3 - f7)) + (f6 * (f5 - f3))) : invokeCommon.intValue;
    }

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            short[] sArr = this.f23783b;
            int i2 = sArr[i(i)] * 2;
            int i3 = sArr[i] * 2;
            int i4 = sArr[h(i)] * 2;
            float[] fArr = this.f23784c;
            return b(fArr[i2], fArr[i2 + 1], fArr[i3], fArr[i3 + 1], fArr[i4], fArr[i4 + 1]);
        }
        return invokeI.intValue;
    }

    public f0 c(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fArr)) == null) ? d(fArr, 0, fArr.length) : (f0) invokeL.objValue;
    }

    public f0 d(float[] fArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, fArr, i, i2)) == null) {
            this.f23784c = fArr;
            int i3 = i2 / 2;
            this.f23785d = i3;
            int i4 = i / 2;
            f0 f0Var = this.a;
            f0Var.b();
            f0Var.c(i3);
            f0Var.f22752b = i3;
            short[] sArr = f0Var.a;
            this.f23783b = sArr;
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
            l lVar = this.f23786e;
            lVar.d();
            lVar.e(i3);
            for (int i7 = 0; i7 < i3; i7++) {
                lVar.a(a(i7));
            }
            f0 f0Var2 = this.f23787f;
            f0Var2.b();
            f0Var2.c(Math.max(0, i3 - 2) * 3);
            j();
            return f0Var2;
        }
        return (f0) invokeLII.objValue;
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            short[] sArr = this.f23783b;
            f0 f0Var = this.f23787f;
            f0Var.a(sArr[i(i)]);
            f0Var.a(sArr[i]);
            f0Var.a(sArr[h(i)]);
            this.a.d(i);
            this.f23786e.f(i);
            this.f23785d--;
        }
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.f23785d;
            for (int i2 = 0; i2 < i; i2++) {
                if (g(i2)) {
                    return i2;
                }
            }
            int[] iArr = this.f23786e.a;
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
            int[] iArr = this.f23786e.a;
            if (iArr[i] == -1) {
                return false;
            }
            int i2 = i(i);
            int h2 = h(i);
            short[] sArr = this.f23783b;
            int i3 = sArr[i2] * 2;
            int i4 = sArr[i] * 2;
            int i5 = sArr[h2] * 2;
            float[] fArr = this.f23784c;
            float f2 = fArr[i3];
            int i6 = 1;
            float f3 = fArr[i3 + 1];
            float f4 = fArr[i4];
            float f5 = fArr[i4 + 1];
            float f6 = fArr[i5];
            float f7 = fArr[i5 + 1];
            int h3 = h(h2);
            while (h3 != i2) {
                if (iArr[h3] != i6) {
                    int i7 = sArr[h3] * 2;
                    float f8 = fArr[i7];
                    float f9 = fArr[i7 + i6];
                    if (b(f6, f7, f2, f3, f8, f9) >= 0 && b(f2, f3, f4, f5, f8, f9) >= 0 && b(f4, f5, f6, f7, f8, f9) >= 0) {
                        return false;
                    }
                }
                h3 = h(h3);
                i6 = 1;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? (i + 1) % this.f23785d : invokeI.intValue;
    }

    public final int i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i == 0) {
                i = this.f23785d;
            }
            return i - 1;
        }
        return invokeI.intValue;
    }

    public final void j() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int[] iArr = this.f23786e.a;
            while (true) {
                i = this.f23785d;
                int i2 = 0;
                if (i <= 3) {
                    break;
                }
                int f2 = f();
                e(f2);
                int i3 = i(f2);
                if (f2 != this.f23785d) {
                    i2 = f2;
                }
                iArr[i3] = a(i3);
                iArr[i2] = a(i2);
            }
            if (i == 3) {
                f0 f0Var = this.f23787f;
                short[] sArr = this.f23783b;
                f0Var.a(sArr[0]);
                f0Var.a(sArr[1]);
                f0Var.a(sArr[2]);
            }
        }
    }
}
