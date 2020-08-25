package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes6.dex */
public final class o {
    private static TelephonyManager anv;
    private static ConnectivityManager anw;
    private static Context mContext;

    public static String H() {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (anw == null) {
                anw = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            activeNetworkInfo = anw.getActiveNetworkInfo();
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
                if (anv == null) {
                    anv = (TelephonyManager) mContext.getSystemService("phone");
                }
                sb.append("isRoaming: ").append(anv.isNetworkRoaming() ? "yes" : "no").append("\n");
            }
        } else {
            sb.append("type: none\n");
        }
        return sb.toString();
    }

    public static String I() {
        try {
            if (anw == null) {
                anw = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = anw.getActiveNetworkInfo();
            return activeNetworkInfo == null ? RomUtils.UNKNOWN : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException e) {
            return RomUtils.UNKNOWN;
        }
    }

    public static void e(Context context) {
        mContext = context;
    }
}
