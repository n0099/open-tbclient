package c.a.c0.e0.a.e.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public static final b u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f1910h;

    /* renamed from: i  reason: collision with root package name */
    public final RectF f1911i;

    /* renamed from: j  reason: collision with root package name */
    public int f1912j;

    /* renamed from: k  reason: collision with root package name */
    public float f1913k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f1914e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1914e = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationRepeat(animator);
                this.f1914e.y();
                d dVar = this.f1914e;
                dVar.o = dVar.n;
                d dVar2 = this.f1914e;
                dVar2.l = (dVar2.l + 1.0f) % 5.0f;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                this.f1914e.l = 0.0f;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-621546299, "Lc/a/c0/e0/a/e/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-621546299, "Lc/a/c0/e0/a/e/a/d;");
                return;
            }
        }
        u = new b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1910h = new Paint();
        this.f1911i = new RectF();
        u(context);
        x();
        b(new a(this));
    }

    @Override // c.a.c0.e0.a.e.a.c
    public void c(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            if (f2 <= 0.5f) {
                this.o = this.r + (u.a(f2 / 0.5f) * 288.0f);
            }
            if (f2 > 0.5f) {
                this.n = this.q + (u.a((f2 - 0.5f) / 0.5f) * 288.0f);
            }
            if (Math.abs(this.n - this.o) > 0.0f) {
                this.p = this.n - this.o;
            }
            this.m = (f2 * 216.0f) + ((this.l / 5.0f) * 1080.0f);
        }
    }

    @Override // c.a.c0.e0.a.e.a.c
    public void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int save = canvas.save();
            this.f1911i.set(this.f1903b);
            RectF rectF = this.f1911i;
            float f2 = this.f1913k;
            rectF.inset(f2, f2);
            canvas.rotate(this.m, this.f1911i.centerX(), this.f1911i.centerY());
            if (this.p != 0.0f) {
                this.f1910h.setColor(this.f1912j);
                canvas.drawArc(this.f1911i, this.o, this.p, false, this.f1910h);
            }
            canvas.restoreToCount(save);
        }
    }

    @Override // c.a.c0.e0.a.e.a.c
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w();
        }
    }

    @Override // c.a.c0.e0.a.e.a.c
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f1910h.setAlpha(i2);
        }
    }

    @Override // c.a.c0.e0.a.e.a.c
    public void l(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, colorFilter) == null) {
            this.f1910h.setColorFilter(colorFilter);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.s = f.c.a(context, 2.0f);
            this.t = f.c.a(context, 11.5f);
            this.f1912j = -1;
            v(this.f1907f, this.f1908g);
        }
    }

    public final void v(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f1913k = Math.max((Math.min(f2, f3) / 2.0f) - this.t, (float) Math.ceil(this.s / 2.0f));
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q = 0.0f;
            this.r = 0.0f;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f1910h.setAntiAlias(true);
            this.f1910h.setStrokeWidth(this.s);
            this.f1910h.setStyle(Paint.Style.STROKE);
            this.f1910h.setStrokeCap(Paint.Cap.SQUARE);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            float f2 = this.n;
            this.q = f2;
            this.r = f2;
        }
    }
}
