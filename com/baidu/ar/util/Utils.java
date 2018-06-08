package com.baidu.ar.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public final class Utils {
    private static String b;
    private static String c;
    private static final String a = Utils.class.getName();
    private static String d = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + "/camera/";

    private static void a() {
        File file = new File(d);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static Bitmap adjustBitmapDegree(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap adjustPreviewBitmap(Bitmap bitmap, double d2, double d3) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) d2) / width, ((float) d3) / height);
        matrix.postRotate(90.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
    }

    public static Bitmap adjustSurfaceViewBitmap(Bitmap bitmap) {
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), new Matrix(), true);
    }

    private static String b() {
        b = "AR_Screenshot_" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".jpg";
        return b;
    }

    public static void broadcastMediaAdded(Context context, File file) {
        if (context == null || file == null || !file.isFile()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    public static void broadcastMediaAdded(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        broadcastMediaAdded(context, new File(str));
    }

    public static boolean checkHideVideoUrlValid() {
        File file = new File(getHideVideoUrl());
        return file.exists() && file.isFile();
    }

    public static boolean checkSDCardSizeAvailable(int i) {
        long sDAvailableSizeByM = SystemInfoUtil.getSDAvailableSizeByM();
        ARLog.e("bdar:avaiableSize = " + sDAvailableSizeByM);
        return sDAvailableSizeByM >= ((long) i);
    }

    public static Bitmap combineBitmap(Bitmap bitmap, Bitmap bitmap2, int i, boolean z) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (bitmap2 != null) {
            if (z) {
                Matrix matrix = new Matrix();
                matrix.setScale(1.0f, -1.0f);
                matrix.postTranslate(0.0f, bitmap2.getHeight());
                canvas.drawBitmap(bitmap2, matrix, new Paint());
            } else {
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
        canvas.save(31);
        canvas.restore();
        Matrix matrix2 = new Matrix();
        matrix2.postRotate(i);
        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix2, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean copyfile(File file, File file2, Boolean bool) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        if (file.exists() && file.isFile() && file.canRead()) {
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (file2.exists() && bool.booleanValue()) {
                file2.delete();
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        IoUtils.copyStream(fileInputStream, fileOutputStream);
                        fileOutputStream.flush();
                        IoUtils.closeQuietly(fileInputStream);
                        IoUtils.closeQuietly(fileOutputStream);
                    } catch (FileNotFoundException e) {
                        e = e;
                        fileInputStream3 = fileInputStream;
                        fileInputStream2 = fileOutputStream;
                        try {
                            e.printStackTrace();
                            IoUtils.closeQuietly(fileInputStream3);
                            IoUtils.closeQuietly(fileInputStream2);
                            return true;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream3;
                            fileInputStream3 = fileInputStream2;
                            IoUtils.closeQuietly(fileInputStream);
                            IoUtils.closeQuietly(fileInputStream3);
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream3 = fileOutputStream;
                        e.printStackTrace();
                        IoUtils.closeQuietly(fileInputStream);
                        IoUtils.closeQuietly(fileInputStream3);
                        return true;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream3 = fileOutputStream;
                        IoUtils.closeQuietly(fileInputStream);
                        IoUtils.closeQuietly(fileInputStream3);
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream2 = null;
                    fileInputStream3 = fileInputStream;
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileInputStream2 = null;
            } catch (IOException e6) {
                e = e6;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
            }
            return true;
        }
        return false;
    }

    public static Bitmap createBitmapFromColors(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return null;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * i;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = iArr[i4 + i5];
                iArr[i4 + i5] = (i6 & (-16711936)) | ((i6 << 16) & 16711680) | ((i6 >> 16) & 255);
            }
        }
        new Matrix().postRotate(180.0f);
        return Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
    }

    public static byte[] cropYuv(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        if (bArr == null || bArr2.length < i * i2) {
            bArr = new byte[i * i2];
        }
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 % 2 == 1) {
                for (int i7 = 0; i7 < i3; i7++) {
                    if (i7 % 2 == 1) {
                        bArr[i5] = bArr2[(i6 * i3) + i7];
                        i5++;
                    }
                }
            }
        }
        return bArr;
    }

    public static void decodeYUV420SP(int[] iArr, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i * i2;
        int i7 = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = 0;
            int i10 = 0;
            int i11 = i7;
            int i12 = 0;
            int i13 = i6 + ((i8 >> 1) * i);
            while (i10 < i) {
                int i14 = (bArr[i11] & 255) - 16;
                int i15 = i14 < 0 ? 0 : i14;
                if ((i10 & 1) == 0) {
                    int i16 = i13 + 1;
                    if (i13 < bArr.length) {
                        i5 = (bArr[i13] & 255) - 128;
                        i3 = (bArr[i13] & 255) - 128;
                        i4 = i16;
                    } else {
                        i5 = i12;
                        i3 = i9;
                        i4 = i16;
                    }
                } else {
                    i3 = i9;
                    i4 = i13;
                    i5 = i12;
                }
                int i17 = i15 * 1192;
                int i18 = i17 + (i5 * 1634);
                int i19 = (i17 - (i5 * 833)) - (i3 * HttpStatus.SC_BAD_REQUEST);
                int i20 = i17 + (i3 * 2066);
                if (i18 < 0) {
                    i18 = 0;
                } else if (i18 > 262143) {
                    i18 = 262143;
                }
                if (i19 < 0) {
                    i19 = 0;
                } else if (i19 > 262143) {
                    i19 = 262143;
                }
                if (i20 < 0) {
                    i20 = 0;
                } else if (i20 > 262143) {
                    i20 = 262143;
                }
                if (i11 < iArr.length) {
                    iArr[i11] = ((i20 << 6) & 16711680) | ViewCompat.MEASURED_STATE_MASK | ((i19 >> 2) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((i18 >> 10) & 255);
                }
                i10++;
                i11++;
                i9 = i3;
                i12 = i5;
                i13 = i4;
            }
            i7 = i11;
        }
    }

    public static void decodeYUV420SPrgb565(int[] iArr, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i * i2;
        int i7 = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = i6 + ((i8 >> 1) * i);
            int i10 = 0;
            int i11 = 0;
            int i12 = i7;
            int i13 = 0;
            while (i11 < i) {
                int i14 = (bArr[i12] & 255) - 16;
                int i15 = i14 < 0 ? 0 : i14;
                if ((i11 & 1) == 0) {
                    int i16 = i9 + 1;
                    i3 = (bArr[i9] & 255) - 128;
                    i4 = (bArr[i16] & 255) - 128;
                    i5 = i16 + 1;
                } else {
                    i3 = i13;
                    i4 = i10;
                    i5 = i9;
                }
                int i17 = i15 * 1192;
                int i18 = i17 + (i3 * 1634);
                int i19 = (i17 - (i3 * 833)) - (i4 * HttpStatus.SC_BAD_REQUEST);
                int i20 = i17 + (i4 * 2066);
                if (i18 < 0) {
                    i18 = 0;
                } else if (i18 > 262143) {
                    i18 = 262143;
                }
                if (i19 < 0) {
                    i19 = 0;
                } else if (i19 > 262143) {
                    i19 = 262143;
                }
                if (i20 < 0) {
                    i20 = 0;
                } else if (i20 > 262143) {
                    i20 = 262143;
                }
                iArr[i12] = ((i20 >> 10) & 255) | ((i19 >> 2) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((i18 << 6) & 16711680) | ViewCompat.MEASURED_STATE_MASK;
                i11++;
                i9 = i5;
                i12++;
                i13 = i3;
                i10 = i4;
            }
            i7 = i12;
        }
    }

    public static void dialPhone(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int dipToPx(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static void enterMarket(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + context.getPackageName()));
        context.startActivity(Intent.createChooser(intent, Res.getString("bdar_sdk_version_update_market_tips")));
    }

    public static String generateVideoName() {
        c = "AR_video_" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".mp4";
        return d + c;
    }

    public static String getDir() {
        return d;
    }

    public static String getFormatterDate() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss.SS").format(new Date());
    }

    public static int getHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT > 12) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            return point.y;
        }
        return defaultDisplay.getHeight();
    }

    public static String getHidePictureUrl() {
        return d + ".AR_Screenshot.jpg";
    }

    public static String getHideVideoUrl() {
        return d + ".AR_video.mp4";
    }

    public static String getPictureUrl() {
        return d + b;
    }

    public static Bitmap getTransparentBitmap(Bitmap bitmap, int i) {
        int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i2 = (i * 255) / 100;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr[i3] = (i2 << 24) | (iArr[i3] & ViewCompat.MEASURED_SIZE_MASK);
        }
        return Bitmap.createBitmap(iArr, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }

    public static String getVideoUrl() {
        generateVideoName();
        return d + c;
    }

    public static int getWidth(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT > 12) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            return point.x;
        }
        return defaultDisplay.getWidth();
    }

    public static Bitmap imageCrop(Bitmap bitmap, int i, int i2, boolean z) {
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            bitmap2 = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - i) / 2, (bitmap.getHeight() - i2) / 2, i, i2, (Matrix) null, false);
            if (z && bitmap != null && !bitmap.equals(bitmap2) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        return bitmap2;
    }

    public static Bitmap imageCrop(Bitmap bitmap, boolean z) {
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width > height ? height : width;
            bitmap2 = Bitmap.createBitmap(bitmap, width > height ? (width - height) / 2 : 0, width > height ? 0 : (height - width) / 2, i, i, (Matrix) null, false);
            if (z && bitmap != null && !bitmap.equals(bitmap2) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        return bitmap2;
    }

    public static boolean isSupportVideoType(String str) {
        String[] strArr = {".mp4"};
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            for (String str2 : strArr) {
                if (str.endsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean isUTF8(String str) {
        if (str != null) {
            try {
                str.getBytes(IoUtils.UTF_8);
                return true;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean needCropSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int min = Math.min(defaultDisplay.getHeight(), defaultDisplay.getWidth());
        int max = Math.max(defaultDisplay.getHeight(), defaultDisplay.getWidth());
        float f = (1.3333334f + 1.7777778f) / 2.0f;
        float f2 = (max * 1.0f) / min;
        ARLog.e("bdar: screenRatio = " + f2);
        if (max * 9 == min * 16) {
            return true;
        }
        if (max * 3 != min * 4 && Float.compare(f2, f) > 0) {
            return true;
        }
        return false;
    }

    public static void openBrowser(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap rawByte2RGBABitmap(int i, int i2, byte[] bArr) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = bArr[(i4 * i) + i5] & 255;
                int i7 = bArr[((i4 >> 1) * i) + i3 + (i5 & (-2)) + 0] & 255;
                int i8 = bArr[((i4 >> 1) * i) + i3 + (i5 & (-2)) + 1] & 255;
                if (i6 < 16) {
                    i6 = 16;
                }
                int round = Math.round((1.164f * (i6 - 16)) + (1.596f * (i8 - 128)));
                int round2 = Math.round(((1.164f * (i6 - 16)) - ((i8 - 128) * 0.813f)) - (0.391f * (i7 - 128)));
                int round3 = Math.round(((i6 - 16) * 1.164f) + ((i7 - 128) * 2.018f));
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = 255;
                }
                if (round2 < 0) {
                    round2 = 0;
                } else if (round2 > 255) {
                    round2 = 255;
                }
                if (round3 < 0) {
                    round3 = 0;
                } else if (round3 > 255) {
                    round3 = 255;
                }
                iArr[(i4 * i) + i5] = (round3 << 16) + ViewCompat.MEASURED_STATE_MASK + (round2 << 8) + round;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    public static Bitmap reversalBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, -1.0f);
        matrix.postTranslate(0.0f, bitmap.getHeight());
        canvas.drawBitmap(bitmap, matrix, new Paint());
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap rotaingImageView(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap && bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmap != null) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static File saveBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        a();
        File file = new File(d, b());
        try {
            file.createNewFile();
            saveBitmap(bitmap, file, 50);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File saveBitmap(Bitmap bitmap, File file, int i) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return file;
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
        return file;
    }

    public static String saveBitmap(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        String str3 = file.getAbsolutePath() + File.separator + str2;
        File file2 = new File(str3);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            file2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveBitmap(bitmap, file2, 50);
        return str3;
    }

    public static String saveBitmap(String str, Bitmap bitmap, int i) {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdir();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            saveBitmap(bitmap, file, i);
            return file.getPath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveToHideFile(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        a();
        File file = new File(d, ".AR_Screenshot.jpg");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveBitmap(bitmap, file, 50);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setScale(-1.0f, 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmap != null) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static void share(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.addFlags(268435456);
            context.startActivity(Intent.createChooser(intent, StatisticConstants.ONCLICK_SHARE_CN));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap transparentBitmap(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAlpha(30);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.save(31);
        canvas.restore();
        if (createBitmap != bitmap && bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
