package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class e extends ReplacementSpan {
    private int aBA;
    private int aBu;
    private int aBv;
    private int aBw;
    private int aBy;
    private int aBz;
    private int mTextColorId;
    private int mTextSize;
    private RectF aBx = new RectF();
    private Paint aBB = new Paint();

    public e(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.aBu = i;
        this.aBv = i2;
        this.aBw = i3;
        this.mTextSize = i4;
        this.mTextColorId = i5;
        this.aBy = i6;
        this.aBA = i7;
        this.aBB.setAntiAlias(true);
        this.aBB.setStyle(Paint.Style.STROKE);
        this.aBB.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.aBz = ((int) this.aBB.measureText(charSequence, i, i2)) + (this.aBy * 2);
        return this.aBz;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.aBB.setColor(al.getColor(this.aBw));
        int i6 = ((i5 - this.aBA) / 2) + i3;
        this.aBx.left = f;
        this.aBx.top = i6;
        this.aBx.right = this.aBz + f;
        this.aBx.bottom = i6 + this.aBA;
        canvas.drawRoundRect(this.aBx, this.aBv, this.aBv, this.aBB);
        Paint.FontMetricsInt fontMetricsInt = this.aBB.getFontMetricsInt();
        this.aBB.setColor(al.getColor(this.mTextColorId));
        canvas.drawText(charSequence, i, i2, f + this.aBy, (int) ((this.aBx.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.aBB);
    }
}
