package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes8.dex */
public final class p {
    private static PackageManager aob;
    private static PackageInfo aoc;
    private static String aod;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? aoc == null ? "N/A" : aoc.versionName : com.baidu.crabsdk.a.o;
    }

    public static int M() {
        if (aoc == null) {
            return 0;
        }
        return aoc.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aob = context.getPackageManager();
            try {
                aoc = aob.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String vf() {
        return mContext.getPackageName();
    }

    public static String vg() {
        if (aod == null) {
            if (aoc == null) {
                return "N/A";
            }
            aod = aoc.applicationInfo.loadLabel(aob).toString();
        }
        return aod;
    }
}
