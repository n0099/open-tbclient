package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.http.Headers;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.util.DeviceId;
import com.baidu.mobstat.Config;
import com.baidu.pass.gid.BaiduGIDManager;
import com.baidu.pass.gid.utils.Event;
import com.baidu.pass.gid.utils.GIDEvent;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.base.utils.EncodeUtils;
import com.baidu.sapi2.base.utils.NetworkUtil;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
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
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SapiUtils {
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
    private static final String f = "SapiUtils";

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
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            return "123456789" + MD5Util.toMd5(String.valueOf(random.nextInt(100)).getBytes(), false);
        }
    }

    public static String getCpuName() {
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            String readLine = new BufferedReader(fileReader).readLine();
            if (fileReader != null) {
                fileReader.close();
            }
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

    public static String getRamMemorySize() {
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            String readLine = new BufferedReader(fileReader).readLine();
            if (fileReader != null) {
                fileReader.close();
            }
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

    public static long getInternalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
        } catch (Throwable th) {
            Log.e(th);
            return 0L;
        }
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

    public static long getTimeSinceBoot() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static String getGPSInfo(Context context) {
        Location lastKnownLocation;
        LocationManager locationManager = (LocationManager) context.getSystemService(Headers.LOCATION);
        try {
            return (checkRequestPermission("android.permission.ACCESS_FINE_LOCATION", context) && locationManager.isProviderEnabled("gps") && (lastKnownLocation = locationManager.getLastKnownLocation("gps")) != null) ? lastKnownLocation.getLongitude() + Constants.ACCEPT_TIME_SEPARATOR_SP + lastKnownLocation.getLatitude() : "";
        } catch (Exception e2) {
            Log.e(e2);
        }
        return "";
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

    @TargetApi(4)
    public static boolean isEmulator(Context context) {
        String str = null;
        if (Build.VERSION.SDK_INT <= 27 || context.getApplicationInfo().targetSdkVersion <= 27) {
            str = Build.SERIAL;
        } else if (checkRequestPermission("android.permission.READ_PHONE_STATE", context)) {
            str = Build.getSerial();
        }
        return Config.NULL_DEVICE_ID.equals(SapiDeviceUtils.getIMEI(context)) || Build.FINGERPRINT.contains("test-keys") || Build.FINGERPRINT.startsWith("unknown") || Build.BRAND.startsWith("generic") || Build.BOARD.equals("unknown") || "unknown".equals(str);
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

    @TargetApi(5)
    public static String getBlueToothDeviceName(Context context) {
        BluetoothAdapter defaultAdapter;
        try {
            return (!checkRequestPermission("android.permission.BLUETOOTH", context) || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null || defaultAdapter.getName() == null) ? "" : defaultAdapter.getName();
        } catch (Exception e2) {
            Log.e(e2);
        }
        return "";
    }

    public static String createRequestParams(List<PassNameValuePair> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (PassNameValuePair passNameValuePair : list) {
                if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                    if (TextUtils.isEmpty(sb.toString())) {
                        sb.append(passNameValuePair.getName()).append("=").append(passNameValuePair.getValue());
                    } else {
                        sb.append("&").append(passNameValuePair.getName()).append("=").append(passNameValuePair.getValue());
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
        switch (((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSimState()) {
            case 5:
                return true;
            default:
                return false;
        }
    }

    public static boolean hasActiveNetwork(Context context) {
        return NetworkUtil.isNetworkAvaliable(context);
    }

    @TargetApi(3)
    public static String getNetworkClass(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            Log.e(th);
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "UNCNCT";
        }
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
                    return "UNKNOWN";
            }
        }
        return "UNKNOWN";
    }

    public static boolean isRoot() {
        return (new File("/system/bin/su").exists() && a("/system/bin/su")) || (new File("/system/xbin/su").exists() && a("/system/xbin/su"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [577=4, 578=4, 569=5, 571=4, 572=4, 573=4] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(String str) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        Process process2 = null;
        try {
            process = Runtime.getRuntime().exec("ls -l " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null && readLine.length() >= 4) {
                        char charAt = readLine.charAt(3);
                        if (charAt == 's' || charAt == 'x') {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e2) {
                                    Log.e(e2);
                                }
                            }
                            if (process != null) {
                                process.destroy();
                                return true;
                            }
                            return true;
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            Log.e(e3);
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                } catch (IOException e4) {
                    e = e4;
                    process2 = process;
                    try {
                        Log.e(e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e5) {
                                Log.e(e5);
                            }
                        }
                        if (process2 != null) {
                            process2.destroy();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        process = process2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception e6) {
                                Log.e(e6);
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    if (process != null) {
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
                process2 = process;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e8) {
            e = e8;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
        }
        return false;
    }

    public static String getIccid(Context context) {
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
                    return sb.toString().substring(0, sb.length() - 1);
                }
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
                if (telephonyManager != null) {
                    return telephonyManager.getSimSerialNumber();
                }
            }
        } catch (Exception e2) {
        }
        return null;
    }

    public static String getWifiInfo(Context context) {
        String str;
        int i;
        String str2;
        String str3;
        List<ScanResult> list;
        int i2 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                i = 0;
                str2 = "";
                str3 = "";
            } else {
                int abs = StrictMath.abs(connectionInfo.getRssi());
                String ssid = connectionInfo.getSSID();
                if (ssid != null) {
                    ssid = ssid.replace("\"", "");
                }
                String bssid = connectionInfo.getBSSID();
                if (bssid != null) {
                    str2 = bssid.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
                    i = abs;
                    str3 = ssid;
                } else {
                    str2 = bssid;
                    i = abs;
                    str3 = ssid;
                }
            }
            if (!checkRequestPermission("android.permission.ACCESS_FINE_LOCATION", context)) {
                list = null;
            } else {
                list = wifiManager.getScanResults();
            }
            if (list != null) {
                for (ScanResult scanResult : list) {
                    String str4 = scanResult.BSSID;
                    String str5 = scanResult.SSID;
                    int abs2 = StrictMath.abs(scanResult.level);
                    String replace = str4 != null ? str4.replace(Config.TRACE_TODAY_VISIT_SPLIT, "") : "";
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

    public static String getLocation(Context context) {
        try {
            SapiBDLocManager sapiBDLocManager = new SapiBDLocManager(context);
            return sapiBDLocManager.getLocString(15) != null ? sapiBDLocManager.getLocString(15) : "";
        } catch (Exception e2) {
            Log.e(e2);
            return "";
        }
    }

    public static String getCookieBduss() {
        return getCookie(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL), "BDUSS");
    }

    public static String getCookiePtoken() {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String cookie = getCookie(confignation.environment.getWap(getDefaultHttpsEnabled()), "PTOKEN");
        if (TextUtils.isEmpty(cookie)) {
            return getCookie(confignation.environment.getURL(getDefaultHttpsEnabled()), "PTOKEN");
        }
        return cookie;
    }

    public static String getCookie(String str, String str2) {
        try {
            CookieSyncManager.createInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context);
            String cookie = CookieManager.getInstance().getCookie(str);
            if (TextUtils.isEmpty(cookie)) {
                return "";
            }
            for (String str3 : cookie.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                String trim = str3.trim();
                if (!TextUtils.isEmpty(trim)) {
                    String[] split = trim.split("=");
                    if (split.length == 2 && split[0].equals(str2)) {
                        return split[1];
                    }
                }
            }
            return "";
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }

    public static boolean webLogin(Context context, String str) {
        return ServiceManager.getInstance().getIsAccountManager().getIsAccountService().webLogin(context, str);
    }

    public static boolean webLogin(Context context, String str, String str2) {
        return ServiceManager.getInstance().getIsAccountManager().getIsAccountService().webLogin(context, str, str2);
    }

    public static boolean webLogout(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : getAuthorizedDomains(context)) {
                arrayList.add(new PassNameValuePair(COOKIE_URL_PREFIX + str, buildBDUSSCookie(str, "")));
            }
            for (String str2 : getAuthorizedDomainsForPtoken(context)) {
                arrayList.add(new PassNameValuePair(COOKIE_URL_PREFIX + str2, buildPtokenCookie(str2, "")));
                arrayList.add(new PassNameValuePair("https://" + str2, buildPtokenCookie(str2, "")));
            }
            for (String str3 : getAuthorizedDomainsForPtoken(context)) {
                arrayList.add(new PassNameValuePair("https://" + str3, buildStokenCookie(str3, "")));
            }
            syncCookies(context, arrayList);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static String a(String str, String str2, String str3, Date date, boolean z) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(date) + ";httponly" + (z ? ";secure" : "");
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

    public static String buildStokenCookie(String str, String str2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str2) ? -8 : 8);
        return a(str, "STOKEN", str2, calendar.getTime(), true);
    }

    static String a(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, calendar.getTime(), true);
    }

    public static String buildBDUSSCookie(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return a(str, str2, str3, calendar.getTime(), false);
    }

    public static String buildBDUSSCookie(String str, String str2) {
        return buildBDUSSCookie(str, "BDUSS", str2);
    }

    public static String buildCuidCookie(String str, String str2) {
        return "cuid=" + str2 + ";domain=" + str + ";path=/;httponly";
    }

    public static void syncCookies(Context context, List<PassNameValuePair> list) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (TextUtils.isEmpty(confignation.clientId)) {
            confignation.clientId = getClientId(context);
        }
        List<String> cuidAuthorizedDomains = getCuidAuthorizedDomains(context);
        if (confignation.getEnvironment() != Domain.DOMAIN_ONLINE) {
            String replaceAll = confignation.environment.getWap(getDefaultHttpsEnabled()).replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
            String replaceAll2 = confignation.environment.getURL(getDefaultHttpsEnabled()).replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
            cuidAuthorizedDomains.add(replaceAll);
            cuidAuthorizedDomains.add(replaceAll2);
        }
        for (String str : cuidAuthorizedDomains) {
            cookieManager.setCookie("https://" + str, buildCuidCookie(str, confignation.clientId));
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

    public static List<String> getAuthorizedDomains(Context context) {
        return context == null ? Collections.emptyList() : SapiContext.getInstance(context).getAuthorizedDomains();
    }

    public static List<String> getCuidAuthorizedDomains(Context context) {
        return context == null ? Collections.emptyList() : SapiContext.getInstance(context).getCuidAuthorizedDomains();
    }

    public static List<String> getAuthorizedDomainsForPtoken(Context context) {
        return context == null ? Collections.emptyList() : SapiContext.getInstance(context).getAuthorizedDomainsForPtoken();
    }

    public static String getPackageSign(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures.length <= 0) {
                return "";
            }
            return EncodeUtils.toMd5(packageInfo.signatures[0].toByteArray());
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
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
            Log.e(th);
            return "0";
        }
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            return 0;
        }
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

    public static int dip2px(Context context, float f2) {
        if (context == null) {
            throw new IllegalArgumentException("Context can't be null");
        }
        return (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
    }

    public static int px2sp(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static boolean isQrLoginSchema(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(b) && str.contains("sign") && str.contains("cmd") && str.contains(KEY_QR_LOGIN_LP)) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length > 1) {
                    hashMap.put(split[0], split[1]);
                } else if (split.length == 1) {
                    hashMap.put(split[0], "");
                }
            }
            return (TextUtils.isEmpty((CharSequence) hashMap.get(b)) || TextUtils.isEmpty((CharSequence) hashMap.get("sign")) || TextUtils.isEmpty((CharSequence) hashMap.get("cmd")) || TextUtils.isEmpty((CharSequence) hashMap.get(KEY_QR_LOGIN_LP))) ? false : true;
        }
        return false;
    }

    public static String[] isQrArtificialAppeal(String str) {
        Domain environment;
        String host = Uri.parse(ServiceManager.getInstance().getIsAccountManager().getConfignation().getEnvironment().getWap(true)).getHost();
        Uri parse = Uri.parse(str);
        String str2 = Uri.parse(environment.getWap(true)).getHost() + "/v3/getpass/artificialappeal";
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

    public static Map<String, String> parseQrLoginSchema(String str) {
        HashMap hashMap = new HashMap();
        if (isQrLoginSchema(str)) {
            Map<String, String> urlParamsToMap = urlParamsToMap(str);
            if ("pc".equals(urlParamsToMap.get(KEY_QR_LOGIN_LP))) {
                HashMap hashMap2 = new HashMap();
                if (ServiceManager.getInstance().getIsAccountManager().getSession() == null) {
                    hashMap2.put("islogin", "0");
                } else {
                    hashMap2.put("islogin", "1");
                }
                hashMap2.put("client", "android");
                StatService.onEvent(StatService.STAT_ENENT_QR_LOGIN_ENTER, hashMap2, false);
            }
            return urlParamsToMap;
        }
        return hashMap;
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

    public static void resetSilentShareStatus(Context context) {
        if (context != null && SapiContext.getInstance(context).getCurrentAccount() == null) {
            SapiContext.getInstance(context).resetSilentShareStatus();
        }
    }

    public static String getFastRegChannel(Context context) {
        if (context != null) {
            String fastRegChannel = SapiContext.getInstance(context).getFastRegChannel();
            if (!TextUtils.isEmpty(fastRegChannel)) {
                return fastRegChannel;
            }
        }
        return SapiEnv.FAST_REG_SMS_NUMBER;
    }

    public static boolean getDefaultHttpsEnabled() {
        return SapiContext.getInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context).getDefaultHttpsEnabled();
    }

    public static String getLoginType() {
        return SapiContext.getInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context).getAccountActionType();
    }

    public static int getLastLoginType() {
        String string = SapiContext.getInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context).getString(SapiContext.KEY_PRE_LOGIN_TYPE);
        if (TextUtils.isEmpty(string)) {
            string = "none";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("none", 0);
        hashMap.put("password", 1);
        hashMap.put("sms", 2);
        hashMap.put("face", 3);
        hashMap.put(SocialType.WEIXIN.getName() + "", 4);
        hashMap.put(SocialType.SINA_WEIBO.getName() + "", 5);
        hashMap.put(SocialType.QQ_SSO.getName() + "", 6);
        hashMap.put(SocialType.HUAWEI.getName() + "", 10);
        hashMap.put("slient_share", 7);
        hashMap.put(ShareCallPacking.LOGIN_TYPE_SHARE_V1_CHOICE, 8);
        hashMap.put(ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE, 9);
        hashMap.put("oneKeyLogin", 12);
        if (hashMap.containsKey(string)) {
            return ((Integer) hashMap.get(string)).intValue();
        }
        return 11;
    }

    @TargetApi(3)
    public static void hideSoftInput(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager.isActive() && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static void reportGid(int i) {
        Event event = null;
        try {
            switch (i) {
                case 10001:
                    event = GIDEvent.BUSINESS_APP_PROCESS_START;
                    break;
                case 10002:
                    event = GIDEvent.BUSINESS_ACCOUNT_LOGIN;
                    break;
                case 10003:
                    event = GIDEvent.BUSINESS_ACCOUNT_REG;
                    break;
                case 10004:
                    event = GIDEvent.BUSINESS_GET_GID;
                    break;
                case 10005:
                    event = GIDEvent.BUSINESS_LOGOUT;
                    break;
                case 10006:
                    event = GIDEvent.SYSTEM_SCREEN_ON;
                    break;
                case SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE /* 11001 */:
                    event = GIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE;
                    break;
                case 11002:
                    event = GIDEvent.SYSTEM_NETWORK_CHANGE_MOB_TO_WIFI;
                    break;
                case 11003:
                    event = GIDEvent.SYSTEM_NETWORK_CHANGE_WIFI_TO_MOB;
                    break;
                case 12001:
                    event = GIDEvent.TIME_FREQ;
                    break;
            }
            if (event != null) {
                BaiduGIDManager.getInstance().check(event);
            }
        } catch (Throwable th) {
        }
    }

    public static boolean isMethodOverWrited(Object obj, String str, Class cls, Class... clsArr) {
        try {
            return !cls.equals(obj.getClass().getMethod(str, clsArr).getDeclaringClass());
        } catch (NoSuchMethodException e2) {
            return false;
        }
    }

    public static int compareVersion(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        String str3 = "";
        for (int i = 0; i < split.length; i++) {
            str3 = str3 + String.format("%2s", split[i]).replaceAll("\\s", "0");
        }
        String replaceAll = String.format("%-8s", str3).replaceAll("\\s", "0");
        String str4 = "";
        for (int i2 = 0; i2 < split2.length; i2++) {
            str4 = str4 + String.format("%2s", split2[i2]).replaceAll("\\s", "0");
        }
        return replaceAll.compareTo(String.format("%-8s", str4).replaceAll("\\s", "0"));
    }

    @TargetApi(23)
    public static boolean checkRequestPermission(String str, Context context) {
        if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) != 0) {
            return Build.VERSION.SDK_INT < 23 && context.checkCallingOrSelfPermission(str) == 0;
        }
        return true;
    }

    public static String calculateSig(Map<String, String> map, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            arrayList.add(str2);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            sb.append(str3);
            sb.append("=");
            try {
                String str4 = map.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    sb.append(URLEncoder.encode(str4, HTTP.UTF_8));
                }
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
            sb.append("&");
        }
        sb.append("sign_key=").append(str);
        return MD5Util.toMd5(sb.toString().getBytes(), false);
    }

    public static boolean statExtraValid(Context context, String str) {
        return !TextUtils.isEmpty(str) && str.getBytes().length <= SapiContext.getInstance(context).getLoginStatExtraLimitLen();
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
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return false;
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
        Map<String, String> authorizedPackages = SapiContext.getInstance(context).getAuthorizedPackages();
        String packageSign = getPackageSign(context, packageName);
        for (String str : authorizedPackages.keySet()) {
            if (packageName.matches(str) && packageSign.equals(authorizedPackages.get(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateMobile(String str) {
        return Pattern.compile("1[3456789]\\d{9}").matcher(str).matches();
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
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    public static String mapToUrlParams(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (sb.length() > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            if (value == null) {
                try {
                    sb.append(key).append("=");
                } catch (Exception e2) {
                    sb.append(key).append("=").append((Object) value);
                    e2.printStackTrace();
                }
            } else {
                sb.append(key).append("=").append(URLEncoder.encode(value.toString(), HTTP.UTF_8));
            }
        }
        return sb.toString();
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

    public static String getSmsCheckCode(String str) {
        String[] split;
        for (String str2 : str.replaceAll("[^0-9]*([0-9]*)[^0-9]*", "$1-").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            if (str2.length() == 6) {
                return str2;
            }
        }
        return "";
    }
}
