package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class j extends h {
    private int cId;
    private int fje;
    private int fjf;

    public j(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.fje = 0;
        this.fjf = 0;
        this.cId = 0;
        this.fje = i2;
        this.fjf = i3;
    }

    @Override // com.baidu.tbadk.core.view.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.fje == 0 && this.fjf == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.fje + this.fjf;
    }

    @Override // com.baidu.tbadk.core.view.h, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.cId);
        super.draw(canvas, charSequence, i, i2, f + this.fje, i3, i4, i5, paint);
        canvas.restore();
    }
}
