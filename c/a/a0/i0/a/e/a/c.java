package c.a.a0.i0.a.e.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.f;
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
    public final Rect f1221b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable.Callback f1222c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f1223d;

    /* renamed from: e  reason: collision with root package name */
    public long f1224e;

    /* renamed from: f  reason: collision with root package name */
    public float f1225f;

    /* renamed from: g  reason: collision with root package name */
    public float f1226g;

    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.f();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
        this.f1221b = new Rect();
        e(context);
        m();
    }

    public void b(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
            this.f1223d.addListener(animatorListener);
        }
    }

    public abstract void c(float f2);

    public abstract void d(Canvas canvas);

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f1225f = f.c.a(context, 31.0f);
            this.f1226g = f.c.a(context, 31.0f);
            this.f1224e = 1333L;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f1222c.invalidateDrawable(null);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1223d.isRunning() : invokeV.booleanValue;
    }

    public abstract void h();

    public abstract void i(int i);

    public void j(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect) == null) {
            this.f1221b.set(rect);
        }
    }

    public void k(Drawable.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, callback) == null) {
            this.f1222c = callback;
        }
    }

    public abstract void l(ColorFilter colorFilter);

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f1223d = ofFloat;
            ofFloat.setRepeatCount(-1);
            this.f1223d.setRepeatMode(1);
            this.f1223d.setDuration(this.f1224e);
            this.f1223d.setInterpolator(new LinearInterpolator());
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            h();
            this.f1223d.addUpdateListener(this.a);
            this.f1223d.setRepeatCount(-1);
            this.f1223d.setDuration(this.f1224e);
            this.f1223d.setStartDelay(200L);
            this.f1223d.start();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f1223d.removeUpdateListener(this.a);
            this.f1223d.setRepeatCount(0);
            this.f1223d.setDuration(0L);
            this.f1223d.end();
        }
    }
}
