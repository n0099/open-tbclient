package com.baidu.location.h;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
/* loaded from: classes.dex */
public class i {
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static int d = 0;
    private static String as = "http://loc.map.baidu.com/sdk.php";
    public static String e = "http://loc.map.baidu.com/sdk_ep.php";
    private static String at = "http://loc.map.baidu.com/user_err.php";
    private static String au = "http://loc.map.baidu.com/oqur.php";
    private static String av = "http://loc.map.baidu.com/tcu.php";
    private static String aw = "http://loc.map.baidu.com/rtbu.php";
    private static String ax = "http://loc.map.baidu.com/iofd.php";
    private static String ay = "https://sapi.skyhookwireless.com/wps2/location";
    private static String az = "http://loc.map.baidu.com/wloc";
    public static String f = "no";
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static String l = "gcj02";
    public static boolean m = true;
    public static int n = 3;
    public static double Nv = 0.0d;
    public static double Nw = 0.0d;
    public static double Nx = 0.0d;
    public static double Ny = 0.0d;
    public static int s = 0;
    public static byte[] t = null;
    public static boolean u = false;
    public static int v = 0;
    public static float w = 1.1f;
    public static float x = 2.2f;
    public static float y = 2.3f;
    public static float z = 3.8f;
    public static int A = 3;
    public static int B = 10;
    public static int C = 2;
    public static int D = 7;
    public static int E = 20;
    public static int F = 70;
    public static int G = 120;
    public static float H = 2.0f;
    public static float I = 10.0f;
    public static float J = 50.0f;
    public static float K = 200.0f;
    public static int L = 16;
    public static float Qo = 0.9f;
    public static int N = 10000;
    public static float Qp = 0.5f;
    public static float Qq = 0.0f;
    public static float Qr = 0.1f;
    public static int R = 30;
    public static int S = 100;
    public static int T = 0;
    public static int U = 0;
    public static int V = 0;
    public static int W = 420000;
    public static boolean X = true;
    public static boolean Qs = true;
    public static int Z = 20;
    public static int Qt = 300;
    public static int Qu = 1000;
    public static long ac = 900000;
    public static long ad = 420000;
    public static long ae = 180000;
    public static long Qv = 0;
    public static long Qw = 15;
    public static long Qx = ReportUserInfoModel.TIME_INTERVAL;
    public static int ai = 1000;
    public static int aj = 0;
    public static int ak = 30000;
    public static int al = 30000;
    public static float am = 10.0f;
    public static float Qy = 6.0f;
    public static float Qz = 10.0f;
    public static int ap = 60;
    public static int aq = 70;
    public static int ar = 6;

    public static Object O(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(5);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(i2), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
    }

    public static String a(com.baidu.location.f.a aVar, com.baidu.location.f.i iVar, Location location, String str, int i2) {
        String f2;
        String g2;
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (aVar != null && (g2 = com.baidu.location.f.b.nA().g(aVar)) != null) {
            stringBuffer.append(g2);
        }
        if (iVar != null) {
            String b2 = i2 == 0 ? iVar.b() : iVar.c();
            if (b2 != null) {
                stringBuffer.append(b2);
            }
        }
        if (location != null) {
            String h2 = (d == 0 || i2 == 0) ? com.baidu.location.f.e.h(location) : com.baidu.location.f.e.i(location);
            if (h2 != null) {
                stringBuffer.append(h2);
            }
        }
        String a2 = c.nP().a(i2 == 0);
        if (a2 != null) {
            stringBuffer.append(a2);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        String d2 = com.baidu.location.c.b.ne().d();
        if (!TextUtils.isEmpty(d2)) {
            stringBuffer.append("&bc=").append(d2);
        }
        if (i2 == 0) {
        }
        if (aVar != null && (f2 = com.baidu.location.f.c.nF().f(aVar)) != null && f2.length() + stringBuffer.length() < 750) {
            stringBuffer.append(f2);
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            if (location == null || iVar == null) {
                n = 3;
            } else {
                float speed = location.getSpeed();
                int i3 = d;
                int d3 = iVar.d();
                int a3 = iVar.a();
                boolean e2 = iVar.e();
                if (speed < Qy && ((i3 == 1 || i3 == 0) && (d3 < ap || e2))) {
                    n = 1;
                } else if (speed >= Qz || (!(i3 == 1 || i3 == 0 || i3 == 3) || (d3 >= aq && a3 <= ar))) {
                    n = 3;
                } else {
                    n = 2;
                }
            }
        } catch (Exception e3) {
            n = 3;
        }
        return stringBuffer2;
    }

    public static String a(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
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

    public static boolean a(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
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
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            String str2 = str;
                            if (i3 >= address.length) {
                                return str2;
                            }
                            String hexString = Integer.toHexString(address[i3] & 255);
                            if (hexString.length() == 1) {
                                hexString = '0' + hexString;
                            }
                            str = str2 + hexString;
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
        return null;
    }

    public static Object c(Object obj, String str, Object... objArr) throws Exception {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            clsArr[i2] = objArr[i2].getClass();
            if (clsArr[i2] == Integer.class) {
                clsArr[i2] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(obj, objArr);
    }

    public static String c() {
        return as;
    }

    public static int d(Object obj, String str, Object... objArr) throws Exception {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            clsArr[i2] = objArr[i2].getClass();
            if (clsArr[i2] == Integer.class) {
                clsArr[i2] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, objArr)).intValue();
    }

    public static String d() {
        return av;
    }

    public static boolean d(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return locType > 100 && locType < 200;
    }

    public static String e() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                String path = Environment.getExternalStorageDirectory().getPath();
                File file = new File(path + "/baidu/tempdata");
                if (file.exists()) {
                    return path;
                }
                file.mkdirs();
                return path;
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    public static String f() {
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        return e2 + "/baidu/tempdata";
    }

    public static String g() {
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

    public static int h(String str, String str2, String str3) {
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
            return ExploreByTouchHelper.INVALID_ID;
        }
    }
}
