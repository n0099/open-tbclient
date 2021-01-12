package com.baidu.ala.dumixar.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import io.flutter.plugin.platform.PlatformPlugin;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes14.dex */
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
        int i3;
        int i4;
        if (i > 0) {
            if ((i2 > 0 || bitmap != null) && !bitmap.isRecycled()) {
                if ((bitmap.getWidth() > bitmap.getHeight()) != (i > i2)) {
                    i3 = i;
                    i4 = i2;
                } else {
                    i3 = i2;
                    i4 = i;
                }
                if (i4 != bitmap.getWidth() || i3 != bitmap.getHeight()) {
                    return scaleImage(bitmap, i4, i3, z);
                }
                return bitmap;
            }
            return bitmap;
        }
        return bitmap;
    }

    public static Bitmap scaleCoverCenterCrop(Bitmap bitmap, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width != 0 && height != 0 && i != 0 && i2 != 0) {
            if ((width * 1.0f) / height > (i * 1.0f) / i2) {
                i4 = (height * i) / i2;
                i3 = height;
            } else {
                i3 = (width * i2) / i;
                i4 = width;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, width > i4 ? (width - i4) / 2 : 0, height > i3 ? (height - i3) / 2 : 0, i4, i3, (Matrix) null, false);
            if (z && bitmap != null && !bitmap.equals(createBitmap)) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap scaleBitMapCenterCrop(Bitmap bitmap, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width != 0 && height != 0 && i != 0 && i2 != 0) {
            float f = (width * 1.0f) / height;
            float f2 = (i * 1.0f) / i2;
            if (Math.abs(f - f2) < 0.01d) {
                i3 = height;
                i4 = width;
            } else if (f > f2) {
                i4 = (height * i) / i2;
                i3 = height;
            } else {
                i3 = (width * i2) / i;
                i4 = width;
            }
            int i5 = width > i4 ? (width - i4) / 2 : 0;
            int i6 = height > i3 ? (height - i3) / 2 : 0;
            Matrix matrix = new Matrix();
            matrix.postScale((i * 1.0f) / width, (i2 * 1.0f) / height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i5, i6, i4, i3, matrix, true);
            if (z && bitmap != null && !bitmap.equals(createBitmap)) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap loadBitmap(Context context, int i) {
        new BitmapFactory.Options().inScaled = false;
        return BitmapFactory.decodeResource(context.getResources(), i);
    }

    public static Bitmap loadBitmap(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        return BitmapFactory.decodeStream(fileInputStream);
    }

    public static String bitmapToBase64(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        String encodeToString;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bitmap == null || bitmap.isRecycled()) {
            return "";
        }
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bitmap.compress(compressFormat, i, byteArrayOutputStream);
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.flush();
                                byteArrayOutputStream.close();
                                return null;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return null;
                            }
                        }
                        return null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            byteArrayOutputStream2.flush();
                            byteArrayOutputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                byteArrayOutputStream = null;
                encodeToString = null;
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return encodeToString;
                }
            }
            return encodeToString;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static Bitmap base64ToBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Bitmap compressBitmap(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static int getImageIdByName(String str, Context context) {
        try {
            int identifier = context.getResources().getIdentifier(str, "drawable", getAppPackageName(context));
            if (identifier == 0) {
                identifier = context.getResources().getIdentifier(str, "mipmap", getAppPackageName(context));
            }
            if (identifier == 0) {
                int identifier2 = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
                if (identifier2 == 0) {
                    return context.getResources().getIdentifier(str, "mipmap", context.getPackageName());
                }
                return identifier2;
            }
            return identifier;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap decodeBitmap(Context context, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (str.contains(File.separator)) {
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = calculateInSampleSize(options, 720, PlatformPlugin.DEFAULT_SYSTEM_UI);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return BitmapFactory.decodeResource(context.getResources(), getImageIdByName(str, context));
    }

    private static String getAppPackageName(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationInfo().packageName;
    }
}
