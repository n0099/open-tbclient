package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class n extends l {
    private int bcC;
    private int bcD;
    private int bcE;

    public n(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.bcC = 0;
        this.bcD = 0;
        this.bcE = 0;
        this.bcC = i2;
        this.bcD = i3;
    }

    @Override // com.baidu.tbadk.core.view.l, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.bcC == 0 && this.bcD == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.bcC + this.bcD;
    }

    @Override // com.baidu.tbadk.core.view.l, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.bcE);
        super.draw(canvas, charSequence, i, i2, f + this.bcC, i3, i4, i5, paint);
        canvas.restore();
    }
}
