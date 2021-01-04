package com.baidu.android.imsdk.upload.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes3.dex */
public class RequsetNetworkUtils {
    private static final String TAG = "RequsetNetworkUtils";
    private static ConnectivityManager mConnManager = null;
    private static TelephonyManager mTelephonyManager = null;

    private static ConnectivityManager getConnectivityManager(Context context) {
        if (context == null) {
            return mConnManager;
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && mConnManager == null) {
            mConnManager = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return mConnManager;
    }

    public static NetworkInfo getNetWorkInfo(Context context) {
        NetworkInfo networkInfo = null;
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                Log.d(TAG, "context is null !!!");
            }
            ConnectivityManager connectivityManager = getConnectivityManager(applicationContext);
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo == null) {
                    Log.e(TAG, "networkInfo is null !!!");
                }
            } else {
                Log.e(TAG, "connManager is null !!!");
            }
        } catch (Exception e) {
            Log.e(TAG, "exp: " + e.getMessage());
        }
        return networkInfo;
    }

    private static TelephonyManager getTelephonyManager(Context context) {
        if (context == null) {
            return mTelephonyManager;
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && mTelephonyManager == null) {
            mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return mTelephonyManager;
    }

    public static String getOperatorName(Context context) {
        if (getTelephonyManager(context) != null) {
            return getTelephonyManager(context).getSimOperatorName();
        }
        return "noPermission";
    }

    public static String getWifiIp(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {
            return "nonWifiIp";
        }
        int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
        return String.format("%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:5:0x0008, B:7:0x000e, B:8:0x0018, B:10:0x001e, B:12:0x002a, B:14:0x002e), top: B:24:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMobileIp(Context context) {
        Exception e;
        String str = "nonMobileIp";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            String str2 = "nonMobileIp";
            while (!networkInterfaces.hasMoreElements()) {
                try {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            str2 = (nextElement.isLoopbackAddress() || !(nextElement instanceof Inet4Address)) ? str2 : nextElement.getHostAddress().toString();
                        }
                    }
                    if (!networkInterfaces.hasMoreElements()) {
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = str2;
                    Log.d(TAG, "getMobileIp exception :" + e.getMessage());
                    return str;
                }
            }
            return str2;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static String getMobileType(Context context) {
        String str;
        if (getTelephonyManager(context) == null) {
            return "unKnow";
        }
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
                str = "3G";
                break;
            case 13:
            case 18:
                str = "4G";
                break;
            default:
                str = "";
                break;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + networkType;
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

    public static String getNetInfo(Context context) {
        if (isNetworkAvailable(context)) {
            if (isWifiConnected(context)) {
                return "wifi|" + getWifiIp(context);
            }
            return getOperatorName(context) + "|" + getMobileIp(context) + "|" + getMobileType(context);
        }
        return "nonNet";
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
