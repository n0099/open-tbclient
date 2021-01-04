package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class p {
    private static PackageManager aqf;
    private static PackageInfo aqg;
    private static String aqh;
    private static Context mContext;

    public static String J() {
        return mContext.getPackageName();
    }

    public static String K() {
        if (aqh == null) {
            if (aqg == null) {
                return "N/A";
            }
            aqh = aqg.applicationInfo.loadLabel(aqf).toString();
        }
        return aqh;
    }

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? aqg == null ? "N/A" : aqg.versionName : com.baidu.crabsdk.a.o;
    }

    public static int M() {
        if (aqg == null) {
            return 0;
        }
        return aqg.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aqf = context.getPackageManager();
            try {
                aqg = aqf.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }
}
