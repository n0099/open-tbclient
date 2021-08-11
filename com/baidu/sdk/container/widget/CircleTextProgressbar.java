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
import c.a.h0.a.k.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.widget.AbsCountDownView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CircleTextProgressbar extends AbsCountDownView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f44876f;

    /* renamed from: g  reason: collision with root package name */
    public int f44877g;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f44878h;

    /* renamed from: i  reason: collision with root package name */
    public int f44879i;

    /* renamed from: j  reason: collision with root package name */
    public int f44880j;
    public int k;
    public Paint l;
    public RectF m;
    public int n;
    public int o;
    public ProgressType p;
    public long q;
    public final Rect r;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44881a;
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
            f44881a = iArr;
            try {
                iArr[ProgressType.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44881a[ProgressType.COUNT_BACK.ordinal()] = 2;
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = a.f44881a[this.p.ordinal()];
            if (i2 == 1) {
                this.o = 0;
            } else if (i2 != 2) {
                this.o = 0;
            } else {
                this.o = this.n;
            }
        }
    }

    public final void c() {
        int colorForState;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f44879i == (colorForState = this.f44878h.getColorForState(getDrawableState(), 0))) {
            return;
        }
        this.f44879i = colorForState;
        invalidate();
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int i3 = this.n;
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
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.drawableStateChanged();
            c();
        }
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : invokeV.intValue;
    }

    public ProgressType getProgressType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (ProgressType) invokeV.objValue;
    }

    public long getTimeMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : invokeV.longValue;
    }

    public void initialize(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, attributeSet) == null) {
            this.l.setAntiAlias(true);
            ColorStateList valueOf = ColorStateList.valueOf(0);
            this.f44878h = valueOf;
            this.f44879i = valueOf.getColorForState(getDrawableState(), 0);
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

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            getDrawingRect(this.r);
            float width = (this.r.height() > this.r.width() ? this.r.width() : this.r.height()) / 2;
            this.l.setStyle(Paint.Style.FILL);
            this.l.setColor(this.f44876f);
            this.l.setAlpha(127);
            canvas.drawCircle(this.r.centerX(), this.r.centerY(), width - this.f44877g, this.l);
            this.l.setStyle(Paint.Style.STROKE);
            this.l.setColor(this.f44876f);
            this.l.setStrokeWidth(this.k);
            this.l.setStrokeCap(Paint.Cap.ROUND);
            this.l.setAlpha(204);
            canvas.drawCircle(this.r.centerX(), this.r.centerY(), width - (this.k / 2), this.l);
            TextPaint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(getText().toString(), this.r.centerX(), this.r.centerY() - ((paint.descent() + paint.ascent()) / 2.0f), paint);
            this.l.setColor(this.f44880j);
            this.l.setStyle(Paint.Style.STROKE);
            this.l.setStrokeWidth(this.k);
            this.l.setStrokeCap(Paint.Cap.ROUND);
            this.l.setAlpha(204);
            RectF rectF = this.m;
            int i2 = this.r.left;
            int i3 = this.k;
            rectF.set(i2 + (i3 / 2), rect.top + (i3 / 2), rect.right - (i3 / 2), rect.bottom - (i3 / 2));
            canvas.drawArc(this.m, 270.0f, (this.o * 360) / this.n, false, this.l);
        }
    }

    public void reStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b();
            start();
        }
    }

    public void setInCircleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f44878h = ColorStateList.valueOf(i2);
            invalidate();
        }
    }

    public void setOutLineColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f44876f = i2;
            invalidate();
        }
    }

    public void setOutLineWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f44877g = i2;
            invalidate();
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.o = d(i2);
            invalidate();
        }
    }

    public void setProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f44880j = i2;
            invalidate();
        }
    }

    public void setProgressLineWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.k = i2;
            invalidate();
        }
    }

    public void setProgressTotalPart(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.n = i2;
            b();
        }
    }

    public void setProgressType(ProgressType progressType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, progressType) == null) {
            this.p = progressType;
            b();
            invalidate();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void setTimeMillis(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.q = j2;
            invalidate();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            setTaskPeriod(this.q / this.n);
            super.start();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.stop();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void updateProTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int i2 = a.f44881a[this.p.ordinal()];
            if (i2 == 1) {
                this.o++;
            } else if (i2 == 2) {
                this.o--;
            }
            int i3 = this.o;
            if (i3 >= 0 && i3 <= this.n) {
                AbsCountDownView.b bVar = this.mCountdownProgressListener;
                if (bVar != null) {
                    bVar.onProgress(i3);
                }
                postInvalidate();
                return;
            }
            this.o = d(this.o);
            AbsCountDownView.b bVar2 = this.mCountdownProgressListener;
            if (bVar2 != null) {
                bVar2.onEnd();
            }
            stop();
        }
    }

    @Override // com.baidu.sdk.container.widget.AbsCountDownView
    public void updateProgres(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            this.o = (this.n * i3) / i2;
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
        this.f44876f = -16777216;
        this.f44877g = 2;
        this.f44878h = ColorStateList.valueOf(0);
        this.f44880j = -16776961;
        this.k = 8;
        this.l = new Paint();
        this.m = new RectF();
        this.n = 100;
        this.o = 100;
        this.p = ProgressType.COUNT_BACK;
        this.q = 3000L;
        this.r = new Rect();
        initialize(context, attributeSet);
    }
}
