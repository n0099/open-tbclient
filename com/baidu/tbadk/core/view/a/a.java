package com.baidu.tbadk.core.view.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class a extends ReplacementSpan {
    private int efu;
    private int ena;
    private int enb;
    private int enc = 0;
    private int mRadius;
    private int mSize;
    private int mTextColorId;
    private int mTextSize;
    private int mTopPadding;

    public a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.ena = i;
        this.mRadius = i2;
        this.mTextSize = i3;
        this.mTextColorId = i4;
        this.efu = i5;
        this.mTopPadding = i6;
        this.enb = i7;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.mTextSize);
        this.mSize = (int) (paint.measureText(charSequence, i, i2) + (this.mRadius * 2) + (this.efu * 2) + this.enc);
        paint.setTextSize(textSize);
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float textSize = paint.getTextSize();
        int color = paint.getColor();
        float f2 = this.enb + f;
        paint.setTextSize(this.mTextSize);
        paint.setColor(ao.getColor(this.ena));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(f2, ((((i3 + i5) - this.mTextSize) - this.mRadius) - this.mTopPadding) / 2, (this.mSize + f2) - this.enc, ((((i3 + i5) + this.mTextSize) + this.mRadius) + this.mTopPadding) / 2);
        canvas.drawRoundRect(rectF, this.mRadius, this.mRadius, paint);
        paint.setColor(ao.getColor(this.mTextColorId));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.drawText(charSequence, i, i2, f2 + this.mRadius + this.efu, (int) ((rectF.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), paint);
        paint.setTextSize(textSize);
        paint.setColor(color);
    }
}
