package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import cn.com.chinatelecom.account.api.CtAuth;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
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
        NetworkInfo a2 = a(context);
        return a2 != null && a2.isAvailable();
    }

    public static boolean c(Context context) {
        NetworkInfo a2 = a(context);
        return a2 != null && a2.getType() == 1;
    }

    public static boolean d(Context context) {
        NetworkInfo a2 = a(context);
        return a2 != null && a2.getType() == 0;
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
        try {
            NetworkInfo a2 = a(context);
            if (a2 != null && a2.isAvailable() && a2.isConnected()) {
                int type = a2.getType();
                if (type == 1) {
                    i = -101;
                } else if (type == 0) {
                    try {
                        i = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                    } catch (Exception e) {
                        e.printStackTrace();
                        i = 0;
                    }
                    if (i == 0) {
                        try {
                            i = a2.getSubtype();
                        } catch (NullPointerException e2) {
                            e = e2;
                            e.printStackTrace();
                            return a(i);
                        } catch (Exception e3) {
                            e = e3;
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
        } catch (NullPointerException e4) {
            e = e4;
            i = 0;
            e.printStackTrace();
            return a(i);
        } catch (Exception e5) {
            e = e5;
            i = 0;
            e.printStackTrace();
            return a(i);
        }
        return a(i);
    }
}
