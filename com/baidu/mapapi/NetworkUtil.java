package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
/* loaded from: classes2.dex */
public class NetworkUtil {
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCurrentNetMode(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        int i2 = 1;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 1) {
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

    public static boolean initConnectState() {
        return true;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            if (isWifiConnected(context)) {
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r3.isConnected() != false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isWifiConnected(NetworkInfo networkInfo) {
        boolean z = true;
        if (networkInfo != null) {
            try {
                if (1 == networkInfo.getType()) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        z = false;
        return z;
    }

    public static boolean isWifiState(Context context) {
        if (context == null) {
            return false;
        }
        int i2 = -1;
        try {
            i2 = ((WifiManager) context.getSystemService("wifi")).getWifiState();
        } catch (Exception unused) {
        }
        return i2 == 3;
    }

    public static void updateNetworkProxy(Context context) {
        SysUpdateObservable.getInstance().updateNetworkProxy(context);
    }
}
