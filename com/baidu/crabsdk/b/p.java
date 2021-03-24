package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4695a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4696b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4697c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4698d;

    public static String a() {
        return f4695a.getPackageName();
    }

    public static String b() {
        if (f4698d == null) {
            PackageInfo packageInfo = f4697c;
            if (packageInfo == null) {
                return "N/A";
            }
            f4698d = packageInfo.applicationInfo.loadLabel(f4696b).toString();
        }
        return f4698d;
    }

    public static String c() {
        if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
            PackageInfo packageInfo = f4697c;
            return packageInfo == null ? "N/A" : packageInfo.versionName;
        }
        return com.baidu.crabsdk.a.o;
    }

    public static int d() {
        PackageInfo packageInfo = f4697c;
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }

    public static void e(Context context) {
        if (f4695a == null) {
            f4695a = context;
            PackageManager packageManager = context.getPackageManager();
            f4696b = packageManager;
            try {
                f4697c = packageManager.getPackageInfo(f4695a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e2);
            }
        }
    }
}
