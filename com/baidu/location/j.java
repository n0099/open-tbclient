package com.baidu.location;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.provider.Settings;
import android.support.v4.widget.ExploreByTouchHelper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.c;
import com.baidu.location.e;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j {

    /* renamed from: try  reason: not valid java name */
    public static boolean f205try = false;
    public static boolean v = false;
    public static boolean I = false;
    public static boolean b = false;

    /* renamed from: else  reason: not valid java name */
    public static boolean f198else = false;

    /* renamed from: void  reason: not valid java name */
    public static int f206void = 0;

    /* renamed from: for  reason: not valid java name */
    private static String f199for = f.v;
    private static String x = "http://loc.map.baidu.com/sdk.php";

    /* renamed from: do  reason: not valid java name */
    public static String f197do = "http://loc.map.baidu.com/sdk_ep.php";
    private static boolean r = false;
    private static boolean n = false;
    private static boolean p = true;
    private static String w = "[baidu_location_service]";
    private static Process y = null;
    public static String f = null;
    public static String j = "no";
    public static String R = "gcj02";
    public static boolean J = true;
    public static boolean M = true;
    public static double O = 0.0d;
    public static double c = 0.0d;
    public static double s = 0.0d;

    /* renamed from: byte  reason: not valid java name */
    public static double f194byte = 0.0d;

    /* renamed from: long  reason: not valid java name */
    public static int f203long = 0;
    public static byte[] o = null;
    public static boolean e = false;

    /* renamed from: goto  reason: not valid java name */
    public static int f200goto = 0;

    /* renamed from: case  reason: not valid java name */
    public static float f195case = 1.1f;
    public static float A = 2.2f;

    /* renamed from: char  reason: not valid java name */
    public static float f196char = 2.3f;
    public static float C = 3.8f;
    public static int t = 3;
    public static int a = 10;
    public static int u = 2;

    /* renamed from: if  reason: not valid java name */
    public static int f201if = 7;

    /* renamed from: int  reason: not valid java name */
    public static int f202int = 20;
    public static int k = 70;
    public static int K = 120;
    public static float T = 2.0f;
    public static float Q = 10.0f;
    public static float d = 50.0f;
    public static float H = 200.0f;
    public static int F = 16;

    /* renamed from: new  reason: not valid java name */
    public static float f204new = 0.9f;
    public static int h = 5000;
    public static float D = 0.5f;
    public static float S = 0.0f;
    public static float P = 0.1f;
    public static int N = 30;
    public static int L = 100;
    public static boolean m = true;
    public static boolean G = true;
    public static int i = 20;
    public static int g = 300;
    public static int l = 1000;
    public static long z = 1200000;
    public static long B = 20;
    public static long q = 300000;
    public static int E = 0;

    /* loaded from: classes.dex */
    public class a {
        private static final boolean a = false;

        /* renamed from: if  reason: not valid java name */
        private static final String f207if = a.class.getSimpleName();

        private static String a(Context context) {
            return b.a(context);
        }

        /* renamed from: if  reason: not valid java name */
        public static String m247if(Context context) {
            String a2 = a(context);
            String m248do = b.m248do(context);
            if (TextUtils.isEmpty(m248do)) {
                m248do = "0";
            }
            return a2 + "|" + new StringBuffer(m248do).reverse().toString();
        }
    }

    /* loaded from: classes.dex */
    public class b {
        private static final String a = "a";

        /* renamed from: do  reason: not valid java name */
        private static final String f208do = "bids";

        /* renamed from: for  reason: not valid java name */
        private static final String f209for = "i";

        /* renamed from: if  reason: not valid java name */
        private static final String f210if = "DeviceId";

        private b() {
        }

        public static String a(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f208do, 0);
            String string = sharedPreferences.getString(f209for, null);
            if (string == null) {
                string = m248do(context);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(f209for, string);
                edit.commit();
            }
            String string2 = sharedPreferences.getString(a, null);
            if (string2 == null) {
                string2 = m249if(context);
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString(a, string2);
                edit2.commit();
            }
            String a2 = j.a(("com.baidu" + string + string2).getBytes(), true);
            String string3 = Settings.System.getString(context.getContentResolver(), a2);
            if (TextUtils.isEmpty(string3)) {
                String a3 = j.a((string + string2 + UUID.randomUUID().toString()).getBytes(), true);
                Settings.System.putString(context.getContentResolver(), a2, a3);
                return !a3.equals(Settings.System.getString(context.getContentResolver(), a2)) ? a2 : a3;
            }
            return string3;
        }

        /* renamed from: do  reason: not valid java name */
        public static String m248do(Context context) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String deviceId = telephonyManager.getDeviceId();
                return TextUtils.isEmpty(deviceId) ? "" : deviceId;
            }
            return "";
        }

        /* renamed from: if  reason: not valid java name */
        public static String m249if(Context context) {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return TextUtils.isEmpty(string) ? "" : string;
        }
    }

    j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(String str, String str2, String str3) {
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
            a(f199for, "util numberFormatException, intStr : " + substring);
            e2.printStackTrace();
            return Float.MIN_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        Calendar calendar = Calendar.getInstance();
        return String.format("%d-%d-%d %d:%d:%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String a(c.a aVar, e.c cVar, Location location, String str, int i2) {
        String m120int;
        String aVar2;
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 != 0) {
            stringBuffer.append("&q=");
            stringBuffer.append(i2);
        }
        if (aVar != null && (aVar2 = aVar.toString()) != null) {
            stringBuffer.append(aVar2);
        }
        if (cVar != null) {
            String m136byte = i2 == 0 ? cVar.m136byte() : cVar.m146try();
            if (m136byte != null) {
                stringBuffer.append(m136byte);
            }
        }
        if (location != null) {
            String m69if = (f206void == 0 || i2 == 0) ? com.baidu.location.b.m69if(location) : com.baidu.location.b.k();
            if (m69if != null) {
                stringBuffer.append(m69if);
            }
        }
        String a2 = c.a(i2 == 0);
        if (a2 != null) {
            stringBuffer.append(a2);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        if (aVar != null && (m120int = aVar.m120int()) != null && m120int.length() + stringBuffer.length() < 750) {
            stringBuffer.append(m120int);
        }
        String stringBuffer2 = stringBuffer.toString();
        a(f199for, "util format : " + stringBuffer2);
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
        a(f199for, "NEW:" + str4);
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
        if (r) {
            Log.d(str, str2);
        }
    }

    public static boolean a(String str) {
        int m242if = m242if(str, "error\":\"", "\"");
        return m242if > 100 && m242if < 200;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: do  reason: not valid java name */
    public static double m238do(String str, String str2, String str3) {
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
            a(f199for, "util numberFormatException, doubleStr : " + substring);
            e2.printStackTrace();
            return Double.MIN_VALUE;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static String m239do() {
        return x;
    }

    /* renamed from: do  reason: not valid java name */
    public static void m240do(String str) {
        if ((r || n) && str != null) {
            x = str;
        }
    }

    /* renamed from: for  reason: not valid java name */
    public static void m241for() {
        if (r || n) {
            try {
                if (y != null) {
                    y.destroy();
                    y = null;
                }
                File file = new File(f.aa);
                if (file.exists()) {
                    a("sdkdemo_applocation", "directory already exists...");
                } else {
                    file.mkdirs();
                    a("sdkdemo_applocation", "directory not exists, make dirs...");
                }
                a(f199for, "logcat start ...");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: if  reason: not valid java name */
    public static int m242if(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str == null || str.equals("") || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) == -1 || (substring = str.substring(length, indexOf2)) == null || substring.equals("")) {
            return ExploreByTouchHelper.INVALID_ID;
        }
        try {
            return Integer.parseInt(substring);
        } catch (NumberFormatException e2) {
            a(f199for, "util numberFormatException, intStr : " + substring);
            e2.printStackTrace();
            return ExploreByTouchHelper.INVALID_ID;
        }
    }

    /* renamed from: if  reason: not valid java name */
    static String m243if() {
        Calendar calendar = Calendar.getInstance();
        return String.format("%d_%d_%d_%d_%d_%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    /* renamed from: if  reason: not valid java name */
    public static void m244if(String str) {
        if (p) {
            Log.d(w, str);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static void m245if(String str, String str2) {
        if (n) {
            Log.d(str, str2);
        }
    }

    /* renamed from: int  reason: not valid java name */
    public static void m246int() {
        if (y != null) {
            try {
                a(f199for, "logcat stop...");
                y.destroy();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
