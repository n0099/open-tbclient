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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.l64;
/* loaded from: classes2.dex */
public class SwanAppLaunchCircleAnimationView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public Paint b;
    public int c;
    public int d;
    public Float e;
    public ValueAnimator f;
    public long g;
    public boolean h;
    public RectF i;
    public float j;
    public int k;
    public float l;
    public float m;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppLaunchCircleAnimationView a;

        public a(SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppLaunchCircleAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppLaunchCircleAnimationView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.e = (Float) valueAnimator.getAnimatedValue();
                SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = this.a;
                swanAppLaunchCircleAnimationView.l = (swanAppLaunchCircleAnimationView.getWidth() - ((this.a.k * 6.0f) / 96.0f)) / 2.0f;
                if (this.a.e.floatValue() <= 0.3f) {
                    SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView2 = this.a;
                    swanAppLaunchCircleAnimationView2.j = ((float) (((swanAppLaunchCircleAnimationView2.e.floatValue() * 0.26d) / 0.3d) + 0.04d)) * 360.0f;
                } else {
                    SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView3 = this.a;
                    swanAppLaunchCircleAnimationView3.j = ((float) (0.3d - (((swanAppLaunchCircleAnimationView3.e.floatValue() - 0.3d) * 0.26d) / 0.7d))) * 360.0f;
                }
                SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView4 = this.a;
                swanAppLaunchCircleAnimationView4.m = (swanAppLaunchCircleAnimationView4.e.floatValue() * 360.0f) - 90.0f;
                this.a.postInvalidate();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Paint();
        this.b = new Paint();
        this.i = null;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = System.currentTimeMillis();
            this.d = getResources().getColor(R.color.obfuscated_res_0x7f0603fa);
            this.c = getResources().getColor(R.color.obfuscated_res_0x7f0603f8);
            this.a.setColor(this.d);
            this.a.setAntiAlias(true);
            this.a.setStyle(Paint.Style.STROKE);
            this.b.setColor(this.c);
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.STROKE);
            this.b.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            g();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f = ofFloat;
            ofFloat.setInterpolator(new l64(0.4f, 0.0f, 0.6f, 1.0f));
            this.f.setRepeatCount(-1);
            this.f.setRepeatMode(1);
            this.f.setDuration(800L);
            if (!this.h) {
                this.f.setCurrentPlayTime(500L);
            } else {
                this.f.setDuration(500L);
            }
            this.f.addUpdateListener(new a(this));
            this.f.start();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f.cancel();
            }
            this.h = false;
        }
    }

    public void j(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048579, this, f) == null) || System.currentTimeMillis() - this.g < 1120) {
            return;
        }
        i();
        Float valueOf = Float.valueOf(f);
        this.e = valueOf;
        this.m = -90.0f;
        this.j = valueOf.floatValue() * 360.0f;
        postInvalidate();
        if (f == 1.0f) {
            this.h = true;
            ValueAnimator valueAnimator = this.f;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.f.cancel();
            }
            h();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            int i = this.k;
            canvas.drawCircle(i, i, this.l, this.a);
            canvas.drawArc(this.i, this.m, this.j, false, this.b);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            int width = getWidth() / 2;
            this.k = width;
            this.a.setStrokeWidth(((float) width) > 99.0f ? (width * 1.0f) / 99.0f : 1.0f);
            this.b.setStrokeWidth((this.k * 6) / 99.0f);
            int i5 = this.k;
            this.i = new RectF(((i5 * 3.0f) / 96.0f) + 1.0f, ((i5 * 3.0f) / 96.0f) + 1.0f, (getWidth() - ((this.k * 3.0f) / 96.0f)) - 1.0f, (getHeight() - ((this.k * 3.0f) / 96.0f)) - 1.0f);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Paint();
        this.b = new Paint();
        this.i = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppLaunchCircleAnimationView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new Paint();
        this.b = new Paint();
        this.i = null;
    }
}
