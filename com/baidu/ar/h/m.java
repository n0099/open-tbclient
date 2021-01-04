package com.baidu.ar.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes6.dex */
public final class m {
    public static boolean t(Context context) {
        NetworkInfo v = v(context);
        return v != null && v.isAvailable();
    }

    public static boolean u(Context context) {
        NetworkInfo v = v(context);
        return v != null && v.isAvailable() && v.getType() == 1;
    }

    private static NetworkInfo v(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static int w(Context context) {
        NetworkInfo v = v(context);
        if (v == null) {
            return Integer.MIN_VALUE;
        }
        if (v.isAvailable() && v.getType() == 0) {
            String subtypeName = v.getSubtypeName();
            switch (v.getSubtype()) {
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

    public static String x(Context context) {
        if (!t(context) || context == null) {
            return "not_Reachable";
        }
        if (u(context)) {
            return "wifi";
        }
        int w = w(context);
        return w == 2 ? "2G" : w == 3 ? "3G" : w == 4 ? "4G" : "other_network";
    }
}
