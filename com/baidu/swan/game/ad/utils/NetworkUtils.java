package com.baidu.swan.game.ad.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
/* loaded from: classes3.dex */
public class NetworkUtils {
    public static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager;
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    @SuppressLint({"HardwareIds"})
    public static String e(Context context) {
        String str;
        try {
            str = ApiReplaceUtil.getMacAddress(((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo());
        } catch (Exception unused) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static boolean f(Context context) {
        NetworkInfo a = a(AppRuntime.getAppContext());
        if (a != null && a.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static boolean g(Context context) {
        NetworkInfo a = a(AppRuntime.getAppContext());
        if (a != null && a.isAvailable() && a.getType() == 1) {
            return true;
        }
        return false;
    }

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

    public static String b(int i, String str) {
        switch (i) {
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
                return "4g";
            case 20:
                return "5g";
            default:
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("LTE_CA")) {
                    return "4g";
                }
                return "unknown";
        }
    }

    public static int c(boolean z) {
        char c;
        String d = d();
        int hashCode = d.hashCode();
        if (hashCode != -284840886) {
            if (hashCode != 1653) {
                if (hashCode != 1684) {
                    if (hashCode != 1715) {
                        if (hashCode != 1746) {
                            if (hashCode == 3649301 && d.equals("wifi")) {
                                c = 0;
                            }
                            c = 65535;
                        } else {
                            if (d.equals("5g")) {
                                c = 4;
                            }
                            c = 65535;
                        }
                    } else {
                        if (d.equals("4g")) {
                            c = 3;
                        }
                        c = 65535;
                    }
                } else {
                    if (d.equals("3g")) {
                        c = 2;
                    }
                    c = 65535;
                }
            } else {
                if (d.equals("2g")) {
                    c = 1;
                }
                c = 65535;
            }
        } else {
            if (d.equals("unknown")) {
                c = 5;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c == 1) {
                return 2;
            }
            if (c == 2) {
                return 3;
            }
            if (c == 3) {
                return 4;
            }
            if (c == 4) {
                return 5;
            }
            if (c != 5) {
                return 0;
            }
            return !z ? 1 : 0;
        } else if (z) {
            return 1;
        } else {
            return 100;
        }
    }

    public static String d() {
        NetworkInfo a = a(AppRuntime.getAppContext());
        if (a != null && a.isConnected()) {
            if (a.getType() == 1) {
                return "wifi";
            }
            if (a.getType() == 0) {
                return b(a.getSubtype(), a.getSubtypeName());
            }
            return "unknown";
        }
        return "no";
    }
}
