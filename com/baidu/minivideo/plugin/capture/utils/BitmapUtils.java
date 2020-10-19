package com.baidu.minivideo.plugin.capture.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
/* loaded from: classes17.dex */
public class BitmapUtils {
    public static Bitmap cropBitmapLeft(Bitmap bitmap, int i, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, i, bitmap.getHeight());
        if (z && bitmap != null && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap cropBitmapLeft(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, i, i2, i3, i4);
        if (z && bitmap != null && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap scaleImage(Bitmap bitmap, int i, int i2, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (z && bitmap != null && !bitmap.equals(createBitmap)) {
            bitmap.recycle();
            return createBitmap;
        }
        return createBitmap;
    }

    public static Bitmap scaleCover(Bitmap bitmap, int i, int i2, boolean z) {
        if (i > 0) {
            if ((i2 > 0 || bitmap != null) && !bitmap.isRecycled()) {
                if ((bitmap.getWidth() > bitmap.getHeight()) == (i > i2)) {
                    i2 = i;
                    i = i2;
                }
                if (i2 != bitmap.getWidth() || i != bitmap.getHeight()) {
                    return scaleImage(bitmap, i2, i, z);
                }
                return bitmap;
            }
            return bitmap;
        }
        return bitmap;
    }
}
