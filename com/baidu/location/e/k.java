package com.baidu.location.e;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
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
/* loaded from: classes5.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;
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

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41074a = false;
    public static String aA = "http://loc.map.baidu.com/oqur.php";
    public static String aB = "http://loc.map.baidu.com/tcu.php";
    public static String aC = "http://loc.map.baidu.com/rtbu.php";
    public static String aD = "http://loc.map.baidu.com/iofd.php";
    public static String aE = "http://loc.map.baidu.com/wloc";
    public static int aa = 420000;
    public static boolean ab = true;
    public static boolean ac = true;
    public static int ad = 20;
    public static int ae = 300;
    public static int af = 1000;
    public static int ag = Integer.MAX_VALUE;
    public static long ah = 900000;
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
    public static String ay = "http://loc.map.baidu.com/sdk.php";
    public static String az = "http://loc.map.baidu.com/user_err.php";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f41075b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f41076c = false;

    /* renamed from: d  reason: collision with root package name */
    public static int f41077d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f41078e = "http://loc.map.baidu.com/sdk_ep.php";

    /* renamed from: f  reason: collision with root package name */
    public static String f41079f = "https://loc.map.baidu.com/sdk.php";

    /* renamed from: g  reason: collision with root package name */
    public static String f41080g = "no";

    /* renamed from: h  reason: collision with root package name */
    public static boolean f41081h = false;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f41082i = false;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f41083j = false;
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
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037812966, "Lcom/baidu/location/e/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037812966, "Lcom/baidu/location/e/k;");
        }
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
            } catch (Exception unused) {
                return 2;
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, null, context, str)) != null) {
            return invokeLL.intValue;
        }
        if (context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
            z2 = false;
            return z2 ? 0 : 1;
        }
        z2 = true;
        if (z2) {
        }
    }

    public static int a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (str != null && !str.equals("") && (indexOf = str.indexOf(str2)) != -1 && (indexOf2 = str.indexOf(str3, (length = indexOf + str2.length()))) != -1 && (substring = str.substring(length, indexOf2)) != null && !substring.equals("")) {
                try {
                    return Integer.parseInt(substring);
                } catch (NumberFormatException unused) {
                }
            }
            return Integer.MIN_VALUE;
        }
        return invokeLLL.intValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
        }
        return (String) invokeV.objValue;
    }

    public static String a(com.baidu.location.c.a aVar, com.baidu.location.c.h hVar, Location location, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{aVar, hVar, location, str, Integer.valueOf(i2)})) == null) ? a(aVar, hVar, location, str, i2, false) : (String) invokeCommon.objValue;
    }

    public static String a(com.baidu.location.c.a aVar, com.baidu.location.c.h hVar, Location location, String str, int i2, boolean z2) {
        InterceptResult invokeCommon;
        String a2;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{aVar, hVar, location, str, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            StringBuffer stringBuffer = new StringBuffer(1024);
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
                String b4 = (f41077d == 0 || i2 == 0) ? com.baidu.location.c.e.b(location) : com.baidu.location.c.e.c(location);
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
            if (aVar != null && (a2 = com.baidu.location.c.b.a().a(aVar)) != null && a2.length() + stringBuffer.length() < 750) {
                stringBuffer.append(a2);
            }
            String stringBuffer2 = stringBuffer.toString();
            if (location != null && hVar != null) {
                try {
                    float speed = location.getSpeed();
                    int i3 = f41077d;
                    int h2 = hVar.h();
                    int a4 = hVar.a();
                    boolean i4 = hVar.i();
                    if (speed < as && ((i3 == 1 || i3 == 0) && (h2 < au || i4))) {
                        q = 1;
                    } else if (speed < at && ((i3 == 1 || i3 == 0 || i3 == 3) && (h2 < av || a4 > aw))) {
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
        return (String) invokeCommon.objValue;
    }

    public static String a(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65543, null, file, str)) != null) {
            return (String) invokeLL.objValue;
        }
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return Jni.en1(o + ";" + str);
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(BDLocation bDLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bDLocation)) == null) {
            int locType = bDLocation.getLocType();
            return (locType > 100 && locType < 200) || locType == 62;
        }
        return invokeL.booleanValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return Settings.Secure.getInt(context.getContentResolver(), "location_mode", -1);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -2;
        }
        return invokeL.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, str, str2, str3)) == null) {
            try {
                PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str3.getBytes(), 0)));
                Signature signature = Signature.getInstance("SHA1WithRSA");
                signature.initVerify(generatePublic);
                signature.update(str.getBytes());
                return signature.verify(Base64.decode(str2.getBytes(), 0));
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            int a2 = a(context, "android.permission.ACCESS_COARSE_LOCATION");
            int a3 = a(context, "android.permission.ACCESS_FINE_LOCATION");
            int a4 = a(context, "android.permission.READ_PHONE_STATE");
            return "&per=" + a2 + "|" + a3 + "|" + a4;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'SocketException', keep only Throwable */
    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
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
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? ay : (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? aB : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? "https://daup.map.baidu.com/cltr/rcvr" : (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            String h2 = h();
            if (h2 == null) {
                return null;
            }
            return h2 + "/baidu/tempdata";
        }
        return (String) invokeV.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
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
        return (String) invokeV.objValue;
    }
}
