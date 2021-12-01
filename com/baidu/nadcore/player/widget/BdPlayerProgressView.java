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
import c.a.b0.h0.v;
import c.a.b0.s.v0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BdPlayerProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f37658e;

    /* renamed from: f  reason: collision with root package name */
    public int f37659f;

    /* renamed from: g  reason: collision with root package name */
    public String f37660g;

    /* renamed from: h  reason: collision with root package name */
    public String f37661h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f37662i;

    /* renamed from: j  reason: collision with root package name */
    public final int f37663j;

    /* renamed from: k  reason: collision with root package name */
    public final int f37664k;
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
            int i4 = this.f37663j;
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
            Paint.FontMetricsInt fontMetricsInt = this.f37662i.getFontMetricsInt();
            int i2 = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
            canvas.drawText(this.f37660g, a(this.f37663j, (int) this.f37662i.measureText(this.f37660g)), measuredHeight, this.f37662i);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Paint.FontMetricsInt fontMetricsInt = this.f37662i.getFontMetricsInt();
            int i2 = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
            canvas.drawText(this.f37661h, a(this.f37663j, (int) this.f37662i.measureText(this.f37661h)), measuredHeight, this.f37662i);
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
            int measureText = (int) this.f37662i.measureText(this.f37664k == 1 ? "00:00:00" : "00:00");
            int mode = View.MeasureSpec.getMode(i2);
            return mode == 1073741824 ? View.MeasureSpec.getSize(i2) : mode == Integer.MIN_VALUE ? measureText : this.l;
        }
        return invokeI.intValue;
    }

    public String getPositionText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37660g : (String) invokeV.objValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37659f : invokeV.intValue;
    }

    public float getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37658e : invokeV.floatValue;
    }

    public String getTimeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f37661h : (String) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            int i2 = this.f37664k;
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
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && this.f37664k == 1) {
            this.f37660g = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f37659f = i2;
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.f37658e = f2;
            this.f37662i.setTextSize(f2);
            invalidate();
        }
    }

    public void setTimeText(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && this.f37664k == 2) {
            this.f37661h = str;
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
        this.f37660g = "00:00:00";
        this.l = 0;
        this.m = 0;
        this.l = d.a(this, 120.0f);
        this.m = d.a(this, 15.0f);
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, v.nad_bdvideoplayer_bdPlayerProgressView);
            this.f37658e = typedArray.getDimension(v.nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextSize, 15.0f);
            this.f37659f = typedArray.getColor(v.nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextColor, -1);
            this.f37663j = typedArray.getInt(v.nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressGravity, 1);
            this.f37664k = typedArray.getInt(v.nad_bdvideoplayer_bdPlayerProgressView_nad_bdvideoplayer_progressTextMode, 1);
            Paint paint = new Paint();
            this.f37662i = paint;
            paint.setAntiAlias(true);
            this.f37662i.setColor(this.f37659f);
            this.f37662i.setTextSize(this.f37658e);
            if (this.f37664k == 2) {
                this.f37662i.setFakeBoldText(true);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }
}
