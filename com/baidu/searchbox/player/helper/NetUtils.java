package com.baidu.searchbox.player.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes15.dex */
public class NetUtils {
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    private static final int NET_TYPE_2G = 3;
    private static final int NET_TYPE_3G = 2;
    private static final int NET_TYPE_4G = 1;
    private static final int NET_TYPE_UNKNOWN = 4;
    private static final int NET_TYPE_WIFI = 0;
    private static final String TYPE_3G = "3g";
    private static final String TYPE_WIFI = "wifi";
    public static NetStatus mOldStatus = NetStatus.NET_DOWN;
    public static NetStatus mStatus = NetStatus.NET_DOWN;

    /* loaded from: classes15.dex */
    public enum NetStatus {
        NET_DOWN,
        NET_WIFI,
        NET_MOBILE
    }

    public static void setNetStatus(NetStatus netStatus) {
        if (mStatus != netStatus) {
            mOldStatus = mStatus;
            mStatus = netStatus;
        }
    }

    @PublicMethod
    @Nullable
    public static NetworkInfo getNetworkInfo() {
        Context appContext = BDPlayerConfig.getAppContext();
        if (appContext == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity");
        return connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
    }

    @PublicMethod
    public static NetStatus getNetStatus() {
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo != null) {
            if (1 == networkInfo.getType()) {
                return NetStatus.NET_WIFI;
            }
            return NetStatus.NET_MOBILE;
        }
        return NetStatus.NET_DOWN;
    }

    @PublicMethod
    public static boolean isNetDown() {
        return getNetworkInfo() == null;
    }

    @PublicMethod
    public static boolean isNet3G() {
        NetworkInfo networkInfo = getNetworkInfo();
        return (networkInfo == null || "wifi".equals(networkInfo.getTypeName().toLowerCase())) ? false : true;
    }

    @PublicMethod
    public static boolean isNetWifi() {
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        return "wifi".equals(networkInfo.getTypeName().toLowerCase());
    }

    @PublicMethod
    public static String appendCDNStatParams(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("vd1.bdstatic.com") || str.contains("vd2.bdstatic.com") || str.contains("vd3.bdstatic.com") || str.contains("vd4.bdstatic.com")) {
                StringBuilder sb = new StringBuilder(str);
                if (!str.contains("?")) {
                    sb.append("?");
                } else {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                sb.append("pdx=").append("0").append(ETAG.ITEM_SEPARATOR);
                sb.append("nt=").append(getNetTypeParams()).append(ETAG.ITEM_SEPARATOR);
                sb.append("dt=").append(i);
                return sb.toString();
            }
            return str;
        }
        return str;
    }

    private static int getNetTypeParams() {
        String networkClass = getNetworkClass();
        if ("wifi".equals(networkClass)) {
            return 0;
        }
        if ("4g".equals(networkClass)) {
            return 1;
        }
        if ("3g".equals(networkClass)) {
            return 2;
        }
        if ("2g".equals(networkClass)) {
            return 3;
        }
        return 4;
    }

    @PublicMethod
    public static String getNetworkClass() {
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            return "no";
        }
        if (networkInfo.getType() == 1) {
            return "wifi";
        }
        if (networkInfo.getType() == 0) {
            return getMobileNetworkType(networkInfo.getSubtype(), networkInfo.getSubtypeName());
        }
        return "unknown";
    }

    @PublicMethod
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
