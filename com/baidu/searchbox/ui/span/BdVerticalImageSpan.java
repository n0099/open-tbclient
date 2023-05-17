package com.baidu.searchbox.ui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
/* loaded from: classes4.dex */
public class BdVerticalImageSpan extends ImageSpan {
    public BdVerticalImageSpan(Drawable drawable) {
        super(drawable);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i6 = fontMetricsInt.top;
        canvas.translate(f, i4 + i6 + (((fontMetricsInt.bottom - i6) - (drawable.getBounds().bottom - drawable.getBounds().top)) / 2));
        drawable.draw(canvas);
        canvas.restore();
    }
}
