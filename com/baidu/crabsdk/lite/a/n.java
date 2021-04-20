package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4775a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4776b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4777c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4778d;

    public static void a(String str, Context context) {
        if (f4775a == null) {
            f4775a = context;
            PackageManager packageManager = context.getPackageManager();
            f4776b = packageManager;
            try {
                f4777c = packageManager.getPackageInfo(f4775a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        return f4775a.getPackageName();
    }

    public static String c() {
        if (f4778d == null) {
            PackageInfo packageInfo = f4777c;
            if (packageInfo == null) {
                return "N/A";
            }
            f4778d = packageInfo.applicationInfo.loadLabel(f4776b).toString();
        }
        return f4778d;
    }

    public static String d() {
        PackageInfo packageInfo = f4777c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }

    public static int e() {
        PackageInfo packageInfo = f4777c;
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }
}
