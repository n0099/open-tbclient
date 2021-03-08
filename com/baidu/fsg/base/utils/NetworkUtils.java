package com.baidu.fsg.base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.fsg.base.ApollonConstants;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
/* loaded from: classes5.dex */
public final class NetworkUtils {
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_TYPE_GSM = 16;
    public static final int NETWORK_TYPE_IWLAN = 18;
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    public static final int NETWORK_UNKNOW = 0;
    public static final int NETWORK_WIFI = 1;

    /* renamed from: a  reason: collision with root package name */
    private static final String f1558a = "NetworkUtils";

    private NetworkUtils() {
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            if (ApollonConstants.DEBUG) {
                LogUtil.d(f1558a, "context is null!");
            }
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            if (ApollonConstants.DEBUG) {
                LogUtil.d(f1558a, "couldn't get connectivity manager");
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            if (ApollonConstants.DEBUG) {
                LogUtil.d(f1558a, "network is not available");
            }
            return false;
        }
        if (ApollonConstants.DEBUG) {
            LogUtil.d(f1558a, "network is available");
        }
        return true;
    }

    public static boolean isNetworkRoaming(Context context) {
        TelephonyManager telephonyManager;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            if (ApollonConstants.DEBUG) {
                LogUtil.v(f1558a, "couldn't get connectivity manager");
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || !telephonyManager.isNetworkRoaming()) {
            return false;
        }
        if (ApollonConstants.DEBUG) {
            LogUtil.v(f1558a, "network is roaming");
        }
        return true;
    }

    public static boolean isWifiNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            if (ApollonConstants.DEBUG) {
                LogUtil.d(f1558a, "couldn't get connectivity manager");
                return false;
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return activeNetworkInfo.getType() == 1;
    }

    public static int getNetworkType(Context context) {
        if (isWifiNetworkAvailable(context)) {
            return 1;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
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
                case 17:
                    return 3;
                case 13:
                case 18:
                    return 4;
                default:
                    return 0;
            }
        }
        return 0;
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            LogUtil.e("", "NetworkStatus", e);
        }
        return null;
    }

    public static String getLocalMacAddress(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            if (ApollonConstants.DEBUG) {
                Log.d(f1558a, "couldn't get connectivity manager");
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            if (ApollonConstants.DEBUG) {
                Log.d(f1558a, "network is not available");
            }
            return false;
        }
        if (ApollonConstants.DEBUG) {
            Log.d(f1558a, "network is available");
        }
        return true;
    }

    public static String getNetName(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getExtraInfo() != null) {
                return activeNetworkInfo.getExtraInfo().toLowerCase();
            }
        }
        return "";
    }
}
