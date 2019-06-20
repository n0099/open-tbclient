package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.sapi2.base.network.Apn;
/* loaded from: classes3.dex */
public final class o {
    private static PackageManager ZO;
    private static PackageInfo ZP;
    private static String ZQ;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (ZQ == null) {
            if (ZP == null) {
                return Apn.APN_UNKNOWN;
            }
            ZQ = ZP.applicationInfo.loadLabel(ZO).toString();
        }
        return ZQ;
    }

    public static String H() {
        return ZP == null ? Apn.APN_UNKNOWN : ZP.versionName;
    }

    public static int I() {
        if (ZP == null) {
            return 0;
        }
        return ZP.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            ZO = context.getPackageManager();
            try {
                ZP = ZO.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }
}
