package com.baidu.apollon.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
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
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.IDevices;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.tieba.service.AsInstallService;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class PhoneUtils {

    /* renamed from: e  reason: collision with root package name */
    public static final String f4067e = "PhoneUtils";

    /* renamed from: f  reason: collision with root package name */
    public static final String f4068f = "_pay.preferences";

    /* renamed from: g  reason: collision with root package name */
    public static final String f4069g = "cuid_1";

    /* renamed from: h  reason: collision with root package name */
    public static final String f4070h = "cuid_2";

    /* renamed from: i  reason: collision with root package name */
    public static final String f4071i = "wime";
    public static final String j = "identity_code";
    public static final String k = "phone_number";
    public static final String l = "card_no";
    public static final String m = "valid_date";
    public static final String n = "cvv2";
    public static final String o = "imei";
    public static CPUInfo p = null;
    public static final String r = "nettype";
    public static final String s = "wloc";
    public static String t;
    public static String u;
    public static ArrayList<String> q = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f4063a = Pattern.compile("((\\d|[A-F]){32}).*");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f4064b = Pattern.compile("((\\d|[a-f]){32}).*");

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f4065c = Pattern.compile("((\\d|[A-F]){32}).*(\\|.*)");

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f4066d = Pattern.compile("((\\d|[a-f]){32}).*(\\|.*)");

    /* loaded from: classes.dex */
    public static class CPUInfo {
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_ARM_PREFIX = "armv";

        /* renamed from: a  reason: collision with root package name */
        public static final String f4072a = "processor";

        /* renamed from: b  reason: collision with root package name */
        public static final String f4073b = "features";
        public String processor = "";
        public String features = "";

        public String getCpuPath() {
            return this.processor.startsWith("armv7") ? "armeabi-v7a" : this.processor.startsWith("armv") ? "armeabi" : this.processor.equals("intel") ? "x86" : this.processor.equals(IDevices.ABI_MIPS) ? IDevices.ABI_MIPS : "";
        }
    }

    /* loaded from: classes.dex */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    static {
        q.add("card_no");
        q.add("valid_date");
        q.add("cvv2");
        q.add("identity_code");
        q.add("phone_number");
    }

    public static String a(byte b2) {
        String str;
        return ("00" + Integer.toHexString(b2) + ":").substring(str.length() - 3);
    }

    public static void checkPermission(Context context, String str) {
        if (hasPermission(context, str)) {
            return;
        }
        sdkError("You need the " + str + " permission. Open AndroidManifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"" + str + "\" />");
    }

    public static String encrypt(String str, String str2) {
        LogUtil.d(str + "加密=" + str2);
        if (q.contains(str)) {
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            String encryptProxy = SafePay.getInstance().encryptProxy(str2);
            LogUtil.d(str + "加密=" + encryptProxy);
            return encryptProxy;
        }
        return str2;
    }

    public static int getAppVersionCode(Context context) {
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

    public static String getAppVersionName(Context context) {
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

    public static ApplicationInfo getApplicationInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getApplicationName(Context context) {
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

    public static String getAvailMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return Formatter.formatFileSize(context, memoryInfo.availMem) + "_" + memoryInfo.lowMemory + "_" + Formatter.formatFileSize(context, memoryInfo.threshold);
    }

    public static String getCUID(Context context) {
        return a(context);
    }

    public static String getCUID2(Context context) {
        Matcher matcher;
        Matcher matcher2;
        String str;
        String cuid = DeviceId.getCUID(context);
        String str2 = null;
        if (cuid == null) {
            return null;
        }
        if (f4065c.matcher(cuid).matches()) {
            str2 = matcher.group(1) + matcher.group(3);
        }
        if (str2 == null) {
            if (f4066d.matcher(cuid).matches()) {
                str = matcher2.group(1) + matcher2.group(3);
            } else {
                str = "";
            }
            return str;
        }
        return str2;
    }

    public static String getCellLocation(Context context) {
        String format;
        CellLocation cellLocation;
        if (Build.VERSION.SDK_INT >= 29 || !PermissionManager.checkCallingPermission(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        format = String.format("%s_%s_%s", 0, 0, 0);
        try {
            if ((hasPermission(context, "android.permission.ACCESS_FINE_LOCATION") || hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) && (cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation()) != null) {
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return String.format("%s_%s_%s", String.format("%d", Integer.valueOf(gsmCellLocation.getCid())), String.format("%d", Integer.valueOf(gsmCellLocation.getLac())), 0);
                }
                String[] split = cellLocation.toString().replace("[", "").replace("]", "").split(",");
                return split.length > 5 ? String.format("%s_%s_%s", split[0], split[3], split[4]) : format;
            }
            return format;
        } catch (Exception e2) {
            Log.d("getLocation", "exception is " + e2);
        }
        return format;
    }

    public static String getGPSLocation(Context context) {
        try {
            if (hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Location lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("gps");
                LogUtil.d("PhoneUtils", "location: " + lastKnownLocation);
                return lastKnownLocation != null ? String.format("%s:%s", Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude())) : "";
            }
            return "";
        } catch (Exception e2) {
            LogUtil.d("PhoneUtils", "exception is " + e2);
            return "";
        }
    }

    public static String getIpInfo() {
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
                Log.d("PhoneUtils", "getIpInfo fail!" + e2.toString());
            }
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getLinkedWay(Context context) {
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

    public static String getLocalMacAddress() {
        InputStreamReader inputStreamReader;
        StringBuffer stringBuffer = new StringBuffer();
        InputStreamReader inputStreamReader2 = null;
        try {
            char[] cArr = new char[20];
            inputStreamReader = new InputStreamReader(new FileInputStream("/sys/class/net/eth0/address"));
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        if (read != 20 || cArr[19] == '\r') {
                            for (int i2 = 0; i2 < read; i2++) {
                                if (cArr[i2] != '\r') {
                                    stringBuffer.append(cArr[i2]);
                                }
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
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
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                Object obj = bundle != null ? bundle.get(str) : null;
                if (obj == null) {
                    LogUtil.d("StatSDK", "null,can't find information for key:" + str);
                    return "";
                }
                String obj2 = obj.toString();
                if (obj2.trim().equals("")) {
                    LogUtil.w("PhoneUtils", "APP Key值为空||The value of APP Key is empty.");
                }
                return obj2;
            }
            return "";
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("PhoneUtils", "exception is " + e2);
            return "";
        }
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            LogUtil.d("PhoneUtils", "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e2) {
            LogUtil.d("PhoneUtils", "CPU Count: Failed.");
            e2.printStackTrace();
            return 1;
        }
    }

    @SuppressLint({"NewApi"})
    public static String getPhisicalMac(Context context) {
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
        if (bArr != null) {
            for (byte b2 : bArr) {
                stringBuffer.append(a(b2));
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(":", "");
        }
        String wifiMacAddress = getWifiMacAddress(context);
        return wifiMacAddress != null ? wifiMacAddress.replaceAll(":", "") : wifiMacAddress;
    }

    public static CPUInfo getSystemCPUInfo() {
        CPUInfo cPUInfo = p;
        if (cPUInfo != null) {
            return cPUInfo;
        }
        CPUInfo cPUInfo2 = new CPUInfo();
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
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
        p = cPUInfo2;
        return cPUInfo2;
    }

    public static long getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static String getTotalMemory(Context context) {
        long j2 = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            String[] split = readLine.split("\\s+");
            for (String str : split) {
                Log.i(readLine, str + TrackUI.SEPERATOR);
            }
            j2 = Long.valueOf(split[1]).longValue() * 1024;
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return Formatter.formatFileSize(context, j2);
    }

    public static String getWCPParams(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wime", "");
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

    public static String getWifiLocation(Context context) {
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
                    Log.d("PhoneUtils", String.format("[active]%s %s_%s", connectionInfo.getSSID(), connectionInfo.getMacAddress(), Integer.valueOf(Math.abs(connectionInfo.getRssi()))));
                }
            }
        } catch (Exception e2) {
            Log.d("PhoneUtils", "getWifiLocation " + e2);
        }
        return str;
    }

    public static String getWifiMacAddress(Context context) {
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
                Log.d("PhoneUtils", e2.toString());
                return "";
            }
            return "";
        }
    }

    public static boolean hasPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        return PermissionManager.checkCallingPermission(context, str);
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 1).size() > 0;
    }

    public static void sdkError(String str) {
        LogUtil.w("PhoneUtils", str);
        LogUtil.w("PhoneUtils", "SDK install error:" + str);
    }

    @TargetApi(9)
    public static void showInstalledAppOrDetails(Context context, String str) {
        Intent intent = new Intent();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 9) {
            if (!TextUtils.isEmpty(str)) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, str, null));
            } else {
                intent.setAction("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            }
        } else {
            String str2 = i2 == 8 ? "pkg" : "com.android.settings.ApplicationPkgName";
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

    public static String a(Context context) {
        String deviceID = DeviceId.getDeviceID(context);
        if (deviceID == null) {
            return null;
        }
        Matcher matcher = f4063a.matcher(deviceID);
        String group = matcher.matches() ? matcher.group(1) : null;
        if (group == null) {
            Matcher matcher2 = f4064b.matcher(deviceID);
            return matcher2.matches() ? matcher2.group(1) : "";
        }
        return group;
    }
}
