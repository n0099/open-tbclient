package com.baidu.android.imsdk.upload;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public class CompressPic {
    private static final boolean HAS_OPTIONS_IN_MUTABLE;

    static {
        HAS_OPTIONS_IN_MUTABLE = Build.VERSION.SDK_INT >= 11;
    }

    public static String genCompressThumbFilePath(String str) {
        File localOutputMediaFile = Utils.localOutputMediaFile(1, true);
        return localOutputMediaFile != null ? localOutputMediaFile.getAbsolutePath() : Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [74=6, 76=5, 77=5, 78=5] */
    public static Bitmap getCompressThumbnail(String str, String str2) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2;
        File file;
        int i;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            file = new File(str2);
            fileInputStream = new FileInputStream(str);
        } catch (Exception e) {
            fileInputStream2 = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            FileDescriptor fd = fileInputStream.getFD();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fd, null, options);
            if (Math.max(options.outWidth, options.outHeight) <= 0) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (IOException e2) {
                        LogUtils.e(LogUtils.TAG, "Bitmap IOException", e2);
                        return null;
                    }
                }
                return null;
            }
            options.inSampleSize = computeSampleSizeLarger(640 / Math.max(i, i2));
            options.inJustDecodeBounds = false;
            setOptionsMutable(options);
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fd, null, options);
            if (decodeFileDescriptor == null) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (IOException e3) {
                        LogUtils.e(LogUtils.TAG, "Bitmap IOException", e3);
                        return null;
                    }
                }
                return null;
            }
            float max = 640 / Math.max(decodeFileDescriptor.getWidth(), decodeFileDescriptor.getHeight());
            if (max <= 0.5d) {
                decodeFileDescriptor = resizeBitmapByScale(decodeFileDescriptor, max, true);
            }
            Bitmap ensureGLCompatibleBitmap = ensureGLCompatibleBitmap(decodeFileDescriptor);
            bitmap2File(ensureGLCompatibleBitmap, file);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    LogUtils.e(LogUtils.TAG, "Bitmap IOException", e4);
                }
            }
            return ensureGLCompatibleBitmap;
        } catch (Exception e5) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return null;
                } catch (IOException e6) {
                    LogUtils.e(LogUtils.TAG, "Bitmap IOException", e6);
                    return null;
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e7) {
                    LogUtils.e(LogUtils.TAG, "Bitmap IOException", e7);
                }
            }
            throw th;
        }
    }

    private static Bitmap ensureGLCompatibleBitmap(Bitmap bitmap) {
        if (bitmap != null && bitmap.getConfig() == null) {
            Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            bitmap.recycle();
            return copy;
        }
        return bitmap;
    }

    private static Bitmap.Config getConfig(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            return Bitmap.Config.ARGB_8888;
        }
        return config;
    }

    public static Bitmap resizeBitmapByScale(Bitmap bitmap, float f, boolean z) {
        int round = Math.round(bitmap.getWidth() * f);
        int round2 = Math.round(bitmap.getHeight() * f);
        if (round != bitmap.getWidth() || round2 != bitmap.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(round, round2, getConfig(bitmap));
            Canvas canvas = new Canvas(createBitmap);
            canvas.scale(f, f);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
            if (z) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }

    @TargetApi(11)
    private static void setOptionsMutable(BitmapFactory.Options options) {
        if (HAS_OPTIONS_IN_MUTABLE) {
            options.inMutable = true;
        }
    }

    public static int computeSampleSizeLarger(float f) {
        int floor = (int) Math.floor(1.0f / f);
        if (floor <= 1) {
            return 1;
        }
        return floor <= 8 ? prevPowerOf2(floor) : (floor / 8) * 8;
    }

    private static int prevPowerOf2(int i) throws IllegalArgumentException {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        return Integer.highestOneBit(i);
    }

    private static String bitmap2File(Bitmap bitmap, File file) throws Exception {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return file.getAbsolutePath();
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }
}
