package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class p {
    private static PackageManager akA;
    private static PackageInfo akB;
    private static String akC;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? akB == null ? "N/A" : akB.versionName : com.baidu.crabsdk.a.o;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            akA = context.getPackageManager();
            try {
                akB = akA.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String sB() {
        return mContext.getPackageName();
    }

    public static String sC() {
        if (akC == null) {
            if (akB == null) {
                return "N/A";
            }
            akC = akB.applicationInfo.loadLabel(akA).toString();
        }
        return akC;
    }

    public static int sD() {
        if (akB == null) {
            return 0;
        }
        return akB.versionCode;
    }
}
