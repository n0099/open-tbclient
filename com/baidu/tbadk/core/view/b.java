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
    private int atQ;
    private int atR;
    private int atS;
    private int atU;
    private int atV;
    private int atW;
    private int atX;
    private int mTextSize;
    private RectF atT = new RectF();
    private Paint atY = new Paint();

    public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.atQ = i;
        this.atR = i2;
        this.atS = i3;
        this.mTextSize = i4;
        this.atU = i5;
        this.atV = i6;
        this.atX = i7;
        this.atY.setAntiAlias(true);
        this.atY.setStyle(Paint.Style.STROKE);
        this.atY.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.atW = ((int) this.atY.measureText(charSequence, i, i2)) + (this.atV * 2);
        return this.atW;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.atY.setColor(am.getColor(this.atS));
        int i6 = ((i5 - this.atX) / 2) + i3;
        this.atT.left = f;
        this.atT.top = i6;
        this.atT.right = this.atW + f;
        this.atT.bottom = i6 + this.atX;
        canvas.drawRoundRect(this.atT, this.atR, this.atR, this.atY);
        Paint.FontMetricsInt fontMetricsInt = this.atY.getFontMetricsInt();
        this.atY.setColor(am.getColor(this.atU));
        canvas.drawText(charSequence, i, i2, f + this.atV, (int) ((this.atT.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.atY);
    }
}
