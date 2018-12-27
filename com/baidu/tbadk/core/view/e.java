package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class e extends ReplacementSpan {
    private int aFK;
    private int aFL;
    private int aFM;
    private int aFO;
    private int aFP;
    private int aFQ;
    private int mTextColorId;
    private int mTextSize;
    private RectF aFN = new RectF();
    private Paint aFR = new Paint();

    public e(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.aFK = i;
        this.aFL = i2;
        this.aFM = i3;
        this.mTextSize = i4;
        this.mTextColorId = i5;
        this.aFO = i6;
        this.aFQ = i7;
        this.aFR.setAntiAlias(true);
        this.aFR.setStyle(Paint.Style.STROKE);
        this.aFR.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.aFP = ((int) this.aFR.measureText(charSequence, i, i2)) + (this.aFO * 2);
        return this.aFP;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.aFR.setColor(al.getColor(this.aFM));
        int i6 = ((i5 - this.aFQ) / 2) + i3;
        this.aFN.left = f;
        this.aFN.top = i6;
        this.aFN.right = this.aFP + f;
        this.aFN.bottom = i6 + this.aFQ;
        canvas.drawRoundRect(this.aFN, this.aFL, this.aFL, this.aFR);
        Paint.FontMetricsInt fontMetricsInt = this.aFR.getFontMetricsInt();
        this.aFR.setColor(al.getColor(this.mTextColorId));
        canvas.drawText(charSequence, i, i2, f + this.aFO, (int) ((this.aFN.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.aFR);
    }
}
