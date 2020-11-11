package com.baidu.live.yuyinim.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class a extends ReplacementSpan {
    private Resources bnd;
    private float bne;
    private float bnf;
    private float bng;
    private Paint bnh;
    private float bni;
    private String mText;
    private Paint mTextPaint;
    private int mTextSize;

    public a(Context context, String str) {
        init(context, str);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) this.bnf;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = (((fontMetrics.descent - fontMetrics.ascent) - this.bng) * 0.5f) + i4 + fontMetrics.ascent;
        int dimensionPixelOffset = this.bnd.getDimensionPixelOffset(a.d.sdk_ds14);
        this.bnh.setShader(new LinearGradient(f, 0.0f, f + this.bnf, 0.0f, Color.parseColor("#FFF53DC7"), Color.parseColor("#FFAF40FF"), Shader.TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(f, f2, this.bnf + f, this.bng + f2), this.bni, this.bni, this.bnh);
        Paint.FontMetrics fontMetrics2 = this.mTextPaint.getFontMetrics();
        float f3 = fontMetrics2.bottom - fontMetrics2.top;
        canvas.drawText("*", dimensionPixelOffset + f, ((((this.bng - f3) * 0.5f) + f2) - fontMetrics2.top) + 4, this.mTextPaint);
        canvas.drawText(this.mText, this.bne + f + dimensionPixelOffset, (((this.bng - f3) * 0.5f) + f2) - fontMetrics2.top, this.mTextPaint);
    }

    private void init(Context context, String str) {
        this.bnd = context.getResources();
        this.mTextSize = this.bnd.getDimensionPixelSize(a.d.sdk_fontsize18);
        this.mText = str;
        sw();
        Np();
        this.bni = this.bng / 2.0f;
    }

    private void Np() {
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        this.bne = this.mTextPaint.measureText("*") + 4.0f;
        this.bnf = rect.width() + this.bne + (this.bnd.getDimensionPixelOffset(a.d.sdk_ds14) * 2);
        this.bng = rect.height() + (this.bnd.getDimensionPixelOffset(a.d.sdk_ds6) * 2);
    }

    private void sw() {
        Nq();
        Nr();
    }

    private void Nq() {
        this.bnh = new Paint();
        this.bnh.setAntiAlias(true);
        this.bnh.setStyle(Paint.Style.FILL);
    }

    private void Nr() {
        this.mTextPaint = new TextPaint();
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(Color.parseColor("#FFFFFFFF"));
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    }
}
