package com.baidu.pass.biometrics.face.liveness.view.face;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
/* loaded from: classes10.dex */
public class CircleProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public float f38906b;

    /* renamed from: c  reason: collision with root package name */
    public int f38907c;

    /* renamed from: d  reason: collision with root package name */
    public int f38908d;

    /* renamed from: e  reason: collision with root package name */
    public float f38909e;

    /* renamed from: f  reason: collision with root package name */
    public float f38910f;

    /* renamed from: g  reason: collision with root package name */
    public int f38911g;

    /* renamed from: h  reason: collision with root package name */
    public int f38912h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f38913i;

    /* renamed from: j  reason: collision with root package name */
    public Shader f38914j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f38915k;
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

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes10.dex */
    public interface b {
        void a(float f2, float f3);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pass_liveness_CircleProgressView);
            DisplayMetrics displayMetrics = getDisplayMetrics();
            this.f38906b = TypedValue.applyDimension(1, 6.0f, displayMetrics);
            this.m = TypedValue.applyDimension(1, 5.0f, displayMetrics);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvStrokeWidth) {
                    this.f38906b = obtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 12.0f, displayMetrics));
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvNormalColor) {
                    this.f38911g = obtainStyledAttributes.getColor(index, -3618616);
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvProgressColor) {
                    this.f38912h = obtainStyledAttributes.getColor(index, -11539796);
                    this.f38913i = false;
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvStartAngle) {
                    this.f38907c = obtainStyledAttributes.getInt(index, 270);
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvSweepAngle) {
                    this.f38908d = obtainStyledAttributes.getInt(index, 360);
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvMax) {
                    this.q = obtainStyledAttributes.getInt(index, 100);
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvProgress) {
                    this.r = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvDuration) {
                    this.s = obtainStyledAttributes.getInt(index, 500);
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvShowTick) {
                    this.u = obtainStyledAttributes.getBoolean(index, this.u);
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvCirclePadding) {
                    this.m = obtainStyledAttributes.getDimension(index, TypedValue.applyDimension(1, 10.0f, displayMetrics));
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvTickSplitAngle) {
                    this.n = obtainStyledAttributes.getInt(index, this.n);
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvBlockAngle) {
                    this.o = obtainStyledAttributes.getFloat(index, this.o);
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvTurn) {
                    this.v = obtainStyledAttributes.getBoolean(index, this.v);
                } else if (index == R.styleable.pass_liveness_CircleProgressView_pass_liveness_cpvCapRound) {
                    this.w = obtainStyledAttributes.getBoolean(index, this.w);
                }
            }
            obtainStyledAttributes.recycle();
            this.t = (int) ((this.r * 100.0f) / this.q);
            this.a = new Paint();
            this.p = (int) ((this.f38908d * 1.0f) / (this.n + this.o));
        }
    }

    private int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i3, size) : i3;
        }
        return invokeII.intValue;
    }

    private DisplayMetrics getDisplayMetrics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? getResources().getDisplayMetrics() : (DisplayMetrics) invokeV.objValue;
    }

    private float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (this.r * 1.0f) / this.q : invokeV.floatValue;
    }

    public float getCircleCenterX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38909e : invokeV.floatValue;
    }

    public float getCircleCenterY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38910f : invokeV.floatValue;
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : invokeV.intValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.intValue;
    }

    public int getProgressPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.t : invokeV.intValue;
    }

    public float getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.floatValue;
    }

    public int getStartAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f38907c : invokeV.intValue;
    }

    public int getSweepAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f38908d : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, canvas) == null) {
            super.onDraw(canvas);
            a(canvas);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int applyDimension = (int) TypedValue.applyDimension(1, 200.0f, getDisplayMetrics());
            int b2 = b(i2, applyDimension);
            int b3 = b(i3, applyDimension);
            this.f38909e = ((getPaddingLeft() + b2) - getPaddingRight()) / 2.0f;
            this.f38910f = ((getPaddingTop() + b3) - getPaddingBottom()) / 2.0f;
            this.l = (((b2 - Math.max(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom())) - this.f38906b) / 2.0f) - this.m;
            float f2 = this.f38909e;
            this.f38914j = new SweepGradient(f2, f2, this.f38915k, (float[]) null);
            setMeasuredDimension(b2, b3);
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
            this.f38913i = true;
            this.f38914j = shader;
            invalidate();
        }
    }

    public void setMax(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.q = i2;
            invalidate();
        }
    }

    public void setNormalColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f38911g = i2;
            invalidate();
        }
    }

    public void setOnChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            this.x = bVar;
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.r = i2;
            this.t = (int) ((i2 * 100.0f) / this.q);
            invalidate();
            b bVar = this.x;
            if (bVar != null) {
                bVar.a(this.r, this.q);
            }
        }
    }

    public void setProgressColor(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iArr) == null) {
            float f2 = this.f38909e;
            setIsShader(new SweepGradient(f2, f2, iArr, (float[]) null));
        }
    }

    public void setProgressColorResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            setProgressColor(getResources().getColor(i2));
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f38907c = 270;
        this.f38908d = 360;
        this.f38911g = BdThumbSeekBarView.BUFFERING_PAINT_COLOR;
        this.f38912h = -11637006;
        this.f38913i = true;
        this.f38915k = new int[]{-6311429, -8941322, -8941322, -11637006, -3615745, -6311429};
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

    public void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f38913i = false;
            this.f38912h = i2;
            invalidate();
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            a(this.r, i2, this.s);
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
            this.a.setStrokeWidth(this.f38906b);
            if (this.u) {
                float f2 = this.l;
                float f3 = f2 * 2.0f;
                float f4 = this.f38909e - f2;
                float f5 = this.f38910f - f2;
                RectF rectF = new RectF(f4, f5, f4 + f3, f3 + f5);
                int i2 = (int) ((this.t / 100.0f) * this.p);
                int i3 = 0;
                if (this.v) {
                    while (i3 < this.p) {
                        this.a.setShader(null);
                        this.a.setColor(this.f38911g);
                        float f6 = this.o;
                        canvas.drawArc(rectF, (i3 * (this.n + f6)) + this.f38907c, f6, false, this.a);
                        i3++;
                    }
                    for (int i4 = i2; i4 < i2 + i2; i4++) {
                        if (this.f38913i && (shader3 = this.f38914j) != null) {
                            this.a.setShader(shader3);
                        } else {
                            this.a.setColor(this.f38912h);
                        }
                        float f7 = this.o;
                        canvas.drawArc(rectF, (i4 * (this.n + f7)) + this.f38907c, f7, false, this.a);
                    }
                } else {
                    while (i3 < this.p) {
                        if (i3 < i2) {
                            if (this.f38913i && (shader2 = this.f38914j) != null) {
                                this.a.setShader(shader2);
                            } else {
                                this.a.setColor(this.f38912h);
                            }
                            float f8 = this.o;
                            canvas.drawArc(rectF, (i3 * (this.n + f8)) + this.f38907c, f8, false, this.a);
                        } else if (this.f38911g != 0) {
                            this.a.setShader(null);
                            this.a.setColor(this.f38911g);
                            float f9 = this.o;
                            canvas.drawArc(rectF, (i3 * (this.n + f9)) + this.f38907c, f9, false, this.a);
                        }
                        i3++;
                    }
                }
            }
            this.a.setShader(null);
            if (this.w) {
                this.a.setStrokeCap(Paint.Cap.ROUND);
            }
            float f10 = (this.l - this.m) - this.f38906b;
            float f11 = 2.0f * f10;
            float f12 = this.f38909e - f10;
            float f13 = this.f38910f - f10;
            RectF rectF2 = new RectF(f12, f13, f12 + f11, f11 + f13);
            int i5 = this.f38911g;
            if (i5 != 0) {
                this.a.setColor(i5);
                canvas.drawArc(rectF2, this.f38907c, this.f38908d, false, this.a);
            }
            if (this.f38913i && (shader = this.f38914j) != null) {
                this.a.setShader(shader);
            } else {
                this.a.setColor(this.f38912h);
            }
            if (this.v) {
                canvas.drawArc(rectF2, this.f38907c + (this.f38908d * getRatio()), this.f38908d * getRatio(), false, this.a);
            } else {
                canvas.drawArc(rectF2, this.f38907c, this.f38908d * getRatio(), false, this.a);
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            a(i2, this.s);
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            a(0, i2, i3);
        }
    }

    public void a(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i2, i3, i4) == null) {
            a(i2, i3, i4, null);
        }
    }

    public void a(int i2, int i3, int i4, Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), animatorListener}) == null) {
            this.s = i4;
            this.r = i2;
            ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
            ofInt.setDuration(i4);
            ofInt.addUpdateListener(new a(this));
            if (animatorListener != null) {
                ofInt.removeAllUpdateListeners();
                ofInt.addListener(animatorListener);
            }
            ofInt.start();
        }
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
}
