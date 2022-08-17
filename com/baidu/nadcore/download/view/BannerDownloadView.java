package com.baidu.nadcore.download.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BannerDownloadView extends AppCompatTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public int b;
    public float c;
    public int d;
    public int e;
    public String f;
    public float g;
    public int h;
    public int i;
    public final Paint j;
    public final Paint k;
    public final Paint l;
    public final RectF m;
    public final RectF n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.b = -1;
        this.c = 10.0f;
        this.g = 1.0f;
        this.h = 0;
        this.i = 0;
        this.j = new Paint();
        this.k = new Paint();
        this.l = new Paint();
        this.m = new RectF();
        this.n = new RectF();
        g(context, attributeSet);
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.h = getMeasuredHeight() / 2;
            RectF rectF = this.n;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = getMeasuredWidth();
            this.n.bottom = getMeasuredHeight();
            this.k.setStrokeWidth(this.i);
            this.k.setColor(Color.parseColor("#E5E5E5"));
            RectF rectF2 = this.n;
            int i = this.h;
            canvas.drawRoundRect(rectF2, i, i, this.k);
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.h = getMeasuredHeight() / 2;
            RectF rectF = this.m;
            int i = this.i;
            rectF.left = i;
            rectF.top = i;
            rectF.bottom = getMeasuredHeight() - this.i;
            this.m.right = getMeasuredWidth() * this.a;
            RectF rectF2 = this.m;
            float f = rectF2.right;
            int i2 = this.h;
            if (f < i2 * 2) {
                rectF2.right = i2 * 2;
            }
            this.j.setShader(new LinearGradient(0.0f, 0.0f, this.m.right, 0.0f, new int[]{this.d, this.e}, (float[]) null, Shader.TileMode.CLAMP));
            RectF rectF3 = this.m;
            int i3 = this.h;
            canvas.drawRoundRect(rectF3, i3, i3, this.j);
        }
    }

    public final void f(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Paint.FontMetrics fontMetrics = this.l.getFontMetrics();
            float f = fontMetrics.descent;
            float measuredWidth = (getMeasuredWidth() - this.l.measureText(this.f)) / 2.0f;
            canvas.drawText(this.f, measuredWidth, (float) (((getHeight() / 2) - f) + ((f - fontMetrics.ascent) / 2.0f) + 0.5d), this.l);
        }
    }

    public final void g(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0404e8, R.attr.obfuscated_res_0x7f0404e9, R.attr.obfuscated_res_0x7f0404ea, R.attr.obfuscated_res_0x7f0404eb, R.attr.obfuscated_res_0x7f0404ec, R.attr.obfuscated_res_0x7f0404ed, R.attr.obfuscated_res_0x7f0404ee, R.attr.obfuscated_res_0x7f0404ef, R.attr.obfuscated_res_0x7f0404f0, R.attr.obfuscated_res_0x7f0404f1, R.attr.obfuscated_res_0x7f0404f2, R.attr.obfuscated_res_0x7f0404f3, R.attr.obfuscated_res_0x7f0404f4});
            int color = getResources().getColor(R.color.obfuscated_res_0x7f060829);
            int color2 = getResources().getColor(R.color.obfuscated_res_0x7f060828);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070563);
            this.i = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070562);
            this.d = obtainStyledAttributes.getInteger(0, color2);
            this.e = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.obfuscated_res_0x7f060827));
            this.b = obtainStyledAttributes.getColor(8, color);
            this.g = obtainStyledAttributes.getFloat(2, this.g);
            this.a = obtainStyledAttributes.getFloat(4, 0.0f);
            this.f = obtainStyledAttributes.getString(6);
            this.c = obtainStyledAttributes.getDimension(9, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070561));
            this.h = obtainStyledAttributes.getDimensionPixelSize(5, dimensionPixelSize);
            obtainStyledAttributes.recycle();
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l.setAntiAlias(true);
            this.l.setTextSize(this.c);
            this.l.setColor(this.b);
            this.j.setAntiAlias(true);
            this.j.setStyle(Paint.Style.FILL);
            this.k.setAntiAlias(true);
            this.k.setStyle(Paint.Style.STROKE);
            setGravity(17);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.a > 0.0f) {
                e(canvas);
            }
            d(canvas);
            if (TextUtils.isEmpty(this.f)) {
                return;
            }
            f(canvas);
        }
    }

    public void setProgress(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048582, this, f) == null) || f < 0.0f || f > this.g || f == this.a) {
            return;
        }
        this.a = f;
        postInvalidate();
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || str == null || str.equals(this.f)) {
            return;
        }
        this.f = str;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || i == this.b) {
            return;
        }
        this.b = i;
        h();
        postInvalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0.0f;
        this.b = -1;
        this.c = 10.0f;
        this.g = 1.0f;
        this.h = 0;
        this.i = 0;
        this.j = new Paint();
        this.k = new Paint();
        this.l = new Paint();
        this.m = new RectF();
        this.n = new RectF();
        g(context, attributeSet);
    }
}
