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
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ServiceManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;
/* loaded from: classes2.dex */
public class PassBiometricUtil {
    public static final String CPU_TYPE_ARM64_V8A = "arm64-v8a";
    public static final String CPU_TYPE_ARMEABI = "armeabi";
    public static final String CPU_TYPE_ARMEABI_V7A = "armeabi-v7a";
    public static final String CPU_TYPE_X86 = "x86";

    /* renamed from: a  reason: collision with root package name */
    public static final String f9120a = "PassBiometricUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final int f9121b = 480;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9122c = 480;

    /* renamed from: d  reason: collision with root package name */
    public static final int f9123d = 192;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9124e = 480;

    /* renamed from: f  reason: collision with root package name */
    public static final int f9125f = 620;

    /* renamed from: g  reason: collision with root package name */
    public static final int f9126g = 250;

    /* renamed from: h  reason: collision with root package name */
    public static final int f9127h = 250;
    public static final int i = 728;
    public static final int j = 194;
    public static final int k = 750;
    public static final int l = 1335;

    public static Rect a(int[] iArr) {
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
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getClientId(Context context) {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (confignation == null || !confignation.isAgreeDangerousProtocol()) {
            return null;
        }
        try {
            return DeviceId.getDeviceID(context);
        } catch (Throwable unused) {
            return "123456789";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a6 A[Catch: IOException -> 0x01a2, TRY_LEAVE, TryCatch #8 {IOException -> 0x01a2, blocks: (B:81:0x019e, B:85:0x01a6), top: B:96:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuType() {
        ?? r1;
        BufferedReader bufferedReader;
        FileReader fileReader;
        String str;
        String str2;
        String[] strArr = {"", ""};
        FileReader fileReader2 = null;
        try {
            try {
                fileReader = new FileReader("/proc/cpuinfo");
            } catch (Throwable th) {
                th = th;
                fileReader2 = "/proc/cpuinfo";
            }
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    String[] split = readLine.split("\\s+");
                    Log.d(f9120a, "getCpuType()str2:" + readLine);
                    for (int i2 = 2; i2 < split.length; i2++) {
                        strArr[0] = strArr[0] + split[i2] + " ";
                    }
                    String readLine2 = bufferedReader.readLine();
                    Log.d(f9120a, "getCpuType()str2" + readLine2);
                    String[] split2 = readLine2.split("\\s+");
                    strArr[1] = strArr[1] + split2[2];
                    try {
                        fileReader.close();
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    str = Build.CPU_ABI;
                    if (Build.VERSION.SDK_INT >= 8) {
                    }
                    str2 = "none";
                    Log.i(f9120a, "getCpuType()" + strArr[0] + strArr[1] + str + str2);
                    if (str.equals("armeabi")) {
                    }
                }
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                r1 = fileReader2;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        throw th;
                    }
                }
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            bufferedReader = null;
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            r1 = 0;
            if (fileReader2 != null) {
            }
            if (r1 != 0) {
            }
            throw th;
        }
        str = Build.CPU_ABI;
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                str2 = (String) Build.class.getDeclaredField("cpuAbi2").get(null);
            } catch (Exception e8) {
                Log.w(f9120a, "getCpuType() abi2" + e8.toString());
            }
            Log.i(f9120a, "getCpuType()" + strArr[0] + strArr[1] + str + str2);
            return (!str.equals("armeabi") || str2.equals("armeabi")) ? "armeabi" : (str.equals("armeabi-v7a") || str2.equals("armeabi-v7a")) ? "armeabi-v7a" : (str.equals("arm64-v8a") || str2.equals("arm64-v8a")) ? "arm64-v8a" : (str.equals("x86") || str2.equals("x86")) ? "x86" : strArr[0].toLowerCase().contains("armv7") ? "armeabi-v7a" : strArr[0].toLowerCase().contains("arm") ? "armeabi" : strArr[0].toLowerCase().contains("arm64") ? "arm64-v8a" : strArr[0].toLowerCase().contains("x86") ? "x86" : "armeabi";
        }
        str2 = "none";
        Log.i(f9120a, "getCpuType()" + strArr[0] + strArr[1] + str + str2);
        if (str.equals("armeabi")) {
        }
    }

    public static Rect getFaceInsideRoundRect(int[] iArr) {
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
        return "pass_bio-p-android-p-" + str + "-p-" + getVersionCode(context) + "-p-" + PassBiometricDefaultFactory.VERSION_NAME + "-p-" + getOSModel() + "-p-" + getOSVersion();
    }

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
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
        if (iArr2 != null && iArr2.length == 2) {
            Rect a2 = a(iArr);
            if (a2.right - a2.left < (iArr2[0] * 192) / 750) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTooNearFromCamera(int[] iArr, int[] iArr2) {
        if (iArr2 != null && iArr2.length == 2) {
            Rect a2 = a(iArr);
            if (a2.right - a2.left > (iArr2[0] * 480) / 750) {
                return true;
            }
        }
        return false;
    }
}
