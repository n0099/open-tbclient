package com.baidu.location.d;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
/* loaded from: classes2.dex */
public class j {
    public static float A = 2.2f;
    public static float B = 2.3f;
    public static float C = 3.8f;
    public static int D = 3;
    public static int E = 10;
    public static int F = 2;
    public static int G = 7;
    public static int H = 20;
    public static int I = 70;
    public static int J = 120;
    public static float K = 2.0f;
    public static float L = 10.0f;
    public static float M = 50.0f;
    public static float N = 200.0f;
    public static int O = 16;
    public static float P = 0.9f;
    public static int Q = 10000;
    public static float R = 0.5f;
    public static float S = 0.0f;
    public static float T = 0.1f;
    public static int U = 30;
    public static int V = 100;
    public static int W = 0;
    public static int X = 0;
    public static int Y = 0;
    public static int Z = 420000;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6715a = false;
    public static String aA = "http://loc.map.baidu.com/rtbu.php";
    public static String aB = "http://loc.map.baidu.com/iofd.php";
    public static String aC = "http://loc.map.baidu.com/wloc";
    public static boolean aa = true;
    public static boolean ab = true;
    public static int ac = 20;
    public static int ad = 300;
    public static int ae = 1000;
    public static int af = Integer.MAX_VALUE;
    public static long ag = 900000;
    public static long ah = 420000;
    public static long ai = 180000;
    public static long aj = 0;
    public static long ak = 15;
    public static long al = 300000;
    public static int am = 1000;
    public static int an = 0;
    public static int ao = 30000;
    public static int ap = 30000;
    public static float aq = 10.0f;
    public static float ar = 6.0f;
    public static float as = 10.0f;
    public static int at = 60;
    public static int au = 70;
    public static int av = 6;
    public static String aw = "http://loc.map.baidu.com/sdk.php";
    public static String ax = "http://loc.map.baidu.com/user_err.php";
    public static String ay = "http://loc.map.baidu.com/oqur.php";
    public static String az = "http://loc.map.baidu.com/tcu.php";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f6716b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f6717c = false;

    /* renamed from: d  reason: collision with root package name */
    public static int f6718d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f6719e = "http://loc.map.baidu.com/sdk_ep.php";

    /* renamed from: f  reason: collision with root package name */
    public static String f6720f = "https://loc.map.baidu.com/sdk.php";

    /* renamed from: g  reason: collision with root package name */
    public static String f6721g = "no";

    /* renamed from: h  reason: collision with root package name */
    public static boolean f6722h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static String n = "gcj02";
    public static String o = "";
    public static boolean p = true;
    public static int q = 3;
    public static double r = 0.0d;
    public static double s = 0.0d;
    public static double t = 0.0d;
    public static double u = 0.0d;
    public static int v = 0;
    public static byte[] w = null;
    public static boolean x = false;
    public static int y = 0;
    public static float z = 1.1f;

    public static int a(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Exception unused) {
            return 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, String str) {
        boolean z2;
        if (context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
            z2 = false;
            return z2 ? 0 : 1;
        }
        z2 = true;
        if (z2) {
        }
    }

    public static int a(String str, String str2, String str3) {
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        if (str != null && !str.equals("") && (indexOf = str.indexOf(str2)) != -1 && (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) != -1 && (substring = str.substring(length, indexOf2)) != null && !substring.equals("")) {
            try {
                return Integer.parseInt(substring);
            } catch (NumberFormatException unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i2), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String a(com.baidu.location.b.a aVar, com.baidu.location.b.h hVar, Location location, String str, int i2) {
        return a(aVar, hVar, location, str, i2, false);
    }

    public static String a(com.baidu.location.b.a aVar, com.baidu.location.b.h hVar, Location location, String str, int i2, boolean z2) {
        String a2;
        String b2;
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (aVar != null && (b2 = com.baidu.location.b.b.a().b(aVar)) != null) {
            stringBuffer.append(b2);
        }
        if (hVar != null) {
            String b3 = i2 == 0 ? z2 ? hVar.b() : hVar.c() : hVar.d();
            if (b3 != null) {
                stringBuffer.append(b3);
            }
        }
        if (location != null) {
            String b4 = (f6718d == 0 || i2 == 0) ? com.baidu.location.b.e.b(location) : com.baidu.location.b.e.c(location);
            if (b4 != null) {
                stringBuffer.append(b4);
            }
        }
        String a3 = b.a().a(i2 == 0);
        if (a3 != null) {
            stringBuffer.append(a3);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        if (aVar != null && (a2 = com.baidu.location.b.b.a().a(aVar)) != null && a2.length() + stringBuffer.length() < 750) {
            stringBuffer.append(a2);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (location != null && hVar != null) {
            try {
                float speed = location.getSpeed();
                int i3 = f6718d;
                int g2 = hVar.g();
                int a4 = hVar.a();
                boolean h2 = hVar.h();
                if (speed < ar && ((i3 == 1 || i3 == 0) && (g2 < at || h2))) {
                    q = 1;
                } else if (speed < as && ((i3 == 1 || i3 == 0 || i3 == 3) && (g2 < au || a4 > av))) {
                    q = 2;
                }
            } catch (Exception unused) {
                q = 3;
            }
            return stringBuffer2;
        }
        q = 3;
        return stringBuffer2;
    }

    public static String a(File file, String str) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    fileInputStream.close();
                    return new BigInteger(1, messageDigest.digest()).toString(16);
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        return Jni.en1(o + ";" + str);
    }

    public static boolean a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    public static int b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -2;
    }

    public static String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        byte[] address = nextElement.getAddress();
                        String str = "";
                        for (byte b2 : address) {
                            String hexString = Integer.toHexString(b2 & 255);
                            if (hexString.length() == 1) {
                                hexString = '0' + hexString;
                            }
                            str = str + hexString;
                        }
                        return str;
                    }
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.baidu.android.bbalbs.common.a.b.a(str3.getBytes())));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(generatePublic);
            signature.update(str.getBytes());
            return signature.verify(com.baidu.android.bbalbs.common.a.b.a(str2.getBytes()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String c() {
        return aw;
    }

    public static String c(Context context) {
        int a2 = a(context, "android.permission.ACCESS_COARSE_LOCATION");
        int a3 = a(context, "android.permission.ACCESS_FINE_LOCATION");
        int a4 = a(context, "android.permission.READ_PHONE_STATE");
        return "&per=" + a2 + FieldBuilder.SE + a3 + FieldBuilder.SE + a4;
    }

    public static String d() {
        return az;
    }

    public static String d(Context context) {
        int i2 = -1;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    i2 = activeNetworkInfo.getType();
                }
            } catch (Exception unused) {
            }
        }
        return "&netc=" + i2;
    }

    public static String e() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }

    public static String f() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                String path = Environment.getExternalStorageDirectory().getPath();
                File file = new File(path + "/baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return path;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String g() {
        String f2 = f();
        if (f2 == null) {
            return null;
        }
        return f2 + "/baidu/tempdata";
    }

    public static String h() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String i() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath();
        } catch (Exception unused) {
            return null;
        }
    }
}
