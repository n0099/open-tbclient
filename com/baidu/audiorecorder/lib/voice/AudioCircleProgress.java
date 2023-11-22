package com.baidu.audiorecorder.lib.voice;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.h16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AudioCircleProgress extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public int b;
    public float c;
    public float d;
    public int e;
    public Paint f;
    public Point g;
    public float h;
    public int i;
    public RectF j;
    public Paint k;
    public Canvas l;
    public float m;
    public float n;
    public float o;
    public ValueAnimator p;
    public float q;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AudioCircleProgress a;

        public a(AudioCircleProgress audioCircleProgress) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioCircleProgress};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = audioCircleProgress;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.invalidate();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioCircleProgress(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioCircleProgress(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d(context, attributeSet);
    }

    public final void g(float f, float f2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j)}) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
            this.p = ofFloat;
            ofFloat.setDuration(j);
            this.p.setInterpolator(new LinearInterpolator());
            this.p.addUpdateListener(new a(this));
            this.p.start();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.save();
            float f = this.n * this.o;
            float f2 = this.m;
            Point point = this.g;
            canvas.rotate(f2, point.x, point.y);
            canvas.drawArc(this.j, 0.0f, f, false, this.a);
            canvas.restore();
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            Point point = this.g;
            canvas.drawCircle(point.x, point.y, this.i, this.k);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            this.l = canvas;
            c(canvas);
            b(canvas);
        }
    }

    public void setArcColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.b = i;
            this.a.setColor(i);
            invalidate();
        }
    }

    public void setArcWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.c = i;
        }
    }

    public void setBgColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.k.setColor(i);
            invalidate();
        }
    }

    public void setPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            setPadding(i, i, i, i);
        }
    }

    public void setProgress(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f) == null) {
            float f2 = this.o;
            if (f2 != f) {
                g(f2, f, 200L);
            }
        }
    }

    public final void d(Context context, @Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            this.j = new RectF();
            this.g = new Point();
            this.p = new ValueAnimator();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h16.voiceCircleProgress);
            this.b = obtainStyledAttributes.getColor(0, SkinManager.getColor(R.color.CAM_X0302));
            this.e = obtainStyledAttributes.getColor(2, 0);
            this.c = obtainStyledAttributes.getDimension(1, 15.0f);
            this.d = obtainStyledAttributes.getDimension(1, 15.0f);
            this.m = obtainStyledAttributes.getFloat(5, 270.0f);
            this.n = obtainStyledAttributes.getFloat(6, 360.0f);
            this.q = BdUtilHelper.getDimens(context, R.dimen.tbds25);
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Paint paint = new Paint();
            this.a = paint;
            paint.setAntiAlias(true);
            this.a.setColor(this.b);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(this.c);
            this.a.setStrokeCap(Paint.Cap.ROUND);
            Paint paint2 = new Paint();
            this.f = paint2;
            paint2.setColor(this.e);
            this.f.setStyle(Paint.Style.STROKE);
            this.f.setStrokeWidth(this.d);
            this.f.setStrokeCap(Paint.Cap.ROUND);
            Paint paint3 = new Paint();
            this.k = paint3;
            paint3.setAntiAlias(true);
            this.k.setStyle(Paint.Style.FILL);
            this.k.setShadowLayer(this.q, 0.0f, 0.0f, SkinManager.getColor(R.color.CAM_X0602));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.l != null) {
                this.o = 0.0f;
                invalidate();
            }
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            float max = Math.max(this.c, this.d);
            int i5 = ((int) max) * 2;
            float min = Math.min((((i - getPaddingLeft()) - getPaddingRight()) - i5) - (((int) this.q) * 2), (((i2 - getPaddingTop()) - getPaddingBottom()) - i5) - (((int) this.q) * 2)) / 2;
            this.h = min;
            this.i = (i - (((int) this.q) * 2)) / 2;
            Point point = this.g;
            int i6 = i / 2;
            point.x = i6;
            int i7 = i2 / 2;
            point.y = i7;
            RectF rectF = this.j;
            float f = max / 2.0f;
            rectF.left = (i6 - min) - f;
            rectF.top = (i7 - min) - f;
            rectF.right = i6 + min + f;
            rectF.bottom = i7 + min + f;
        }
    }
}
