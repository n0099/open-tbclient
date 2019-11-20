package com.baidu.swan.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class a {
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        Context appContext = AppRuntime.getAppContext();
        if (appContext != null && (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static String MP() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(AppRuntime.getAppContext());
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            return s(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName());
        }
        return "unknown";
    }

    public static String s(int i, String str) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return BdNetTypeUtil.NET_TYPENAME_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return BdNetTypeUtil.NET_TYPENAME_3G;
            case 13:
            case 18:
            case 19:
                return BdNetTypeUtil.NET_TYPENAME_4G;
            default:
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("LTE_CA")) {
                    return BdNetTypeUtil.NET_TYPENAME_4G;
                }
                return "unknown";
        }
    }
}
