package com.baidu.pass.biometrics.base.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statistics.g;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
/* loaded from: classes2.dex */
public final class NetworkUtils {
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_TYPE_1XRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_GSM = 16;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_IWLAN = 18;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_UNKNOW = 0;
    public static final int NETWORK_WIFI = 1;

    @TargetApi(3)
    public static String getNetworkClass(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return g.f3909b;
                    case 13:
                        return "4G";
                    default:
                        return RomUtils.UNKNOWN;
                }
            }
            return RomUtils.UNKNOWN;
        }
        return "UNCNCT";
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
    }
}
