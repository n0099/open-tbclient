package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class p {
    private static PackageManager alg;
    private static PackageInfo alh;
    private static String ali;
    private static Context mContext;

    public static String J() {
        return mContext.getPackageName();
    }

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? alh == null ? "N/A" : alh.versionName : com.baidu.crabsdk.a.o;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            alg = context.getPackageManager();
            try {
                alh = alg.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String sL() {
        if (ali == null) {
            if (alh == null) {
                return "N/A";
            }
            ali = alh.applicationInfo.loadLabel(alg).toString();
        }
        return ali;
    }

    public static int sM() {
        if (alh == null) {
            return 0;
        }
        return alh.versionCode;
    }
}
