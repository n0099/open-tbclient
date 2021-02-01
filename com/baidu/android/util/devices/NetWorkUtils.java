package com.baidu.android.util.devices;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.net.InetAddress;
import java.net.UnknownHostException;
@Deprecated
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    public static NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager;
        if (AppRuntime.getAppContext() == null) {
            return null;
        }
        try {
            connectivityManager = (ConnectivityManager) AppRuntime.getAppContext().getSystemService("connectivity");
        } catch (SecurityException e) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    @Deprecated
    public static boolean isWifiNetworkConnected(Context context) {
        return isWifiNetworkConnected();
    }

    public static boolean isWifiNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
    }

    @Deprecated
    public static boolean isMobileNetworkConnected(Context context) {
        return isMobileNetworkConnected();
    }

    public static boolean isMobileNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
    }

    @Deprecated
    public static boolean isNetworkConnected(Context context) {
        return isNetworkConnected();
    }

    public static boolean isNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    @Deprecated
    public static String getNetworkClass(Context context) {
        return getNetworkClass();
    }

    public static String getNetworkClass() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
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
            case 20:
                return "5g";
            default:
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("LTE_CA")) {
                    return "4g";
                }
                return "unknown";
        }
    }

    @Deprecated
    public static NetType getNetworkType(Context context) {
        return getNetworkType();
    }

    public static NetType getNetworkType() {
        String networkClass = getNetworkClass();
        char c = 65535;
        switch (networkClass.hashCode()) {
            case -840472412:
                if (networkClass.equals("unknow")) {
                    c = 6;
                    break;
                }
                break;
            case 1653:
                if (networkClass.equals("2g")) {
                    c = 0;
                    break;
                }
                break;
            case 1684:
                if (networkClass.equals("3g")) {
                    c = 1;
                    break;
                }
                break;
            case 1715:
                if (networkClass.equals("4g")) {
                    c = 2;
                    break;
                }
                break;
            case 1746:
                if (networkClass.equals("5g")) {
                    c = 3;
                    break;
                }
                break;
            case 3521:
                if (networkClass.equals("no")) {
                    c = 5;
                    break;
                }
                break;
            case 3649301:
                if (networkClass.equals("wifi")) {
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

    @Deprecated
    public static boolean isHighNetworkConnected(Context context) {
        return isHighNetworkConnected();
    }

    public static boolean isHighNetworkConnected() {
        String networkClass = getNetworkClass();
        return "wifi".equals(networkClass) || "5g".equals(networkClass) || "4g".equals(networkClass) || "3g".equals(networkClass);
    }

    @Deprecated
    public static boolean isWapNetWorkConnected(@NonNull Context context) {
        return isWapNetWorkConnected();
    }

    public static boolean isWapNetWorkConnected() {
        return new ConnectManager(AppRuntime.getAppContext().getApplicationContext()).isWapNetwork();
    }

    public static InetAddress intToInetAddress(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
        } catch (UnknownHostException e) {
            throw new AssertionError();
        }
    }

    @Deprecated
    public static String getNetworkInfo(@NonNull Context context) {
        return getNetworkInfo();
    }

    @Deprecated
    public static String getNetworkInfo() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) AppRuntime.getAppContext().getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return "WiFi";
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
                        return "3G";
                    case 13:
                        return "4G";
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    default:
                        return "unknown";
                    case 20:
                        return "5G";
                }
            }
            return "unknown";
        }
        return "no";
    }

    @Deprecated
    public static String getMacAddress(Context context) {
        return getMacAddress();
    }

    public static String getMacAddress() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo == null ? "NULL" : connectionInfo.getMacAddress();
    }

    @Deprecated
    public static String getBSSID(@NonNull Context context) {
        return getBSSID();
    }

    public static String getBSSID() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo == null ? "NULL" : connectionInfo.getBSSID();
    }

    @Deprecated
    public static String getWifiName(@NonNull Context context) {
        return getWifiName();
    }

    public static String getWifiName() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo == null ? "NULL" : connectionInfo.getSSID();
    }

    @Deprecated
    public static int getIPAddress(@NonNull Context context) {
        return getIPAddress();
    }

    public static int getIPAddress() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return 0;
        }
        return connectionInfo.getIpAddress();
    }

    @Deprecated
    public static int getNetworkId(@NonNull Context context) {
        return getNetworkId();
    }

    public static int getNetworkId() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return 0;
        }
        return connectionInfo.getNetworkId();
    }

    @Deprecated
    public static String getWifiInfo(@NonNull Context context) {
        return getWifiInfo();
    }

    public static String getWifiInfo() {
        WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo == null ? "NULL" : connectionInfo.toString();
    }
}
