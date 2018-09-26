package cn.jiguang.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes3.dex */
public final class k {
    public static int a(Context context) {
        String c = c(context);
        if (!TextUtils.isEmpty(c)) {
            if ("wifi".equals(c)) {
                return 1;
            }
            if ("2g".equals(c)) {
                return 2;
            }
            if ("3g".equals(c)) {
                return 3;
            }
            if ("4g".equals(c)) {
                return 4;
            }
        }
        return 0;
    }

    public static String a(Context context, int i) {
        String c = c(context);
        if (TextUtils.isEmpty(c)) {
            try {
                Object a = cn.jiguang.f.a.a(TelephonyManager.class, "getNetworkClass", new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
                if (((Integer) a).intValue() == 0) {
                    c = "unknown";
                } else if (((Integer) a).intValue() == 1) {
                    c = "2g";
                } else if (((Integer) a).intValue() == 2) {
                    c = "3g";
                } else {
                    c = ((Integer) a).intValue() == 3 ? "4g" : c;
                }
            } catch (IllegalAccessException e) {
            } catch (NoSuchMethodException e2) {
            } catch (InvocationTargetException e3) {
            } catch (Exception e4) {
            }
        }
        return TextUtils.isEmpty(c) ? "unknown" : c;
    }

    public static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkOperator();
        } catch (Exception e) {
            return "";
        }
    }

    public static String c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (activeNetworkInfo == null) {
            return "unknown";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
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
                    return "3g";
                case 13:
                    return "4g";
                default:
                    return subtype == 16 ? "2g" : subtype == 17 ? "3g" : subtype == 18 ? "4g" : "unknown";
            }
        }
        return "";
    }
}
