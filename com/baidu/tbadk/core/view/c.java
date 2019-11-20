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
    private int bgX;
    private int cmA;
    private int cmB;
    private int cmv;
    private int cmw;
    private int cmx;
    private int cmz;
    private int mTextSize;
    private RectF cmy = new RectF();
    private Paint aiW = new Paint();

    public c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.cmv = i;
        this.cmw = i2;
        this.cmx = i3;
        this.mTextSize = i4;
        this.bgX = i5;
        this.cmz = i6;
        this.cmB = i7;
        this.aiW.setAntiAlias(true);
        this.aiW.setStyle(Paint.Style.STROKE);
        this.aiW.setTextSize(this.mTextSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        this.cmA = ((int) this.aiW.measureText(charSequence, i, i2)) + (this.cmz * 2);
        return this.cmA;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        this.aiW.setColor(am.getColor(this.cmx));
        int i6 = ((i5 - this.cmB) / 2) + i3;
        this.cmy.left = f;
        this.cmy.top = i6;
        this.cmy.right = this.cmA + f;
        this.cmy.bottom = i6 + this.cmB;
        canvas.drawRoundRect(this.cmy, this.cmw, this.cmw, this.aiW);
        Paint.FontMetricsInt fontMetricsInt = this.aiW.getFontMetricsInt();
        this.aiW.setColor(am.getColor(this.bgX));
        canvas.drawText(charSequence, i, i2, f + this.cmz, (int) ((this.cmy.centerY() + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2)) - fontMetricsInt.bottom), this.aiW);
    }

    public void er(boolean z) {
        if (this.aiW != null) {
            if (z) {
                this.aiW.setStyle(Paint.Style.FILL);
            } else {
                this.aiW.setStyle(Paint.Style.STROKE);
            }
        }
    }
}
