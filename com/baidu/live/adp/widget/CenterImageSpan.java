package com.baidu.live.adp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class CenterImageSpan extends ImageSpan {
    private WeakReference<Drawable> mDrawableRef;
    private int offset;

    public CenterImageSpan(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    public CenterImageSpan(Context context, Bitmap bitmap, int i) {
        super(context, bitmap, i);
    }

    public CenterImageSpan(Drawable drawable) {
        super(drawable);
    }

    public CenterImageSpan(Drawable drawable, int i) {
        super(drawable, i);
    }

    public CenterImageSpan(Drawable drawable, String str) {
        super(drawable, str, 0);
    }

    public CenterImageSpan(Drawable drawable, String str, int i) {
        super(drawable, str, i);
    }

    public CenterImageSpan(Context context, Uri uri) {
        super(context, uri);
    }

    public CenterImageSpan(Context context, Uri uri, int i) {
        super(context, uri, i);
    }

    public CenterImageSpan(Context context, int i) {
        super(context, i);
    }

    public CenterImageSpan(Context context, int i, int i2) {
        super(context, i, i2);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        canvas.save();
        int i6 = paint.getFontMetricsInt().top;
        canvas.translate(f, ((i5 - cachedDrawable.getBounds().bottom) - (((paint.getFontMetricsInt().bottom - i6) / 2) - ((cachedDrawable.getBounds().top + cachedDrawable.getBounds().bottom) / 2))) + this.offset);
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

    public void setOffset(int i) {
        this.offset = i;
    }
}
