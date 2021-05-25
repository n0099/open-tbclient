package com.baidu.android.pushservice.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static ConnectivityManager f3466a;

    /* renamed from: b  reason: collision with root package name */
    public static TelephonyManager f3467b;

    public static boolean a(Context context) {
        NetworkInfo c2 = c(context);
        if (c2 != null) {
            return c2.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean b(Context context) {
        NetworkInfo c2 = c(context);
        return c2 != null && c2.getType() == 1;
    }

    public static NetworkInfo c(Context context) {
        try {
            ConnectivityManager j = j(context.getApplicationContext());
            if (j != null) {
                return j.getActiveNetworkInfo();
            }
            return null;
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
            return null;
        }
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
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        str = nextElement.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception unused) {
        }
        return str;
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
                    str = com.baidu.apollon.statistics.g.f3966b;
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

    public static String h(Context context) {
        StringBuilder sb;
        String g2;
        if (a(context)) {
            if (b(context)) {
                sb = new StringBuilder();
                sb.append("wifi|");
                g2 = e(context);
            } else {
                sb = new StringBuilder();
                sb.append(d(context));
                sb.append(FieldBuilder.SE);
                sb.append(f(context));
                sb.append(FieldBuilder.SE);
                g2 = g(context);
            }
            sb.append(g2);
            return sb.toString();
        }
        return "nonNet";
    }

    public static String i(Context context) {
        if (a(context)) {
            NetworkInfo c2 = c(context);
            switch (c2 != null ? c2.getType() : -1) {
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

    public static ConnectivityManager j(Context context) {
        if (context == null) {
            return f3466a;
        }
        if (f3466a == null) {
            f3466a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f3466a;
    }

    public static TelephonyManager k(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            if (context == null) {
                return f3467b;
            }
            if (f3467b == null) {
                f3467b = (TelephonyManager) context.getSystemService("phone");
            }
        }
        return f3467b;
    }
}
