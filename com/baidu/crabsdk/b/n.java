package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
/* loaded from: classes3.dex */
public final class n {
    private static TelephonyManager Kk;
    private static ConnectivityManager Kl;
    private static Context mContext;

    public static String D() {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (Kl == null) {
                Kl = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            activeNetworkInfo = Kl.getActiveNetworkInfo();
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("getNetworkInfo", e);
        }
        if (activeNetworkInfo == null) {
            return "N/A";
        }
        if (activeNetworkInfo.isConnected()) {
            sb.append("type: ").append(activeNetworkInfo.getTypeName()).append("\n");
            if (activeNetworkInfo.getType() == 0) {
                sb.append("subType: ").append(activeNetworkInfo.getSubtypeName()).append("\n");
                if (Kk == null) {
                    Kk = (TelephonyManager) mContext.getSystemService("phone");
                }
                sb.append("isRoaming: ").append(Kk.isNetworkRoaming() ? "yes" : "no").append("\n");
            }
        } else {
            sb.append("type: none\n");
        }
        return sb.toString();
    }

    public static String E() {
        try {
            if (Kl == null) {
                Kl = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = Kl.getActiveNetworkInfo();
            return activeNetworkInfo == null ? "UNKNOWN" : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException e) {
            return "UNKNOWN";
        }
    }

    public static void e(Context context) {
        mContext = context;
    }
}
