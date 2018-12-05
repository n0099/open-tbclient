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
    private int aFJ;
    private int aFK;
    private int aFL;
    private int aFN;
    private int aFO;
    private int aFP;
    private int mTextColorId;
    private int mTextSize;
    private RectF aFM = new RectF();
    private Paint aFQ = new Paint();

    public e(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.aFJ = i;
        this.aFK = i2;
        this.aFL = i3;
        this.mTextSize = i4;
        this.mTextColorId = i5;
        this.aFN = i6;
        this.aFP = i7;
        this.aFQ.setAntiAlias(true);
        this.aFQ.setStyle(Paint.Style.STROKE);
        this.aFQ.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.aFO = ((int) this.aFQ.measureText(charSequence, i, i2)) + (this.aFN * 2);
        return this.aFO;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.aFQ.setColor(al.getColor(this.aFL));
        int i6 = ((i5 - this.aFP) / 2) + i3;
        this.aFM.left = f;
        this.aFM.top = i6;
        this.aFM.right = this.aFO + f;
        this.aFM.bottom = i6 + this.aFP;
        canvas.drawRoundRect(this.aFM, this.aFK, this.aFK, this.aFQ);
        Paint.FontMetricsInt fontMetricsInt = this.aFQ.getFontMetricsInt();
        this.aFQ.setColor(al.getColor(this.mTextColorId));
        canvas.drawText(charSequence, i, i2, f + this.aFN, (int) ((this.aFM.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.aFQ);
    }
}
