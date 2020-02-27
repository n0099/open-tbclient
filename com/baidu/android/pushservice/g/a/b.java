package com.baidu.android.pushservice.g.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.i.g;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {

    /* loaded from: classes8.dex */
    public static class a {
        public int a;
        public int b;
        public int c;
        public double d;
        public long e;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String str;
        a a2;
        byte[] bArr;
        RandomAccessFile randomAccessFile2 = null;
        try {
            bArr = new byte[1024];
            randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
        } catch (Exception e) {
        } catch (Throwable th2) {
            randomAccessFile = null;
            th = th2;
        }
        try {
            randomAccessFile.read(bArr);
            str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            com.baidu.android.pushservice.e.b.a(randomAccessFile);
        } catch (Exception e2) {
            randomAccessFile2 = randomAccessFile;
            com.baidu.android.pushservice.e.b.a(randomAccessFile2);
            str = "";
            a2 = a(str);
            if (a2 != null) {
            }
            return a2;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.android.pushservice.e.b.a(randomAccessFile);
            throw th;
        }
        a2 = a(str);
        if (a2 != null) {
            a2.e = f();
        }
        return a2;
    }

    private static a a(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        aVar.a = 0;
        aVar.c = 0;
        aVar.b = 1;
        aVar.d = 0.0d;
        if (str.contains("ARMv5")) {
            aVar.a = 1;
        } else if (str.contains("ARMv6")) {
            aVar.a = 16;
        } else if (str.contains("ARMv7")) {
            aVar.a = 256;
        }
        if (str.contains("neon")) {
            aVar.c |= 256;
        }
        if (str.contains("vfpv3")) {
            aVar.c |= 16;
        }
        if (str.contains(" vfp")) {
            aVar.c |= 1;
        }
        String[] split = str.split("\n");
        if (split.length > 0) {
            for (String str2 : split) {
                if (str2.contains("CPU variant")) {
                    int indexOf2 = str2.indexOf(": ");
                    if (indexOf2 >= 0) {
                        try {
                            aVar.b = Integer.decode(str2.substring(indexOf2 + 2)).intValue();
                            aVar.b = aVar.b == 0 ? 1 : aVar.b;
                        } catch (NumberFormatException e) {
                            aVar.b = 1;
                        }
                    }
                } else if (str2.contains("BogoMIPS") && (indexOf = str2.indexOf(": ")) >= 0) {
                    try {
                        aVar.d = Double.parseDouble(str2.substring(indexOf + 2));
                    } catch (NumberFormatException e2) {
                        aVar.d = 0.0d;
                    }
                }
            }
            return aVar;
        }
        return aVar;
    }

    public static String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            } catch (IOException e) {
                com.baidu.android.pushservice.e.b.a(inputStream, inputStreamReader, bufferedReader);
            } catch (Throwable th) {
                com.baidu.android.pushservice.e.b.a(inputStream, inputStreamReader, bufferedReader);
                throw th;
            }
        }
        com.baidu.android.pushservice.e.b.a(inputStream, inputStreamReader, bufferedReader);
        return sb.toString();
    }

    public static int[] a(Context context) {
        int[] iArr = new int[3];
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            return iArr;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            iArr[1] = displayMetrics.widthPixels;
            iArr[0] = displayMetrics.heightPixels;
        }
        iArr[2] = displayMetrics.densityDpi;
        return iArr;
    }

    public static long b() {
        FileReader fileReader;
        Throwable th;
        String readLine;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
                long intValue = bufferedReader.readLine() != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() / 1024 : 0L;
                bufferedReader.close();
                com.baidu.android.pushservice.e.b.a(fileReader);
                return intValue;
            } catch (IOException e) {
                com.baidu.android.pushservice.e.b.a(fileReader);
                return -1L;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.android.pushservice.e.b.a(fileReader);
                throw th;
            }
        } catch (IOException e2) {
            fileReader = null;
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
        }
    }

    public static String b(Context context) {
        return g.d(context);
    }

    public static String c() {
        a a2 = a();
        return a2 != null ? (a2.a & 1) == 1 ? "armv5" : (a2.a & 16) == 16 ? "armv6" : (a2.a & 256) == 256 ? "armv7" : "unknown" : "";
    }

    public static boolean c(Context context) {
        return g.a(context);
    }

    public static String d() {
        a a2 = a();
        return a2 != null ? (a2.c & 256) == 256 ? "neon" : (a2.c & 1) == 1 ? "vfp" : (a2.c & 16) == 16 ? "vfpv3" : "unknown" : "";
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                jSONObject.put("type", telephonyManager.getNetworkType());
                jSONObject.put("operator", telephonyManager.getNetworkOperatorName());
            }
            jSONObject.put("access_type", b(context));
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator) || networkOperator.length() < 4) {
                    jSONObject.put("mcc", -1);
                    jSONObject.put("mnc", -1);
                } else {
                    try {
                        jSONObject.put("mcc", Integer.parseInt(networkOperator.substring(0, 3)));
                        jSONObject.put("mnc", Integer.parseInt(networkOperator.substring(3)));
                    } catch (NumberFormatException e) {
                        jSONObject.put("mcc", -1);
                        jSONObject.put("mnc", -1);
                    }
                }
            }
            jSONObject.put("user_ip", e());
        } catch (JSONException e2) {
        }
        return jSONObject;
    }

    public static String e() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                String str = null;
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        str = !nextElement.isLoopbackAddress() ? nextElement.getHostAddress().toString() : str;
                    }
                }
                return str;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONObject e(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os_name", "Android");
            jSONObject.put("manufacture", Build.MANUFACTURER);
            jSONObject.put(BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("firmware", Build.FINGERPRINT);
            jSONObject.put("mem_size", String.valueOf(b()));
            int[] a2 = a(context);
            jSONObject.put("screen_width", String.valueOf(a2[0]));
            jSONObject.put("screen_height", String.valueOf(a2[1]));
            jSONObject.put("cpu_model", c());
            jSONObject.put("cpu_feature", d());
            jSONObject.put("screen_density", String.valueOf(a2[2]));
            jSONObject.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
            if (((TelephonyManager) context.getSystemService("phone")) != null) {
                jSONObject.put("wise_cuid", DeviceId.getCUID(context));
            }
            String string = context.getSharedPreferences("pst", 0).getString("push_mac_id", null);
            if (string == null || string.length() == 0) {
                try {
                    str = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
                    if (str != null) {
                        try {
                            if (str.length() > 0) {
                                context.getSharedPreferences("pst", 0).edit().putString("push_mac_id", str).apply();
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    str = string;
                }
            } else {
                str = string;
            }
            if (str != null && str.length() > 0) {
                jSONObject.put("mac_id", str);
            }
        } catch (JSONException e3) {
        }
        return jSONObject;
    }

    private static int f() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        FileReader fileReader2;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String readLine = bufferedReader.readLine();
                    int parseInt = readLine != null ? Integer.parseInt(readLine.trim()) : 0;
                    com.baidu.android.pushservice.e.b.a(fileReader, bufferedReader);
                    return parseInt;
                } catch (Exception e) {
                    bufferedReader2 = bufferedReader;
                    fileReader2 = fileReader;
                    com.baidu.android.pushservice.e.b.a(fileReader2, bufferedReader2);
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.android.pushservice.e.b.a(fileReader, bufferedReader);
                    throw th;
                }
            } catch (Exception e2) {
                fileReader2 = fileReader;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Exception e3) {
            fileReader2 = null;
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
        }
    }
}
