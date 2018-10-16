package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes6.dex */
public final class o {
    private static PackageManager Ym;
    private static PackageInfo Yn;
    private static String Yo;
    private static Context mContext;

    public static String G() {
        return mContext.getPackageName();
    }

    public static String H() {
        if (Yo == null) {
            if (Yn == null) {
                return "N/A";
            }
            Yo = Yn.applicationInfo.loadLabel(Ym).toString();
        }
        return Yo;
    }

    public static String I() {
        return Yn == null ? "N/A" : Yn.versionName;
    }

    public static int J() {
        if (Yn == null) {
            return 0;
        }
        return Yn.versionCode;
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            Ym = context.getPackageManager();
            try {
                Yn = Ym.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }
}
