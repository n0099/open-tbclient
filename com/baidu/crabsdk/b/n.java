package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.base.network.Apn;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
/* loaded from: classes3.dex */
public final class n {
    private static TelephonyManager abX;
    private static ConnectivityManager abY;
    private static Context mContext;

    public static String D() {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (abY == null) {
                abY = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            activeNetworkInfo = abY.getActiveNetworkInfo();
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("getNetworkInfo", e);
        }
        if (activeNetworkInfo == null) {
            return Apn.APN_UNKNOWN;
        }
        if (activeNetworkInfo.isConnected()) {
            sb.append("type: ").append(activeNetworkInfo.getTypeName()).append("\n");
            if (activeNetworkInfo.getType() == 0) {
                sb.append("subType: ").append(activeNetworkInfo.getSubtypeName()).append("\n");
                if (abX == null) {
                    abX = (TelephonyManager) mContext.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
                }
                sb.append("isRoaming: ").append(abX.isNetworkRoaming() ? "yes" : "no").append("\n");
            }
        } else {
            sb.append("type: none\n");
        }
        return sb.toString();
    }

    public static String E() {
        try {
            if (abY == null) {
                abY = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = abY.getActiveNetworkInfo();
            return activeNetworkInfo == null ? "UNKNOWN" : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException e) {
            return "UNKNOWN";
        }
    }

    public static void e(Context context) {
        mContext = context;
    }
}
