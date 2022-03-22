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
import c.a.a0.h0.f;
import c.a.a0.j.d.a;
import c.a.a0.j.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AdProgressButton extends View implements i<AdProgressButton> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f27522b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f27523c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f27524d;

    /* renamed from: e  reason: collision with root package name */
    public float f27525e;

    /* renamed from: f  reason: collision with root package name */
    public int f27526f;

    /* renamed from: g  reason: collision with root package name */
    public String f27527g;

    /* renamed from: h  reason: collision with root package name */
    public int f27528h;
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
        this.f27522b = -1;
        this.f27525e = 10.0f;
        this.f27528h = 100;
        this.i = 0;
        this.j = 0;
        b(context, null);
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.a <= 0) {
            return;
        }
        int i = this.j;
        int measuredWidth = getMeasuredWidth() - this.j;
        float f2 = this.a / (this.f27528h + 0.0f);
        float f3 = i;
        float f4 = measuredWidth;
        RectF rectF = new RectF(f3, i, f4, getMeasuredHeight() - this.j);
        this.f27523c.setShader(new LinearGradient(f3, 0.0f, f4, 0.0f, new int[]{this.f27526f, 0}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP));
        int i2 = this.i;
        canvas.drawRoundRect(rectF, i2, i2, this.f27523c);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040436, R.attr.obfuscated_res_0x7f040437, R.attr.obfuscated_res_0x7f040438, R.attr.obfuscated_res_0x7f040439, R.attr.obfuscated_res_0x7f04043a, R.attr.obfuscated_res_0x7f04043b, R.attr.obfuscated_res_0x7f04043c, R.attr.obfuscated_res_0x7f04043d, R.attr.obfuscated_res_0x7f04043e, R.attr.obfuscated_res_0x7f04043f, R.attr.obfuscated_res_0x7f040440, R.attr.obfuscated_res_0x7f040441, R.attr.obfuscated_res_0x7f040442});
            int color = getResources().getColor(R.color.obfuscated_res_0x7f060829);
            int color2 = getResources().getColor(R.color.obfuscated_res_0x7f060828);
            int a = f.c.a(getContext(), 11.0f);
            int a2 = f.c.a(getContext(), 12.0f);
            this.j = 1;
            this.f27526f = obtainStyledAttributes.getInteger(0, color2);
            this.f27522b = obtainStyledAttributes.getColor(8, color);
            this.f27528h = obtainStyledAttributes.getInteger(2, this.f27528h);
            this.a = obtainStyledAttributes.getInteger(4, 0);
            this.f27527g = obtainStyledAttributes.getString(6);
            this.f27525e = obtainStyledAttributes.getDimension(9, a);
            this.i = obtainStyledAttributes.getDimensionPixelSize(5, a2);
            obtainStyledAttributes.recycle();
            this.k = Typeface.defaultFromStyle(1);
            setBackgroundDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080da9));
            d();
        }
    }

    @Override // c.a.a0.j.f.i
    public void c(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) && (viewGroup instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13, -1);
            viewGroup.addView(this, layoutParams);
            viewGroup.setVisibility(0);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f27523c = new Paint();
            Paint paint = new Paint();
            this.f27524d = paint;
            paint.setAntiAlias(true);
            this.f27524d.setTextSize(this.f27525e);
            this.f27524d.setColor(this.f27522b);
            this.f27524d.setTypeface(this.k);
            this.f27523c.setAntiAlias(true);
            this.f27523c.setStyle(Paint.Style.FILL);
        }
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.a0.j.f.i
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
            a(canvas);
            if (TextUtils.isEmpty(this.f27527g)) {
                return;
            }
            Paint.FontMetrics fontMetrics = this.f27524d.getFontMetrics();
            float f2 = fontMetrics.descent;
            canvas.drawText(this.f27527g, (getMeasuredWidth() - this.f27524d.measureText(this.f27527g)) / 2.0f, ((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f), this.f27524d);
        }
    }

    public void setForeground(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f27526f = i;
            d();
            postInvalidate();
        }
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f27528h = i;
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i > this.f27528h) {
            return;
        }
        this.a = i;
        this.f27527g = this.a + "%";
        postInvalidate();
    }

    public void setProgressNoText(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || i > this.f27528h) {
            return;
        }
        this.a = i;
        this.f27527g = "";
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
            this.f27527g = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f27522b = i;
            d();
            postInvalidate();
        }
    }

    public void setTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.f27525e = i;
            d();
            postInvalidate();
        }
    }

    @Override // c.a.a0.j.f.i
    public void update(String str, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, aVar) == null) {
            if (aVar.f1246c == AdDownloadStatus.DOWNLOADING) {
                setProgress((int) (aVar.i * 100.0f));
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
        this.f27522b = -1;
        this.f27525e = 10.0f;
        this.f27528h = 100;
        this.i = 0;
        this.j = 0;
        b(context, attributeSet);
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
        this.f27522b = -1;
        this.f27525e = 10.0f;
        this.f27528h = 100;
        this.i = 0;
        this.j = 0;
        b(context, attributeSet);
    }
}
