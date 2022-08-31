package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.bm;
import com.baidu.mobstat.bt;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    Bundle bundle = applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get(str) : null;
                    if (obj == null) {
                        bc c2 = bc.c();
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

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? bt.a.a(a(context).getBytes()).toUpperCase(Locale.US) : (String) invokeL.objValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics;
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
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
        String format;
        CellLocation cellLocation;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65563, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        format = String.format("%s_%s_%s", 0, 0, 0);
        try {
            if ((bo.e(context, com.kuaishou.weapon.p0.h.g) || bo.e(context, com.kuaishou.weapon.p0.h.h)) && (cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation()) != null) {
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return String.format("%s_%s_%s", String.format("%d", Integer.valueOf(gsmCellLocation.getCid())), String.format("%d", Integer.valueOf(gsmCellLocation.getLac())), 0);
                }
                String[] split = cellLocation.toString().replace(PreferencesUtil.LEFT_MOUNT, "").replace(PreferencesUtil.RIGHT_MOUNT, "").split(",");
                return String.format("%s_%s_%s", split[0], split[3], split[4]);
            }
            return format;
        } catch (Exception unused) {
        }
        return format;
    }

    public static String j(Context context) {
        Location lastKnownLocation;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            try {
                return (!bo.e(context, com.kuaishou.weapon.p0.h.g) || (lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("gps")) == null) ? "" : String.format("%s_%s_%s", Long.valueOf(lastKnownLocation.getTime()), Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude()));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return l(context);
            }
            return d();
        }
        return (String) invokeL.objValue;
    }

    public static String l(Context context) {
        WifiInfo connectionInfo;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            try {
                if (!bo.e(context, com.kuaishou.weapon.p0.h.d) || (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) == null) {
                    return "";
                }
                String macAddress = connectionInfo.getMacAddress();
                return !TextUtils.isEmpty(macAddress) ? macAddress : "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    String name = defaultAdapter.getName();
                    return name != null ? name : "";
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static String n(Context context) {
        InterceptResult invokeL;
        BluetoothAdapter defaultAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            String str = android.os.Build.BRAND;
            if ("4.1.1".equals(Build.VERSION.RELEASE) && "TCT".equals(str)) {
                return "";
            }
            try {
                if (bo.e(context, "android.permission.BLUETOOTH") && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null) {
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

    public static String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            String p = p(context);
            return TextUtils.isEmpty(p) ? "" : bm.a.a(p.getBytes());
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:10|11|12|(11:14|15|16|17|19|20|(1:24)|25|(2:26|(1:1)(8:32|33|(1:35)|36|(1:44)(1:40)|41|42|43))|48|(1:50)(6:51|52|53|(1:55)|56|57))|67|15|16|17|19|20|(2:22|24)|25|(3:26|(2:28|60)(1:61)|43)|48|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        r4 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b4 A[ADDED_TO_REGION, EDGE_INSN: B:72:0x00b4->B:44:0x00b4 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String p(Context context) {
        InterceptResult invokeL;
        boolean z;
        List<ScanResult> list;
        JSONArray jSONArray;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65570, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (context == null || !bo.e(context, com.kuaishou.weapon.p0.h.d)) {
            return "";
        }
        if (bo.e(context, com.kuaishou.weapon.p0.h.g)) {
            z = ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            list = wifiManager.getScanResults();
            if (list != null && list.size() != 0) {
                Collections.sort(list, new Comparator<ScanResult>() { // from class: com.baidu.mobstat.bw.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, scanResult, scanResult2)) == null) ? scanResult2.level - scanResult.level : invokeLL.intValue;
                    }
                });
            }
            jSONArray = new JSONArray();
            i = 0;
            while (true) {
                int i2 = 1;
                if (list != null || i >= list.size() || i >= 30) {
                    break;
                }
                try {
                    ScanResult scanResult = list.get(i);
                    StringBuilder sb = new StringBuilder();
                    sb.append(scanResult.BSSID);
                    sb.append("|");
                    String replaceAll = scanResult.SSID.replaceAll(WebChromeClient.PARAM_SEPARATOR, "");
                    if (replaceAll.length() > 30) {
                        replaceAll = replaceAll.substring(0, 30);
                    }
                    sb.append(replaceAll);
                    sb.append("|");
                    sb.append(scanResult.level);
                    sb.append("|");
                    if (wifiInfo == null || !scanResult.BSSID.equals(wifiInfo.getBSSID())) {
                        i2 = 0;
                    }
                    sb.append(i2);
                    jSONArray.put(sb.toString());
                } catch (Exception unused) {
                }
                i++;
            }
            if (jSONArray.length() == 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis());
                sb2.append("|");
                sb2.append(z ? 1 : 0);
                sb2.append("|");
                sb2.append(j(context));
                jSONObject.put("ap-list", jSONArray);
                jSONObject.put("meta-data", sb2.toString());
                return jSONObject.toString();
            } catch (Exception unused2) {
                return "";
            }
        }
        z = false;
        WifiManager wifiManager2 = (WifiManager) context.getSystemService("wifi");
        WifiInfo wifiInfo2 = wifiManager2.getConnectionInfo();
        list = wifiManager2.getScanResults();
        if (list != null) {
            Collections.sort(list, new Comparator<ScanResult>() { // from class: com.baidu.mobstat.bw.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i22 = newInitContext.flag;
                        if ((i22 & 1) != 0) {
                            int i3 = i22 & 2;
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
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, scanResult2, scanResult22)) == null) ? scanResult22.level - scanResult2.level : invokeLL.intValue;
                }
            });
        }
        jSONArray = new JSONArray();
        i = 0;
        while (true) {
            int i22 = 1;
            if (list != null) {
                break;
            }
            break;
            i++;
        }
        if (jSONArray.length() == 0) {
        }
    }

    public static boolean q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
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

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    String typeName = activeNetworkInfo.getTypeName();
                    return (typeName.equals("WIFI") || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean s(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            if (context != null) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (!bo.e(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                        return false;
                    }
                    return activeNetworkInfo.isAvailable();
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) ? context != null ? context.getPackageName() : "" : (String) invokeL.objValue;
    }

    public static String u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            String str = b;
            if (str == null) {
                String y = y(context);
                String b2 = b(context, y);
                if (TextUtils.isEmpty(b2)) {
                    b2 = c(context, y);
                }
                str = b2 == null ? "" : b2;
                b = str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String v(Context context) {
        InterceptResult invokeL;
        ServiceInfo[] serviceInfoArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            String y = y(context);
            if (y == null) {
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
                if (y.equals(serviceInfo.processName)) {
                    str = serviceInfo.name;
                    break;
                }
                i++;
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x003b: INVOKE  (r1v3 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public static String x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
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
                return bm.a.a(jSONObject2.toString().getBytes());
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = r2.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) {
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

    public static String b(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65545, null, i, context)) == null) {
            String l = l(context);
            return TextUtils.isEmpty(l) ? "" : bm.b.c(i, l.getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String c(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65550, null, i, context)) == null) {
            String d2 = d(i, context);
            String c2 = !TextUtils.isEmpty(d2) ? bm.b.c(i, d2.getBytes()) : null;
            return TextUtils.isEmpty(c2) ? "" : c2;
        }
        return (String) invokeIL.objValue;
    }

    @TargetApi(9)
    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (Build.VERSION.SDK_INT < 9) {
                return "";
            }
            try {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
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

    @SuppressLint({"NewApi"})
    public static String e(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65556, null, i, context)) == null) {
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
            String b3 = b(i, context);
            return b3 != null ? b3.replaceAll(":", "") : b3;
        }
        return (String) invokeIL.objValue;
    }

    public static String h(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65561, null, i, context)) == null) {
            String t = t(context);
            if (TextUtils.isEmpty(t)) {
                return "";
            }
            try {
                return bm.b.c(i, t.getBytes());
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeIL.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        int lastIndexOf;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            if (str != null && (lastIndexOf = str.lastIndexOf(58)) > 0 && (i = lastIndexOf + 1) < str.length()) {
                return str.substring(i);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String f(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65558, null, i, context)) == null) {
            String n = n(context);
            return TextUtils.isEmpty(n) ? "" : bm.b.c(i, n.getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String g(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65559, null, i, context)) == null) {
            String p = p(context);
            return TextUtils.isEmpty(p) ? "" : bm.b.d(i, p.getBytes());
        }
        return (String) invokeIL.objValue;
    }

    public static String a(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, context)) == null) {
            try {
                return bm.b.c(i, a(context).getBytes());
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeIL.objValue;
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
                String a2 = a(RomUtils.PROP_RO_BUILD_DISPLAY_ID);
                if (!TextUtils.isEmpty(a2) && a2.contains("Flyme")) {
                    str = "flyme";
                }
            }
            c = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, context, str)) == null) {
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

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? d.matcher(bx.a(context)).replaceAll("") : (String) invokeL.objValue;
    }

    public static Boolean c() {
        InterceptResult invokeV;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            Boolean bool = Boolean.TRUE;
            try {
                Class<?> cls = Class.forName("com.baidu.disasterrecovery.MtjAdapter");
                return (cls == null || (invoke = cls.getDeclaredMethod("shouldUploadOther", new Class[0]).invoke(null, new Object[0])) == null || !(invoke instanceof Boolean)) ? bool : (Boolean) invoke;
            } catch (Exception unused) {
                return bool;
            }
        }
        return (Boolean) invokeV.objValue;
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
                        for (int i = 0; i < read; i++) {
                            if (cArr[i] != '\r') {
                                stringBuffer.append(cArr[i]);
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

    public static String d(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65554, null, i, context)) == null) {
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                a2 = e(i, context);
            }
            return TextUtils.isEmpty(a2) ? "" : a2;
        }
        return (String) invokeIL.objValue;
    }

    public static String a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, context, i)) == null) {
            String m = m(context);
            return TextUtils.isEmpty(m) ? "" : bm.b.c(i, m.getBytes());
        }
        return (String) invokeLI.objValue;
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
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, null, str)) != null) {
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
