package com.baidu.crabsdk.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.sapi2.base.network.Apn;
/* loaded from: classes3.dex */
public final class o {
    private static PackageManager ZP;
    private static PackageInfo ZQ;
    private static String ZR;
    private static Context mContext;

    public static String F() {
        return mContext.getPackageName();
    }

    public static String G() {
        if (ZR == null) {
            if (ZQ == null) {
                return Apn.APN_UNKNOWN;
            }
            ZR = ZQ.applicationInfo.loadLabel(ZP).toString();
        }
        return ZR;
    }

    public static String H() {
        return ZQ == null ? Apn.APN_UNKNOWN : ZQ.versionName;
    }

    public static int I() {
        if (ZQ == null) {
            return 0;
        }
        return ZQ.versionCode;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            ZP = context.getPackageManager();
            try {
                ZQ = ZP.getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                com.baidu.crabsdk.c.a.a("PackageCollector.init fail.", e);
            }
        }
    }
}
