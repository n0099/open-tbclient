package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.ext.widget.toast.ToastUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.bl;
import com.baidu.mobstat.bs;
import com.baidu.mobstat.util.CuidUtil;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bw {
    public static String a;
    public static String b;
    public static String c;
    public static final Pattern d = Pattern.compile("\\s*|\t|\r|\n");

    public static Boolean c() {
        Object invoke;
        Boolean bool = Boolean.TRUE;
        try {
            Class<?> cls = Class.forName("com.baidu.disasterrecovery.MtjAdapter");
            if (cls != null && (invoke = cls.getDeclaredMethod("shouldUploadOther", new Class[0]).invoke(null, new Object[0])) != null && (invoke instanceof Boolean)) {
                return (Boolean) invoke;
            }
            return bool;
        } catch (Exception unused) {
            return bool;
        }
    }

    public static String a() {
        InputStreamReader inputStreamReader;
        StringBuffer stringBuffer = new StringBuffer();
        InputStreamReader inputStreamReader2 = null;
        try {
            char[] cArr = new char[20];
            inputStreamReader = new InputStreamReader(new FileInputStream("/sys/class/net/eth0/address"));
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    } else if (read == 20 && cArr[19] != '\r') {
                        System.out.print(cArr);
                    } else {
                        for (int i = 0; i < read; i++) {
                            if (cArr[i] != '\r') {
                                stringBuffer.append(cArr[i]);
                            }
                        }
                    }
                } catch (Exception unused) {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
            String replaceAll = stringBuffer.toString().trim().replaceAll(":", "");
            try {
                inputStreamReader.close();
            } catch (Exception unused4) {
            }
            return replaceAll;
        } catch (Exception unused5) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(byte b2) {
        String str;
        return ("00" + Integer.toHexString(b2) + ":").substring(str.length() - 3);
    }

    public static String b(Context context) {
        return bs.a.a(a(context).getBytes()).toUpperCase(Locale.US);
    }

    public static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = e(context);
        } catch (Exception unused) {
        }
        return displayMetrics.widthPixels;
    }

    public static int d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = e(context);
        } catch (Exception unused) {
        }
        return displayMetrics.heightPixels;
    }

    public static DisplayMetrics e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static String g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h(Context context) {
        try {
            return (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String i(Context context) {
        if (!bu.a().d()) {
            return "";
        }
        if (Build.VERSION.SDK_INT < 23) {
            return j(context);
        }
        return d();
    }

    public static String j(Context context) {
        WifiInfo connectionInfo;
        if (!bu.a().d()) {
            return "";
        }
        try {
            if (bn.e(context, com.kuaishou.weapon.p0.g.d) && (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) != null) {
                String macAddress = ApiReplaceUtil.getMacAddress(connectionInfo);
                if (!TextUtils.isEmpty(macAddress)) {
                    return macAddress;
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String k(Context context) {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                String name = defaultAdapter.getName();
                if (name != null) {
                    return name;
                }
                return "";
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m(Context context) {
        if (!bu.a().d()) {
            return "";
        }
        String n = n(context);
        if (TextUtils.isEmpty(n)) {
            return "";
        }
        return bl.a.a(n.getBytes());
    }

    public static boolean o(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isAvailable()) {
                return false;
            }
            if (!networkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String p(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            String typeName = activeNetworkInfo.getTypeName();
            if (!typeName.equals("WIFI") && activeNetworkInfo.getSubtypeName() != null) {
                return activeNetworkInfo.getSubtypeName();
            }
            return typeName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean q(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (bn.e(context, "android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    return activeNetworkInfo.isAvailable();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public static String r(Context context) {
        if (context != null) {
            return context.getPackageName();
        }
        return "";
    }

    public static String s(Context context) {
        String str = b;
        if (str == null) {
            String x = x(context);
            String b2 = b(context, x);
            if (TextUtils.isEmpty(b2)) {
                b2 = c(context, x);
            }
            if (b2 == null) {
                str = "";
            } else {
                str = b2;
            }
            b = str;
        }
        return str;
    }

    public static boolean u(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String w(Context context) {
        if (!bu.a().d()) {
            return "";
        }
        try {
            String deviceId = ApiReplaceUtil.getDeviceId((TelephonyManager) context.getSystemService("phone"));
            if (!TextUtils.isEmpty(deviceId)) {
                return bl.b.c(2, deviceId.getBytes());
            }
            return deviceId;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(int i, Context context) {
        try {
            return bl.b.c(i, a(context).getBytes());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(int i, Context context) {
        return bl.b.c(i, CuidUtil.getOaid(context).getBytes());
    }

    public static String c(Context context, String str) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        String str2 = applicationInfo.processName;
        if (str2 == null || str2.equals(str)) {
            return null;
        }
        return str;
    }

    public static String d(int i, Context context) {
        return bl.b.c(i, CuidUtil.getIid(context).getBytes());
    }

    public static String e(int i, Context context) {
        return bl.b.c(i, CuidUtil.getGaid(context).getBytes());
    }

    public static String f(int i, Context context) {
        return bl.b.c(i, CuidUtil.getCuid3(context).getBytes());
    }

    public static String g(int i, Context context) {
        return bl.b.c(i, CuidUtil.getSsaid(context).getBytes());
    }

    public static String h(int i, Context context) {
        if (!bu.a().d()) {
            return "";
        }
        String j = j(context);
        if (TextUtils.isEmpty(j)) {
            return "";
        }
        return bl.b.c(i, j.getBytes());
    }

    public static String i(int i, Context context) {
        if (!bu.a().d()) {
            return "";
        }
        String j = j(i, context);
        String str = null;
        if (!TextUtils.isEmpty(j)) {
            str = bl.b.c(i, j.getBytes());
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String j(int i, Context context) {
        if (!bu.a().d()) {
            return "";
        }
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            a2 = k(i, context);
        }
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        return a2;
    }

    public static String l(int i, Context context) {
        if (!bu.a().d()) {
            return "";
        }
        String l = l(context);
        if (TextUtils.isEmpty(l)) {
            return "";
        }
        return bl.b.c(i, l.getBytes());
    }

    public static String m(int i, Context context) {
        if (!bu.a().d()) {
            return "";
        }
        String n = n(context);
        if (TextUtils.isEmpty(n)) {
            return "";
        }
        return bl.b.d(i, n.getBytes());
    }

    public static String n(int i, Context context) {
        String r = r(context);
        if (!TextUtils.isEmpty(r)) {
            try {
                return bl.b.c(i, r.getBytes());
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public static String a(Context context) {
        return d.matcher(bx.a(context)).replaceAll("");
    }

    public static String a(Context context, int i) {
        String k = k(context);
        if (TextUtils.isEmpty(k)) {
            return "";
        }
        return bl.b.c(i, k.getBytes());
    }

    public static String b(Context context, String str) {
        int lastIndexOf;
        int i;
        if (str == null || (lastIndexOf = str.lastIndexOf(58)) <= 0 || (i = lastIndexOf + 1) >= str.length()) {
            return null;
        }
        return str.substring(i);
    }

    public static String a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return "";
            }
            Object obj = null;
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                obj = bundle.get(str);
            }
            if (obj == null) {
                bb c2 = bb.c();
                c2.a("can't find information in AndroidManifest.xml for key " + str);
                return "";
            }
            return obj.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(int i, final Context context) {
        String v = bp.a().v(context);
        if (TextUtils.isEmpty(v)) {
            v = bp.a().w(context);
            ca.a().a(context, new bz() { // from class: com.baidu.mobstat.bw.1
                @Override // com.baidu.mobstat.bz
                public void a(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        bp.a().o(context, str);
                    }
                }
            });
        }
        if (TextUtils.isEmpty(v)) {
            v = "";
        }
        return bl.b.c(i, v.getBytes());
    }

    public static String a(String str) {
        return bl.b.c(2, str.getBytes());
    }

    public static String b() {
        String str;
        String str2 = c;
        if (str2 != null) {
            return str2;
        }
        if (!TextUtils.isEmpty(b("ro.miui.ui.version.name"))) {
            str = "miui";
        } else if (!TextUtils.isEmpty(b("ro.build.version.opporom"))) {
            str = "coloros";
        } else if (!TextUtils.isEmpty(b("ro.build.version.emui"))) {
            str = "emui";
        } else if (!TextUtils.isEmpty(b("ro.vivo.os.version"))) {
            str = "funtouch";
        } else if (!TextUtils.isEmpty(b("ro.smartisan.version"))) {
            str = RomUtils.MANUFACTURER_SMARTISAN;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            String b2 = b(RomUtils.PROP_RO_BUILD_DISPLAY_ID);
            if (!TextUtils.isEmpty(b2) && b2.contains(ToastUtils.MEIZU_ROM)) {
                str = "flyme";
            }
        }
        c = str;
        return str;
    }

    @TargetApi(9)
    public static String d() {
        if (Build.VERSION.SDK_INT < 9) {
            return "";
        }
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = ApiReplaceUtil.getHardwareAddress(networkInterface);
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
        r5.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
        if (r5 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
        if (r5 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process process;
        String str2 = null;
        try {
            process = Runtime.getRuntime().exec("getprop " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                try {
                    str2 = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Exception unused6) {
            process = null;
            bufferedReader = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            process = null;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0038: INVOKE  (r1v3 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public static String v(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("m", memoryInfo.availMem);
            jSONObject.put("l", memoryInfo.lowMemory);
            jSONObject.put("t", memoryInfo.threshold);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_mem", jSONArray);
            jSONObject2.put("meta-data", sb.toString());
            return bl.a.a(jSONObject2.toString().getBytes());
        } catch (Exception unused) {
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    public static String k(int i, Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isAnyLocalAddress() && (nextElement2 instanceof Inet4Address) && !nextElement2.isLoopbackAddress()) {
                            if (nextElement2.isSiteLocalAddress()) {
                                bArr = ApiReplaceUtil.getHardwareAddress(nextElement);
                            } else if (!nextElement2.isLinkLocalAddress()) {
                                bArr = ApiReplaceUtil.getHardwareAddress(nextElement);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (bArr != null) {
            for (byte b2 : bArr) {
                stringBuffer.append(a(b2));
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(":", "");
        }
        String h = h(i, context);
        if (h != null) {
            return h.replaceAll(":", "");
        }
        return h;
    }

    @SuppressLint({"NewApi"})
    public static String l(Context context) {
        BluetoothAdapter defaultAdapter;
        if (!bu.a().d()) {
            return "";
        }
        String str = android.os.Build.BRAND;
        if ("4.1.1".equals(Build.VERSION.RELEASE) && "TCT".equals(str)) {
            return "";
        }
        try {
            if (bn.e(context, "android.permission.BLUETOOTH") && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null) {
                String address = defaultAdapter.getAddress();
                if (address != null) {
                    return address;
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String t(Context context) {
        ServiceInfo[] serviceInfoArr;
        String str;
        String x = x(context);
        if (x == null) {
            return "";
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
        } catch (Exception unused) {
        }
        if (packageInfo == null || (serviceInfoArr = packageInfo.services) == null) {
            return "";
        }
        int length = serviceInfoArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = "";
                break;
            }
            ServiceInfo serviceInfo = serviceInfoArr[i];
            if (x.equals(serviceInfo.processName)) {
                str = serviceInfo.name;
                break;
            }
            i++;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        r0 = r2.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String x(Context context) {
        String str = a;
        if (str == null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                int i = 0;
                while (true) {
                    if (runningAppProcesses == null || i >= runningAppProcesses.size()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        break;
                    }
                    i++;
                }
            } catch (Exception unused) {
            }
            if (str == null) {
                str = "";
            }
            a = str;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a A[Catch: Exception -> 0x0097, TryCatch #3 {Exception -> 0x0097, blocks: (B:25:0x0049, B:27:0x006a, B:28:0x006e, B:30:0x007e, B:34:0x008d), top: B:51:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(Context context) {
        WifiInfo wifiInfo;
        List<ScanResult> list;
        JSONArray jSONArray;
        int i;
        String replaceAll;
        int i2;
        WifiManager wifiManager;
        if (context == null || !bn.e(context, com.kuaishou.weapon.p0.g.d)) {
            return "";
        }
        try {
            wifiManager = (WifiManager) context.getSystemService("wifi");
            wifiInfo = wifiManager.getConnectionInfo();
        } catch (Throwable unused) {
            wifiInfo = null;
        }
        try {
            list = wifiManager.getScanResults();
        } catch (Throwable unused2) {
            list = null;
            if (list != null) {
                Collections.sort(list, new Comparator<ScanResult>() { // from class: com.baidu.mobstat.bw.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(ScanResult scanResult, ScanResult scanResult2) {
                        return scanResult2.level - scanResult.level;
                    }
                });
            }
            jSONArray = new JSONArray();
            while (list != null) {
                try {
                    ScanResult scanResult = list.get(i);
                    StringBuilder sb = new StringBuilder();
                    sb.append(scanResult.BSSID);
                    sb.append("|");
                    replaceAll = scanResult.SSID.replaceAll(WebChromeClient.PARAM_SEPARATOR, "");
                    if (replaceAll.length() > 30) {
                    }
                    sb.append(replaceAll);
                    sb.append("|");
                    sb.append(scanResult.level);
                    sb.append("|");
                    if (wifiInfo == null) {
                    }
                    i2 = 0;
                    sb.append(i2);
                    jSONArray.put(sb.toString());
                } catch (Exception unused3) {
                }
            }
            if (jSONArray.length() != 0) {
            }
        }
        if (list != null && list.size() != 0) {
            Collections.sort(list, new Comparator<ScanResult>() { // from class: com.baidu.mobstat.bw.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(ScanResult scanResult2, ScanResult scanResult22) {
                    return scanResult22.level - scanResult2.level;
                }
            });
        }
        jSONArray = new JSONArray();
        for (i = 0; list != null && i < list.size() && i < 30; i++) {
            ScanResult scanResult2 = list.get(i);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(scanResult2.BSSID);
            sb2.append("|");
            replaceAll = scanResult2.SSID.replaceAll(WebChromeClient.PARAM_SEPARATOR, "");
            if (replaceAll.length() > 30) {
                replaceAll = replaceAll.substring(0, 30);
            }
            sb2.append(replaceAll);
            sb2.append("|");
            sb2.append(scanResult2.level);
            sb2.append("|");
            if (wifiInfo == null && scanResult2.BSSID.equals(wifiInfo.getBSSID())) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            sb2.append(i2);
            jSONArray.put(sb2.toString());
        }
        if (jSONArray.length() != 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ap-list", jSONArray);
            jSONObject.put("meta-data", System.currentTimeMillis() + "|0");
            return jSONObject.toString();
        } catch (Exception unused4) {
            return "";
        }
    }
}
