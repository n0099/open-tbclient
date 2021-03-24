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
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statusbar.ImmersiveOSUtils;
import com.baidu.mobstat.bm;
import com.baidu.mobstat.bt;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
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
/* loaded from: classes2.dex */
public class bw {

    /* renamed from: a  reason: collision with root package name */
    public static String f9128a;

    /* renamed from: b  reason: collision with root package name */
    public static String f9129b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9130c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f9131d = Pattern.compile("\\s*|\t|\r|\n");

    public static String a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                Object obj = bundle != null ? bundle.get(str) : null;
                if (obj == null) {
                    bc c2 = bc.c();
                    c2.a("can't find information in AndroidManifest.xml for key " + str);
                    return "";
                }
                return obj.toString();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(Context context) {
        return bt.a.a(a(context).getBytes()).toUpperCase(Locale.US);
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
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
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
        CellLocation cellLocation;
        String format = String.format("%s_%s_%s", 0, 0, 0);
        try {
            if ((bo.e(context, "android.permission.ACCESS_FINE_LOCATION") || bo.e(context, "android.permission.ACCESS_COARSE_LOCATION")) && (cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation()) != null) {
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return String.format("%s_%s_%s", String.format("%d", Integer.valueOf(gsmCellLocation.getCid())), String.format("%d", Integer.valueOf(gsmCellLocation.getLac())), 0);
                }
                String[] split = cellLocation.toString().replace("[", "").replace("]", "").split(",");
                return String.format("%s_%s_%s", split[0], split[3], split[4]);
            }
            return format;
        } catch (Exception unused) {
        }
        return format;
    }

    public static String j(Context context) {
        Location lastKnownLocation;
        try {
            return (!bo.e(context, "android.permission.ACCESS_FINE_LOCATION") || (lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("gps")) == null) ? "" : String.format("%s_%s_%s", Long.valueOf(lastKnownLocation.getTime()), Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude()));
        } catch (Exception unused) {
            return "";
        }
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
            if (!bo.e(context, "android.permission.ACCESS_WIFI_STATE") || (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) == null) {
                return "";
            }
            String macAddress = connectionInfo.getMacAddress();
            return !TextUtils.isEmpty(macAddress) ? macAddress : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m(Context context) {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                String name = defaultAdapter.getName();
                return name != null ? name : "";
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
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
        } catch (Exception unused) {
        }
        return "";
    }

    public static String o(Context context) {
        String p = p(context);
        return TextUtils.isEmpty(p) ? "" : bm.a.a(p.getBytes());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:8|(2:9|10)|(11:12|13|14|15|17|18|(1:22)|23|(2:24|(1:1)(8:30|31|(1:33)|34|(1:42)(1:38)|39|40|41))|46|(1:48)(6:49|50|51|(1:53)|54|55))|65|13|14|15|17|18|(2:20|22)|23|(3:24|(2:26|58)(1:59)|41)|46|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:8|9|10|(11:12|13|14|15|17|18|(1:22)|23|(2:24|(1:1)(8:30|31|(1:33)|34|(1:42)(1:38)|39|40|41))|46|(1:48)(6:49|50|51|(1:53)|54|55))|65|13|14|15|17|18|(2:20|22)|23|(3:24|(2:26|58)(1:59)|41)|46|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        r4 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2 A[ADDED_TO_REGION, EDGE_INSN: B:66:0x00b2->B:42:0x00b2 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String p(Context context) {
        boolean z;
        List<ScanResult> list;
        JSONArray jSONArray;
        int i;
        if (context == null || !bo.e(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        if (bo.e(context, "android.permission.ACCESS_FINE_LOCATION")) {
            z = ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            list = wifiManager.getScanResults();
            if (list != null && list.size() != 0) {
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
            i = 0;
            while (true) {
                int i2 = 1;
                if (list != null || i >= list.size() || i >= 30) {
                    break;
                }
                try {
                    ScanResult scanResult = list.get(i);
                    StringBuilder sb = new StringBuilder();
                    sb.append(scanResult.BSSID);
                    sb.append(FieldBuilder.SE);
                    String replaceAll = scanResult.SSID.replaceAll("\\|", "");
                    if (replaceAll.length() > 30) {
                        replaceAll = replaceAll.substring(0, 30);
                    }
                    sb.append(replaceAll);
                    sb.append(FieldBuilder.SE);
                    sb.append(scanResult.level);
                    sb.append(FieldBuilder.SE);
                    if (wifiInfo == null || !scanResult.BSSID.equals(wifiInfo.getBSSID())) {
                        i2 = 0;
                    }
                    sb.append(i2);
                    jSONArray.put(sb.toString());
                } catch (Exception unused) {
                }
                i++;
            }
            if (jSONArray.length() == 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis());
                sb2.append(FieldBuilder.SE);
                sb2.append(z ? 1 : 0);
                sb2.append(FieldBuilder.SE);
                sb2.append(j(context));
                jSONObject.put("ap-list", jSONArray);
                jSONObject.put("meta-data", sb2.toString());
                return jSONObject.toString();
            } catch (Exception unused2) {
                return "";
            }
        }
        z = false;
        WifiManager wifiManager2 = (WifiManager) context.getSystemService("wifi");
        WifiInfo wifiInfo2 = wifiManager2.getConnectionInfo();
        list = wifiManager2.getScanResults();
        if (list != null) {
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
        i = 0;
        while (true) {
            int i22 = 1;
            if (list != null) {
                break;
            }
            break;
            i++;
        }
        if (jSONArray.length() == 0) {
        }
    }

    public static boolean q(Context context) {
        if (context != null) {
            try {
                NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
                if (networkInfo == null || !networkInfo.isAvailable()) {
                    return false;
                }
                return networkInfo.isConnected();
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public static String r(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                return (typeName.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean s(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (!bo.e(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return false;
                }
                return activeNetworkInfo.isAvailable();
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public static String t(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static String u(Context context) {
        String str = f9129b;
        if (str == null) {
            String y = y(context);
            String b2 = b(context, y);
            if (TextUtils.isEmpty(b2)) {
                b2 = c(context, y);
            }
            str = b2 == null ? "" : b2;
            f9129b = str;
        }
        return str;
    }

    public static String v(Context context) {
        ServiceInfo[] serviceInfoArr;
        String str;
        String y = y(context);
        if (y == null) {
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
            if (y.equals(serviceInfo.processName)) {
                str = serviceInfo.name;
                break;
            }
            i++;
        }
        return str == null ? "" : str;
    }

    public static boolean w(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0038: INVOKE  (r1v3 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public static String x(Context context) {
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
            return bm.a.a(jSONObject2.toString().getBytes());
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        r0 = r2.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String y(Context context) {
        String str = f9128a;
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
            f9128a = str;
        }
        return str;
    }

    public static String b(int i, Context context) {
        String l = l(context);
        return TextUtils.isEmpty(l) ? "" : bm.b.c(i, l.getBytes());
    }

    public static String c(int i, Context context) {
        String d2 = d(i, context);
        String c2 = !TextUtils.isEmpty(d2) ? bm.b.c(i, d2.getBytes()) : null;
        return TextUtils.isEmpty(c2) ? "" : c2;
    }

    @TargetApi(9)
    public static String d() {
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
        } catch (Throwable unused) {
        }
        return "";
    }

    @SuppressLint({"NewApi"})
    public static String e(int i, Context context) {
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
                                bArr = nextElement.getHardwareAddress();
                            } else if (!nextElement2.isLinkLocalAddress()) {
                                bArr = nextElement.getHardwareAddress();
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
        String b3 = b(i, context);
        return b3 != null ? b3.replaceAll(":", "") : b3;
    }

    public static String h(int i, Context context) {
        String t = t(context);
        if (TextUtils.isEmpty(t)) {
            return "";
        }
        try {
            return bm.b.c(i, t.getBytes());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(Context context, String str) {
        int lastIndexOf;
        int i;
        if (str != null && (lastIndexOf = str.lastIndexOf(58)) > 0 && (i = lastIndexOf + 1) < str.length()) {
            return str.substring(i);
        }
        return null;
    }

    public static String f(int i, Context context) {
        String n = n(context);
        return TextUtils.isEmpty(n) ? "" : bm.b.c(i, n.getBytes());
    }

    public static String g(int i, Context context) {
        String p = p(context);
        return TextUtils.isEmpty(p) ? "" : bm.b.d(i, p.getBytes());
    }

    public static String a(int i, Context context) {
        try {
            return bm.b.c(i, a(context).getBytes());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        String str;
        String str2 = f9130c;
        if (str2 != null) {
            return str2;
        }
        if (!TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
            str = "miui";
        } else if (!TextUtils.isEmpty(a("ro.build.version.opporom"))) {
            str = "coloros";
        } else if (!TextUtils.isEmpty(a("ro.build.version.emui"))) {
            str = "emui";
        } else if (TextUtils.isEmpty(a("ro.vivo.os.version"))) {
            str = !TextUtils.isEmpty(a("ro.smartisan.version")) ? RomUtils.MANUFACTURER_SMARTISAN : "";
        } else {
            str = "funtouch";
        }
        if (TextUtils.isEmpty(str)) {
            String a2 = a("ro.build.display.id");
            if (!TextUtils.isEmpty(a2) && a2.contains("Flyme")) {
                str = ImmersiveOSUtils.FLYME;
            }
        }
        f9130c = str;
        return str;
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

    public static String a(Context context) {
        return f9131d.matcher(bx.a(context)).replaceAll("");
    }

    public static Boolean c() {
        Object invoke;
        Boolean bool = Boolean.TRUE;
        try {
            Class<?> cls = Class.forName("com.baidu.disasterrecovery.MtjAdapter");
            return (cls == null || (invoke = cls.getDeclaredMethod("shouldUploadOther", new Class[0]).invoke(null, new Object[0])) == null || !(invoke instanceof Boolean)) ? bool : (Boolean) invoke;
        } catch (Exception unused) {
            return bool;
        }
    }

    public static String a(byte b2) {
        String str;
        return ("00" + Integer.toHexString(b2) + ":").substring(str.length() - 3);
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
                    } else if (read != 20 || cArr[19] == '\r') {
                        for (int i = 0; i < read; i++) {
                            if (cArr[i] != '\r') {
                                stringBuffer.append(cArr[i]);
                            }
                        }
                    } else {
                        System.out.print(cArr);
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

    public static String d(int i, Context context) {
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            a2 = e(i, context);
        }
        return TextUtils.isEmpty(a2) ? "" : a2;
    }

    public static String a(Context context, int i) {
        String m = m(context);
        return TextUtils.isEmpty(m) ? "" : bm.b.c(i, m.getBytes());
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
    public static String a(String str) {
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
}
