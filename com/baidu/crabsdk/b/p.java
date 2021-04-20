package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4731a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4732b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4733c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4734d;

    public static String a() {
        return f4731a.getPackageName();
    }

    public static String b() {
        if (f4734d == null) {
            PackageInfo packageInfo = f4733c;
            if (packageInfo == null) {
                return "N/A";
            }
            f4734d = packageInfo.applicationInfo.loadLabel(f4732b).toString();
        }
        return f4734d;
    }

    public static String c() {
        if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
            PackageInfo packageInfo = f4733c;
            return packageInfo == null ? "N/A" : packageInfo.versionName;
        }
        return com.baidu.crabsdk.a.o;
    }

    public static int d() {
        PackageInfo packageInfo = f4733c;
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }

    public static void e(Context context) {
        if (f4731a == null) {
            f4731a = context;
            PackageManager packageManager = context.getPackageManager();
            f4732b = packageManager;
            try {
                f4733c = packageManager.getPackageInfo(f4731a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e2);
            }
        }
    }
}
