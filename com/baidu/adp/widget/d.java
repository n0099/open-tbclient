package com.baidu.adp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d extends ImageSpan {
    private int offset;
    private WeakReference<Drawable> wZ;

    public d(Context context, Bitmap bitmap, int i) {
        super(context, bitmap, i);
    }

    public d(Drawable drawable, int i) {
        super(drawable, i);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable iD = iD();
        canvas.save();
        int i6 = paint.getFontMetricsInt().top;
        canvas.translate(f, ((i5 - iD.getBounds().bottom) - (((paint.getFontMetricsInt().bottom - i6) / 2) - ((iD.getBounds().top + iD.getBounds().bottom) / 2))) + this.offset);
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

    public void setOffset(int i) {
        this.offset = i;
    }
}
