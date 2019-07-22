package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes3.dex */
public final class o {
    private static PackageManager aaj;
    private static PackageInfo aak;
    private static String aal;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (aal == null) {
            if (aak == null) {
                return "N/A";
            }
            aal = aak.applicationInfo.loadLabel(aaj).toString();
        }
        return aal;
    }

    public static String H() {
        return aak == null ? "N/A" : aak.versionName;
    }

    public static int I() {
        if (aak == null) {
            return 0;
        }
        return aak.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            aaj = context.getPackageManager();
            try {
                aak = aaj.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }
}
