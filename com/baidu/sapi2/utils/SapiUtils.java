package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.provider.Telephony;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class SapiUtils implements NoProguard {
    public static final String COOKIE_HTTPS_URL_PREFIX = "https://";
    public static final String COOKIE_URL_PREFIX = "https://www.";
    public static final String KEY_QR_LOGIN_LP = "lp";
    public static final String KEY_QR_LOGIN_SIGN = "sign";
    public static final int MAX_WIFI_LIST = 10;
    public static final int NETWORK_TYPE_1XRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final String QR_LOGIN_LP_APP = "app";
    public static final String QR_LOGIN_LP_PC = "pc";
    static final String a = "cmd";
    static final String b = "error";
    static final String c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    static final String d = Character.toString(2);
    static final String e = Character.toString(3);
    private static String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(3)
    public static String a(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
        } catch (Exception e2) {
            Log.e(e2);
            return "";
        }
    }

    private static boolean b(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("qrsign") && str.contains("scope") && str.contains("channelid") && str.contains("client_id")) {
            Map<String, String> urlParamsToMap = urlParamsToMap(str);
            return (TextUtils.isEmpty(urlParamsToMap.get("qrsign")) || TextUtils.isEmpty(urlParamsToMap.get("scope")) || TextUtils.isEmpty(urlParamsToMap.get("channelid")) || TextUtils.isEmpty(urlParamsToMap.get("client_id"))) ? false : true;
        }
        return false;
    }

    public static String buildBDUSSCookie(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, calendar.getTime(), false);
    }

    public static String buildCuidCookie(String str, String str2) {
        return "cuid=" + str2 + ";domain=" + str + ";path=/;httponly";
    }

    public static String buildDarkModeCookie(String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, TextUtils.isEmpty(str2) ? -1 : 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return "passtheme=" + str2 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(calendar.getTime());
    }

    public static String buildDeviceInfoCookie(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, calendar.getTime(), true);
    }

    public static String buildIqiyiCookie(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, TextUtils.isEmpty(str3) ? -2 : 2);
        return a(str, str2, str3, calendar.getTime(), false);
    }

    public static String buildPtokenCookie(String str, String str2) {
        return a(str, "PTOKEN", str2);
    }

    public static String buildSidCookie(String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, 7);
        return a(str, UbcStatConstant.KEY_CONTENT_EXT_SID, str2, calendar.getTime(), false);
    }

    public static String buildStokenCookie(String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str2) ? -8 : 8);
        return a(str, "STOKEN", str2, calendar.getTime(), true);
    }

    public static String calculateSig(Map<String, String> map, String str) {
        map.remove("sig");
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            arrayList.add(str2);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            try {
                String str4 = map.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    sb.append(str3).append(ETAG.EQUAL).append(URLEncoder.encode(str4, "UTF-8")).append(ETAG.ITEM_SEPARATOR);
                }
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
        }
        sb.append("sign_key=").append(str);
        return SecurityUtil.md5(sb.toString().getBytes(), false);
    }

    @TargetApi(23)
    public static boolean checkRequestPermission(String str, Context context) {
        try {
            if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) != 0) {
                if (Build.VERSION.SDK_INT >= 23) {
                    return false;
                }
                if (context.checkCallingOrSelfPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static String createRequestParams(List<PassNameValuePair> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (PassNameValuePair passNameValuePair : list) {
                if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                    if (TextUtils.isEmpty(sb.toString())) {
                        sb.append(passNameValuePair.getName()).append(ETAG.EQUAL).append(passNameValuePair.getValue());
                    } else {
                        sb.append(ETAG.ITEM_SEPARATOR).append(passNameValuePair.getName()).append(ETAG.EQUAL).append(passNameValuePair.getValue());
                    }
                }
            }
        }
        return sb.toString();
    }

    public static int dip2px(Context context, float f2) {
        if (context != null) {
            return (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        }
        throw new IllegalArgumentException("Context can't be null");
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static List<String> getAuthorizedDomains() {
        return SapiContext.getInstance().getAuthorizedDomains();
    }

    public static List<String> getAuthorizedDomainsForPtoken() {
        return SapiContext.getInstance().getAuthorizedDomainsForPtoken();
    }

    public static String getClientId(Context context) {
        try {
            return DeviceId.getDeviceID(context);
        } catch (Throwable th) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            return "123456789" + SecurityUtil.md5(String.valueOf(random.nextInt(100)).getBytes(), false);
        }
    }

    public static String getCookie(String str, String str2) {
        int indexOf;
        try {
            CookieSyncManager.createInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
            String cookie = CookieManager.getInstance().getCookie(str);
            if (TextUtils.isEmpty(cookie)) {
                return "";
            }
            for (String str3 : cookie.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                String trim = str3.trim();
                if (!TextUtils.isEmpty(trim) && (indexOf = trim.indexOf(ETAG.EQUAL)) > -1) {
                    String[] strArr = new String[2];
                    strArr[0] = trim.substring(0, indexOf);
                    int i = indexOf + 1;
                    if (i < trim.length()) {
                        strArr[1] = trim.substring(i, trim.length());
                    }
                    if (strArr[0].equals(str2)) {
                        return strArr[1];
                    }
                }
            }
            return "";
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    public static String getCookieBduss() {
        return getCookie(f.a(f.l), "BDUSS");
    }

    public static String getCookiePtoken() {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String cookie = getCookie(confignation.environment.getWap(), "PTOKEN");
        return TextUtils.isEmpty(cookie) ? getCookie(confignation.environment.getURL(), "PTOKEN") : cookie;
    }

    public static String getCpuName() {
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            String readLine = new BufferedReader(fileReader).readLine();
            fileReader.close();
            if (!TextUtils.isEmpty(readLine)) {
                String[] split = readLine.split(":\\s+", 2);
                return split.length > 1 ? split[1] : "";
            }
        } catch (FileNotFoundException e2) {
            Log.e(e2);
        } catch (IOException e3) {
            Log.e(e3);
        }
        return "";
    }

    public static List<String> getCuidAuthorizedDomains() {
        return SapiContext.getInstance().getCuidAuthorizedDomains();
    }

    @TargetApi(3)
    public static String getCurProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return "";
    }

    public static boolean getDefaultHttpsEnabled() {
        return SapiContext.getInstance().getDefaultHttpsEnabled();
    }

    public static String getIccid(Context context) {
        if (ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
            if (!TextUtils.isEmpty(f)) {
                return f;
            }
            try {
                if (Build.VERSION.SDK_INT >= 22) {
                    StringBuilder sb = new StringBuilder();
                    List<SubscriptionInfo> activeSubscriptionInfoList = SubscriptionManager.from(context).getActiveSubscriptionInfoList();
                    if (activeSubscriptionInfoList == null) {
                        return null;
                    }
                    for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                        sb.append(subscriptionInfo.getIccId()).append(d);
                    }
                    if (sb.length() > 0) {
                        f = sb.toString().substring(0, sb.length() - 1);
                        return f;
                    }
                } else {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        f = telephonyManager.getSimSerialNumber();
                        return f;
                    }
                }
            } catch (Exception e2) {
            }
            return null;
        }
        return "";
    }

    public static long getInternalAvailableMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
        } catch (Throwable th) {
            Log.e(th);
            return 0L;
        }
    }

    public static long getInternalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
        } catch (Throwable th) {
            Log.e(th);
            return 0L;
        }
    }

    public static int getLastLoginType() {
        String string = SapiContext.getInstance().getString(SapiContext.KEY_PRE_LOGIN_TYPE);
        if (TextUtils.isEmpty(string)) {
            string = "none";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("none", 0);
        hashMap.put("password", 1);
        hashMap.put(LoginConstants.SMS_LOGIN, 2);
        hashMap.put("face", 3);
        hashMap.put(SocialType.WEIXIN.getName() + "", 4);
        hashMap.put(SocialType.SINA_WEIBO_SSO.getName() + "", 5);
        hashMap.put(SocialType.QQ_SSO.getName() + "", 6);
        hashMap.put(SocialType.HUAWEI.getName() + "", 10);
        hashMap.put("slient_share", 7);
        hashMap.put(com.baidu.sapi2.share.b.j, 8);
        hashMap.put(com.baidu.sapi2.share.b.k, 9);
        hashMap.put("oneKeyLogin", 12);
        hashMap.put("finger_account", 15);
        hashMap.put("CM", 16);
        hashMap.put("CU", 17);
        hashMap.put("CT", 18);
        hashMap.put(SapiWebView.SWITCH_ACCOUNT_PAGE, 19);
        hashMap.put("naQrlogin", 20);
        if (hashMap.containsKey(string)) {
            return ((Integer) hashMap.get(string)).intValue();
        }
        return 11;
    }

    public static String getLocalIpAddress() {
        String hostAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (hostAddress = nextElement.getHostAddress()) != null && hostAddress.length() > 0 && (nextElement instanceof Inet4Address)) {
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return null;
    }

    public static String getLoginType() {
        return SapiContext.getInstance().getAccountActionType();
    }

    @TargetApi(3)
    public static String getNetworkClass(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            Log.e(th);
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        return RomUtils.UNKNOWN;
                }
            }
            return RomUtils.UNKNOWN;
        }
        return "UNCNCT";
    }

    public static List<String> getPackageList(Context context) {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent("baidu.intent.action.account.SHARE_SERVICE"), 32);
        if (queryIntentServices != null) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    arrayList.add(serviceInfo.packageName);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static String getPackageSign(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            return packageInfo.signatures.length > 0 ? SecurityUtil.md5(packageInfo.signatures[0].toByteArray(), false) : "";
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    public static String[] getPkgIconAndName(Context context, String str) {
        String[] strArr = new String[2];
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            strArr[1] = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a(packageInfo.applicationInfo.loadIcon(packageManager)), 80, 80, true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 100;
            createScaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            while (byteArrayOutputStream.toByteArray().length > 524288 && i > 0) {
                i /= 2;
                byteArrayOutputStream.reset();
                createScaledBitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
            }
            strArr[0] = "data:image/png;base64," + SapiDeviceUtils.DeviceCrypto.base64Encode(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            Log.e(e2);
        }
        return strArr;
    }

    public static String getRamMemorySize() {
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            String readLine = new BufferedReader(fileReader).readLine();
            fileReader.close();
            if (!TextUtils.isEmpty(readLine)) {
                String[] split = readLine.split(":\\s+", 2);
                return split.length > 1 ? split[1].replace("kB", "").trim() : "";
            }
        } catch (FileNotFoundException e2) {
            Log.e(e2);
        } catch (IOException e3) {
            Log.e(e3);
        }
        return "";
    }

    public static String getSmsCheckCode(String str) {
        String[] split;
        for (String str2 : str.replaceAll("[^0-9]*([0-9]*)[^0-9]*", "$1-").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            if (str2.length() == 6) {
                return str2;
            }
        }
        return "";
    }

    public static long getTimeSinceBoot() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            return 0;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            Log.e(th);
            return "0";
        }
    }

    public static String getWifiInfo(Context context) {
        String str;
        String str2;
        String str3;
        int i;
        int i2 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol() ? wifiManager.getConnectionInfo() : null;
            str2 = "";
            str3 = "";
            if (connectionInfo != null) {
                int abs = StrictMath.abs(connectionInfo.getRssi());
                String ssid = connectionInfo.getSSID();
                if (ssid != null) {
                    ssid = ssid.replace("\"", "");
                }
                String bssid = connectionInfo.getBSSID();
                if (bssid != null) {
                    str3 = ssid;
                    str2 = bssid.replace(":", "");
                    i = abs;
                } else {
                    str3 = ssid;
                    str2 = bssid;
                    i = abs;
                }
            } else {
                i = 0;
            }
            List<ScanResult> scanResults = checkRequestPermission("android.permission.ACCESS_FINE_LOCATION", context) ? wifiManager.getScanResults() : null;
            if (scanResults != null) {
                for (ScanResult scanResult : scanResults) {
                    String str4 = scanResult.BSSID;
                    String str5 = scanResult.SSID;
                    int abs2 = StrictMath.abs(scanResult.level);
                    String replace = str4 != null ? str4.replace(":", "") : "";
                    if (!replace.equals(str2) && abs2 != 0) {
                        if (i2 >= 10) {
                            break;
                        }
                        stringBuffer.append(d).append(replace).append(e).append(abs2).append(e).append(str5).append(e).append("2");
                        i2++;
                    }
                }
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
        if (!TextUtils.isEmpty(str2)) {
            str = d + str2 + e + i + e + str3 + e + '1';
            return str + stringBuffer.toString();
        }
        str = "";
        return str + stringBuffer.toString();
    }

    @TargetApi(3)
    public static void hideSoftInput(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (!inputMethodManager.isActive() || activity.getCurrentFocus() == null || activity.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    @TargetApi(4)
    public static boolean isDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
        return false;
    }

    @TargetApi(4)
    public static boolean isEmulator(Context context) {
        String str = null;
        if (ServiceManager.getInstance().getIsAccountManager().getConfignation().isAgreeDangerousProtocol()) {
            if (Build.VERSION.SDK_INT > 27 && context.getApplicationInfo().targetSdkVersion > 27) {
                if (checkRequestPermission("android.permission.READ_PHONE_STATE", context)) {
                    try {
                        str = Build.getSerial();
                    } catch (Throwable th) {
                    }
                }
            } else {
                str = Build.SERIAL;
            }
        }
        return Config.NULL_DEVICE_ID.equals(SapiDeviceUtils.b(context)) || Build.FINGERPRINT.contains("test-keys") || Build.FINGERPRINT.startsWith("unknown") || Build.BRAND.startsWith("generic") || Build.BOARD.equals("unknown") || "unknown".equals(str);
    }

    public static boolean isMethodOverWrited(Object obj, String str, Class cls, Class... clsArr) {
        try {
            return !cls.equals(obj.getClass().getMethod(str, clsArr).getDeclaringClass());
        } catch (NoSuchMethodException e2) {
            return false;
        }
    }

    @TargetApi(4)
    public static boolean isOnline(Context context) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        if (packageName.matches("com.baidu.sapi2.(.*)")) {
            return true;
        }
        if (isDebug(context)) {
            return false;
        }
        Map<String, String> authorizedPackages = SapiContext.getInstance().getAuthorizedPackages();
        String packageSign = getPackageSign(context, packageName);
        for (String str : authorizedPackages.keySet()) {
            if (packageName.matches(str) && packageSign.equals(authorizedPackages.get(str))) {
                return true;
            }
        }
        return false;
    }

    public static String[] isQrArtificialAppeal(String str) {
        Domain environment;
        String host = Uri.parse(ServiceManager.getInstance().getIsAccountManager().getConfignation().getEnvironment().getWap()).getHost();
        Uri parse = Uri.parse(str);
        String str2 = Uri.parse(environment.getWap()).getHost() + "/v3/getpass/artificialappeal";
        if (TextUtils.isEmpty(str) || !str.contains(str2)) {
            return null;
        }
        String[] strArr = {Uri.decode(parse.getQueryParameter("title")), Uri.decode(parse.getQueryParameter("url"))};
        Uri parse2 = Uri.parse(strArr[1]);
        if (TextUtils.isEmpty(strArr[1]) || !host.equals(parse2.getHost())) {
            return null;
        }
        return strArr;
    }

    public static boolean isQrLoginSchema(String str) {
        if (b(str)) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && str.contains("error") && str.contains("sign") && str.contains("cmd") && str.contains(KEY_QR_LOGIN_LP)) {
            Map<String, String> urlParamsToMap = urlParamsToMap(str);
            return (TextUtils.isEmpty(urlParamsToMap.get("error")) || TextUtils.isEmpty(urlParamsToMap.get("sign")) || TextUtils.isEmpty(urlParamsToMap.get("cmd")) || TextUtils.isEmpty(urlParamsToMap.get(KEY_QR_LOGIN_LP))) ? false : true;
        }
        return false;
    }

    public static boolean isRoot() {
        return (new File("/system/bin/su").exists() && a("/system/bin/su")) || (new File("/system/xbin/su").exists() && a("/system/xbin/su"));
    }

    public static boolean isValidPhoneNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^(1)\\d{10}$").matcher(str).matches();
    }

    public static boolean isValidUsername(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 14;
    }

    public static JSONArray map2JsonArray(Map<String, Long> map, String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (map == null || map.isEmpty()) {
            return jSONArray;
        }
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(entry.getKey())) {
                try {
                    jSONObject.put(str, entry.getKey());
                    jSONObject.put(str2, entry.getValue());
                } catch (JSONException e2) {
                }
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static void notEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String parseQrFaceAuthSchema(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (String str2 : new String[]{"ucenter/qrlivingnav", "url", "tpl"}) {
            if (!str.contains(str2)) {
                return null;
            }
        }
        return URLDecoder.decode(str.substring(str.indexOf("url=") + 4, str.length()));
    }

    public static Map<String, String> parseQrLoginSchema(String str) {
        HashMap hashMap = new HashMap();
        if (b(str)) {
            hashMap.put(KEY_QR_LOGIN_LP, "pc");
            return hashMap;
        } else if (isQrLoginSchema(str)) {
            Map<String, String> urlParamsToMap = urlParamsToMap(str);
            if ("pc".equals(urlParamsToMap.get(KEY_QR_LOGIN_LP))) {
                HashMap hashMap2 = new HashMap();
                if (ServiceManager.getInstance().getIsAccountManager().getSession() == null) {
                    hashMap2.put("islogin", "0");
                } else {
                    hashMap2.put("islogin", "1");
                }
                hashMap2.put("client", "android");
                k.a(k.a, hashMap2);
            }
            return urlParamsToMap;
        } else {
            return hashMap;
        }
    }

    public static int px2sp(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void resetSilentShareStatus() {
        if (SapiContext.getInstance().getCurrentAccount() == null) {
            SapiContext.getInstance().resetSilentShareStatus();
        }
    }

    public static void sendSms(Context context, String str, List<String> list) {
        String defaultSmsPackage;
        String str2 = "";
        String str3 = "Samsung".equalsIgnoreCase(Build.MANUFACTURER) ? Constants.ACCEPT_TIME_SEPARATOR_SP : ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
        if (list != null && !list.isEmpty()) {
            str2 = TextUtils.join(str3, list);
        }
        Uri parse = Uri.parse("smsto:" + str2);
        Intent intent = new Intent();
        intent.setData(parse);
        intent.putExtra("sms_body", str);
        intent.setAction("android.intent.action.SENDTO");
        if (Build.VERSION.SDK_INT >= 19 && (defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(context)) != null) {
            intent.setPackage(defaultSmsPackage);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (Exception e2) {
        }
    }

    public static boolean statExtraValid(String str) {
        return !TextUtils.isEmpty(str) && str.getBytes().length <= SapiContext.getInstance().getLoginStatExtraLimitLen();
    }

    public static void syncCookies(Context context, List<PassNameValuePair> list) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (TextUtils.isEmpty(confignation.clientId)) {
            confignation.clientId = getClientId(context);
        }
        List<String> cuidAuthorizedDomains = getCuidAuthorizedDomains();
        if (confignation.getEnvironment() != Domain.DOMAIN_ONLINE) {
            String replaceAll = confignation.environment.getWap().replace("http://", "").replace(COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
            String replaceAll2 = confignation.environment.getURL().replace("http://", "").replace(COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
            cuidAuthorizedDomains.add(replaceAll);
            cuidAuthorizedDomains.add(replaceAll2);
        }
        for (String str : cuidAuthorizedDomains) {
            cookieManager.setCookie(COOKIE_HTTPS_URL_PREFIX + str, buildCuidCookie(str, confignation.clientId));
            String searchBoxSid = SapiContext.getInstance().getSearchBoxSid();
            if (!TextUtils.isEmpty(searchBoxSid)) {
                cookieManager.setCookie(COOKIE_HTTPS_URL_PREFIX + str, buildSidCookie(str, searchBoxSid));
            }
        }
        if (list != null) {
            for (PassNameValuePair passNameValuePair : list) {
                if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                    cookieManager.setCookie(passNameValuePair.getName(), passNameValuePair.getValue());
                }
            }
        }
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync();
        } else {
            cookieManager.flush();
        }
    }

    public static Map<String, String> urlParamsToMap(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("?")) {
                try {
                    str = str.substring(str.indexOf("?") + 1, str.length());
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
            for (String str2 : str.split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str2.split(ETAG.EQUAL);
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    public static boolean validateMobile(String str) {
        return Pattern.compile("1[3456789]\\d{9}").matcher(str).matches();
    }

    public static int versionCompareTo(String str, String str2) {
        String replaceAll = TextUtils.isEmpty(str) ? "0" : str.replaceAll("[^\\d\\.]+", "");
        String replaceAll2 = TextUtils.isEmpty(str2) ? "0" : str2.replaceAll("[^\\d\\.]+", "");
        String[] split = replaceAll.split("\\.");
        String[] split2 = replaceAll2.split("\\.");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str3 : split) {
            arrayList.add(Integer.valueOf(Integer.parseInt(str3)));
        }
        for (String str4 : split2) {
            arrayList2.add(Integer.valueOf(Integer.parseInt(str4)));
        }
        int size = arrayList.size() > arrayList2.size() ? arrayList.size() : arrayList2.size();
        while (arrayList.size() < size) {
            arrayList.add(0);
        }
        while (arrayList2.size() < size) {
            arrayList2.add(0);
        }
        for (int i = 0; i < size; i++) {
            if (((Integer) arrayList.get(i)).intValue() > ((Integer) arrayList2.get(i)).intValue()) {
                return 1;
            }
            if (((Integer) arrayList.get(i)).intValue() < ((Integer) arrayList2.get(i)).intValue()) {
                return -1;
            }
        }
        return 0;
    }

    public static boolean webLogin(Context context, String str) {
        return ServiceManager.getInstance().getIsAccountManager().getIsAccountService().webLogin(context, str);
    }

    public static boolean webLogin(Context context, String str, String str2) {
        return ServiceManager.getInstance().getIsAccountManager().getIsAccountService().webLogin(context, str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [40=4, 28=4] */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r0 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
        r0.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
        if (r0 != null) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(String str) {
        Process process;
        Process process2;
        IOException e2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            Process process3 = Runtime.getRuntime().exec("ls -l " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process3.getInputStream()));
            } catch (IOException e3) {
                process2 = process3;
                e = e3;
                IOException iOException = e;
                process3 = process2;
                e2 = iOException;
                try {
                    Log.e(e2);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e4) {
                            Log.e(e4);
                        }
                    }
                } catch (Throwable th) {
                    process = process3;
                    th = th;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e5) {
                            Log.e(e5);
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                process = process3;
                th = th2;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        try {
                            bufferedReader.close();
                        } catch (Exception e6) {
                            Log.e(e6);
                        }
                        if (process3 != null) {
                            process3.destroy();
                        }
                        return true;
                    }
                }
                try {
                    bufferedReader.close();
                } catch (Exception e7) {
                    Log.e(e7);
                }
            } catch (IOException e8) {
                e2 = e8;
                bufferedReader2 = bufferedReader;
                Log.e(e2);
                if (bufferedReader2 != null) {
                }
            } catch (Throwable th3) {
                bufferedReader2 = bufferedReader;
                th = th3;
                process = process3;
                if (bufferedReader2 != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            process2 = null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
        }
    }

    public static String buildBDUSSCookie(String str, String str2) {
        return buildBDUSSCookie(str, "BDUSS", str2);
    }

    public static boolean hasActiveNetwork(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Throwable th) {
            Log.e(th);
            return false;
        }
    }

    public static boolean webLogout(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : getAuthorizedDomains()) {
                arrayList.add(new PassNameValuePair(COOKIE_URL_PREFIX + str, buildBDUSSCookie(str, "")));
            }
            for (String str2 : getAuthorizedDomainsForPtoken()) {
                arrayList.add(new PassNameValuePair(COOKIE_URL_PREFIX + str2, buildPtokenCookie(str2, "")));
                arrayList.add(new PassNameValuePair(COOKIE_HTTPS_URL_PREFIX + str2, buildPtokenCookie(str2, "")));
            }
            for (String str3 : getAuthorizedDomainsForPtoken()) {
                arrayList.add(new PassNameValuePair(COOKIE_HTTPS_URL_PREFIX + str3, buildStokenCookie(str3, "")));
            }
            syncCookies(context, arrayList);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String mapToUrlParams(Map<String, String> map, boolean z) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (sb.length() <= 0 && !z) {
                sb.append("?");
            } else {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            if (value == null) {
                try {
                    sb.append(key).append(ETAG.EQUAL);
                } catch (Exception e2) {
                    sb.append(key).append(ETAG.EQUAL).append((Object) value);
                    e2.printStackTrace();
                }
            } else {
                sb.append(key).append(ETAG.EQUAL).append(URLEncoder.encode(value.toString(), "UTF-8"));
            }
        }
        return sb.toString();
    }

    private static String a(String str, String str2, String str3, Date date, boolean z) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return str2 + ETAG.EQUAL + str3 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(date) + ";httponly" + (z ? ";secure" : "");
    }

    static String a(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, calendar.getTime(), true);
    }

    private static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && (drawable instanceof AdaptiveIconDrawable)) {
            AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) drawable;
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{adaptiveIconDrawable.getBackground(), adaptiveIconDrawable.getForeground()});
            Bitmap createBitmap = Bitmap.createBitmap(layerDrawable.getIntrinsicWidth(), layerDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            layerDrawable.draw(canvas);
            return createBitmap;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }
}
