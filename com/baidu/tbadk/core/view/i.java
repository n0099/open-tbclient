package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class i extends g {
    private int apJ;
    private int apK;
    private int apL;

    public i(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.apJ = 0;
        this.apK = 0;
        this.apL = 0;
        this.apJ = i2;
        this.apK = i3;
    }

    @Override // com.baidu.tbadk.core.view.g, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.apJ == 0 && this.apK == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.apJ + this.apK;
    }

    @Override // com.baidu.tbadk.core.view.g, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.apL);
        super.draw(canvas, charSequence, i, i2, f + this.apJ, i3, i4, i5, paint);
        canvas.restore();
    }
}
