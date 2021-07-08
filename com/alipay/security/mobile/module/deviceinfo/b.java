package com.alipay.security.mobile.module.deviceinfo;

import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statistics.g;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f2074a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1767273494, "Lcom/alipay/security/mobile/module/deviceinfo/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1767273494, "Lcom/alipay/security/mobile/module/deviceinfo/b;");
                return;
            }
        }
        f2074a = new b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
                if (list != null) {
                    for (NetworkInterface networkInterface : list) {
                        if (networkInterface != null && networkInterface.getName() != null && networkInterface.getName().equalsIgnoreCase(NetworkInfoUtils.NETWORK_NAME)) {
                            byte[] hardwareAddress = networkInterface.getHardwareAddress();
                            if (hardwareAddress == null) {
                                return Config.DEF_MAC_ID;
                            }
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                sb.append(String.format("%02X:", Integer.valueOf(hardwareAddress[i2] & 255)));
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            return sb.toString();
                        }
                    }
                    return Config.DEF_MAC_ID;
                }
                return Config.DEF_MAC_ID;
            } catch (Throwable unused) {
                return Config.DEF_MAC_ID;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String C() {
        InterceptResult invokeV;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, null)) != null) {
            return (String) invokeV.objValue;
        }
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileReader = null;
        }
        try {
            readLine = bufferedReader.readLine();
        } catch (Throwable unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            if (fileReader == null) {
                return "";
            }
            try {
                fileReader.close();
            } catch (Throwable unused5) {
                return "";
            }
        }
        if (!com.alipay.security.mobile.module.a.a.a(readLine)) {
            String trim = readLine.trim();
            try {
                bufferedReader.close();
            } catch (Throwable unused6) {
            }
            try {
                fileReader.close();
            } catch (Throwable unused7) {
            }
            return trim;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused8) {
        }
        fileReader.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        r1 = r2[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
        if (r0 == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String D() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) != null) {
            return (String) invokeV.objValue;
        }
        String str = "";
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!com.alipay.security.mobile.module.a.a.a(readLine) && (split = readLine.split(":")) != null && split.length > 1 && split[0].contains("BogoMIPS")) {
                                break;
                            }
                        }
                    } catch (Throwable unused) {
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused5) {
            return str;
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f2074a : (b) invokeV.objValue;
    }

    public static String a(BluetoothAdapter bluetoothAdapter) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bluetoothAdapter)) == null) {
            try {
                Field declaredField = BluetoothAdapter.class.getDeclaredField("mService");
                declaredField.setAccessible(true);
                obj = declaredField.get(bluetoothAdapter);
            } catch (Throwable unused) {
            }
            if (obj == null) {
                return null;
            }
            Method declaredMethod = obj.getClass().getDeclaredMethod("getAddress", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(obj, new Object[0]);
            if (invoke != null && (invoke instanceof String)) {
                return (String) invoke;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? !b(context, str) : invokeLL.booleanValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) ? context.getPackageManager().checkPermission(str, context.getPackageName()) == 0 : invokeLL.booleanValue;
    }

    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress().toString();
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

    public static String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (a(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                return "";
            }
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return null;
                }
                if (activeNetworkInfo.getType() == 1) {
                    return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
                }
                if (activeNetworkInfo.getType() == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (subtype != 4 && subtype != 1 && subtype != 2 && subtype != 7 && subtype != 11) {
                        if (subtype != 3 && subtype != 5 && subtype != 6 && subtype != 8 && subtype != 9 && subtype != 10 && subtype != 12 && subtype != 14 && subtype != 15) {
                            return subtype == 13 ? "4G" : "UNKNOW";
                        }
                        return g.f3986b;
                    }
                    return "2G";
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("00:");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("ro.hardware", "goldfish");
            linkedHashMap.put("ro.kernel.qemu", "1");
            linkedHashMap.put("ro.product.device", "generic");
            linkedHashMap.put("ro.product.model", "sdk");
            linkedHashMap.put("ro.product.brand", "generic");
            linkedHashMap.put("ro.product.name", "sdk");
            linkedHashMap.put(RomUtils.PROP_RO_BUILD_FINGERPRINT, "test-keys");
            linkedHashMap.put("ro.product.manufacturer", "unknow");
            for (String str : linkedHashMap.keySet()) {
                char c2 = '0';
                String str2 = (String) linkedHashMap.get(str);
                String b2 = com.alipay.security.mobile.module.a.a.b(str, "");
                if (b2 != null && b2.contains(str2)) {
                    c2 = '1';
                }
                sb.append(c2);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                return "";
            }
            String str = null;
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = telephonyManager.getDeviceId();
                    }
                } catch (Throwable unused) {
                }
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public String b() {
        long j;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                j = statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable unused) {
                j = 0;
            }
            return String.valueOf(j);
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String subscriberId;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (context != null) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
            if (telephonyManager != null) {
                subscriberId = telephonyManager.getSubscriberId();
                return subscriberId != null ? "" : subscriberId;
            }
        }
        subscriberId = "";
        if (subscriberId != null) {
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long j = 0;
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    StatFs statFs = new StatFs(com.alipay.security.mobile.module.a.a.a().getPath());
                    j = statFs.getBlockSize() * statFs.getAvailableBlocks();
                }
            } catch (Throwable unused) {
            }
            return String.valueOf(j);
        }
        return (String) invokeV.objValue;
    }

    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            int i2 = 0;
            try {
                i2 = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
            } catch (Throwable unused) {
            }
            return i2 == 1 ? "1" : "0";
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
        if (r2 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = "0000000000000000";
            LineNumberReader lineNumberReader = null;
            try {
                fileInputStream = new FileInputStream(new File("/proc/cpuinfo"));
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        LineNumberReader lineNumberReader2 = new LineNumberReader(inputStreamReader);
                        for (int i2 = 1; i2 < 100; i2++) {
                            try {
                                String readLine = lineNumberReader2.readLine();
                                if (readLine != null) {
                                    if (readLine.indexOf("Serial") >= 0) {
                                        str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                                        break;
                                    }
                                }
                            } catch (Throwable unused) {
                                lineNumberReader = lineNumberReader2;
                                if (lineNumberReader != null) {
                                    try {
                                        lineNumberReader.close();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Throwable unused3) {
                                    }
                                }
                            }
                        }
                        try {
                            lineNumberReader2.close();
                        } catch (Throwable unused4) {
                        }
                        try {
                            inputStreamReader.close();
                        } catch (Throwable unused5) {
                        }
                    } catch (Throwable unused6) {
                    }
                } catch (Throwable unused7) {
                    inputStreamReader = null;
                }
            } catch (Throwable unused8) {
                fileInputStream = null;
                inputStreamReader = null;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused9) {
            }
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                int i2 = audioManager.getRingerMode() == 0 ? 1 : 0;
                int streamVolume = audioManager.getStreamVolume(0);
                int streamVolume2 = audioManager.getStreamVolume(1);
                int streamVolume3 = audioManager.getStreamVolume(2);
                int streamVolume4 = audioManager.getStreamVolume(3);
                int streamVolume5 = audioManager.getStreamVolume(4);
                jSONObject.put("ringermode", String.valueOf(i2));
                jSONObject.put(NotificationCompat.CATEGORY_CALL, String.valueOf(streamVolume));
                jSONObject.put(ConstantHelper.LOG_OS, String.valueOf(streamVolume2));
                jSONObject.put("ring", String.valueOf(streamVolume3));
                jSONObject.put(MediaTrackConfig.AE_TEMPLATE_TYPE_MUSIC, String.valueOf(streamVolume4));
                jSONObject.put(NotificationCompat.CATEGORY_ALARM, String.valueOf(streamVolume5));
            } catch (Throwable unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
        if (r2 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String e() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) != null) {
            return (String) invokeV.objValue;
        }
        String str = "-1";
        LineNumberReader lineNumberReader = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/cpuinfo"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    LineNumberReader lineNumberReader2 = new LineNumberReader(inputStreamReader);
                    for (int i2 = 1; i2 < 100; i2++) {
                        try {
                            String readLine = lineNumberReader2.readLine();
                            if (readLine != null) {
                                if (readLine.indexOf("Hardware") >= 0) {
                                    str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                                    break;
                                }
                            }
                        } catch (Throwable unused) {
                            lineNumberReader = lineNumberReader2;
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                    try {
                        lineNumberReader2.close();
                    } catch (Throwable unused4) {
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable unused5) {
                    }
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                inputStreamReader = null;
            }
        } catch (Throwable unused8) {
            fileInputStream = null;
            inputStreamReader = null;
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused9) {
            return str;
        }
    }

    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            String str = null;
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = telephonyManager.getSimOperator();
                    }
                } catch (Throwable unused) {
                }
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
            } catch (Throwable unused) {
                return "1";
            }
        }
        return (String) invokeV.objValue;
    }

    public String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            String str = null;
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = telephonyManager.getSimOperatorName();
                    }
                } catch (Throwable unused) {
                }
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String C = C();
            return !com.alipay.security.mobile.module.a.a.a(C) ? C : D();
        }
        return (String) invokeV.objValue;
    }

    public String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            String str = null;
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        str = telephonyManager.getNetworkOperatorName();
                    }
                } catch (Throwable unused) {
                }
            }
            return (str == null || StringUtil.NULL_STRING.equals(str)) ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        FileReader fileReader;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048590, this)) != null) {
            return (String) invokeV.objValue;
        }
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                split = bufferedReader.readLine().split(":\\s+", 2);
            } catch (Throwable unused2) {
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (bufferedReader == null) {
                    return "";
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                    return "";
                }
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        if (split != null && split.length > 1) {
            String str = split[1];
            try {
                fileReader.close();
            } catch (Throwable unused6) {
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused7) {
            }
            return str;
        }
        try {
            fileReader.close();
        } catch (Throwable unused8) {
        }
        bufferedReader.close();
    }

    public String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r0 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String i() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048592, this)) != null) {
            return (String) invokeV.objValue;
        }
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                r2 = bufferedReader.readLine() != null ? Integer.parseInt(readLine.split("\\s+")[1]) : 0L;
                try {
                    fileReader2.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                fileReader = fileReader2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused4) {
                    }
                }
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused6) {
            return String.valueOf(r2);
        }
    }

    public String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public String j() {
        long j;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                j = statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable unused) {
                j = 0;
            }
            return String.valueOf(j);
        }
        return (String) invokeV.objValue;
    }

    public String j(Context context) {
        InterceptResult invokeL;
        List<Sensor> sensorList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) {
            String str = null;
            if (context != null) {
                try {
                    SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                    if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (Sensor sensor : sensorList) {
                            sb.append(sensor.getName());
                            sb.append(sensor.getVersion());
                            sb.append(sensor.getVendor());
                        }
                        str = com.alipay.security.mobile.module.a.a.e(sb.toString());
                    }
                } catch (Throwable unused) {
                }
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            long j = 0;
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    j = statFs.getBlockSize() * statFs.getBlockCount();
                }
            } catch (Throwable unused) {
            }
            return String.valueOf(j);
        }
        return (String) invokeV.objValue;
    }

    public String k(Context context) {
        InterceptResult invokeL;
        List<Sensor> sensorList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (context != null) {
                try {
                    SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                    if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                        for (Sensor sensor : sensorList) {
                            if (sensor != null) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("name", sensor.getName());
                                jSONObject.put("version", sensor.getVersion());
                                jSONObject.put("vendor", sensor.getVendor());
                                jSONArray.put(jSONObject);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }

    public String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, context)) == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                return Integer.toString(displayMetrics.widthPixels) + "*" + Integer.toString(displayMetrics.heightPixels);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    return defaultAdapter.isEnabled();
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String m() {
        InterceptResult invokeV;
        BluetoothAdapter bluetoothAdapter;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            try {
                bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (bluetoothAdapter != null) {
                    try {
                        if (!bluetoothAdapter.isEnabled()) {
                            return "";
                        }
                    } catch (Throwable unused) {
                        str = "";
                        if (str != null) {
                        }
                        try {
                            str = a(bluetoothAdapter);
                        } catch (Throwable unused2) {
                        }
                        if (str != null) {
                        }
                    }
                }
                str = bluetoothAdapter.getAddress();
            } catch (Throwable unused3) {
                bluetoothAdapter = null;
            }
            if (str != null || str.endsWith("00:00:00:00:00")) {
                str = a(bluetoothAdapter);
            }
            return str != null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0011: IGET  (r5v4 int A[REMOVE]) = (r5v3 android.util.DisplayMetrics) android.util.DisplayMetrics.densityDpi int)] */
    public String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, context)) == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                StringBuilder sb = new StringBuilder();
                sb.append(displayMetrics.densityDpi);
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
            } catch (Throwable unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0011: IGET  (r5v4 int A[REMOVE]) = (r5v3 android.util.DisplayMetrics) android.util.DisplayMetrics.widthPixels int)] */
    public String n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, context)) == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                StringBuilder sb = new StringBuilder();
                sb.append(displayMetrics.widthPixels);
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String o() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048604, this)) != null) {
            return (String) invokeV.objValue;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
                str = "";
            } catch (Throwable unused) {
                bufferedReader = null;
                str = "";
            }
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    }
                } catch (Throwable unused2) {
                }
                try {
                    try {
                        break;
                    } catch (Throwable unused3) {
                        str2 = "";
                        return str2 == null ? "" : str2;
                    }
                } catch (Throwable unused4) {
                    if (com.alipay.security.mobile.module.a.a.b(str)) {
                        String substring = str.substring(str.indexOf("version ") + 8);
                        str2 = substring.substring(0, substring.indexOf(" "));
                        if (str2 == null) {
                        }
                    }
                    str2 = "";
                    if (str2 == null) {
                    }
                }
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (Throwable unused5) {
            return "";
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0011: IGET  (r5v4 int A[REMOVE]) = (r5v3 android.util.DisplayMetrics) android.util.DisplayMetrics.heightPixels int)] */
    public String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, context)) == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                StringBuilder sb = new StringBuilder();
                sb.append(displayMetrics.heightPixels);
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            try {
                str = Build.SERIAL;
            } catch (Throwable unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, context)) == null) {
            String str = "";
            if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return "";
            }
            try {
                str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                if (str == null || str.length() == 0 || Config.DEF_MAC_ID.equals(str)) {
                    return B();
                }
            } catch (Throwable unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            try {
                str = Locale.getDefault().toString();
            } catch (Throwable unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, context)) == null) {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                return "";
            }
            try {
                String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
                if (simSerialNumber != null) {
                    if (simSerialNumber != null) {
                        try {
                            if (simSerialNumber.length() == 0) {
                                return "";
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    return simSerialNumber;
                }
                return "";
            } catch (Throwable unused2) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            try {
                str = InetAddress.getLocalHost().getHostName();
            } catch (Throwable unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public String r(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, context)) == null) {
            try {
                str = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
            } catch (Throwable unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            try {
                str = TimeZone.getDefault().getDisplayName(false, 0);
            } catch (Throwable unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (com.baidu.mobstat.Config.DEF_MAC_ID.equals(r0) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, context)) == null) {
            if (a(context, "android.permission.BLUETOOTH")) {
                return "";
            }
            String m = m();
            if (m != null) {
                try {
                    if (m.length() != 0) {
                    }
                } catch (Throwable unused) {
                    return m;
                }
            }
            m = Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
            return m != null ? m : "";
        }
        return (String) invokeL.objValue;
    }

    public String t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0016: ARITH  (r0v4 long A[REMOVE]) = (r0v3 long) - (wrap: long : 0x0014: ARITH  (r3v1 long A[REMOVE]) = (r0v3 long) % (1000 long)))] */
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
                StringBuilder sb = new StringBuilder();
                sb.append(currentTimeMillis - (currentTimeMillis % 1000));
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String u(Context context) {
        InterceptResult invokeL;
        String str;
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048616, this, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            wifiManager = (WifiManager) context.getSystemService("wifi");
        } catch (Throwable unused) {
        }
        if (wifiManager.isWifiEnabled()) {
            str = wifiManager.getConnectionInfo().getBSSID();
            return str != null ? "" : str;
        }
        str = "";
        if (str != null) {
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0009: INVOKE  (r1v0 long A[REMOVE]) =  type: STATIC call: android.os.SystemClock.elapsedRealtime():long)] */
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(SystemClock.elapsedRealtime());
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, context)) == null) {
            try {
                String w = w(context);
                String t = t();
                if (com.alipay.security.mobile.module.a.a.b(w) && com.alipay.security.mobile.module.a.a.b(t)) {
                    return w + ":" + t();
                }
                return "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
                sb.append("00:");
                for (int i2 = 0; i2 < 7; i2++) {
                    sb.append(new File(strArr[i2]).exists() ? "1" : "0");
                }
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            String[] strArr = {"dalvik.system.Taint"};
            StringBuilder sb = new StringBuilder();
            sb.append("00");
            sb.append(":");
            for (int i2 = 0; i2 <= 0; i2++) {
                try {
                    Class.forName(strArr[0]);
                    sb.append("1");
                } catch (Throwable unused) {
                    sb.append("0");
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, context)) == null) {
            try {
                long j = 0;
                if (((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                    String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
                    for (int i2 = 0; i2 < 5; i2++) {
                        long j2 = -1;
                        try {
                            j2 = new File(strArr[i2]).lastModified();
                        } catch (Throwable unused) {
                        }
                        j = Math.max(j2, j);
                    }
                    return "1:" + j;
                }
                return "0:0";
            } catch (Throwable unused2) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            StringBuilder sb = new StringBuilder();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(SnapshotConstant.DeviceFilePathConstants.DEVICE_BUILD_CONFIG, "ro.product.name=sdk");
            linkedHashMap.put("/proc/tty/drivers", "goldfish");
            linkedHashMap.put("/proc/cpuinfo", "goldfish");
            sb.append("00:");
            for (String str : linkedHashMap.keySet()) {
                LineNumberReader lineNumberReader = null;
                char c2 = '0';
                try {
                    LineNumberReader lineNumberReader2 = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                    while (true) {
                        try {
                            String readLine = lineNumberReader2.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                                c2 = '1';
                                break;
                            }
                        } catch (Throwable unused) {
                            lineNumberReader = lineNumberReader2;
                            sb.append('0');
                            if (lineNumberReader != null) {
                                lineNumberReader.close();
                            }
                        }
                    }
                    sb.append(c2);
                    try {
                        lineNumberReader2.close();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String y(Context context) {
        boolean z;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, context)) == null) {
            try {
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                int intExtra = registerReceiver.getIntExtra("level", -1);
                int intExtra2 = registerReceiver.getIntExtra("status", -1);
                if (intExtra2 != 2 && intExtra2 != 5) {
                    z = false;
                    StringBuilder sb = new StringBuilder();
                    sb.append(!z ? "1" : "0");
                    sb.append(":");
                    sb.append(intExtra);
                    return sb.toString();
                }
                z = true;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(!z ? "1" : "0");
                sb2.append(":");
                sb2.append(intExtra);
                return sb2.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("00:");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("BRAND", "generic");
            linkedHashMap.put("BOARD", "unknown");
            linkedHashMap.put("DEVICE", "generic");
            linkedHashMap.put("HARDWARE", "goldfish");
            linkedHashMap.put("PRODUCT", "sdk");
            linkedHashMap.put("MODEL", "sdk");
            for (String str : linkedHashMap.keySet()) {
                char c2 = '0';
                try {
                    String str2 = (String) Build.class.getField(str).get(null);
                    String str3 = (String) linkedHashMap.get(str);
                    String lowerCase = str2 != null ? str2.toLowerCase() : null;
                    if (lowerCase != null && lowerCase.contains(str3)) {
                        c2 = '1';
                    }
                } catch (Throwable unused) {
                }
                sb.append(c2);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
