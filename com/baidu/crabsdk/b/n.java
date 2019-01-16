package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppRomUtils;
/* loaded from: classes6.dex */
public final class n {
    private static TelephonyManager Yt;
    private static ConnectivityManager Yu;
    private static Context mContext;

    public static String E() {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (Yu == null) {
                Yu = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            activeNetworkInfo = Yu.getActiveNetworkInfo();
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
                if (Yt == null) {
                    Yt = (TelephonyManager) mContext.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
                }
                sb.append("isRoaming: ").append(Yt.isNetworkRoaming() ? "yes" : AiAppNetworkUtils.NETWORK_TYPE_CELL_UN_CONNECTED).append("\n");
            }
        } else {
            sb.append("type: none\n");
        }
        return sb.toString();
    }

    public static String F() {
        try {
            if (Yu == null) {
                Yu = (ConnectivityManager) mContext.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = Yu.getActiveNetworkInfo();
            return activeNetworkInfo == null ? AiAppRomUtils.UNKNOWN : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException e) {
            return AiAppRomUtils.UNKNOWN;
        }
    }

    public static void d(Context context) {
        mContext = context;
    }
}
