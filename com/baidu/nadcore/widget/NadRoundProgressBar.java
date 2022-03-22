package com.baidu.nadcore.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NadRoundProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;

    /* renamed from: b  reason: collision with root package name */
    public int f27742b;

    /* renamed from: c  reason: collision with root package name */
    public int f27743c;

    /* renamed from: d  reason: collision with root package name */
    public final int f27744d;

    /* renamed from: e  reason: collision with root package name */
    public final float f27745e;

    /* renamed from: f  reason: collision with root package name */
    public final float f27746f;

    /* renamed from: g  reason: collision with root package name */
    public float f27747g;

    /* renamed from: h  reason: collision with root package name */
    public int f27748h;
    public int i;
    public final boolean j;
    public final int k;
    public final RectF l;
    public a m;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRoundProgressBar(Context context) {
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

    public synchronized int getMax() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i = this.f27748h;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int getProgress() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i = this.i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            int width = getWidth() / 2;
            float f2 = width;
            int i = (int) ((f2 - (this.f27747g / 2.0f)) - 5.0f);
            this.a.setColor(this.f27742b);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(this.f27747g);
            this.a.setAntiAlias(true);
            canvas.drawCircle(f2, f2, i, this.a);
            this.a.setStyle(Paint.Style.FILL);
            this.a.setStrokeWidth(0.0f);
            this.a.setColor(this.f27744d);
            this.a.setTextSize(this.f27745e);
            this.a.setTypeface(Typeface.DEFAULT_BOLD);
            int i2 = (int) ((this.i / this.f27748h) * 100.0f);
            float measureText = this.a.measureText(String.valueOf(i2));
            this.a.setTextSize(this.f27746f);
            float measureText2 = this.a.measureText("%");
            if (this.j && this.k == 0) {
                if (i2 == 0) {
                    i2 = 1;
                }
                this.a.setTextSize(this.f27745e);
                canvas.drawText(String.valueOf(i2), f2 - ((measureText + measureText2) / 2.0f), ((this.f27745e / 2.0f) + f2) - 5.0f, this.a);
                this.a.setTextSize(this.f27746f);
                canvas.drawText("%", ((measureText / 2.0f) + f2) - (measureText2 / 2.0f), (f2 + (this.f27745e / 2.0f)) - 5.0f, this.a);
            }
            this.a.setStrokeWidth(this.f27747g);
            this.a.setColor(this.f27743c);
            float f3 = width - i;
            float f4 = width + i;
            this.l.set(f3, f3, f4, f4);
            this.a.setStrokeCap(Paint.Cap.ROUND);
            int i3 = this.k;
            if (i3 == 0) {
                this.a.setStyle(Paint.Style.STROKE);
                canvas.drawArc(this.l, -90.0f, (this.i * 360.0f) / this.f27748h, false, this.a);
            } else if (i3 != 1) {
            } else {
                this.a.setStyle(Paint.Style.FILL_AND_STROKE);
                int i4 = this.i;
                if (i4 != 0) {
                    canvas.drawArc(this.l, -90.0f, (i4 * 360.0f) / this.f27748h, true, this.a);
                }
            }
        }
    }

    public void setCircleColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f27742b = i;
            postInvalidate();
        }
    }

    public void setCircleProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f27743c = i;
            postInvalidate();
        }
    }

    public synchronized void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            synchronized (this) {
                this.f27748h = i;
            }
        }
    }

    public void setOnProgressChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public synchronized void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            synchronized (this) {
                if (i > this.f27748h) {
                    i = this.f27748h;
                }
                this.i = i;
                if (this.m != null) {
                    this.m.a(i);
                }
                postInvalidate();
            }
        }
    }

    public void setRoundProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f27743c = i;
        }
    }

    public void setRoundWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f27747g = f2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadRoundProgressBar(Context context, AttributeSet attributeSet) {
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
    @SuppressLint({"PrivateResource"})
    public NadRoundProgressBar(Context context, AttributeSet attributeSet, int i) {
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
        this.a = new Paint();
        this.l = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040416, R.attr.obfuscated_res_0x7f040447, R.attr.obfuscated_res_0x7f0404f8, R.attr.obfuscated_res_0x7f040508, R.attr.obfuscated_res_0x7f040509, R.attr.obfuscated_res_0x7f04050a, R.attr.obfuscated_res_0x7f04050b, R.attr.obfuscated_res_0x7f04050c, R.attr.obfuscated_res_0x7f04050e, R.attr.obfuscated_res_0x7f040510, R.attr.obfuscated_res_0x7f040511, R.attr.obfuscated_res_0x7f040611, R.attr.obfuscated_res_0x7f04061b, R.attr.obfuscated_res_0x7f04061e});
        this.f27742b = obtainStyledAttributes.getColor(3, getResources().getColor(R.color.obfuscated_res_0x7f060820));
        this.f27743c = obtainStyledAttributes.getColor(7, getResources().getColor(R.color.obfuscated_res_0x7f060821));
        this.f27744d = obtainStyledAttributes.getColor(8, getResources().getColor(R.color.obfuscated_res_0x7f060822));
        this.f27745e = obtainStyledAttributes.getDimension(9, f.c.a(getContext(), 11.0f));
        this.f27746f = obtainStyledAttributes.getDimension(4, f.c.a(getContext(), 8.0f));
        this.f27747g = obtainStyledAttributes.getDimension(10, 5.0f);
        this.f27748h = obtainStyledAttributes.getInteger(5, 100);
        this.j = obtainStyledAttributes.getBoolean(12, true);
        this.k = obtainStyledAttributes.getInt(1, 0);
        obtainStyledAttributes.recycle();
    }
}
