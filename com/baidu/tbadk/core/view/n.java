package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class n extends l {
    private int bep;
    private int beq;
    private int ber;

    public n(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.bep = 0;
        this.beq = 0;
        this.ber = 0;
        this.bep = i2;
        this.beq = i3;
    }

    @Override // com.baidu.tbadk.core.view.l, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.bep == 0 && this.beq == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.bep + this.beq;
    }

    @Override // com.baidu.tbadk.core.view.l, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.ber);
        super.draw(canvas, charSequence, i, i2, f + this.bep, i3, i4, i5, paint);
        canvas.restore();
    }
}
