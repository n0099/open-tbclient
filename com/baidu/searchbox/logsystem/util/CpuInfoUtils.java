package com.baidu.searchbox.logsystem.util;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class CpuInfoUtils {
    public static final String CPU_INFO_DIR = "/sys/devices/system/cpu/";
    public static final int INVALID_VALUE = -1;
    public static final String TAG = "CpuInfoUtils";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static int sCoreNum = -1;

    public static float getAveCpuFrequency() {
        int i2 = 0;
        float f2 = 0.0f;
        for (int i3 = 0; i3 < getNumCores(); i3++) {
            float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i3));
            if (singleCpuFrequency > 0.0f) {
                f2 += singleCpuFrequency;
                i2++;
            }
        }
        if (i2 > 0) {
            return f2 / i2;
        }
        return -1.0f;
    }

    public static String getCpuInfoFilePath(int i2) {
        return "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq";
    }

    public static int getNumCores() {
        FileFilter fileFilter = new FileFilter() { // from class: com.baidu.searchbox.logsystem.util.CpuInfoUtils.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]", file.getName());
            }
        };
        if (sCoreNum <= 0) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(fileFilter);
                sCoreNum = listFiles == null ? -1 : listFiles.length;
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.e("CpuInfoUtils", "getNumCores exception occurred, e= ", e2);
                }
                sCoreNum = -1;
            }
        }
        return sCoreNum;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float getSingleCpuFrequency(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        BufferedReader bufferedReader;
        Exception e2;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    try {
                        float parseLong = (((float) Long.parseLong(bufferedReader.readLine())) / 1000.0f) / 1000.0f;
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                        return parseLong;
                    } catch (Exception e3) {
                        e2 = e3;
                        if (DEBUG) {
                            Log.e("CpuInfoUtils", "getCpuFrequency Exception occurred, e=", e2);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused4) {
                            }
                        }
                        return -1.0f;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused6) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (fileInputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            e2 = e5;
            bufferedReader = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            bufferedReader = null;
        }
    }
}
