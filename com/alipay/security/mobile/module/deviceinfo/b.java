package com.alipay.security.mobile.module.deviceinfo;

import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statistics.g;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f2057a = new b();

    public static String B() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            if (list != null) {
                for (NetworkInterface networkInterface : list) {
                    if (networkInterface != null && networkInterface.getName() != null && networkInterface.getName().equalsIgnoreCase(NetworkInfoUtils.NETWORK_NAME)) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            return Config.DEF_MAC_ID;
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            sb.append(String.format("%02X:", Integer.valueOf(hardwareAddress[i2] & 255)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
                return Config.DEF_MAC_ID;
            }
            return Config.DEF_MAC_ID;
        } catch (Throwable unused) {
            return Config.DEF_MAC_ID;
        }
    }

    public static String C() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    readLine = bufferedReader.readLine();
                } catch (Throwable unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (fileReader == null) {
                        return "";
                    }
                    try {
                        fileReader.close();
                    } catch (Throwable unused3) {
                        return "";
                    }
                }
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        if (!com.alipay.security.mobile.module.a.a.a(readLine)) {
            String trim = readLine.trim();
            try {
                bufferedReader.close();
            } catch (Throwable unused6) {
            }
            try {
                fileReader.close();
            } catch (Throwable unused7) {
            }
            return trim;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused8) {
        }
        fileReader.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        r1 = r2[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r0 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String D() {
        BufferedReader bufferedReader;
        String[] split;
        String str = "";
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!com.alipay.security.mobile.module.a.a.a(readLine) && (split = readLine.split(":")) != null && split.length > 1 && split[0].contains("BogoMIPS")) {
                                break;
                            }
                        }
                    } catch (Throwable unused) {
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused5) {
            return str;
        }
    }

    public static b a() {
        return f2057a;
    }

    public static String a(BluetoothAdapter bluetoothAdapter) {
        Object obj;
        try {
            Field declaredField = BluetoothAdapter.class.getDeclaredField("mService");
            declaredField.setAccessible(true);
            obj = declaredField.get(bluetoothAdapter);
        } catch (Throwable unused) {
        }
        if (obj == null) {
            return null;
        }
        Method declaredMethod = obj.getClass().getDeclaredMethod("getAddress", new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(obj, new Object[0]);
        if (invoke != null && (invoke instanceof String)) {
            return (String) invoke;
        }
        return null;
    }

    public static boolean a(Context context, String str) {
        return !b(context, str);
    }

    public static boolean b(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static String t() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String w(Context context) {
        if (a(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype != 4 && subtype != 1 && subtype != 2 && subtype != 7 && subtype != 11) {
                    if (subtype != 3 && subtype != 5 && subtype != 6 && subtype != 8 && subtype != 9 && subtype != 10 && subtype != 12 && subtype != 14 && subtype != 15) {
                        return subtype == 13 ? "4G" : "UNKNOW";
                    }
                    return g.f3962b;
                }
                return "2G";
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String A() {
        StringBuilder sb = new StringBuilder();
        sb.append("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put(RomUtils.PROP_RO_BUILD_FINGERPRINT, "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            char c2 = '0';
            String str2 = (String) linkedHashMap.get(str);
            String b2 = com.alipay.security.mobile.module.a.a.b(str, "");
            if (b2 != null && b2.contains(str2)) {
                c2 = '1';
            }
            sb.append(c2);
        }
        return sb.toString();
    }

    public String a(Context context) {
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Throwable unused) {
            }
        }
        return str == null ? "" : str;
    }

    public String b() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable unused) {
            j = 0;
        }
        return String.valueOf(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(Context context) {
        TelephonyManager telephonyManager;
        String subscriberId;
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (context != null) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
            if (telephonyManager != null) {
                subscriberId = telephonyManager.getSubscriberId();
                return subscriberId != null ? "" : subscriberId;
            }
        }
        subscriberId = "";
        if (subscriberId != null) {
        }
    }

    public String c() {
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(com.alipay.security.mobile.module.a.a.a().getPath());
                j = statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
        } catch (Throwable unused) {
        }
        return String.valueOf(j);
    }

    public String c(Context context) {
        int i2 = 0;
        try {
            i2 = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable unused) {
        }
        return i2 == 1 ? "1" : "0";
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
        if (r2 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d() {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        String str = "0000000000000000";
        LineNumberReader lineNumberReader = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/cpuinfo"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    LineNumberReader lineNumberReader2 = new LineNumberReader(inputStreamReader);
                    for (int i2 = 1; i2 < 100; i2++) {
                        try {
                            String readLine = lineNumberReader2.readLine();
                            if (readLine != null) {
                                if (readLine.indexOf("Serial") >= 0) {
                                    str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                                    break;
                                }
                            }
                        } catch (Throwable unused) {
                            lineNumberReader = lineNumberReader2;
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                    try {
                        lineNumberReader2.close();
                    } catch (Throwable unused4) {
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable unused5) {
                    }
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                inputStreamReader = null;
            }
        } catch (Throwable unused8) {
            fileInputStream = null;
            inputStreamReader = null;
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused9) {
        }
        return str == null ? "" : str;
    }

    public String d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            int i2 = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", String.valueOf(i2));
            jSONObject.put(NotificationCompat.CATEGORY_CALL, String.valueOf(streamVolume));
            jSONObject.put("system", String.valueOf(streamVolume2));
            jSONObject.put("ring", String.valueOf(streamVolume3));
            jSONObject.put("music", String.valueOf(streamVolume4));
            jSONObject.put(NotificationCompat.CATEGORY_ALARM, String.valueOf(streamVolume5));
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
        if (r2 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String e() {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        String str = "-1";
        LineNumberReader lineNumberReader = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/cpuinfo"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    LineNumberReader lineNumberReader2 = new LineNumberReader(inputStreamReader);
                    for (int i2 = 1; i2 < 100; i2++) {
                        try {
                            String readLine = lineNumberReader2.readLine();
                            if (readLine != null) {
                                if (readLine.indexOf("Hardware") >= 0) {
                                    str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                                    break;
                                }
                            }
                        } catch (Throwable unused) {
                            lineNumberReader = lineNumberReader2;
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                    try {
                        lineNumberReader2.close();
                    } catch (Throwable unused4) {
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable unused5) {
                    }
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                inputStreamReader = null;
            }
        } catch (Throwable unused8) {
            fileInputStream = null;
            inputStreamReader = null;
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused9) {
            return str;
        }
    }

    public String e(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getSimOperator();
                }
            } catch (Throwable unused) {
            }
        }
        return str == null ? "" : str;
    }

    public String f() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }

    public String f(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getSimOperatorName();
                }
            } catch (Throwable unused) {
            }
        }
        return str == null ? "" : str;
    }

    public String g() {
        String C = C();
        return !com.alipay.security.mobile.module.a.a.a(C) ? C : D();
    }

    public String g(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getNetworkOperatorName();
                }
            } catch (Throwable unused) {
            }
        }
        return (str == null || StringUtil.NULL_STRING.equals(str)) ? "" : str;
    }

    public String h() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String[] split;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        try {
            split = bufferedReader.readLine().split(":\\s+", 2);
        } catch (Throwable unused3) {
            fileReader2 = fileReader;
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (Throwable unused4) {
                }
            }
            if (bufferedReader == null) {
                return "";
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused5) {
                return "";
            }
        }
        if (split != null && split.length > 1) {
            String str = split[1];
            try {
                fileReader.close();
            } catch (Throwable unused6) {
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused7) {
            }
            return str;
        }
        try {
            fileReader.close();
        } catch (Throwable unused8) {
        }
        bufferedReader.close();
    }

    public String h(Context context) {
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r0 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String i() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String readLine;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        try {
            r2 = bufferedReader.readLine() != null ? Integer.parseInt(readLine.split("\\s+")[1]) : 0L;
            try {
                fileReader.close();
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
            fileReader2 = fileReader;
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (Throwable unused5) {
                }
            }
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused6) {
            return String.valueOf(r2);
        }
    }

    public String i(Context context) {
        return "";
    }

    public String j() {
        long j;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable unused) {
            j = 0;
        }
        return String.valueOf(j);
    }

    public String j(Context context) {
        List<Sensor> sensorList;
        String str = null;
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (Sensor sensor : sensorList) {
                        sb.append(sensor.getName());
                        sb.append(sensor.getVersion());
                        sb.append(sensor.getVendor());
                    }
                    str = com.alipay.security.mobile.module.a.a.e(sb.toString());
                }
            } catch (Throwable unused) {
            }
        }
        return str == null ? "" : str;
    }

    public String k() {
        long j = 0;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j = statFs.getBlockSize() * statFs.getBlockCount();
            }
        } catch (Throwable unused) {
        }
        return String.valueOf(j);
    }

    public String k(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", sensor.getName());
                            jSONObject.put("version", sensor.getVersion());
                            jSONObject.put("vendor", sensor.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    public String l(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + "*" + Integer.toString(displayMetrics.heightPixels);
        } catch (Throwable unused) {
            return "";
        }
    }

    public boolean l() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                return defaultAdapter.isEnabled();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String m() {
        BluetoothAdapter bluetoothAdapter;
        String str;
        try {
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (bluetoothAdapter != null) {
                try {
                    if (!bluetoothAdapter.isEnabled()) {
                        return "";
                    }
                } catch (Throwable unused) {
                    str = "";
                    if (str != null) {
                    }
                    try {
                        str = a(bluetoothAdapter);
                    } catch (Throwable unused2) {
                    }
                    if (str != null) {
                    }
                }
            }
            str = bluetoothAdapter.getAddress();
        } catch (Throwable unused3) {
            bluetoothAdapter = null;
        }
        if (str != null || str.endsWith("00:00:00:00:00")) {
            str = a(bluetoothAdapter);
        }
        return str != null ? "" : str;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x000d: IGET  (r2v4 int A[REMOVE]) = (r2v3 android.util.DisplayMetrics) android.util.DisplayMetrics.densityDpi int)] */
    public String m(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.densityDpi);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String n() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x000d: IGET  (r2v4 int A[REMOVE]) = (r2v3 android.util.DisplayMetrics) android.util.DisplayMetrics.widthPixels int)] */
    public String n(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.widthPixels);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String o() {
        BufferedReader bufferedReader;
        String str;
        String str2;
        try {
            FileInputStream fileInputStream = new FileInputStream(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
                str = "";
            } catch (Throwable unused) {
                bufferedReader = null;
                str = "";
            }
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    }
                } catch (Throwable unused2) {
                }
                try {
                    try {
                        break;
                    } catch (Throwable unused3) {
                        str2 = "";
                        return str2 == null ? "" : str2;
                    }
                } catch (Throwable unused4) {
                    if (com.alipay.security.mobile.module.a.a.b(str)) {
                        String substring = str.substring(str.indexOf("version ") + 8);
                        str2 = substring.substring(0, substring.indexOf(" "));
                        if (str2 == null) {
                        }
                    }
                    str2 = "";
                    if (str2 == null) {
                    }
                }
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (Throwable unused5) {
            return "";
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x000d: IGET  (r2v4 int A[REMOVE]) = (r2v3 android.util.DisplayMetrics) android.util.DisplayMetrics.heightPixels int)] */
    public String o(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.heightPixels);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String p() {
        String str;
        try {
            str = Build.SERIAL;
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public String p(Context context) {
        String str = "";
        if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (str == null || str.length() == 0 || Config.DEF_MAC_ID.equals(str)) {
                return B();
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public String q() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public String q(Context context) {
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            if (simSerialNumber != null) {
                if (simSerialNumber != null) {
                    try {
                        if (simSerialNumber.length() == 0) {
                            return "";
                        }
                    } catch (Throwable unused) {
                    }
                }
                return simSerialNumber;
            }
            return "";
        } catch (Throwable unused2) {
            return "";
        }
    }

    public String r() {
        String str;
        try {
            str = InetAddress.getLocalHost().getHostName();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public String r(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public String s() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (com.baidu.mobstat.Config.DEF_MAC_ID.equals(r0) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String s(Context context) {
        if (a(context, "android.permission.BLUETOOTH")) {
            return "";
        }
        String m = m();
        if (m != null) {
            try {
                if (m.length() != 0) {
                }
            } catch (Throwable unused) {
                return m;
            }
        }
        m = Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
        return m != null ? m : "";
    }

    public String t(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0012: ARITH  (r0v3 long A[REMOVE]) = (r0v2 long) - (wrap: long : 0x0010: ARITH  (r3v1 long A[REMOVE]) = (r0v2 long) % (1000 long)))] */
    public String u() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis - (currentTimeMillis % 1000));
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String u(Context context) {
        String str;
        WifiManager wifiManager;
        if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            wifiManager = (WifiManager) context.getSystemService("wifi");
        } catch (Throwable unused) {
        }
        if (wifiManager.isWifiEnabled()) {
            str = wifiManager.getConnectionInfo().getBSSID();
            return str != null ? "" : str;
        }
        str = "";
        if (str != null) {
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0005: INVOKE  (r1v0 long A[REMOVE]) =  type: STATIC call: android.os.SystemClock.elapsedRealtime():long)] */
    public String v() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String v(Context context) {
        try {
            String w = w(context);
            String t = t();
            if (com.alipay.security.mobile.module.a.a.b(w) && com.alipay.security.mobile.module.a.a.b(t)) {
                return w + ":" + t();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public String w() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb.append("00:");
            for (int i2 = 0; i2 < 7; i2++) {
                sb.append(new File(strArr[i2]).exists() ? "1" : "0");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String x() {
        String[] strArr = {"dalvik.system.Taint"};
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(":");
        for (int i2 = 0; i2 <= 0; i2++) {
            try {
                Class.forName(strArr[0]);
                sb.append("1");
            } catch (Throwable unused) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    public String x(Context context) {
        try {
            long j = 0;
            if (((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
                for (int i2 = 0; i2 < 5; i2++) {
                    long j2 = -1;
                    try {
                        j2 = new File(strArr[i2]).lastModified();
                    } catch (Throwable unused) {
                    }
                    j = Math.max(j2, j);
                }
                return "1:" + j;
            }
            return "0:0";
        } catch (Throwable unused2) {
            return "";
        }
    }

    public String y() {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SnapshotConstant.DeviceFilePathConstants.DEVICE_BUILD_CONFIG, "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb.append("00:");
        for (String str : linkedHashMap.keySet()) {
            LineNumberReader lineNumberReader = null;
            char c2 = '0';
            try {
                LineNumberReader lineNumberReader2 = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = lineNumberReader2.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                            c2 = '1';
                            break;
                        }
                    } catch (Throwable unused) {
                        lineNumberReader = lineNumberReader2;
                        sb.append('0');
                        if (lineNumberReader != null) {
                            lineNumberReader.close();
                        }
                    }
                }
                sb.append(c2);
                try {
                    lineNumberReader2.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String y(Context context) {
        boolean z;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("status", -1);
            if (intExtra2 != 2 && intExtra2 != 5) {
                z = false;
                StringBuilder sb = new StringBuilder();
                sb.append(!z ? "1" : "0");
                sb.append(":");
                sb.append(intExtra);
                return sb.toString();
            }
            z = true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(!z ? "1" : "0");
            sb2.append(":");
            sb2.append(intExtra);
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String z() {
        StringBuilder sb = new StringBuilder();
        sb.append("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (String str : linkedHashMap.keySet()) {
            char c2 = '0';
            try {
                String str2 = (String) Build.class.getField(str).get(null);
                String str3 = (String) linkedHashMap.get(str);
                String lowerCase = str2 != null ? str2.toLowerCase() : null;
                if (lowerCase != null && lowerCase.contains(str3)) {
                    c2 = '1';
                }
            } catch (Throwable unused) {
            }
            sb.append(c2);
        }
        return sb.toString();
    }
}
