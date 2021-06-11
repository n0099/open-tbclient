package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4684a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4685b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4686c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4687d;

    public static void a(String str, Context context) {
        if (f4684a == null) {
            f4684a = context;
            PackageManager packageManager = context.getPackageManager();
            f4685b = packageManager;
            try {
                f4686c = packageManager.getPackageInfo(f4684a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        return f4684a.getPackageName();
    }

    public static String c() {
        if (f4687d == null) {
            PackageInfo packageInfo = f4686c;
            if (packageInfo == null) {
                return "N/A";
            }
            f4687d = packageInfo.applicationInfo.loadLabel(f4685b).toString();
        }
        return f4687d;
    }

    public static String d() {
        PackageInfo packageInfo = f4686c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }

    public static int e() {
        PackageInfo packageInfo = f4686c;
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }
}
