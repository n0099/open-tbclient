package com.baidu.location.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
/* loaded from: classes3.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;
    public static float A = 2.3f;
    public static float B = 3.8f;
    public static int C = 3;
    public static int D = 10;
    public static int E = 2;
    public static int F = 7;
    public static int G = 20;
    public static int H = 70;
    public static int I = 120;
    public static float J = 2.0f;
    public static float K = 10.0f;
    public static float L = 50.0f;
    public static float M = 200.0f;
    public static int N = 16;
    public static int O = 32;
    public static float P = 0.9f;
    public static int Q = 10000;
    public static float R = 0.5f;
    public static float S = 0.0f;

    /* renamed from: T  reason: collision with root package name */
    public static float f1047T = 0.1f;
    public static int U = 30;
    public static int V = 100;
    public static int W = 0;
    public static int X = 0;
    public static int Y = 0;
    public static int Z = 420000;
    public static boolean a = false;
    public static double aA = -0.10000000149011612d;
    public static int aB = 0;
    public static int aC = 0;
    public static int aD = 1;
    public static boolean aE = false;
    public static int aF = -1;
    public static int aG = 10;
    public static int aH = 3;
    public static int aI = 40;
    public static double[] aJ = null;
    public static int aK = 1;
    public static int aL = 1;
    public static int aM = 1;
    public static boolean aN = false;
    public static String aO = null;
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
    public static String aw = null;
    public static boolean ax = false;
    public static int ay = 16;
    public static float az = 0.75f;
    public static boolean b = false;
    public static boolean c = false;
    public static int d = 0;
    public static String e = "no";
    public static int f = 4;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static String m = "gcj02";
    public static String n = "";
    public static boolean o = true;
    public static int p = 3;
    public static double q = 0.0d;
    public static double r = 0.0d;
    public static double s = 0.0d;
    public static double t = 0.0d;
    public static int u = 0;
    public static byte[] v = null;
    public static boolean w = false;
    public static int x = 0;
    public static float y = 1.1f;
    public static float z = 2.2f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037812966, "Lcom/baidu/location/e/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037812966, "Lcom/baidu/location/e/k;");
                return;
            }
        }
        aO = Build.MANUFACTURER;
        aN = false;
    }

    public static double a(double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
            float[] fArr = new float[1];
            Location.distanceBetween(d2, d3, d4, d5, fArr);
            return fArr[0];
        }
        return invokeCommon.doubleValue;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT > 17) {
                    return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0);
                }
                return 2;
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
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, null, context, str)) != null) {
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

    public static int a(Object obj, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str)) == null) {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return ((Integer) declaredMethod.invoke(obj, null)).intValue();
        }
        return invokeLL.intValue;
    }

    public static int a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        int indexOf;
        int length;
        int indexOf2;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, str3)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            Calendar calendar = Calendar.getInstance();
            return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)));
        }
        return (String) invokeV.objValue;
    }

    public static String a(com.baidu.location.c.a aVar, com.baidu.location.c.j jVar, Location location, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{aVar, jVar, location, str, Integer.valueOf(i2)})) == null) ? a(aVar, jVar, location, str, i2, false) : (String) invokeCommon.objValue;
    }

    public static String a(com.baidu.location.c.a aVar, com.baidu.location.c.j jVar, Location location, String str, int i2, boolean z2) {
        InterceptResult invokeCommon;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{aVar, jVar, location, str, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            StringBuffer stringBuffer = new StringBuffer(2048);
            if (aVar != null && (b2 = com.baidu.location.c.b.a().b(aVar)) != null) {
                stringBuffer.append(b2);
            }
            if (jVar != null) {
                String b3 = i2 == 0 ? z2 ? jVar.b() : jVar.c() : jVar.d();
                if (b3 != null) {
                    stringBuffer.append(b3);
                }
            }
            if (location != null) {
                String b4 = (d == 0 || i2 == 0) ? com.baidu.location.c.e.b(location) : com.baidu.location.c.e.c(location);
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
            stringBuffer.append(com.baidu.location.c.e.a().m());
            String a3 = com.baidu.location.c.b.a().a(aVar);
            if (a3 != null && a3.length() + stringBuffer.length() < 2000) {
                stringBuffer.append(a3);
            }
            String stringBuffer2 = stringBuffer.toString();
            if (location != null && jVar != null) {
                try {
                    float speed = location.getSpeed();
                    int i3 = d;
                    int h2 = jVar.h();
                    int a4 = jVar.a();
                    boolean i4 = jVar.i();
                    if (speed < ar && ((i3 == 1 || i3 == 0) && (h2 < at || i4))) {
                        p = 1;
                    } else if (speed < as && ((i3 == 1 || i3 == 0 || i3 == 3) && (h2 < au || a4 > av))) {
                        p = 2;
                    }
                } catch (Exception unused) {
                    p = 3;
                }
                return stringBuffer2;
            }
            p = 3;
            return stringBuffer2;
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            return Jni.en1(n + ParamableElem.DIVIDE_PARAM + str);
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, String str, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, null, bArr, str, z2)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z2) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static String a(byte[] bArr, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, bArr, z2)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return a(messageDigest.digest(), "", z2);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static boolean a(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) ? Math.abs(d2 - d3) <= 1.192092896E-7d : invokeCommon.booleanValue;
    }

    public static boolean a(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? Math.abs(f2 - f3) <= 1.1920929E-7f : invokeCommon.booleanValue;
    }

    public static boolean a(Location location) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, location)) == null) {
            if (location == null || (str = aO) == null) {
                return false;
            }
            if (RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(str)) {
                try {
                    Bundle extras = location.getExtras();
                    if (extras == null) {
                        return false;
                    }
                    if ((extras.getInt("SourceType") & 128) != 128) {
                        return false;
                    }
                } catch (Exception unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(BDLocation bDLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bDLocation)) == null) {
            int locType = bDLocation.getLocType();
            return (locType > 100 && locType < 200) || locType == 62;
        }
        return invokeL.booleanValue;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) {
            try {
                context.getPackageManager().getPackageInfo(str, 1);
                return true;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            try {
                return Class.forName(str) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0042 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.zip.GZIPInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2;
        IOException e2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            gZIPInputStream = 65557;
            InterceptResult invokeL = interceptable.invokeL(65557, null, bArr);
            if (invokeL != null) {
                return (byte[]) invokeL.objValue;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr));
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            try {
                byte[] bArr2 = new byte[2048];
                while (true) {
                    int read = gZIPInputStream2.read(bArr2);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                gZIPInputStream2.close();
            } catch (IOException e4) {
                e2 = e4;
                e2.printStackTrace();
                if (gZIPInputStream2 != null) {
                    gZIPInputStream2.close();
                }
                return byteArrayOutputStream.toByteArray();
            }
        } catch (IOException e5) {
            gZIPInputStream2 = null;
            e2 = e5;
        } catch (Throwable th2) {
            gZIPInputStream = 0;
            th = th2;
            if (gZIPInputStream != 0) {
                try {
                    gZIPInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Throwable added to exception handler: 'SocketException', keep only Throwable */
    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
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

    public static String c(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            } catch (Exception unused) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                if (TextUtils.isEmpty(readLine)) {
                    return null;
                }
                return readLine;
            } catch (Exception unused3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (context != null) {
                try {
                    i2 = context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.h.h);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i2 = 0;
                }
                boolean z2 = i2 == 0;
                if (z2 && Build.VERSION.SDK_INT >= 23) {
                    try {
                        if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 1) == 0) {
                            return false;
                        }
                    } catch (Exception unused) {
                    }
                }
                return z2;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static long d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime() / 1000;
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? "https://daup.map.baidu.com/cltr/rcvr" : (String) invokeV.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            int a2 = a(context, com.kuaishou.weapon.p0.h.h);
            int a3 = a(context, com.kuaishou.weapon.p0.h.g);
            int a4 = a(context, com.kuaishou.weapon.p0.h.c);
            if (Build.VERSION.SDK_INT < 29) {
                return "&per=" + a2 + "|" + a3 + "|" + a4;
            }
            int a5 = a(context, "android.permission.ACCESS_BACKGROUND_LOCATION");
            return "&per=" + a2 + "|" + a3 + "|" + a4 + "|" + a5;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e() {
        InterceptResult invokeV;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
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
                        } catch (Exception unused) {
                            path = null;
                        }
                    }
                    if (path != null) {
                        try {
                            File file = new File(path + "/baidu/tempdata");
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
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
        return (String) invokeV.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            int i2 = -1;
            if (context != null) {
                try {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        i2 = activeNetworkInfo.getType();
                    }
                } catch (Throwable unused) {
                }
            }
            return "&netc=" + i2;
        }
        return (String) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            int a2 = a(context, com.kuaishou.weapon.p0.h.g) | a(context, com.kuaishou.weapon.p0.h.h);
            if (b(context) == 0 || a2 != 1) {
                if (b(context) == 0 || a2 == 1) {
                    return (b(context) >= 1 || a2 != 1) ? 0 : -1;
                }
                return -2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            String e2 = e();
            if (e2 == null) {
                return null;
            }
            return e2 + "/baidu/tempdata";
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
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

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
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

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                File file = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return com.baidu.location.f.getServiceContext().getFilesDir().getPath() + File.separator + "/baidu/tempdata";
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? c("ro.mediatek.platform") : (String) invokeV.objValue;
    }

    public static SSLSocketFactory k() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            TrustManager[] trustManagerArr = {new l()};
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            return sSLContext.getSocketFactory();
        }
        return (SSLSocketFactory) invokeV.objValue;
    }
}
