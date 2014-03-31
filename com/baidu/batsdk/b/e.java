package com.baidu.batsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
public final class e {
    private static Context a;
    private static PackageManager b;
    private static PackageInfo c;
    private static String d;

    public static void a(Context context) {
        if (a == null) {
            a = context;
            b = context.getPackageManager();
            try {
                c = b.getPackageInfo(a.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.batsdk.f.a.b("PackageCollector.init fail.", e);
            }
        }
    }

    public static String a() {
        return a.getPackageName();
    }

    public static String b() {
        if (d == null) {
            if (c == null) {
                return "N/A";
            }
            d = c.applicationInfo.loadLabel(b).toString();
        }
        return d;
    }

    public static String c() {
        return c == null ? "N/A" : c.versionName;
    }

    public static int d() {
        if (c == null) {
            return 0;
        }
        return c.versionCode;
    }

    public static String e() {
        StringBuilder sb = new StringBuilder();
        for (PackageInfo packageInfo : b.getInstalledPackages(0)) {
            sb.append(packageInfo.applicationInfo.loadLabel(b)).append("\t").append(packageInfo.packageName).append("\t").append(packageInfo.versionName).append("\tflag(").append(packageInfo.applicationInfo.flags).append(")\n");
        }
        return sb.toString();
    }
}
