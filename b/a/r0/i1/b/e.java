package b.a.r0.i1.b;

import android.content.Context;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static float f19358f = 8.0f;

    /* renamed from: g  reason: collision with root package name */
    public static float f19359g = 1.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f19360a;

    /* renamed from: b  reason: collision with root package name */
    public final a f19361b;

    /* renamed from: c  reason: collision with root package name */
    public final a f19362c;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f19363d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f19364e;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static float p;
        public static final float[] q;
        public static final float[] r;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19365a;

        /* renamed from: b  reason: collision with root package name */
        public int f19366b;

        /* renamed from: c  reason: collision with root package name */
        public int f19367c;

        /* renamed from: d  reason: collision with root package name */
        public int f19368d;

        /* renamed from: e  reason: collision with root package name */
        public float f19369e;

        /* renamed from: f  reason: collision with root package name */
        public float f19370f;

        /* renamed from: g  reason: collision with root package name */
        public long f19371g;

        /* renamed from: h  reason: collision with root package name */
        public int f19372h;

        /* renamed from: i  reason: collision with root package name */
        public int f19373i;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1854772963, "Lb/a/r0/i1/b/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1854772963, "Lb/a/r0/i1/b/e$a;");
                    return;
                }
            }
            p = (float) (Math.log(0.78d) / Math.log(0.9d));
            q = new float[101];
            r = new float[101];
            float f12 = 0.0f;
            float f13 = 0.0f;
            for (int i2 = 0; i2 < 100; i2++) {
                float f14 = i2 / 100.0f;
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
                q[i2] = (f6 * ((f5 * 0.5f) + f3)) + f7;
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
                r[i2] = (f10 * ((f9 * 0.175f) + (f8 * 0.35000002f))) + f11;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        public static float m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? i2 > 0 ? -2000.0f : 2000.0f : invokeI.floatValue;
        }

        public final void h(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                float abs = Math.abs((i4 - i2) / (i3 - i2));
                int i5 = (int) (abs * 100.0f);
                if (i5 < 100) {
                    float f2 = i5 / 100.0f;
                    int i6 = i5 + 1;
                    float[] fArr = r;
                    float f3 = fArr[i5];
                    this.f19372h = (int) (this.f19372h * (f3 + (((abs - f2) / ((i6 / 100.0f) - f2)) * (fArr[i6] - f3))));
                }
            }
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.n;
                if (i2 != 0) {
                    if (i2 == 1) {
                        return false;
                    }
                    if (i2 == 2) {
                        this.f19371g += this.f19372h;
                        x(this.f19367c, this.f19365a, 0);
                    }
                } else if (this.f19372h >= this.f19373i) {
                    return false;
                } else {
                    this.f19365a = this.f19367c;
                    int i3 = (int) this.f19369e;
                    this.f19368d = i3;
                    this.f19370f = m(i3);
                    this.f19371g += this.f19372h;
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
                this.f19366b = this.f19367c;
                this.k = true;
            }
        }

        public final void k(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048579, this, i2, i3, i4) == null) {
                float f2 = this.f19370f;
                float sqrt = (float) Math.sqrt((((((i4 * i4) / 2.0f) / Math.abs(f2)) + Math.abs(i3 - i2)) * 2.0d) / Math.abs(this.f19370f));
                this.f19371g -= (int) ((sqrt - ((-i4) / f2)) * 1000.0f);
                this.f19365a = i3;
                this.f19368d = (int) ((-this.f19370f) * sqrt);
            }
        }

        public void l(int i2, int i3, int i4, int i5, int i6) {
            float f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                this.l = i6;
                this.k = false;
                this.f19368d = i3;
                this.f19369e = i3;
                this.f19373i = 0;
                this.f19372h = 0;
                this.f19371g = AnimationUtils.currentAnimationTimeMillis();
                this.f19365a = i2;
                this.f19366b = i2;
                if (i2 <= i5 && i2 >= i4) {
                    this.n = 0;
                    double d2 = 0.0d;
                    if (i3 != 0) {
                        int p2 = p(i3);
                        this.f19373i = p2;
                        this.f19372h = p2;
                        d2 = o(i3);
                    }
                    int signum = (int) (d2 * Math.signum(f2));
                    this.j = signum;
                    int i7 = i2 + signum;
                    this.f19367c = i7;
                    if (i7 < i4) {
                        h(this.f19365a, i7, i4);
                        this.f19367c = i4;
                    }
                    int i8 = this.f19367c;
                    if (i8 > i5) {
                        h(this.f19365a, i8, i5);
                        this.f19367c = i5;
                        return;
                    }
                    return;
                }
                u(i2, i4, i5, i3);
            }
        }

        public final double n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? Math.log((Math.abs(i2) * 0.35f) / (this.m * this.o)) : invokeI.doubleValue;
        }

        public final double o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                double n = n(i2);
                float f2 = p;
                return this.m * this.o * Math.exp((f2 / (f2 - 1.0d)) * n);
            }
            return invokeI.doubleValue;
        }

        public final int p(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? (int) (Math.exp(n(i2) / (p - 1.0d)) * 1000.0d) : invokeI.intValue;
        }

        public void q(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) && this.n == 0) {
                this.l = i4;
                this.f19371g = AnimationUtils.currentAnimationTimeMillis();
                u(i2, i3, i3, (int) this.f19369e);
            }
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                int i2 = this.f19368d;
                float abs = (i2 * i2) / (Math.abs(this.f19370f) * 2.0f);
                float signum = Math.signum(this.f19368d);
                int i3 = this.l;
                if (abs > i3) {
                    float f2 = -signum;
                    int i4 = this.f19368d;
                    this.f19370f = ((f2 * i4) * i4) / (i3 * 2.0f);
                    abs = i3;
                }
                this.l = (int) abs;
                this.n = 2;
                int i5 = this.f19365a;
                if (this.f19368d <= 0) {
                    abs = -abs;
                }
                this.f19367c = i5 + ((int) abs);
                this.f19372h = -((int) ((this.f19368d * 1000.0f) / this.f19370f));
            }
        }

        public void s(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
                this.m = f2;
            }
        }

        public boolean t(int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(1048587, this, i2, i3, i4)) == null) {
                this.k = true;
                this.f19367c = i2;
                this.f19365a = i2;
                this.f19368d = 0;
                this.f19371g = AnimationUtils.currentAnimationTimeMillis();
                this.f19372h = 0;
                if (i2 < i3) {
                    x(i2, i3, 0);
                } else if (i2 > i4) {
                    x(i2, i4, 0);
                }
                return !this.k;
            }
            return invokeIII.booleanValue;
        }

        public final void u(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
                if (i2 > i3 && i2 < i4) {
                    this.k = true;
                    return;
                }
                boolean z = i2 > i4;
                int i6 = z ? i4 : i3;
                int i7 = i2 - i6;
                if (i7 * i5 >= 0) {
                    v(i2, i6, i5);
                } else if (o(i5) > Math.abs(i7)) {
                    l(i2, i5, z ? i3 : i2, z ? i2 : i4, this.l);
                } else {
                    x(i2, i6, i5);
                }
            }
        }

        public boolean update() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f19371g;
                int i2 = this.f19372h;
                if (currentAnimationTimeMillis > i2) {
                    return false;
                }
                double d2 = 0.0d;
                int i3 = this.n;
                if (i3 == 0) {
                    float f2 = ((float) currentAnimationTimeMillis) / this.f19373i;
                    int i4 = (int) (f2 * 100.0f);
                    float f3 = 1.0f;
                    float f4 = 0.0f;
                    if (i4 < 100) {
                        float f5 = i4 / 100.0f;
                        int i5 = i4 + 1;
                        float[] fArr = q;
                        float f6 = fArr[i4];
                        f4 = (fArr[i5] - f6) / ((i5 / 100.0f) - f5);
                        f3 = f6 + ((f2 - f5) * f4);
                    }
                    int i6 = this.j;
                    this.f19369e = ((f4 * i6) / this.f19373i) * 1000.0f;
                    d2 = f3 * i6;
                } else if (i3 == 1) {
                    float f7 = ((float) currentAnimationTimeMillis) / i2;
                    float f8 = f7 * f7;
                    float signum = Math.signum(this.f19368d);
                    int i7 = this.l;
                    this.f19369e = signum * i7 * 6.0f * ((-f7) + f8);
                    d2 = i7 * signum * ((3.0f * f8) - ((2.0f * f7) * f8));
                } else if (i3 == 2) {
                    float f9 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    int i8 = this.f19368d;
                    float f10 = this.f19370f;
                    this.f19369e = i8 + (f10 * f9);
                    d2 = (i8 * f9) + (((f10 * f9) * f9) / 2.0f);
                }
                this.f19366b = this.f19365a + ((int) Math.round(d2));
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void v(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048590, this, i2, i3, i4) == null) {
                this.f19370f = m(i4 == 0 ? i2 - i3 : i4);
                k(i2, i3, i4);
                r();
            }
        }

        public void w(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048591, this, i2, i3, i4) == null) {
                this.k = false;
                this.f19365a = i2;
                this.f19367c = i2 + i3;
                this.f19371g = AnimationUtils.currentAnimationTimeMillis();
                this.f19372h = i4;
                this.f19370f = 0.0f;
                this.f19368d = 0;
            }
        }

        public final void x(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048592, this, i2, i3, i4) == null) {
                this.k = false;
                this.n = 1;
                this.f19365a = i2;
                this.f19367c = i3;
                int i5 = i2 - i3;
                this.f19370f = m(i5);
                this.f19368d = -i5;
                this.l = Math.abs(i5);
                this.f19372h = (int) (Math.sqrt((i5 * (-2.0d)) / this.f19370f) * 1000.0d);
            }
        }

        public void y(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
                int i2 = this.f19365a;
                this.f19366b = i2 + Math.round(f2 * (this.f19367c - i2));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-552259264, "Lb/a/r0/i1/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-552259264, "Lb/a/r0/i1/b/e;");
                return;
            }
        }
        f19359g = 1.0f / n(1.0f);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            float f3 = f2 * f19358f;
            if (f3 < 1.0f) {
                exp = f3 - (1.0f - ((float) Math.exp(-f3)));
            } else {
                exp = ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f) + 0.36787945f;
            }
            return exp * f19359g;
        }
        return invokeF.floatValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19361b.j();
            this.f19362c.j();
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
            int i2 = this.f19360a;
            if (i2 == 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f19361b.f19371g;
                int i3 = this.f19361b.f19372h;
                if (currentAnimationTimeMillis < i3) {
                    float f2 = ((float) currentAnimationTimeMillis) / i3;
                    Interpolator interpolator = this.f19363d;
                    if (interpolator == null) {
                        interpolation = n(f2);
                    } else {
                        interpolation = interpolator.getInterpolation(f2);
                    }
                    this.f19361b.y(interpolation);
                    this.f19362c.y(interpolation);
                } else {
                    a();
                }
            } else if (i2 == 1) {
                if (!this.f19361b.k && !this.f19361b.update() && !this.f19361b.i()) {
                    this.f19361b.j();
                }
                if (!this.f19362c.k && !this.f19362c.update() && !this.f19362c.i()) {
                    this.f19362c.j();
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
            d(i2, i3, i4, i5, i6, i7, i8, i9, 0, 0);
        }
    }

    public void d(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11)}) == null) {
            if (!this.f19364e || g()) {
                i12 = i4;
            } else {
                float f2 = this.f19361b.f19369e;
                float f3 = this.f19362c.f19369e;
                i12 = i4;
                float f4 = i12;
                if (Math.signum(f4) == Math.signum(f2)) {
                    i13 = i5;
                    float f5 = i13;
                    if (Math.signum(f5) == Math.signum(f3)) {
                        i14 = (int) (f5 + f3);
                        i15 = (int) (f4 + f2);
                        this.f19360a = 1;
                        this.f19361b.l(i2, i15, i6, i7, i10);
                        this.f19362c.l(i3, i14, i8, i9, i11);
                    }
                    i14 = i13;
                    i15 = i12;
                    this.f19360a = 1;
                    this.f19361b.l(i2, i15, i6, i7, i10);
                    this.f19362c.l(i3, i14, i8, i9, i11);
                }
            }
            i13 = i5;
            i14 = i13;
            i15 = i12;
            this.f19360a = 1;
            this.f19361b.l(i2, i15, i6, i7, i10);
            this.f19362c.l(i3, i14, i8, i9, i11);
        }
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (float) Math.sqrt((this.f19361b.f19369e * this.f19361b.f19369e) + (this.f19362c.f19369e * this.f19362c.f19369e)) : invokeV.floatValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19361b.f19366b : invokeV.intValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19361b.k && this.f19362c.k : invokeV.booleanValue;
    }

    public boolean h(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return !g() && Math.signum(f2) == Math.signum((float) (this.f19361b.f19367c - this.f19361b.f19365a)) && Math.signum(f3) == Math.signum((float) (this.f19362c.f19367c - this.f19362c.f19365a));
        }
        return invokeCommon.booleanValue;
    }

    public void i(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) {
            this.f19361b.q(i2, i3, i4);
        }
    }

    public final void j(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f19361b.s(f2);
            this.f19362c.s(f2);
        }
    }

    public void k(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interpolator) == null) {
            this.f19363d = interpolator;
        }
    }

    public boolean l(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            this.f19360a = 1;
            return this.f19361b.t(i2, i4, i5) || this.f19362c.t(i3, i6, i7);
        }
        return invokeCommon.booleanValue;
    }

    public void m(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.f19360a = 0;
            this.f19361b.w(i2, i4, i6);
            this.f19362c.w(i3, i5, i6);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f19363d = interpolator;
        this.f19364e = z;
        this.f19361b = new a(context);
        this.f19362c = new a(context);
    }
}
