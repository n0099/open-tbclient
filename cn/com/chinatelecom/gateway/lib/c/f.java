package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.idl.util.NetUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class f {
    public static int a(int i) {
        int i2 = -101;
        if (i != -101) {
            i2 = -1;
            if (i != -1) {
                switch (i) {
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
        }
        return i2;
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
        return a2 != null && a2.getType() == 0;
    }

    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            CtAuth.warn(NetUtil.TAG, "isMobileEnable error ", th);
            return true;
        }
    }

    public static String e(Context context) {
        int h2 = h(context);
        return h2 != -101 ? (h2 == -1 || h2 == 0) ? StringUtil.NULL_STRING : h2 != 1 ? h2 != 2 ? h2 != 3 ? Integer.toString(h2) : "4G" : com.baidu.apollon.statistics.g.f3909b : "2G" : CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
    }

    public static String f(Context context) {
        String e2 = e(context);
        return (e2 != null && e2.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) && d(context)) ? "BOTH" : e2;
    }

    public static String g(Context context) {
        String f2 = f(context);
        if (!TextUtils.isEmpty(f2) && !f2.equals(StringUtil.NULL_STRING)) {
            if (f2.equals("2G")) {
                return "10";
            }
            if (f2.equals(com.baidu.apollon.statistics.g.f3909b)) {
                return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
            }
            if (f2.equals("4G")) {
                return Constants.VIA_REPORT_TYPE_SET_AVATAR;
            }
            if (f2.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING)) {
                return Constants.VIA_REPORT_TYPE_JOININ_GROUP;
            }
            if (f2.equals("BOTH")) {
                return Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            }
        }
        return Constants.VIA_REPORT_TYPE_WPA_STATE;
    }

    public static int h(Context context) {
        int i = 0;
        try {
            NetworkInfo a2 = a(context);
            if (a2 != null && a2.isAvailable() && a2.isConnected()) {
                int type = a2.getType();
                if (type == 1) {
                    i = -101;
                } else if (type == 0) {
                    try {
                        i = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (i == 0) {
                        i = a2.getSubtype();
                    }
                }
            } else {
                i = -1;
            }
        } catch (NullPointerException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return a(i);
    }
}
