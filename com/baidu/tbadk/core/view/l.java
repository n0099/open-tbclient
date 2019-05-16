package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends j {
    private int amz;
    private int cbA;
    private int cbz;

    public l(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.cbz = 0;
        this.cbA = 0;
        this.amz = 0;
        this.cbz = i2;
        this.cbA = i3;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.cbz == 0 && this.cbA == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.cbz + this.cbA;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.amz);
        super.draw(canvas, charSequence, i, i2, f + this.cbz, i3, i4, i5, paint);
        canvas.restore();
    }
}
