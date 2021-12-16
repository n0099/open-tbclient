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
import c.a.c0.c0.b;
import c.a.c0.c0.c;
import c.a.c0.c0.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BannerDownloadView extends AppCompatTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f38049e;

    /* renamed from: f  reason: collision with root package name */
    public int f38050f;

    /* renamed from: g  reason: collision with root package name */
    public float f38051g;

    /* renamed from: h  reason: collision with root package name */
    public int f38052h;

    /* renamed from: i  reason: collision with root package name */
    public int f38053i;

    /* renamed from: j  reason: collision with root package name */
    public String f38054j;

    /* renamed from: k  reason: collision with root package name */
    public float f38055k;
    public int l;
    public int m;
    public final Paint n;
    public final Paint o;
    public final Paint p;
    public final RectF q;
    public final RectF r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38049e = 0.0f;
        this.f38050f = -1;
        this.f38051g = 10.0f;
        this.f38055k = 1.0f;
        this.l = 0;
        this.m = 0;
        this.n = new Paint();
        this.o = new Paint();
        this.p = new Paint();
        this.q = new RectF();
        this.r = new RectF();
        d(context, attributeSet);
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.l = getMeasuredHeight() / 2;
            RectF rectF = this.r;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = getMeasuredWidth();
            this.r.bottom = getMeasuredHeight();
            this.o.setStrokeWidth(this.m);
            this.o.setColor(Color.parseColor("#E5E5E5"));
            RectF rectF2 = this.r;
            int i2 = this.l;
            canvas.drawRoundRect(rectF2, i2, i2, this.o);
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.l = getMeasuredHeight() / 2;
            RectF rectF = this.q;
            int i2 = this.m;
            rectF.left = i2;
            rectF.top = i2;
            rectF.bottom = getMeasuredHeight() - this.m;
            this.q.right = getMeasuredWidth() * this.f38049e;
            RectF rectF2 = this.q;
            float f2 = rectF2.right;
            int i3 = this.l;
            if (f2 < i3 * 2) {
                rectF2.right = i3 * 2;
            }
            this.n.setShader(new LinearGradient(0.0f, 0.0f, this.q.right, 0.0f, new int[]{this.f38052h, this.f38053i}, (float[]) null, Shader.TileMode.CLAMP));
            RectF rectF3 = this.q;
            int i4 = this.l;
            canvas.drawRoundRect(rectF3, i4, i4, this.n);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Paint.FontMetrics fontMetrics = this.p.getFontMetrics();
            float f2 = fontMetrics.descent;
            float measuredWidth = (getMeasuredWidth() - this.p.measureText(this.f38054j)) / 2.0f;
            canvas.drawText(this.f38054j, measuredWidth, (float) (((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f) + 0.5d), this.p);
        }
    }

    public final void d(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.nad_progress);
            int color = getResources().getColor(b.nad_download_button_text_color);
            int color2 = getResources().getColor(b.nad_download_button_fg_start);
            int dimensionPixelSize = getResources().getDimensionPixelSize(c.nad_progress_button_radian);
            this.m = getResources().getDimensionPixelSize(c.nad_progress_button_frame);
            this.f38052h = obtainStyledAttributes.getInteger(i.nad_progress_nad_btn_foreground, color2);
            this.f38053i = obtainStyledAttributes.getColor(i.nad_progress_nad_btn_foreground_end, getResources().getColor(b.nad_download_button_fg_end));
            this.f38050f = obtainStyledAttributes.getColor(i.nad_progress_nad_btn_textColor, color);
            this.f38055k = obtainStyledAttributes.getFloat(i.nad_progress_nad_btn_max, this.f38055k);
            this.f38049e = obtainStyledAttributes.getFloat(i.nad_progress_nad_btn_progress, 0.0f);
            this.f38054j = obtainStyledAttributes.getString(i.nad_progress_nad_btn_text);
            this.f38051g = obtainStyledAttributes.getDimension(i.nad_progress_nad_btn_textSize, (int) getResources().getDimension(c.nad_progress_button_font_size));
            this.l = obtainStyledAttributes.getDimensionPixelSize(i.nad_progress_nad_btn_radius, dimensionPixelSize);
            obtainStyledAttributes.recycle();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.p.setAntiAlias(true);
            this.p.setTextSize(this.f38051g);
            this.p.setColor(this.f38050f);
            this.n.setAntiAlias(true);
            this.n.setStyle(Paint.Style.FILL);
            this.o.setAntiAlias(true);
            this.o.setStyle(Paint.Style.STROKE);
            setGravity(17);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f38049e > 0.0f) {
                b(canvas);
            }
            a(canvas);
            if (TextUtils.isEmpty(this.f38054j)) {
                return;
            }
            c(canvas);
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048582, this, f2) == null) || f2 < 0.0f || f2 > this.f38055k || f2 == this.f38049e) {
            return;
        }
        this.f38049e = f2;
        postInvalidate();
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || str == null || str.equals(this.f38054j)) {
            return;
        }
        this.f38054j = str;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 == this.f38050f) {
            return;
        }
        this.f38050f = i2;
        e();
        postInvalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerDownloadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38049e = 0.0f;
        this.f38050f = -1;
        this.f38051g = 10.0f;
        this.f38055k = 1.0f;
        this.l = 0;
        this.m = 0;
        this.n = new Paint();
        this.o = new Paint();
        this.p = new Paint();
        this.q = new RectF();
        this.r = new RectF();
        d(context, attributeSet);
    }
}
