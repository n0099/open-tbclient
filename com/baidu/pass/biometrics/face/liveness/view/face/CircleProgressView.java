package com.baidu.pass.biometrics.face.liveness.view.face;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.R;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CircleProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public float b;
    public int c;
    public int d;
    public float e;
    public float f;
    public int g;
    public int h;
    public boolean i;
    public Shader j;
    public int[] k;
    public float l;
    public float m;
    public int n;
    public float o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public b x;

    /* loaded from: classes2.dex */
    public interface b {
        void a(float f, float f2);
    }

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CircleProgressView a;

        public a(CircleProgressView circleProgressView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {circleProgressView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = circleProgressView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
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
        this.c = 270;
        this.d = 360;
        this.g = BdThumbSeekBarView.BUFFERING_PAINT_COLOR;
        this.h = -11637006;
        this.i = true;
        this.k = new int[]{-6311429, -8941322, -8941322, -11637006, -3615745, -6311429};
        this.n = 2;
        this.o = 0.5f;
        this.q = 100;
        this.r = 0;
        this.s = 1500;
        this.u = true;
        this.v = false;
        this.w = true;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pass_liveness_CircleProgressView);
            DisplayMetrics displayMetrics = getDisplayMetrics();
            this.b = TypedValue.applyDimension(1, 6.0f, displayMetrics);
            this.m = TypedValue.applyDimension(1, 5.0f, displayMetrics);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 14) {
                    this.b = obtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 12.0f, displayMetrics));
                } else if (index == 9) {
                    this.g = obtainStyledAttributes.getColor(index, -3618616);
                } else if (index == 11) {
                    this.h = obtainStyledAttributes.getColor(index, -11539796);
                    this.i = false;
                } else if (index == 13) {
                    this.c = obtainStyledAttributes.getInt(index, 270);
                } else if (index == 15) {
                    this.d = obtainStyledAttributes.getInt(index, 360);
                } else if (index == 8) {
                    this.q = obtainStyledAttributes.getInt(index, 100);
                } else if (index == 10) {
                    this.r = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 3) {
                    this.s = obtainStyledAttributes.getInt(index, 500);
                } else if (index == 12) {
                    this.u = obtainStyledAttributes.getBoolean(index, this.u);
                } else if (index == 2) {
                    this.m = obtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 10.0f, displayMetrics));
                } else if (index == 16) {
                    this.n = obtainStyledAttributes.getInt(index, this.n);
                } else if (index == 0) {
                    this.o = obtainStyledAttributes.getFloat(index, this.o);
                } else if (index == 17) {
                    this.v = obtainStyledAttributes.getBoolean(index, this.v);
                } else if (index == 1) {
                    this.w = obtainStyledAttributes.getBoolean(index, this.w);
                }
            }
            obtainStyledAttributes.recycle();
            this.t = (int) ((this.r * 100.0f) / this.q);
            this.a = new Paint();
            this.p = (int) ((this.d * 1.0f) / (this.n + this.o));
        }
    }

    private void a(Canvas canvas) {
        Shader shader;
        Shader shader2;
        Shader shader3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, canvas) == null) {
            this.a.reset();
            this.a.setAntiAlias(true);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(this.b);
            if (this.u) {
                float f = this.l;
                float f2 = f * 2.0f;
                float f3 = this.e - f;
                float f4 = this.f - f;
                RectF rectF = new RectF(f3, f4, f3 + f2, f2 + f4);
                int i = (int) ((this.t / 100.0f) * this.p);
                int i2 = 0;
                if (this.v) {
                    while (i2 < this.p) {
                        this.a.setShader(null);
                        this.a.setColor(this.g);
                        float f5 = this.o;
                        canvas.drawArc(rectF, (i2 * (this.n + f5)) + this.c, f5, false, this.a);
                        i2++;
                    }
                    for (int i3 = i; i3 < i + i; i3++) {
                        if (this.i && (shader3 = this.j) != null) {
                            this.a.setShader(shader3);
                        } else {
                            this.a.setColor(this.h);
                        }
                        float f6 = this.o;
                        canvas.drawArc(rectF, (i3 * (this.n + f6)) + this.c, f6, false, this.a);
                    }
                } else {
                    while (i2 < this.p) {
                        if (i2 < i) {
                            if (this.i && (shader2 = this.j) != null) {
                                this.a.setShader(shader2);
                            } else {
                                this.a.setColor(this.h);
                            }
                            float f7 = this.o;
                            canvas.drawArc(rectF, (i2 * (this.n + f7)) + this.c, f7, false, this.a);
                        } else if (this.g != 0) {
                            this.a.setShader(null);
                            this.a.setColor(this.g);
                            float f8 = this.o;
                            canvas.drawArc(rectF, (i2 * (this.n + f8)) + this.c, f8, false, this.a);
                        }
                        i2++;
                    }
                }
            }
            this.a.setShader(null);
            if (this.w) {
                this.a.setStrokeCap(Paint.Cap.ROUND);
            }
            float f9 = (this.l - this.m) - this.b;
            float f10 = 2.0f * f9;
            float f11 = this.e - f9;
            float f12 = this.f - f9;
            RectF rectF2 = new RectF(f11, f12, f11 + f10, f10 + f12);
            int i4 = this.g;
            if (i4 != 0) {
                this.a.setColor(i4);
                canvas.drawArc(rectF2, this.c, this.d, false, this.a);
            }
            if (this.i && (shader = this.j) != null) {
                this.a.setShader(shader);
            } else {
                this.a.setColor(this.h);
            }
            if (this.v) {
                canvas.drawArc(rectF2, this.c + (this.d * getRatio()), this.d * getRatio(), false, this.a);
            } else {
                canvas.drawArc(rectF2, this.c, this.d * getRatio(), false, this.a);
            }
        }
    }

    private int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, this, i, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == 1073741824) {
                return size;
            }
            if (mode == Integer.MIN_VALUE) {
                return Math.min(i2, size);
            }
            return i2;
        }
        return invokeII.intValue;
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            a(0, i, i2);
        }
    }

    private DisplayMetrics getDisplayMetrics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return getResources().getDisplayMetrics();
        }
        return (DisplayMetrics) invokeV.objValue;
    }

    private float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return (this.r * 1.0f) / this.q;
        }
        return invokeV.floatValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200L);
            startAnimation(alphaAnimation);
        }
    }

    public float getCircleCenterX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return invokeV.floatValue;
    }

    public float getCircleCenterY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.floatValue;
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public int getProgressPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public float getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return invokeV.floatValue;
    }

    public int getStartAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int getSweepAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            a(i, this.s);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            a(this.r, i, this.s);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, canvas) == null) {
            super.onDraw(canvas);
            a(canvas);
        }
    }

    public void setCapRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.w = z;
            invalidate();
        }
    }

    public void setIsShader(Shader shader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, shader) == null) {
            this.i = true;
            this.j = shader;
            invalidate();
        }
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.q = i;
            invalidate();
        }
    }

    public void setNormalColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.g = i;
            invalidate();
        }
    }

    public void setOnChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            this.x = bVar;
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.r = i;
            this.t = (int) ((i * 100.0f) / this.q);
            invalidate();
            b bVar = this.x;
            if (bVar != null) {
                bVar.a(this.r, this.q);
            }
        }
    }

    public void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.i = false;
            this.h = i;
            invalidate();
        }
    }

    public void setProgressColorResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            setProgressColor(getResources().getColor(i));
        }
    }

    public void setShowTick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.u = z;
            invalidate();
        }
    }

    public void setTurn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.v = z;
            invalidate();
        }
    }

    public void a(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            a(i, i2, i3, null);
        }
    }

    public void a(int i, int i2, int i3, Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), animatorListener}) == null) {
            this.s = i3;
            this.r = i;
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.setDuration(i3);
            ofInt.addUpdateListener(new a(this));
            if (animatorListener != null) {
                ofInt.removeAllUpdateListeners();
                ofInt.addListener(animatorListener);
            }
            ofInt.start();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int applyDimension = (int) TypedValue.applyDimension(1, 200.0f, getDisplayMetrics());
            int b2 = b(i, applyDimension);
            int b3 = b(i2, applyDimension);
            this.e = ((getPaddingLeft() + b2) - getPaddingRight()) / 2.0f;
            this.f = ((getPaddingTop() + b3) - getPaddingBottom()) / 2.0f;
            this.l = (((b2 - Math.max(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom())) - this.b) / 2.0f) - this.m;
            float f = this.e;
            this.j = new SweepGradient(f, f, this.k, (float[]) null);
            setMeasuredDimension(b2, b3);
        }
    }

    public void setProgressColor(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iArr) == null) {
            float f = this.e;
            setIsShader(new SweepGradient(f, f, iArr, (float[]) null));
        }
    }
}
