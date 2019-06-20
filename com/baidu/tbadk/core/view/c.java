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
    private int bWn;
    private int bWo;
    private int bWp;
    private int bWr;
    private int bWs;
    private int bWt;
    private int mTextSize;
    private RectF bWq = new RectF();
    private Paint bWu = new Paint();

    public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.bWn = i;
        this.bWo = i2;
        this.bWp = i3;
        this.mTextSize = i4;
        this.aNb = i5;
        this.bWr = i6;
        this.bWt = i7;
        this.bWu.setAntiAlias(true);
        this.bWu.setStyle(Paint.Style.STROKE);
        this.bWu.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.bWs = ((int) this.bWu.measureText(charSequence, i, i2)) + (this.bWr * 2);
        return this.bWs;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.bWu.setColor(al.getColor(this.bWp));
        int i6 = ((i5 - this.bWt) / 2) + i3;
        this.bWq.left = f;
        this.bWq.top = i6;
        this.bWq.right = this.bWs + f;
        this.bWq.bottom = i6 + this.bWt;
        canvas.drawRoundRect(this.bWq, this.bWo, this.bWo, this.bWu);
        Paint.FontMetricsInt fontMetricsInt = this.bWu.getFontMetricsInt();
        this.bWu.setColor(al.getColor(this.aNb));
        canvas.drawText(charSequence, i, i2, f + this.bWr, (int) ((this.bWq.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.bWu);
    }

    public void eh(boolean z) {
        if (this.bWu != null) {
            if (z) {
                this.bWu.setStyle(Paint.Style.FILL);
            } else {
                this.bWu.setStyle(Paint.Style.STROKE);
            }
        }
    }
}
