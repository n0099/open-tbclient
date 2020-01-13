package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes6.dex */
public final class n {
    private static TelephonyManager Qr;
    private static ConnectivityManager Qs;
    private static Context mContext;

    public static String D() {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (Qs == null) {
                Qs = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            activeNetworkInfo = Qs.getActiveNetworkInfo();
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
                if (Qr == null) {
                    Qr = (TelephonyManager) mContext.getSystemService("phone");
                }
                sb.append("isRoaming: ").append(Qr.isNetworkRoaming() ? "yes" : NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED).append("\n");
            }
        } else {
            sb.append("type: none\n");
        }
        return sb.toString();
    }

    public static String E() {
        try {
            if (Qs == null) {
                Qs = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = Qs.getActiveNetworkInfo();
            return activeNetworkInfo == null ? RomUtils.UNKNOWN : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException e) {
            return RomUtils.UNKNOWN;
        }
    }

    public static void e(Context context) {
        mContext = context;
    }
}
