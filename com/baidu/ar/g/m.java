package com.baidu.ar.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes10.dex */
public final class m {
    public static boolean s(Context context) {
        NetworkInfo u = u(context);
        return u != null && u.isAvailable();
    }

    public static boolean t(Context context) {
        NetworkInfo u = u(context);
        return u != null && u.isAvailable() && u.getType() == 1;
    }

    private static NetworkInfo u(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static int v(Context context) {
        NetworkInfo u = u(context);
        if (u == null) {
            return Integer.MIN_VALUE;
        }
        if (u.isAvailable() && u.getType() == 0) {
            String subtypeName = u.getSubtypeName();
            switch (u.getSubtype()) {
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
                    return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : Integer.MIN_VALUE;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static String w(Context context) {
        if (!s(context) || context == null) {
            return "not_Reachable";
        }
        if (t(context)) {
            return "wifi";
        }
        int v = v(context);
        return v == 2 ? "2G" : v == 3 ? "3G" : v == 4 ? "4G" : "other_network";
    }
}
