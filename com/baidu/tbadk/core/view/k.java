package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class k extends i {
    private int ayH;
    private int ayI;
    private int ayJ;

    public k(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.ayH = 0;
        this.ayI = 0;
        this.ayJ = 0;
        this.ayH = i2;
        this.ayI = i3;
    }

    @Override // com.baidu.tbadk.core.view.i, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.ayH == 0 && this.ayI == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.ayH + this.ayI;
    }

    @Override // com.baidu.tbadk.core.view.i, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.ayJ);
        super.draw(canvas, charSequence, i, i2, f + this.ayH, i3, i4, i5, paint);
        canvas.restore();
    }
}
