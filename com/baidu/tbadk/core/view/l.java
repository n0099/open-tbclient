package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends j {
    private int aGz;
    private int cqZ;
    private int cra;

    public l(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.cqZ = 0;
        this.cra = 0;
        this.aGz = 0;
        this.cqZ = i2;
        this.cra = i3;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.cqZ == 0 && this.cra == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.cqZ + this.cra;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.aGz);
        super.draw(canvas, charSequence, i, i2, f + this.cqZ, i3, i4, i5, paint);
        canvas.restore();
    }
}
