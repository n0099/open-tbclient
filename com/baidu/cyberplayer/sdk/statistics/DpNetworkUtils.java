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
/* loaded from: classes.dex */
public class DpNetworkUtils {
    public static String a(Context context) {
        WifiInfo connectionInfo;
        int rssi;
        NetworkInfo b2 = b(context);
        if (b2 != null) {
            int type = b2.getType();
            if (type == 0) {
                String extraInfo = b2.getExtraInfo();
                return TextUtils.isEmpty(extraInfo) ? "Disconnect" : extraInfo;
            } else if (type == 1) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (rssi = connectionInfo.getRssi()) <= -127) {
                    return "Disconnect";
                }
                return "wifi:" + rssi;
            } else {
                return "N/A";
            }
        }
        return "Disconnect";
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean a(Context context, String str) {
        return str != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static NetworkInfo b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context) {
        boolean z;
        boolean z2 = true;
        if (!a()) {
            return true;
        }
        if (context == null) {
            return false;
        }
        try {
            if (!a(context, "android.permission.CALL_PHONE") && !a(context, "android.permission.MODIFY_PHONE_STATE") && !a(context, "android.permission.READ_PHONE_STATE") && !a(context, "android.permission.PROCESS_OUTGOING_CALLS")) {
                z = false;
                if (Build.VERSION.SDK_INT < 16) {
                    if (!z) {
                        if (!a(context, "android.permission.READ_CALL_LOG")) {
                            z2 = false;
                        }
                    }
                    return z2;
                }
                return z;
            }
            z = true;
            if (Build.VERSION.SDK_INT < 16) {
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    @Keep
    public static String getNetworkStatisticsData(Context context) {
        int i;
        TelephonyManager telephonyManager;
        String subscriberId;
        NetworkInfo b2 = b(context);
        int i2 = 3;
        if (b2 == null || b2.getState() != NetworkInfo.State.CONNECTED) {
            i = 0;
        } else if (b2.getType() == 0) {
            switch (b2.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    i = 2;
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
                    i = 3;
                    break;
                case 13:
                    i = 4;
                    break;
                default:
                    i = 1;
                    break;
            }
        } else {
            i = b2.getType() == 1 ? 100 : b2.getType() == 9 ? 101 : 999;
        }
        int i3 = 99;
        try {
            if (!c(context) || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (subscriberId = telephonyManager.getSubscriberId()) == null) {
                i2 = 0;
            } else {
                if (!subscriberId.startsWith("46000") && !subscriberId.startsWith("46002") && !subscriberId.startsWith("46007") && !subscriberId.startsWith("46008")) {
                    if (!subscriberId.startsWith("46001") && !subscriberId.startsWith("46006") && !subscriberId.startsWith("46009")) {
                        if (!subscriberId.startsWith("46003") && !subscriberId.startsWith("46005")) {
                            if (!subscriberId.startsWith("460011")) {
                                i2 = 99;
                            }
                        }
                        i2 = 2;
                    }
                }
                i2 = 1;
            }
            i3 = i2;
        } catch (Throwable th) {
            CyberLog.e("DpNetworkUtils", "network changed: " + th);
        }
        return i + "_" + i3;
    }
}
