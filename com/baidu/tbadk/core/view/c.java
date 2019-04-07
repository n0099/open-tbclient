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
    private int aLh;
    private int bOB;
    private int bOC;
    private int bOD;
    private int bOx;
    private int bOy;
    private int bOz;
    private int mTextSize;
    private RectF bOA = new RectF();
    private Paint bOE = new Paint();

    public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.bOx = i;
        this.bOy = i2;
        this.bOz = i3;
        this.mTextSize = i4;
        this.aLh = i5;
        this.bOB = i6;
        this.bOD = i7;
        this.bOE.setAntiAlias(true);
        this.bOE.setStyle(Paint.Style.STROKE);
        this.bOE.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.bOC = ((int) this.bOE.measureText(charSequence, i, i2)) + (this.bOB * 2);
        return this.bOC;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.bOE.setColor(al.getColor(this.bOz));
        int i6 = ((i5 - this.bOD) / 2) + i3;
        this.bOA.left = f;
        this.bOA.top = i6;
        this.bOA.right = this.bOC + f;
        this.bOA.bottom = i6 + this.bOD;
        canvas.drawRoundRect(this.bOA, this.bOy, this.bOy, this.bOE);
        Paint.FontMetricsInt fontMetricsInt = this.bOE.getFontMetricsInt();
        this.bOE.setColor(al.getColor(this.aLh));
        canvas.drawText(charSequence, i, i2, f + this.bOB, (int) ((this.bOA.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.bOE);
    }

    public void dL(boolean z) {
        if (this.bOE != null) {
            if (z) {
                this.bOE.setStyle(Paint.Style.FILL);
            } else {
                this.bOE.setStyle(Paint.Style.STROKE);
            }
        }
    }
}
