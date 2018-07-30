package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
/* loaded from: classes2.dex */
public final class n {
    private static TelephonyManager SV;
    private static ConnectivityManager SW;
    private static Context mContext;

    public static String D() {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (SW == null) {
                SW = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            activeNetworkInfo = SW.getActiveNetworkInfo();
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.b("getNetworkInfo", e);
        }
        if (activeNetworkInfo == null) {
            return "N/A";
        }
        if (activeNetworkInfo.isConnected()) {
            sb.append("type: ").append(activeNetworkInfo.getTypeName()).append("\n");
            if (activeNetworkInfo.getType() == 0) {
                sb.append("subType: ").append(activeNetworkInfo.getSubtypeName()).append("\n");
                if (SV == null) {
                    SV = (TelephonyManager) mContext.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
                }
                sb.append("isRoaming: ").append(SV.isNetworkRoaming() ? "yes" : "no").append("\n");
            }
        } else {
            sb.append("type: none\n");
        }
        return sb.toString();
    }

    public static String E() {
        try {
            if (SW == null) {
                SW = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = SW.getActiveNetworkInfo();
            return activeNetworkInfo == null ? "UNKNOWN" : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException e) {
            return "UNKNOWN";
        }
    }

    public static void d(Context context) {
        mContext = context;
    }
}
