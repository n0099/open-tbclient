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
import com.baidu.pass.biometrics.base.PassBiometricDefaultFactory;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.common.SecurityUtil;
import java.util.UUID;
/* loaded from: classes2.dex */
public class PassBiometricUtil {
    public static final String CPU_TYPE_ARM64_V8A = "arm64-v8a";
    public static final String CPU_TYPE_ARMEABI = "armeabi";
    public static final String CPU_TYPE_ARMEABI_V7A = "armeabi-v7a";
    public static final String CPU_TYPE_X86 = "x86";

    /* renamed from: a  reason: collision with root package name */
    public static final String f9038a = "PassBiometricUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final int f9039b = 480;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9040c = 480;

    /* renamed from: d  reason: collision with root package name */
    public static final int f9041d = 192;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9042e = 480;

    /* renamed from: f  reason: collision with root package name */
    public static final int f9043f = 620;

    /* renamed from: g  reason: collision with root package name */
    public static final int f9044g = 250;

    /* renamed from: h  reason: collision with root package name */
    public static final int f9045h = 250;

    /* renamed from: i  reason: collision with root package name */
    public static final int f9046i = 728;
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
