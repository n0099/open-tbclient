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
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.base.utils.EncodeUtils;
import com.baidu.sapi2.base.utils.NetworkUtil;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.utils.enums.Domain;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SapiUtils {
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
    static final String d = "https://www.";
    static final String e = Character.toString(2);
    static final String f = Character.toString(3);
    private static final String g = "SapiUtils";

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
                return readLine.split(":\\s+", 2)[1];
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
                return readLine.split(":\\s+", 2)[1].replace("kB", "").trim();
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

    public static boolean isEmulator(Context context) {
        return "000000000000000".equals(SapiDeviceUtils.getIMEI(context)) || Build.FINGERPRINT.contains("test-keys") || Build.FINGERPRINT.startsWith("unknown") || Build.BRAND.startsWith("generic") || Build.BOARD.equals("unknown") || Build.SERIAL.equals("unknown");
    }

    public static String getLocalIpAddress() {
        String hostAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (hostAddress = nextElement.getHostAddress()) != null && hostAddress.length() > 0 && InetAddressUtils.isIPv4Address(hostAddress)) {
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return null;
    }

    public static String getBlueToothDeviceName(Context context) {
        BluetoothAdapter defaultAdapter;
        try {
            return (!checkRequestPermission("android.permission.BLUETOOTH", context) || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null || defaultAdapter.getName() == null) ? "" : defaultAdapter.getName();
        } catch (Exception e2) {
            Log.e(e2);
        }
        return "";
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [514=5, 516=4, 517=4, 518=4, 522=4, 523=4] */
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
                    str2 = bssid.replace(":", "");
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
                    String replace = str4 != null ? str4.replace(":", "") : "";
                    if (!replace.equals(str2) && abs2 != 0) {
                        if (i2 >= 10) {
                            break;
                        }
                        stringBuffer.append(e).append(replace).append(f).append(abs2).append(f).append(str5).append(f).append("2");
                        i2++;
                    }
                }
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
        if (!TextUtils.isEmpty(str2)) {
            str = e + str2 + f + i + f + str3 + f + '1';
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
        return a(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL), "BDUSS");
    }

    public static String getCookiePtoken() {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        String a2 = a(confignation.environment.getWap(getDefaultHttpsEnabled()), "PTOKEN");
        if (TextUtils.isEmpty(a2)) {
            return a(confignation.environment.getURL(getDefaultHttpsEnabled()), "PTOKEN");
        }
        return a2;
    }

    private static String a(String str, String str2) {
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
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String str3 : getAuthorizedDomains(context)) {
                arrayList.add(new BasicNameValuePair(d + str3, buildBDUSSCookie(str3, str)));
            }
            if (!TextUtils.isEmpty(str2)) {
                for (String str4 : getAuthorizedDomainsForPtoken(context)) {
                    arrayList.add(new BasicNameValuePair(d + str4, buildPtokenCookie(str4, str2)));
                }
            }
            syncCookies(context, arrayList);
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
            ArrayList arrayList = new ArrayList();
            for (String str : getAuthorizedDomains(context)) {
                arrayList.add(new BasicNameValuePair(d + str, buildBDUSSCookie(str, "")));
            }
            for (String str2 : getAuthorizedDomainsForPtoken(context)) {
                arrayList.add(new BasicNameValuePair(d + str2, buildPtokenCookie(str2, "")));
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
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(date) + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + "httponly" + (z ? ";secure" : "");
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

    public static void syncCookies(Context context, List<NameValuePair> list) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (TextUtils.isEmpty(confignation.clientId)) {
            confignation.clientId = getClientId(context);
        }
        cookieManager.setCookie(confignation.environment.getWap(getDefaultHttpsEnabled()), "cuid=" + confignation.clientId + ";domain=" + confignation.environment.getWap(getDefaultHttpsEnabled()).replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/;httponly");
        if (list != null) {
            for (NameValuePair nameValuePair : list) {
                if (!TextUtils.isEmpty(nameValuePair.getName()) && !TextUtils.isEmpty(nameValuePair.getValue())) {
                    cookieManager.setCookie(nameValuePair.getName(), nameValuePair.getValue());
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

    @TargetApi(4)
    public static boolean sendSms(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            SmsManager.getDefault().sendTextMessage(str2, null, str, null, null);
            return true;
        } catch (Throwable th) {
            return false;
        }
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

    public static void hideSoftInput(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager.isActive() && activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static boolean isMethodOverWrited(Object obj, String str, Class cls, Class... clsArr) {
        try {
            return !cls.equals(obj.getClass().getMethod(str, clsArr).getDeclaringClass());
        } catch (NoSuchMethodException e2) {
            return false;
        }
    }

    @TargetApi(23)
    public static boolean checkRequestPermission(String str, Context context) {
        if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) != 0) {
            return Build.VERSION.SDK_INT < 23 && context.checkCallingOrSelfPermission(str) == 0;
        }
        return true;
    }
}
