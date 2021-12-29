package com.baidu.mobstat.dxmpay;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.dxmpay.m;
import com.baidu.mobstat.dxmpay.s;
import com.baidu.mobstat.dxmpay.util.CuidUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f38126b;

    /* renamed from: c  reason: collision with root package name */
    public static String f38127c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f38128d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1455169723, "Lcom/baidu/mobstat/dxmpay/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1455169723, "Lcom/baidu/mobstat/dxmpay/w;");
                return;
            }
        }
        f38128d = Pattern.compile("\\s*|\t|\r|\n");
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    Bundle bundle = applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get(str) : null;
                    if (obj == null) {
                        h c2 = h.c();
                        c2.a("can't find information in AndroidManifest.xml for key " + str);
                        return "";
                    }
                    return obj.toString();
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String b(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i2, context)) == null) ? m.b.c(i2, q.a().o(context).getBytes()) : (String) invokeIL.objValue;
    }

    public static String c(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65548, null, i2, context)) == null) ? m.b.c(i2, CuidUtil.getIid(context).getBytes()) : (String) invokeIL.objValue;
    }

    public static String d(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i2, context)) == null) ? m.b.c(i2, CuidUtil.getGaid(context).getBytes()) : (String) invokeIL.objValue;
    }

    public static String e(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65553, null, i2, context)) == null) ? m.b.c(i2, CuidUtil.getCuid3(context).getBytes()) : (String) invokeIL.objValue;
    }

    public static String f(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65555, null, i2, context)) == null) ? m.b.c(i2, CuidUtil.getSsaid(context).getBytes()) : (String) invokeIL.objValue;
    }

    public static String g(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65556, null, i2, context)) == null) ? "" : (String) invokeIL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65558, null, i2, context)) == null) {
            String i3 = i(i2, context);
            String c2 = !TextUtils.isEmpty(i3) ? m.b.c(i2, i3.getBytes()) : null;
            return TextUtils.isEmpty(c2) ? "" : c2;
        }
        return (String) invokeIL.objValue;
    }

    public static String i(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65560, null, i2, context)) == null) {
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                a2 = j(i2, context);
            }
            return TextUtils.isEmpty(a2) ? "" : a2;
        }
        return (String) invokeIL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static String j(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65562, null, i2, context)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = null;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isAnyLocalAddress() && (nextElement2 instanceof Inet4Address) && !nextElement2.isLoopbackAddress()) {
                                if (nextElement2.isSiteLocalAddress()) {
                                    bArr = nextElement.getHardwareAddress();
                                } else if (!nextElement2.isLinkLocalAddress()) {
                                    bArr = nextElement.getHardwareAddress();
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (bArr != null) {
                for (byte b2 : bArr) {
                    stringBuffer.append(a(b2));
                }
                return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(":", "");
            }
            String g2 = g(i2, context);
            return g2 != null ? g2.replaceAll(":", "") : g2;
        }
        return (String) invokeIL.objValue;
    }

    public static String k(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65564, null, i2, context)) == null) ? "" : (String) invokeIL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            String str = f38126b;
            if (str == null) {
                String n = n(context);
                String b2 = b(context, n);
                if (TextUtils.isEmpty(b2)) {
                    b2 = c(context, n);
                }
                str = b2 == null ? "" : b2;
                f38126b = str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String l(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65566, null, i2, context)) == null) {
            String j2 = j(context);
            if (TextUtils.isEmpty(j2)) {
                return "";
            }
            try {
                return m.b.c(i2, j2.getBytes());
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeIL.objValue;
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (context != null) {
                try {
                    return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = r2.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            String str = a;
            if (str == null) {
                try {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                    int i2 = 0;
                    while (true) {
                        if (runningAppProcesses == null || i2 >= runningAppProcesses.size()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                            break;
                        }
                        i2++;
                    }
                } catch (Exception unused) {
                }
                if (str == null) {
                    str = "";
                }
                a = str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? s.a.a(a(context).getBytes()).toUpperCase(Locale.US) : (String) invokeL.objValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                displayMetrics = e(context);
            } catch (Exception unused) {
            }
            return displayMetrics.widthPixels;
        }
        return invokeL.intValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                displayMetrics = e(context);
            } catch (Exception unused) {
            }
            return displayMetrics.heightPixels;
        }
        return invokeL.intValue;
    }

    public static DisplayMetrics e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics;
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception unused) {
                return 1;
            }
        }
        return invokeL.intValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        int lastIndexOf;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            if (str != null && (lastIndexOf = str.lastIndexOf(58)) > 0 && (i2 = lastIndexOf + 1) < str.length()) {
                return str.substring(i2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        ServiceInfo[] serviceInfoArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            String n = n(context);
            if (n == null) {
                return "";
            }
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
            } catch (Exception unused) {
            }
            if (packageInfo == null || (serviceInfoArr = packageInfo.services) == null) {
                return "";
            }
            int length = serviceInfoArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    str = "";
                    break;
                }
                ServiceInfo serviceInfo = serviceInfoArr[i2];
                if (n.equals(serviceInfo.processName)) {
                    str = serviceInfo.name;
                    break;
                }
                i2++;
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            String str2 = applicationInfo.processName;
            if (str2 == null || str2.equals(str)) {
                return null;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (context != null) {
                try {
                    NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
                    if (networkInfo == null || !networkInfo.isAvailable()) {
                        return false;
                    }
                    return networkInfo.isConnected();
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    String typeName = activeNetworkInfo.getTypeName();
                    return (typeName.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String str2 = f38127c;
            if (str2 != null) {
                return str2;
            }
            if (!TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
                str = "miui";
            } else if (!TextUtils.isEmpty(a("ro.build.version.opporom"))) {
                str = "coloros";
            } else if (!TextUtils.isEmpty(a("ro.build.version.emui"))) {
                str = "emui";
            } else if (TextUtils.isEmpty(a("ro.vivo.os.version"))) {
                str = !TextUtils.isEmpty(a("ro.smartisan.version")) ? RomUtils.MANUFACTURER_SMARTISAN : "";
            } else {
                str = "funtouch";
            }
            if (TextUtils.isEmpty(str)) {
                String a2 = a("ro.build.display.id");
                if (!TextUtils.isEmpty(a2) && a2.contains("Flyme")) {
                    str = "flyme";
                }
            }
            f38127c = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? f38128d.matcher(x.a(context)).replaceAll("") : (String) invokeL.objValue;
    }

    public static String a(int i2, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, context)) == null) ? m.b.c(i2, CuidUtil.getOaid(context).getBytes()) : (String) invokeIL.objValue;
    }

    public static String a(byte b2) {
        InterceptResult invokeB;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) {
            return ("00" + Integer.toHexString(b2) + ":").substring(str.length() - 3);
        }
        return (String) invokeB.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65537, null)) != null) {
            return (String) invokeV.objValue;
        }
        StringBuffer stringBuffer = new StringBuffer();
        InputStreamReader inputStreamReader2 = null;
        try {
            char[] cArr = new char[20];
            inputStreamReader = new InputStreamReader(new FileInputStream("/sys/class/net/eth0/address"));
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    } else if (read != 20 || cArr[19] == '\r') {
                        for (int i2 = 0; i2 < read; i2++) {
                            if (cArr[i2] != '\r') {
                                stringBuffer.append(cArr[i2]);
                            }
                        }
                    } else {
                        System.out.print(cArr);
                    }
                } catch (Exception unused) {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            }
            String replaceAll = stringBuffer.toString().trim().replaceAll(":", "");
            try {
                inputStreamReader.close();
            } catch (Exception unused4) {
            }
            return replaceAll;
        } catch (Exception unused5) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) ? context != null ? context.getPackageName() : "" : (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r5 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        r5.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:
        if (r5 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Throwable th;
        Process process;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65542, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        String str2 = null;
        try {
            process = Runtime.getRuntime().exec("getprop " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                try {
                    str2 = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Exception unused6) {
            process = null;
            bufferedReader = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            process = null;
        }
    }
}
