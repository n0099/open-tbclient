package com.baidu.searchbox.player.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import java.util.Locale;
/* loaded from: classes3.dex */
public class NetUtils {
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_5G = "5g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final int NET_TYPE_2G = 3;
    public static final int NET_TYPE_3G = 2;
    public static final int NET_TYPE_4G = 1;
    public static final int NET_TYPE_5G = 5;
    public static final int NET_TYPE_UNKNOWN = 4;
    public static final int NET_TYPE_WIFI = 0;
    public static final String TYPE_3G = "3g";
    public static final String TYPE_WIFI = "wifi";
    public static NetStatus mOldStatus;
    public static NetStatus mStatus;

    /* loaded from: classes3.dex */
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
    public static String getNetworkClass() {
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 1) {
                return "wifi";
            }
            if (networkInfo.getType() == 0) {
                return getMobileNetworkType(networkInfo.getSubtype(), networkInfo.getSubtypeName());
            }
            return "unknown";
        }
        return "no";
    }

    @Nullable
    @PublicMethod
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo getNetworkInfo() {
        ConnectivityManager connectivityManager;
        Context appContext = BDPlayerConfig.getAppContext();
        if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (SecurityException unused) {
            return null;
        }
    }

    @PublicMethod
    public static boolean isNet3G() {
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        return !"wifi".equals(networkInfo.getTypeName().toLowerCase(Locale.getDefault()));
    }

    @PublicMethod
    public static boolean isNetDown() {
        if (getNetworkInfo() == null) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public static boolean isNetWifi() {
        NetworkInfo networkInfo = getNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        return "wifi".equals(networkInfo.getTypeName().toLowerCase(Locale.getDefault()));
    }

    @PublicMethod
    public static String appendCDNStatParams(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.contains("vd1.bdstatic.com") && !str.contains("vd2.bdstatic.com") && !str.contains("vd3.bdstatic.com") && !str.contains("vd4.bdstatic.com") && !VideoAsyncHostHelper.isVideoUrlNeedAsyncRequest(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("pdx=")) {
            int indexOf = sb.indexOf("pdx=");
            if (indexOf >= 0) {
                int i2 = indexOf + 4;
                sb.replace(i2, getNumEndIndex(sb.toString(), i2), "0");
            }
            int indexOf2 = sb.indexOf("nt=");
            if (indexOf2 >= 0) {
                int i3 = indexOf2 + 3;
                sb.replace(i3, getNumEndIndex(sb.toString(), i3), String.valueOf(getNetTypeParams()));
            }
            int indexOf3 = sb.indexOf("dt=");
            if (indexOf3 >= 0) {
                int i4 = indexOf3 + 3;
                sb.replace(i4, getNumEndIndex(sb.toString(), i4), String.valueOf(i));
            }
            int indexOf4 = sb.indexOf("ds_stc=");
            if (indexOf4 >= 0) {
                int i5 = indexOf4 + 7;
                sb.replace(i5, findParamEndIndex(sb.toString(), i5), String.valueOf(str2));
            }
        } else {
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
            sb.append("&");
            sb.append("ds_stc=");
            sb.append(str2);
        }
        return sb.toString();
    }

    public static int findParamEndIndex(@NonNull String str, @IntRange(from = 0) int i) {
        int i2 = i;
        while (i < str.length() && !"&".equals(String.valueOf(str.charAt(i)))) {
            i2++;
            i++;
        }
        return i2;
    }

    public static int getNumEndIndex(@NonNull String str, @IntRange(from = 0) int i) {
        int i2 = i;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            i2++;
            i++;
        }
        return i2;
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
            case 20:
                return "5g";
            default:
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("LTE_CA")) {
                    return "4g";
                }
                return "unknown";
        }
    }

    public static int getNetTypeParams() {
        char c;
        String networkClass = getNetworkClass();
        int hashCode = networkClass.hashCode();
        if (hashCode != 1653) {
            if (hashCode != 1684) {
                if (hashCode != 1715) {
                    if (hashCode != 1746) {
                        if (hashCode == 3649301 && networkClass.equals("wifi")) {
                            c = 0;
                        }
                        c = 65535;
                    } else {
                        if (networkClass.equals("5g")) {
                            c = 4;
                        }
                        c = 65535;
                    }
                } else {
                    if (networkClass.equals("4g")) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (networkClass.equals("3g")) {
                    c = 2;
                }
                c = 65535;
            }
        } else {
            if (networkClass.equals("2g")) {
                c = 3;
            }
            c = 65535;
        }
        if (c == 0) {
            return 0;
        }
        if (c == 1) {
            return 1;
        }
        if (c == 2) {
            return 2;
        }
        if (c == 3) {
            return 3;
        }
        if (c != 4) {
            return 4;
        }
        return 5;
    }

    public static void setNetStatus(NetStatus netStatus) {
        NetStatus netStatus2 = mStatus;
        if (netStatus2 != netStatus) {
            mOldStatus = netStatus2;
            mStatus = netStatus;
        }
    }
}
