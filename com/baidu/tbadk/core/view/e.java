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
    private int awJ;
    private int awK;
    private int awL;
    private int awN;
    private int awO;
    private int awP;
    private int awQ;
    private int mTextSize;
    private RectF awM = new RectF();
    private Paint awR = new Paint();

    public e(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.awJ = i;
        this.awK = i2;
        this.awL = i3;
        this.mTextSize = i4;
        this.awN = i5;
        this.awO = i6;
        this.awQ = i7;
        this.awR.setAntiAlias(true);
        this.awR.setStyle(Paint.Style.STROKE);
        this.awR.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.awP = ((int) this.awR.measureText(charSequence, i, i2)) + (this.awO * 2);
        return this.awP;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.awR.setColor(al.getColor(this.awL));
        int i6 = ((i5 - this.awQ) / 2) + i3;
        this.awM.left = f;
        this.awM.top = i6;
        this.awM.right = this.awP + f;
        this.awM.bottom = i6 + this.awQ;
        canvas.drawRoundRect(this.awM, this.awK, this.awK, this.awR);
        Paint.FontMetricsInt fontMetricsInt = this.awR.getFontMetricsInt();
        this.awR.setColor(al.getColor(this.awN));
        canvas.drawText(charSequence, i, i2, f + this.awO, (int) ((this.awM.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.awR);
    }
}
