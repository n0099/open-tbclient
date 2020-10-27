package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes11.dex */
public final class p {
    private static PackageManager aoL;
    private static PackageInfo aoM;
    private static String aoN;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? aoM == null ? "N/A" : aoM.versionName : com.baidu.crabsdk.a.o;
    }

    public static int M() {
        if (aoM == null) {
            return 0;
        }
        return aoM.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aoL = context.getPackageManager();
            try {
                aoM = aoL.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String vo() {
        return mContext.getPackageName();
    }

    public static String vp() {
        if (aoN == null) {
            if (aoM == null) {
                return "N/A";
            }
            aoN = aoM.applicationInfo.loadLabel(aoL).toString();
        }
        return aoN;
    }
}
