package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes2.dex */
public final class o {
    private static PackageManager VA;
    private static PackageInfo VB;
    private static String bq;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (bq == null) {
            if (VB == null) {
                return "N/A";
            }
            bq = VB.applicationInfo.loadLabel(VA).toString();
        }
        return bq;
    }

    public static String H() {
        return VB == null ? "N/A" : VB.versionName;
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            VA = context.getPackageManager();
            try {
                VB = VA.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }

    public static int qi() {
        if (VB == null) {
            return 0;
        }
        return VB.versionCode;
    }
}
