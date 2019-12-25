package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes5.dex */
public final class o {
    private static PackageManager Qp;
    private static PackageInfo Qq;
    private static String Qr;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (Qr == null) {
            if (Qq == null) {
                return "N/A";
            }
            Qr = Qq.applicationInfo.loadLabel(Qp).toString();
        }
        return Qr;
    }

    public static String H() {
        return Qq == null ? "N/A" : Qq.versionName;
    }

    public static int I() {
        if (Qq == null) {
            return 0;
        }
        return Qq.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            Qp = context.getPackageManager();
            try {
                Qq = Qp.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }
}
