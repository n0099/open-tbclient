package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class p {
    private static PackageManager aqH;
    private static PackageInfo aqI;
    private static String aqJ;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? aqI == null ? "N/A" : aqI.versionName : com.baidu.crabsdk.a.o;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aqH = context.getPackageManager();
            try {
                aqI = aqH.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String up() {
        return mContext.getPackageName();
    }

    public static String uq() {
        if (aqJ == null) {
            if (aqI == null) {
                return "N/A";
            }
            aqJ = aqI.applicationInfo.loadLabel(aqH).toString();
        }
        return aqJ;
    }

    public static int ur() {
        if (aqI == null) {
            return 0;
        }
        return aqI.versionCode;
    }
}
