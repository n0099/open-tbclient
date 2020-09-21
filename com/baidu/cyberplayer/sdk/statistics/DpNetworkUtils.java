package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes10.dex */
public class DpNetworkUtils {
    public static String a(Context context) {
        WifiInfo connectionInfo;
        int rssi;
        NetworkInfo b = b(context);
        if (b != null) {
            int type = b.getType();
            if (type == 0) {
                String extraInfo = b.getExtraInfo();
                return TextUtils.isEmpty(extraInfo) ? "Disconnect" : extraInfo;
            } else if (type == 1) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (rssi = connectionInfo.getRssi()) <= -127) ? "Disconnect" : "wifi:" + rssi;
            } else {
                return "N/A";
            }
        }
        return "Disconnect";
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean a(Context context, String str) {
        return str != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private static NetworkInfo b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
        } catch (Exception e) {
        }
        return null;
    }

    private static boolean c(Context context) {
        if (a()) {
            if (context != null) {
                try {
                    boolean z = a(context, "android.permission.CALL_PHONE") || a(context, "android.permission.MODIFY_PHONE_STATE") || a(context, "android.permission.READ_PHONE_STATE") || a(context, "android.permission.PROCESS_OUTGOING_CALLS");
                    if (Build.VERSION.SDK_INT >= 16) {
                        if (!z) {
                            if (!a(context, "android.permission.READ_CALL_LOG")) {
                                return false;
                            }
                        }
                        return true;
                    }
                    return z;
                } catch (Throwable th) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    @Keep
    public static String getNetworkStatisticsData(Context context) {
        int i;
        TelephonyManager telephonyManager;
        String subscriberId;
        int i2;
        int i3 = 3;
        NetworkInfo b = b(context);
        if (b == null) {
            i = 0;
        } else if (b.getState() != NetworkInfo.State.CONNECTED) {
            i = 0;
        } else if (b.getType() == 0) {
            switch (b.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    i2 = 2;
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
                    i2 = 3;
                    break;
                case 13:
                    i2 = 4;
                    break;
                default:
                    i2 = 1;
                    break;
            }
            i = i2;
        } else {
            i = b.getType() == 1 ? 100 : b.getType() == 9 ? 101 : 999;
        }
        try {
            if (!c(context) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (subscriberId = telephonyManager.getSubscriberId()) == null) {
                i3 = 0;
            } else if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002")) {
                i3 = 1;
            } else if (!subscriberId.startsWith("46001")) {
                i3 = subscriberId.startsWith("46003") ? 2 : 99;
            }
        } catch (Throwable th) {
            CyberLog.e("DpNetworkUtils", "network changed: " + th);
            i3 = 99;
        }
        return i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i3;
    }
}
