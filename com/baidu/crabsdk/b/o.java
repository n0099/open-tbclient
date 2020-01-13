package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* loaded from: classes6.dex */
public final class o {
    private static PackageManager Qt;
    private static PackageInfo Qu;
    private static String Qv;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (Qv == null) {
            if (Qu == null) {
                return "N/A";
            }
            Qv = Qu.applicationInfo.loadLabel(Qt).toString();
        }
        return Qv;
    }

    public static String H() {
        return Qu == null ? "N/A" : Qu.versionName;
    }

    public static int I() {
        if (Qu == null) {
            return 0;
        }
        return Qu.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            Qt = context.getPackageManager();
            try {
                Qu = Qt.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }
}
