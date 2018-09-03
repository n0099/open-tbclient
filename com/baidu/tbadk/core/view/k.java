package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class k extends i {
    private int ayr;
    private int ays;
    private int ayt;

    public k(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.ayr = 0;
        this.ays = 0;
        this.ayt = 0;
        this.ayr = i2;
        this.ays = i3;
    }

    @Override // com.baidu.tbadk.core.view.i, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.ayr == 0 && this.ays == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.ayr + this.ays;
    }

    @Override // com.baidu.tbadk.core.view.i, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.ayt);
        super.draw(canvas, charSequence, i, i2, f + this.ayr, i3, i4, i5, paint);
        canvas.restore();
    }
}
