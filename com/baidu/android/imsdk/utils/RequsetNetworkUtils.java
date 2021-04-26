package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.g;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes.dex */
public class RequsetNetworkUtils extends BaseUtils {
    public static final String TAG = "RequsetNetworkUtils";
    public static ConnectivityManager mConnManager;
    public static TelephonyManager mTelephonyManager;

    public static ConnectivityManager getConnectivityManager(Context context) {
        if (context == null) {
            return mConnManager;
        }
        if (context.checkCallingOrSelfPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) == 0 && mConnManager == null) {
            mConnManager = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return mConnManager;
    }

    public static String getHostUrl(Context context) {
        if (context == null) {
            LogUtils.e("RequsetNetworkUtils", "context is null");
            return null;
        }
        int readIntData = Utility.readIntData(context, Constants.KEY_ENV, 0);
        if (readIntData != 0) {
            if (readIntData == 1 || readIntData == 2) {
                return "http://rd-im-server.bcc-szth.baidu.com:8080/";
            }
            if (readIntData != 3) {
                return null;
            }
            return Constants.URL_HTTP_BOX;
        }
        return "https://pim.baidu.com/";
    }

    public static String getMobileIp(Context context) {
        String str = "nonMobileIp";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        str = nextElement.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception e2) {
            LogUtils.d("RequsetNetworkUtils", e2.getMessage());
        }
        return str;
    }

    public static String getMobileType(Context context) {
        String str;
        if (getTelephonyManager(context) != null) {
            int networkType = getTelephonyManager(context).getNetworkType();
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    str = "2G";
                    break;
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
                    str = g.f3962b;
                    break;
                case 13:
                case 18:
                    str = "4G";
                    break;
                default:
                    str = "";
                    break;
            }
            return str + "-" + networkType;
        }
        return "unKnow";
    }

    public static String getNetInfo(Context context) {
        if (isNetworkAvailable(context)) {
            if (isWifiConnected(context)) {
                return "wifi|" + getWifiIp(context);
            }
            return getOperatorName(context) + FieldBuilder.SE + getMobileIp(context) + FieldBuilder.SE + getMobileType(context);
        }
        return "nonNet";
    }

    public static NetworkInfo getNetWorkInfo(Context context) {
        NetworkInfo networkInfo = null;
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                LogUtils.d("RequsetNetworkUtils", "context is null !!!");
            }
            ConnectivityManager connectivityManager = getConnectivityManager(applicationContext);
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo == null) {
                    LogUtils.e("RequsetNetworkUtils", "networkInfo is null !!!");
                }
            } else {
                LogUtils.e("RequsetNetworkUtils", "connManager is null !!!");
            }
        } catch (Exception e2) {
            LogUtils.e("RequsetNetworkUtils", "exp: " + e2.getMessage());
        }
        return networkInfo;
    }

    public static String getOperatorName(Context context) {
        return getTelephonyManager(context) != null ? getTelephonyManager(context).getSimOperatorName() : "noPermission";
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        if (context == null) {
            return mTelephonyManager;
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && mTelephonyManager == null) {
            mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return mTelephonyManager;
    }

    public static String getWifiIp(Context context) {
        try {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
                return String.format("%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
            }
            return "nonWifiIp";
        } catch (Exception unused) {
            return "nonWifiIp";
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo netWorkInfo = getNetWorkInfo(context);
        if (netWorkInfo != null) {
            return netWorkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo netWorkInfo = getNetWorkInfo(context);
        return netWorkInfo != null && netWorkInfo.getType() == 1;
    }
}
