package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes.dex */
public class g {
    public static ConnectivityManager a;

    public static ConnectivityManager a(Context context) {
        if (context == null) {
            return a;
        }
        if (a == null) {
            a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return a;
    }

    public static NetworkInfo b(Context context) {
        try {
            ConnectivityManager a2 = a(context.getApplicationContext());
            if (a2 != null) {
                return a2.getActiveNetworkInfo();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String c(Context context) {
        if (d(context)) {
            NetworkInfo b = b(context);
            switch (b != null ? b.getType() : -1) {
                case 0:
                    return "mobile";
                case 1:
                    return "wifi";
                case 2:
                    return "mobile_mms";
                case 3:
                    return "mobile_supl";
                case 4:
                    return "mobile_dun";
                case 5:
                    return "mobile_hipri";
                case 6:
                    return "wimax";
                default:
                    return "connectionless";
            }
        }
        return "connectionless";
    }

    public static boolean d(Context context) {
        NetworkInfo b = b(context);
        if (b != null) {
            return b.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean e(Context context) {
        NetworkInfo b = b(context);
        return b != null && b.getType() == 1;
    }
}
