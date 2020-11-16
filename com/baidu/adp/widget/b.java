package com.baidu.adp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b extends ImageSpan {
    private WeakReference<Drawable> mDrawableRef;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int offset;

    public b(Context context, Bitmap bitmap, int i) {
        super(context, bitmap, i);
    }

    public b(Drawable drawable, int i) {
        super(drawable, i);
    }

    public b(Context context, int i) {
        super(context, i);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return super.getSize(paint, charSequence, i, i2, fontMetricsInt) + this.mPaddingLeft + this.mPaddingRight;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        canvas.save();
        int i6 = paint.getFontMetricsInt().top;
        canvas.translate(this.mPaddingLeft + f, ((i5 - cachedDrawable.getBounds().bottom) - (((paint.getFontMetricsInt().bottom - i6) / 2) - ((cachedDrawable.getBounds().top + cachedDrawable.getBounds().bottom) / 2))) + this.offset);
        cachedDrawable.draw(canvas);
        canvas.restore();
    }

    private Drawable getCachedDrawable() {
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.mDrawableRef = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public void aH(int i) {
        this.mPaddingLeft = i;
    }
}
