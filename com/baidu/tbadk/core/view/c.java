package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class c extends ReplacementSpan {
    private int aLi;
    private int bOA;
    private int bOC;
    private int bOD;
    private int bOE;
    private int bOy;
    private int bOz;
    private int mTextSize;
    private RectF bOB = new RectF();
    private Paint bOF = new Paint();

    public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.bOy = i;
        this.bOz = i2;
        this.bOA = i3;
        this.mTextSize = i4;
        this.aLi = i5;
        this.bOC = i6;
        this.bOE = i7;
        this.bOF.setAntiAlias(true);
        this.bOF.setStyle(Paint.Style.STROKE);
        this.bOF.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.bOD = ((int) this.bOF.measureText(charSequence, i, i2)) + (this.bOC * 2);
        return this.bOD;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.bOF.setColor(al.getColor(this.bOA));
        int i6 = ((i5 - this.bOE) / 2) + i3;
        this.bOB.left = f;
        this.bOB.top = i6;
        this.bOB.right = this.bOD + f;
        this.bOB.bottom = i6 + this.bOE;
        canvas.drawRoundRect(this.bOB, this.bOz, this.bOz, this.bOF);
        Paint.FontMetricsInt fontMetricsInt = this.bOF.getFontMetricsInt();
        this.bOF.setColor(al.getColor(this.aLi));
        canvas.drawText(charSequence, i, i2, f + this.bOC, (int) ((this.bOB.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.bOF);
    }

    public void dL(boolean z) {
        if (this.bOF != null) {
            if (z) {
                this.bOF.setStyle(Paint.Style.FILL);
            } else {
                this.bOF.setStyle(Paint.Style.STROKE);
            }
        }
    }
}
