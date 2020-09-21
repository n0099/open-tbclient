package com.baidu.ar.g;

import android.graphics.Bitmap;
import android.graphics.Matrix;
/* loaded from: classes10.dex */
public class e {
    public static Bitmap a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        matrix.postScale(-1.0f, 1.0f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap b(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height / 4, width, height / 2, (Matrix) null, false);
        Matrix matrix = new Matrix();
        matrix.postRotate(i, createBitmap.getWidth() / 2.0f, createBitmap.getHeight() / 2.0f);
        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, false);
    }
}
