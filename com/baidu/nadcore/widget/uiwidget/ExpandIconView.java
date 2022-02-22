package com.baidu.nadcore.widget.uiwidget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.h0.f;
import c.a.d0.l0.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ExpandIconView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LESS = 1;
    public static final int MORE = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f37646e;

    /* renamed from: f  reason: collision with root package name */
    public float f37647f;

    /* renamed from: g  reason: collision with root package name */
    public float f37648g;
    @FloatRange(from = 0.0d, to = 1.0d)

    /* renamed from: h  reason: collision with root package name */
    public float f37649h;

    /* renamed from: i  reason: collision with root package name */
    public float f37650i;

    /* renamed from: j  reason: collision with root package name */
    public final int f37651j;
    public final int k;
    @NonNull
    public final Paint l;
    public final Point m;
    public final Point n;
    public final Point o;
    public final Point p;
    public final Point q;
    public final Path r;
    @Nullable
    public ValueAnimator s;

    /* loaded from: classes11.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExpandIconView f37652e;

        public a(ExpandIconView expandIconView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandIconView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37652e = expandIconView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f37652e.f37647f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f37652e.k();
                this.f37652e.h();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandIconView(@NonNull Context context) {
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

    private int getFinalStateByFraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.f37649h < 0.0f ? 0 : 1 : invokeV.intValue;
    }

    public final void d(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            g();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f37647f, f2);
            ofFloat.addUpdateListener(new a(this));
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(e(f2));
            ofFloat.start();
            this.s = ofFloat;
        }
    }

    public final long e(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) ? Math.abs(f2 - this.f37647f) / this.f37650i : invokeF.longValue;
    }

    public final void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.l.setStrokeWidth(this.k);
            this.o.set(i2 / 2, i3 / 2);
            double sqrt = Math.sqrt(Math.pow(this.f37651j / 2.0d, 2.0d) - Math.pow(this.o.y, 2.0d));
            Point point = this.m;
            Point point2 = this.o;
            int i4 = (int) sqrt;
            point.set(point2.x - i4, point2.y);
            Point point3 = this.n;
            Point point4 = this.o;
            point3.set(point4.x + i4, point4.y);
        }
    }

    public final void g() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (valueAnimator = this.s) != null && valueAnimator.isRunning()) {
            this.s.cancel();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            postInvalidateOnAnimation();
        }
    }

    public final void i(@NonNull Point point, double d2, @NonNull Point point2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{point, Double.valueOf(d2), point2}) == null) {
            double radians = Math.toRadians(d2);
            int i2 = this.o.x;
            int cos = (int) ((i2 + ((point.x - i2) * Math.cos(radians))) - ((point.y - this.o.y) * Math.sin(radians)));
            Point point3 = this.o;
            point2.set(cos, (int) (point3.y + ((point.x - point3.x) * Math.sin(radians)) + ((point.y - this.o.y) * Math.cos(radians))));
        }
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            float f2 = this.f37649h * 45.0f;
            if (z) {
                d(f2);
                return;
            }
            g();
            this.f37647f = f2;
            k();
            invalidate();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.r.reset();
            Point point = this.m;
            if (point == null || this.n == null) {
                return;
            }
            i(point, -this.f37647f, this.p);
            i(this.n, this.f37647f, this.q);
            int i2 = this.o.y;
            Point point2 = this.p;
            int i3 = point2.y;
            this.f37648g = (int) ((i2 - i3) / 2.0d);
            this.r.moveTo(point2.x, i3);
            Path path = this.r;
            Point point3 = this.o;
            path.lineTo(point3.x, point3.y);
            Path path2 = this.r;
            Point point4 = this.q;
            path2.lineTo(point4.x, point4.y);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.translate(0.0f, this.f37648g);
            canvas.drawPath(this.r, this.l);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            f(i2, i3);
            k();
        }
    }

    public void setFraction(@FloatRange(from = -1.0d, to = 1.0d) float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) || f2 < -1.0f || f2 > 1.0f || this.f37649h == f2) {
            return;
        }
        this.f37649h = f2;
        if (f2 == -1.0f) {
            this.f37646e = 0;
        } else if (f2 == 1.0f) {
            this.f37646e = 1;
        } else {
            this.f37646e = 2;
        }
        j(z);
    }

    public void setState(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f37646e = i2;
            if (i2 == 0) {
                this.f37649h = -1.0f;
            } else if (i2 == 1) {
                this.f37649h = 1.0f;
            } else if (i2 == 2) {
                this.f37649h = 0.0f;
            }
            j(z);
        }
    }

    public void switchState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            switchState(true);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    public void switchState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            int i2 = this.f37646e;
            int i3 = 0;
            if (i2 != 0) {
                if (i2 == 1) {
                    i3 = 1;
                } else if (i2 == 2) {
                    i3 = getFinalStateByFraction();
                }
            }
            setState(i3, z);
        }
    }

    /* JADX DEBUG: Incorrect finally slice size: {[INVOKE, CONST] complete}, expected: {[INVOKE] complete} */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Finally extract failed */
    public ExpandIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f37647f = -45.0f;
        this.f37648g = 0.0f;
        this.f37649h = 0.0f;
        this.m = new Point();
        this.n = new Point();
        this.o = new Point();
        this.p = new Point();
        this.q = new Point();
        this.r = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.ExpandIconView, 0, 0);
        try {
            this.f37651j = obtainStyledAttributes.getDimensionPixelSize(q.ExpandIconView_length, f.c.a(getContext(), 40.0f));
            this.k = obtainStyledAttributes.getDimensionPixelSize(q.ExpandIconView_thick, f.c.a(getContext(), 2.0f));
            int color = obtainStyledAttributes.getColor(q.ExpandIconView_color, -16777216);
            long integer = obtainStyledAttributes.getInteger(q.ExpandIconView_animationDuration, 150);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint(1);
            this.l = paint;
            paint.setDither(true);
            this.l.setColor(color);
            this.l.setStyle(Paint.Style.STROKE);
            this.l.setStrokeJoin(Paint.Join.ROUND);
            this.l.setPathEffect(new CornerPathEffect(10.0f));
            this.l.setStrokeCap(Paint.Cap.ROUND);
            this.f37650i = 45.0f / ((float) integer);
            setState(1, true);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
