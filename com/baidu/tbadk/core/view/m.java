package com.baidu.tbadk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class m extends ImageSpan {
    private WeakReference<Drawable> Hu;
    private int offset;

    public m(Drawable drawable) {
        super(drawable);
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable kA = kA();
        canvas.save();
        canvas.translate(f, (((paint.getFontMetricsInt().descent + i4) - kA.getBounds().height()) / 2) + this.offset);
        kA.draw(canvas);
        canvas.restore();
    }

    private Drawable kA() {
        WeakReference<Drawable> weakReference = this.Hu;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.Hu = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }
}
