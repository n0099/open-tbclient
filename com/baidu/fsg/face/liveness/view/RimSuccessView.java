package com.baidu.fsg.face.liveness.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RimSuccessView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40505a;

    /* renamed from: b  reason: collision with root package name */
    public float f40506b;

    /* renamed from: c  reason: collision with root package name */
    public float f40507c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f40508d;

    /* renamed from: e  reason: collision with root package name */
    public PathMeasure f40509e;

    /* renamed from: f  reason: collision with root package name */
    public Path f40510f;

    /* renamed from: g  reason: collision with root package name */
    public Path f40511g;

    /* renamed from: h  reason: collision with root package name */
    public Path f40512h;

    /* renamed from: i  reason: collision with root package name */
    public Path f40513i;

    /* renamed from: j  reason: collision with root package name */
    public Path f40514j;
    public ValueAnimator k;
    public float l;
    public float m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RimSuccessView(Context context) {
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

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.m = 0.0f;
            this.l = 0.0f;
            this.f40510f.reset();
            this.f40511g.reset();
            this.f40513i.reset();
            this.f40514j.reset();
            this.f40512h.reset();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.k = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.baidu.fsg.face.liveness.view.RimSuccessView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RimSuccessView f40515a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f40515a = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.f40515a.l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.f40515a.invalidate();
                    }
                }
            });
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.baidu.fsg.face.liveness.view.RimSuccessView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RimSuccessView f40516a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f40516a = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.f40516a.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.f40516a.invalidate();
                    }
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(this.k).after(ofFloat2);
            animatorSet.setDuration(500L);
            animatorSet.start();
        }
    }

    public void loadSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            e();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.translate(getPaddingLeft(), getPaddingTop());
            this.f40508d.setColor(this.f40505a);
            RectF rectF = new RectF();
            rectF.left = (getWidth() / 2) - this.f40507c;
            rectF.top = (getWidth() / 2) - this.f40507c;
            rectF.right = (getWidth() / 2) + this.f40507c;
            float f2 = this.f40507c;
            rectF.bottom = (getWidth() / 2) + f2;
            float f3 = (f2 * 2.0f) / 76.0f;
            this.f40512h.moveTo(rectF.left + (23.0f * f3), rectF.top + (30.0f * f3));
            this.f40512h.lineTo(rectF.left + (38.0f * f3), rectF.top + (45.0f * f3));
            this.f40512h.lineTo(rectF.left + (68.0f * f3), rectF.top + (f3 * 17.0f));
            this.f40509e.setPath(this.f40512h, false);
            PathMeasure pathMeasure = this.f40509e;
            pathMeasure.getSegment(0.0f, this.m * pathMeasure.getLength(), this.f40511g, true);
            canvas.drawPath(this.f40511g, this.f40508d);
            if (this.m == 1.0f) {
                this.f40510f.rLineTo(0.0f, 0.0f);
                this.f40510f.addArc(rectF, -36.0f, -320.0f);
                this.f40509e.setPath(this.f40510f, false);
                PathMeasure pathMeasure2 = this.f40509e;
                pathMeasure2.getSegment(0.0f, this.l * pathMeasure2.getLength(), this.f40511g, true);
                canvas.drawPath(this.f40511g, this.f40508d);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                size = (int) ((this.f40507c * 2.0f) + this.f40506b + getPaddingLeft() + getPaddingRight());
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode2 != 1073741824) {
                size2 = (int) ((this.f40507c * 2.0f) + this.f40506b + getPaddingTop() + getPaddingBottom());
            }
            setMeasuredDimension(size, size2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RimSuccessView(Context context, AttributeSet attributeSet) {
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

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            Paint paint = new Paint();
            this.f40508d = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f40508d.setDither(true);
            this.f40508d.setAntiAlias(true);
            this.f40508d.setStrokeWidth(this.f40506b);
            this.f40508d.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f40510f = new Path();
            this.f40509e = new PathMeasure();
            this.f40511g = new Path();
            this.f40512h = new Path();
            this.f40513i = new Path();
            this.f40514j = new Path();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RimSuccessView(Context context, AttributeSet attributeSet, int i2) {
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
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.RimSuccessView, i2, 0);
        this.f40505a = obtainStyledAttributes.getColor(R.styleable.RimSuccessView_rim_progress_color, ContextCompat.getColor(context, R.color.rim_base_white));
        this.f40506b = obtainStyledAttributes.getDimension(R.styleable.RimSuccessView_rim_progress_width, 2.0f);
        this.f40507c = obtainStyledAttributes.getDimension(R.styleable.RimSuccessView_rim_progress_radius, 35.0f);
        obtainStyledAttributes.recycle();
        a();
        b();
        c();
    }
}
