package com.baidu.nadcore.player.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.h0.v;
import c.a.c0.s.v0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BdPlayerProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f38303e;

    /* renamed from: f  reason: collision with root package name */
    public int f38304f;

    /* renamed from: g  reason: collision with root package name */
    public String f38305g;

    /* renamed from: h  reason: collision with root package name */
    public String f38306h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f38307i;

    /* renamed from: j  reason: collision with root package name */
    public final int f38308j;

    /* renamed from: k  reason: collision with root package name */
    public final int f38309k;
    public int l;
    public int m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdPlayerProgressView(Context context) {
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

    public final int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            int i4 = this.f38308j;
            if (i4 != 0) {
                if (i4 == 1 || i4 != 2) {
                    return 0;
                }
                return getMeasuredWidth() - i3;
            }
            return (getMeasuredWidth() - i3) / 2;
        }
        return invokeII.intValue;
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            Paint.FontMetricsInt fontMetricsInt = this.f38307i.getFontMetricsInt();
            int i2 = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
            canvas.drawText(this.f38305g, a(this.f38308j, (int) this.f38307i.measureText(this.f38305g)), measuredHeight, this.f38307i);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Paint.FontMetricsInt fontMetricsInt = this.f38307i.getFontMetricsInt();
            int i2 = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
            canvas.drawText(this.f38306h, a(this.f38308j, (int) this.f38307i.measureText(this.f38306h)), measuredHeight, this.f38307i);
        }
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                return this.m;
            }
            if (mode == Integer.MIN_VALUE) {
                return Math.min(this.m, size);
            }
            return this.m;
        }
        return invokeI.intValue;
    }

    public final int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int measureText = (int) this.f38307i.measureText(this.f38309k == 1 ? com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT : com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_TIME_TEXT);
            int mode = View.MeasureSpec.getMode(i2);
            return mode == 1073741824 ? View.MeasureSpec.getSize(i2) : mode == Integer.MIN_VALUE ? measureText : this.l;
        }
        return invokeI.intValue;
    }

    public String getPositionText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38305g : (String) invokeV.objValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38304f : invokeV.intValue;
    }

    public float getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38303e : invokeV.floatValue;
    }

    public String getTimeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f38306h : (String) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            int i2 = this.f38309k;
            if (i2 == 1) {
                b(canvas);
            } else if (i2 == 2) {
                c(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            setMeasuredDimension(e(i2), d(i3));
        }
    }

    public void setPositionText(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && this.f38309k == 1) {
            this.f38305g = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f38304f = i2;
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.f38303e = f2;
            this.f38307i.setTextSize(f2);
            invalidate();
        }
    }

    public void setTimeText(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && this.f38309k == 2) {
            this.f38306h = str;
            postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdPlayerProgressView(Context context, AttributeSet attributeSet) {
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
    @SuppressLint({"CustomViewStyleable"})
    public BdPlayerProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f38305g = com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT;
        this.l = 0;
        this.m = 0;
        this.l = d.a(this, 120.0f);
        this.m = d.a(this, 15.0f);
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, v.nad_bdvideoplayer_bdPlayerProgressView);
            this.f38303e = typedArray.getDimension(v.nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextSize, 15.0f);
            this.f38304f = typedArray.getColor(v.nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextColor, -1);
            this.f38308j = typedArray.getInt(v.nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressGravity, 1);
            this.f38309k = typedArray.getInt(v.nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextMode, 1);
            Paint paint = new Paint();
            this.f38307i = paint;
            paint.setAntiAlias(true);
            this.f38307i.setColor(this.f38304f);
            this.f38307i.setTextSize(this.f38303e);
            if (this.f38309k == 2) {
                this.f38307i.setFakeBoldText(true);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }
}
