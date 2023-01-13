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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n71;
import com.baidu.tieba.r31;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ExpandIconView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    @FloatRange(from = 0.0d, to = 1.0d)
    public float c;
    public float d;
    public final int e;
    public final int f;
    @NonNull
    public final Paint g;
    public final Point h;
    public final Point i;
    public final Point j;
    public final Point k;
    public final Point l;
    public final Path m;
    @Nullable
    public ValueAnimator n;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandIconView a;

        public a(ExpandIconView expandIconView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandIconView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = expandIconView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.k();
                this.a.h();
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

    public final void d(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            g();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.a, f);
            ofFloat.addUpdateListener(new a(this));
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(e(f));
            ofFloat.start();
            this.n = ofFloat;
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

    public final void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.g.setStrokeWidth(this.f);
            this.j.set(i / 2, i2 / 2);
            double sqrt = Math.sqrt(Math.pow(this.e / 2.0d, 2.0d) - Math.pow(this.j.y, 2.0d));
            Point point = this.h;
            Point point2 = this.j;
            int i3 = (int) sqrt;
            point.set(point2.x - i3, point2.y);
            Point point3 = this.i;
            Point point4 = this.j;
            point3.set(point4.x + i3, point4.y);
        }
    }

    /* JADX DEBUG: Incorrect finally slice size: {[INVOKE, CONSTRUCTOR] complete}, expected: {[INVOKE] complete} */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Finally extract failed */
    public ExpandIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = -45.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.h = new Point();
        this.i = new Point();
        this.j = new Point();
        this.k = new Point();
        this.l = new Point();
        this.m = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n71.ExpandIconView, 0, 0);
        try {
            this.e = obtainStyledAttributes.getDimensionPixelSize(2, r31.c.a(getContext(), 40.0f));
            this.f = obtainStyledAttributes.getDimensionPixelSize(3, r31.c.a(getContext(), 2.0f));
            int color = obtainStyledAttributes.getColor(1, -16777216);
            long integer = obtainStyledAttributes.getInteger(0, 150);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint(1);
            this.g = paint;
            paint.setDither(true);
            this.g.setColor(color);
            this.g.setStyle(Paint.Style.STROKE);
            this.g.setStrokeJoin(Paint.Join.ROUND);
            this.g.setPathEffect(new CornerPathEffect(10.0f));
            this.g.setStrokeCap(Paint.Cap.ROUND);
            this.d = 45.0f / ((float) integer);
            setState(1, true);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final long e(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            return Math.abs(f - this.a) / this.d;
        }
        return invokeF.longValue;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            float f = this.c * 45.0f;
            if (z) {
                d(f);
                return;
            }
            g();
            this.a = f;
            k();
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.translate(0.0f, this.b);
            canvas.drawPath(this.m, this.g);
        }
    }

    private int getFinalStateByFraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.c < 0.0f) {
                return 0;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public final void g() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (valueAnimator = this.n) != null && valueAnimator.isRunning()) {
            this.n.cancel();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            postInvalidateOnAnimation();
        }
    }

    public final void i(@NonNull Point point, double d, @NonNull Point point2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{point, Double.valueOf(d), point2}) == null) {
            double radians = Math.toRadians(d);
            int i = this.j.x;
            int cos = (int) ((i + ((point.x - i) * Math.cos(radians))) - ((point.y - this.j.y) * Math.sin(radians)));
            Point point3 = this.j;
            point2.set(cos, (int) (point3.y + ((point.x - point3.x) * Math.sin(radians)) + ((point.y - this.j.y) * Math.cos(radians))));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.m.reset();
            Point point = this.h;
            if (point != null && this.i != null) {
                i(point, -this.a, this.k);
                i(this.i, this.a, this.l);
                int i = this.j.y;
                Point point2 = this.k;
                int i2 = point2.y;
                this.b = (int) ((i - i2) / 2.0d);
                this.m.moveTo(point2.x, i2);
                Path path = this.m;
                Point point3 = this.j;
                path.lineTo(point3.x, point3.y);
                Path path2 = this.m;
                Point point4 = this.l;
                path2.lineTo(point4.x, point4.y);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            f(i, i2);
            k();
        }
    }

    public void setFraction(@FloatRange(from = -1.0d, to = 1.0d) float f, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Boolean.valueOf(z)}) != null) || f < -1.0f || f > 1.0f || this.c == f) {
            return;
        }
        this.c = f;
        if (f != -1.0f) {
            int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        }
        j(z);
    }

    public void setState(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        this.c = 0.0f;
                    }
                } else {
                    this.c = 1.0f;
                }
            } else {
                this.c = -1.0f;
            }
            j(z);
        }
    }
}
