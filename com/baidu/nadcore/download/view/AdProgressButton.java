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
import c.a.d0.f0.b;
import c.a.d0.f0.d;
import c.a.d0.h0.f;
import c.a.d0.j.d.a;
import c.a.d0.j.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class AdProgressButton extends View implements i<AdProgressButton> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f37238e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f37239f;

    /* renamed from: g  reason: collision with root package name */
    public float f37240g;

    /* renamed from: h  reason: collision with root package name */
    public String f37241h;

    /* renamed from: i  reason: collision with root package name */
    public Typeface f37242i;
    public int mForegroundColor;
    public Paint mForegroundPaint;
    public int mMax;
    public int mProgress;
    public int mRadius;
    public int strokeWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdProgressButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProgress = 0;
        this.f37238e = -1;
        this.f37240g = 10.0f;
        this.mMax = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.d0.f0.i.nad_progress);
            int color = getResources().getColor(b.nad_progress_download_button_text_color);
            int color2 = getResources().getColor(b.nad_progress_download_button_fg);
            int a = f.c.a(getContext(), 11.0f);
            int a2 = f.c.a(getContext(), 12.0f);
            this.strokeWidth = 1;
            this.mForegroundColor = obtainStyledAttributes.getInteger(c.a.d0.f0.i.nad_progress_nad_btn_foreground, color2);
            this.f37238e = obtainStyledAttributes.getColor(c.a.d0.f0.i.nad_progress_nad_btn_textColor, color);
            this.mMax = obtainStyledAttributes.getInteger(c.a.d0.f0.i.nad_progress_nad_btn_max, this.mMax);
            this.mProgress = obtainStyledAttributes.getInteger(c.a.d0.f0.i.nad_progress_nad_btn_progress, 0);
            this.f37241h = obtainStyledAttributes.getString(c.a.d0.f0.i.nad_progress_nad_btn_text);
            this.f37240g = obtainStyledAttributes.getDimension(c.a.d0.f0.i.nad_progress_nad_btn_textSize, a);
            this.mRadius = obtainStyledAttributes.getDimensionPixelSize(c.a.d0.f0.i.nad_progress_nad_btn_radius, a2);
            obtainStyledAttributes.recycle();
            this.f37242i = Typeface.defaultFromStyle(1);
            setBackgroundDrawable(getResources().getDrawable(d.nad_feed_download_btn_bg));
            initPaint();
        }
    }

    @Override // c.a.d0.j.f.i
    public void bind(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) && (viewGroup instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13, -1);
            viewGroup.addView(this, layoutParams);
            viewGroup.setVisibility(0);
        }
    }

    public void drawProgressView(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || this.mProgress <= 0) {
            return;
        }
        int i2 = this.strokeWidth;
        int measuredWidth = getMeasuredWidth() - this.strokeWidth;
        float f2 = this.mProgress / (this.mMax + 0.0f);
        float f3 = i2;
        float f4 = measuredWidth;
        RectF rectF = new RectF(f3, i2, f4, getMeasuredHeight() - this.strokeWidth);
        this.mForegroundPaint.setShader(new LinearGradient(f3, 0.0f, f4, 0.0f, new int[]{this.mForegroundColor, 0}, new float[]{f2, f2 + 0.001f}, Shader.TileMode.CLAMP));
        int i3 = this.mRadius;
        canvas.drawRoundRect(rectF, i3, i3, this.mForegroundPaint);
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mProgress : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d0.j.f.i
    @NonNull
    public AdProgressButton getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (AdProgressButton) invokeV.objValue;
    }

    public void initPaint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mForegroundPaint = new Paint();
            Paint paint = new Paint();
            this.f37239f = paint;
            paint.setAntiAlias(true);
            this.f37239f.setTextSize(this.f37240g);
            this.f37239f.setColor(this.f37238e);
            this.f37239f.setTypeface(this.f37242i);
            this.mForegroundPaint.setAntiAlias(true);
            this.mForegroundPaint.setStyle(Paint.Style.FILL);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            drawProgressView(canvas);
            if (TextUtils.isEmpty(this.f37241h)) {
                return;
            }
            Paint.FontMetrics fontMetrics = this.f37239f.getFontMetrics();
            float f2 = fontMetrics.descent;
            canvas.drawText(this.f37241h, (getMeasuredWidth() - this.f37239f.measureText(this.f37241h)) / 2.0f, ((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f), this.f37239f);
        }
    }

    public void setForeground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mForegroundColor = i2;
            initPaint();
            postInvalidate();
        }
    }

    public void setMax(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mMax = i2;
        }
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 > this.mMax) {
            return;
        }
        this.mProgress = i2;
        this.f37241h = this.mProgress + "%";
        postInvalidate();
    }

    public void setProgressNoText(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || i2 > this.mMax) {
            return;
        }
        this.mProgress = i2;
        this.f37241h = "";
        postInvalidate();
    }

    public void setRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mRadius = i2;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f37241h = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f37238e = i2;
            initPaint();
            postInvalidate();
        }
    }

    public void setTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f37240g = i2;
            initPaint();
            postInvalidate();
        }
    }

    @Override // c.a.d0.j.f.i
    public void update(String str, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, aVar) == null) {
            if (aVar.f2798c == AdDownloadStatus.DOWNLOADING) {
                setProgress((int) (aVar.f2804i * 100.0f));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mProgress = 0;
        this.f37238e = -1;
        this.f37240g = 10.0f;
        this.mMax = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdProgressButton(Context context, AttributeSet attributeSet, int i2) {
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
        this.mProgress = 0;
        this.f37238e = -1;
        this.f37240g = 10.0f;
        this.mMax = 100;
        this.mRadius = 0;
        this.strokeWidth = 0;
        a(context, attributeSet);
    }
}
