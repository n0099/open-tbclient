package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class p {
    private static PackageManager aoK;
    private static PackageInfo aoL;
    private static String aoM;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? aoL == null ? "N/A" : aoL.versionName : com.baidu.crabsdk.a.o;
    }

    public static int M() {
        if (aoL == null) {
            return 0;
        }
        return aoL.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aoK = context.getPackageManager();
            try {
                aoL = aoK.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String vo() {
        return mContext.getPackageName();
    }

    public static String vp() {
        if (aoM == null) {
            if (aoL == null) {
                return "N/A";
            }
            aoM = aoL.applicationInfo.loadLabel(aoK).toString();
        }
        return aoM;
    }
}
