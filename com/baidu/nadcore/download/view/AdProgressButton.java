package com.baidu.nadcore.download.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hj0;
import com.repackage.oi0;
import com.repackage.p01;
/* loaded from: classes2.dex */
public class AdProgressButton extends View implements hj0<AdProgressButton> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Paint c;
    public Paint d;
    public float e;
    public int f;
    public String g;
    public int h;
    public int i;
    public int j;
    public Typeface k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdProgressButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = -1;
        this.e = 10.0f;
        this.h = 100;
        this.i = 0;
        this.j = 0;
        d(context, null);
    }

    @Override // com.repackage.hj0
    public void b(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13, -1);
            viewGroup.addView(this, layoutParams);
            viewGroup.setVisibility(0);
        }
    }

    public void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.a <= 0) {
            return;
        }
        int i = this.j;
        int measuredWidth = getMeasuredWidth() - this.j;
        float f = this.a / (this.h + 0.0f);
        float f2 = i;
        float f3 = measuredWidth;
        RectF rectF = new RectF(f2, i, f3, getMeasuredHeight() - this.j);
        this.c.setShader(new LinearGradient(f2, 0.0f, f3, 0.0f, new int[]{this.f, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP));
        int i2 = this.i;
        canvas.drawRoundRect(rectF, i2, i2, this.c);
    }

    public final void d(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0404e7, R.attr.obfuscated_res_0x7f0404e8, R.attr.obfuscated_res_0x7f0404e9, R.attr.obfuscated_res_0x7f0404ea, R.attr.obfuscated_res_0x7f0404eb, R.attr.obfuscated_res_0x7f0404ec, R.attr.obfuscated_res_0x7f0404ed, R.attr.obfuscated_res_0x7f0404ee, R.attr.obfuscated_res_0x7f0404ef, R.attr.obfuscated_res_0x7f0404f0, R.attr.obfuscated_res_0x7f0404f1, R.attr.obfuscated_res_0x7f0404f2, R.attr.obfuscated_res_0x7f0404f3});
            int color = getResources().getColor(R.color.obfuscated_res_0x7f060852);
            int color2 = getResources().getColor(R.color.obfuscated_res_0x7f060851);
            int a = p01.c.a(getContext(), 11.0f);
            int a2 = p01.c.a(getContext(), 12.0f);
            this.j = 1;
            this.f = obtainStyledAttributes.getInteger(0, color2);
            this.b = obtainStyledAttributes.getColor(8, color);
            this.h = obtainStyledAttributes.getInteger(2, this.h);
            this.a = obtainStyledAttributes.getInteger(4, 0);
            this.g = obtainStyledAttributes.getString(6);
            this.e = obtainStyledAttributes.getDimension(9, a);
            this.i = obtainStyledAttributes.getDimensionPixelSize(5, a2);
            obtainStyledAttributes.recycle();
            this.k = Typeface.defaultFromStyle(1);
            setBackgroundDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080da7));
            e();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = new Paint();
            Paint paint = new Paint();
            this.d = paint;
            paint.setAntiAlias(true);
            this.d.setTextSize(this.e);
            this.d.setColor(this.b);
            this.d.setTypeface(this.k);
            this.c.setAntiAlias(true);
            this.c.setStyle(Paint.Style.FILL);
        }
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hj0
    @NonNull
    public AdProgressButton getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (AdProgressButton) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            c(canvas);
            if (TextUtils.isEmpty(this.g)) {
                return;
            }
            Paint.FontMetrics fontMetrics = this.d.getFontMetrics();
            float f = fontMetrics.descent;
            canvas.drawText(this.g, (getMeasuredWidth() - this.d.measureText(this.g)) / 2.0f, ((getHeight() / 2) - f) + ((f - fontMetrics.ascent) / 2.0f), this.d);
        }
    }

    public void setForeground(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f = i;
            e();
            postInvalidate();
        }
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.h = i;
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i > this.h) {
            return;
        }
        this.a = i;
        this.g = this.a + "%";
        postInvalidate();
    }

    public void setProgressNoText(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || i > this.h) {
            return;
        }
        this.a = i;
        this.g = "";
        postInvalidate();
    }

    public void setRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.i = i;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.g = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b = i;
            e();
            postInvalidate();
        }
    }

    public void setTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.e = i;
            e();
            postInvalidate();
        }
    }

    @Override // com.repackage.hj0
    public void update(String str, @NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, oi0Var) == null) {
            if (oi0Var.c == AdDownloadStatus.DOWNLOADING) {
                setProgress((int) (oi0Var.i * 100.0f));
                return;
            }
            setProgressNoText(0);
            setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = -1;
        this.e = 10.0f;
        this.h = 100;
        this.i = 0;
        this.j = 0;
        d(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdProgressButton(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 0;
        this.b = -1;
        this.e = 10.0f;
        this.h = 100;
        this.i = 0;
        this.j = 0;
        d(context, attributeSet);
    }
}
