package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.sapi2.base.network.Apn;
/* loaded from: classes3.dex */
public final class o {
    private static PackageManager abZ;
    private static PackageInfo aca;
    private static String acb;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (acb == null) {
            if (aca == null) {
                return Apn.APN_UNKNOWN;
            }
            acb = aca.applicationInfo.loadLabel(abZ).toString();
        }
        return acb;
    }

    public static String H() {
        return aca == null ? Apn.APN_UNKNOWN : aca.versionName;
    }

    public static int I() {
        if (aca == null) {
            return 0;
        }
        return aca.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            abZ = context.getPackageManager();
            try {
                aca = abZ.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.f("PackageCollector.init fail.", e);
            }
        }
    }
}
