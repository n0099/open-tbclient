package com.baidu.android.util.connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: classes6.dex */
public class NetWorkUtils {
    private static final boolean DEBUG = false;
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_5G = "5g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    private static final String TAG = "NetWorkUtils";

    /* loaded from: classes6.dex */
    public enum NetType {
        NONE("no"),
        WIFI("wifi"),
        _2G("2g"),
        _3G("3g"),
        _4G("4g"),
        _5G("5g"),
        UNKOWN("unknow");
        
        public final String type;

        NetType(String str) {
            this.type = str;
        }
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
        } catch (SecurityException e) {
            return null;
        }
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static String getMobileType(int i, String str) {
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
            case 20:
                return "5g";
            default:
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("LTE_CA")) {
                    return "4g";
                }
                return "unknown";
        }
    }

    public static NetType getNetworkType(Context context) {
        String networkTypeString = getNetworkTypeString(context);
        char c = 65535;
        switch (networkTypeString.hashCode()) {
            case -284840886:
                if (networkTypeString.equals("unknown")) {
                    c = 6;
                    break;
                }
                break;
            case 1653:
                if (networkTypeString.equals("2g")) {
                    c = 0;
                    break;
                }
                break;
            case 1684:
                if (networkTypeString.equals("3g")) {
                    c = 1;
                    break;
                }
                break;
            case 1715:
                if (networkTypeString.equals("4g")) {
                    c = 2;
                    break;
                }
                break;
            case 1746:
                if (networkTypeString.equals("5g")) {
                    c = 3;
                    break;
                }
                break;
            case 3521:
                if (networkTypeString.equals("no")) {
                    c = 5;
                    break;
                }
                break;
            case 3649301:
                if (networkTypeString.equals("wifi")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return NetType._2G;
            case 1:
                return NetType._3G;
            case 2:
                return NetType._4G;
            case 3:
                return NetType._5G;
            case 4:
                return NetType.WIFI;
            case 5:
                return NetType.NONE;
            default:
                return NetType.UNKOWN;
        }
    }

    public static boolean isHighNetworkConnected(Context context) {
        String networkTypeString = getNetworkTypeString(context);
        return "wifi".equals(networkTypeString) || "5g".equals(networkTypeString) || "4g".equals(networkTypeString) || "3g".equals(networkTypeString);
    }

    public static InetAddress intToInetAddress(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
        } catch (UnknownHostException e) {
            throw new AssertionError();
        }
    }

    public static String getNetworkTypeString(Context context) {
        if (context == null) {
            return "unknown";
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            return getMobileType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName());
        }
        return "unknown";
    }

    public static String getBSSID(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "NULL" : connectionInfo.getBSSID();
    }

    public static String getWifiName(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "NULL" : connectionInfo.getSSID();
    }

    public static int getIPAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return 0;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        return connectionInfo == null ? 0 : connectionInfo.getIpAddress();
    }

    public static int getNetworkId(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return 0;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        return connectionInfo == null ? 0 : connectionInfo.getNetworkId();
    }

    public static String getWifiInfo(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "NULL" : connectionInfo.toString();
    }
}
