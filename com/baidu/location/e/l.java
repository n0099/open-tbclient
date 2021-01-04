package com.baidu.location.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.util.Base64;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.fun.ad.sdk.FunAdConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
/* loaded from: classes15.dex */
public class l {
    public static double[] aI;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2733a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2734b = false;
    public static boolean c = false;
    public static int d = 0;
    private static String aM = "http://loc.map.baidu.com/sdk.php";
    public static String e = "https://loc.map.baidu.com/sdk_ep.php";
    private static String aN = "http://loc.map.baidu.com/user_err.php";
    private static String aO = "http://loc.map.baidu.com/oqur.php";
    private static String aP = "https://loc.map.baidu.com/tcu.php";
    private static String aQ = "http://loc.map.baidu.com/rtbu.php";
    private static String aR = "http://loc.map.baidu.com/iofd.php";
    private static String aS = "http://loc.map.baidu.com/wloc";
    public static String f = "https://loc.map.baidu.com/sdk.php";
    public static String g = "no";
    public static boolean h = false;
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
    public static int P = 32;
    public static float Q = 0.9f;
    public static int R = 10000;
    public static float S = 0.5f;
    public static float T = 0.0f;
    public static float U = 0.1f;
    public static int V = 30;
    public static int W = 100;
    public static int X = 0;
    public static int Y = 0;
    public static int Z = 0;
    public static int aa = 420000;
    public static boolean ab = true;
    public static boolean ac = true;
    public static int ad = 20;
    public static int ae = 300;
    public static int af = 1000;
    public static int ag = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public static long ah = FunAdConfig.Builder.AD_EXPIRED_INTERVAL;
    public static long ai = 420000;
    public static long aj = 180000;
    public static long ak = 0;
    public static long al = 15;
    public static long am = 300000;
    public static int an = 1000;
    public static int ao = 0;
    public static int ap = 30000;
    public static int aq = 30000;
    public static float ar = 10.0f;
    public static float as = 6.0f;
    public static float at = 10.0f;
    public static int au = 60;
    public static int av = 70;
    public static int aw = 6;
    public static String ax = null;
    public static boolean ay = false;
    public static int az = 16;
    public static float aA = 0.75f;
    public static double aB = -0.10000000149011612d;
    public static int aC = 0;
    public static boolean aD = false;
    public static int aE = -1;
    public static int aF = 10;
    public static int aG = 3;
    public static int aH = 40;
    public static int aJ = 1;
    public static int aK = 1;
    public static int aL = 1;

    public static double a(double d2, double d3, double d4, double d5) {
        float[] fArr = new float[1];
        Location.distanceBetween(d2, d3, d4, d5, fArr);
        return fArr[0];
    }

