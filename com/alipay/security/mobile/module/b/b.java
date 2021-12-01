package com.alipay.security.mobile.module.b;

import android.app.KeyguardManager;
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
import androidx.webkit.ProxyConfig;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
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
import com.kuaishou.weapon.un.g;
import com.kuaishou.weapon.un.s;
import com.kuaishou.weapon.un.z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
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
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static b a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-920876992, "Lcom/alipay/security/mobile/module/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-920876992, "Lcom/alipay/security/mobile/module/b/b;");
                return;
            }
        }
        a = new b();
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String deviceId;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (a(context, s.f56838c)) {
            return "";
        }
        if (context != null) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
            if (telephonyManager != null) {
                deviceId = telephonyManager.getDeviceId();
                return deviceId != null ? "" : deviceId;
            }
        }
        deviceId = null;
        if (deviceId != null) {
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            return !(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
        }
        return invokeLL.booleanValue;
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a : (b) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String subscriberId;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65541, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (a(context, s.f56838c)) {
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

    public static String c() {
        long j2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                j2 = statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable unused) {
                j2 = 0;
            }
            return String.valueOf(j2);
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            int i2 = 0;
            try {
                i2 = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
            } catch (Throwable unused) {
            }
            return i2 == 1 ? "1" : "0";
        }
        return (String) invokeL.objValue;
    }

    public static String d() {
        long j2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(com.alipay.security.mobile.module.a.a.a().getPath());
                j2 = statFs.getBlockSize() * statFs.getAvailableBlocks();
                return String.valueOf(j2);
            }
            j2 = 0;
            return String.valueOf(j2);
        }
        return (String) invokeV.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
        if (r2 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
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

    public static String e(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String networkOperatorName;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65547, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (context != null) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
            if (telephonyManager != null) {
                networkOperatorName = telephonyManager.getNetworkOperatorName();
                return (networkOperatorName != null || StringUtil.NULL_STRING.equals(networkOperatorName)) ? "" : networkOperatorName;
            }
        }
        networkOperatorName = null;
        if (networkOperatorName != null) {
        }
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            String v = v();
            return !com.alipay.security.mobile.module.a.a.a(v) ? v : w();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String f(Context context) {
        InterceptResult invokeL;
        SensorManager sensorManager;
        List<Sensor> sensorList;
        String e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65549, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (context != null) {
            try {
                sensorManager = (SensorManager) context.getSystemService("sensor");
            } catch (Throwable unused) {
            }
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (Sensor sensor : sensorList) {
                    sb.append(sensor.getName());
                    sb.append(sensor.getVersion());
                    sb.append(sensor.getVendor());
                }
                e2 = com.alipay.security.mobile.module.a.a.e(sb.toString());
                return e2 != null ? "" : e2;
            }
        }
        e2 = null;
        if (e2 != null) {
        }
    }

    public static String g() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65550, null)) != null) {
            return (String) invokeV.objValue;
        }
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2);
                try {
                    String[] split = bufferedReader.readLine().split(":\\s+", 2);
                    if (split != null && split.length > 1) {
                        String str = split[1];
                        try {
                            fileReader2.close();
                        } catch (Throwable unused) {
                        }
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused2) {
                        }
                        return str;
                    }
                    try {
                        fileReader2.close();
                    } catch (Throwable unused3) {
                        try {
                            bufferedReader.close();
                            return "";
                        } catch (Throwable unused4) {
                            return "";
                        }
                    }
                } catch (Throwable unused5) {
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    if (bufferedReader == null) {
                        return "";
                    }
                    bufferedReader.close();
                    return "";
                }
            } catch (Throwable unused7) {
                bufferedReader = null;
            }
        } catch (Throwable unused8) {
            bufferedReader = null;
        }
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        List<Sensor> sensorList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
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

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r0 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        FileReader fileReader;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65552, null)) != null) {
            return (String) invokeV.objValue;
        }
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        try {
            r2 = bufferedReader.readLine() != null ? Integer.parseInt(readLine.split("\\s+")[1]) : 0L;
            try {
                fileReader.close();
            } catch (Throwable unused3) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                }
                return String.valueOf(r2);
            }
        } catch (Throwable unused5) {
            fileReader2 = fileReader;
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (Throwable unused6) {
                }
            }
        }
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                return Integer.toString(displayMetrics.widthPixels) + ProxyConfig.MATCH_ALL_SCHEMES + Integer.toString(displayMetrics.heightPixels);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String i() {
        long j2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                j2 = statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable unused) {
                j2 = 0;
            }
            return String.valueOf(j2);
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0011: IGET  (r4v4 int A[REMOVE]) = (r4v3 android.util.DisplayMetrics) android.util.DisplayMetrics.widthPixels int)] */
    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
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

    public static String j() {
        long j2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                j2 = statFs.getBlockSize() * statFs.getBlockCount();
                return String.valueOf(j2);
            }
            j2 = 0;
            return String.valueOf(j2);
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0011: IGET  (r4v4 int A[REMOVE]) = (r4v3 android.util.DisplayMetrics) android.util.DisplayMetrics.heightPixels int)] */
    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
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

    public static String k() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
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

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            String str = "";
            if (a(context, s.f56839d)) {
                return "";
            }
            try {
                str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                if (str == null || str.length() == 0 || "02:00:00:00:00:00".equals(str)) {
                    return u();
                }
            } catch (Throwable unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            try {
                str = Locale.getDefault().toString();
            } catch (Throwable unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            if (a(context, s.f56838c)) {
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

    public static String m() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                str = TimeZone.getDefault().getDisplayName(false, 0);
            } catch (Throwable unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            try {
                str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable unused) {
                str = "";
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0016: ARITH  (r0v4 long A[REMOVE]) = (r0v3 long) - (wrap: long : 0x0014: ARITH  (r3v1 long A[REMOVE]) = (r0v3 long) % (1000 long)))] */
    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
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

    public static String n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0009: INVOKE  (r1v0 long A[REMOVE]) =  type: STATIC call: android.os.SystemClock.elapsedRealtime():long)] */
    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String o(Context context) {
        InterceptResult invokeL;
        String str;
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65567, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (a(context, s.f56839d)) {
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

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0025 -> B:15:0x0025). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String p(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65569, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29) {
            str = "";
            return str != null ? "" : str;
        }
        str = (Build.VERSION.SDK_INT < 26 || i2 < 28) ? Build.SERIAL : Build.getSerial();
        if (str != null) {
        }
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
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

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            try {
                String t = t(context);
                String x = x();
                if (com.alipay.security.mobile.module.a.a.b(t) && com.alipay.security.mobile.module.a.a.b(x)) {
                    return t + ":" + x();
                }
            } catch (Throwable unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
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

    public static String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            try {
                long j2 = 0;
                if (((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                    String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
                    for (int i2 = 0; i2 < 5; i2++) {
                        long j3 = -1;
                        try {
                            j3 = new File(strArr[i2]).lastModified();
                        } catch (Throwable unused) {
                        }
                        j2 = Math.max(j3, j2);
                    }
                    return "1:" + j2;
                }
                return "0:0";
            } catch (Throwable unused2) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String s(Context context) {
        boolean z;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
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

    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
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
            linkedHashMap.put(g.q, "unknow");
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

    public static String t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
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
                    return (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) ? "2G" : (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "UNKNOW";
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            try {
                ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
                if (list != null) {
                    for (NetworkInterface networkInterface : list) {
                        if (networkInterface != null && networkInterface.getName() != null && networkInterface.getName().equalsIgnoreCase("wlan0")) {
                            byte[] hardwareAddress = networkInterface.getHardwareAddress();
                            if (hardwareAddress == null) {
                                return "02:00:00:00:00:00";
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
                    return "02:00:00:00:00:00";
                }
                return "02:00:00:00:00:00";
            } catch (Throwable unused) {
                return "02:00:00:00:00:00";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String v() {
        InterceptResult invokeV;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                fileReader = new FileReader(z.f56920b);
                try {
                    bufferedReader = new BufferedReader(fileReader, 8192);
                    try {
                        readLine = bufferedReader.readLine();
                    } catch (Throwable unused) {
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (fileReader == null) {
                            return "";
                        }
                        try {
                            fileReader.close();
                            return "";
                        } catch (Throwable unused3) {
                            return "";
                        }
                    }
                } catch (Throwable unused4) {
                }
            } catch (Throwable unused5) {
                fileReader = null;
            }
            if (com.alipay.security.mobile.module.a.a.a(readLine)) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused6) {
                }
                fileReader.close();
                return "";
            }
            String trim = readLine.trim();
            try {
                bufferedReader.close();
            } catch (Throwable unused7) {
            }
            try {
                fileReader.close();
            } catch (Throwable unused8) {
            }
            return trim;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        r1 = r2[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
        if (r0 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String w() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        FileReader fileReader;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65580, null)) != null) {
            return (String) invokeV.objValue;
        }
        String str = "";
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!com.alipay.security.mobile.module.a.a.a(readLine) && (split = readLine.split(":")) != null && split.length > 1 && split[0].contains("BogoMIPS")) {
                                break;
                            }
                        }
                    } catch (Throwable unused) {
                        fileReader2 = fileReader;
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
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
            fileReader.close();
        } catch (Throwable unused5) {
            try {
                bufferedReader.close();
            } catch (Throwable unused6) {
            }
            return str;
        }
    }

    public static String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
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

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
            } catch (Throwable unused) {
                return "1";
            }
        }
        return (String) invokeV.objValue;
    }
}
