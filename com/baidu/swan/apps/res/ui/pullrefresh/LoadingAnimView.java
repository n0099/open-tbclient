package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import c.a.q0.a.c;
import c.a.q0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class LoadingAnimView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f40321e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f40322f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f40323g;

    /* renamed from: h  reason: collision with root package name */
    public Canvas f40324h;

    /* renamed from: i  reason: collision with root package name */
    public Camera f40325i;

    /* renamed from: j  reason: collision with root package name */
    public Matrix f40326j;

    /* renamed from: k  reason: collision with root package name */
    public Paint f40327k;

    /* loaded from: classes10.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoadingAnimView f40328e;

        public a(LoadingAnimView loadingAnimView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingAnimView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40328e = loadingAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 0.4f) {
                    this.f40328e.f40321e = (floatValue / 0.4f) * 0.25f;
                } else if (floatValue < 0.6f) {
                    this.f40328e.f40321e = (((floatValue - 0.4f) / 0.2f) * 0.5f) + 0.25f;
                } else {
                    this.f40328e.f40321e = (((floatValue - 0.6f) / 0.4f) * 0.25f) + 0.75f;
                }
                this.f40328e.postInvalidate();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingAnimView(Context context) {
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
        this.f40321e = 0.0f;
        init();
    }

    public final void b() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.f40322f) == null) {
            return;
        }
        valueAnimator.setRepeatCount(0);
        this.f40322f.removeAllUpdateListeners();
        this.f40322f.removeAllListeners();
        this.f40322f.end();
        this.f40322f.cancel();
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.f40327k = paint;
            paint.setAntiAlias(true);
            this.f40325i = new Camera();
            this.f40326j = new Matrix();
            startAnim();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f40323g == null || this.f40324h == null) {
                return;
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int f2 = n0.f(getContext(), 6.0f);
            this.f40323g.eraseColor(0);
            this.f40327k.setStyle(Paint.Style.FILL);
            this.f40327k.setColor(getResources().getColor(c.aiapps_pull_load_footer_image_color));
            this.f40327k.setAlpha((int) ((((1.0d - (Math.abs(this.f40321e - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d));
            float f3 = measuredWidth / 2.0f;
            float f4 = measuredHeight / 2.0f;
            this.f40324h.drawCircle(f3, f4, f2, this.f40327k);
            this.f40326j.reset();
            this.f40325i.save();
            this.f40325i.setLocation(0.0f, 0.0f, -100.0f);
            this.f40325i.rotateY(this.f40321e * 360.0f);
            this.f40325i.getMatrix(this.f40326j);
            this.f40325i.restore();
            this.f40326j.preTranslate((-measuredWidth) / 2.0f, (-measuredHeight) / 2.0f);
            this.f40326j.postTranslate(f3, f4);
            canvas.drawBitmap(this.f40323g, this.f40326j, null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f40323g = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.f40324h = new Canvas(this.f40323g);
        }
    }

    public void startAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f40322f != null) {
                b();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f40322f = ofFloat;
            ofFloat.setDuration(750L);
            this.f40322f.setRepeatCount(20);
            this.f40322f.setRepeatMode(1);
            this.f40322f.setInterpolator(new LinearInterpolator());
            this.f40322f.addUpdateListener(new a(this));
            if (this.f40322f.isRunning()) {
                return;
            }
            this.f40322f.start();
        }
    }

    public void stopAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b();
            clearAnimation();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingAnimView(Context context, AttributeSet attributeSet) {
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
        this.f40321e = 0.0f;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingAnimView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f40321e = 0.0f;
        init();
    }
}
