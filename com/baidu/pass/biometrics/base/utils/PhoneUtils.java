package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.pass.biometrics.base.debug.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public final class PhoneUtils {
    private static final String IMEI = "imei";
    private static final String KEY_CARD_NO = "card_no";
    private static final String KEY_CVV2 = "cvv2";
    private static final String KEY_IDENTITY_CODE = "identity_code";
    private static final String KEY_PHONE_NUMBER = "phone_number";
    private static final String KEY_VALID_DATE = "valid_date";
    private static final String PREFERENCES_NAME = "bio_base_phone.preferences";
    private static final String TAG = "PhoneUtils";
    private static CPUInfo systemCPUInfo = null;
    private static ArrayList<String> keys = new ArrayList<>();

    static {
        keys.add(KEY_CARD_NO);
        keys.add(KEY_VALID_DATE);
        keys.add(KEY_CVV2);
        keys.add(KEY_IDENTITY_CODE);
        keys.add(KEY_PHONE_NUMBER);
    }

    private PhoneUtils() {
    }

    public static final String getImei(Context context) {
        String deviceId;
        if (!PassBiometricUtil.checkRequestPermission(context, "android.permission.READ_PHONE_STATE")) {
            return makeImei(context);
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            deviceId = makeImei(context);
        } else {
            deviceId = telephonyManager.getDeviceId();
            if (deviceId == null || deviceId.length() < 2) {
                deviceId = makeImei(context);
            } else {
                int length = deviceId.length();
                char charAt = deviceId.charAt(0);
                int i = 1;
                while (i < length && charAt == deviceId.charAt(i)) {
                    i++;
                }
                if (i >= length) {
                    deviceId = makeImei(context);
                }
            }
        }
        Log.d(TAG, "imei=" + deviceId + "#len=" + deviceId.length());
        return deviceId;
    }

    private static final String makeImei(Context context) {
        String str = (String) SharedPreferencesUtils.getParam(context, PREFERENCES_NAME, IMEI, "");
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
            }
            Log.d(TAG, "makeImei :: " + upperCase + " # " + length);
            int length2 = upperCase.length();
            for (int i = length2 - 1; i >= length2 - 6; i--) {
                stringBuffer.append(upperCase.charAt(i));
            }
            for (int length3 = stringBuffer.length(); length3 < 15; length3++) {
                stringBuffer.append((char) (random.nextInt(10) | 48));
            }
            SharedPreferencesUtils.setParam(context, PREFERENCES_NAME, IMEI, stringBuffer.toString());
            return stringBuffer.toString();
        }
        Log.d(TAG, "从文件里面获取imei号=" + str);
        return str;
    }

    public static String getImsi(Context context) {
        TelephonyManager telephonyManager;
        if (PassBiometricUtil.checkRequestPermission(context, "android.permission.READ_PHONE_STATE") && (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone")) != null) {
            String subscriberId = telephonyManager.getSubscriberId();
            if (!TextUtils.isEmpty(subscriberId)) {
                return subscriberId;
            }
        }
        return "";
    }

    public static CPUInfo getSystemCPUInfo() {
        if (systemCPUInfo != null) {
            return systemCPUInfo;
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        systemCPUInfo = cPUInfo;
        return cPUInfo;
    }

    public static int getNumCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.baidu.pass.biometrics.base.utils.PhoneUtils.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static boolean hasPermission(Context context, String str) {
        return (context == null || context.checkCallingPermission(str) == -1) ? false : true;
    }

    public static String getGPSLocation(Context context) {
        Location lastKnownLocation;
        try {
            if (hasPermission(context, "android.permission.ACCESS_FINE_LOCATION") && (lastKnownLocation = ((LocationManager) context.getSystemService(Headers.LOCATION)).getLastKnownLocation("gps")) != null) {
                return String.format("%s:%s", Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude()));
            }
        } catch (Exception e) {
            Log.e(e);
        }
        return "";
    }

    public static String getCUID2(Context context) {
        return DeviceId.getCUID(context);
    }

    public static String getCUID(Context context) {
        return getDeviceId(context);
    }

    private static String getDeviceId(Context context) {
        return DeviceId.getDeviceID(context);
    }

    public static String getLineNum(Context context) {
        TelephonyManager telephonyManager;
        if (PassBiometricUtil.checkRequestPermission(context, "android.permission.READ_PHONE_STATE") && (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone")) != null) {
            String line1Number = telephonyManager.getLine1Number();
            if (!TextUtils.isEmpty(line1Number)) {
                return line1Number;
            }
        }
        return "";
    }

    public static String getSimSerialNum(Context context) {
        TelephonyManager telephonyManager;
        if (PassBiometricUtil.checkRequestPermission(context, "android.permission.READ_PHONE_STATE") && (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone")) != null) {
            String simSerialNumber = telephonyManager.getSimSerialNumber();
            Log.d(TAG, "serialNum = " + simSerialNumber);
            if (!TextUtils.isEmpty(simSerialNumber)) {
                return simSerialNumber;
            }
        }
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
                            int i = (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
                            str = (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
                            break;
                        }
                    }
                }
                str2 = str;
            }
        } catch (Exception e) {
            Log.d(TAG, "getIpInfo fail!" + e.toString());
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }

    public static long getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    /* loaded from: classes2.dex */
    public static class CPUInfo {
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        private static final String PREFIX_FEATURES = "features";
        private static final String PREFIX_PROCESSOR = "processor";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_ARM_PREFIX = "armv";
        public String processor = "";
        public String features = "";

        public String getCpuPath() {
            if (this.processor.startsWith(PROCESSOR_ARMV7)) {
                return PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
            }
            if (this.processor.startsWith(PROCESSOR_ARM_PREFIX)) {
                return PassBiometricUtil.CPU_TYPE_ARMEABI;
            }
            if (this.processor.equals("intel")) {
                return PassBiometricUtil.CPU_TYPE_X86;
            }
            if (this.processor.equals("mips")) {
                return "mips";
            }
            return "";
        }
    }
}
