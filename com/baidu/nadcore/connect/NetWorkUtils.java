package com.baidu.nadcore.connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes2.dex */
public class NetWorkUtils {
    public static NetworkInfo a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean b(Context context) {
        NetworkInfo a = a(context);
        if (a != null && a.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static boolean c(Context context) {
        NetworkInfo a = a(context);
        if (a != null && a.isAvailable() && a.getType() == 1) {
            return true;
        }
        return false;
    }

    /* loaded from: classes2.dex */
    public enum NetType {
        NONE("no"),
        WIFI("wifi"),
        _2G("2g"),
        _3G("3g"),
        _4G("4g"),
        _5G("5g"),
        UNKOWN("unknow");
        
        public final String type;

        NetType(String str) {
            this.type = str;
        }
    }
}
