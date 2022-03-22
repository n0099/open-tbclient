package com.baidu.nadcore.video.videoplayer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.i0.a.d.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BdTextProgressView extends View {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final int f27702h;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public int f27703b;

    /* renamed from: c  reason: collision with root package name */
    public String f27704c;

    /* renamed from: d  reason: collision with root package name */
    public String f27705d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f27706e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27707f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27708g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744809923, "Lcom/baidu/nadcore/video/videoplayer/widget/BdTextProgressView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744809923, "Lcom/baidu/nadcore/video/videoplayer/widget/BdTextProgressView;");
                return;
            }
        }
        f27702h = b.a(120.0f);
        i = b.a(15.0f);
        b.a(2.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdTextProgressView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            int i4 = this.f27707f;
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
            Paint.FontMetricsInt fontMetricsInt = this.f27706e.getFontMetricsInt();
            int i2 = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
            canvas.drawText(this.f27704c, a(this.f27707f, (int) this.f27706e.measureText(this.f27704c)), measuredHeight, this.f27706e);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Paint.FontMetricsInt fontMetricsInt = this.f27706e.getFontMetricsInt();
            int i2 = fontMetricsInt.top;
            int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i2) / 2) - i2;
            canvas.drawText(this.f27705d, a(this.f27707f, (int) this.f27706e.measureText(this.f27705d)), measuredHeight, this.f27706e);
        }
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                return i;
            }
            if (mode == Integer.MIN_VALUE) {
                return Math.min(i, size);
            }
            return i;
        }
        return invokeI.intValue;
    }

    public final int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int measureText = (int) this.f27706e.measureText(this.f27708g == 1 ? BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT : BdPlayerProgressView.DEFAULT_TIME_TEXT);
            int mode = View.MeasureSpec.getMode(i2);
            return mode == 1073741824 ? View.MeasureSpec.getSize(i2) : mode == Integer.MIN_VALUE ? measureText : f27702h;
        }
        return invokeI.intValue;
    }

    public String getPositionText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27704c : (String) invokeV.objValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27703b : invokeV.intValue;
    }

    public float getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.floatValue;
    }

    public String getTimeText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27705d : (String) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            super.onDraw(canvas);
            int i2 = this.f27708g;
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

    public void setPositionText(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && this.f27708g == 1) {
            this.f27704c = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f27703b = i2;
        }
    }

    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.a = f2;
            this.f27706e.setTextSize(f2);
            invalidate();
        }
    }

    public void setTimeText(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && this.f27708g == 2) {
            this.f27705d = str;
            postInvalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdTextProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTextProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f27704c = BdPlayerProgressView.DEFAULT_PROGRESS_TIME_TEXT;
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040443, R.attr.obfuscated_res_0x7f040444, R.attr.obfuscated_res_0x7f040445, R.attr.obfuscated_res_0x7f040446});
            this.a = typedArray.getDimension(3, 15.0f);
            this.f27703b = typedArray.getColor(1, -1);
            this.f27707f = typedArray.getInt(0, 1);
            this.f27708g = typedArray.getInt(2, 1);
            Paint paint = new Paint();
            this.f27706e = paint;
            paint.setAntiAlias(true);
            this.f27706e.setColor(this.f27703b);
            this.f27706e.setTextSize(this.a);
            if (this.f27708g == 2) {
                this.f27706e.setFakeBoldText(true);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }
}
