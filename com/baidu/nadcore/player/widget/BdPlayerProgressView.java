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
import c.a.b0.v.v0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BdPlayerProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f35736e;

    /* renamed from: f  reason: collision with root package name */
    public int f35737f;

    /* renamed from: g  reason: collision with root package name */
    public String f35738g;

    /* renamed from: h  reason: collision with root package name */
    public String f35739h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f35740i;

    /* renamed from: j  reason: collision with root package name */
    public final int f35741j;
    public final int k;
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
            int i4 = this.f35741j;
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
            Paint.FontMetricsInt fontMetricsInt = this.f35740i.getFontMetricsInt();
            int i2 = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
            canvas.drawText(this.f35738g, a(this.f35741j, (int) this.f35740i.measureText(this.f35738g)), measuredHeight, this.f35740i);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Paint.FontMetricsInt fontMetricsInt = this.f35740i.getFontMetricsInt();
            int i2 = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
            canvas.drawText(this.f35739h, a(this.f35741j, (int) this.f35740i.measureText(this.f35739h)), measuredHeight, this.f35740i);
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
            int measureText = (int) this.f35740i.measureText(this.k == 1 ? com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT : com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_TIME_TEXT);
            int mode = View.MeasureSpec.getMode(i2);
            return mode == 1073741824 ? View.MeasureSpec.getSize(i2) : mode == Integer.MIN_VALUE ? measureText : this.l;
        }
        return invokeI.intValue;
    }

    public String getPositionText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35738g : (String) invokeV.objValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35737f : invokeV.intValue;
    }

    public float getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f35736e : invokeV.floatValue;
    }

    public String getTimeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f35739h : (String) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            int i2 = this.k;
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
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && this.k == 1) {
            this.f35738g = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f35737f = i2;
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.f35736e = f2;
            this.f35740i.setTextSize(f2);
            invalidate();
        }
    }

    public void setTimeText(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && this.k == 2) {
            this.f35739h = str;
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
        this.f35738g = com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT;
        this.l = 0;
        this.m = 0;
        this.l = d.a(this, 120.0f);
        this.m = d.a(this, 15.0f);
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.nad_bdvideoplayer_progressGravity, R.attr.nad_bdvideoplayer_progressTextColor, R.attr.nad_bdvideoplayer_progressTextMode, R.attr.nad_bdvideoplayer_progressTextSize});
            this.f35736e = typedArray.getDimension(3, 15.0f);
            this.f35737f = typedArray.getColor(1, -1);
            this.f35741j = typedArray.getInt(0, 1);
            this.k = typedArray.getInt(2, 1);
            Paint paint = new Paint();
            this.f35740i = paint;
            paint.setAntiAlias(true);
            this.f35740i.setColor(this.f35737f);
            this.f35740i.setTextSize(this.f35736e);
            if (this.k == 2) {
                this.f35740i.setFakeBoldText(true);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }
}
