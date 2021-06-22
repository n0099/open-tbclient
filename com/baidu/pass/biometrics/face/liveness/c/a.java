package com.baidu.pass.biometrics.face.liveness.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
/* loaded from: classes2.dex */
public class a {
    public String a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static Bitmap a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e2) {
            e2.getMessage();
            return null;
        }
    }

    public static byte[] a(Bitmap bitmap, int i2) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap a(Bitmap bitmap, float f2) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Paint paint = new Paint();
        Canvas canvas = new Canvas(createBitmap);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(f2, f2, f2, 1.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, new Matrix(), paint);
        return createBitmap;
    }
}
