package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class p {
    private static PackageManager aoR;
    private static PackageInfo aoS;
    private static String aoT;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? aoS == null ? "N/A" : aoS.versionName : com.baidu.crabsdk.a.o;
    }

    public static int M() {
        if (aoS == null) {
            return 0;
        }
        return aoS.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aoR = context.getPackageManager();
            try {
                aoS = aoR.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String vn() {
        return mContext.getPackageName();
    }

    public static String vo() {
        if (aoT == null) {
            if (aoS == null) {
                return "N/A";
            }
            aoT = aoS.applicationInfo.loadLabel(aoR).toString();
        }
        return aoT;
    }
}
