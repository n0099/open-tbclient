package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class k extends i {
    private int ayu;
    private int ayv;
    private int ayw;

    public k(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.ayu = 0;
        this.ayv = 0;
        this.ayw = 0;
        this.ayu = i2;
        this.ayv = i3;
    }

    @Override // com.baidu.tbadk.core.view.i, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.ayu == 0 && this.ayv == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.ayu + this.ayv;
    }

    @Override // com.baidu.tbadk.core.view.i, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.ayw);
        super.draw(canvas, charSequence, i, i2, f + this.ayu, i3, i4, i5, paint);
        canvas.restore();
    }
}
