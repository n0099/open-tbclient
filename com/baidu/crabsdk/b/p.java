package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes14.dex */
public final class p {
    private static PackageManager aps;
    private static PackageInfo apt;
    private static String apu;
    private static Context mContext;

    public static String J() {
        return mContext.getPackageName();
    }

    public static String K() {
        if (apu == null) {
            if (apt == null) {
                return "N/A";
            }
            apu = apt.applicationInfo.loadLabel(aps).toString();
        }
        return apu;
    }

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? apt == null ? "N/A" : apt.versionName : com.baidu.crabsdk.a.o;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aps = context.getPackageManager();
            try {
                apt = aps.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static int us() {
        if (apt == null) {
            return 0;
        }
        return apt.versionCode;
    }
}
