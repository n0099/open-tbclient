package com.baidu.tbadk.core.view.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class a extends ReplacementSpan {
    private int diC;
    private int eTS;
    private int eTT;
    private int eTU = 0;
    private int mRadius;
    private int mSize;
    private int mTextColorId;
    private int mTextSize;
    private int mTopPadding;

    public a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.eTS = i;
        this.mRadius = i2;
        this.mTextSize = i3;
        this.mTextColorId = i4;
        this.diC = i5;
        this.mTopPadding = i6;
        this.eTT = i7;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        float textSize = paint.getTextSize();
        paint.setTextSize(this.mTextSize);
        this.mSize = (int) (paint.measureText(charSequence, i, i2) + (this.mRadius * 2) + (this.diC * 2) + this.eTU);
        paint.setTextSize(textSize);
        return this.mSize;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float textSize = paint.getTextSize();
        int color = paint.getColor();
        float f2 = this.eTT + f;
        paint.setTextSize(this.mTextSize);
        paint.setColor(ap.getColor(this.eTS));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(f2, ((((i3 + i5) - this.mTextSize) - this.mRadius) - this.mTopPadding) / 2, (this.mSize + f2) - this.eTU, ((((i3 + i5) + this.mTextSize) + this.mRadius) + this.mTopPadding) / 2);
        canvas.drawRoundRect(rectF, this.mRadius, this.mRadius, paint);
        paint.setColor(ap.getColor(this.mTextColorId));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.drawText(charSequence, i, i2, f2 + this.mRadius + this.diC, (int) ((rectF.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), paint);
        paint.setTextSize(textSize);
        paint.setColor(color);
    }
}
