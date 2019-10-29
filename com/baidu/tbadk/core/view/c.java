package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class c extends ReplacementSpan {
    private int bhp;
    private int cnm;
    private int cnn;
    private int cno;
    private int cnq;
    private int cnr;
    private int cns;
    private int mTextSize;
    private RectF cnp = new RectF();
    private Paint ajo = new Paint();

    public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.cnm = i;
        this.cnn = i2;
        this.cno = i3;
        this.mTextSize = i4;
        this.bhp = i5;
        this.cnq = i6;
        this.cns = i7;
        this.ajo.setAntiAlias(true);
        this.ajo.setStyle(Paint.Style.STROKE);
        this.ajo.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.cnr = ((int) this.ajo.measureText(charSequence, i, i2)) + (this.cnq * 2);
        return this.cnr;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.ajo.setColor(am.getColor(this.cno));
        int i6 = ((i5 - this.cns) / 2) + i3;
        this.cnp.left = f;
        this.cnp.top = i6;
        this.cnp.right = this.cnr + f;
        this.cnp.bottom = i6 + this.cns;
        canvas.drawRoundRect(this.cnp, this.cnn, this.cnn, this.ajo);
        Paint.FontMetricsInt fontMetricsInt = this.ajo.getFontMetricsInt();
        this.ajo.setColor(am.getColor(this.bhp));
        canvas.drawText(charSequence, i, i2, f + this.cnq, (int) ((this.cnp.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.ajo);
    }

    public void er(boolean z) {
        if (this.ajo != null) {
            if (z) {
                this.ajo.setStyle(Paint.Style.FILL);
            } else {
                this.ajo.setStyle(Paint.Style.STROKE);
            }
        }
    }
}
