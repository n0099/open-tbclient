package com.baidu.ar.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes3.dex */
public final class k {
    public static boolean a(Context context) {
        NetworkInfo b = b(context);
        return b != null && b.isAvailable() && b.getType() == 1;
    }

    public static NetworkInfo b(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static boolean c(Context context) {
        NetworkInfo b = b(context);
        return b != null && b.isAvailable() && b.getType() == 0;
    }

    public static int d(Context context) {
        NetworkInfo b = b(context);
        if (b != null && b.isAvailable() && b.getType() == 0) {
            String subtypeName = b.getSubtypeName();
            switch (b.getSubtype()) {
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
                    if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                        return 3;
                    }
                    break;
            }
        }
        return Integer.MIN_VALUE;
    }
}
