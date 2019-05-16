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
    private int aNb;
    private int bWm;
    private int bWn;
    private int bWo;
    private int bWq;
    private int bWr;
    private int bWs;
    private int mTextSize;
    private RectF bWp = new RectF();
    private Paint bWt = new Paint();

    public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.bWm = i;
        this.bWn = i2;
        this.bWo = i3;
        this.mTextSize = i4;
        this.aNb = i5;
        this.bWq = i6;
        this.bWs = i7;
        this.bWt.setAntiAlias(true);
        this.bWt.setStyle(Paint.Style.STROKE);
        this.bWt.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.bWr = ((int) this.bWt.measureText(charSequence, i, i2)) + (this.bWq * 2);
        return this.bWr;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.bWt.setColor(al.getColor(this.bWo));
        int i6 = ((i5 - this.bWs) / 2) + i3;
        this.bWp.left = f;
        this.bWp.top = i6;
        this.bWp.right = this.bWr + f;
        this.bWp.bottom = i6 + this.bWs;
        canvas.drawRoundRect(this.bWp, this.bWn, this.bWn, this.bWt);
        Paint.FontMetricsInt fontMetricsInt = this.bWt.getFontMetricsInt();
        this.bWt.setColor(al.getColor(this.aNb));
        canvas.drawText(charSequence, i, i2, f + this.bWq, (int) ((this.bWp.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.bWt);
    }

    public void eh(boolean z) {
        if (this.bWt != null) {
            if (z) {
                this.bWt.setStyle(Paint.Style.FILL);
            } else {
                this.bWt.setStyle(Paint.Style.STROKE);
            }
        }
    }
}
