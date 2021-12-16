package com.baidu.adp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class TextProgressBar extends ProgressBar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f32269e;

    /* renamed from: f  reason: collision with root package name */
    public TextPaint f32270f;

    /* renamed from: g  reason: collision with root package name */
    public Paint.FontMetrics f32271g;

    /* renamed from: h  reason: collision with root package name */
    public int f32272h;

    /* renamed from: i  reason: collision with root package name */
    public int f32273i;

    /* renamed from: j  reason: collision with root package name */
    public int f32274j;

    /* renamed from: k  reason: collision with root package name */
    public int f32275k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextProgressBar(Context context) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f32269e = "0%";
            TextPaint textPaint = new TextPaint();
            this.f32270f = textPaint;
            textPaint.setTextSize(20.0f);
            this.f32270f.setColor(-1);
            this.f32271g = new Paint.FontMetrics();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            synchronized (this) {
                super.onDraw(canvas);
                canvas.save();
                this.f32273i = (int) Layout.getDesiredWidth(this.f32269e, this.f32270f);
                this.f32270f.getFontMetrics(this.f32271g);
                this.f32272h = (int) (this.f32271g.descent - this.f32271g.top);
                canvas.drawText(this.f32269e, (getMeasuredWidth() - this.f32273i) / 2, getMeasuredHeight(), this.f32270f);
                canvas.restore();
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            synchronized (this) {
                this.f32273i = (int) Layout.getDesiredWidth("100%", this.f32270f);
                this.f32270f.getFontMetrics(this.f32271g);
                this.f32272h = (int) (this.f32271g.descent - this.f32271g.top);
                super.onMeasure(i2, i3);
                this.f32274j = getMeasuredWidth();
                this.f32275k = getMeasuredHeight();
                setMeasuredDimension(Math.max(this.f32273i, getMeasuredWidth()), getMeasuredHeight() + this.f32272h + 0);
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            int paddingRight = (this.f32274j - getPaddingRight()) - getPaddingLeft();
            int width = (getWidth() - paddingRight) / 2;
            int i6 = paddingRight + width;
            int paddingBottom = (this.f32275k - getPaddingBottom()) - getPaddingTop();
            Drawable indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable != null) {
                indeterminateDrawable.setBounds(width, 0, i6, paddingBottom);
            }
            Drawable progressDrawable = getProgressDrawable();
            if (progressDrawable != null) {
                progressDrawable.setBounds(width, 0, i6, paddingBottom);
            }
        }
    }

    public synchronized void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            synchronized (this) {
                this.f32269e = str;
                drawableStateChanged();
            }
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f32270f.setColor(i2);
            drawableStateChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextProgressBar(Context context, AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextProgressBar(Context context, AttributeSet attributeSet, int i2) {
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
        a();
    }
}
