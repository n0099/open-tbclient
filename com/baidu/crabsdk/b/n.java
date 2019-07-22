package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
/* loaded from: classes3.dex */
public final class n {
    private static TelephonyManager aah;
    private static ConnectivityManager aai;
    private static Context mContext;

    public static String D() {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (aai == null) {
                aai = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            activeNetworkInfo = aai.getActiveNetworkInfo();
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("getNetworkInfo", e);
        }
        if (activeNetworkInfo == null) {
            return "N/A";
        }
        if (activeNetworkInfo.isConnected()) {
            sb.append("type: ").append(activeNetworkInfo.getTypeName()).append("\n");
            if (activeNetworkInfo.getType() == 0) {
                sb.append("subType: ").append(activeNetworkInfo.getSubtypeName()).append("\n");
                if (aah == null) {
                    aah = (TelephonyManager) mContext.getSystemService("phone");
                }
                sb.append("isRoaming: ").append(aah.isNetworkRoaming() ? "yes" : "no").append("\n");
            }
        } else {
            sb.append("type: none\n");
        }
        return sb.toString();
    }

    public static String E() {
        try {
            if (aai == null) {
                aai = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = aai.getActiveNetworkInfo();
            return activeNetworkInfo == null ? "UNKNOWN" : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException e) {
            return "UNKNOWN";
        }
    }

    public static void e(Context context) {
        mContext = context;
    }
}
