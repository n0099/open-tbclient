package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class p {
    private static PackageManager apJ;
    private static PackageInfo apK;
    private static String apL;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? apK == null ? "N/A" : apK.versionName : com.baidu.crabsdk.a.o;
    }

    public static int M() {
        if (apK == null) {
            return 0;
        }
        return apK.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            apJ = context.getPackageManager();
            try {
                apK = apJ.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String vc() {
        return mContext.getPackageName();
    }

    public static String vd() {
        if (apL == null) {
            if (apK == null) {
                return "N/A";
            }
            apL = apK.applicationInfo.loadLabel(apJ).toString();
        }
        return apL;
    }
}
