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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c;
import d.a.o0.a.v2.n0;
/* loaded from: classes3.dex */
public class LoadingAnimView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f11399e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f11400f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f11401g;

    /* renamed from: h  reason: collision with root package name */
    public Canvas f11402h;

    /* renamed from: i  reason: collision with root package name */
    public Camera f11403i;
    public Matrix j;
    public Paint k;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoadingAnimView f11404e;

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
            this.f11404e = loadingAnimView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 0.4f) {
                    this.f11404e.f11399e = (floatValue / 0.4f) * 0.25f;
                } else if (floatValue < 0.6f) {
                    this.f11404e.f11399e = (((floatValue - 0.4f) / 0.2f) * 0.5f) + 0.25f;
                } else {
                    this.f11404e.f11399e = (((floatValue - 0.6f) / 0.4f) * 0.25f) + 0.75f;
                }
                this.f11404e.postInvalidate();
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
        this.f11399e = 0.0f;
        b();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Paint paint = new Paint();
            this.k = paint;
            paint.setAntiAlias(true);
            this.f11403i = new Camera();
            this.j = new Matrix();
            d();
        }
    }

    public final void c() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (valueAnimator = this.f11400f) == null) {
            return;
        }
        valueAnimator.setRepeatCount(0);
        this.f11400f.removeAllUpdateListeners();
        this.f11400f.removeAllListeners();
        this.f11400f.end();
        this.f11400f.cancel();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f11400f != null) {
                c();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f11400f = ofFloat;
            ofFloat.setDuration(750L);
            this.f11400f.setRepeatCount(20);
            this.f11400f.setRepeatMode(1);
            this.f11400f.setInterpolator(new LinearInterpolator());
            this.f11400f.addUpdateListener(new a(this));
            if (this.f11400f.isRunning()) {
                return;
            }
            this.f11400f.start();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c();
            clearAnimation();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f11401g == null || this.f11402h == null) {
                return;
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int f2 = n0.f(getContext(), 6.0f);
            this.f11401g.eraseColor(0);
            this.k.setStyle(Paint.Style.FILL);
            this.k.setColor(getResources().getColor(c.aiapps_pull_load_footer_image_color));
            this.k.setAlpha((int) ((((1.0d - (Math.abs(this.f11399e - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d));
            float f3 = measuredWidth / 2.0f;
            float f4 = measuredHeight / 2.0f;
            this.f11402h.drawCircle(f3, f4, f2, this.k);
            this.j.reset();
            this.f11403i.save();
            this.f11403i.setLocation(0.0f, 0.0f, -100.0f);
            this.f11403i.rotateY(this.f11399e * 360.0f);
            this.f11403i.getMatrix(this.j);
            this.f11403i.restore();
            this.j.preTranslate((-measuredWidth) / 2.0f, (-measuredHeight) / 2.0f);
            this.j.postTranslate(f3, f4);
            canvas.drawBitmap(this.f11401g, this.j, null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f11401g = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.f11402h = new Canvas(this.f11401g);
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
        this.f11399e = 0.0f;
        b();
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
        this.f11399e = 0.0f;
        b();
    }
}