    public static int a(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Exception e2) {
            return 2;
        }
    }

    public static int a(Context context, String str) {
        boolean z2;
        try {
            z2 = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Exception e2) {
            z2 = true;
        }
        return !z2 ? 0 : 1;
    }

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
            return Integer.MIN_VALUE;
        }
    }

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i2), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String a(com.baidu.location.c.a aVar, com.baidu.location.c.h hVar, Location location, String str, int i2) {
        return a(aVar, hVar, location, str, i2, false);
    }

    public static String a(com.baidu.location.c.a aVar, com.baidu.location.c.h hVar, Location location, String str, int i2, boolean z2) {
        String b2;
        StringBuffer stringBuffer = new StringBuffer(2048);
        if (aVar != null && (b2 = com.baidu.location.c.b.a().b(aVar)) != null) {
            stringBuffer.append(b2);
        }
        if (hVar != null) {
            String b3 = i2 == 0 ? z2 ? hVar.b() : hVar.c() : hVar.d();
            if (b3 != null) {
                stringBuffer.append(b3);
            }
        }
        if (location != null) {
            String b4 = (d == 0 || i2 == 0) ? com.baidu.location.c.f.b(location) : com.baidu.location.c.f.c(location);
            if (b4 != null) {
                stringBuffer.append(b4);
            }
        }
        String a2 = b.a().a(i2 == 0);
        if (a2 != null) {
            stringBuffer.append(a2);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(com.baidu.location.c.f.a().m());
        String a3 = com.baidu.location.c.b.a().a(aVar);
        if (a3 != null && a3.length() + stringBuffer.length() < 2000) {
            stringBuffer.append(a3);
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            if (location == null || hVar == null) {
                q = 3;
            } else {
                float speed = location.getSpeed();
                int i3 = d;
                int h2 = hVar.h();
                int a4 = hVar.a();
                boolean i4 = hVar.i();
                if (speed < as && ((i3 == 1 || i3 == 0) && (h2 < au || i4))) {
                    q = 1;
                } else if (speed >= at || (!(i3 == 1 || i3 == 0 || i3 == 3) || (h2 >= av && a4 <= aw))) {
                    q = 3;
                } else {
                    q = 2;
                }
            }
        } catch (Exception e2) {
            q = 3;
        }
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
        return Jni.en1(o + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + str);
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
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z2);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    public static int b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
            } catch (Exception e2) {
                return -1;
            }
        }
        return -2;
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader3.readLine();
                bufferedReader3.close();
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                        return readLine;
                    } catch (IOException e2) {
                        return readLine;
                    }
                }
                return readLine;
            } catch (IOException e3) {
                bufferedReader = bufferedReader3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean b() {
        return false;
    }

    public static boolean b(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean b(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str3.getBytes(), 0)));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(generatePublic);
            signature.update(str.getBytes());
            return signature.verify(Base64.decode(str2.getBytes(), 0));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        byte[] address = nextElement.getAddress();
                        String str = "";
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= address.length) {
                                return str;
                            }
                            String hexString = Integer.toHexString(address[i3] & 255);
                            if (hexString.length() == 1) {
                                hexString = '0' + hexString;
                            }
                            str = str + hexString;
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
        return null;
    }

    public static boolean c(Context context) {
        int i2;
        if (context != null) {
            try {
                i2 = context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
            } catch (Exception e2) {
                e2.printStackTrace();
                i2 = 0;
            }
            boolean z2 = i2 == 0;
            if (!z2 || Build.VERSION.SDK_INT < 23) {
                return z2;
            }
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "location_mode", 1) != 0 ? z2 : false;
            } catch (Exception e3) {
                return z2;
            }
        }
        return true;
    }

    public static String d() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet6Address) && nextElement.getHostAddress() != null && !nextElement.getHostAddress().startsWith("fe80:")) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (SocketException e2) {
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    public static String d(Context context) {
        int a2 = a(context, "android.permission.ACCESS_COARSE_LOCATION");
        int a3 = a(context, "android.permission.ACCESS_FINE_LOCATION");
        return "&per=" + a2 + "|" + a3 + "|" + a(context, "android.permission.READ_PHONE_STATE");
    }

    public static String e() {
        return aM;
    }

    public static String e(Context context) {
        NetworkInfo activeNetworkInfo;
        int type;
        int i2 = -1;
        if (context != null) {
            try {
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Throwable th) {
            }
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                type = activeNetworkInfo.getType();
                i2 = type;
                return "&netc=" + i2;
            }
        }
        type = -1;
        i2 = type;
        return "&netc=" + i2;
    }

    public static String f() {
        return aP;
    }

    public static String g() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h() {
        String path;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (Environment.getExternalStorageState().equals("mounted")) {
                path = Environment.getExternalStorageDirectory().getPath();
                if (path == null && Build.VERSION.SDK_INT > 28 && com.baidu.location.f.getServiceContext() != null) {
                    try {
                        path = com.baidu.location.f.getServiceContext().getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath();
                    } catch (Exception e3) {
                        path = null;
                    }
                }
                if (path != null) {
                    try {
                        File file = new File(path + "/baidu/tempdata");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return null;
                    }
                }
                return path;
            }
        }
        path = null;
        if (path == null) {
            path = com.baidu.location.f.getServiceContext().getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath();
        }
        if (path != null) {
        }
        return path;
    }

    public static String i() {
        String h2 = h();
        if (h2 == null) {
            return null;
        }
        return h2 + "/baidu/tempdata";
    }

    public static String j() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception e2) {
            return null;
        }
    }

    public static String k() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath();
        } catch (Exception e2) {
            return null;
        }
    }

    public static String l() {
        try {
            File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            return com.baidu.location.f.getServiceContext().getFilesDir().getPath() + File.separator + "/baidu/tempdata";
        } catch (Exception e2) {
            return null;
        }
    }

    public static String m() {
        return b("ro.mediatek.platform");
    }
}
