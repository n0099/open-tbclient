package com.baidu.adp.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d extends ImageSpan {
    private WeakReference<Drawable> Fe;

    public d(Drawable drawable, int i) {
        super(drawable, i);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable mG = mG();
        canvas.save();
        int i6 = paint.getFontMetricsInt().top;
        canvas.translate(f, (i5 - mG.getBounds().bottom) - (((paint.getFontMetricsInt().bottom - i6) / 2) - ((mG.getBounds().top + mG.getBounds().bottom) / 2)));
        mG.draw(canvas);
        canvas.restore();
    }

    private Drawable mG() {
        WeakReference<Drawable> weakReference = this.Fe;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.Fe = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }
}
