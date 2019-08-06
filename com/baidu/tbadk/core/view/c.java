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
    private int aNK;
    private int bXA;
    private int bXB;
    private int bXv;
    private int bXw;
    private int bXx;
    private int bXz;
    private int mTextSize;
    private RectF bXy = new RectF();
    private Paint bXC = new Paint();

    public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.bXv = i;
        this.bXw = i2;
        this.bXx = i3;
        this.mTextSize = i4;
        this.aNK = i5;
        this.bXz = i6;
        this.bXB = i7;
        this.bXC.setAntiAlias(true);
        this.bXC.setStyle(Paint.Style.STROKE);
        this.bXC.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.bXA = ((int) this.bXC.measureText(charSequence, i, i2)) + (this.bXz * 2);
        return this.bXA;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.bXC.setColor(am.getColor(this.bXx));
        int i6 = ((i5 - this.bXB) / 2) + i3;
        this.bXy.left = f;
        this.bXy.top = i6;
        this.bXy.right = this.bXA + f;
        this.bXy.bottom = i6 + this.bXB;
        canvas.drawRoundRect(this.bXy, this.bXw, this.bXw, this.bXC);
        Paint.FontMetricsInt fontMetricsInt = this.bXC.getFontMetricsInt();
        this.bXC.setColor(am.getColor(this.aNK));
        canvas.drawText(charSequence, i, i2, f + this.bXz, (int) ((this.bXy.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.bXC);
    }

    public void el(boolean z) {
        if (this.bXC != null) {
            if (z) {
                this.bXC.setStyle(Paint.Style.FILL);
            } else {
                this.bXC.setStyle(Paint.Style.STROKE);
            }
        }
    }
}
