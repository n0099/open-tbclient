package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class l extends j {
    private int amn;
    private int bTF;
    private int bTG;

    public l(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        this.bTF = 0;
        this.bTG = 0;
        this.amn = 0;
        this.bTF = i2;
        this.bTG = i3;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (this.bTF == 0 && this.bTG == 0) ? super.getSize(paint, charSequence, i, i2, fontMetricsInt) : getDrawable().getBounds().width() + this.bTF + this.bTG;
    }

    @Override // com.baidu.tbadk.core.view.j, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.amn);
        super.draw(canvas, charSequence, i, i2, f + this.bTF, i3, i4, i5, paint);
        canvas.restore();
    }
}
