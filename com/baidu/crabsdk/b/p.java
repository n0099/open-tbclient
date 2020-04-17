package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class p {
    private static PackageManager aku;
    private static PackageInfo akv;
    private static String akw;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? akv == null ? "N/A" : akv.versionName : com.baidu.crabsdk.a.o;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aku = context.getPackageManager();
            try {
                akv = aku.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }

    public static String sC() {
        return mContext.getPackageName();
    }

    public static String sD() {
        if (akw == null) {
            if (akv == null) {
                return "N/A";
            }
            akw = akv.applicationInfo.loadLabel(aku).toString();
        }
        return akw;
    }

    public static int sE() {
        if (akv == null) {
            return 0;
        }
        return akv.versionCode;
    }
}
