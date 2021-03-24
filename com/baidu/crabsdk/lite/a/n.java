package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4739a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4740b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4741c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4742d;

    public static void a(String str, Context context) {
        if (f4739a == null) {
            f4739a = context;
            PackageManager packageManager = context.getPackageManager();
            f4740b = packageManager;
            try {
                f4741c = packageManager.getPackageInfo(f4739a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        return f4739a.getPackageName();
    }

    public static String c() {
        if (f4742d == null) {
            PackageInfo packageInfo = f4741c;
            if (packageInfo == null) {
                return "N/A";
            }
            f4742d = packageInfo.applicationInfo.loadLabel(f4740b).toString();
        }
        return f4742d;
    }

    public static String d() {
        PackageInfo packageInfo = f4741c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }

    public static int e() {
        PackageInfo packageInfo = f4741c;
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }
}
