package com.baidu.location;

import android.location.Location;
import android.util.Log;
import com.baidu.mapapi.MKEvent;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f464a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static int f = 0;
    private static String aa = "baidu_location_service";
    private static String ab = "http://loc.map.baidu.com/sdk.php";
    public static String g = "http://loc.map.baidu.com/sdk_ep.php";
    private static boolean ac = false;
    private static boolean ad = false;
    private static boolean ae = true;
    private static String af = "[baidu_location_service]";
    private static Process ag = null;
    public static String h = null;
    public static String i = "no";
    public static String j = "gcj02";
    public static boolean k = true;
    public static boolean l = true;
    public static double m = 0.0d;
    public static double n = 0.0d;
    public static double o = 0.0d;
    public static double p = 0.0d;
    public static int q = 0;
    public static byte[] r = null;
    public static boolean s = false;
    public static int t = 0;
    public static float u = 1.1f;
    public static float v = 2.2f;
    public static float w = 2.3f;
    public static float x = 3.8f;
    public static int y = 3;
    public static int z = 10;
    public static int A = 2;
    public static int B = 7;
    public static int C = 20;
    public static int D = 70;
    public static int E = 120;
    public static float F = 2.0f;
    public static float G = 10.0f;
    public static float H = 50.0f;
    public static float I = 200.0f;
    public static int J = 16;
    public static float K = 0.9f;
    public static int L = 5000;
    public static float M = 0.5f;
    public static float N = 0.0f;
    public static float O = 0.1f;
    public static int P = 30;
    public static int Q = 100;
    public static boolean R = true;
    public static boolean S = true;
    public static int T = 20;
    public static int U = MKEvent.ERROR_PERMISSION_DENIED;
    public static int V = 1000;
    public static long W = 1200000;
    public static long X = 20;
    public static long Y = 300000;
    public static int Z = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1 || (substring = str.substring(length, indexOf2)) == null || substring.equals("")) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(substring);
        } catch (NumberFormatException e2) {
            a(aa, "util numberFormatException, intStr : " + substring);
            e2.printStackTrace();
            return Integer.MIN_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        Calendar calendar = Calendar.getInstance();
        return String.format("%d-%d-%d %d:%d:%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String a(u uVar, aa aaVar, Location location, String str, int i2) {
        String e2;
        String uVar2;
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 != 0) {
            stringBuffer.append("&q=");
            stringBuffer.append(i2);
        }
        if (uVar != null && (uVar2 = uVar.toString()) != null) {
            stringBuffer.append(uVar2);
        }
        if (aaVar != null) {
            String c2 = i2 == 0 ? aaVar.c() : aaVar.d();
            if (c2 != null) {
                stringBuffer.append(c2);
            }
        }
        if (location != null) {
            String a2 = (f == 0 || i2 == 0) ? m.a(location) : m.g();
            if (a2 != null) {
                stringBuffer.append(a2);
            }
        }
        String a3 = t.a(i2 == 0);
        if (a3 != null) {
            stringBuffer.append(a3);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        if (uVar != null && (e2 = uVar.e()) != null && e2.length() + stringBuffer.length() < 750) {
            stringBuffer.append(e2);
        }
        String stringBuffer2 = stringBuffer.toString();
        a(aa, "util format : " + stringBuffer2);
        return stringBuffer2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, String str3, double d2) {
        int indexOf;
        int length;
        int indexOf2;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1) {
            return null;
        }
        String str4 = str.substring(0, length) + String.format("%.7f", Double.valueOf(d2)) + str.substring(indexOf2);
        a(aa, "NEW:" + str4);
        return str4;
    }

    public static String a(byte[] bArr, String str, boolean z2) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z2) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    public static String a(byte[] bArr, boolean z2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z2);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void a(String str, String str2) {
        if (ac) {
            Log.d(str, str2);
        }
    }

    public static boolean a(String str) {
        int a2 = a(str, "error\":\"", "\"");
        return a2 > 100 && a2 < 200;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1 || (substring = str.substring(length, indexOf2)) == null || substring.equals("")) {
            return Float.MIN_VALUE;
        }
        try {
            return Float.parseFloat(substring);
        } catch (NumberFormatException e2) {
            a(aa, "util numberFormatException, intStr : " + substring);
            e2.printStackTrace();
            return Float.MIN_VALUE;
        }
    }

    public static void b() {
        if (ac || ad) {
            try {
                if (ag != null) {
                    ag.destroy();
                    ag = null;
                }
                File file = new File(f.f470a);
                if (file.exists()) {
                    a("sdkdemo_applocation", "directory already exists...");
                } else {
                    file.mkdirs();
                    a("sdkdemo_applocation", "directory not exists, make dirs...");
                }
                a(aa, "logcat start ...");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str, String str2) {
        if (ad) {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double c(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1 || (substring = str.substring(length, indexOf2)) == null || substring.equals("")) {
            return Double.MIN_VALUE;
        }
        try {
            return Double.parseDouble(substring);
        } catch (NumberFormatException e2) {
            a(aa, "util numberFormatException, doubleStr : " + substring);
            e2.printStackTrace();
            return Double.MIN_VALUE;
        }
    }

    public static void c() {
        if (ag != null) {
            try {
                a(aa, "logcat stop...");
                ag.destroy();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String d() {
        return ab;
    }
}
