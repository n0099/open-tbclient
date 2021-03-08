package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.Headers;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.mobstat.bm;
import com.baidu.mobstat.bt;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
/* loaded from: classes4.dex */
public class bw {

    /* renamed from: a  reason: collision with root package name */
    private static String f2646a = null;
    private static String b = null;
    private static String c = null;
    private static final Pattern d = Pattern.compile("\\s*|\t|\r|\n");

    public static String a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return "";
            }
            Object obj = null;
            if (applicationInfo.metaData != null) {
                obj = applicationInfo.metaData.get(str);
            }
            if (obj == null) {
                bc.c().a("can't find information in AndroidManifest.xml for key " + str);
                return "";
            }
            return obj.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(int i, Context context) {
        try {
            return bm.b.c(i, a(context).getBytes());
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(Context context) {
        return d.matcher(bx.a(context)).replaceAll("");
    }

    public static String b(Context context) {
        return bt.a.a(a(context).getBytes()).toUpperCase(Locale.US);
    }

    public static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = e(context);
        } catch (Exception e) {
        }
        return displayMetrics.widthPixels;
    }

    public static int d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = e(context);
        } catch (Exception e) {
        }
        return displayMetrics.heightPixels;
    }

    public static DisplayMetrics e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return 1;
        }
    }

    public static String g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "";
        }
    }

    public static String h(Context context) {
        try {
            return (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        } catch (Exception e) {
            return "";
        }
    }

    public static String i(Context context) {
        String format = String.format("%s_%s_%s", 0, 0, 0);
        try {
            if (bo.e(context, "android.permission.ACCESS_FINE_LOCATION") || bo.e(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
                if (cellLocation == null) {
                    return format;
                }
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return String.format("%s_%s_%s", String.format("%d", Integer.valueOf(gsmCellLocation.getCid())), String.format("%d", Integer.valueOf(gsmCellLocation.getLac())), 0);
                }
                String[] split = cellLocation.toString().replace("[", "").replace("]", "").split(",");
                return String.format("%s_%s_%s", split[0], split[3], split[4]);
            }
        } catch (Exception e) {
        }
        return format;
    }

    public static String j(Context context) {
        Location lastKnownLocation;
        try {
            if (bo.e(context, "android.permission.ACCESS_FINE_LOCATION") && (lastKnownLocation = ((LocationManager) context.getSystemService(Headers.LOCATION)).getLastKnownLocation("gps")) != null) {
                return String.format("%s_%s_%s", Long.valueOf(lastKnownLocation.getTime()), Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude()));
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String b(int i, Context context) {
        String l = l(context);
        return TextUtils.isEmpty(l) ? "" : bm.b.c(i, l.getBytes());
    }

    public static String k(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return l(context);
        }
        return d();
    }

    public static String l(Context context) {
        WifiInfo connectionInfo;
        try {
            if (bo.e(context, "android.permission.ACCESS_WIFI_STATE") && (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) != null) {
                String macAddress = connectionInfo.getMacAddress();
                if (!TextUtils.isEmpty(macAddress)) {
                    return macAddress;
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    @TargetApi(9)
    private static String d() {
        if (Build.VERSION.SDK_INT < 9) {
            return "";
        }
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
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
        } catch (Throwable th) {
        }
        return "";
    }

    private static String a(byte b2) {
        String str;
        return ("00" + Integer.toHexString(b2) + ":").substring(str.length() - 3);
    }

    public static String c(int i, Context context) {
        String d2 = d(i, context);
        String str = null;
        if (!TextUtils.isEmpty(d2)) {
            str = bm.b.c(i, d2.getBytes());
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String d(int i, Context context) {
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            a2 = e(i, context);
        }
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        return a2;
    }

    @SuppressLint({"NewApi"})
    public static String e(int i, Context context) {
        byte[] bArr;
        byte[] bArr2 = null;
        StringBuffer stringBuffer = new StringBuffer();
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
                                bArr = nextElement.getHardwareAddress();
                            } else if (!nextElement2.isLinkLocalAddress()) {
                                bArr2 = nextElement.getHardwareAddress();
                                break;
                            } else {
                                bArr = bArr2;
                            }
                            bArr2 = bArr;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        if (bArr2 != null) {
            for (byte b2 : bArr2) {
                stringBuffer.append(a(b2));
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(":", "");
        }
        String b3 = b(i, context);
        if (b3 != null) {
            return b3.replaceAll(":", "");
        }
        return b3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [512=4] */
    public static String a() {
        Throwable th;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            char[] cArr = new char[20];
            inputStreamReader2 = new InputStreamReader(new FileInputStream("/sys/class/net/eth0/address"));
            while (true) {
                try {
                    int read = inputStreamReader2.read(cArr);
                    if (read == -1) {
                        break;
                    } else if (read != cArr.length || cArr[cArr.length - 1] == '\r') {
                        for (int i = 0; i < read; i++) {
                            if (cArr[i] != '\r') {
                                stringBuffer.append(cArr[i]);
                            }
                        }
                    } else {
                        System.out.print(cArr);
                    }
                } catch (Exception e) {
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (Exception e2) {
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader = inputStreamReader2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            }
            str = stringBuffer.toString().trim().replaceAll(":", "");
            if (inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                } catch (Exception e4) {
                }
            }
        } catch (Exception e5) {
            inputStreamReader2 = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
        return str;
    }

    public static String a(Context context, int i) {
        String m = m(context);
        return TextUtils.isEmpty(m) ? "" : bm.b.c(i, m.getBytes());
    }

    public static String m(Context context) {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                String name = defaultAdapter.getName();
                if (name != null) {
                    return name;
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String f(int i, Context context) {
        String n = n(context);
        return TextUtils.isEmpty(n) ? "" : bm.b.c(i, n.getBytes());
    }

    @SuppressLint({"NewApi"})
    public static String n(Context context) {
        BluetoothAdapter defaultAdapter;
        String str = android.os.Build.BRAND;
        if ("4.1.1".equals(Build.VERSION.RELEASE) && "TCT".equals(str)) {
            return "";
        }
        try {
            if (bo.e(context, "android.permission.BLUETOOTH") && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null) {
                String address = defaultAdapter.getAddress();
                if (address != null) {
                    return address;
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String o(Context context) {
        String p = p(context);
        return TextUtils.isEmpty(p) ? "" : bm.a.a(p.getBytes());
    }

    public static String g(int i, Context context) {
        String p = p(context);
        return TextUtils.isEmpty(p) ? "" : bm.b.d(i, p.getBytes());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008d A[Catch: Exception -> 0x0120, TryCatch #0 {Exception -> 0x0120, blocks: (B:25:0x0065, B:27:0x008d, B:28:0x0094, B:30:0x00aa, B:33:0x00b7), top: B:57:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String p(Context context) {
        boolean z;
        WifiInfo wifiInfo;
        List<ScanResult> list;
        WifiInfo wifiInfo2;
        JSONArray jSONArray;
        int i;
        String replaceAll;
        if (context == null || !bo.e(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            z = bo.e(context, "android.permission.ACCESS_FINE_LOCATION") ? ((LocationManager) context.getSystemService(Headers.LOCATION)).isProviderEnabled("gps") : false;
        } catch (Exception e) {
            z = false;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            try {
                list = wifiManager.getScanResults();
                wifiInfo2 = connectionInfo;
            } catch (Throwable th) {
                wifiInfo = connectionInfo;
                list = null;
                wifiInfo2 = wifiInfo;
                if (list != null) {
                    Collections.sort(list, new Comparator<ScanResult>() { // from class: com.baidu.mobstat.bw.1
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
                        replaceAll = scanResult.SSID.replaceAll(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR, "");
                        if (replaceAll.length() > 30) {
                        }
                        sb.append(replaceAll);
                        sb.append("|");
                        sb.append(scanResult.level);
                        sb.append("|");
                        sb.append((wifiInfo2 == null && scanResult.BSSID.equals(wifiInfo2.getBSSID())) ? 1 : 0);
                        jSONArray.put(sb.toString());
                    } catch (Exception e2) {
                    }
                }
                if (jSONArray.length() != 0) {
                }
            }
        } catch (Throwable th2) {
            wifiInfo = null;
        }
        if (list != null && list.size() != 0) {
            Collections.sort(list, new Comparator<ScanResult>() { // from class: com.baidu.mobstat.bw.1
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
            replaceAll = scanResult2.SSID.replaceAll(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR, "");
            if (replaceAll.length() > 30) {
                replaceAll = replaceAll.substring(0, 30);
            }
            sb2.append(replaceAll);
            sb2.append("|");
            sb2.append(scanResult2.level);
            sb2.append("|");
            sb2.append((wifiInfo2 == null && scanResult2.BSSID.equals(wifiInfo2.getBSSID())) ? 1 : 0);
            jSONArray.put(sb2.toString());
        }
        if (jSONArray.length() != 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(System.currentTimeMillis());
            sb3.append("|");
            sb3.append(z ? 1 : 0);
            sb3.append("|");
            sb3.append(j(context));
            jSONObject.put("ap-list", jSONArray);
            jSONObject.put("meta-data", sb3.toString());
            return jSONObject.toString();
        } catch (Exception e3) {
            return "";
        }
    }

    public static boolean q(Context context) {
        boolean z;
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isAvailable()) {
                if (networkInfo.isConnected()) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static String r(Context context) {
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            String typeName = activeNetworkInfo.getTypeName();
            try {
                if (!typeName.equals("WIFI") && activeNetworkInfo.getSubtypeName() != null) {
                    return activeNetworkInfo.getSubtypeName();
                }
                return typeName;
            } catch (Exception e) {
                return str;
            }
        } catch (Exception e2) {
            return "";
        }
    }

    public static boolean s(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (bo.e(context, "android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                    return activeNetworkInfo.isAvailable();
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static String t(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static String h(int i, Context context) {
        String t = t(context);
        if (!TextUtils.isEmpty(t)) {
            try {
                return bm.b.c(i, t.getBytes());
            } catch (Exception e) {
            }
        }
        return "";
    }

    private static String y(Context context) {
        String str;
        String str2 = f2646a;
        if (str2 == null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
                for (int i = 0; runningAppProcesses != null && i < runningAppProcesses.size(); i++) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
                str = str2;
            } catch (Exception e) {
                str = str2;
            }
            if (str == null) {
                str = "";
            }
            f2646a = str;
            return str;
        }
        return str2;
    }

    private static String b(Context context, String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(58)) > 0 && lastIndexOf + 1 < str.length()) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    private static String c(Context context, String str) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        String str2 = applicationInfo.processName;
        if (str2 == null || str2.equals(str)) {
            str = null;
        }
        return str;
    }

    public static String u(Context context) {
        String str = b;
        if (str == null) {
            String y = y(context);
            str = b(context, y);
            if (TextUtils.isEmpty(str)) {
                str = c(context, y);
            }
            if (str == null) {
                str = "";
            }
            b = str;
        }
        return str;
    }

    public static String v(Context context) {
        ServiceInfo[] serviceInfoArr;
        String str = "";
        String y = y(context);
        if (y == null) {
            return "";
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
        } catch (Exception e) {
        }
        if (packageInfo == null || (serviceInfoArr = packageInfo.services) == null) {
            return "";
        }
        int length = serviceInfoArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            ServiceInfo serviceInfo = serviceInfoArr[i];
            if (!y.equals(serviceInfo.processName)) {
                i++;
            } else {
                str = serviceInfo.name;
                break;
            }
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static boolean w(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003b: INVOKE  (r2v3 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public static String x(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
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
            return bm.a.a(jSONObject2.toString().getBytes());
        } catch (Exception e) {
            return "";
        }
    }

    public static String b() {
        if (c != null) {
            return c;
        }
        String str = "";
        if (!TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
            str = "miui";
        } else if (!TextUtils.isEmpty(a("ro.build.version.opporom"))) {
            str = "coloros";
        } else if (!TextUtils.isEmpty(a("ro.build.version.emui"))) {
            str = "emui";
        } else if (!TextUtils.isEmpty(a("ro.vivo.os.version"))) {
            str = "funtouch";
        } else if (!TextUtils.isEmpty(a("ro.smartisan.version"))) {
            str = RomUtils.MANUFACTURER_SMARTISAN;
        }
        if (TextUtils.isEmpty(str)) {
            String a2 = a(RomUtils.PROP_RO_BUILD_DISPLAY_ID);
            if (!TextUtils.isEmpty(a2) && a2.contains("Flyme")) {
                str = "flyme";
            }
        }
        c = str;
        return c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1032=4] */
    private static String a(String str) {
        Throwable th;
        Process process;
        BufferedReader bufferedReader;
        Process process2;
        BufferedReader bufferedReader2;
        String str2 = null;
        try {
            process2 = Runtime.getRuntime().exec("getprop " + str);
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(process2.getInputStream()), 1024);
                try {
                    str2 = bufferedReader2.readLine();
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e) {
                        }
                    }
                    if (process2 != null) {
                        process2.destroy();
                    }
                } catch (Exception e2) {
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (process2 != null) {
                        process2.destroy();
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    process = process2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                bufferedReader2 = null;
            } catch (Throwable th3) {
                th = th3;
                process = process2;
                bufferedReader = null;
            }
        } catch (Exception e6) {
            process2 = null;
            bufferedReader2 = null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
            bufferedReader = null;
        }
        return str2;
    }

    public static Boolean c() {
        Object invoke;
        try {
            Class<?> cls = Class.forName("com.baidu.disasterrecovery.MtjAdapter");
            if (cls == null || (invoke = cls.getDeclaredMethod("shouldUploadOther", new Class[0]).invoke(null, new Object[0])) == null || !(invoke instanceof Boolean)) {
                return true;
            }
            return (Boolean) invoke;
        } catch (Exception e) {
            return true;
        }
    }
}
