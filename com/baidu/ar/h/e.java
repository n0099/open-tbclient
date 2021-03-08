package com.baidu.ar.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
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

    public static Bitmap f(Context context, String str) {
        Bitmap bitmap = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream open = context.getAssets().open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        float f;
        float f2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(i, width / 2.0f, height / 2.0f);
        if (i != 90 && i != 270) {
            f = 0.0f;
            f2 = 0.0f;
        } else if (width > height) {
            f2 = (height / 2.0f) - (width / 2.0f);
            f = 0.0f - f2;
        } else {
            f = (width / 2.0f) - (height / 2.0f);
            f2 = 0.0f - f;
        }
        matrix.postTranslate(f2, f);
        Bitmap bitmap2 = null;
        try {
            bitmap2 = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Canvas(bitmap2).drawBitmap(bitmap, matrix, new Paint());
        return bitmap2;
    }
}
