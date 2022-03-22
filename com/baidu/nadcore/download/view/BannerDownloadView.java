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
/* loaded from: classes4.dex */
public class BannerDownloadView extends AppCompatTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public int f27529b;

    /* renamed from: c  reason: collision with root package name */
    public float f27530c;

    /* renamed from: d  reason: collision with root package name */
    public int f27531d;

    /* renamed from: e  reason: collision with root package name */
    public int f27532e;

    /* renamed from: f  reason: collision with root package name */
    public String f27533f;

    /* renamed from: g  reason: collision with root package name */
    public float f27534g;

    /* renamed from: h  reason: collision with root package name */
    public int f27535h;
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
        this.f27529b = -1;
        this.f27530c = 10.0f;
        this.f27534g = 1.0f;
        this.f27535h = 0;
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
            this.f27535h = getMeasuredHeight() / 2;
            RectF rectF = this.n;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = getMeasuredWidth();
            this.n.bottom = getMeasuredHeight();
            this.k.setStrokeWidth(this.i);
            this.k.setColor(Color.parseColor("#E5E5E5"));
            RectF rectF2 = this.n;
            int i = this.f27535h;
            canvas.drawRoundRect(rectF2, i, i, this.k);
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.f27535h = getMeasuredHeight() / 2;
            RectF rectF = this.m;
            int i = this.i;
            rectF.left = i;
            rectF.top = i;
            rectF.bottom = getMeasuredHeight() - this.i;
            this.m.right = getMeasuredWidth() * this.a;
            RectF rectF2 = this.m;
            float f2 = rectF2.right;
            int i2 = this.f27535h;
            if (f2 < i2 * 2) {
                rectF2.right = i2 * 2;
            }
            this.j.setShader(new LinearGradient(0.0f, 0.0f, this.m.right, 0.0f, new int[]{this.f27531d, this.f27532e}, (float[]) null, Shader.TileMode.CLAMP));
            RectF rectF3 = this.m;
            int i3 = this.f27535h;
            canvas.drawRoundRect(rectF3, i3, i3, this.j);
        }
    }

    public final void f(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            Paint.FontMetrics fontMetrics = this.l.getFontMetrics();
            float f2 = fontMetrics.descent;
            float measuredWidth = (getMeasuredWidth() - this.l.measureText(this.f27533f)) / 2.0f;
            canvas.drawText(this.f27533f, measuredWidth, (float) (((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f) + 0.5d), this.l);
        }
    }

    public final void g(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040436, R.attr.obfuscated_res_0x7f040437, R.attr.obfuscated_res_0x7f040438, R.attr.obfuscated_res_0x7f040439, R.attr.obfuscated_res_0x7f04043a, R.attr.obfuscated_res_0x7f04043b, R.attr.obfuscated_res_0x7f04043c, R.attr.obfuscated_res_0x7f04043d, R.attr.obfuscated_res_0x7f04043e, R.attr.obfuscated_res_0x7f04043f, R.attr.obfuscated_res_0x7f040440, R.attr.obfuscated_res_0x7f040441, R.attr.obfuscated_res_0x7f040442});
            int color = getResources().getColor(R.color.obfuscated_res_0x7f060806);
            int color2 = getResources().getColor(R.color.obfuscated_res_0x7f060805);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070502);
            this.i = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070501);
            this.f27531d = obtainStyledAttributes.getInteger(0, color2);
            this.f27532e = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.obfuscated_res_0x7f060804));
            this.f27529b = obtainStyledAttributes.getColor(8, color);
            this.f27534g = obtainStyledAttributes.getFloat(2, this.f27534g);
            this.a = obtainStyledAttributes.getFloat(4, 0.0f);
            this.f27533f = obtainStyledAttributes.getString(6);
            this.f27530c = obtainStyledAttributes.getDimension(9, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070500));
            this.f27535h = obtainStyledAttributes.getDimensionPixelSize(5, dimensionPixelSize);
            obtainStyledAttributes.recycle();
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l.setAntiAlias(true);
            this.l.setTextSize(this.f27530c);
            this.l.setColor(this.f27529b);
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
            if (TextUtils.isEmpty(this.f27533f)) {
                return;
            }
            f(canvas);
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048582, this, f2) == null) || f2 < 0.0f || f2 > this.f27534g || f2 == this.a) {
            return;
        }
        this.a = f2;
        postInvalidate();
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || str == null || str.equals(this.f27533f)) {
            return;
        }
        this.f27533f = str;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || i == this.f27529b) {
            return;
        }
        this.f27529b = i;
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
        this.f27529b = -1;
        this.f27530c = 10.0f;
        this.f27534g = 1.0f;
        this.f27535h = 0;
        this.i = 0;
        this.j = new Paint();
        this.k = new Paint();
        this.l = new Paint();
        this.m = new RectF();
        this.n = new RectF();
        g(context, attributeSet);
    }
}
