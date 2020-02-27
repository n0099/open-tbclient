package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes8.dex */
public final class o {
    private static PackageManager RZ;
    private static PackageInfo Sa;
    private static String Sb;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (Sb == null) {
            if (Sa == null) {
                return "N/A";
            }
            Sb = Sa.applicationInfo.loadLabel(RZ).toString();
        }
        return Sb;
    }

    public static String H() {
        return Sa == null ? "N/A" : Sa.versionName;
    }

    public static int I() {
        if (Sa == null) {
            return 0;
        }
        return Sa.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            RZ = context.getPackageManager();
            try {
                Sa = RZ.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }
}
