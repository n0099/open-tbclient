package com.baidu.mobads.container.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: classes2.dex */
public class ConnectionType {
    public static final int TYPE_2G = 2;
    public static final int TYPE_3G = 3;
    public static final int TYPE_4G = 4;
    public static final int TYPE_5G = 5;
    public static final int TYPE_CELL_UNKNOWN = 1;
    public static final int TYPE_ETHERNET = 101;
    public static final int TYPE_UNKNOWN = 999;
    public static final int TYPE_UNREACHABLE = 0;
    public static final int TYPE_WIFI = 100;

    public static int get(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo2 == null || !isConnectedOrConnecting(networkInfo2.getState())) {
            if (Build.VERSION.SDK_INT < 13 || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || !isConnectedOrConnecting(networkInfo.getState())) {
                NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
                if (networkInfo3 == null || !isConnectedOrConnecting(networkInfo3.getState())) {
                    return 999;
                }
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                    default:
                        return 1;
                }
            }
            return 101;
        }
        return 100;
    }

    public static boolean isConnectedOrConnecting(NetworkInfo.State state) {
        return state != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING);
    }
}
