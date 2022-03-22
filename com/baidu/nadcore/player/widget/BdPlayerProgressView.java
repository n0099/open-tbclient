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
import c.a.a0.v.v0.d;
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
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public int f27610b;

    /* renamed from: c  reason: collision with root package name */
    public String f27611c;

    /* renamed from: d  reason: collision with root package name */
    public String f27612d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f27613e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27614f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27615g;

    /* renamed from: h  reason: collision with root package name */
    public int f27616h;
    public int i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdPlayerProgressView(Context context) {
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

    public final int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            int i3 = this.f27614f;
            if (i3 != 0) {
                if (i3 == 1 || i3 != 2) {
                    return 0;
                }
                return getMeasuredWidth() - i2;
            }
            return (getMeasuredWidth() - i2) / 2;
        }
        return invokeII.intValue;
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            Paint.FontMetricsInt fontMetricsInt = this.f27613e.getFontMetricsInt();
            int i = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i) / 2) - i;
            canvas.drawText(this.f27611c, a(this.f27614f, (int) this.f27613e.measureText(this.f27611c)), measuredHeight, this.f27613e);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Paint.FontMetricsInt fontMetricsInt = this.f27613e.getFontMetricsInt();
            int i = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i) / 2) - i;
            canvas.drawText(this.f27612d, a(this.f27614f, (int) this.f27613e.measureText(this.f27612d)), measuredHeight, this.f27613e);
        }
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == 1073741824) {
                return this.i;
            }
            if (mode == Integer.MIN_VALUE) {
                return Math.min(this.i, size);
            }
            return this.i;
        }
        return invokeI.intValue;
    }

    public final int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int measureText = (int) this.f27613e.measureText(this.f27615g == 1 ? com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT : com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_TIME_TEXT);
            int mode = View.MeasureSpec.getMode(i);
            return mode == 1073741824 ? View.MeasureSpec.getSize(i) : mode == Integer.MIN_VALUE ? measureText : this.f27616h;
        }
        return invokeI.intValue;
    }

    public String getPositionText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27611c : (String) invokeV.objValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27610b : invokeV.intValue;
    }

    public float getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.floatValue;
    }

    public String getTimeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27612d : (String) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            int i = this.f27615g;
            if (i == 1) {
                b(canvas);
            } else if (i == 2) {
                c(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            setMeasuredDimension(e(i), d(i2));
        }
    }

    public void setPositionText(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && this.f27615g == 1) {
            this.f27611c = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f27610b = i;
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.a = f2;
            this.f27613e.setTextSize(f2);
            invalidate();
        }
    }

    public void setTimeText(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && this.f27615g == 2) {
            this.f27612d = str;
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
    @SuppressLint({"CustomViewStyleable"})
    public BdPlayerProgressView(Context context, AttributeSet attributeSet, int i) {
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
        this.f27611c = com.baidu.searchbox.player.widget.BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT;
        this.f27616h = 0;
        this.i = 0;
        this.f27616h = d.a(this, 120.0f);
        this.i = d.a(this, 15.0f);
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040432, R.attr.obfuscated_res_0x7f040433, R.attr.obfuscated_res_0x7f040434, R.attr.obfuscated_res_0x7f040435});
            this.a = typedArray.getDimension(3, 15.0f);
            this.f27610b = typedArray.getColor(1, -1);
            this.f27614f = typedArray.getInt(0, 1);
            this.f27615g = typedArray.getInt(2, 1);
            Paint paint = new Paint();
            this.f27613e = paint;
            paint.setAntiAlias(true);
            this.f27613e.setColor(this.f27610b);
            this.f27613e.setTextSize(this.a);
            if (this.f27615g == 2) {
                this.f27613e.setFakeBoldText(true);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }
}
