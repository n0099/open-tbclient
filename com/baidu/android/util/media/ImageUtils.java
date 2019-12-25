package com.baidu.android.util.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.PathUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64;
/* loaded from: classes9.dex */
public final class ImageUtils {
    private static final boolean DEBUG = false;
    public static final long DEFAULT_MAX_PIXELS = 131072;
    public static final int QUALITY = 100;
    public static final int ROTATE_0 = 0;
    public static final int ROTATE_180 = 180;
    public static final int ROTATE_270 = 270;
    public static final int ROTATE_90 = 90;
    private static final String TAG = "ImageUtils";

    private ImageUtils() {
    }

    public static Bitmap loadBitmapFromSDCard(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, new BitmapFactory.Options());
            Closeables.closeSafely(fileInputStream);
            return decodeStream;
        } catch (IOException | OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [153=4] */
    public static Bitmap loadBitmapFromSDCard(String str, int i, int i2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file = new File(str);
        try {
            try {
                fileInputStream2 = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = getAppropriateSampleSize(fileInputStream2, i, i2);
                Closeables.closeSafely(fileInputStream2);
                fileInputStream = new FileInputStream(file);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
                    int decodeImageDegree = decodeImageDegree(str);
                    if (decodeStream == null || !(decodeImageDegree == 90 || decodeImageDegree == 270)) {
                        Closeables.closeSafely(fileInputStream);
                        return decodeStream;
                    }
                    Matrix matrix = new Matrix();
                    matrix.setRotate(decodeImageDegree, decodeStream.getWidth() / 2.0f, decodeStream.getHeight() / 2.0f);
                    Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
                    decodeStream.recycle();
                    Closeables.closeSafely(fileInputStream);
                    return createBitmap;
                } catch (IOException e) {
                    e = e;
                    fileInputStream2 = fileInputStream;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    Closeables.closeSafely(fileInputStream);
                    return null;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    e.printStackTrace();
                    Closeables.closeSafely(fileInputStream);
                    return null;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (OutOfMemoryError e4) {
                e = e4;
                fileInputStream = fileInputStream2;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                Closeables.closeSafely(fileInputStream);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileInputStream2 = null;
        } catch (OutOfMemoryError e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i, i2);
        if (computeInitialSampleSize <= 8) {
            int i3 = 1;
            while (i3 < computeInitialSampleSize) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((computeInitialSampleSize + 7) / 8) * 8;
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        double d = options.outWidth;
        double d2 = options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / i2));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / i), Math.floor(d2 / i));
        if (min >= ceil) {
            if (i2 == -1 && i == -1) {
                return 1;
            }
            return i != -1 ? min : ceil;
        }
        return ceil;
    }

    public static int getAppropriateSampleSize(InputStream inputStream, int i, int i2) {
        if (inputStream == null) {
            return 1;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            if (options.outHeight <= 0 || options.outWidth <= 0) {
                return 1;
            }
            return computeSampleSize(options, i, i2);
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
            return 1;
        }
    }

    private static int decodeImageDegree(String str) {
        if (str == null) {
            return 0;
        }
        try {
            switch (new ExifInterface(str).getAttributeInt(android.support.media.ExifInterface.TAG_ORIENTATION, 1)) {
                case 3:
                    return 180;
                case 4:
                case 5:
                case 7:
                default:
                    return 0;
                case 6:
                    return 90;
                case 8:
                    return 270;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void saveBitmapToFile(Bitmap bitmap, File file) {
        if (bitmap != null && file != null && !file.isDirectory()) {
            saveBitmap(bitmap, file.getAbsolutePath(), 100);
        }
    }

    public static boolean saveBitmap(Bitmap bitmap, String str) {
        return saveBitmap(bitmap, str, 100);
    }

    public static boolean saveBitmap(Bitmap bitmap, String str, int i) {
        return saveBitmap(bitmap, str, i, Bitmap.CompressFormat.JPEG);
    }

    public static boolean saveBitmap(Bitmap bitmap, String str, int i, Bitmap.CompressFormat compressFormat) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        if (compressFormat == null) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        if (PathUtils.isExternalStorageWritable()) {
            FileOutputStream fileOutputStream2 = null;
            try {
                File file = new File(str);
                if (createAbsoluteDir(file)) {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        z = bitmap.compress(compressFormat, i, fileOutputStream);
                        Closeables.closeSafely(fileOutputStream);
                    } catch (FileNotFoundException e) {
                        Closeables.closeSafely(fileOutputStream);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        Closeables.closeSafely(fileOutputStream2);
                        throw th;
                    }
                } else {
                    Closeables.closeSafely((Closeable) null);
                }
            } catch (FileNotFoundException e2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z;
    }

    private static boolean createAbsoluteDir(File file) {
        if (file.getParentFile().exists()) {
            return true;
        }
        return file.getParentFile().mkdirs();
    }

    public static Bitmap duplicateBitmap(Bitmap bitmap) {
        Bitmap bitmap2;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        try {
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            if (bitmap2 != null) {
                Canvas canvas = new Canvas(bitmap2);
                Rect rect = new Rect(0, 0, width, height);
                canvas.drawBitmap(bitmap, rect, rect, (Paint) null);
            }
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
            bitmap2 = null;
        }
        return bitmap2;
    }

    public static Bitmap reduceBitmap(Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        if (bitmap == null || i <= 0 || i2 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        float min = Math.min(1.0f, Math.min(i / width, i2 / height));
        matrix.postScale(min, min);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
            bitmap2 = null;
        }
        return bitmap2;
    }

    public static String imgToBase64(Bitmap bitmap) {
        return imgToBase64(bitmap, 100);
    }

    public static String imgToBase64(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        String str = null;
        if (bitmap != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    Closeables.closeSafely(byteArrayOutputStream);
                } catch (Exception e2) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.flush();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    Closeables.closeSafely(byteArrayOutputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.flush();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    Closeables.closeSafely(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e5) {
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        }
        return str;
    }

    public static Bitmap base64ToImg(String str, BitmapFactory.Options options) {
        byte[] bArr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            bArr = Base64.decode(str, 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr != null) {
            try {
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static Bitmap getCenterCropBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int max = Math.max((bitmap.getWidth() - i) / 2, 0);
        int max2 = Math.max((bitmap.getHeight() - i2) / 2, 0);
        return Bitmap.createBitmap(bitmap, max, max2, max == 0 ? bitmap.getWidth() : i, max2 == 0 ? bitmap.getHeight() : i2, new Matrix(), true);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return drawableToBitmap(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    public static Bitmap drawableToBitmap(Drawable drawable, int i, int i2) {
        Bitmap bitmap = null;
        if (drawable != null && i > 0 && i2 > 0) {
            try {
                bitmap = Bitmap.createBitmap(i, i2, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                if (bitmap != null) {
                    Canvas canvas = new Canvas(bitmap);
                    drawable.setBounds(0, 0, i, i2);
                    drawable.draw(canvas);
                }
            } catch (Exception | OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }

    @Deprecated
    public static Bitmap getBitmapFromNet(Context context, int i, String str) {
        return null;
    }

    public static Bitmap createBitmap(int i, int i2, int i3, int i4, String str, int i5) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(0.0f, 0.0f);
            Paint paint = new Paint();
            paint.setColor(i4);
            Paint paint2 = new Paint(32);
            paint2.setTextSize(i5);
            paint2.setColor(AppRuntime.getAppContext().getResources().getColor(i3));
            Rect rect = new Rect(0, 0, i, i2);
            canvas.drawRect(rect, paint);
            new DrawTextUtil(paint2).drawText(canvas, rect, str, true, true);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static Bitmap createBitmapInNotify(int i, int i2, int i3, int i4, String str, int i5) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(0.0f, 0.0f);
            Paint paint = new Paint();
            paint.setColor(AppRuntime.getAppContext().getResources().getColor(i4));
            Paint paint2 = new Paint(32);
            paint2.setTextSize(i5);
            paint2.setColor(AppRuntime.getAppContext().getResources().getColor(i3));
            Rect rect = new Rect(0, 0, i, i2);
            canvas.drawRect(rect, paint);
            new DrawTextUtil(paint2).drawText(canvas, rect, str, true, true);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } finally {
            Closeables.closeSafely(byteArrayOutputStream);
        }
    }

    public static String encodeBitmapAsString(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return "";
        }
    }

    public static Bitmap decodeBitmapFromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] decode = android.util.Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Bitmap captureViewSnapshot(View view) {
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            int save = canvas.save();
            view.draw(canvas);
            canvas.restoreToCount(save);
            return createBitmap;
        } catch (Exception e) {
            return null;
        } catch (OutOfMemoryError e2) {
            return null;
        }
    }

    public static String getBase64ImageFromBitmap(Bitmap bitmap, long j) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        int i = height;
        int i2 = width;
        while (i2 * i > j) {
            i2 = (int) (i2 / 1.2d);
            i = (int) (i / 1.2d);
        }
        return getBase64ImageFromBitmap(Bitmap.createScaledBitmap(bitmap, i2, i, true));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [837=4] */
    public static String getBase64ImageFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        String str = null;
        if (bitmap != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    str = android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (OutOfMemoryError e2) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (OutOfMemoryError e5) {
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        }
        return str;
    }

    public static Bitmap getSizedBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap != null && i > 0 && i2 > 0) {
            try {
                return Bitmap.createScaledBitmap(bitmap, i, i2, true);
            } catch (Exception e) {
                e.printStackTrace();
                return bitmap;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                return bitmap;
            }
        }
        return bitmap;
    }

    public static Bitmap getSizedBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        if (bitmap != null && i > 0 && i2 > 0) {
            try {
                float width = bitmap.getWidth();
                float height = bitmap.getHeight();
                float min = Math.min(i / width, i2 / height);
                return Bitmap.createScaledBitmap(bitmap, (int) (z ? width * min : i), (int) (z ? min * height : i2), true);
            } catch (Exception e) {
                e.printStackTrace();
                return bitmap;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                return bitmap;
            }
        }
        return bitmap;
    }

    public static int calculateInSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i6 / i5 > i4 && i7 / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }
}
