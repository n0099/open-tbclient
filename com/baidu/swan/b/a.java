package com.baidu.swan.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes10.dex */
public class a {
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        Context appContext = AppRuntime.getAppContext();
        if (appContext != null && (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static String getNetworkClass() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(AppRuntime.getAppContext());
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            return getMobileNetworkType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName());
        }
        return "unknown";
    }

    public static String getMobileNetworkType(int i, String str) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2g";
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
                return "3g";
            case 13:
            case 18:
            case 19:
                return "4g";
            default:
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("LTE_CA")) {
                    return "4g";
                }
                return "unknown";
        }
    }
}
