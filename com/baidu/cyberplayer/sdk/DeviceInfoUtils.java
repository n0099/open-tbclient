package com.baidu.cyberplayer.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.baidu.pass.main.facesdk.statistic.DeviceInfoUtil;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
@Keep
/* loaded from: classes2.dex */
public class DeviceInfoUtils {
    public static String a;
    public static String b;

    public static String getAvailMemorySize() {
        ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.availMem / 1000);
        }
        return null;
    }

    public static String getBatteryHealth() {
        Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return String.valueOf(registerReceiver.getIntExtra("health", 1));
        }
        return null;
    }

    public static String[] getBatteryInfos() {
        Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        String[] strArr = new String[7];
        if (registerReceiver != null) {
            strArr[0] = String.valueOf(registerReceiver.getIntExtra("health", 1));
            strArr[1] = String.valueOf(registerReceiver.getIntExtra("status", 1));
            strArr[2] = String.valueOf(registerReceiver.getIntExtra("level", 0));
            strArr[3] = String.valueOf(registerReceiver.getIntExtra("scale", 0));
            strArr[4] = String.valueOf(registerReceiver.getIntExtra("voltage", 0));
            strArr[5] = String.valueOf(registerReceiver.getIntExtra("temperature", 0));
            strArr[6] = registerReceiver.getStringExtra("technology");
            return strArr;
        }
        return null;
    }

    public static String getBatteryLevel() {
        Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return String.valueOf(registerReceiver.getIntExtra("level", 0));
        }
        return null;
    }

    public static String getBatteryScale() {
        Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return String.valueOf(registerReceiver.getIntExtra("scale", 0));
        }
        return null;
    }

    public static String getBatteryStatus() {
        Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return String.valueOf(registerReceiver.getIntExtra("status", 1));
        }
        return null;
    }

    public static String getBatteryTechnology() {
        Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getStringExtra("technology");
        }
        return null;
    }

    public static String getBatteryTemperature() {
        Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return String.valueOf(registerReceiver.getIntExtra("temperature", 0));
        }
        return null;
    }

    public static String getBatteryVoltage() {
        Intent registerReceiver = CyberPlayerManager.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return String.valueOf(registerReceiver.getIntExtra("voltage", 0));
        }
        return null;
    }

    public static String getCurCpuFreq() {
        try {
            return new BufferedReader(new FileReader(DeviceInfoUtil.CurPath)).readLine().trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getDeviceBoard() {
        return Build.BOARD;
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static int getDeviceDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static String getDeviceDevice() {
        return Build.DEVICE;
    }

    public static String getDeviceDisplay() {
        return Build.DISPLAY;
    }

    public static String getDeviceFubgerprint() {
        return Build.FINGERPRINT;
    }

    public static String getDeviceHardware() {
        return Build.HARDWARE;
    }

    public static int getDeviceHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static String getDeviceHost() {
        return Build.HOST;
    }

    public static String getDeviceId() {
        return Build.ID;
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceProduct() {
        return Build.PRODUCT;
    }

    public static String getDeviceSerial() {
        return Build.SERIAL;
    }

    public static String getDeviceUser() {
        return Build.USER;
    }

    public static int getDeviceWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String getMaxCpuFreq() {
        String str;
        byte[] bArr;
        String str2 = a;
        if (str2 != null) {
            return str2;
        }
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            String str3 = "";
            while (inputStream.read(new byte[24]) != -1) {
                str3 = str3 + new String(bArr);
            }
            str = str3.trim();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            str = null;
        }
        if (str != null) {
            a = str;
        }
        return str;
    }

    public static String[] getMemoryInfos() {
        String[] strArr = new String[3];
        ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            strArr[0] = String.valueOf(memoryInfo.totalMem / 1000);
            strArr[1] = String.valueOf(memoryInfo.availMem / 1000);
            strArr[2] = String.valueOf(memoryInfo.threshold / 1000);
            return strArr;
        }
        return null;
    }

    public static String getMemorySize() {
        ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.totalMem / 1000);
        }
        return null;
    }

    public static String getMemoryThresholdSize() {
        ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.threshold / 1000);
        }
        return null;
    }

    public static String getMinCpuFreq() {
        String str;
        byte[] bArr;
        String str2 = b;
        if (str2 != null) {
            return str2;
        }
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            String str3 = "";
            while (inputStream.read(new byte[24]) != -1) {
                str3 = str3 + new String(bArr);
            }
            str = str3.trim();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            str = null;
        }
        if (str != null) {
            b = str;
        }
        return str;
    }
}
