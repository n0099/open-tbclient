package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes2.dex */
public final class o {
    private static PackageManager SX;
    private static PackageInfo SY;
    private static String bq;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (bq == null) {
            if (SY == null) {
                return "N/A";
            }
            bq = SY.applicationInfo.loadLabel(SX).toString();
        }
        return bq;
    }

    public static String H() {
        return SY == null ? "N/A" : SY.versionName;
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            SX = context.getPackageManager();
            try {
                SY = SX.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.b("PackageCollector.init fail.", e);
            }
        }
    }

    public static int pc() {
        if (SY == null) {
            return 0;
        }
        return SY.versionCode;
    }
}
