package com.baidu.android.pushservice.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.xiaomi.mipush.sdk.Constants;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static ConnectivityManager f1429a = null;

    /* renamed from: b  reason: collision with root package name */
    private static TelephonyManager f1430b = null;

    public static boolean a(Context context) {
        NetworkInfo c = c(context);
        if (c != null) {
            return c.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean b(Context context) {
        NetworkInfo c = c(context);
        return c != null && c.getType() == 1;
    }

    public static NetworkInfo c(Context context) {
        NetworkInfo networkInfo = null;
        try {
            context = context.getApplicationContext();
            if (context == null) {
            }
            ConnectivityManager j = j(context);
            if (j != null) {
                networkInfo = j.getActiveNetworkInfo();
                if (networkInfo == null) {
                }
            }
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
        }
        return networkInfo;
    }

    public static String d(Context context) {
        return k(context) != null ? k(context).getSimOperatorName() : "noPermission";
    }

    public static String e(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
            return String.format("%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
        }
        return "nonWifiIp";
    }

    public static String f(Context context) {
        String str = "nonMobileIp";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    str = (nextElement.isLoopbackAddress() || !(nextElement instanceof Inet4Address)) ? str : nextElement.getHostAddress().toString();
                }
            }
            return str;
        } catch (Exception e) {
            return str;
        }
    }

    public static String g(Context context) {
        String str;
        if (k(context) != null) {
            int networkType = k(context).getNetworkType();
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
        return "unKnow";
    }

    public static String h(Context context) {
        return a(context) ? b(context) ? "wifi|" + e(context) : d(context) + "|" + f(context) + "|" + g(context) : "nonNet";
    }

    public static String i(Context context) {
        if (a(context)) {
            NetworkInfo c = c(context);
            switch (c != null ? c.getType() : -1) {
                case 0:
                    return "mobile";
                case 1:
                    return "wifi";
                case 2:
                    return "mobile_mms";
                case 3:
                    return "mobile_supl";
                case 4:
                    return "mobile_dun";
                case 5:
                    return "mobile_hipri";
                case 6:
                    return "wimax";
                default:
                    return "connectionless";
            }
        }
        return "connectionless";
    }

    private static ConnectivityManager j(Context context) {
        if (context == null) {
            return f1429a;
        }
        if (f1429a == null) {
            f1429a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f1429a;
    }

    private static TelephonyManager k(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            if (context == null) {
                return f1430b;
            }
            if (f1430b == null) {
                f1430b = (TelephonyManager) context.getSystemService("phone");
            }
        }
        return f1430b;
    }
}
