package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class b extends ReplacementSpan {
    private int atA;
    private int atB;
    private int atC;
    private int atv;
    private int atw;
    private int atx;
    private int atz;
    private int mTextSize;
    private RectF aty = new RectF();
    private Paint atD = new Paint();

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.atv = i;
        this.atw = i2;
        this.atx = i3;
        this.mTextSize = i4;
        this.atz = i5;
        this.atA = i6;
        this.atC = i7;
        this.atD.setAntiAlias(true);
        this.atD.setStyle(Paint.Style.STROKE);
        this.atD.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.atB = ((int) this.atD.measureText(charSequence, i, i2)) + (this.atA * 2);
        return this.atB;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.atD.setColor(am.getColor(this.atx));
        int i6 = ((i5 - this.atC) / 2) + i3;
        this.aty.left = f;
        this.aty.top = i6;
        this.aty.right = this.atB + f;
        this.aty.bottom = i6 + this.atC;
        canvas.drawRoundRect(this.aty, this.atw, this.atw, this.atD);
        Paint.FontMetricsInt fontMetricsInt = this.atD.getFontMetricsInt();
        this.atD.setColor(am.getColor(this.atz));
        canvas.drawText(charSequence, i, i2, f + this.atA, (int) ((this.aty.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.atD);
    }
}
