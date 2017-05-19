package com.baidu.android.pushservice.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class k {
    private static ConnectivityManager a = null;

    public static boolean a(Context context) {
        NetworkInfo c = c(context);
        if (c != null) {
            return c.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean b(Context context) {
        NetworkInfo c = c(context);
        return c != null && c.getType() == 1;
    }

    public static NetworkInfo c(Context context) {
        NetworkInfo networkInfo = null;
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                com.baidu.android.pushservice.e.a.d("NetworkCheck", "context is null !!!");
            }
            ConnectivityManager f = f(applicationContext);
            if (f != null) {
                networkInfo = f.getActiveNetworkInfo();
                if (networkInfo == null) {
                    com.baidu.android.pushservice.e.a.d("NetworkCheck", "networkInfo is null !!!");
                }
            } else {
                com.baidu.android.pushservice.e.a.d("NetworkCheck", "connManager is null !!!");
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.e("NetworkCheck", "exp: " + e.getMessage());
        }
        return networkInfo;
    }

    public static String d(Context context) {
        if (a(context)) {
            NetworkInfo c = c(context);
            switch (c != null ? c.getType() : -1) {
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

    public static boolean e(Context context) {
        boolean a2 = a(context);
        if (a2 || !u.s(context, "android.permission.INTERNET")) {
            return a2;
        }
        try {
            com.baidu.android.pushservice.d.a a3 = com.baidu.android.pushservice.d.b.a(com.baidu.android.pushservice.h.a(), "GET", (HashMap<String, String>) null);
            if (a3.b() != 0) {
                if (a3.a() != null) {
                    return true;
                }
                return a2;
            }
            return a2;
        } catch (Exception e) {
            return a2;
        }
    }

    private static ConnectivityManager f(Context context) {
        if (context == null) {
            return a;
        }
        if (a == null) {
            a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return a;
    }
}
