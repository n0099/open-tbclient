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
    private int aOi;
    private int bYo;
    private int bYp;
    private int bYq;
    private int bYs;
    private int bYt;
    private int bYu;
    private int mTextSize;
    private RectF bYr = new RectF();
    private Paint bYv = new Paint();

    public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.bYo = i;
        this.bYp = i2;
        this.bYq = i3;
        this.mTextSize = i4;
        this.aOi = i5;
        this.bYs = i6;
        this.bYu = i7;
        this.bYv.setAntiAlias(true);
        this.bYv.setStyle(Paint.Style.STROKE);
        this.bYv.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.bYt = ((int) this.bYv.measureText(charSequence, i, i2)) + (this.bYs * 2);
        return this.bYt;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.bYv.setColor(am.getColor(this.bYq));
        int i6 = ((i5 - this.bYu) / 2) + i3;
        this.bYr.left = f;
        this.bYr.top = i6;
        this.bYr.right = this.bYt + f;
        this.bYr.bottom = i6 + this.bYu;
        canvas.drawRoundRect(this.bYr, this.bYp, this.bYp, this.bYv);
        Paint.FontMetricsInt fontMetricsInt = this.bYv.getFontMetricsInt();
        this.bYv.setColor(am.getColor(this.aOi));
        canvas.drawText(charSequence, i, i2, f + this.bYs, (int) ((this.bYr.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.bYv);
    }

    public void eo(boolean z) {
        if (this.bYv != null) {
            if (z) {
                this.bYv.setStyle(Paint.Style.FILL);
            } else {
                this.bYv.setStyle(Paint.Style.STROKE);
            }
        }
    }
}
