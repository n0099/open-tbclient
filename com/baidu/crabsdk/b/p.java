package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4843a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4844b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4845c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4846d;

    public static String a() {
        return f4843a.getPackageName();
    }

    public static String b() {
        if (f4846d == null) {
            PackageInfo packageInfo = f4845c;
            if (packageInfo == null) {
                return "N/A";
            }
            f4846d = packageInfo.applicationInfo.loadLabel(f4844b).toString();
        }
        return f4846d;
    }

    public static String c() {
        if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
            PackageInfo packageInfo = f4845c;
            return packageInfo == null ? "N/A" : packageInfo.versionName;
        }
        return com.baidu.crabsdk.a.o;
    }

    public static int d() {
        PackageInfo packageInfo = f4845c;
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }

    public static void e(Context context) {
        if (f4843a == null) {
            f4843a = context;
            PackageManager packageManager = context.getPackageManager();
            f4844b = packageManager;
            try {
                f4845c = packageManager.getPackageInfo(f4843a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e2);
            }
        }
    }
}
