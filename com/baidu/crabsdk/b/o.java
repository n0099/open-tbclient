package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.sapi2.base.network.Apn;
/* loaded from: classes3.dex */
public final class o {
    private static PackageManager abY;
    private static PackageInfo abZ;
    private static String aca;
    private static Context mContext;

    public static String G() {
        return mContext.getPackageName();
    }

    public static String H() {
        if (aca == null) {
            if (abZ == null) {
                return Apn.APN_UNKNOWN;
            }
            aca = abZ.applicationInfo.loadLabel(abY).toString();
        }
        return aca;
    }

    public static String I() {
        return abZ == null ? Apn.APN_UNKNOWN : abZ.versionName;
    }

    public static int J() {
        if (abZ == null) {
            return 0;
        }
        return abZ.versionCode;
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            abY = context.getPackageManager();
            try {
                abZ = abY.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }
}
