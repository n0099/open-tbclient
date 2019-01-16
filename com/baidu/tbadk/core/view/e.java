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
    private int aGm;
    private int aGn;
    private int aGo;
    private int aGq;
    private int aGr;
    private int aGs;
    private int mTextColorId;
    private int mTextSize;
    private RectF aGp = new RectF();
    private Paint aGt = new Paint();

    public e(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.aGm = i;
        this.aGn = i2;
        this.aGo = i3;
        this.mTextSize = i4;
        this.mTextColorId = i5;
        this.aGq = i6;
        this.aGs = i7;
        this.aGt.setAntiAlias(true);
        this.aGt.setStyle(Paint.Style.STROKE);
        this.aGt.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.aGr = ((int) this.aGt.measureText(charSequence, i, i2)) + (this.aGq * 2);
        return this.aGr;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.aGt.setColor(al.getColor(this.aGo));
        int i6 = ((i5 - this.aGs) / 2) + i3;
        this.aGp.left = f;
        this.aGp.top = i6;
        this.aGp.right = this.aGr + f;
        this.aGp.bottom = i6 + this.aGs;
        canvas.drawRoundRect(this.aGp, this.aGn, this.aGn, this.aGt);
        Paint.FontMetricsInt fontMetricsInt = this.aGt.getFontMetricsInt();
        this.aGt.setColor(al.getColor(this.mTextColorId));
        canvas.drawText(charSequence, i, i2, f + this.aGq, (int) ((this.aGp.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.aGt);
    }
}
