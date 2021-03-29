package com.baidu.android.util.devices;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.apollon.statistics.g;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.net.InetAddress;
import java.net.UnknownHostException;
@Deprecated
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

    @Deprecated
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        return getActiveNetworkInfo();
    }

    @Deprecated
    public static String getBSSID(@NonNull Context context) {
        return getBSSID();
    }

    @Deprecated
    public static int getIPAddress(@NonNull Context context) {
        return getIPAddress();
    }

    @Deprecated
    public static String getMacAddress(Context context) {
        return getMacAddress();
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
            case 20:
                return "5g";
            default:
                return (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) ? "unknown" : "4g";
        }
    }

    @Deprecated
    public static String getNetworkClass(Context context) {
        return getNetworkClass();
    }

    @Deprecated
    public static int getNetworkId(@NonNull Context context) {
        return getNetworkId();
    }

    @Deprecated
    public static String getNetworkInfo(@NonNull Context context) {
        return getNetworkInfo();
    }

    @Deprecated
    public static NetType getNetworkType(Context context) {
        return getNetworkType();
    }

    @Deprecated
    public static String getWifiInfo(@NonNull Context context) {
        return getWifiInfo();
    }

    @Deprecated
    public static String getWifiName(@NonNull Context context) {
        return getWifiName();
    }

    public static InetAddress intToInetAddress(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    @Deprecated
    public static boolean isHighNetworkConnected(Context context) {
        return isHighNetworkConnected();
    }

    @Deprecated
    public static boolean isMobileNetworkConnected(Context context) {
        return isMobileNetworkConnected();
    }

    @Deprecated
    public static boolean isNetworkConnected(Context context) {
        return isNetworkConnected();
    }

    @Deprecated
    public static boolean isWapNetWorkConnected(@NonNull Context context) {
        return isWapNetWorkConnected();
    }

    @Deprecated
    public static boolean isWifiNetworkConnected(Context context) {
        return isWifiNetworkConnected();
    }

    public static NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager;
        if (AppRuntime.getAppContext() == null) {
            return null;
        }
        try {
            connectivityManager = (ConnectivityManager) AppRuntime.getAppContext().getSystemService("connectivity");
        } catch (SecurityException unused) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static String getBSSID() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo == null ? "NULL" : connectionInfo.getBSSID();
    }

    public static int getIPAddress() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return 0;
        }
        return connectionInfo.getIpAddress();
    }

    public static String getMacAddress() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo == null ? "NULL" : connectionInfo.getMacAddress();
    }

    public static String getNetworkClass() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? "no" : activeNetworkInfo.getType() == 1 ? "wifi" : activeNetworkInfo.getType() == 0 ? getMobileNetworkType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName()) : "unknown";
    }

    public static int getNetworkId() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return 0;
        }
        return connectionInfo.getNetworkId();
    }

    @Deprecated
    public static String getNetworkInfo() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) AppRuntime.getAppContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WiFi";
        }
        if (activeNetworkInfo.getType() == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype != 20) {
                switch (subtype) {
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
                        return g.f3874b;
                    case 13:
                        return "4G";
                    default:
                        return "unknown";
                }
            }
            return "5G";
        }
        return "unknown";
    }

    public static NetType getNetworkType() {
        char c2;
        String networkClass = getNetworkClass();
        int hashCode = networkClass.hashCode();
        if (hashCode == -840472412) {
            if (networkClass.equals("unknow")) {
                c2 = 6;
            }
            c2 = 65535;
        } else if (hashCode == 1653) {
            if (networkClass.equals("2g")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode == 1684) {
            if (networkClass.equals("3g")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode == 1715) {
            if (networkClass.equals("4g")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode == 1746) {
            if (networkClass.equals("5g")) {
                c2 = 3;
            }
            c2 = 65535;
        } else if (hashCode != 3521) {
            if (hashCode == 3649301 && networkClass.equals("wifi")) {
                c2 = 4;
            }
            c2 = 65535;
        } else {
            if (networkClass.equals("no")) {
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

    public static String getWifiInfo() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo == null ? "NULL" : connectionInfo.toString();
    }

    public static String getWifiName() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo == null ? "NULL" : connectionInfo.getSSID();
    }

    public static boolean isHighNetworkConnected() {
        String networkClass = getNetworkClass();
        return "wifi".equals(networkClass) || "5g".equals(networkClass) || "4g".equals(networkClass) || "3g".equals(networkClass);
    }

    public static boolean isMobileNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
    }

    public static boolean isNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean isWapNetWorkConnected() {
        return new ConnectManager(AppRuntime.getAppContext().getApplicationContext()).isWapNetwork();
    }

    public static boolean isWifiNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
    }
}
