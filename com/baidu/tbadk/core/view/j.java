package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class j extends h {
    private int euX;
    private int euY;
    private int mOffsetY;

    public j(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.euX = 0;
        this.euY = 0;
        this.mOffsetY = 0;
        this.euX = i2;
        this.euY = i3;
    }

    @Override // com.baidu.tbadk.core.view.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.euX == 0 && this.euY == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.euX + this.euY;
    }

    @Override // com.baidu.tbadk.core.view.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.mOffsetY);
        super.draw(canvas, charSequence, i, i2, f + this.euX, i3, i4, i5, paint);
        canvas.restore();
    }
}
