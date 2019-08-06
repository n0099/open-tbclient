package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends j {
    private int anc;
    private int ccK;
    private int ccL;

    public l(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.ccK = 0;
        this.ccL = 0;
        this.anc = 0;
        this.ccK = i2;
        this.ccL = i3;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.ccK == 0 && this.ccL == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.ccK + this.ccL;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.anc);
        super.draw(canvas, charSequence, i, i2, f + this.ccK, i3, i4, i5, paint);
        canvas.restore();
    }
}
