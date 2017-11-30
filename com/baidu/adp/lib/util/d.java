package com.baidu.adp.lib.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.SparseArray;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class d {
    private static d xQ = null;
    private volatile SparseArray<Bitmap> mBitmapHash = new SparseArray<>();
    private Context mContext = null;
    private Bitmap.Config xR = Bitmap.Config.RGB_565;

    public static synchronized d gP() {
        d dVar;
        synchronized (d.class) {
            if (xQ == null) {
                xQ = new d();
            }
            dVar = xQ;
        }
        return dVar;
    }

    public synchronized void ab(Context context) {
        this.mContext = context;
    }

    private d() {
    }

    public synchronized void clearCashBitmap() {
        this.mBitmapHash.clear();
    }

    public Bitmap ax(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public Bitmap getResBitmap(Context context, int i) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, new BitmapFactory.Options());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public Bitmap resizeBitmap(Bitmap bitmap, int i, int i2) {
        float f;
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i2 / height > i / width) {
                f = i / width;
            } else {
                f = i2 / height;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }

    public Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        float f;
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i2 / height < i / width) {
                f = i / width;
            } else {
                f = i2 / height;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            matrix.postTranslate((i - (width * f)) / 2.0f, (i2 - (height * f)) / 2.0f);
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
            return createBitmap;
        }
        return bitmap;
    }

    public byte[] Bitmap2Bytes(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
