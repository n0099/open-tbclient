package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class ah extends ImageSpan {
    private int offset;
    private WeakReference<Drawable> wZ;

    public ah(Drawable drawable) {
        super(drawable);
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable iD = iD();
        canvas.save();
        canvas.translate(f, (((paint.getFontMetricsInt().descent + i4) - iD.getBounds().height()) / 2) + this.offset);
        iD.draw(canvas);
        canvas.restore();
    }

    private Drawable iD() {
        WeakReference<Drawable> weakReference = this.wZ;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.wZ = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }
}
