package c.a.a0.i0.a.e.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.f;
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
    public final Paint f1227h;
    public final RectF i;
    public int j;
    public float k;
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
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationRepeat(animator);
                this.a.y();
                d dVar = this.a;
                dVar.o = dVar.n;
                d dVar2 = this.a;
                dVar2.l = (dVar2.l + 1.0f) % 5.0f;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.l = 0.0f;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1791700107, "Lc/a/a0/i0/a/e/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1791700107, "Lc/a/a0/i0/a/e/a/d;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1227h = new Paint();
        this.i = new RectF();
        u(context);
        x();
        b(new a(this));
    }

    @Override // c.a.a0.i0.a.e.a.c
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

    @Override // c.a.a0.i0.a.e.a.c
    public void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int save = canvas.save();
            this.i.set(this.f1221b);
            RectF rectF = this.i;
            float f2 = this.k;
            rectF.inset(f2, f2);
            canvas.rotate(this.m, this.i.centerX(), this.i.centerY());
            if (this.p != 0.0f) {
                this.f1227h.setColor(this.j);
                canvas.drawArc(this.i, this.o, this.p, false, this.f1227h);
            }
            canvas.restoreToCount(save);
        }
    }

    @Override // c.a.a0.i0.a.e.a.c
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w();
        }
    }

    @Override // c.a.a0.i0.a.e.a.c
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f1227h.setAlpha(i);
        }
    }

    @Override // c.a.a0.i0.a.e.a.c
    public void l(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, colorFilter) == null) {
            this.f1227h.setColorFilter(colorFilter);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.s = f.c.a(context, 2.0f);
            this.t = f.c.a(context, 11.5f);
            this.j = -1;
            v(this.f1225f, this.f1226g);
        }
    }

    public final void v(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.k = Math.max((Math.min(f2, f3) / 2.0f) - this.t, (float) Math.ceil(this.s / 2.0f));
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
            this.f1227h.setAntiAlias(true);
            this.f1227h.setStrokeWidth(this.s);
            this.f1227h.setStyle(Paint.Style.STROKE);
            this.f1227h.setStrokeCap(Paint.Cap.SQUARE);
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
