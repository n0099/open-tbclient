package com.baidu.location.g;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.tieba.model.ReportUserInfoModel;
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
/* loaded from: classes3.dex */
public class g {
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static int d = 0;
    private static String aw = "http://loc.map.baidu.com/sdk.php";
    public static String e = "http://loc.map.baidu.com/sdk_ep.php";
    private static String ax = "http://loc.map.baidu.com/user_err.php";
    private static String ay = "http://loc.map.baidu.com/oqur.php";
    private static String az = "http://loc.map.baidu.com/tcu.php";
    private static String aA = "http://loc.map.baidu.com/rtbu.php";
    private static String aB = "http://loc.map.baidu.com/iofd.php";
    private static String aC = "http://loc.map.baidu.com/wloc";
    public static String f = "https://loc.map.baidu.com/sdk.php";
    public static String g = "no";
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static String n = CoordinateType.GCJ02;
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
    public static boolean aa = true;
    public static boolean ab = true;
    public static int ac = 20;
    public static int ad = 300;
    public static int ae = 1000;
    public static int af = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public static long ag = 900000;
    public static long ah = 420000;
    public static long ai = 180000;
    public static long aj = 0;
    public static long ak = 15;
    public static long al = ReportUserInfoModel.TIME_INTERVAL;
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

    public static String a(com.baidu.location.e.a aVar, com.baidu.location.e.e eVar, Location location, String str, int i2) {
        return a(aVar, eVar, location, str, i2, false);
    }

    public static String a(com.baidu.location.e.a aVar, com.baidu.location.e.e eVar, Location location, String str, int i2, boolean z2) {
        String a2;
        String b2;
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (aVar != null && (b2 = com.baidu.location.e.b.a().b(aVar)) != null) {
            stringBuffer.append(b2);
        }
        if (eVar != null) {
            String b3 = i2 == 0 ? z2 ? eVar.b() : eVar.c() : eVar.d();
            if (b3 != null) {
                stringBuffer.append(b3);
            }
        }
        if (location != null) {
            String b4 = (d == 0 || i2 == 0) ? com.baidu.location.e.d.b(location) : com.baidu.location.e.d.c(location);
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
        String d2 = com.baidu.location.b.c.a().d();
        if (!TextUtils.isEmpty(d2)) {
            stringBuffer.append("&bc=").append(d2);
        }
        if (aVar != null && (a2 = com.baidu.location.e.b.a().a(aVar)) != null && a2.length() + stringBuffer.length() < 750) {
            stringBuffer.append(a2);
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            if (location == null || eVar == null) {
                q = 3;
            } else {
                float speed = location.getSpeed();
                int i3 = d;
                int h2 = eVar.h();
                int a4 = eVar.a();
                boolean i4 = eVar.i();
                if (speed < ar && ((i3 == 1 || i3 == 0) && (h2 < at || i4))) {
                    q = 1;
                } else if (speed >= as || (!(i3 == 1 || i3 == 0 || i3 == 3) || (h2 >= au && a4 <= av))) {
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

    public static boolean a(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return (locType > 100 && locType < 200) || locType == 62;
    }

    public static int b(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Exception e2) {
            return 2;
        }
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

    public static boolean b(String str, String str2, String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str3.getBytes())));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(generatePublic);
            signature.update(str.getBytes());
            return signature.verify(Base64.decode(str2.getBytes()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int c(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
            } catch (Exception e2) {
                return -1;
            }
        }
        return -2;
    }

    public static String c() {
        return aw;
    }

    public static String d() {
        return az;
    }

    public static String d(Context context) {
        int a2 = a(context, "android.permission.ACCESS_COARSE_LOCATION");
        int a3 = a(context, "android.permission.ACCESS_FINE_LOCATION");
        return "&per=" + a2 + "|" + a3 + "|" + a(context, "android.permission.READ_PHONE_STATE");
    }

    public static String e() {
        return "https://daup.map.baidu.com/cltr/rcvr";
    }

    public static String e(Context context) {
        NetworkInfo activeNetworkInfo;
        int type;
        int i2 = -1;
        if (context != null) {
            try {
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception e2) {
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
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                String path = Environment.getExternalStorageDirectory().getPath();
                File file = new File(path + "/baidu/tempdata");
                if (file.exists()) {
                    return path;
                }
                file.mkdirs();
                return path;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
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
        } catch (Exception e2) {
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
        } catch (Exception e2) {
            return null;
        }
    }
}
