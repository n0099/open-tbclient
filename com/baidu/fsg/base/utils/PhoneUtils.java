package com.baidu.fsg.base.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.IDevices;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
/* loaded from: classes15.dex */
public final class PhoneUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1519a = "PhoneUtils";
    private static final String b = "_rim_pay.preferences";
    private static final String c = "cuid_1";
    private static final String d = "cuid_2";
    private static final String e = "wime";
    private static final String f = "identity_code";
    private static final String g = "phone_number";
    private static final String h = "card_no";
    private static final String i = "valid_date";
    private static final String j = "cvv2";
    private static final String k = "imei";
    private static final String l = "nettype";
    private static final String m = "wloc";
    private static CPUInfo n = null;
    private static ArrayList<String> o = new ArrayList<>();

    static {
        o.add("card_no");
        o.add("valid_date");
        o.add("cvv2");
        o.add("identity_code");
        o.add("phone_number");
    }

    private PhoneUtils() {
    }

    public static final String getImei(Context context) {
        return a(context);
    }

    private static final String a(Context context) {
        String str = (String) SharedPreferencesUtils.getParam(context, b, "imei", "");
        if (TextUtils.isEmpty(str)) {
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
                Log.d(f1519a, "makeImei :: " + upperCase + " # " + length);
            }
            int length2 = upperCase.length();
            for (int i2 = length2 - 1; i2 >= length2 - 6; i2--) {
                stringBuffer.append(upperCase.charAt(i2));
            }
            for (int length3 = stringBuffer.length(); length3 < 15; length3++) {
                stringBuffer.append((char) (random.nextInt(10) | 48));
            }
            SharedPreferencesUtils.setParam(context, b, "imei", stringBuffer.toString());
            return stringBuffer.toString();
        } else if (ApollonConstants.DEBUG) {
            Log.d(f1519a, "从文件里面获取imei号=" + str);
            return str;
        } else {
            return str;
        }
    }

    public static String getImsi(Context context) {
        return "";
    }

    public static CPUInfo getSystemCPUInfo() {
        if (n != null) {
            return n;
        }
        CPUInfo cPUInfo = new CPUInfo();
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                String lowerCase = readLine.trim().toLowerCase(Locale.ENGLISH);
                if (lowerCase.startsWith("processor") && lowerCase.indexOf(":", "processor".length()) != -1) {
                    if (cPUInfo.processor.length() > 0) {
                        cPUInfo.processor += "__";
                    }
                    cPUInfo.processor += lowerCase.split(":")[1].trim();
                } else if (lowerCase.startsWith("features") && lowerCase.indexOf(":", "features".length()) != -1) {
                    if (cPUInfo.features.length() > 0) {
                        cPUInfo.features += "__";
                    }
                    cPUInfo.features += lowerCase.split(":")[1].trim();
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        n = cPUInfo;
        return cPUInfo;
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.baidu.fsg.base.utils.PhoneUtils.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            });
            LogUtil.d(f1519a, "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e2) {
            LogUtil.d(f1519a, "CPU Count: Failed.");
            e2.printStackTrace();
            return 1;
        }
    }

    public static String getMetaData(Context context, String str) {
        String str2 = "";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = null;
                if (applicationInfo.metaData != null) {
                    obj = applicationInfo.metaData.get(str);
                }
                if (obj == null) {
                    LogUtil.d("StatSDK", "null,can't find information for key:" + str);
                } else {
                    str2 = obj.toString();
                    if (str2.trim().equals("")) {
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(f1519a, "exception is " + e2);
        }
        return str2;
    }

    public static String getApplicationName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (Throwable th) {
            return "";
        }
    }

    public static ApplicationInfo getApplicationInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Throwable th) {
            return null;
        }
    }

    public static int getAppVersionCode(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            LogUtil.w(f1519a, "get app version code exception");
            return 1;
        }
    }

    public static String getAppVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            LogUtil.w(f1519a, "get app version name exception");
            return "";
        }
    }

    public static void checkPermission(Context context, String str) {
        if (!hasPermission(context, str)) {
            sdkError("You need the " + str + " permission. Open AndroidManifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"" + str + "\" />");
        }
    }

    public static boolean hasPermission(Context context, String str) {
        return (context == null || context.checkCallingPermission(str) == -1) ? false : true;
    }

    public static void sdkError(String str) {
        LogUtil.w(f1519a, str);
        LogUtil.w(f1519a, "SDK install error:" + str);
    }

    public static String getWifiMacAddress(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                LogUtil.d(f1519a, String.format("ssid=%s mac=%s", connectionInfo.getSSID(), connectionInfo.getMacAddress()));
                return connectionInfo.getMacAddress();
            }
        } catch (Exception e2) {
            if (ApollonConstants.DEBUG) {
                Log.d(f1519a, e2.toString());
            }
        }
        return "";
    }

    @SuppressLint({"NewApi"})
    public static String getPhisicalMac(Context context) {
        byte[] bArr;
        byte[] bArr2 = null;
        StringBuffer stringBuffer = new StringBuffer();
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
                                bArr2 = nextElement.getHardwareAddress();
                                break;
                            } else {
                                bArr = bArr2;
                            }
                            bArr2 = bArr;
                        }
                    }
                }
            }
        } catch (SocketException e2) {
            e2.printStackTrace();
        }
        if (bArr2 != null) {
            for (byte b2 : bArr2) {
                stringBuffer.append(a(b2));
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(":", "");
        }
        String wifiMacAddress = getWifiMacAddress(context);
        if (wifiMacAddress != null) {
            return wifiMacAddress.replaceAll(":", "");
        }
        return wifiMacAddress;
    }

    private static String a(byte b2) {
        String str;
        return ("00" + Integer.toHexString(b2) + ":").substring(str.length() - 3);
    }

    public static String getLocalMacAddress() {
        InputStreamReader inputStreamReader;
        Throwable th;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            char[] cArr = new char[20];
            inputStreamReader = new InputStreamReader(new FileInputStream("/sys/class/net/eth0/address"));
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    } else if (read != cArr.length || cArr[cArr.length - 1] == '\r') {
                        for (int i2 = 0; i2 < read; i2++) {
                            if (cArr[i2] != '\r') {
                                stringBuffer.append(cArr[i2]);
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                            return null;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return stringBuffer.toString().trim().replaceAll(":", "");
        } catch (Exception e6) {
            inputStreamReader = null;
        } catch (Throwable th3) {
            inputStreamReader = null;
            th = th3;
        }
    }

    @SuppressLint({"NewApi"})
    public static String getBluetoothMac() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                return "";
            }
            return defaultAdapter.getAddress();
        } catch (Exception e2) {
            Log.d(f1519a, "exception is " + e2);
            return "";
        }
    }

    public static String getCellLocation(Context context) {
        return "";
    }

    public static String getGPSLocation(Context context) {
        try {
            if (hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Location lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("gps");
                LogUtil.d(f1519a, "location: " + lastKnownLocation);
                if (lastKnownLocation != null) {
                    return String.format("%s:%s", Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude()));
                }
            }
        } catch (Exception e2) {
            LogUtil.d(f1519a, "exception is " + e2);
        }
        return "";
    }

    public static String getWifiLocation(Context context) {
        Exception exc;
        String str;
        String str2;
        int i2;
        int i3;
        int i4 = 0;
        try {
            if (hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    int i5 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    int i6 = -1;
                    while (i4 < wifiManager.getScanResults().size()) {
                        ScanResult scanResult = wifiManager.getScanResults().get(i4);
                        int abs = Math.abs(scanResult.level);
                        LogUtil.d(f1519a, String.format("%s %s_%s", scanResult.SSID, scanResult.BSSID, Integer.valueOf(abs)));
                        if (i5 > abs) {
                            i2 = i4;
                            i3 = abs;
                        } else {
                            i2 = i6;
                            i3 = i5;
                        }
                        i4++;
                        i5 = i3;
                        i6 = i2;
                    }
                    if (i6 < 0) {
                        str2 = "";
                    } else {
                        ScanResult scanResult2 = wifiManager.getScanResults().get(i6);
                        str2 = String.format("%s_%s", scanResult2.BSSID.replace(":", "").toLowerCase(Locale.ENGLISH), Integer.valueOf(Math.abs(scanResult2.level)));
                    }
                    try {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        Log.d(f1519a, String.format("[active]%s %s_%s", connectionInfo.getSSID(), connectionInfo.getMacAddress(), Integer.valueOf(Math.abs(connectionInfo.getRssi()))));
                        return str2;
                    } catch (Exception e2) {
                        str = str2;
                        exc = e2;
                        Log.d(f1519a, "getWifiLocation " + exc);
                        return str;
                    }
                }
            }
            return "";
        } catch (Exception e3) {
            exc = e3;
            str = "";
        }
    }

    public static String getLinkedWay(Context context) {
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            String typeName = activeNetworkInfo.getTypeName();
            try {
                if (!typeName.equals("WIFI") && activeNetworkInfo.getSubtypeName() != null) {
                    return activeNetworkInfo.getSubtypeName();
                }
                return typeName;
            } catch (Exception e2) {
                return str;
            }
        } catch (Exception e3) {
            return "";
        }
    }

    public static String getCUID2(Context context) {
        return DeviceId.getCUID(context);
    }

    public static String getCUID(Context context) {
        return b(context);
    }

    private static String b(Context context) {
        return DeviceId.getDeviceID(context);
    }

    public static String getTotalMemory(Context context) {
        long j2 = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            String[] split = readLine.split("\\s+");
            int length = split.length;
            for (int i2 = 0; i2 < length; i2++) {
                Log.i(readLine, split[i2] + "\t");
            }
            j2 = Long.valueOf(split[1]).longValue() * 1024;
            bufferedReader.close();
        } catch (IOException e2) {
        }
        return Formatter.formatFileSize(context, j2);
    }

    public static String getAvailMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return Formatter.formatFileSize(context, memoryInfo.availMem) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + memoryInfo.lowMemory + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Formatter.formatFileSize(context, memoryInfo.threshold);
    }

    public static String getLineNum(Context context) {
        return "";
    }

    public static String getSimSerialNum(Context context) {
        return "";
    }

    public static String getIpInfo() {
        String str;
        String str2 = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        str = str2;
                        break;
                    }
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        byte[] address = nextElement.getAddress();
                        if (address.length == 4) {
                            int i2 = (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
                            str = (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
                            break;
                        }
                    }
                }
                str2 = str;
            }
        } catch (Exception e2) {
            if (ApollonConstants.DEBUG) {
                Log.d(f1519a, "getIpInfo fail!" + e2.toString());
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }

    @TargetApi(9)
    public static void showInstalledAppOrDetails(Context context, String str) {
        String str2 = Config.INPUT_DEF_PKG;
        Intent intent = new Intent();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 9) {
            if (!TextUtils.isEmpty(str)) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", str, null));
            } else {
                intent.setAction("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            }
        } else {
            if (i2 != 8) {
                str2 = "com.android.settings.ApplicationPkgName";
            }
            intent.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(str)) {
                intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent.putExtra(str2, str);
            } else {
                intent.setClassName("com.android.settings", "com.android.settings.ManageApplications");
            }
        }
        if (isIntentAvailable(context, intent)) {
            context.startActivity(intent);
        }
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 1).size() > 0;
    }

    public static long getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static String getWCPParams(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(e, encrypt("phone_number", getImei(context)));
            jSONObject.put(c, encrypt("phone_number", getCUID(context)));
            jSONObject.put(d, encrypt("phone_number", getCUID2(context)));
            jSONObject.put(l, NetworkUtils.getNetworkType(context));
            jSONObject.put(m, encrypt("phone_number", getGPSLocation(context)));
            return new String(Base64Utils.encode(jSONObject.toString().getBytes()));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        LogUtil.d(str + "加密=" + str2);
        if (o.contains(str)) {
            if (!TextUtils.isEmpty(str2)) {
                String encryptProxy = RimArmor.getInstance().encryptProxy(str2);
                LogUtil.d(str + "加密=" + encryptProxy);
                return encryptProxy;
            }
            return "";
        }
        return str2;
    }

    /* loaded from: classes15.dex */
    public static class CPUInfo {
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_ARM_PREFIX = "armv";

        /* renamed from: a  reason: collision with root package name */
        private static final String f1520a = "processor";
        private static final String b = "features";
        public String processor = "";
        public String features = "";

        public String getCpuPath() {
            if (this.processor.startsWith("armv7")) {
                return "armeabi-v7a";
            }
            if (this.processor.startsWith(PROCESSOR_ARM_PREFIX)) {
                return "armeabi";
            }
            if (this.processor.equals("intel")) {
                return "x86";
            }
            if (this.processor.equals(IDevices.ABI_MIPS)) {
                return IDevices.ABI_MIPS;
            }
            return "";
        }
    }
}
