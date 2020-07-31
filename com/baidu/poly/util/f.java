package com.baidu.poly.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
/* loaded from: classes9.dex */
public class f {
    private static String M(int i, String str) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "1";
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
                return "2";
            case 13:
            case 18:
            case 19:
                return "3";
            default:
                return (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) ? "unknown" : "3";
        }
    }

    public static boolean Oz() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private static NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager;
        Context OA = g.OA();
        if (OA != null && (connectivityManager = (ConnectivityManager) OA.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static String getNetworkType() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "0";
        }
        return activeNetworkInfo.getType() == 1 ? "4" : activeNetworkInfo.getType() == 0 ? M(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName()) : "unknown";
    }
}
