package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes3.dex */
public final class o {
    private static PackageManager Km;
    private static PackageInfo Kn;
    private static String Ko;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (Ko == null) {
            if (Kn == null) {
                return "N/A";
            }
            Ko = Kn.applicationInfo.loadLabel(Km).toString();
        }
        return Ko;
    }

    public static String H() {
        return Kn == null ? "N/A" : Kn.versionName;
    }

    public static int I() {
        if (Kn == null) {
            return 0;
        }
        return Kn.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            Km = context.getPackageManager();
            try {
                Kn = Km.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }
}
