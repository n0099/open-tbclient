package com.baidu.sapi2.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.SapiAccount;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class SapiUtils {
    public static final String KEY_QR_LOGIN_LP = "lp";
    public static final String KEY_QR_LOGIN_SIGN = "sign";
    public static final String QR_LOGIN_LP_APP = "app";
    public static final String QR_LOGIN_LP_PC = "pc";
    static final String a = "cmd";
    static final String b = "error";
    static final String c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";

    public static boolean isValidAccount(SapiAccount sapiAccount) {
        return (sapiAccount == null || TextUtils.isEmpty(sapiAccount.bduss) || TextUtils.isEmpty(sapiAccount.uid) || TextUtils.isEmpty(sapiAccount.displayname)) ? false : true;
    }

    public static boolean isValidUsername(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 14) {
            return false;
        }
        return true;
    }

    public static String getClientId(Context context) {
        try {
            return DeviceId.getDeviceID(context);
        } catch (Throwable th) {
            return "123456789";
        }
    }

    public static String getCUID(Context context) {
        try {
            return DeviceId.getDeviceID(context) + "|" + ((Object) TextUtils.getReverse(DeviceId.getIMEI(context), 0, DeviceId.getIMEI(context).length()));
        } catch (Throwable th) {
            L.e(th);
            return null;
        }
    }

    public static String getLocalIpAddress() {
        String hostAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (hostAddress = nextElement.getHostAddress()) != null && hostAddress.length() > 0) {
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable th) {
            L.e(th);
        }
        return null;
    }

    public static String createRequestParams(List<NameValuePair> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (NameValuePair nameValuePair : list) {
                if (!TextUtils.isEmpty(nameValuePair.getName()) && !TextUtils.isEmpty(nameValuePair.getValue())) {
                    if (TextUtils.isEmpty(sb.toString())) {
                        sb.append(nameValuePair.getName()).append("=").append(nameValuePair.getValue());
                    } else {
                        sb.append("&").append(nameValuePair.getName()).append("=").append(nameValuePair.getValue());
                    }
                }
            }
        }
        return sb.toString();
    }

    public static boolean isValidPhoneNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^(1)\\d{10}$").matcher(str).matches();
    }

    public static boolean isSimReady(Context context) {
        if (context == null || context.checkCallingOrSelfPermission("android.permission.SEND_SMS") != 0) {
            return false;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getSimState()) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
            case 3:
            case 4:
                return false;
            case 5:
                return true;
            default:
                return false;
        }
    }

    public static boolean hasActiveNetwork(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Throwable th) {
            L.e(th);
            return false;
        }
    }

    public static boolean webLogin(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String a2 = a(str);
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("http://www.baidu.com", a2);
            CookieSyncManager.getInstance().sync();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean webLogout(Context context) {
        if (context == null) {
            return false;
        }
        try {
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("http://www.baidu.com", "BDUSS=;domain=baidu.com;path=/");
            CookieSyncManager.getInstance().sync();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    static String a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, 8);
        return "BDUSS=" + str + ";domain=baidu.com;path=/;expires=" + simpleDateFormat.format(calendar.getTime());
    }

    public static List<String> getAuthorizedDomains(Context context) {
        return context == null ? Collections.emptyList() : com.baidu.sapi2.d.a(context).l();
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            L.e(th);
            return "0";
        }
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int dip2px(Context context, float f) {
        if (context == null) {
            throw new IllegalArgumentException("Context can't be null");
        }
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static boolean isQrLoginSchema(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(b) && str.contains(KEY_QR_LOGIN_SIGN) && str.contains("cmd") && str.contains(KEY_QR_LOGIN_LP)) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length > 1) {
                    hashMap.put(split[0], split[1]);
                } else if (split.length == 1) {
                    hashMap.put(split[0], "");
                }
            }
            return (TextUtils.isEmpty((CharSequence) hashMap.get(b)) || TextUtils.isEmpty((CharSequence) hashMap.get(KEY_QR_LOGIN_SIGN)) || TextUtils.isEmpty((CharSequence) hashMap.get("cmd")) || TextUtils.isEmpty((CharSequence) hashMap.get(KEY_QR_LOGIN_LP))) ? false : true;
        }
        return false;
    }

    public static Map<String, String> parseQrLoginSchema(String str) {
        HashMap hashMap = new HashMap();
        if (isQrLoginSchema(str)) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length > 1) {
                    hashMap.put(split[0], split[1]);
                } else if (split.length == 1) {
                    hashMap.put(split[0], "");
                }
            }
        }
        return hashMap;
    }

    public static boolean sendSms(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            SmsManager.getDefault().sendTextMessage(str2, null, str, PendingIntent.getBroadcast(context, 0, new Intent(), 0), null);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void resetSilentShareStatus(Context context) {
        if (context != null && com.baidu.sapi2.d.a(context).d() == null) {
            com.baidu.sapi2.d.a(context).i();
        }
    }

    public static String getFastRegChannel(Context context) {
        if (context != null) {
            String m = com.baidu.sapi2.d.a(context).m();
            if (!TextUtils.isEmpty(m)) {
                return m;
            }
        }
        return d.s;
    }
}
