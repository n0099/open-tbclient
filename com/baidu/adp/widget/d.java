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
    private WeakReference<Drawable> FY;
    private int offset;

    public d(Context context, Bitmap bitmap, int i) {
        super(context, bitmap, i);
    }

    public d(Drawable drawable, int i) {
        super(drawable, i);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable mw = mw();
        canvas.save();
        int i6 = paint.getFontMetricsInt().top;
        canvas.translate(f, ((i5 - mw.getBounds().bottom) - (((paint.getFontMetricsInt().bottom - i6) / 2) - ((mw.getBounds().top + mw.getBounds().bottom) / 2))) + this.offset);
        mw.draw(canvas);
        canvas.restore();
    }

    private Drawable mw() {
        WeakReference<Drawable> weakReference = this.FY;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.FY = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public void setOffset(int i) {
        this.offset = i;
    }
}
