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
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class SapiUtils {
    public static final String KEY_QR_LOGIN_LP = "lp";
    public static final String KEY_QR_LOGIN_SIGN = "sign";
    public static final int NETWORK_OPERATOR_MOBILE = 1;
    public static final int NETWORK_OPERATOR_TELECOM = 3;
    public static final int NETWORK_OPERATOR_UNICOM = 2;
    public static final int NETWORK_OPERATOR_UNKOWN = 0;
    public static final String QR_LOGIN_LP_APP = "app";
    public static final String QR_LOGIN_LP_PC = "pc";
    static final String a = "cmd";
    static final String b = "error";

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
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            return connectivityManager.getActiveNetworkInfo() != null;
        } catch (Throwable th) {
            return false;
        }
    }

    public static int readNetworkOperatorType(Context context) {
        int i;
        String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (TextUtils.isEmpty(networkOperator)) {
            return 0;
        }
        if (networkOperator.length() < 3 || networkOperator.substring(0, 3).equals("460")) {
            if (networkOperator.length() > 3) {
                try {
                    i = Integer.parseInt(networkOperator.substring(3));
                } catch (NumberFormatException e) {
                    L.e(e);
                    i = 0;
                }
                switch (i) {
                    case 0:
                    case 2:
                    case 7:
                        return 1;
                    case 1:
                    case 6:
                        return 2;
                    case 3:
                    case 5:
                        return 3;
                }
            }
            return 0;
        }
        return 0;
    }

    public static boolean webLogin(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("http://www.baidu.com", "BDUSS=" + str + ";domain=baidu.com;path=/");
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

    public static List<String> getAuthorizedDomains(Context context) {
        return context == null ? Collections.emptyList() : com.baidu.sapi2.c.a(context).j().g();
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getAppName(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(str, 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e) {
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

    public static int dip2px(Context context, float f) {
        if (context == null) {
            throw new IllegalArgumentException("Context can't be null");
        }
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        if (context == null) {
            throw new IllegalArgumentException("Context can't be null");
        }
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
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
}
