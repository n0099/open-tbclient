package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes2.dex */
public final class o {
    private static PackageManager Ta;
    private static PackageInfo Tb;
    private static String bq;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (bq == null) {
            if (Tb == null) {
                return "N/A";
            }
            bq = Tb.applicationInfo.loadLabel(Ta).toString();
        }
        return bq;
    }

    public static String H() {
        return Tb == null ? "N/A" : Tb.versionName;
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            Ta = context.getPackageManager();
            try {
                Tb = Ta.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.b("PackageCollector.init fail.", e);
            }
        }
    }

    public static int pb() {
        if (Tb == null) {
            return 0;
        }
        return Tb.versionCode;
    }
}
