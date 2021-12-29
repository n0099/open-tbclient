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
import c.a.c0.d0.f;
import c.a.c0.h0.o;
import c.a.c0.h0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class NadRoundProgressBar extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILL = 1;
    public static final int STROKE = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f38447e;

    /* renamed from: f  reason: collision with root package name */
    public int f38448f;

    /* renamed from: g  reason: collision with root package name */
    public int f38449g;

    /* renamed from: h  reason: collision with root package name */
    public final int f38450h;

    /* renamed from: i  reason: collision with root package name */
    public final float f38451i;

    /* renamed from: j  reason: collision with root package name */
    public final float f38452j;

    /* renamed from: k  reason: collision with root package name */
    public float f38453k;
    public int l;
    public int m;
    public final boolean n;
    public final int o;
    public final RectF p;
    public a q;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i2);
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

    public synchronized int getMax() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i2 = this.l;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int getProgress() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i2 = this.m;
            }
            return i2;
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
            int i2 = (int) ((f2 - (this.f38453k / 2.0f)) - 5.0f);
            this.f38447e.setColor(this.f38448f);
            this.f38447e.setStyle(Paint.Style.STROKE);
            this.f38447e.setStrokeWidth(this.f38453k);
            this.f38447e.setAntiAlias(true);
            canvas.drawCircle(f2, f2, i2, this.f38447e);
            this.f38447e.setStyle(Paint.Style.FILL);
            this.f38447e.setStrokeWidth(0.0f);
            this.f38447e.setColor(this.f38450h);
            this.f38447e.setTextSize(this.f38451i);
            this.f38447e.setTypeface(Typeface.DEFAULT_BOLD);
            int i3 = (int) ((this.m / this.l) * 100.0f);
            float measureText = this.f38447e.measureText(String.valueOf(i3));
            this.f38447e.setTextSize(this.f38452j);
            float measureText2 = this.f38447e.measureText("%");
            if (this.n && this.o == 0) {
                if (i3 == 0) {
                    i3 = 1;
                }
                this.f38447e.setTextSize(this.f38451i);
                canvas.drawText(String.valueOf(i3), f2 - ((measureText + measureText2) / 2.0f), ((this.f38451i / 2.0f) + f2) - 5.0f, this.f38447e);
                this.f38447e.setTextSize(this.f38452j);
                canvas.drawText("%", ((measureText / 2.0f) + f2) - (measureText2 / 2.0f), (f2 + (this.f38451i / 2.0f)) - 5.0f, this.f38447e);
            }
            this.f38447e.setStrokeWidth(this.f38453k);
            this.f38447e.setColor(this.f38449g);
            float f3 = width - i2;
            float f4 = width + i2;
            this.p.set(f3, f3, f4, f4);
            this.f38447e.setStrokeCap(Paint.Cap.ROUND);
            int i4 = this.o;
            if (i4 == 0) {
                this.f38447e.setStyle(Paint.Style.STROKE);
                canvas.drawArc(this.p, -90.0f, (this.m * 360.0f) / this.l, false, this.f38447e);
            } else if (i4 != 1) {
            } else {
                this.f38447e.setStyle(Paint.Style.FILL_AND_STROKE);
                int i5 = this.m;
                if (i5 != 0) {
                    canvas.drawArc(this.p, -90.0f, (i5 * 360.0f) / this.l, true, this.f38447e);
                }
            }
        }
    }

    public void setCircleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f38448f = i2;
            postInvalidate();
        }
    }

    public void setCircleProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f38449g = i2;
            postInvalidate();
        }
    }

    public synchronized void setMax(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            synchronized (this) {
                this.l = i2;
            }
        }
    }

    public void setOnProgressChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public synchronized void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            synchronized (this) {
                if (i2 > this.l) {
                    i2 = this.l;
                }
                this.m = i2;
                if (this.q != null) {
                    this.q.a(i2);
                }
                postInvalidate();
            }
        }
    }

    public void setRoundProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f38449g = i2;
        }
    }

    public void setRoundWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.f38453k = f2;
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
    @SuppressLint({"PrivateResource"})
    public NadRoundProgressBar(Context context, AttributeSet attributeSet, int i2) {
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
        this.f38447e = new Paint();
        this.p = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v.NadRoundProgressBar);
        this.f38448f = obtainStyledAttributes.getColor(v.NadRoundProgressBar_roundColor, getResources().getColor(o.nad_mini_video_round_progress_border_color));
        this.f38449g = obtainStyledAttributes.getColor(v.NadRoundProgressBar_roundProgressColor, getResources().getColor(o.nad_mini_video_round_progress_color));
        this.f38450h = obtainStyledAttributes.getColor(v.NadRoundProgressBar_roundTextColor, getResources().getColor(o.nad_mini_video_round_progress_text_color));
        this.f38451i = obtainStyledAttributes.getDimension(v.NadRoundProgressBar_roundTextSize, f.c.a(getContext(), 11.0f));
        this.f38452j = obtainStyledAttributes.getDimension(v.NadRoundProgressBar_roundHintTextSize, f.c.a(getContext(), 8.0f));
        this.f38453k = obtainStyledAttributes.getDimension(v.NadRoundProgressBar_roundWidth, 5.0f);
        this.l = obtainStyledAttributes.getInteger(v.NadRoundProgressBar_roundMax, 100);
        this.n = obtainStyledAttributes.getBoolean(v.NadRoundProgressBar_textIsDisplayable, true);
        this.o = obtainStyledAttributes.getInt(v.NadRoundProgressBar_nad_style, 0);
        obtainStyledAttributes.recycle();
    }
}
