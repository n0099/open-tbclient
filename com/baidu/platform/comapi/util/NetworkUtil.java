package com.baidu.platform.comapi.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class NetworkUtil {
    public static final int NETYPE_2G = 2;
    public static final int NETYPE_3G = 3;
    public static final int NETYPE_4G = 4;
    public static final int NETYPE_4G_UNKNOWN = 10;
    public static final int NETYPE_MOBILE_3G = 8;
    public static final int NETYPE_MOBILE_UNICOM_2G = 6;
    public static final int NETYPE_NOCON = -1;
    public static final int NETYPE_TELECOM_2G = 5;
    public static final int NETYPE_TELECOM_3G = 7;
    public static final int NETYPE_UNICOM_3G = 9;
    public static final int NETYPE_UNKNOWN = 0;
    public static final int NETYPE_WIFI = 1;
    public static boolean mUseProxy = false;
    public static String mProxyHost = "";
    public static int mProxyPort = 0;

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static NetworkInfo[] getAllNetworkInfo(Context context) {
        NetworkInfo[] networkInfoArr;
        if (context == null) {
            return null;
        }
        try {
            networkInfoArr = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
        } catch (Exception e) {
            networkInfoArr = null;
        }
        return networkInfoArr;
    }

    public static String getCurrentNetMode(Context context) {
        TelephonyManager telephonyManager;
        int i = 1;
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null) {
            int type = activeNetworkInfo.getType();
            if (type != 1) {
                if ((type == 0 || type == 3 || type == 4 || type == 5) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                        case 2:
                            i = 6;
                            break;
                        case 3:
                        case 9:
                        case 10:
                        case 15:
                            i = 9;
                            break;
                        case 4:
                            i = 5;
                            break;
                        case 5:
                        case 6:
                        case 12:
                            i = 7;
                            break;
                        case 7:
                        case 11:
                        case 16:
                            i = 2;
                            break;
                        case 8:
                        case 17:
                            i = 8;
                            break;
                        case 13:
                        case 18:
                            i = 4;
                            break;
                        case 14:
                            i = 3;
                            break;
                        default:
                            i = 0;
                            break;
                    }
                } else {
                    i = -1;
                }
            }
        } else {
            i = -1;
        }
        return Integer.toString(i);
    }

    public static String getNetworkOperatorInfo(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                try {
                    StringBuilder sb = new StringBuilder(networkOperator);
                    sb.insert(3, ":");
                    return sb.toString();
                } catch (Exception e) {
                    return "";
                }
            }
        }
        return "";
    }

    public static int getNetworkOperatorType(Context context) {
        String networkOperatorInfo = getNetworkOperatorInfo(context);
        if (!TextUtils.isEmpty(networkOperatorInfo)) {
            if (networkOperatorInfo.startsWith("460:00") || networkOperatorInfo.startsWith("460:02")) {
                return 0;
            }
            if (networkOperatorInfo.startsWith("460:01")) {
                return 1;
            }
            if (networkOperatorInfo.startsWith("460:03")) {
                return 2;
            }
        }
        return -1;
    }

    public static boolean initConnectState() {
        return true;
    }

    public static boolean isNetworkAvailable(Context context) {
        boolean z;
        try {
            if (isWifiConnected(context)) {
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnectedOrConnecting()) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        boolean z;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            if (1 == activeNetworkInfo.getType()) {
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isWifiState(Context context) {
        int i;
        if (context == null) {
            return false;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        try {
            i = Build.VERSION.SDK_INT >= 23 ? context.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0 ? wifiManager.getWifiState() : 1 : wifiManager.getWifiState();
        } catch (Exception e) {
            i = 1;
        }
        return i == 3;
    }

    public static void updateNetworkProxy(Context context) {
    }
}
