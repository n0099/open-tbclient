package com.baidu.swan.apps.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.c;
import d.a.n0.a.r1.l.b;
import d.a.n0.k.d;
/* loaded from: classes3.dex */
public class SwanAppLaunchCircleAnimationView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f11571e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f11572f;

    /* renamed from: g  reason: collision with root package name */
    public int f11573g;

    /* renamed from: h  reason: collision with root package name */
    public int f11574h;

    /* renamed from: i  reason: collision with root package name */
    public Float f11575i;
    public ValueAnimator j;
    public long k;
    public boolean l;
    public RectF m;
    public float n;
    public int o;
    public float p;
    public float q;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppLaunchCircleAnimationView f11576e;

        public a(SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppLaunchCircleAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11576e = swanAppLaunchCircleAnimationView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f11576e.f11575i = (Float) valueAnimator.getAnimatedValue();
                SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = this.f11576e;
                swanAppLaunchCircleAnimationView.p = (swanAppLaunchCircleAnimationView.getWidth() - ((this.f11576e.o * 6.0f) / 96.0f)) / 2.0f;
                if (this.f11576e.f11575i.floatValue() <= 0.3f) {
                    SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView2 = this.f11576e;
                    swanAppLaunchCircleAnimationView2.n = ((float) (((swanAppLaunchCircleAnimationView2.f11575i.floatValue() * 0.26d) / 0.3d) + 0.04d)) * 360.0f;
                } else {
                    SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView3 = this.f11576e;
                    swanAppLaunchCircleAnimationView3.n = ((float) (0.3d - (((swanAppLaunchCircleAnimationView3.f11575i.floatValue() - 0.3d) * 0.26d) / 0.7d))) * 360.0f;
                }
                SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView4 = this.f11576e;
                swanAppLaunchCircleAnimationView4.q = (swanAppLaunchCircleAnimationView4.f11575i.floatValue() * 360.0f) - 90.0f;
                this.f11576e.postInvalidate();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppLaunchCircleAnimationView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11571e = new Paint();
        this.f11572f = new Paint();
        this.m = null;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k = System.currentTimeMillis();
            this.f11574h = getResources().getColor(c.app_Launch_Gray_Arc_Color);
            this.f11573g = getResources().getColor(c.app_Launch_Blue_Arc_Color);
            this.f11571e.setColor(this.f11574h);
            this.f11571e.setAntiAlias(true);
            this.f11571e.setStyle(Paint.Style.STROKE);
            this.f11572f.setColor(this.f11573g);
            this.f11572f.setAntiAlias(true);
            this.f11572f.setStyle(Paint.Style.STROKE);
            this.f11572f.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            g();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.j = ofFloat;
            ofFloat.setInterpolator(new d(0.4f, 0.0f, 0.6f, 1.0f));
            this.j.setRepeatCount(-1);
            this.j.setRepeatMode(1);
            this.j.setDuration(800L);
            if (!this.l) {
                this.j.setCurrentPlayTime(500L);
            } else if (b.d() == 3) {
                this.j.setDuration(500L);
            }
            this.j.addUpdateListener(new a(this));
            this.j.start();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.j.cancel();
            }
            this.l = false;
        }
    }

    public void j(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048579, this, f2) == null) || System.currentTimeMillis() - this.k < 1120) {
            return;
        }
        i();
        Float valueOf = Float.valueOf(f2);
        this.f11575i = valueOf;
        this.q = -90.0f;
        this.n = valueOf.floatValue() * 360.0f;
        postInvalidate();
        if (f2 == 1.0f) {
            this.l = true;
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.j.cancel();
            }
            h();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            int i2 = this.o;
            canvas.drawCircle(i2, i2, this.p, this.f11571e);
            canvas.drawArc(this.m, this.q, this.n, false, this.f11572f);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            int width = getWidth() / 2;
            this.o = width;
            this.f11571e.setStrokeWidth(((float) width) > 99.0f ? (width * 1.0f) / 99.0f : 1.0f);
            this.f11572f.setStrokeWidth((this.o * 6) / 99.0f);
            int i6 = this.o;
            this.m = new RectF(((i6 * 3.0f) / 96.0f) + 1.0f, ((i6 * 3.0f) / 96.0f) + 1.0f, (getWidth() - ((this.o * 3.0f) / 96.0f)) - 1.0f, (getHeight() - ((this.o * 3.0f) / 96.0f)) - 1.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppLaunchCircleAnimationView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11571e = new Paint();
        this.f11572f = new Paint();
        this.m = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppLaunchCircleAnimationView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f11571e = new Paint();
        this.f11572f = new Paint();
        this.m = null;
    }
}
