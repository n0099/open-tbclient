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
    private int aLe;
    private int bOA;
    private int bOB;
    private int bOv;
    private int bOw;
    private int bOx;
    private int bOz;
    private int mTextSize;
    private RectF bOy = new RectF();
    private Paint bOC = new Paint();

    public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.bOv = i;
        this.bOw = i2;
        this.bOx = i3;
        this.mTextSize = i4;
        this.aLe = i5;
        this.bOz = i6;
        this.bOB = i7;
        this.bOC.setAntiAlias(true);
        this.bOC.setStyle(Paint.Style.STROKE);
        this.bOC.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.bOA = ((int) this.bOC.measureText(charSequence, i, i2)) + (this.bOz * 2);
        return this.bOA;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.bOC.setColor(al.getColor(this.bOx));
        int i6 = ((i5 - this.bOB) / 2) + i3;
        this.bOy.left = f;
        this.bOy.top = i6;
        this.bOy.right = this.bOA + f;
        this.bOy.bottom = i6 + this.bOB;
        canvas.drawRoundRect(this.bOy, this.bOw, this.bOw, this.bOC);
        Paint.FontMetricsInt fontMetricsInt = this.bOC.getFontMetricsInt();
        this.bOC.setColor(al.getColor(this.aLe));
        canvas.drawText(charSequence, i, i2, f + this.bOz, (int) ((this.bOy.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.bOC);
    }

    public void dL(boolean z) {
        if (this.bOC != null) {
            if (z) {
                this.bOC.setStyle(Paint.Style.FILL);
            } else {
                this.bOC.setStyle(Paint.Style.STROKE);
            }
        }
    }
}
