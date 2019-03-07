package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.sapi2.base.network.Apn;
/* loaded from: classes3.dex */
public final class o {
    private static PackageManager abX;
    private static PackageInfo abY;
    private static String abZ;
    private static Context mContext;

    public static String G() {
        return mContext.getPackageName();
    }

    public static String H() {
        if (abZ == null) {
            if (abY == null) {
                return Apn.APN_UNKNOWN;
            }
            abZ = abY.applicationInfo.loadLabel(abX).toString();
        }
        return abZ;
    }

    public static String I() {
        return abY == null ? Apn.APN_UNKNOWN : abY.versionName;
    }

    public static int J() {
        if (abY == null) {
            return 0;
        }
        return abY.versionCode;
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            abX = context.getPackageManager();
            try {
                abY = abX.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }
}
