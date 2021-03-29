package com.baidu.down.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class DeviceInfoUtils {
    public static final boolean DEBUG = false;
    public static final String SF_FILENAME = "device_info_shared_f";
    public static final String SF_KEY_CPU_CORES = "cpu_cores";
    public static final String SF_KEY_CPU_FREQ = "cpu_freq";
    public static final String TAG = "DeviceInfoUtils";

    public static int getCpuCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.baidu.down.utils.DeviceInfoUtils.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static int getCpuCoresWithCache(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SF_FILENAME, 0);
        int i = sharedPreferences.getInt(SF_KEY_CPU_CORES, 0);
        if (i == 0) {
            int cpuCores = getCpuCores();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(SF_KEY_CPU_CORES, cpuCores);
            edit.commit();
            return cpuCores;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getCpuFreq() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream()));
            try {
                long parseLong = Long.parseLong(bufferedReader.readLine());
                try {
                    bufferedReader.close();
                    return parseLong;
                } catch (IOException unused) {
                    return parseLong;
                }
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
            } catch (NumberFormatException unused3) {
                bufferedReader2 = bufferedReader;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (NumberFormatException unused6) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long getCpuFreqWithCache(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SF_FILENAME, 0);
        long j = sharedPreferences.getLong(SF_KEY_CPU_FREQ, -1L);
        if (j == -1) {
            long cpuFreq = getCpuFreq();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(SF_KEY_CPU_FREQ, cpuFreq);
            edit.commit();
            return cpuFreq;
        }
        return j;
    }

    public static String getCut() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        int i = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        return str.replace("_", "-") + "_" + str2.replace("_", "-") + "_" + i + "_" + str3.replace("_", "-");
    }
}
