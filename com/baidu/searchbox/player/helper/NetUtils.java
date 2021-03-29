package com.baidu.searchbox.player.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes2.dex */
public class NetUtils {
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final int NET_TYPE_2G = 3;
    public static final int NET_TYPE_3G = 2;
    public static final int NET_TYPE_4G = 1;
    public static final int NET_TYPE_UNKNOWN = 4;
    public static final int NET_TYPE_WIFI = 0;
    public static final String TYPE_3G = "3g";
    public static final String TYPE_WIFI = "wifi";
    public static NetStatus mOldStatus;
    public static NetStatus mStatus;

    /* loaded from: classes2.dex */
    public enum NetStatus {
        NET_DOWN,
        NET_WIFI,
        NET_MOBILE
    }

    static {
        NetStatus netStatus = NetStatus.NET_DOWN;
        mOldStatus = netStatus;
        mStatus = netStatus;
    }

    @PublicMethod
    public static String appendCDNStatParams(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains("vd1.bdstatic.com") || str.contains("vd2.bdstatic.com") || str.contains("vd3.bdstatic.com") || str.contains("vd4.bdstatic.com")) {
            StringBuilder sb = new StringBuilder(str);
            if (!str.contains("?")) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            sb.append("pdx=");
            sb.append("0");
            sb.append("&");
            sb.append("nt=");
            sb.append(getNetTypeParams());
            sb.append("&");
            sb.append("dt=");
            sb.append(i);
            return sb.toString();
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
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
                break;
            default:
                if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) {
                    return "unknown";
                }
                break;
        }
        return "4g";
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

    public static int getNetTypeParams() {
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
        return "2g".equals(networkClass) ? 3 : 4;
    }

    @PublicMethod
    public static String getNetworkClass() {
        NetworkInfo networkInfo = getNetworkInfo();
        return (networkInfo == null || !networkInfo.isConnected()) ? "no" : networkInfo.getType() == 1 ? "wifi" : networkInfo.getType() == 0 ? getMobileNetworkType(networkInfo.getSubtype(), networkInfo.getSubtypeName()) : "unknown";
    }

    @Nullable
    @PublicMethod
    public static NetworkInfo getNetworkInfo() {
        ConnectivityManager connectivityManager;
        Context appContext = BDPlayerConfig.getAppContext();
        if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    @PublicMethod
    public static boolean isNet3G() {
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        return !"wifi".equals(networkInfo.getTypeName().toLowerCase());
    }

    @PublicMethod
    public static boolean isNetDown() {
        return getNetworkInfo() == null;
    }

    @PublicMethod
    public static boolean isNetWifi() {
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        return "wifi".equals(networkInfo.getTypeName().toLowerCase());
    }

    public static void setNetStatus(NetStatus netStatus) {
        NetStatus netStatus2 = mStatus;
        if (netStatus2 != netStatus) {
            mOldStatus = netStatus2;
            mStatus = netStatus;
        }
    }
}
