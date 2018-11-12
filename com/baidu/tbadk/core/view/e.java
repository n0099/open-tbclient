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
    private int aCj;
    private int aCk;
    private int aCl;
    private int aCn;
    private int aCo;
    private int aCp;
    private int mTextColorId;
    private int mTextSize;
    private RectF aCm = new RectF();
    private Paint aCq = new Paint();

    public e(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.aCj = i;
        this.aCk = i2;
        this.aCl = i3;
        this.mTextSize = i4;
        this.mTextColorId = i5;
        this.aCn = i6;
        this.aCp = i7;
        this.aCq.setAntiAlias(true);
        this.aCq.setStyle(Paint.Style.STROKE);
        this.aCq.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.aCo = ((int) this.aCq.measureText(charSequence, i, i2)) + (this.aCn * 2);
        return this.aCo;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.aCq.setColor(al.getColor(this.aCl));
        int i6 = ((i5 - this.aCp) / 2) + i3;
        this.aCm.left = f;
        this.aCm.top = i6;
        this.aCm.right = this.aCo + f;
        this.aCm.bottom = i6 + this.aCp;
        canvas.drawRoundRect(this.aCm, this.aCk, this.aCk, this.aCq);
        Paint.FontMetricsInt fontMetricsInt = this.aCq.getFontMetricsInt();
        this.aCq.setColor(al.getColor(this.mTextColorId));
        canvas.drawText(charSequence, i, i2, f + this.aCn, (int) ((this.aCm.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.aCq);
    }
}
