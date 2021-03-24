package com.baidu.mobads.production.cpu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: classes2.dex */
public class b {
    public static int a(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo2 == null || !a(networkInfo2.getState())) {
            if (Build.VERSION.SDK_INT < 13 || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || !a(networkInfo.getState())) {
                NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
                if (networkInfo3 == null || !a(networkInfo3.getState())) {
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

    public static boolean a(NetworkInfo.State state) {
        return state != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING);
    }
}
