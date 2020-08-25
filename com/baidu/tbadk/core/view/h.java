package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
/* loaded from: classes2.dex */
public class h extends ImageSpan {
    public h(Drawable drawable, int i) {
        super(drawable, i);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.mVerticalAlignment == -100) {
            Drawable drawable = getDrawable();
            canvas.save();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.translate(f, (((fontMetricsInt.bottom - fontMetricsInt.top) - (drawable.getBounds().bottom - drawable.getBounds().top)) / 2) + fontMetricsInt.top + i4);
            drawable.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
    }
}
