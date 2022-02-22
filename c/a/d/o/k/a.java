package c.a.d.o.k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends Drawable implements Animatable {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator p;
    public static final Interpolator q;
    public static final int[] r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<Animation> f2547e;

    /* renamed from: f  reason: collision with root package name */
    public final d f2548f;

    /* renamed from: g  reason: collision with root package name */
    public float f2549g;

    /* renamed from: h  reason: collision with root package name */
    public Resources f2550h;

    /* renamed from: i  reason: collision with root package name */
    public View f2551i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f2552j;
    public float k;
    public double l;
    public double m;
    public boolean n;
    public final Drawable.Callback o;

    /* renamed from: c.a.d.o.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0063a extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f2553e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f2554f;

        public C0063a(a aVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2554f = aVar;
            this.f2553e = dVar;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                a aVar = this.f2554f;
                if (aVar.n) {
                    aVar.a(f2, this.f2553e);
                    return;
                }
                float c2 = aVar.c(this.f2553e);
                float j2 = this.f2553e.j();
                float l = this.f2553e.l();
                float k = this.f2553e.k();
                this.f2554f.m(f2, this.f2553e);
                if (f2 <= 0.5f) {
                    this.f2553e.D(l + ((0.8f - c2) * a.q.getInterpolation(f2 / 0.5f)));
                }
                if (f2 > 0.5f) {
                    this.f2553e.z(j2 + ((0.8f - c2) * a.q.getInterpolation((f2 - 0.5f) / 0.5f)));
                }
                this.f2553e.B(k + (0.25f * f2));
                a aVar2 = this.f2554f;
                aVar2.h((f2 * 216.0f) + ((aVar2.k / 5.0f) * 1080.0f));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f2555b;

        public b(a aVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2555b = aVar;
            this.a = dVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                this.a.F();
                this.a.n();
                d dVar = this.a;
                dVar.D(dVar.e());
                a aVar = this.f2555b;
                if (aVar.n) {
                    aVar.n = false;
                    animation.setDuration(1332L);
                    this.a.C(false);
                    return;
                }
                aVar.k = (aVar.k + 1.0f) % 5.0f;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.f2555b.k = 0.0f;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Drawable.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2556e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2556e = aVar;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.f2556e.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{drawable, runnable, Long.valueOf(j2)}) == null) {
                this.f2556e.scheduleSelf(runnable, j2);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, drawable, runnable) == null) {
                this.f2556e.unscheduleSelf(runnable);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RectF a;

        /* renamed from: b  reason: collision with root package name */
        public final Paint f2557b;

        /* renamed from: c  reason: collision with root package name */
        public final Paint f2558c;

        /* renamed from: d  reason: collision with root package name */
        public final Drawable.Callback f2559d;

        /* renamed from: e  reason: collision with root package name */
        public float f2560e;

        /* renamed from: f  reason: collision with root package name */
        public float f2561f;

        /* renamed from: g  reason: collision with root package name */
        public float f2562g;

        /* renamed from: h  reason: collision with root package name */
        public float f2563h;

        /* renamed from: i  reason: collision with root package name */
        public float f2564i;

        /* renamed from: j  reason: collision with root package name */
        public int[] f2565j;
        public int k;
        public float l;
        public float m;
        public float n;
        public boolean o;
        public Path p;
        public float q;
        public double r;
        public int s;
        public int t;
        public int u;
        public final Paint v;
        public int w;
        public int x;

        public d(Drawable.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new RectF();
            this.f2557b = new Paint();
            this.f2558c = new Paint();
            this.f2560e = 0.0f;
            this.f2561f = 0.0f;
            this.f2562g = 0.0f;
            this.f2563h = 5.0f;
            this.f2564i = 2.5f;
            this.v = new Paint(1);
            this.f2559d = callback;
            this.f2557b.setStrokeCap(Paint.Cap.SQUARE);
            this.f2557b.setAntiAlias(true);
            this.f2557b.setStyle(Paint.Style.STROKE);
            this.f2558c.setStyle(Paint.Style.FILL);
            this.f2558c.setAntiAlias(true);
        }

        public void A(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                float min = Math.min(i2, i3);
                double d2 = this.r;
                this.f2564i = (float) ((d2 <= 0.0d || min < 0.0f) ? Math.ceil(this.f2563h / 2.0f) : (min / 2.0f) - d2);
            }
        }

        public void B(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                this.f2562g = f2;
                o();
            }
        }

        public void C(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.o == z) {
                return;
            }
            this.o = z;
            o();
        }

        public void D(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                this.f2560e = f2;
                o();
            }
        }

        public void E(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
                this.f2563h = f2;
                this.f2557b.setStrokeWidth(f2);
                o();
            }
        }

        public void F() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.l = this.f2560e;
                this.m = this.f2561f;
                this.n = this.f2562g;
            }
        }

        public void a(Canvas canvas, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, canvas, rect) == null) {
                RectF rectF = this.a;
                rectF.set(rect);
                float f2 = this.f2564i;
                rectF.inset(f2, f2);
                float f3 = this.f2560e;
                float f4 = this.f2562g;
                float f5 = (f3 + f4) * 360.0f;
                float f6 = ((this.f2561f + f4) * 360.0f) - f5;
                this.f2557b.setColor(this.x);
                canvas.drawArc(rectF, f5, f6, false, this.f2557b);
                b(canvas, f5, f6, rect);
                if (this.u < 255) {
                    this.v.setColor(this.w);
                    this.v.setAlpha(255 - this.u);
                    canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.v);
                }
            }
        }

        public final void b(Canvas canvas, float f2, float f3, Rect rect) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3), rect}) == null) && this.o) {
                Path path = this.p;
                if (path == null) {
                    Path path2 = new Path();
                    this.p = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f4 = (((int) this.f2564i) / 2) * this.q;
                float sin = (float) ((this.r * Math.sin(0.0d)) + rect.exactCenterY());
                this.p.moveTo(0.0f, 0.0f);
                this.p.lineTo(this.s * this.q, 0.0f);
                Path path3 = this.p;
                float f5 = this.q;
                path3.lineTo((this.s * f5) / 2.0f, this.t * f5);
                this.p.offset(((float) ((this.r * Math.cos(0.0d)) + rect.exactCenterX())) - f4, sin);
                this.p.close();
                this.f2558c.setColor(this.x);
                canvas.rotate((f2 + f3) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.p, this.f2558c);
            }
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.u : invokeV.intValue;
        }

        public double d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.doubleValue;
        }

        public float e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2561f : invokeV.floatValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f2565j[g()] : invokeV.intValue;
        }

        public final int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.k + 1) % this.f2565j.length : invokeV.intValue;
        }

        public float h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f2560e : invokeV.floatValue;
        }

        public int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f2565j[this.k] : invokeV.intValue;
        }

        public float j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m : invokeV.floatValue;
        }

        public float k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.n : invokeV.floatValue;
        }

        public float l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : invokeV.floatValue;
        }

        public float m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f2563h : invokeV.floatValue;
        }

        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
                x(g());
            }
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                this.f2559d.invalidateDrawable(null);
            }
        }

        public void p() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
                this.l = 0.0f;
                this.m = 0.0f;
                this.n = 0.0f;
                D(0.0f);
                z(0.0f);
                B(0.0f);
            }
        }

        public void q(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
                this.u = i2;
            }
        }

        public void r(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.s = (int) f2;
                this.t = (int) f3;
            }
        }

        public void s(float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048600, this, f2) == null) || f2 == this.q) {
                return;
            }
            this.q = f2;
            o();
        }

        public void t(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
                this.w = i2;
            }
        }

        public void u(double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Double.valueOf(d2)}) == null) {
                this.r = d2;
            }
        }

        public void v(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
                this.x = i2;
            }
        }

        public void w(ColorFilter colorFilter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, colorFilter) == null) {
                this.f2557b.setColorFilter(colorFilter);
                o();
            }
        }

        public void x(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
                this.k = i2;
                this.x = this.f2565j[i2];
            }
        }

        public void y(@NonNull int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048606, this, iArr) == null) {
                this.f2565j = iArr;
                x(0);
            }
        }

        public void z(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048607, this, f2) == null) {
                this.f2561f = f2;
                o();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-244975825, "Lc/a/d/o/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-244975825, "Lc/a/d/o/k/a;");
                return;
            }
        }
        p = new LinearInterpolator();
        q = new FastOutSlowInInterpolator();
        r = new int[]{-16777216};
    }

    public a(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2547e = new ArrayList<>();
        this.o = new c(this);
        this.f2551i = view;
        this.f2550h = context.getResources();
        d dVar = new d(this.o);
        this.f2548f = dVar;
        dVar.y(r);
        n(1);
        k();
    }

    public void a(float f2, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), dVar}) == null) {
            m(f2, dVar);
            dVar.D(dVar.l() + (((dVar.j() - c(dVar)) - dVar.l()) * f2));
            dVar.z(dVar.j());
            dVar.B(dVar.k() + ((((float) (Math.floor(dVar.k() / 0.8f) + 1.0d)) - dVar.k()) * f2));
        }
    }

    public final int b(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int intValue = Integer.valueOf(i2).intValue();
            int i4 = (intValue >> 24) & 255;
            int i5 = (intValue >> 16) & 255;
            int i6 = (intValue >> 8) & 255;
            int i7 = intValue & 255;
            int intValue2 = Integer.valueOf(i3).intValue();
            return ((i4 + ((int) ((((intValue2 >> 24) & 255) - i4) * f2))) << 24) | ((i5 + ((int) ((((intValue2 >> 16) & 255) - i5) * f2))) << 16) | ((i6 + ((int) ((((intValue2 >> 8) & 255) - i6) * f2))) << 8) | (i7 + ((int) (f2 * ((intValue2 & 255) - i7))));
        }
        return invokeCommon.intValue;
    }

    public float c(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) ? (float) Math.toRadians(dVar.m() / (dVar.d() * 6.283185307179586d)) : invokeL.floatValue;
    }

    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.f2548f.s(f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            Rect bounds = getBounds();
            int save = canvas.save();
            canvas.rotate(this.f2549g, bounds.exactCenterX(), bounds.exactCenterY());
            this.f2548f.a(canvas, bounds);
            if (save < 1 || save > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(save);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f2548f.t(i2);
        }
    }

    public void f(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
            this.f2548f.y(iArr);
            this.f2548f.x(0);
        }
    }

    public void g(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.f2548f.B(f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2548f.c() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (int) this.m : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (int) this.l : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public void h(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            this.f2549g = f2;
            invalidateSelf();
        }
    }

    public final void i(double d2, double d3, double d4, double d5, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            d dVar = this.f2548f;
            float f4 = this.f2550h.getDisplayMetrics().density;
            double d6 = f4;
            this.l = d2 * d6;
            this.m = d3 * d6;
            dVar.E(((float) d5) * f4);
            dVar.u(d4 * d6);
            dVar.x(0);
            dVar.r(f2 * f4, f3 * f4);
            dVar.A((int) this.l, (int) this.m);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ArrayList<Animation> arrayList = this.f2547e;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Animation animation = arrayList.get(i2);
                if (animation.hasStarted() && !animation.hasEnded()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f2548f.D(f2);
            this.f2548f.z(f3);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            d dVar = this.f2548f;
            C0063a c0063a = new C0063a(this, dVar);
            c0063a.setRepeatCount(-1);
            c0063a.setRepeatMode(1);
            c0063a.setInterpolator(p);
            c0063a.setAnimationListener(new b(this, dVar));
            this.f2552j = c0063a;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f2548f.C(z);
        }
    }

    public void m(float f2, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), dVar}) == null) || f2 <= 0.75f) {
            return;
        }
        dVar.v(b((f2 - 0.75f) / 0.25f, dVar.i(), dVar.f()));
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            if (i2 == 0) {
                i(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
            } else {
                i(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f2548f.q(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, colorFilter) == null) {
            this.f2548f.w(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f2552j.reset();
            this.f2548f.F();
            if (this.f2548f.e() != this.f2548f.h()) {
                this.n = true;
                this.f2552j.setDuration(666L);
                this.f2551i.startAnimation(this.f2552j);
                return;
            }
            this.f2548f.x(0);
            this.f2548f.p();
            this.f2552j.setDuration(1332L);
            this.f2551i.startAnimation(this.f2552j);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f2551i.clearAnimation();
            h(0.0f);
            this.f2548f.C(false);
            this.f2548f.x(0);
            this.f2548f.p();
        }
    }
}
