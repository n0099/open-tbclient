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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m11;
/* loaded from: classes2.dex */
public class NadRoundProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;
    public int b;
    public int c;
    public final int d;
    public final float e;
    public final float f;
    public float g;
    public int h;
    public int i;
    public final boolean j;
    public final int k;
    public final RectF l;
    public a m;

    /* loaded from: classes2.dex */
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
                i = this.h;
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
            float f = width;
            int i = (int) ((f - (this.g / 2.0f)) - 5.0f);
            this.a.setColor(this.b);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(this.g);
            this.a.setAntiAlias(true);
            canvas.drawCircle(f, f, i, this.a);
            this.a.setStyle(Paint.Style.FILL);
            this.a.setStrokeWidth(0.0f);
            this.a.setColor(this.d);
            this.a.setTextSize(this.e);
            this.a.setTypeface(Typeface.DEFAULT_BOLD);
            int i2 = (int) ((this.i / this.h) * 100.0f);
            float measureText = this.a.measureText(String.valueOf(i2));
            this.a.setTextSize(this.f);
            float measureText2 = this.a.measureText("%");
            if (this.j && this.k == 0) {
                if (i2 == 0) {
                    i2 = 1;
                }
                this.a.setTextSize(this.e);
                canvas.drawText(String.valueOf(i2), f - ((measureText + measureText2) / 2.0f), ((this.e / 2.0f) + f) - 5.0f, this.a);
                this.a.setTextSize(this.f);
                canvas.drawText("%", ((measureText / 2.0f) + f) - (measureText2 / 2.0f), (f + (this.e / 2.0f)) - 5.0f, this.a);
            }
            this.a.setStrokeWidth(this.g);
            this.a.setColor(this.c);
            float f2 = width - i;
            float f3 = width + i;
            this.l.set(f2, f2, f3, f3);
            this.a.setStrokeCap(Paint.Cap.ROUND);
            int i3 = this.k;
            if (i3 == 0) {
                this.a.setStyle(Paint.Style.STROKE);
                canvas.drawArc(this.l, -90.0f, (this.i * 360.0f) / this.h, false, this.a);
            } else if (i3 != 1) {
            } else {
                this.a.setStyle(Paint.Style.FILL_AND_STROKE);
                int i4 = this.i;
                if (i4 != 0) {
                    canvas.drawArc(this.l, -90.0f, (i4 * 360.0f) / this.h, true, this.a);
                }
            }
        }
    }

    public void setCircleColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b = i;
            postInvalidate();
        }
    }

    public void setCircleProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.c = i;
            postInvalidate();
        }
    }

    public synchronized void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            synchronized (this) {
                this.h = i;
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
                if (i > this.h) {
                    i = this.h;
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
            this.c = i;
        }
    }

    public void setRoundWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.g = f;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04045b, R.attr.obfuscated_res_0x7f04048b, R.attr.obfuscated_res_0x7f04053b, R.attr.obfuscated_res_0x7f04054b, R.attr.obfuscated_res_0x7f04054c, R.attr.obfuscated_res_0x7f04054d, R.attr.obfuscated_res_0x7f04054e, R.attr.obfuscated_res_0x7f04054f, R.attr.obfuscated_res_0x7f040551, R.attr.obfuscated_res_0x7f040553, R.attr.obfuscated_res_0x7f040554, R.attr.obfuscated_res_0x7f040657, R.attr.obfuscated_res_0x7f040661, R.attr.obfuscated_res_0x7f040664});
        this.b = obtainStyledAttributes.getColor(3, getResources().getColor(R.color.obfuscated_res_0x7f060838));
        this.c = obtainStyledAttributes.getColor(7, getResources().getColor(R.color.obfuscated_res_0x7f060839));
        this.d = obtainStyledAttributes.getColor(8, getResources().getColor(R.color.obfuscated_res_0x7f06083a));
        this.e = obtainStyledAttributes.getDimension(9, m11.c.a(getContext(), 11.0f));
        this.f = obtainStyledAttributes.getDimension(4, m11.c.a(getContext(), 8.0f));
        this.g = obtainStyledAttributes.getDimension(10, 5.0f);
        this.h = obtainStyledAttributes.getInteger(5, 100);
        this.j = obtainStyledAttributes.getBoolean(12, true);
        this.k = obtainStyledAttributes.getInt(1, 0);
        obtainStyledAttributes.recycle();
    }
}
