package com.baidu.pass.biometrics.base.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.pass.biometrics.base.PassBiometricDefaultFactory;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.common.SecurityUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;
/* loaded from: classes11.dex */
public class PassBiometricUtil {
    public static final String CPU_TYPE_ARM64_V8A = "arm64-v8a";
    public static final String CPU_TYPE_ARMEABI = "armeabi";
    public static final String CPU_TYPE_ARMEABI_V7A = "armeabi-v7a";
    public static final String CPU_TYPE_X86 = "x86";

    /* renamed from: a  reason: collision with root package name */
    private static final String f2712a = "PassBiometricUtil";
    static final int b = 480;
    static final int c = 480;
    static final int d = 192;
    static final int e = 480;
    static final int f = 620;
    static final int g = 728;
    static final int h = 750;
    static final int i = 1335;

    private static Rect a(int[] iArr) {
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

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i3 || i5 > i2) {
            int round = Math.round(i4 / i3);
            int round2 = Math.round(i5 / i2);
            return round < round2 ? round : round2;
        }
        return 1;
    }

    @TargetApi(23)
    public static boolean checkRequestPermission(Context context, String str) {
        return (Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission(str) == 0) || (Build.VERSION.SDK_INT < 23 && context.checkCallingOrSelfPermission(str) == 0);
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getClientId(Context context) {
        try {
            return DeviceId.getDeviceID(context);
        } catch (Throwable th) {
            return "123456789";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [15=4, 32=6] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0127 A[Catch: IOException -> 0x020d, TRY_LEAVE, TryCatch #6 {IOException -> 0x020d, blocks: (B:41:0x0122, B:43:0x0127), top: B:103:0x0122 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuType() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        String str;
        String str2;
        String readLine;
        BufferedReader bufferedReader2 = null;
        String[] strArr = {"", ""};
        try {
            fileReader = new FileReader("/proc/cpuinfo");
        } catch (IOException e2) {
            e = e2;
            fileReader = null;
            bufferedReader = null;
        } catch (Throwable th2) {
            fileReader = null;
            th = th2;
        }
        try {
            bufferedReader = new BufferedReader(fileReader, 8192);
            try {
                try {
                    String readLine2 = bufferedReader.readLine();
                    String[] split = readLine2.split("\\s+");
                    Object[] objArr = new Object[1];
                    objArr[0] = "getCpuType()str2:" + readLine2;
                    Log.d(f2712a, objArr);
                    for (int i2 = 2; i2 < split.length; i2++) {
                        strArr[0] = strArr[0] + split[i2] + " ";
                    }
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = "getCpuType()str2" + bufferedReader.readLine();
                    Log.d(f2712a, objArr2);
                    strArr[1] = strArr[1] + readLine.split("\\s+")[2];
                    try {
                        fileReader.close();
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    str = Build.CPU_ABI;
                    if (Build.VERSION.SDK_INT >= 8) {
                    }
                    str2 = "none";
                    Log.i(f2712a, "getCpuType()" + strArr[0] + strArr[1] + str + str2);
                    if (str.equals("armeabi")) {
                    }
                }
            } catch (Throwable th3) {
                bufferedReader2 = bufferedReader;
                th = th3;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        throw th;
                    }
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            if (fileReader != null) {
            }
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        str = Build.CPU_ABI;
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                str2 = (String) Build.class.getDeclaredField("cpuAbi2").get(null);
            } catch (Exception e8) {
                Log.w(f2712a, "getCpuType() abi2" + e8.toString());
            }
            Log.i(f2712a, "getCpuType()" + strArr[0] + strArr[1] + str + str2);
            return (!str.equals("armeabi") || str2.equals("armeabi")) ? "armeabi" : (str.equals("armeabi-v7a") || str2.equals("armeabi-v7a")) ? "armeabi-v7a" : (str.equals("arm64-v8a") || str2.equals("arm64-v8a")) ? "arm64-v8a" : (str.equals("x86") || str2.equals("x86")) ? "x86" : strArr[0].toLowerCase().contains("armv7") ? "armeabi-v7a" : strArr[0].toLowerCase().contains("arm") ? "armeabi" : strArr[0].toLowerCase().contains("arm64") ? "arm64-v8a" : strArr[0].toLowerCase().contains("x86") ? "x86" : "armeabi";
        }
        str2 = "none";
        Log.i(f2712a, "getCpuType()" + strArr[0] + strArr[1] + str + str2);
        if (str.equals("armeabi")) {
        }
    }

    public static Rect getFaceInsideRoundRect(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return new Rect(0, 0, 0, 0);
        }
        int i2 = ((iArr[0] * 480) / 750) / 2;
        int i3 = ((iArr[1] * f) / i) / 2;
        Point point = new Point();
        point.set(iArr[0] / 2, (iArr[1] * g) / i);
        int i4 = point.x;
        int i5 = point.y;
        return new Rect(i4 - i2, i5 - i3, i2 + i4, i3 + i5);
    }

    public static String getOSModel() {
        return !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "-1";
    }

    public static String getOSVersion() {
        return !TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "-1";
    }

    public static String getPackageSign(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            return packageInfo.signatures.length > 0 ? SecurityUtil.md5(packageInfo.signatures[0].toByteArray(), false) : "";
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    public static String getUA(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("pass_bio").append("-p-");
        sb.append("android").append("-p-");
        sb.append(str).append("-p-");
        sb.append(getVersionCode(context)).append("-p-");
        sb.append(PassBiometricDefaultFactory.VERSION_NAME).append("-p-");
        sb.append(getOSModel()).append("-p-");
        sb.append(getOSVersion());
        return sb.toString();
    }

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return !TextUtils.isEmpty(uuid) ? uuid.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") : uuid;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            return 0;
        }
    }

    public static boolean isFaceInsideRound(int[] iArr, int[] iArr2) {
        if (iArr2 == null || iArr2.length != 2) {
            return false;
        }
        Rect a2 = a(iArr);
        Rect faceInsideRoundRect = getFaceInsideRoundRect(iArr2);
        return faceInsideRoundRect.bottom > a2.bottom && faceInsideRoundRect.top < a2.top;
    }

    public static boolean isTooFarFromCamera(int[] iArr, int[] iArr2) {
        if (iArr2 == null || iArr2.length != 2) {
            return false;
        }
        Rect a2 = a(iArr);
        return a2.right - a2.left < (iArr2[0] * 192) / 750;
    }

    public static boolean isTooNearFromCamera(int[] iArr, int[] iArr2) {
        if (iArr2 == null || iArr2.length != 2) {
            return false;
        }
        Rect a2 = a(iArr);
        return a2.right - a2.left > (iArr2[0] * 480) / 750;
    }
}
