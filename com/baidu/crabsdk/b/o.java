package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes2.dex */
public final class o {
    private static PackageManager SY;
    private static PackageInfo SZ;
    private static String bq;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (bq == null) {
            if (SZ == null) {
                return "N/A";
            }
            bq = SZ.applicationInfo.loadLabel(SY).toString();
        }
        return bq;
    }

    public static String H() {
        return SZ == null ? "N/A" : SZ.versionName;
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            SY = context.getPackageManager();
            try {
                SZ = SY.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.b("PackageCollector.init fail.", e);
            }
        }
    }

    public static int pb() {
        if (SZ == null) {
            return 0;
        }
        return SZ.versionCode;
    }
}
