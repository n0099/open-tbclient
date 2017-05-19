package com.baidu.android.pushservice.f.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.pushservice.h.k;
import com.baidu.android.pushservice.i.e;
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
/* loaded from: classes2.dex */
public class b {

    /* loaded from: classes2.dex */
    public static class a {
        public int a;
        public int b;
        public int c;
        public double d;
        public long e;
    }

    /* renamed from: com.baidu.android.pushservice.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0017b {
        private static C0017b c = null;
        private Context a;
        private final JSONObject b = new JSONObject();

        private C0017b(Context context) {
            this.a = null;
            this.a = context;
            try {
                this.b.put("os_name", "Android");
                this.b.put("manufacture", Build.MANUFACTURER);
                this.b.put("os_version", Build.VERSION.RELEASE);
                this.b.put("model", Build.MODEL);
                this.b.put("firmware", Build.FINGERPRINT);
                this.b.put("mem_size", String.valueOf(b.b()));
                this.b.put("screen_width", String.valueOf(b.a(this.a)[0]));
                this.b.put("screen_height", String.valueOf(b.a(this.a)[1]));
                this.b.put("cpu_model", b.c());
                this.b.put("cpu_feature", b.d());
                this.b.put("screen_density", String.valueOf(b.a(this.a)[2]));
                if (((TelephonyManager) this.a.getSystemService("phone")) != null) {
                    this.b.put("wise_cuid", e.a(this.a));
                }
                String string = context.getSharedPreferences("pst", 0).getString("push_mac_id", null);
                if (string == null || string.length() == 0) {
                    try {
                        string = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                        if (string != null && string.length() > 0) {
                            context.getSharedPreferences("pst", 0).edit().putString("push_mac_id", string).commit();
                        }
                    } catch (Exception e) {
                        com.baidu.android.pushservice.e.a.a("StatUtils", e);
                    }
                }
                if (string == null || string.length() <= 0) {
                    return;
                }
                this.b.put("mac_id", string);
            } catch (JSONException e2) {
                com.baidu.android.pushservice.e.a.a("StatUtils", e2);
            }
        }

        public static synchronized C0017b a(Context context) {
            C0017b c0017b;
            synchronized (C0017b.class) {
                if (c == null) {
                    c = new C0017b(context);
                }
                c0017b = c;
            }
            return c0017b;
        }

        public JSONObject a() {
            return this.b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a() {
        RandomAccessFile randomAccessFile;
        String str;
        a a2;
        try {
            try {
                byte[] bArr = new byte[1024];
                randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
                try {
                    randomAccessFile.read(bArr);
                    str = new String(bArr);
                    int indexOf = str.indexOf(0);
                    if (indexOf != -1) {
                        str = str.substring(0, indexOf);
                    }
                    com.baidu.android.pushservice.d.b.a(randomAccessFile);
                } catch (Exception e) {
                    e = e;
                    com.baidu.android.pushservice.e.a.a("StatUtils", e);
                    com.baidu.android.pushservice.d.b.a(randomAccessFile);
                    str = "";
                    a2 = a(str);
                    if (a2 != null) {
                    }
                    return a2;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.android.pushservice.d.b.a(null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.android.pushservice.d.b.a(null);
            throw th;
        }
        a2 = a(str);
        if (a2 != null) {
            a2.e = e();
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
        if (split == null || split.length <= 0) {
            return aVar;
        }
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

    public static String a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (IOException e) {
                    com.baidu.android.pushservice.e.a.a("StatUtils", e);
                    com.baidu.android.pushservice.d.b.a(inputStream, inputStreamReader, bufferedReader);
                }
            } catch (Throwable th) {
                com.baidu.android.pushservice.d.b.a(inputStream, inputStreamReader, bufferedReader);
                throw th;
            }
        }
        com.baidu.android.pushservice.d.b.a(inputStream, inputStreamReader, bufferedReader);
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
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i >= i2) {
            i2 = i;
            i = i2;
        }
        iArr[0] = i2;
        iArr[1] = i;
        iArr[2] = displayMetrics.densityDpi;
        return iArr;
    }

    public static long b() {
        FileReader fileReader;
        Throwable th;
        String readLine;
        try {
            fileReader = new FileReader("/proc/meminfo");
        } catch (IOException e) {
            fileReader = null;
        } catch (Throwable th2) {
            fileReader = null;
            th = th2;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
            long intValue = bufferedReader.readLine() != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() / 1024 : 0L;
            bufferedReader.close();
            com.baidu.android.pushservice.d.b.a(fileReader);
            return intValue;
        } catch (IOException e2) {
            com.baidu.android.pushservice.d.b.a(fileReader);
            return -1L;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.android.pushservice.d.b.a(fileReader);
            throw th;
        }
    }

    public static String b(Context context) {
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
            com.baidu.android.pushservice.e.a.a("StatUtils", e);
            return null;
        }
    }

    public static String c() {
        a a2 = a();
        return a2 != null ? (a2.a & 1) == 1 ? "armv5" : (a2.a & 16) == 16 ? "armv6" : (a2.a & 256) == 256 ? "armv7" : "unknown" : "";
    }

    public static String c(Context context) {
        return k.d(context);
    }

    public static String d() {
        a a2 = a();
        return a2 != null ? (a2.c & 256) == 256 ? "neon" : (a2.c & 1) == 1 ? "vfp" : (a2.c & 16) == 16 ? "vfpv3" : "unknown" : "";
    }

    public static boolean d(Context context) {
        return k.a(context);
    }

    private static int e() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Exception e) {
                e = e;
                bufferedReader = null;
                fileReader2 = fileReader;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            fileReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            int parseInt = readLine != null ? Integer.parseInt(readLine.trim()) : 0;
            com.baidu.android.pushservice.d.b.a(fileReader, bufferedReader);
            return parseInt;
        } catch (Exception e3) {
            e = e3;
            fileReader2 = fileReader;
            try {
                com.baidu.android.pushservice.e.a.a("StatUtils", e);
                com.baidu.android.pushservice.d.b.a(fileReader2, bufferedReader);
                return 0;
            } catch (Throwable th3) {
                th = th3;
                fileReader = fileReader2;
                com.baidu.android.pushservice.d.b.a(fileReader, bufferedReader);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            com.baidu.android.pushservice.d.b.a(fileReader, bufferedReader);
            throw th;
        }
    }

    public static JSONObject e(Context context) {
        return C0017b.a(context).a();
    }

    public static JSONObject f(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                jSONObject.put("type", telephonyManager.getNetworkType());
                jSONObject.put("operator", telephonyManager.getNetworkOperatorName());
            }
            jSONObject.put("access_type", c(context));
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
            jSONObject.put("user_ip", b(context));
        } catch (JSONException e2) {
            com.baidu.android.pushservice.e.a.a("StatUtils", e2);
        }
        return jSONObject;
    }
}
