package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes6.dex */
public final class o {
    private static PackageManager Yv;
    private static PackageInfo Yw;
    private static String Yx;
    private static Context mContext;

    public static String G() {
        return mContext.getPackageName();
    }

    public static String H() {
        if (Yx == null) {
            if (Yw == null) {
                return "N/A";
            }
            Yx = Yw.applicationInfo.loadLabel(Yv).toString();
        }
        return Yx;
    }

    public static String I() {
        return Yw == null ? "N/A" : Yw.versionName;
    }

    public static int J() {
        if (Yw == null) {
            return 0;
        }
        return Yw.versionCode;
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            Yv = context.getPackageManager();
            try {
                Yw = Yv.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }
}
