package com.baidu.fsg.base.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.IDevices;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class PhoneUtils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f38417a = "PhoneUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final String f38418b = "_rim_pay.preferences";

    /* renamed from: c  reason: collision with root package name */
    public static final String f38419c = "cuid_1";

    /* renamed from: d  reason: collision with root package name */
    public static final String f38420d = "cuid_2";

    /* renamed from: e  reason: collision with root package name */
    public static final String f38421e = "wime";

    /* renamed from: f  reason: collision with root package name */
    public static final String f38422f = "identity_code";

    /* renamed from: g  reason: collision with root package name */
    public static final String f38423g = "phone_number";

    /* renamed from: h  reason: collision with root package name */
    public static final String f38424h = "card_no";

    /* renamed from: i  reason: collision with root package name */
    public static final String f38425i = "valid_date";
    public static final String j = "cvv2";
    public static final String k = "imei";
    public static final String l = "nettype";
    public static final String m = "wloc";
    public static CPUInfo n;
    public static ArrayList<String> o;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class CPUInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_ARM_PREFIX = "armv";

        /* renamed from: a  reason: collision with root package name */
        public static final String f38426a = "processor";

        /* renamed from: b  reason: collision with root package name */
        public static final String f38427b = "features";
        public transient /* synthetic */ FieldHolder $fh;
        public String features;
        public String processor;

        public CPUInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.processor = "";
            this.features = "";
        }

        public String getCpuPath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.processor.startsWith("armv7") ? "armeabi-v7a" : this.processor.startsWith("armv") ? "armeabi" : this.processor.equals("intel") ? "x86" : this.processor.equals(IDevices.ABI_MIPS) ? IDevices.ABI_MIPS : "" : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(810930815, "Lcom/baidu/fsg/base/utils/PhoneUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(810930815, "Lcom/baidu/fsg/base/utils/PhoneUtils;");
                return;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        o = arrayList;
        arrayList.add("card_no");
        o.add("valid_date");
        o.add("cvv2");
        o.add("identity_code");
        o.add("phone_number");
    }

    public PhoneUtils() {
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

    public static String a(byte b2) {
        InterceptResult invokeB;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) {
            return ("00" + Integer.toHexString(b2) + ":").substring(str.length() - 3);
        }
        return (String) invokeB.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? DeviceId.getDeviceID(context) : (String) invokeL.objValue;
    }

    public static final String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String str = (String) SharedPreferencesUtils.getParam(context, f38418b, "imei", "");
            if (!TextUtils.isEmpty(str)) {
                if (ApollonConstants.DEBUG) {
                    String str2 = "从文件里面获取imei号=" + str;
                }
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("BAIDU");
            long currentTimeMillis = System.currentTimeMillis();
            String upperCase = Long.toHexString(currentTimeMillis).toUpperCase(Locale.ENGLISH);
            int length = upperCase.length();
            Random random = new Random(currentTimeMillis);
            if (length < 7) {
                while (length < 7) {
                    upperCase = upperCase + ((char) (random.nextInt(10) | 48));
                    length++;
                }
                random = null;
            }
            if (ApollonConstants.DEBUG) {
                String str3 = "makeImei :: " + upperCase + " # " + length;
            }
            int length2 = upperCase.length();
            for (int i2 = length2 - 1; i2 >= length2 - 6; i2--) {
                stringBuffer.append(upperCase.charAt(i2));
            }
            for (int length3 = stringBuffer.length(); length3 < 15; length3++) {
                stringBuffer.append((char) (random.nextInt(10) | 48));
            }
            SharedPreferencesUtils.setParam(context, f38418b, "imei", stringBuffer.toString());
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void checkPermission(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str) == null) || hasPermission(context, str)) {
            return;
        }
        sdkError("You need the " + str + " permission. Open AndroidManifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"" + str + "\" />");
    }

    public static String encrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            LogUtil.d(str + "加密=" + str2);
            if (o.contains(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return "";
                }
                String encryptProxy = RimArmor.getInstance().encryptProxy(str2);
                LogUtil.d(str + "加密=" + encryptProxy);
                return encryptProxy;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static int getAppVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable unused) {
                LogUtil.w("PhoneUtils", "get app version code exception");
                return 1;
            }
        }
        return invokeL.intValue;
    }

    public static String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context == null) {
                return "";
            }
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable unused) {
                LogUtil.w("PhoneUtils", "get app version name exception");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static ApplicationInfo getApplicationInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (ApplicationInfo) invokeL.objValue;
    }

    public static String getApplicationName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context == null) {
                return "";
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getAvailMemory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return Formatter.formatFileSize(context, memoryInfo.availMem) + "_" + memoryInfo.lowMemory + "_" + Formatter.formatFileSize(context, memoryInfo.threshold);
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static String getBluetoothMac() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    return defaultAdapter.getAddress();
                }
            } catch (Exception e2) {
                String str = "exception is " + e2;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String getCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? a(context) : (String) invokeL.objValue;
    }

    public static String getCUID2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? DeviceId.getCUID(context) : (String) invokeL.objValue;
    }

    public static String getCellLocation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static String getGPSLocation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static final String getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) ? b(context) : (String) invokeL.objValue;
    }

    public static String getImsi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static String getIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            String str = null;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress()) {
                                byte[] address = nextElement.getAddress();
                                if (address.length == 4) {
                                    int i2 = ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8) | (address[0] & 255);
                                    str = (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                if (ApollonConstants.DEBUG) {
                    String str2 = "getIpInfo fail!" + e2.toString();
                }
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public static String getLineNum(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static String getLinkedWay(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
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

    public static String getLocalMacAddress() {
        InterceptResult invokeV;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65558, null)) != null) {
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
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } else if (read != 20 || cArr[19] == '\r') {
                        for (int i2 = 0; i2 < read; i2++) {
                            if (cArr[i2] != '\r') {
                                stringBuffer.append(cArr[i2]);
                            }
                        }
                    }
                } catch (Exception unused) {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            inputStreamReader.close();
            return stringBuffer.toString().trim().replaceAll(":", "");
        } catch (Exception unused2) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getMetaData(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    Bundle bundle = applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get(str) : null;
                    if (obj != null) {
                        String obj2 = obj.toString();
                        obj2.trim().equals("");
                        return obj2;
                    }
                    LogUtil.d("StatSDK", "null,can't find information for key:" + str);
                    return "";
                }
                return "";
            } catch (PackageManager.NameNotFoundException e2) {
                String str2 = "exception is " + e2;
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static int getNumCores() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.baidu.fsg.base.utils.PhoneUtils.1CpuFilter
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

                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? Pattern.matches("cpu[0-9]", file.getName()) : invokeL.booleanValue;
                    }
                });
                StringBuilder sb = new StringBuilder();
                sb.append("CPU Count: ");
                sb.append(listFiles.length);
                LogUtil.d("PhoneUtils", sb.toString());
                return listFiles.length;
            } catch (Exception e2) {
                LogUtil.d("PhoneUtils", "CPU Count: Failed.");
                e2.printStackTrace();
                return 1;
            }
        }
        return invokeV.intValue;
    }

    @SuppressLint({"NewApi"})
    public static String getPhisicalMac(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
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
            } catch (SocketException e2) {
                e2.printStackTrace();
            }
            if (bArr == null) {
                String wifiMacAddress = getWifiMacAddress(context);
                return wifiMacAddress != null ? wifiMacAddress.replaceAll(":", "") : wifiMacAddress;
            }
            for (byte b2 : bArr) {
                stringBuffer.append(a(b2));
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(":", "");
        }
        return (String) invokeL.objValue;
    }

    public static String getSimSerialNum(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static CPUInfo getSystemCPUInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            CPUInfo cPUInfo = n;
            if (cPUInfo != null) {
                return cPUInfo;
            }
            CPUInfo cPUInfo2 = new CPUInfo();
            try {
                FileReader fileReader = new FileReader("/proc/cpuinfo");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String lowerCase = readLine.trim().toLowerCase(Locale.ENGLISH);
                    if (lowerCase.startsWith("processor") && lowerCase.indexOf(":", 9) != -1) {
                        if (cPUInfo2.processor.length() > 0) {
                            cPUInfo2.processor += "__";
                        }
                        cPUInfo2.processor += lowerCase.split(":")[1].trim();
                    } else if (lowerCase.startsWith("features") && lowerCase.indexOf(":", 8) != -1) {
                        if (cPUInfo2.features.length() > 0) {
                            cPUInfo2.features += "__";
                        }
                        cPUInfo2.features += lowerCase.split(":")[1].trim();
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            n = cPUInfo2;
            return cPUInfo2;
        }
        return (CPUInfo) invokeV.objValue;
    }

    public static long getTotalInternalMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        }
        return invokeV.longValue;
    }

    public static String getTotalMemory(Context context) {
        InterceptResult invokeL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                String[] split = bufferedReader.readLine().split("\\s+");
                for (String str : split) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(TrackUI.SEPERATOR);
                    sb.toString();
                }
                j2 = Long.valueOf(split[1]).longValue() * 1024;
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                j2 = 0;
            }
            return Formatter.formatFileSize(context, j2);
        }
        return (String) invokeL.objValue;
    }

    public static String getWCPParams(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wime", encrypt("phone_number", getImei(context)));
                jSONObject.put("cuid_1", encrypt("phone_number", getCUID(context)));
                jSONObject.put("cuid_2", encrypt("phone_number", getCUID2(context)));
                jSONObject.put("nettype", NetworkUtils.getNetworkType(context));
                jSONObject.put("wloc", encrypt("phone_number", getGPSLocation(context)));
                return new String(Base64Utils.encode(jSONObject.toString().getBytes()));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getWifiLocation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            String str = "";
            try {
                if (hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager.isWifiEnabled()) {
                        int i2 = Integer.MAX_VALUE;
                        int i3 = -1;
                        for (int i4 = 0; i4 < wifiManager.getScanResults().size(); i4++) {
                            ScanResult scanResult = wifiManager.getScanResults().get(i4);
                            int abs = Math.abs(scanResult.level);
                            LogUtil.d("PhoneUtils", String.format("%s %s_%s", scanResult.SSID, scanResult.BSSID, Integer.valueOf(abs)));
                            if (i2 > abs) {
                                i3 = i4;
                                i2 = abs;
                            }
                        }
                        if (i3 >= 0) {
                            ScanResult scanResult2 = wifiManager.getScanResults().get(i3);
                            str = String.format("%s_%s", scanResult2.BSSID.replace(":", "").toLowerCase(Locale.ENGLISH), Integer.valueOf(Math.abs(scanResult2.level)));
                        }
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        String.format("[active]%s %s_%s", connectionInfo.getSSID(), connectionInfo.getMacAddress(), Integer.valueOf(Math.abs(connectionInfo.getRssi())));
                    }
                }
            } catch (Exception e2) {
                String str2 = "getWifiLocation " + e2;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String getWifiMacAddress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    LogUtil.d("PhoneUtils", String.format("ssid=%s mac=%s", connectionInfo.getSSID(), connectionInfo.getMacAddress()));
                    return connectionInfo.getMacAddress();
                }
                return "";
            } catch (Exception e2) {
                if (ApollonConstants.DEBUG) {
                    e2.toString();
                    return "";
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean hasPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, context, str)) == null) ? (context == null || context.checkCallingPermission(str) == -1) ? false : true : invokeLL.booleanValue;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, context, intent)) == null) ? context.getPackageManager().queryIntentActivities(intent, 1).size() > 0 : invokeLL.booleanValue;
    }

    public static void sdkError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, str) == null) {
            LogUtil.w("PhoneUtils", str);
            LogUtil.w("PhoneUtils", "SDK install error:" + str);
        }
    }

    @TargetApi(9)
    public static void showInstalledAppOrDetails(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65572, null, context, str) == null) {
            Intent intent = new Intent();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 9) {
                String str2 = i2 == 8 ? "pkg" : "com.android.settings.ApplicationPkgName";
                intent.setAction("android.intent.action.VIEW");
                if (TextUtils.isEmpty(str)) {
                    intent.setClassName("com.android.settings", "com.android.settings.ManageApplications");
                } else {
                    intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                    intent.putExtra(str2, str);
                }
            } else if (TextUtils.isEmpty(str)) {
                intent.setAction("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            } else {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", str, null));
            }
            if (isIntentAvailable(context, intent)) {
                context.startActivity(intent);
            }
        }
    }
}
