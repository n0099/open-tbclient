package com.baidu.android.util.connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: classes.dex */
public class NetWorkUtils {
    public static final boolean DEBUG = false;
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_5G = "5g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final String TAG = "NetWorkUtils";

    /* loaded from: classes.dex */
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
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static String getBSSID(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "NULL" : connectionInfo.getBSSID();
    }

    public static int getIPAddress(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return 0;
        }
        return connectionInfo.getIpAddress();
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
                return (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) ? "unknown" : "4g";
        }
    }

    public static int getNetworkId(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return 0;
        }
        return connectionInfo.getNetworkId();
    }

    public static NetType getNetworkType(Context context) {
        char c2;
        String networkTypeString = getNetworkTypeString(context);
        int hashCode = networkTypeString.hashCode();
        if (hashCode == -284840886) {
            if (networkTypeString.equals("unknown")) {
                c2 = 6;
            }
            c2 = 65535;
        } else if (hashCode == 1653) {
            if (networkTypeString.equals("2g")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode == 1684) {
            if (networkTypeString.equals("3g")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode == 1715) {
            if (networkTypeString.equals("4g")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode == 1746) {
            if (networkTypeString.equals("5g")) {
                c2 = 3;
            }
            c2 = 65535;
        } else if (hashCode != 3521) {
            if (hashCode == 3649301 && networkTypeString.equals("wifi")) {
                c2 = 4;
            }
            c2 = 65535;
        } else {
            if (networkTypeString.equals("no")) {
                c2 = 5;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        if (c2 != 4) {
                            if (c2 != 5) {
                                return NetType.UNKOWN;
                            }
                            return NetType.NONE;
                        }
                        return NetType.WIFI;
                    }
                    return NetType._5G;
                }
                return NetType._4G;
            }
            return NetType._3G;
        }
        return NetType._2G;
    }

    public static String getNetworkTypeString(Context context) {
        if (context == null) {
            return "unknown";
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? "no" : activeNetworkInfo.getType() == 1 ? "wifi" : activeNetworkInfo.getType() == 0 ? getMobileType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName()) : "unknown";
    }

    public static String getWifiInfo(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "NULL" : connectionInfo.toString();
    }

    public static String getWifiName(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "NULL" : connectionInfo.getSSID();
    }

    public static InetAddress intToInetAddress(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean isHighNetworkConnected(Context context) {
        String networkTypeString = getNetworkTypeString(context);
        return "wifi".equals(networkTypeString) || "5g".equals(networkTypeString) || "4g".equals(networkTypeString) || "3g".equals(networkTypeString);
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
    }
}
