package com.baidu.pano.platform.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f9330a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f9331b = "";

    /* renamed from: c  reason: collision with root package name */
    public static int f9332c;

    public static NetworkInfo a(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) {
        NetworkInfo a2 = a(context);
        int i2 = 1;
        if (a2 != null) {
            if (a2.getType() != 1) {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                        i2 = 6;
                        break;
                    case 3:
                    case 9:
                    case 10:
                    case 15:
                        i2 = 9;
                        break;
                    case 4:
                        i2 = 5;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 12:
                        i2 = 7;
                        break;
                    case 8:
                        i2 = 8;
                        break;
                    case 11:
                        i2 = 2;
                        break;
                    case 13:
                        i2 = 4;
                        break;
                    case 14:
                        i2 = 10;
                        break;
                }
            }
            return Integer.toString(i2);
        }
        i2 = 0;
        return Integer.toString(i2);
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        if (((WifiManager) context.getSystemService("wifi")).getWifiState() == 3) {
            return true;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() == 5 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
