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
    private int atu;
    private int atv;
    private int atw;
    private int aty;
    private int atz;
    private int mTextSize;
    private RectF atx = new RectF();
    private Paint atC = new Paint();

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.atu = i;
        this.atv = i2;
        this.atw = i3;
        this.mTextSize = i4;
        this.aty = i5;
        this.atz = i6;
        this.atB = i7;
        this.atC.setAntiAlias(true);
        this.atC.setStyle(Paint.Style.STROKE);
        this.atC.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.atA = ((int) this.atC.measureText(charSequence, i, i2)) + (this.atz * 2);
        return this.atA;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.atC.setColor(am.getColor(this.atw));
        int i6 = ((i5 - this.atB) / 2) + i3;
        this.atx.left = f;
        this.atx.top = i6;
        this.atx.right = this.atA + f;
        this.atx.bottom = i6 + this.atB;
        canvas.drawRoundRect(this.atx, this.atv, this.atv, this.atC);
        Paint.FontMetricsInt fontMetricsInt = this.atC.getFontMetricsInt();
        this.atC.setColor(am.getColor(this.aty));
        canvas.drawText(charSequence, i, i2, f + this.atz, (int) ((this.atx.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.atC);
    }
}
