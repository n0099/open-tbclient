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
    private int aLd;
    private int bOA;
    private int bOu;
    private int bOv;
    private int bOw;
    private int bOy;
    private int bOz;
    private int mTextSize;
    private RectF bOx = new RectF();
    private Paint bOB = new Paint();

    public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.bOu = i;
        this.bOv = i2;
        this.bOw = i3;
        this.mTextSize = i4;
        this.aLd = i5;
        this.bOy = i6;
        this.bOA = i7;
        this.bOB.setAntiAlias(true);
        this.bOB.setStyle(Paint.Style.STROKE);
        this.bOB.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.bOz = ((int) this.bOB.measureText(charSequence, i, i2)) + (this.bOy * 2);
        return this.bOz;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.bOB.setColor(al.getColor(this.bOw));
        int i6 = ((i5 - this.bOA) / 2) + i3;
        this.bOx.left = f;
        this.bOx.top = i6;
        this.bOx.right = this.bOz + f;
        this.bOx.bottom = i6 + this.bOA;
        canvas.drawRoundRect(this.bOx, this.bOv, this.bOv, this.bOB);
        Paint.FontMetricsInt fontMetricsInt = this.bOB.getFontMetricsInt();
        this.bOB.setColor(al.getColor(this.aLd));
        canvas.drawText(charSequence, i, i2, f + this.bOy, (int) ((this.bOx.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.bOB);
    }

    public void dL(boolean z) {
        if (this.bOB != null) {
            if (z) {
                this.bOB.setStyle(Paint.Style.FILL);
            } else {
                this.bOB.setStyle(Paint.Style.STROKE);
            }
        }
    }
}
