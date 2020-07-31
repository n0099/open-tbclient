package com.baidu.ar.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes11.dex */
public final class k {
    public static boolean r(Context context) {
        NetworkInfo t = t(context);
        return t != null && t.isAvailable();
    }

    public static boolean s(Context context) {
        NetworkInfo t = t(context);
        return t != null && t.isAvailable() && t.getType() == 1;
    }

    private static NetworkInfo t(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static int u(Context context) {
        NetworkInfo t = t(context);
        if (t == null) {
            return Integer.MIN_VALUE;
        }
        if (t.isAvailable() && t.getType() == 0) {
            String subtypeName = t.getSubtypeName();
            switch (t.getSubtype()) {
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

    public static String v(Context context) {
        if (!r(context) || context == null) {
            return "not_Reachable";
        }
        if (s(context)) {
            return "wifi";
        }
        int u = u(context);
        return u == 2 ? "2G" : u == 3 ? "3G" : u == 4 ? "4G" : "other_network";
    }
}
