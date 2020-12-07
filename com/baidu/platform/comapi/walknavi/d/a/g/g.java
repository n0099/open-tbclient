package com.baidu.platform.comapi.walknavi.d.a.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
/* loaded from: classes26.dex */
public final class g {
    public static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static boolean b(Context context) {
        boolean z;
        try {
            if (c(context)) {
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnectedOrConnecting()) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean c(Context context) {
        ConnectivityManager connectivityManager;
        boolean z;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (1 == activeNetworkInfo.getType()) {
                    if (activeNetworkInfo.isConnected()) {
                        z = true;
                    }
                }
                z = false;
            } else {
                z = false;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean d(Context context) {
        int i;
        if (context == null) {
            return false;
        }
        try {
            i = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getWifiState();
        } catch (Exception e) {
            i = -1;
        }
        return i == 3;
    }
}
