package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import cn.com.chinatelecom.account.api.CtAuth;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class e {
    private static int a(int i) {
        switch (i) {
            case -101:
                return -101;
            case -1:
                return -1;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 1;
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
                return 2;
            case 13:
            case 18:
            case 19:
                return 3;
            default:
                return i;
        }
    }

    public static NetworkInfo a(Context context) {
        if (context == null) {
            return null;
        }
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean b(Context context) {
        NetworkInfo a = a(context);
        return a != null && a.isAvailable();
    }

    public static boolean c(Context context) {
        NetworkInfo a = a(context);
        return a != null && a.getType() == 1;
    }

    public static boolean d(Context context) {
        NetworkInfo a = a(context);
        return a != null && a.getType() == 0;
    }

    public static boolean e(Context context) {
        if (context == null) {
            return true;
        }
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity"), new Object[0])).booleanValue();
        } catch (Throwable th) {
            CtAuth.warn("NetUtil", "isMobileEnable error ", th);
            return true;
        }
    }

    public static String f(Context context) {
        boolean c = c(context);
        boolean e = e(context);
        return (!c || e) ? (!e || c) ? (c && e) ? "1" : (c || e || !d(context)) ? "" : "0" : "0" : "2";
    }

    public static String g(Context context) {
        int h = h(context);
        switch (h) {
            case -101:
                return "wifi";
            case -1:
                return "unnet";
            case 0:
                return "-1";
            case 1:
                return "2g";
            case 2:
                return "3g";
            case 3:
                return "4g";
            default:
                return Integer.toString(h);
        }
    }

    private static int h(Context context) {
        int i;
        Exception e;
        NullPointerException e2;
        try {
            NetworkInfo a = a(context);
            if (a != null && a.isAvailable() && a.isConnected()) {
                int type = a.getType();
                if (type == 1) {
                    i = -101;
                } else if (type == 0) {
                    try {
                        i = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        i = 0;
                    }
                    if (i == 0) {
                        try {
                            i = a.getSubtype();
                        } catch (NullPointerException e4) {
                            e2 = e4;
                            e2.printStackTrace();
                            return a(i);
                        } catch (Exception e5) {
                            e = e5;
                            e.printStackTrace();
                            return a(i);
                        }
                    }
                } else {
                    i = 0;
                }
            } else {
                i = -1;
            }
        } catch (NullPointerException e6) {
            i = 0;
            e2 = e6;
            e2.printStackTrace();
            return a(i);
        } catch (Exception e7) {
            i = 0;
            e = e7;
            e.printStackTrace();
            return a(i);
        }
        return a(i);
    }
}
