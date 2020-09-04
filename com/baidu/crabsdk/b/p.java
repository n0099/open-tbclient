package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class p {
    private static PackageInfo anA;
    private static String anB;
    private static PackageManager anz;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? anA == null ? "N/A" : anA.versionName : com.baidu.crabsdk.a.o;
    }

    public static int M() {
        if (anA == null) {
            return 0;
        }
        return anA.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            anz = context.getPackageManager();
            try {
                anA = anz.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String uR() {
        return mContext.getPackageName();
    }

    public static String uS() {
        if (anB == null) {
            if (anA == null) {
                return "N/A";
            }
            anB = anA.applicationInfo.loadLabel(anz).toString();
        }
        return anB;
    }
}
