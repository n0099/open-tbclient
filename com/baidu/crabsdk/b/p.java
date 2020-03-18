package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class p {
    private static PackageManager Sb;
    private static PackageInfo Sc;
    private static String Se;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? Sc == null ? "N/A" : Sc.versionName : com.baidu.crabsdk.a.o;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            Sb = context.getPackageManager();
            try {
                Sc = Sb.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }

    public static String oi() {
        return mContext.getPackageName();
    }

    public static String oj() {
        if (Se == null) {
            if (Sc == null) {
                return "N/A";
            }
            Se = Sc.applicationInfo.loadLabel(Sb).toString();
        }
        return Se;
    }

    public static int ok() {
        if (Sc == null) {
            return 0;
        }
        return Sc.versionCode;
    }
}
