package c.a.b0.i0.a.e.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.h0.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ValueAnimator.AnimatorUpdateListener a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f1576b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable.Callback f1577c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f1578d;

    /* renamed from: e  reason: collision with root package name */
    public long f1579e;

    /* renamed from: f  reason: collision with root package name */
    public float f1580f;

    /* renamed from: g  reason: collision with root package name */
    public float f1581g;

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f1582e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1582e = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f1582e.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f1582e.f();
            }
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
        this.f1576b = new Rect();
        e(context);
        m();
    }

    public void b(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
            this.f1578d.addListener(animatorListener);
        }
    }

    public abstract void c(float f2);

    public abstract void d(Canvas canvas);

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f1580f = f.c.a(context, 31.0f);
            this.f1581g = f.c.a(context, 31.0f);
            this.f1579e = 1333L;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f1577c.invalidateDrawable(null);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1578d.isRunning() : invokeV.booleanValue;
    }

    public abstract void h();

    public abstract void i(int i2);

    public void j(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect) == null) {
            this.f1576b.set(rect);
        }
    }

    public void k(Drawable.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, callback) == null) {
            this.f1577c = callback;
        }
    }

    public abstract void l(ColorFilter colorFilter);

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f1578d = ofFloat;
            ofFloat.setRepeatCount(-1);
            this.f1578d.setRepeatMode(1);
            this.f1578d.setDuration(this.f1579e);
            this.f1578d.setInterpolator(new LinearInterpolator());
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            h();
            this.f1578d.addUpdateListener(this.a);
            this.f1578d.setRepeatCount(-1);
            this.f1578d.setDuration(this.f1579e);
            this.f1578d.setStartDelay(200L);
            this.f1578d.start();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f1578d.removeUpdateListener(this.a);
            this.f1578d.setRepeatCount(0);
            this.f1578d.setDuration(0L);
            this.f1578d.end();
        }
    }
}
