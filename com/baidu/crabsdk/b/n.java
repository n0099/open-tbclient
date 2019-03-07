package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.base.network.Apn;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
/* loaded from: classes3.dex */
public final class n {
    private static TelephonyManager abV;
    private static ConnectivityManager abW;
    private static Context mContext;

    public static String E() {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (abW == null) {
                abW = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            activeNetworkInfo = abW.getActiveNetworkInfo();
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
                if (abV == null) {
                    abV = (TelephonyManager) mContext.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
                }
                sb.append("isRoaming: ").append(abV.isNetworkRoaming() ? "yes" : "no").append("\n");
            }
        } else {
            sb.append("type: none\n");
        }
        return sb.toString();
    }

    public static String F() {
        try {
            if (abW == null) {
                abW = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = abW.getActiveNetworkInfo();
            return activeNetworkInfo == null ? "UNKNOWN" : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException e) {
            return "UNKNOWN";
        }
    }

    public static void d(Context context) {
        mContext = context;
    }
}
