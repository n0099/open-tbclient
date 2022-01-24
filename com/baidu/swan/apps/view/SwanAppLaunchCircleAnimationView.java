package com.baidu.swan.apps.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import c.a.r0.a.c;
import c.a.r0.n.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SwanAppLaunchCircleAnimationView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f39464e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f39465f;

    /* renamed from: g  reason: collision with root package name */
    public int f39466g;

    /* renamed from: h  reason: collision with root package name */
    public int f39467h;

    /* renamed from: i  reason: collision with root package name */
    public Float f39468i;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator f39469j;
    public long k;
    public boolean l;
    public RectF m;
    public float n;
    public int o;
    public float p;
    public float q;

    /* loaded from: classes11.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppLaunchCircleAnimationView f39470e;

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
            this.f39470e = swanAppLaunchCircleAnimationView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f39470e.f39468i = (Float) valueAnimator.getAnimatedValue();
                SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = this.f39470e;
                swanAppLaunchCircleAnimationView.p = (swanAppLaunchCircleAnimationView.getWidth() - ((this.f39470e.o * 6.0f) / 96.0f)) / 2.0f;
                if (this.f39470e.f39468i.floatValue() <= 0.3f) {
                    SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView2 = this.f39470e;
                    swanAppLaunchCircleAnimationView2.n = ((float) (((swanAppLaunchCircleAnimationView2.f39468i.floatValue() * 0.26d) / 0.3d) + 0.04d)) * 360.0f;
                } else {
                    SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView3 = this.f39470e;
                    swanAppLaunchCircleAnimationView3.n = ((float) (0.3d - (((swanAppLaunchCircleAnimationView3.f39468i.floatValue() - 0.3d) * 0.26d) / 0.7d))) * 360.0f;
                }
                SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView4 = this.f39470e;
                swanAppLaunchCircleAnimationView4.q = (swanAppLaunchCircleAnimationView4.f39468i.floatValue() * 360.0f) - 90.0f;
                this.f39470e.postInvalidate();
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
        this.f39464e = new Paint();
        this.f39465f = new Paint();
        this.m = null;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k = System.currentTimeMillis();
            this.f39467h = getResources().getColor(c.app_Launch_Gray_Arc_Color);
            this.f39466g = getResources().getColor(c.app_Launch_Blue_Arc_Color);
            this.f39464e.setColor(this.f39467h);
            this.f39464e.setAntiAlias(true);
            this.f39464e.setStyle(Paint.Style.STROKE);
            this.f39465f.setColor(this.f39466g);
            this.f39465f.setAntiAlias(true);
            this.f39465f.setStyle(Paint.Style.STROKE);
            this.f39465f.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int i2 = this.o;
            canvas.drawCircle(i2, i2, this.p, this.f39464e);
            canvas.drawArc(this.m, this.q, this.n, false, this.f39465f);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            int width = getWidth() / 2;
            this.o = width;
            this.f39464e.setStrokeWidth(((float) width) > 99.0f ? (width * 1.0f) / 99.0f : 1.0f);
            this.f39465f.setStrokeWidth((this.o * 6) / 99.0f);
            int i6 = this.o;
            this.m = new RectF(((i6 * 3.0f) / 96.0f) + 1.0f, ((i6 * 3.0f) / 96.0f) + 1.0f, (getWidth() - ((this.o * 3.0f) / 96.0f)) - 1.0f, (getHeight() - ((this.o * 3.0f) / 96.0f)) - 1.0f);
        }
    }

    public void startLoadingAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f39469j = ofFloat;
            ofFloat.setInterpolator(new d(0.4f, 0.0f, 0.6f, 1.0f));
            this.f39469j.setRepeatCount(-1);
            this.f39469j.setRepeatMode(1);
            this.f39469j.setDuration(800L);
            if (!this.l) {
                this.f39469j.setCurrentPlayTime(500L);
            } else {
                this.f39469j.setDuration(500L);
            }
            this.f39469j.addUpdateListener(new a(this));
            this.f39469j.start();
        }
    }

    public void stopAllCircleAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ValueAnimator valueAnimator = this.f39469j;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f39469j.cancel();
            }
            this.l = false;
        }
    }

    public void updateDownloadingAnimation(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || System.currentTimeMillis() - this.k < 1120) {
            return;
        }
        stopAllCircleAnimation();
        Float valueOf = Float.valueOf(f2);
        this.f39468i = valueOf;
        this.q = -90.0f;
        this.n = valueOf.floatValue() * 360.0f;
        postInvalidate();
        if (f2 == 1.0f) {
            this.l = true;
            ValueAnimator valueAnimator = this.f39469j;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f39469j.cancel();
            }
            startLoadingAnimation();
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
        this.f39464e = new Paint();
        this.f39465f = new Paint();
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
        this.f39464e = new Paint();
        this.f39465f = new Paint();
        this.m = null;
    }
}
