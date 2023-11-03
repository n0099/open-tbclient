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
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tieba.R;
import com.baidu.tieba.h11;
import com.baidu.tieba.oh0;
import com.baidu.tieba.t11;
import com.baidu.tieba.vg0;
/* loaded from: classes3.dex */
public class AdProgressButton extends View implements oh0<AdProgressButton> {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oh0
    @NonNull
    public AdProgressButton getRealView() {
        return this;
    }

    public AdProgressButton(Context context) {
        super(context);
        this.a = 0;
        this.b = -1;
        this.e = 10.0f;
        this.h = 100;
        this.i = 0;
        this.j = 0;
        e(context, null);
    }

    @Override // com.baidu.tieba.oh0
    public void c(@NonNull ViewGroup viewGroup) {
        if (!(viewGroup instanceof RelativeLayout)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        viewGroup.addView(this, layoutParams);
        viewGroup.setVisibility(0);
    }

    public void setForeground(int i) {
        this.f = i;
        f();
        postInvalidate();
    }

    public void setMax(int i) {
        this.h = i;
    }

    public void setProgress(int i) {
        if (i > this.h) {
            return;
        }
        this.a = i;
        this.g = this.a + "%";
        postInvalidate();
    }

    public void setProgressNoText(int i) {
        if (i > this.h) {
            return;
        }
        this.a = i;
        this.g = "";
        postInvalidate();
    }

    public void setRadius(int i) {
        this.i = i;
    }

    public void setText(String str) {
        this.g = str;
        postInvalidate();
    }

    public void setTextColor(int i) {
        this.b = i;
        f();
        postInvalidate();
    }

    public void setTextSize(int i) {
        this.e = i;
        f();
        postInvalidate();
    }

    public AdProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = -1;
        this.e = 10.0f;
        this.h = 100;
        this.i = 0;
        this.j = 0;
        e(context, attributeSet);
    }

    @Override // com.baidu.tieba.oh0
    public void b(String str, @NonNull vg0 vg0Var) {
        if (vg0Var.c == AdDownloadStatus.DOWNLOADING) {
            setProgress((int) (vg0Var.i * 100.0f));
            return;
        }
        setProgressNoText(0);
        setText(str);
    }

    public AdProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = -1;
        this.e = 10.0f;
        this.h = 100;
        this.i = 0;
        this.j = 0;
        e(context, attributeSet);
    }

    public void d(Canvas canvas) {
        if (this.a > 0) {
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
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h11.nad_progress);
        int color = getResources().getColor(R.color.nad_progress_download_button_text_color);
        int color2 = getResources().getColor(R.color.nad_progress_download_button_fg);
        int a = t11.c.a(getContext(), 11.0f);
        int a2 = t11.c.a(getContext(), 12.0f);
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
        setBackgroundDrawable(getResources().getDrawable(R.drawable.nad_feed_download_btn_bg));
        f();
    }

    public void f() {
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

    public int getProgress() {
        return this.a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
        if (TextUtils.isEmpty(this.g)) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.d.getFontMetrics();
        float f = fontMetrics.descent;
        canvas.drawText(this.g, (getMeasuredWidth() - this.d.measureText(this.g)) / 2.0f, ((getHeight() / 2) - f) + ((f - fontMetrics.ascent) / 2.0f), this.d);
    }
}
