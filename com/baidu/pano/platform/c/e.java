package com.baidu.pano.platform.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
/* loaded from: classes10.dex */
public class e {
    public static boolean a = false;
    public static String b = "";
    public static int c = 0;

    public static NetworkInfo a(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) {
        int i = 1;
        NetworkInfo a2 = a(context);
        if (a2 != null) {
            if (a2.getType() != 1) {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                        i = 6;
                        break;
                    case 3:
                    case 9:
                    case 10:
                    case 15:
                        i = 9;
                        break;
                    case 4:
                        i = 5;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 12:
                        i = 7;
                        break;
                    case 8:
                        i = 8;
                        break;
                    case 11:
                        i = 2;
                        break;
                    case 13:
                        i = 4;
                        break;
                    case 14:
                        i = 10;
                        break;
                }
            }
            return Integer.toString(i);
        }
        i = 0;
        return Integer.toString(i);
    }

    public static boolean c(Context context) {
        if (((WifiManager) context.getSystemService("wifi")).getWifiState() == 3) {
            return true;
        }
        if (((TelephonyManager) context.getSystemService("phone")).getSimState() != 5) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
