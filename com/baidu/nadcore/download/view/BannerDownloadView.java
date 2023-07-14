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
import com.baidu.tieba.R;
import com.baidu.tieba.s61;
/* loaded from: classes3.dex */
public class BannerDownloadView extends AppCompatTextView {
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

    public BannerDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
        i(context, attributeSet);
    }

    public BannerDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        i(context, attributeSet);
    }

    public final void d(Canvas canvas) {
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

    public final void h(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.l.getFontMetrics();
        float f = fontMetrics.descent;
        float measuredWidth = (getMeasuredWidth() - this.l.measureText(this.f)) / 2.0f;
        canvas.drawText(this.f, measuredWidth, (float) (((getHeight() / 2) - f) + ((f - fontMetrics.ascent) / 2.0f) + 0.5d), this.l);
    }

    public final void e(Canvas canvas) {
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

    public final void i(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s61.nad_progress);
        int color = getResources().getColor(R.color.nad_download_button_text_color);
        int color2 = getResources().getColor(R.color.nad_download_button_fg_start);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.nad_progress_button_radian);
        this.i = getResources().getDimensionPixelSize(R.dimen.nad_progress_button_frame);
        this.d = obtainStyledAttributes.getInteger(0, color2);
        this.e = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.nad_download_button_fg_end));
        this.b = obtainStyledAttributes.getColor(8, color);
        this.g = obtainStyledAttributes.getFloat(2, this.g);
        this.a = obtainStyledAttributes.getFloat(4, 0.0f);
        this.f = obtainStyledAttributes.getString(6);
        this.c = obtainStyledAttributes.getDimension(9, (int) getResources().getDimension(R.dimen.nad_progress_button_font_size));
        this.h = obtainStyledAttributes.getDimensionPixelSize(5, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        j();
    }

    public final void j() {
        this.l.setAntiAlias(true);
        this.l.setTextSize(this.c);
        this.l.setColor(this.b);
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.FILL);
        this.k.setAntiAlias(true);
        this.k.setStyle(Paint.Style.STROKE);
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a > 0.0f) {
            e(canvas);
        }
        d(canvas);
        if (!TextUtils.isEmpty(this.f)) {
            h(canvas);
        }
    }

    public void setProgress(float f) {
        if (f < 0.0f || f > this.g || f == this.a) {
            return;
        }
        this.a = f;
        postInvalidate();
    }

    public void setText(String str) {
        if (str == null || str.equals(this.f)) {
            return;
        }
        this.f = str;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        if (i == this.b) {
            return;
        }
        this.b = i;
        j();
        postInvalidate();
    }
}
