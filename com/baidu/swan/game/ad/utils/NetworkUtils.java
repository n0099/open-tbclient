package com.baidu.swan.game.ad.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class NetworkUtils {

    /* loaded from: classes3.dex */
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

    public static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager;
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(int i2, String str) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3g";
            case 13:
            case 18:
            case 19:
                break;
            default:
                if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) {
                    return "unknown";
                }
                break;
        }
        return "4g";
    }

    public static int c(boolean z) {
        char c2;
        String d2 = d();
        int hashCode = d2.hashCode();
        if (hashCode == -284840886) {
            if (d2.equals("unknown")) {
                c2 = 4;
            }
            c2 = 65535;
        } else if (hashCode == 1653) {
            if (d2.equals("2g")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode == 1684) {
            if (d2.equals("3g")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 1715) {
            if (hashCode == 3649301 && d2.equals("wifi")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (d2.equals("4g")) {
                c2 = 3;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            return z ? 1 : 100;
        } else if (c2 != 1) {
            if (c2 != 2) {
                if (c2 != 3) {
                    if (c2 != 4) {
                        return 0;
                    }
                    return !z ? 1 : 0;
                }
                return 4;
            }
            return 3;
        } else {
            return 2;
        }
    }

    public static String d() {
        NetworkInfo a2 = a(AppRuntime.getAppContext());
        return (a2 == null || !a2.isConnected()) ? "no" : a2.getType() == 1 ? "wifi" : a2.getType() == 0 ? b(a2.getSubtype(), a2.getSubtypeName()) : "unknown";
    }

    @SuppressLint({"HardwareIds"})
    public static String e(Context context) {
        String str;
        try {
            str = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static boolean f(Context context) {
        NetworkInfo a2 = a(AppRuntime.getAppContext());
        return a2 != null && a2.isConnectedOrConnecting();
    }

    public static boolean g(Context context) {
        NetworkInfo a2 = a(AppRuntime.getAppContext());
        return a2 != null && a2.isAvailable() && a2.getType() == 1;
    }
}
