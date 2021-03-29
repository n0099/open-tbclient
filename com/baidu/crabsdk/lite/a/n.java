package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4740a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4741b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4742c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4743d;

    public static void a(String str, Context context) {
        if (f4740a == null) {
            f4740a = context;
            PackageManager packageManager = context.getPackageManager();
            f4741b = packageManager;
            try {
                f4742c = packageManager.getPackageInfo(f4740a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        return f4740a.getPackageName();
    }

    public static String c() {
        if (f4743d == null) {
            PackageInfo packageInfo = f4742c;
            if (packageInfo == null) {
                return "N/A";
            }
            f4743d = packageInfo.applicationInfo.loadLabel(f4741b).toString();
        }
        return f4743d;
    }

    public static String d() {
        PackageInfo packageInfo = f4742c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }

    public static int e() {
        PackageInfo packageInfo = f4742c;
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }
}
