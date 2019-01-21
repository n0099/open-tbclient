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
    private int aGn;
    private int aGo;
    private int aGp;
    private int aGr;
    private int aGs;
    private int aGt;
    private int mTextColorId;
    private int mTextSize;
    private RectF aGq = new RectF();
    private Paint aGu = new Paint();

    public e(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.aGn = i;
        this.aGo = i2;
        this.aGp = i3;
        this.mTextSize = i4;
        this.mTextColorId = i5;
        this.aGr = i6;
        this.aGt = i7;
        this.aGu.setAntiAlias(true);
        this.aGu.setStyle(Paint.Style.STROKE);
        this.aGu.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.aGs = ((int) this.aGu.measureText(charSequence, i, i2)) + (this.aGr * 2);
        return this.aGs;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.aGu.setColor(al.getColor(this.aGp));
        int i6 = ((i5 - this.aGt) / 2) + i3;
        this.aGq.left = f;
        this.aGq.top = i6;
        this.aGq.right = this.aGs + f;
        this.aGq.bottom = i6 + this.aGt;
        canvas.drawRoundRect(this.aGq, this.aGo, this.aGo, this.aGu);
        Paint.FontMetricsInt fontMetricsInt = this.aGu.getFontMetricsInt();
        this.aGu.setColor(al.getColor(this.mTextColorId));
        canvas.drawText(charSequence, i, i2, f + this.aGr, (int) ((this.aGq.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.aGu);
    }
}
