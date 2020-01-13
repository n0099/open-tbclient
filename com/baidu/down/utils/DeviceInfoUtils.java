package com.baidu.down.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class DeviceInfoUtils {
    private static final boolean DEBUG = false;
    private static final String SF_FILENAME = "device_info_shared_f";
    private static final String SF_KEY_CPU_CORES = "cpu_cores";
    private static final String SF_KEY_CPU_FREQ = "cpu_freq";
    private static final String TAG = "DeviceInfoUtils";

    private DeviceInfoUtils() {
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

    public static int getCpuCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.baidu.down.utils.DeviceInfoUtils.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
        } catch (Exception e) {
            return 1;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=5, 174=4] */
    public static long getCpuFreq() {
        BufferedReader bufferedReader;
        long j = 0;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream()));
        } catch (IOException e) {
            bufferedReader = null;
        } catch (NumberFormatException e2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            j = Long.parseLong(bufferedReader.readLine());
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                }
            }
        } catch (IOException e4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
            }
            return j;
        } catch (NumberFormatException e6) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e7) {
                }
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e8) {
                }
            }
            throw th;
        }
        return j;
    }

    public static String getCut() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        return str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.VERSION.SDK_INT + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.MANUFACTURER.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }
}
