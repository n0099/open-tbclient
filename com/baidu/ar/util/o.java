package com.baidu.ar.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.view.ViewCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public final class o {
    private static int b;
    private static String c;
    private static String d;
    private static final String a = o.class.getName();
    private static String e = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + "/camera/";

    public static int a() {
        return b;
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static Bitmap a(int i, int i2, byte[] bArr) {
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

    public static Bitmap a(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap && bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap a(int[] iArr, int i, int i2) {
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
        return Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
    }

    public static File a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        g();
        File file = new File(e, h());
        try {
            file.createNewFile();
            a(bitmap, file);
            return file;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(Bitmap bitmap, File file) {
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
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
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
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
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

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void a(int i) {
        b = i;
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void a(Context context, File file) {
        if (context == null || file == null || !file.isFile()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    public static void a(Context context, String str) {
        if (f.c(context)) {
            Intent intent = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("link_info", "{\"type\":\"4\",\"fParam\":\"@linkinfotest\",\"url\":\"" + str + "\"}");
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x00b7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x00bf */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(File file, File file2, Boolean bool) {
        ?? canRead;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream2 = null;
        if (file.exists() && file.isFile() && (canRead = file.canRead()) != 0) {
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (file2.exists() && bool.booleanValue()) {
                file2.delete();
            }
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                canRead = 0;
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                canRead = 0;
                fileInputStream = null;
            }
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    fileInputStream2 = fileInputStream;
                    canRead = fileOutputStream;
                    try {
                        e.printStackTrace();
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (canRead != 0) {
                            try {
                                canRead.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        return true;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (canRead != 0) {
                            try {
                                canRead.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    return true;
                }
            } catch (FileNotFoundException e14) {
                e = e14;
                canRead = 0;
                fileInputStream2 = fileInputStream;
            } catch (IOException e15) {
                e = e15;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                canRead = 0;
                if (fileInputStream != null) {
                }
                if (canRead != 0) {
                }
                throw th;
            }
            return true;
        }
        return false;
    }

    public static String b() {
        return e + c;
    }

    public static void b(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        g();
        File file = new File(e, ".AR_Screenshot.jpg");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        a(bitmap, file);
    }

    public static Bitmap c(Bitmap bitmap) {
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

    public static String c() {
        return e + ".AR_Screenshot.jpg";
    }

    public static String d() {
        d = "AR_video_" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".mp4";
        return e + d;
    }

    public static String e() {
        return e + ".AR_video.mp4";
    }

    public static boolean f() {
        File file = new File(e());
        return file.exists() && file.isFile();
    }

    private static void g() {
        File file = new File(e);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private static String h() {
        c = "AR_Screenshot_" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".jpg";
        return c;
    }
}
