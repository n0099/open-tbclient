package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class j extends h {
    private int axQ;
    private int axR;
    private int axS;

    public j(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.axQ = 0;
        this.axR = 0;
        this.axS = 0;
        this.axQ = i2;
        this.axR = i3;
    }

    @Override // com.baidu.tbadk.core.view.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.axQ == 0 && this.axR == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.axQ + this.axR;
    }

    @Override // com.baidu.tbadk.core.view.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.axS);
        super.draw(canvas, charSequence, i, i2, f + this.axQ, i3, i4, i5, paint);
        canvas.restore();
    }
}
