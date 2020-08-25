package com.baidu.live.adp.lib.util;

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
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.SparseArray;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class BdBitmapHelper {
    public static final int ROTATE_LEFT = 0;
    public static final int ROTATE_LEFT_RIGHT = 2;
    public static final int ROTATE_RIGHT = 1;
    public static final int ROTATE_UP_DOWN = 3;
    private static BdBitmapHelper sInstance = null;
    private volatile SparseArray<Bitmap> mBitmapHash = new SparseArray<>();
    private Context mContext = null;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.RGB_565;

    public static synchronized BdBitmapHelper getInstance() {
        BdBitmapHelper bdBitmapHelper;
        synchronized (BdBitmapHelper.class) {
            if (sInstance == null) {
                sInstance = new BdBitmapHelper();
            }
            bdBitmapHelper = sInstance;
        }
        return bdBitmapHelper;
    }

    public synchronized void initial(Context context) {
        this.mContext = context;
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
    }

    private BdBitmapHelper() {
    }

    public synchronized Bitmap getCashBitmap(int i) {
        Bitmap bitmap;
        bitmap = this.mBitmapHash.get(i);
        if (bitmap == null && (bitmap = getResBitmap(this.mContext, i)) != null) {
            this.mBitmapHash.put(i, bitmap);
        }
        return bitmap;
    }

    public synchronized void removeCashBitmap(int i) {
        this.mBitmapHash.remove(i);
    }

    public synchronized void clearCashBitmap() {
        this.mBitmapHash.clear();
    }

    public Bitmap getImage(String str, String str2) {
        return BitmapFactory.decodeFile(BdFileHelper.getFilePath(str, str2));
    }

    public Bitmap getImage(String str) {
        return BitmapFactory.decodeFile(BdFileHelper.getFilePath(str));
    }

    public Bitmap getImageAbsolutePath(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public String saveFile(String str, String str2, Bitmap bitmap, int i) {
        if (BdFileHelper.checkDir(str) && bitmap != null && BdFileHelper.checkAndMkdirs(str, str2)) {
            File file = BdFileHelper.getFile(str, str2);
            try {
                if ((!file.exists() || file.delete()) && file.createNewFile()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file.getPath();
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public String saveFile(String str, Bitmap bitmap, int i) {
        return saveFile(null, str, bitmap, i);
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
        if (i <= 0 || i2 <= 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= 0 || height <= 0) {
                return null;
            }
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

    public Bitmap resizeBitmap(Bitmap bitmap, int i) {
        return resizeBitmap(bitmap, i, i);
    }

    public Bitmap getResizedBitmap(Bitmap bitmap, int i) {
        return getResizedBitmap(bitmap, i, i);
    }

    public Bitmap resizeBitmap(String str, String str2, int i) {
        return resizeBitmap(subSampleBitmap(str, str2, i), i);
    }

    public Bitmap resizeBitmap(String str, int i) {
        return resizeBitmap(subSampleBitmap((String) null, str, i), i);
    }

    public Bitmap subSampleBitmap(String str, String str2, int i) {
        int i2 = 1;
        if (i <= 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            InputStream inStreamFromFile = BdFileHelper.getInStreamFromFile(str, str2);
            BitmapFactory.decodeStream(inStreamFromFile, null, options);
            options.inPreferredConfig = this.mBitmapConfig;
            try {
                inStreamFromFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (true) {
                if (options.outWidth / (i2 * 2) <= i && options.outHeight / (i2 * 2) <= i) {
                    break;
                }
                i2 *= 2;
            }
            options.inJustDecodeBounds = false;
            options.inSampleSize = i2;
            InputStream inStreamFromFile2 = BdFileHelper.getInStreamFromFile(str, str2);
            Bitmap decodeStream = BitmapFactory.decodeStream(inStreamFromFile2, null, options);
            try {
                inStreamFromFile2.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return decodeStream;
        } catch (Exception e3) {
            return null;
        }
    }

    public Bitmap subSampleBitmap(String str, int i) {
        return subSampleBitmap((String) null, str, i);
    }

    public Bitmap resizeBitmap(Context context, Uri uri, int i) {
        return resizeBitmap(subSampleBitmap(context, uri, i), i);
    }

    public Bitmap subSampleBitmap(Context context, Uri uri, int i) {
        ParcelFileDescriptor parcelFileDescriptor;
        int i2 = 1;
        try {
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = this.mBitmapConfig;
                options.inDither = false;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                while (true) {
                    if (options.outWidth / (i2 + 1) > i || options.outHeight / (i2 + 1) > i) {
                        i2++;
                    } else {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i2;
                        return BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                    }
                }
            } catch (Exception e) {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                        return null;
                    } catch (Exception e2) {
                        return null;
                    }
                }
                return null;
            }
        } catch (Exception e3) {
            parcelFileDescriptor = null;
        }
    }

    public Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f) {
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

    public Bitmap getRoundedCornerBitmap2(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
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

    public byte[] Bitmap2BytesPng(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public Bitmap Bytes2Bitmap(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = this.mBitmapConfig;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (i == 0) {
            matrix.postRotate(-90.0f);
        } else if (i == 1) {
            matrix.postRotate(90.0f);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap rotateBitmapDegree(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap reversalBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == 2) {
            matrix.setScale(1.0f, -1.0f);
        } else if (i == 3) {
            matrix.setScale(-1.0f, 1.0f);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        matrix.setRotate(180.0f);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
        if (createBitmap != createBitmap2) {
            createBitmap.recycle();
        }
        if (bitmap != createBitmap2) {
            bitmap.recycle();
        }
        return createBitmap2;
    }

    public Bitmap enlargeBitmap(Bitmap bitmap, int i, int i2) {
        float f;
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() < i || bitmap.getHeight() < i2) {
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
}
