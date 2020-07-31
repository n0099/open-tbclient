package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes12.dex */
public final class p {
    private static PackageManager amv;
    private static PackageInfo amw;
    private static String amx;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? amw == null ? "N/A" : amw.versionName : com.baidu.crabsdk.a.o;
    }

    public static int M() {
        if (amw == null) {
            return 0;
        }
        return amw.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            amv = context.getPackageManager();
            try {
                amw = amv.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String ti() {
        return mContext.getPackageName();
    }

    public static String tj() {
        if (amx == null) {
            if (amw == null) {
                return "N/A";
            }
            amx = amw.applicationInfo.loadLabel(amv).toString();
        }
        return amx;
    }
}
