package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes3.dex */
public final class o {
    private static PackageManager JM;
    private static PackageInfo JN;
    private static String JO;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (JO == null) {
            if (JN == null) {
                return "N/A";
            }
            JO = JN.applicationInfo.loadLabel(JM).toString();
        }
        return JO;
    }

    public static String H() {
        return JN == null ? "N/A" : JN.versionName;
    }

    public static int I() {
        if (JN == null) {
            return 0;
        }
        return JN.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            JM = context.getPackageManager();
            try {
                JN = JM.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }
}
