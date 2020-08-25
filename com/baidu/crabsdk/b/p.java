package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class p {
    private static PackageManager anx;
    private static PackageInfo any;
    private static String anz;
    private static Context mContext;

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? any == null ? "N/A" : any.versionName : com.baidu.crabsdk.a.o;
    }

    public static int M() {
        if (any == null) {
            return 0;
        }
        return any.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            anx = context.getPackageManager();
            try {
                any = anx.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static String uR() {
        return mContext.getPackageName();
    }

    public static String uS() {
        if (anz == null) {
            if (any == null) {
                return "N/A";
            }
            anz = any.applicationInfo.loadLabel(anx).toString();
        }
        return anz;
    }
}
