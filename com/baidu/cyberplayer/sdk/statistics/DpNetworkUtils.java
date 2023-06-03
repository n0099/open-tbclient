package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.DeviceInfoUtils;
import com.baidu.cyberplayer.sdk.Keep;
/* loaded from: classes3.dex */
public class DpNetworkUtils {
    public static int a(Context context) {
        try {
            String operator = DeviceInfoUtils.getOperator(context);
            if (TextUtils.isEmpty(operator)) {
                return 0;
            }
            if (!"46000".equals(operator) && !"46002".equals(operator) && !"46007".equals(operator) && !"46008".equals(operator)) {
                if (!"46001".equals(operator) && !"46006".equals(operator) && !"46009".equals(operator)) {
                    if (!"46003".equals(operator) && !"46005".equals(operator)) {
                        if (!"46011".equals(operator)) {
                            return 99;
                        }
                    }
                    return 2;
                }
                return 3;
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String b(Context context) {
        WifiInfo connectionInfo;
        int rssi;
        NetworkInfo netWorkInfo = getNetWorkInfo(context);
        if (netWorkInfo == null) {
            return "Disconnect";
        }
        int type = netWorkInfo.getType();
        if (type == 0) {
            if (TextUtils.isEmpty(netWorkInfo.getExtraInfo())) {
                return "Disconnect";
            }
            return "mobile_connect";
        } else if (type == 1) {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (rssi = connectionInfo.getRssi()) <= -127) {
                return "Disconnect";
            }
            return "wifi:" + rssi;
        } else {
            return "N/A";
        }
    }

    @Keep
    public static int getNetworkConnectType(NetworkInfo networkInfo) {
        if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
            return 0;
        }
        if (networkInfo.getType() == 0) {
            switch (networkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 4;
                default:
                    return 1;
            }
        } else if (networkInfo.getType() == 1) {
            return 100;
        } else {
            if (networkInfo.getType() == 9) {
                return 101;
            }
            return 999;
        }
    }

    @Keep
    public static NetworkInfo getNetWorkInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Keep
    public static String getNetworkStatisticsData(Context context) {
        int networkConnectType = getNetworkConnectType(getNetWorkInfo(context));
        int a = a(context);
        return networkConnectType + "_" + a;
    }

    @Keep
    public static String getNetworkStatisticsNoOperator(Context context) {
        int networkConnectType = getNetworkConnectType(getNetWorkInfo(context));
        return networkConnectType + "_0";
    }
}
