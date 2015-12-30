package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class y extends ImageSpan {
    private WeakReference<Drawable> FL;
    private int offset;

    public y(Drawable drawable) {
        super(drawable);
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable mh = mh();
        canvas.save();
        canvas.translate(f, (((paint.getFontMetricsInt().descent + i4) - mh.getBounds().height()) / 2) + this.offset);
        mh.draw(canvas);
        canvas.restore();
    }

    private Drawable mh() {
        WeakReference<Drawable> weakReference = this.FL;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.FL = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }
}
