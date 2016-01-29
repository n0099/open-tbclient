package com.baidu.adp.lib.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes.dex */
public class d {
    private static d yh = null;
    private volatile SparseArray<Bitmap> mBitmapHash = new SparseArray<>();
    private Context mContext = null;
    private Bitmap.Config yi = Bitmap.Config.RGB_565;

    public static synchronized d iH() {
        d dVar;
        synchronized (d.class) {
            if (yh == null) {
                yh = new d();
            }
            dVar = yh;
        }
        return dVar;
    }

    public synchronized void I(Context context) {
        this.mContext = context;
    }

    public void a(Bitmap.Config config) {
        this.yi = config;
    }

    private d() {
    }

    public synchronized Bitmap getCashBitmap(int i) {
        Bitmap bitmap;
        bitmap = this.mBitmapHash.get(i);
        if (bitmap == null && (bitmap = getResBitmap(this.mContext, i)) != null) {
            this.mBitmapHash.put(i, bitmap);
        }
        return bitmap;
    }

    public synchronized void clearCashBitmap() {
        this.mBitmapHash.clear();
    }

    public Bitmap aC(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public String a(String str, String str2, Bitmap bitmap, int i) {
        if (e.aF(str) && bitmap != null && e.u(str, str2)) {
            File x = e.x(str, str2);
            try {
                if ((!x.exists() || x.delete()) && x.createNewFile()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(x);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return x.getPath();
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
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

    public Bitmap resizeBitmap(Bitmap bitmap, int i) {
        return resizeBitmap(bitmap, i, i);
    }

    public Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public byte[] Bitmap2Bytes(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public Bitmap Bytes2Bitmap(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = this.yi;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }
}
