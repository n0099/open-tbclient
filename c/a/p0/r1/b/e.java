package c.a.p0.r1.b;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static float f17951f = 8.0f;

    /* renamed from: g  reason: collision with root package name */
    public static float f17952g = 1.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final a f17953b;

    /* renamed from: c  reason: collision with root package name */
    public final a f17954c;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f17955d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f17956e;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static float p;
        public static final float[] q;
        public static final float[] r;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f17957b;

        /* renamed from: c  reason: collision with root package name */
        public int f17958c;

        /* renamed from: d  reason: collision with root package name */
        public int f17959d;

        /* renamed from: e  reason: collision with root package name */
        public float f17960e;

        /* renamed from: f  reason: collision with root package name */
        public float f17961f;

        /* renamed from: g  reason: collision with root package name */
        public long f17962g;

        /* renamed from: h  reason: collision with root package name */
        public int f17963h;
        public int i;
        public int j;
        public boolean k;
        public int l;
        public float m;
        public int n;
        public float o;

        static {
            InterceptResult invokeClinit;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1998852365, "Lc/a/p0/r1/b/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1998852365, "Lc/a/p0/r1/b/e$a;");
                    return;
                }
            }
            p = (float) (Math.log(0.78d) / Math.log(0.9d));
            q = new float[101];
            r = new float[101];
            float f12 = 0.0f;
            float f13 = 0.0f;
            for (int i = 0; i < 100; i++) {
                float f14 = i / 100.0f;
                float f15 = 1.0f;
                while (true) {
                    f2 = 2.0f;
                    f3 = ((f15 - f12) / 2.0f) + f12;
                    f4 = 3.0f;
                    f5 = 1.0f - f3;
                    f6 = f3 * 3.0f * f5;
                    f7 = f3 * f3 * f3;
                    float f16 = (((f5 * 0.175f) + (f3 * 0.35000002f)) * f6) + f7;
                    if (Math.abs(f16 - f14) < 1.0E-5d) {
                        break;
                    } else if (f16 > f14) {
                        f15 = f3;
                    } else {
                        f12 = f3;
                    }
                }
                q[i] = (f6 * ((f5 * 0.5f) + f3)) + f7;
                float f17 = 1.0f;
                while (true) {
                    f8 = ((f17 - f13) / f2) + f13;
                    f9 = 1.0f - f8;
                    f10 = f8 * f4 * f9;
                    f11 = f8 * f8 * f8;
                    float f18 = (((f9 * 0.5f) + f8) * f10) + f11;
                    if (Math.abs(f18 - f14) < 1.0E-5d) {
                        break;
                    }
                    if (f18 > f14) {
                        f17 = f8;
                    } else {
                        f13 = f8;
                    }
                    f2 = 2.0f;
                    f4 = 3.0f;
                }
                r[i] = (f10 * ((f9 * 0.175f) + (f8 * 0.35000002f))) + f11;
            }
            float[] fArr = q;
            r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.m = ViewConfiguration.getScrollFriction();
            this.n = 0;
            this.k = true;
            this.o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        public static float m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) ? i > 0 ? -2000.0f : 2000.0f : invokeI.floatValue;
        }

        public final void h(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                float abs = Math.abs((i3 - i) / (i2 - i));
                int i4 = (int) (abs * 100.0f);
                if (i4 < 100) {
                    float f2 = i4 / 100.0f;
                    int i5 = i4 + 1;
                    float[] fArr = r;
                    float f3 = fArr[i4];
                    this.f17963h = (int) (this.f17963h * (f3 + (((abs - f2) / ((i5 / 100.0f) - f2)) * (fArr[i5] - f3))));
                }
            }
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.n;
                if (i != 0) {
                    if (i == 1) {
                        return false;
                    }
                    if (i == 2) {
                        this.f17962g += this.f17963h;
                        x(this.f17958c, this.a, 0);
                    }
                } else if (this.f17963h >= this.i) {
                    return false;
                } else {
                    this.a = this.f17958c;
                    int i2 = (int) this.f17960e;
                    this.f17959d = i2;
                    this.f17961f = m(i2);
                    this.f17962g += this.f17963h;
                    r();
                }
                update();
                return true;
            }
            return invokeV.booleanValue;
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f17957b = this.f17958c;
                this.k = true;
            }
        }

        public final void k(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
                float f2 = this.f17961f;
                float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(f2)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.f17961f));
                this.f17962g -= (int) ((sqrt - ((-i3) / f2)) * 1000.0f);
                this.a = i2;
                this.f17959d = (int) ((-this.f17961f) * sqrt);
            }
        }

        public void l(int i, int i2, int i3, int i4, int i5) {
            float f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.l = i5;
                this.k = false;
                this.f17959d = i2;
                this.f17960e = i2;
                this.i = 0;
                this.f17963h = 0;
                this.f17962g = AnimationUtils.currentAnimationTimeMillis();
                this.a = i;
                this.f17957b = i;
                if (i <= i4 && i >= i3) {
                    this.n = 0;
                    double d2 = 0.0d;
                    if (i2 != 0) {
                        int p2 = p(i2);
                        this.i = p2;
                        this.f17963h = p2;
                        d2 = o(i2);
                    }
                    int signum = (int) (d2 * Math.signum(f2));
                    this.j = signum;
                    int i6 = i + signum;
                    this.f17958c = i6;
                    if (i6 < i3) {
                        h(this.a, i6, i3);
                        this.f17958c = i3;
                    }
                    int i7 = this.f17958c;
                    if (i7 > i4) {
                        h(this.a, i7, i4);
                        this.f17958c = i4;
                        return;
                    }
                    return;
                }
                u(i, i3, i4, i2);
            }
        }

        public final double n(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? Math.log((Math.abs(i) * 0.35f) / (this.m * this.o)) : invokeI.doubleValue;
        }

        public final double o(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                double n = n(i);
                float f2 = p;
                return this.m * this.o * Math.exp((f2 / (f2 - 1.0d)) * n);
            }
            return invokeI.doubleValue;
        }

        public final int p(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? (int) (Math.exp(n(i) / (p - 1.0d)) * 1000.0d) : invokeI.intValue;
        }

        public void q(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3) == null) && this.n == 0) {
                this.l = i3;
                this.f17962g = AnimationUtils.currentAnimationTimeMillis();
                u(i, i2, i2, (int) this.f17960e);
            }
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                int i = this.f17959d;
                float abs = (i * i) / (Math.abs(this.f17961f) * 2.0f);
                float signum = Math.signum(this.f17959d);
                int i2 = this.l;
                if (abs > i2) {
                    float f2 = -signum;
                    int i3 = this.f17959d;
                    this.f17961f = ((f2 * i3) * i3) / (i2 * 2.0f);
                    abs = i2;
                }
                this.l = (int) abs;
                this.n = 2;
                int i4 = this.a;
                if (this.f17959d <= 0) {
                    abs = -abs;
                }
                this.f17958c = i4 + ((int) abs);
                this.f17963h = -((int) ((this.f17959d * 1000.0f) / this.f17961f));
            }
        }

        public void s(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
                this.m = f2;
            }
        }

        public boolean t(int i, int i2, int i3) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(1048587, this, i, i2, i3)) == null) {
                this.k = true;
                this.f17958c = i;
                this.a = i;
                this.f17959d = 0;
                this.f17962g = AnimationUtils.currentAnimationTimeMillis();
                this.f17963h = 0;
                if (i < i2) {
                    x(i, i2, 0);
                } else if (i > i3) {
                    x(i, i3, 0);
                }
                return !this.k;
            }
            return invokeIII.booleanValue;
        }

        public final void u(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
                if (i > i2 && i < i3) {
                    Log.e("OverScroller", "startAfterEdge called from a valid position");
                    this.k = true;
                    return;
                }
                boolean z = i > i3;
                int i5 = z ? i3 : i2;
                int i6 = i - i5;
                if (i6 * i4 >= 0) {
                    v(i, i5, i4);
                } else if (o(i4) > Math.abs(i6)) {
                    l(i, i4, z ? i2 : i, z ? i : i3, this.l);
                } else {
                    x(i, i5, i4);
                }
            }
        }

        public boolean update() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f17962g;
                int i = this.f17963h;
                if (currentAnimationTimeMillis > i) {
                    return false;
                }
                double d2 = 0.0d;
                int i2 = this.n;
                if (i2 == 0) {
                    float f2 = ((float) currentAnimationTimeMillis) / this.i;
                    int i3 = (int) (f2 * 100.0f);
                    float f3 = 1.0f;
                    float f4 = 0.0f;
                    if (i3 < 100) {
                        float f5 = i3 / 100.0f;
                        int i4 = i3 + 1;
                        float[] fArr = q;
                        float f6 = fArr[i3];
                        f4 = (fArr[i4] - f6) / ((i4 / 100.0f) - f5);
                        f3 = f6 + ((f2 - f5) * f4);
                    }
                    int i5 = this.j;
                    this.f17960e = ((f4 * i5) / this.i) * 1000.0f;
                    d2 = f3 * i5;
                } else if (i2 == 1) {
                    float f7 = ((float) currentAnimationTimeMillis) / i;
                    float f8 = f7 * f7;
                    float signum = Math.signum(this.f17959d);
                    int i6 = this.l;
                    this.f17960e = signum * i6 * 6.0f * ((-f7) + f8);
                    d2 = i6 * signum * ((3.0f * f8) - ((2.0f * f7) * f8));
                } else if (i2 == 2) {
                    float f9 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    int i7 = this.f17959d;
                    float f10 = this.f17961f;
                    this.f17960e = i7 + (f10 * f9);
                    d2 = (i7 * f9) + (((f10 * f9) * f9) / 2.0f);
                }
                this.f17957b = this.a + ((int) Math.round(d2));
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void v(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
                this.f17961f = m(i3 == 0 ? i - i2 : i3);
                k(i, i2, i3);
                r();
            }
        }

        public void w(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) {
                this.k = false;
                this.a = i;
                this.f17958c = i + i2;
                this.f17962g = AnimationUtils.currentAnimationTimeMillis();
                this.f17963h = i3;
                this.f17961f = 0.0f;
                this.f17959d = 0;
            }
        }

        public final void x(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048592, this, i, i2, i3) == null) {
                this.k = false;
                this.n = 1;
                this.a = i;
                this.f17958c = i2;
                int i4 = i - i2;
                this.f17961f = m(i4);
                this.f17959d = -i4;
                this.l = Math.abs(i4);
                this.f17963h = (int) (Math.sqrt((i4 * (-2.0d)) / this.f17961f) * 1000.0d);
            }
        }

        public void y(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
                int i = this.a;
                this.f17957b = i + Math.round(f2 * (this.f17958c - i));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1267192342, "Lc/a/p0/r1/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1267192342, "Lc/a/p0/r1/b/e;");
                return;
            }
        }
        f17952g = 1.0f / n(1.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Interpolator) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static float n(float f2) {
        InterceptResult invokeF;
        float exp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f2)) == null) {
            float f3 = f2 * f17951f;
            if (f3 < 1.0f) {
                exp = f3 - (1.0f - ((float) Math.exp(-f3)));
            } else {
                exp = ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f) + 0.36787945f;
            }
            return exp * f17952g;
        }
        return invokeF.floatValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17953b.j();
            this.f17954c.j();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        float interpolation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (g()) {
                return false;
            }
            int i = this.a;
            if (i == 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f17953b.f17962g;
                int i2 = this.f17953b.f17963h;
                if (currentAnimationTimeMillis < i2) {
                    float f2 = ((float) currentAnimationTimeMillis) / i2;
                    Interpolator interpolator = this.f17955d;
                    if (interpolator == null) {
                        interpolation = n(f2);
                    } else {
                        interpolation = interpolator.getInterpolation(f2);
                    }
                    this.f17953b.y(interpolation);
                    this.f17954c.y(interpolation);
                } else {
                    a();
                }
            } else if (i == 1) {
                if (!this.f17953b.k && !this.f17953b.update() && !this.f17953b.i()) {
                    this.f17953b.j();
                }
                if (!this.f17954c.k && !this.f17954c.update() && !this.f17954c.i()) {
                    this.f17954c.j();
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            d(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
        }
    }

    public void d(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
            if (!this.f17956e || g()) {
                i11 = i3;
            } else {
                float f2 = this.f17953b.f17960e;
                float f3 = this.f17954c.f17960e;
                i11 = i3;
                float f4 = i11;
                if (Math.signum(f4) == Math.signum(f2)) {
                    i12 = i4;
                    float f5 = i12;
                    if (Math.signum(f5) == Math.signum(f3)) {
                        i13 = (int) (f5 + f3);
                        i14 = (int) (f4 + f2);
                        this.a = 1;
                        this.f17953b.l(i, i14, i5, i6, i9);
                        this.f17954c.l(i2, i13, i7, i8, i10);
                    }
                    i13 = i12;
                    i14 = i11;
                    this.a = 1;
                    this.f17953b.l(i, i14, i5, i6, i9);
                    this.f17954c.l(i2, i13, i7, i8, i10);
                }
            }
            i12 = i4;
            i13 = i12;
            i14 = i11;
            this.a = 1;
            this.f17953b.l(i, i14, i5, i6, i9);
            this.f17954c.l(i2, i13, i7, i8, i10);
        }
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (float) Math.sqrt((this.f17953b.f17960e * this.f17953b.f17960e) + (this.f17954c.f17960e * this.f17954c.f17960e)) : invokeV.floatValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f17953b.f17957b : invokeV.intValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f17953b.k && this.f17954c.k : invokeV.booleanValue;
    }

    public boolean h(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return !g() && Math.signum(f2) == Math.signum((float) (this.f17953b.f17958c - this.f17953b.a)) && Math.signum(f3) == Math.signum((float) (this.f17954c.f17958c - this.f17954c.a));
        }
        return invokeCommon.booleanValue;
    }

    public void i(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3) == null) {
            this.f17953b.q(i, i2, i3);
        }
    }

    public final void j(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f17953b.s(f2);
            this.f17954c.s(f2);
        }
    }

    public void k(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interpolator) == null) {
            this.f17955d = interpolator;
        }
    }

    public boolean l(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            this.a = 1;
            return this.f17953b.t(i, i3, i4) || this.f17954c.t(i2, i5, i6);
        }
        return invokeCommon.booleanValue;
    }

    public void m(int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.a = 0;
            this.f17953b.w(i, i3, i5);
            this.f17954c.w(i2, i4, i5);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, interpolator};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Interpolator) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public e(Context context, Interpolator interpolator, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, interpolator, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f17955d = interpolator;
        this.f17956e = z;
        this.f17953b = new a(context);
        this.f17954c = new a(context);
    }
}
