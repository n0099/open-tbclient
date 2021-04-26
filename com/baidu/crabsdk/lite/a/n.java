package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4888a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4889b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4890c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4891d;

    public static void a(String str, Context context) {
        if (f4888a == null) {
            f4888a = context;
            PackageManager packageManager = context.getPackageManager();
            f4889b = packageManager;
            try {
                f4890c = packageManager.getPackageInfo(f4888a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        return f4888a.getPackageName();
    }

    public static String c() {
        if (f4891d == null) {
            PackageInfo packageInfo = f4890c;
            if (packageInfo == null) {
                return "N/A";
            }
            f4891d = packageInfo.applicationInfo.loadLabel(f4889b).toString();
        }
        return f4891d;
    }

    public static String d() {
        PackageInfo packageInfo = f4890c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }

    public static int e() {
        PackageInfo packageInfo = f4890c;
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }
}
