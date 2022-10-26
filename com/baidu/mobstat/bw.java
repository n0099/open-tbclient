package com.baidu.mobstat;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.bl;
import com.baidu.mobstat.bs;
import com.baidu.mobstat.util.CuidUtil;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bw {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static final Pattern d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581658493, "Lcom/baidu/mobstat/bw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581658493, "Lcom/baidu/mobstat/bw;");
                return;
            }
        }
        d = Pattern.compile("\\s*|\t|\r|\n");
    }

    public static String a() {
        InterceptResult invokeV;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
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
                        } else if (read == 20 && cArr[19] != '\r') {
                            System.out.print(cArr);
                        } else {
                            for (int i = 0; i < read; i++) {
                                if (cArr[i] != '\r') {
                                    stringBuffer.append(cArr[i]);
                                }
                            }
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
        } else {
            return (String) invokeV.objValue;
        }
    }

    public static String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String str2 = c;
            if (str2 != null) {
                return str2;
            }
            if (!TextUtils.isEmpty(b("ro.miui.ui.version.name"))) {
                str = "miui";
            } else if (!TextUtils.isEmpty(b("ro.build.version.opporom"))) {
                str = "coloros";
            } else if (!TextUtils.isEmpty(b("ro.build.version.emui"))) {
                str = "emui";
            } else if (!TextUtils.isEmpty(b("ro.vivo.os.version"))) {
                str = "funtouch";
            } else if (!TextUtils.isEmpty(b("ro.smartisan.version"))) {
                str = RomUtils.MANUFACTURER_SMARTISAN;
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                String b2 = b(RomUtils.PROP_RO_BUILD_DISPLAY_ID);
                if (!TextUtils.isEmpty(b2) && b2.contains("Flyme")) {
                    str = "flyme";
                }
            }
            c = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (Build.VERSION.SDK_INT < 9) {
                return "";
            }
            try {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = ApiReplaceUtil.getHardwareAddress(networkInterface);
                        if (hardwareAddress == null) {
                            return "";
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
            } catch (Throwable unused) {
            }
            return "";
        }
        return (String) invokeV.objValue;
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

    public static String j(Context context) {
        InterceptResult invokeL;
        WifiInfo connectionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            try {
                if (bn.e(context, com.kuaishou.weapon.p0.h.d) && (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) != null) {
                    String macAddress = ApiReplaceUtil.getMacAddress(connectionInfo);
                    if (!TextUtils.isEmpty(macAddress)) {
                        return macAddress;
                    }
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            String n = n(context);
            if (TextUtils.isEmpty(n)) {
                return "";
            }
            return bl.a.a(n.getBytes());
        }
        return (String) invokeL.objValue;
    }

    public static boolean o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
                if (networkInfo == null || !networkInfo.isAvailable()) {
                    return false;
                }
                if (!networkInfo.isConnected()) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return "";
                }
                String typeName = activeNetworkInfo.getTypeName();
                if (!typeName.equals("WIFI") && activeNetworkInfo.getSubtypeName() != null) {
                    return activeNetworkInfo.getSubtypeName();
                }
                return typeName;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) {
            String str = b;
            if (str == null) {
                String x = x(context);
                String b2 = b(context, x);
                if (TextUtils.isEmpty(b2)) {
                    b2 = c(context, x);
                }
                if (b2 == null) {
                    str = "";
                } else {
                    str = b2;
                }
                b = str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            try {
                String deviceId = ApiReplaceUtil.getDeviceId((TelephonyManager) context.getSystemService("phone"));
                if (!TextUtils.isEmpty(deviceId)) {
                    return bl.b.c(2, deviceId.getBytes());
                }
                return deviceId;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, context)) == null) {
            try {
                return bl.b.c(i, a(context).getBytes());
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeIL.objValue;
    }

    public static String b(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65545, null, i, context)) == null) {
            return bl.b.c(i, CuidUtil.getOaid(context).getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, str)) == null) {
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

    public static String d(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65555, null, i, context)) == null) {
            return bl.b.c(i, CuidUtil.getIid(context).getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String e(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65557, null, i, context)) == null) {
            return bl.b.c(i, CuidUtil.getGaid(context).getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String f(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65559, null, i, context)) == null) {
            return bl.b.c(i, CuidUtil.getCuid3(context).getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String g(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65560, null, i, context)) == null) {
            return bl.b.c(i, CuidUtil.getSsaid(context).getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String n(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65574, null, i, context)) == null) {
            String r = r(context);
            if (!TextUtils.isEmpty(r)) {
                try {
                    return bl.b.c(i, r.getBytes());
                } catch (Exception unused) {
                    return "";
                }
            }
            return "";
        }
        return (String) invokeIL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return d.matcher(bx.a(context)).replaceAll("");
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            return bs.a.a(a(context).getBytes()).toUpperCase(Locale.US);
        }
        return (String) invokeL.objValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics;
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception unused) {
                return 1;
            }
        }
        return invokeL.intValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            try {
                return (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            if (Build.VERSION.SDK_INT < 23) {
                return j(context);
            }
            return d();
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    String name = defaultAdapter.getName();
                    if (name != null) {
                        return name;
                    }
                    return "";
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean q(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            if (context != null) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (bn.e(context, "android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                        return activeNetworkInfo.isAvailable();
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) {
            if (context != null) {
                return context.getPackageName();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                if (!context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, context, i)) == null) {
            String k = k(context);
            if (TextUtils.isEmpty(k)) {
                return "";
            }
            return bl.b.c(i, k.getBytes());
        }
        return (String) invokeLI.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        int lastIndexOf;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            if (str == null || (lastIndexOf = str.lastIndexOf(58)) <= 0 || (i = lastIndexOf + 1) >= str.length()) {
                return null;
            }
            return str.substring(i);
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null) {
                    return "";
                }
                Object obj = null;
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    obj = bundle.get(str);
                }
                if (obj == null) {
                    bb c2 = bb.c();
                    c2.a("can't find information in AndroidManifest.xml for key " + str);
                    return "";
                }
                return obj.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String c(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, context)) == null) {
            String v = bp.a().v(context);
            if (TextUtils.isEmpty(v)) {
                v = bp.a().w(context);
                ca.a().a(context, new bz(context) { // from class: com.baidu.mobstat.bw.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = context;
                    }

                    @Override // com.baidu.mobstat.bz
                    public void a(String str) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str)) {
                            bp.a().o(this.a, str);
                        }
                    }
                });
            }
            if (TextUtils.isEmpty(v)) {
                v = "";
            }
            return bl.b.c(i, v.getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return bl.b.c(2, str.getBytes());
        }
        return (String) invokeL.objValue;
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
    public static String b(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Throwable th;
        Process process;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
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
        } else {
            return (String) invokeL.objValue;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003c: INVOKE  (r1v3 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public static String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("m", memoryInfo.availMem);
                jSONObject.put("l", memoryInfo.lowMemory);
                jSONObject.put("t", memoryInfo.threshold);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_mem", jSONArray);
                jSONObject2.put("meta-data", sb.toString());
                return bl.a.a(jSONObject2.toString().getBytes());
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static Boolean c() {
        InterceptResult invokeV;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            Boolean bool = Boolean.TRUE;
            try {
                Class<?> cls = Class.forName("com.baidu.disasterrecovery.MtjAdapter");
                if (cls != null && (invoke = cls.getDeclaredMethod("shouldUploadOther", new Class[0]).invoke(null, new Object[0])) != null && (invoke instanceof Boolean)) {
                    return (Boolean) invoke;
                }
                return bool;
            } catch (Exception unused) {
                return bool;
            }
        }
        return (Boolean) invokeV.objValue;
    }

    public static String h(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65562, null, i, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            String j = j(context);
            if (TextUtils.isEmpty(j)) {
                return "";
            }
            return bl.b.c(i, j.getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String i(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65564, null, i, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            String j = j(i, context);
            String str = null;
            if (!TextUtils.isEmpty(j)) {
                str = bl.b.c(i, j.getBytes());
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeIL.objValue;
    }

    public static String j(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65566, null, i, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                a2 = k(i, context);
            }
            if (TextUtils.isEmpty(a2)) {
                return "";
            }
            return a2;
        }
        return (String) invokeIL.objValue;
    }

    public static String l(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65570, null, i, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            String l = l(context);
            if (TextUtils.isEmpty(l)) {
                return "";
            }
            return bl.b.c(i, l.getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String m(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65572, null, i, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            String n = n(context);
            if (TextUtils.isEmpty(n)) {
                return "";
            }
            return bl.b.d(i, n.getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String k(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65568, null, i, context)) == null) {
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
                                    bArr = ApiReplaceUtil.getHardwareAddress(nextElement);
                                } else if (!nextElement2.isLinkLocalAddress()) {
                                    bArr = ApiReplaceUtil.getHardwareAddress(nextElement);
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
            String h = h(i, context);
            if (h != null) {
                return h.replaceAll(":", "");
            }
            return h;
        }
        return (String) invokeIL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        BluetoothAdapter defaultAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            if (!bu.a().d()) {
                return "";
            }
            String str = android.os.Build.BRAND;
            if ("4.1.1".equals(Build.VERSION.RELEASE) && "TCT".equals(str)) {
                return "";
            }
            try {
                if (bn.e(context, "android.permission.BLUETOOTH") && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null) {
                    String address = defaultAdapter.getAddress();
                    if (address != null) {
                        return address;
                    }
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String t(Context context) {
        InterceptResult invokeL;
        ServiceInfo[] serviceInfoArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            String x = x(context);
            if (x == null) {
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
            int i = 0;
            while (true) {
                if (i >= length) {
                    str = "";
                    break;
                }
                ServiceInfo serviceInfo = serviceInfoArr[i];
                if (x.equals(serviceInfo.processName)) {
                    str = serviceInfo.name;
                    break;
                }
                i++;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = r2.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            String str = a;
            if (str == null) {
                try {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                    int i = 0;
                    while (true) {
                        if (runningAppProcesses == null || i >= runningAppProcesses.size()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                            break;
                        }
                        i++;
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

    /* JADX WARN: Removed duplicated region for block: B:29:0x006e A[Catch: Exception -> 0x009b, TryCatch #1 {Exception -> 0x009b, blocks: (B:27:0x004d, B:29:0x006e, B:30:0x0072, B:32:0x0082, B:36:0x0091), top: B:53:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(Context context) {
        InterceptResult invokeL;
        WifiInfo wifiInfo;
        List<ScanResult> list;
        JSONArray jSONArray;
        int i;
        String replaceAll;
        int i2;
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            if (context == null || !bn.e(context, com.kuaishou.weapon.p0.h.d)) {
                return "";
            }
            try {
                wifiManager = (WifiManager) context.getSystemService("wifi");
                wifiInfo = wifiManager.getConnectionInfo();
            } catch (Throwable unused) {
                wifiInfo = null;
            }
            try {
                list = wifiManager.getScanResults();
            } catch (Throwable unused2) {
                list = null;
                if (list != null) {
                    Collections.sort(list, new Comparator() { // from class: com.baidu.mobstat.bw.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: a */
                        public int compare(ScanResult scanResult, ScanResult scanResult2) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, scanResult, scanResult2)) == null) {
                                return scanResult2.level - scanResult.level;
                            }
                            return invokeLL.intValue;
                        }
                    });
                }
                jSONArray = new JSONArray();
                while (list != null) {
                    try {
                        ScanResult scanResult = list.get(i);
                        StringBuilder sb = new StringBuilder();
                        sb.append(scanResult.BSSID);
                        sb.append("|");
                        replaceAll = scanResult.SSID.replaceAll(WebChromeClient.PARAM_SEPARATOR, "");
                        if (replaceAll.length() > 30) {
                        }
                        sb.append(replaceAll);
                        sb.append("|");
                        sb.append(scanResult.level);
                        sb.append("|");
                        if (wifiInfo == null) {
                        }
                        i2 = 0;
                        sb.append(i2);
                        jSONArray.put(sb.toString());
                    } catch (Exception unused3) {
                    }
                }
                if (jSONArray.length() != 0) {
                }
            }
            if (list != null && list.size() != 0) {
                Collections.sort(list, new Comparator() { // from class: com.baidu.mobstat.bw.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(ScanResult scanResult2, ScanResult scanResult22) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, scanResult2, scanResult22)) == null) {
                            return scanResult22.level - scanResult2.level;
                        }
                        return invokeLL.intValue;
                    }
                });
            }
            jSONArray = new JSONArray();
            for (i = 0; list != null && i < list.size() && i < 30; i++) {
                ScanResult scanResult2 = list.get(i);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(scanResult2.BSSID);
                sb2.append("|");
                replaceAll = scanResult2.SSID.replaceAll(WebChromeClient.PARAM_SEPARATOR, "");
                if (replaceAll.length() > 30) {
                    replaceAll = replaceAll.substring(0, 30);
                }
                sb2.append(replaceAll);
                sb2.append("|");
                sb2.append(scanResult2.level);
                sb2.append("|");
                if (wifiInfo == null && scanResult2.BSSID.equals(wifiInfo.getBSSID())) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                sb2.append(i2);
                jSONArray.put(sb2.toString());
            }
            if (jSONArray.length() != 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ap-list", jSONArray);
                jSONObject.put("meta-data", System.currentTimeMillis() + "|0");
                return jSONObject.toString();
            } catch (Exception unused4) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
