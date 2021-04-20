package com.baidu.fsg.face.base.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.util.DeviceId;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Random;
import java.util.UUID;
import org.apache.http.conn.util.InetAddressUtils;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5656a = "armeabi";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5657b = "armeabi-v7a";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5658c = "x86";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5659d = "arm64-v8a";

    /* renamed from: e  reason: collision with root package name */
    public static final int f5660e = 480;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5661f = 480;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5662g = 192;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5663h = 480;
    public static final int i = 620;
    public static final int j = 728;
    public static final int k = 750;
    public static final int l = 1335;
    public static final String m = "SapiBiometricUtil";

    public static void a(int[] iArr, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint paint = new Paint();
        paint.setStrokeWidth(4.0f);
        paint.setColor(-16711936);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        paint.setColor(-16711936);
        for (int i2 = 0; i2 < iArr.length / 2; i2++) {
            int i3 = i2 << 1;
            canvas.drawCircle(iArr[i3], iArr[i3 + 1], 2.0f, paint);
        }
        Rect b2 = b(iArr);
        canvas.drawRect(b2, paint);
        Point point = new Point();
        point.set(b2.centerX(), b2.centerY());
        paint.setColor(-65536);
        canvas.drawCircle(point.x, point.y, 5.0f, paint);
        canvas.drawRect(a(new int[]{bitmap.getWidth(), bitmap.getHeight()}), paint);
        Point point2 = new Point();
        point2.set(bitmap.getWidth() / 2, (bitmap.getHeight() * 728) / 1335);
        paint.setColor(-65536);
        canvas.drawCircle(point2.x, point2.y, 5.0f, paint);
        int width = ((bitmap.getWidth() * 480) / 750) / 2;
        int i4 = point2.x;
        int i5 = point2.y;
        canvas.drawRect(i4 - width, i5 - width, i4 + width, i5 + width, paint);
        int width2 = ((bitmap.getWidth() * 192) / 750) / 2;
        int i6 = point2.x;
        int i7 = point2.y;
        canvas.drawRect(i6 - width2, i7 - width2, i6 + width2, i7 + width2, paint);
    }

    public static boolean a(Context context, String str, String str2) {
        return false;
    }

    public static boolean b(int[] iArr, Bitmap bitmap) {
        if (bitmap != null) {
            Rect b2 = b(iArr);
            return a(bitmap).contains(b2.centerX(), b2.centerY());
        }
        return false;
    }

    public static boolean c(int[] iArr, int[] iArr2) {
        if (iArr2 != null && iArr2.length == 2) {
            Rect b2 = b(iArr);
            if (b2.right - b2.left < (iArr2[0] * 192) / 750) {
                return true;
            }
        }
        return false;
    }

    public static int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String e() {
        return "";
    }

    public static String e(Context context) {
        try {
            return DeviceId.getDeviceID(context);
        } catch (Throwable unused) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            return "123456789" + MD5Util.toMd5(String.valueOf(random.nextInt(100)).getBytes(), false);
        }
    }

    public static NetworkInfo f(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            Log.w("getActiveNetworkInfo", " getActiveNetworkInfo NullPointerException--- \n" + e2.getMessage());
            return null;
        }
    }

    public static boolean g(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = f(context);
        } catch (NullPointerException e2) {
            Log.w("getActiveNetworkInfo", " getActiveNetworkInfo NullPointerException--- \n" + e2.getMessage());
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.getType() == 1;
    }

    public static boolean b(int[] iArr, int[] iArr2) {
        if (iArr2 != null && iArr2.length == 2) {
            Rect b2 = b(iArr);
            if (b2.right - b2.left > (iArr2[0] * 480) / 750) {
                return true;
            }
        }
        return false;
    }

    public static int d(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static String c(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d() {
        String uuid = UUID.randomUUID().toString();
        return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
    }

    public static Rect b(int[] iArr) {
        Point point = new Point();
        Point point2 = new Point();
        if (iArr.length > 2) {
            point.x = iArr[0];
            point.y = iArr[1];
            point2.x = iArr[0];
            point2.y = iArr[1];
        }
        for (int i2 = 0; i2 < iArr.length / 2; i2++) {
            int i3 = i2 << 1;
            float f2 = iArr[i3];
            float f3 = iArr[i3 + 1];
            if (f2 < point.x) {
                point.x = (int) f2;
            }
            if (f3 < point.y) {
                point.y = (int) f3;
            }
            if (f2 > point2.x) {
                point2.x = (int) f2;
            }
            if (f3 > point2.y) {
                point2.y = (int) f3;
            }
        }
        return new Rect(point.x, point.y, point2.x, point2.y);
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static String c() {
        String hostAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (hostAddress = nextElement.getHostAddress()) != null && hostAddress.length() > 0 && InetAddressUtils.isIPv4Address(hostAddress)) {
                        return hostAddress;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            d.a(th);
            return "0";
        }
    }

    public static Rect a(Bitmap bitmap) {
        int width = ((bitmap.getWidth() * 480) / 750) / 2;
        Point point = new Point();
        point.set(bitmap.getWidth() / 2, (bitmap.getHeight() * 728) / 1335);
        int i2 = point.x;
        int i3 = point.y;
        return new Rect(i2 - width, i3 - width, i2 + width, i3 + width);
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String b() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "-1";
    }

    public static void b(Bitmap bitmap) {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                File file = new File(externalStorageDirectory.getAbsolutePath() + "/awe");
                file.mkdirs();
                File file2 = new File(file, String.format("%d.jpg", Long.valueOf(System.currentTimeMillis())));
                if (file2.exists()) {
                    file2.delete();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static Rect a(int[] iArr) {
        if (iArr != null && iArr.length == 2) {
            int i2 = ((iArr[0] * 480) / 750) / 2;
            int i3 = ((iArr[1] * 620) / 1335) / 2;
            Point point = new Point();
            point.set(iArr[0] / 2, (iArr[1] * 728) / 1335);
            int i4 = point.x;
            int i5 = point.y;
            return new Rect(i4 - i2, i5 - i3, i4 + i2, i5 + i3);
        }
        return new Rect(0, 0, 0, 0);
    }

    public static boolean a(int[] iArr, int[] iArr2) {
        if (iArr2 == null || iArr2.length != 2) {
            return false;
        }
        Rect b2 = b(iArr);
        Rect a2 = a(iArr2);
        return a2.bottom > b2.bottom && a2.top < b2.top;
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i3 || i5 > i2) {
            int round = Math.round(i4 / i3);
            int round2 = Math.round(i5 / i2);
            return round < round2 ? round : round2;
        }
        return 1;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static String a(String str, Context context) {
        return str + "-" + d(context) + "-Android-sapi_bio-" + com.baidu.fsg.face.base.c.f5627a;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String a() {
        return !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "-1";
    }

    public static String a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            return packageInfo.signatures.length > 0 ? MD5Util.toMd5(packageInfo.signatures[0].toByteArray(), false) : "";
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static double a(int i2, int i3) {
        return new BigDecimal(Double.toString(i2)).divide(new BigDecimal(Double.toString(i3)), 10, 4).doubleValue();
    }
}
