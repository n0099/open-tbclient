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
import com.repackage.q01;
/* loaded from: classes2.dex */
public class CircleTextProgressbar extends AbsCountDownView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int d;
    public int e;
    public ColorStateList f;
    public int g;
    public int h;
    public int i;
    public Paint j;
    public RectF k;
    public int l;
    public int m;
    public ProgressType n;
    public long o;
    public final Rect p;

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

        public ProgressType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public static final /* synthetic */ int[] a;
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
            a = iArr;
            try {
                iArr[ProgressType.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ProgressType.COUNT_BACK.ordinal()] = 2;
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

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setTaskPeriod(this.o / this.l);
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
            int i = a.a[this.n.ordinal()];
            if (i == 1) {
                this.m++;
            } else if (i == 2) {
                this.m--;
            }
            int i2 = this.m;
            if (i2 >= 0 && i2 <= this.l) {
                AbsCountDownView.b bVar = this.b;
                if (bVar != null) {
                    bVar.onProgress(i2);
                }
                postInvalidate();
                return;
            }
            this.m = h(this.m);
            AbsCountDownView.b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.a();
            }
            c();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.drawableStateChanged();
            g();
        }
    }

    public void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, attributeSet) == null) {
            this.j.setAntiAlias(true);
            ColorStateList valueOf = ColorStateList.valueOf(0);
            this.f = valueOf;
            this.g = valueOf.getColorForState(getDrawableState(), 0);
            setWidth(q01.c.a(context, 40.0f));
            setHeight(q01.c.a(context, 40.0f));
            setOutLineColor(-7697782);
            setProgressColor(-12956454);
            setProgressLineWidth(q01.c.a(context, 2.0f));
            setTextSize(1, 10.0f);
            setTextColor(-1);
            setText("跳过");
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i = a.a[this.n.ordinal()];
            if (i == 1) {
                this.m = 0;
            } else if (i != 2) {
                this.m = 0;
            } else {
                this.m = this.l;
            }
        }
    }

    public final void g() {
        int colorForState;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.g == (colorForState = this.f.getColorForState(getDrawableState(), 0))) {
            return;
        }
        this.g = colorForState;
        invalidate();
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : invokeV.intValue;
    }

    public ProgressType getProgressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (ProgressType) invokeV.objValue;
    }

    public long getTimeMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o : invokeV.longValue;
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            int i2 = this.l;
            if (i > i2) {
                return i2;
            }
            if (i < 0) {
                return 0;
            }
            return i;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            getDrawingRect(this.p);
            float width = (this.p.height() > this.p.width() ? this.p.width() : this.p.height()) / 2;
            this.j.setStyle(Paint.Style.FILL);
            this.j.setColor(this.d);
            this.j.setAlpha(127);
            canvas.drawCircle(this.p.centerX(), this.p.centerY(), width - this.e, this.j);
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setColor(this.d);
            this.j.setStrokeWidth(this.i);
            this.j.setStrokeCap(Paint.Cap.ROUND);
            this.j.setAlpha(204);
            canvas.drawCircle(this.p.centerX(), this.p.centerY(), width - (this.i / 2), this.j);
            TextPaint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(getText().toString(), this.p.centerX(), this.p.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
            this.j.setColor(this.h);
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setStrokeWidth(this.i);
            this.j.setStrokeCap(Paint.Cap.ROUND);
            this.j.setAlpha(204);
            RectF rectF = this.k;
            int i = this.p.left;
            int i2 = this.i;
            rectF.set(i + (i2 / 2), rect.top + (i2 / 2), rect.right - (i2 / 2), rect.bottom - (i2 / 2));
            canvas.drawArc(this.k, 270.0f, (this.m * 360) / this.l, false, this.j);
        }
    }

    public void setInCircleColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f = ColorStateList.valueOf(i);
            invalidate();
        }
    }

    public void setOutLineColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.d = i;
            invalidate();
        }
    }

    public void setOutLineWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.e = i;
            invalidate();
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.m = h(i);
            invalidate();
        }
    }

    public void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.h = i;
            invalidate();
        }
    }

    public void setProgressLineWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.i = i;
            invalidate();
        }
    }

    public void setProgressTotalPart(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.l = i;
            f();
        }
    }

    public void setProgressType(ProgressType progressType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, progressType) == null) {
            this.n = progressType;
            f();
            invalidate();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void setTimeMillis(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.o = j;
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
    public CircleTextProgressbar(Context context, AttributeSet attributeSet, int i) {
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
        this.d = -16777216;
        this.e = 2;
        this.f = ColorStateList.valueOf(0);
        this.h = -16776961;
        this.i = 8;
        this.j = new Paint();
        this.k = new RectF();
        this.l = 100;
        this.m = 100;
        this.n = ProgressType.COUNT_BACK;
        this.o = 3000L;
        this.p = new Rect();
        e(context, attributeSet);
    }
}
