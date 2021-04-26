package com.baidu.minivideo.plugin.capture.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class BitmapUtils {
    public static Bitmap cropBitmapLeft(Bitmap bitmap, int i2, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, i2, bitmap.getHeight());
        if (z && bitmap != null && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap scaleCover(Bitmap bitmap, int i2, int i3, boolean z) {
        if (i2 > 0) {
            if ((i3 > 0 || bitmap != null) && !bitmap.isRecycled()) {
                if ((bitmap.getWidth() > bitmap.getHeight()) != (i2 > i3)) {
                    i3 = i2;
                    i2 = i3;
                }
                return (i2 == bitmap.getWidth() && i3 == bitmap.getHeight()) ? bitmap : scaleImage(bitmap, i2, i3, z);
            }
            return bitmap;
        }
        return bitmap;
    }

    public static Bitmap scaleImage(Bitmap bitmap, int i2, int i3, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (z && bitmap != null && !bitmap.equals(createBitmap)) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap cropBitmapLeft(Bitmap bitmap, int i2, int i3, int i4, int i5, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, i2, i3, i4, i5);
        if (z && bitmap != null && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
