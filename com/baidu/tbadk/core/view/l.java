package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends j {
    private int amh;
    private int bTB;
    private int bTC;

    public l(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.bTB = 0;
        this.bTC = 0;
        this.amh = 0;
        this.bTB = i2;
        this.bTC = i3;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.bTB == 0 && this.bTC == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.bTB + this.bTC;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.amh);
        super.draw(canvas, charSequence, i, i2, f + this.bTB, i3, i4, i5, paint);
        canvas.restore();
    }
}
