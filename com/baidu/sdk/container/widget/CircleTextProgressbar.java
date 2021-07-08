package com.baidu.sdk.container.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.widget.AbsCountDownView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.h0.a.k.h;
/* loaded from: classes2.dex */
public class CircleTextProgressbar extends AbsCountDownView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f10178h;

    /* renamed from: i  reason: collision with root package name */
    public int f10179i;
    public ColorStateList j;
    public int k;
    public int l;
    public int m;
    public Paint n;
    public RectF o;
    public int p;
    public int q;
    public ProgressType r;
    public long s;
    public final Rect t;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ProgressType {
        public static final /* synthetic */ ProgressType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ProgressType COUNT;
        public static final ProgressType COUNT_BACK;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-823053153, "Lcom/baidu/sdk/container/widget/CircleTextProgressbar$ProgressType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-823053153, "Lcom/baidu/sdk/container/widget/CircleTextProgressbar$ProgressType;");
                    return;
                }
            }
            COUNT = new ProgressType("COUNT", 0);
            ProgressType progressType = new ProgressType("COUNT_BACK", 1);
            COUNT_BACK = progressType;
            $VALUES = new ProgressType[]{COUNT, progressType};
        }

        public ProgressType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ProgressType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ProgressType) Enum.valueOf(ProgressType.class, str) : (ProgressType) invokeL.objValue;
        }

        public static ProgressType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ProgressType[]) $VALUES.clone() : (ProgressType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10180a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1665073617, "Lcom/baidu/sdk/container/widget/CircleTextProgressbar$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1665073617, "Lcom/baidu/sdk/container/widget/CircleTextProgressbar$a;");
                    return;
                }
            }
            int[] iArr = new int[ProgressType.values().length];
            f10180a = iArr;
            try {
                iArr[ProgressType.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10180a[ProgressType.COUNT_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleTextProgressbar(Context context) {
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

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setTaskPeriod(this.s / this.p);
            super.b();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = a.f10180a[this.r.ordinal()];
            if (i2 == 1) {
                this.q++;
            } else if (i2 == 2) {
                this.q--;
            }
            int i3 = this.q;
            if (i3 >= 0 && i3 <= this.p) {
                AbsCountDownView.b bVar = this.f10161f;
                if (bVar != null) {
                    bVar.onProgress(i3);
                }
                postInvalidate();
                return;
            }
            this.q = i(this.q);
            AbsCountDownView.b bVar2 = this.f10161f;
            if (bVar2 != null) {
                bVar2.onEnd();
            }
            c();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.drawableStateChanged();
            h();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.q = (this.p * i3) / i2;
            invalidate();
        }
    }

    public void f(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, attributeSet) == null) {
            this.n.setAntiAlias(true);
            ColorStateList valueOf = ColorStateList.valueOf(0);
            this.j = valueOf;
            this.k = valueOf.getColorForState(getDrawableState(), 0);
            setWidth(h.a(context, 40.0f));
            setHeight(h.a(context, 40.0f));
            setOutLineColor(-7697782);
            setProgressColor(-12956454);
            setProgressLineWidth(h.a(context, 2.0f));
            setTextSize(1, 10.0f);
            setTextColor(-1);
            setText("跳过");
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = a.f10180a[this.r.ordinal()];
            if (i2 == 1) {
                this.q = 0;
            } else if (i2 != 2) {
                this.q = 0;
            } else {
                this.q = this.p;
            }
        }
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q : invokeV.intValue;
    }

    public ProgressType getProgressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.r : (ProgressType) invokeV.objValue;
    }

    public long getTimeMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.s : invokeV.longValue;
    }

    public final void h() {
        int colorForState;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.k == (colorForState = this.j.getColorForState(getDrawableState(), 0))) {
            return;
        }
        this.k = colorForState;
        invalidate();
    }

    public final int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            int i3 = this.p;
            if (i2 > i3) {
                return i3;
            }
            if (i2 < 0) {
                return 0;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, canvas) == null) {
            getDrawingRect(this.t);
            float width = (this.t.height() > this.t.width() ? this.t.width() : this.t.height()) / 2;
            this.n.setStyle(Paint.Style.FILL);
            this.n.setColor(this.f10178h);
            this.n.setAlpha(127);
            canvas.drawCircle(this.t.centerX(), this.t.centerY(), width - this.f10179i, this.n);
            this.n.setStyle(Paint.Style.STROKE);
            this.n.setColor(this.f10178h);
            this.n.setStrokeWidth(this.m);
            this.n.setStrokeCap(Paint.Cap.ROUND);
            this.n.setAlpha(204);
            canvas.drawCircle(this.t.centerX(), this.t.centerY(), width - (this.m / 2), this.n);
            TextPaint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(getText().toString(), this.t.centerX(), this.t.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
            this.n.setColor(this.l);
            this.n.setStyle(Paint.Style.STROKE);
            this.n.setStrokeWidth(this.m);
            this.n.setStrokeCap(Paint.Cap.ROUND);
            this.n.setAlpha(204);
            RectF rectF = this.o;
            int i2 = this.t.left;
            int i3 = this.m;
            rectF.set(i2 + (i3 / 2), rect.top + (i3 / 2), rect.right - (i3 / 2), rect.bottom - (i3 / 2));
            canvas.drawArc(this.o, 270.0f, (this.q * 360) / this.p, false, this.n);
        }
    }

    public void setInCircleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.j = ColorStateList.valueOf(i2);
            invalidate();
        }
    }

    public void setOutLineColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f10178h = i2;
            invalidate();
        }
    }

    public void setOutLineWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f10179i = i2;
            invalidate();
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.q = i(i2);
            invalidate();
        }
    }

    public void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.l = i2;
            invalidate();
        }
    }

    public void setProgressLineWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.m = i2;
            invalidate();
        }
    }

    public void setProgressTotalPart(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.p = i2;
            g();
        }
    }

    public void setProgressType(ProgressType progressType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, progressType) == null) {
            this.r = progressType;
            g();
            invalidate();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void setTimeMillis(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.s = j;
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleTextProgressbar(Context context, AttributeSet attributeSet) {
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
    public CircleTextProgressbar(Context context, AttributeSet attributeSet, int i2) {
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
        this.f10178h = -16777216;
        this.f10179i = 2;
        this.j = ColorStateList.valueOf(0);
        this.l = -16776961;
        this.m = 8;
        this.n = new Paint();
        this.o = new RectF();
        this.p = 100;
        this.q = 100;
        this.r = ProgressType.COUNT_BACK;
        this.s = 3000L;
        this.t = new Rect();
        f(context, attributeSet);
    }
}
