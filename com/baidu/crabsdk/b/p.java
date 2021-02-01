package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class p {
    private static PackageManager apg;
    private static PackageInfo aph;
    private static String api;
    private static Context mContext;

    public static String J() {
        return mContext.getPackageName();
    }

    public static String K() {
        if (api == null) {
            if (aph == null) {
                return "N/A";
            }
            api = aph.applicationInfo.loadLabel(apg).toString();
        }
        return api;
    }

    public static String L() {
        return TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? aph == null ? "N/A" : aph.versionName : com.baidu.crabsdk.a.o;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            apg = context.getPackageManager();
            try {
                aph = apg.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }

    public static int up() {
        if (aph == null) {
            return 0;
        }
        return aph.versionCode;
    }
}
