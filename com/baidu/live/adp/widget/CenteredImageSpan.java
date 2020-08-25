package com.baidu.live.adp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class CenteredImageSpan extends ImageSpan {
    private WeakReference<Drawable> mDrawableRef;

    public CenteredImageSpan(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.translate(f, ((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - (cachedDrawable.getBounds().bottom / 2));
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
}
