package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends j {
    private int anc;
    private int ccD;
    private int ccE;

    public l(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.ccD = 0;
        this.ccE = 0;
        this.anc = 0;
        this.ccD = i2;
        this.ccE = i3;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.ccD == 0 && this.ccE == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.ccD + this.ccE;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.anc);
        super.draw(canvas, charSequence, i, i2, f + this.ccD, i3, i4, i5, paint);
        canvas.restore();
    }
}
