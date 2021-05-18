package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4742a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f4743b;

    /* renamed from: c  reason: collision with root package name */
    public static PackageInfo f4744c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4745d;

    public static void a(String str, Context context) {
        if (f4742a == null) {
            f4742a = context;
            PackageManager packageManager = context.getPackageManager();
            f4743b = packageManager;
            try {
                f4744c = packageManager.getPackageInfo(f4742a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "PackageCollector.init fail.", e2);
            }
        }
    }

    public static String b() {
        return f4742a.getPackageName();
    }

    public static String c() {
        if (f4745d == null) {
            PackageInfo packageInfo = f4744c;
            if (packageInfo == null) {
                return "N/A";
            }
            f4745d = packageInfo.applicationInfo.loadLabel(f4743b).toString();
        }
        return f4745d;
    }

    public static String d() {
        PackageInfo packageInfo = f4744c;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }

    public static int e() {
        PackageInfo packageInfo = f4744c;
        if (packageInfo == null) {
            return 0;
        }
        return packageInfo.versionCode;
    }
}
