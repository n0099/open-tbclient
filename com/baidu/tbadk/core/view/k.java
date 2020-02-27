package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class k extends i {
    private int diJ;
    private int diK;
    private int mOffsetY;

    public k(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.diJ = 0;
        this.diK = 0;
        this.mOffsetY = 0;
        this.diJ = i2;
        this.diK = i3;
    }

    @Override // com.baidu.tbadk.core.view.i, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.diJ == 0 && this.diK == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.diJ + this.diK;
    }

    @Override // com.baidu.tbadk.core.view.i, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.mOffsetY);
        super.draw(canvas, charSequence, i, i2, f + this.diJ, i3, i4, i5, paint);
        canvas.restore();
    }
}
