package com.baidu.platform.comapi.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* loaded from: classes20.dex */
public class d {
    public static Bitmap a(Drawable drawable) {
        int i;
        int i2;
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT > 26 || !(drawable instanceof BitmapDrawable)) {
            try {
                int width = !drawable.getBounds().isEmpty() ? drawable.getBounds().width() : drawable.getIntrinsicWidth();
                int height = !drawable.getBounds().isEmpty() ? drawable.getBounds().height() : drawable.getIntrinsicHeight();
                if (!(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
                    i = height;
                    i2 = width;
                } else {
                    if (width <= bitmap.getWidth()) {
                        width = bitmap.getWidth();
                    }
                    i = height > bitmap.getHeight() ? height : bitmap.getHeight();
                    i2 = width;
                }
                if (i2 <= 0) {
                    i2 = 1;
                }
                if (i <= 0) {
                    i = 1;
                }
                Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            } catch (Exception e) {
                return null;
            }
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }
}
