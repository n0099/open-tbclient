package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes14.dex */
public final class o {
    private static TelephonyManager apq;
    private static ConnectivityManager apr;
    private static Context mContext;

    public static String H() {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (apr == null) {
                apr = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            activeNetworkInfo = apr.getActiveNetworkInfo();
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
                if (apq == null) {
                    apq = (TelephonyManager) mContext.getSystemService("phone");
                }
                sb.append("isRoaming: ").append(apq.isNetworkRoaming() ? "yes" : "no").append("\n");
            }
        } else {
            sb.append("type: none\n");
        }
        return sb.toString();
    }

    public static String I() {
        try {
            if (apr == null) {
                apr = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = apr.getActiveNetworkInfo();
            return activeNetworkInfo == null ? RomUtils.UNKNOWN : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException e) {
            return RomUtils.UNKNOWN;
        }
    }

    public static void e(Context context) {
        mContext = context;
    }
}
