package c.i.b.a.x;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes9.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29937b;

    /* renamed from: c  reason: collision with root package name */
    public final float f29938c;

    /* renamed from: d  reason: collision with root package name */
    public final float f29939d;

    /* renamed from: e  reason: collision with root package name */
    public final float f29940e;

    /* renamed from: f  reason: collision with root package name */
    public final int f29941f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29942g;

    /* renamed from: h  reason: collision with root package name */
    public final int f29943h;

    /* renamed from: i  reason: collision with root package name */
    public final short[] f29944i;

    /* renamed from: j  reason: collision with root package name */
    public int f29945j;
    public short[] k;
    public int l;
    public short[] m;
    public int n;
    public short[] o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;

    public i(int i2, int i3, float f2, float f3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f29937b = i3;
        this.f29941f = i2 / 400;
        int i7 = i2 / 65;
        this.f29942g = i7;
        int i8 = i7 * 2;
        this.f29943h = i8;
        this.f29944i = new short[i8];
        this.f29945j = i8;
        this.k = new short[i8 * i3];
        this.l = i8;
        this.m = new short[i8 * i3];
        this.n = i8;
        this.o = new short[i8 * i3];
        this.p = 0;
        this.q = 0;
        this.v = 0;
        this.f29938c = f2;
        this.f29939d = f3;
        this.f29940e = i2 / i4;
    }

    public static void o(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), sArr, Integer.valueOf(i4), sArr2, Integer.valueOf(i5), sArr3, Integer.valueOf(i6)}) == null) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = (i4 * i3) + i7;
                int i9 = (i6 * i3) + i7;
                int i10 = (i5 * i3) + i7;
                for (int i11 = 0; i11 < i2; i11++) {
                    sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                    i8 += i3;
                    i10 += i3;
                    i9 += i3;
                }
            }
        }
    }

    public final void a(float f2, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) || this.s == i2) {
            return;
        }
        int i5 = this.a;
        int i6 = (int) (i5 / f2);
        while (true) {
            if (i6 <= 16384 && i5 <= 16384) {
                break;
            }
            i6 /= 2;
            i5 /= 2;
        }
        n(i2);
        int i7 = 0;
        while (true) {
            int i8 = this.t;
            if (i7 < i8 - 1) {
                while (true) {
                    i3 = this.p;
                    int i9 = (i3 + 1) * i6;
                    i4 = this.q;
                    if (i9 <= i4 * i5) {
                        break;
                    }
                    g(1);
                    int i10 = 0;
                    while (true) {
                        int i11 = this.f29937b;
                        if (i10 < i11) {
                            this.m[(this.s * i11) + i10] = m(this.o, (i11 * i7) + i10, i5, i6);
                            i10++;
                        }
                    }
                    this.q++;
                    this.s++;
                }
                int i12 = i3 + 1;
                this.p = i12;
                if (i12 == i5) {
                    this.p = 0;
                    c.i.b.a.i0.a.f(i4 == i6);
                    this.q = 0;
                }
                i7++;
            } else {
                t(i8 - 1);
                return;
            }
        }
    }

    public final void b(float f2) {
        int i2;
        int l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || (i2 = this.r) < this.f29943h) {
            return;
        }
        int i3 = 0;
        do {
            if (this.u > 0) {
                l = c(i3);
            } else {
                int h2 = h(this.k, i3, true);
                if (f2 > 1.0d) {
                    l = h2 + v(this.k, i3, f2, h2);
                } else {
                    l = l(this.k, i3, f2, h2);
                }
            }
            i3 += l;
        } while (this.f29943h + i3 <= i2);
        u(i3);
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int min = Math.min(this.f29943h, this.u);
            d(this.k, i2, min);
            this.u -= min;
            return min;
        }
        return invokeI.intValue;
    }

    public final void d(short[] sArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, sArr, i2, i3) == null) {
            g(i3);
            int i4 = this.f29937b;
            System.arraycopy(sArr, i2 * i4, this.m, this.s * i4, i4 * i3);
            this.s += i3;
        }
    }

    public final void e(short[] sArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, sArr, i2, i3) == null) {
            int i4 = this.f29943h / i3;
            int i5 = this.f29937b;
            int i6 = i3 * i5;
            int i7 = i2 * i5;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = 0;
                for (int i10 = 0; i10 < i6; i10++) {
                    i9 += sArr[(i8 * i6) + i7 + i10];
                }
                this.f29944i[i8] = (short) (i9 / i6);
            }
        }
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            int i3 = this.r + i2;
            int i4 = this.f29945j;
            if (i3 > i4) {
                int i5 = i4 + (i4 / 2) + i2;
                this.f29945j = i5;
                this.k = Arrays.copyOf(this.k, i5 * this.f29937b);
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            int i3 = this.s + i2;
            int i4 = this.l;
            if (i3 > i4) {
                int i5 = i4 + (i4 / 2) + i2;
                this.l = i5;
                this.m = Arrays.copyOf(this.m, i5 * this.f29937b);
            }
        }
    }

    public final int h(short[] sArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{sArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i4 = this.a;
            int i5 = i4 > 4000 ? i4 / 4000 : 1;
            if (this.f29937b == 1 && i5 == 1) {
                i3 = i(sArr, i2, this.f29941f, this.f29942g);
            } else {
                e(sArr, i2, i5);
                int i6 = i(this.f29944i, 0, this.f29941f / i5, this.f29942g / i5);
                if (i5 != 1) {
                    int i7 = i6 * i5;
                    int i8 = i5 * 4;
                    int i9 = i7 - i8;
                    int i10 = i7 + i8;
                    int i11 = this.f29941f;
                    if (i9 < i11) {
                        i9 = i11;
                    }
                    int i12 = this.f29942g;
                    if (i10 > i12) {
                        i10 = i12;
                    }
                    if (this.f29937b == 1) {
                        i3 = i(sArr, i2, i9, i10);
                    } else {
                        e(sArr, i2, 1);
                        i3 = i(this.f29944i, 0, i9, i10);
                    }
                } else {
                    i3 = i6;
                }
            }
            int i13 = p(this.x, this.y, z) ? this.v : i3;
            this.w = this.x;
            this.v = i3;
            return i13;
        }
        return invokeCommon.intValue;
    }

    public final int i(short[] sArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, sArr, i2, i3, i4)) == null) {
            int i5 = i2 * this.f29937b;
            int i6 = 1;
            int i7 = 255;
            int i8 = 0;
            int i9 = 0;
            while (i3 <= i4) {
                int i10 = 0;
                for (int i11 = 0; i11 < i3; i11++) {
                    i10 += Math.abs(sArr[i5 + i11] - sArr[(i5 + i3) + i11]);
                }
                if (i10 * i8 < i6 * i3) {
                    i8 = i3;
                    i6 = i10;
                }
                if (i10 * i7 > i9 * i3) {
                    i7 = i3;
                    i9 = i10;
                }
                i3++;
            }
            this.x = i6 / i8;
            this.y = i9 / i7;
            return i8;
        }
        return invokeLIII.intValue;
    }

    public void j(ShortBuffer shortBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, shortBuffer) == null) {
            int min = Math.min(shortBuffer.remaining() / this.f29937b, this.s);
            shortBuffer.put(this.m, 0, this.f29937b * min);
            int i2 = this.s - min;
            this.s = i2;
            short[] sArr = this.m;
            int i3 = this.f29937b;
            System.arraycopy(sArr, min * i3, sArr, 0, i2 * i3);
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : invokeV.intValue;
    }

    public final int l(short[] sArr, int i2, float f2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{sArr, Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)})) == null) {
            if (f2 < 0.5f) {
                i4 = (int) ((i3 * f2) / (1.0f - f2));
            } else {
                this.u = (int) ((i3 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                i4 = i3;
            }
            int i5 = i3 + i4;
            g(i5);
            int i6 = this.f29937b;
            System.arraycopy(sArr, i2 * i6, this.m, this.s * i6, i6 * i3);
            o(i4, this.f29937b, this.m, this.s + i3, sArr, i2 + i3, sArr, i2);
            this.s += i5;
            return i4;
        }
        return invokeCommon.intValue;
    }

    public final short m(short[] sArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048588, this, sArr, i2, i3, i4)) == null) {
            short s = sArr[i2];
            short s2 = sArr[i2 + this.f29937b];
            int i5 = this.q * i3;
            int i6 = this.p;
            int i7 = i6 * i4;
            int i8 = (i6 + 1) * i4;
            int i9 = i8 - i5;
            int i10 = i8 - i7;
            return (short) (((s * i9) + ((i10 - i9) * s2)) / i10);
        }
        return invokeLIII.shortValue;
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            int i3 = this.s - i2;
            int i4 = this.t + i3;
            int i5 = this.n;
            if (i4 > i5) {
                int i6 = i5 + (i5 / 2) + i3;
                this.n = i6;
                this.o = Arrays.copyOf(this.o, i6 * this.f29937b);
            }
            short[] sArr = this.m;
            int i7 = this.f29937b;
            System.arraycopy(sArr, i2 * i7, this.o, this.t * i7, i7 * i3);
            this.s = i2;
            this.t += i3;
        }
    }

    public final boolean p(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (i2 == 0 || this.v == 0) {
                return false;
            }
            return z ? i3 <= i2 * 3 && i2 * 2 > this.w * 3 : i2 > this.w;
        }
        return invokeCommon.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = this.s;
            float f2 = this.f29938c;
            float f3 = this.f29939d;
            float f4 = f2 / f3;
            float f5 = this.f29940e * f3;
            double d2 = f4;
            if (d2 <= 1.00001d && d2 >= 0.99999d) {
                d(this.k, 0, this.r);
                this.r = 0;
            } else {
                b(f4);
            }
            if (f5 != 1.0f) {
                a(f5, i2);
            }
        }
    }

    public void r() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i3 = this.r;
            float f2 = this.f29938c;
            float f3 = this.f29939d;
            int i4 = this.s + ((int) ((((i3 / (f2 / f3)) + this.t) / (this.f29940e * f3)) + 0.5f));
            f((this.f29943h * 2) + i3);
            int i5 = 0;
            while (true) {
                i2 = this.f29943h;
                int i6 = this.f29937b;
                if (i5 >= i2 * 2 * i6) {
                    break;
                }
                this.k[(i6 * i3) + i5] = 0;
                i5++;
            }
            this.r += i2 * 2;
            q();
            if (this.s > i4) {
                this.s = i4;
            }
            this.r = 0;
            this.u = 0;
            this.t = 0;
        }
    }

    public void s(ShortBuffer shortBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, shortBuffer) == null) {
            int remaining = shortBuffer.remaining();
            int i2 = this.f29937b;
            int i3 = remaining / i2;
            f(i3);
            shortBuffer.get(this.k, this.r * this.f29937b, ((i2 * i3) * 2) / 2);
            this.r += i3;
            q();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 == 0) {
            return;
        }
        short[] sArr = this.o;
        int i3 = this.f29937b;
        System.arraycopy(sArr, i2 * i3, sArr, 0, (this.t - i2) * i3);
        this.t -= i2;
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            int i3 = this.r - i2;
            short[] sArr = this.k;
            int i4 = this.f29937b;
            System.arraycopy(sArr, i2 * i4, sArr, 0, i4 * i3);
            this.r = i3;
        }
    }

    public final int v(short[] sArr, int i2, float f2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{sArr, Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)})) == null) {
            if (f2 >= 2.0f) {
                i4 = (int) (i3 / (f2 - 1.0f));
            } else {
                this.u = (int) ((i3 * (2.0f - f2)) / (f2 - 1.0f));
                i4 = i3;
            }
            g(i4);
            o(i4, this.f29937b, this.m, this.s, sArr, i2, sArr, i2 + i3);
            this.s += i4;
            return i4;
        }
        return invokeCommon.intValue;
    }
}
