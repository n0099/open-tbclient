package com.baidu.live.arch.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: classes3.dex */
public class MixNetWorkUtils {
    public static final boolean DEBUG = false;
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_5G = "5g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final String TAG = "MixNetWorkUtils";

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager;
        Context application;
        try {
            application = getApplication();
        } catch (SecurityException unused) {
            connectivityManager = null;
        }
        if (application == null) {
            return null;
        }
        connectivityManager = (ConnectivityManager) application.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static Context getApplication() {
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            return appInfoService.getApplication();
        }
        return null;
    }

    public static String getBSSID() {
        WifiInfo wifiManager = getWifiManager();
        if (wifiManager == null) {
            return "NULL";
        }
        return wifiManager.getBSSID();
    }

    public static int getIPAddress() {
        WifiInfo wifiManager = getWifiManager();
        if (wifiManager == null) {
            return 0;
        }
        return wifiManager.getIpAddress();
    }

    public static String getNetworkClass() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() == 0) {
                return getMobileNetworkType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName());
            }
            return "unknown";
        }
        return "no";
    }

    public static int getNetworkId() {
        WifiInfo wifiManager = getWifiManager();
        if (wifiManager == null) {
            return 0;
        }
        return wifiManager.getNetworkId();
    }

    public static String getWifiInfo() {
        WifiInfo wifiManager = getWifiManager();
        if (wifiManager == null) {
            return "NULL";
        }
        return wifiManager.toString();
    }

    @SuppressLint({"MissingPermission"})
    public static WifiInfo getWifiManager() {
        Context application = getApplication();
        if (application == null) {
            return null;
        }
        return ((WifiManager) application.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    }

    public static String getWifiName() {
        WifiInfo wifiManager = getWifiManager();
        if (wifiManager == null) {
            return "NULL";
        }
        return wifiManager.getSSID();
    }

    public static boolean isHighNetworkConnected() {
        String networkClass = getNetworkClass();
        if (!"wifi".equals(networkClass) && !"5g".equals(networkClass) && !"4g".equals(networkClass) && !"3g".equals(networkClass)) {
            return false;
        }
        return true;
    }

    public static boolean isMobileNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static boolean isWifiNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    public enum NetType {
        NONE("no"),
        WIFI("wifi"),
        _2G("2g"),
        _3G("3g"),
        _4G("4g"),
        _5G("5g"),
        UNKOWN(DownloadStatisticConstants.UBC_VALUE_UNKNOW);
        
        public final String type;

        NetType(String str) {
            this.type = str;
        }
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

    public static NetType getNetworkType() {
        char c;
        String networkClass = getNetworkClass();
        int hashCode = networkClass.hashCode();
        if (hashCode != -840472412) {
            if (hashCode != 1653) {
                if (hashCode != 1684) {
                    if (hashCode != 1715) {
                        if (hashCode != 1746) {
                            if (hashCode != 3521) {
                                if (hashCode == 3649301 && networkClass.equals("wifi")) {
                                    c = 4;
                                }
                                c = 65535;
                            } else {
                                if (networkClass.equals("no")) {
                                    c = 5;
                                }
                                c = 65535;
                            }
                        } else {
                            if (networkClass.equals("5g")) {
                                c = 3;
                            }
                            c = 65535;
                        }
                    } else {
                        if (networkClass.equals("4g")) {
                            c = 2;
                        }
                        c = 65535;
                    }
                } else {
                    if (networkClass.equals("3g")) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (networkClass.equals("2g")) {
                    c = 0;
                }
                c = 65535;
            }
        } else {
            if (networkClass.equals(DownloadStatisticConstants.UBC_VALUE_UNKNOW)) {
                c = 6;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            if (c != 5) {
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

    public static InetAddress intToInetAddress(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }
}
