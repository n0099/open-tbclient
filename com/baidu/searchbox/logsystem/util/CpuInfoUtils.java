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
/* loaded from: classes5.dex */
public class CpuInfoUtils {
    private static final String CPU_INFO_DIR = "/sys/devices/system/cpu/";
    private static final int INVALID_VALUE = -1;
    private static final String TAG = "CpuInfoUtils";
    private static final boolean DEBUG = AppConfig.isDebug();
    private static int sCoreNum = -1;

    public static int getNumCores() {
        FileFilter fileFilter = new FileFilter() { // from class: com.baidu.searchbox.logsystem.util.CpuInfoUtils.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]", file.getName());
            }
        };
        if (sCoreNum <= 0) {
            try {
                File[] listFiles = new File(CPU_INFO_DIR).listFiles(fileFilter);
                sCoreNum = listFiles == null ? -1 : listFiles.length;
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e(TAG, "getNumCores exception occurred, e= ", e);
                }
                sCoreNum = -1;
            }
        }
        return sCoreNum;
    }

    public static float getAveCpuFrequency() {
        float f;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (i < getNumCores()) {
            float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i));
            if (singleCpuFrequency > 0.0f) {
                f = singleCpuFrequency + f2;
                i2++;
            } else {
                f = f2;
            }
            i++;
            f2 = f;
        }
        if (i2 > 0) {
            return f2 / i2;
        }
        return -1.0f;
    }

    private static String getCpuInfoFilePath(int i) {
        return "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [122=4] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static float getSingleCpuFrequency(String str) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        float f;
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (Exception e) {
            e = e;
            bufferedReader = null;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
            fileInputStream = null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            try {
                try {
                    f = (((float) Long.parseLong(bufferedReader.readLine())) / 1000.0f) / 1000.0f;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    if (DEBUG) {
                        Log.e(TAG, "getCpuFrequency Exception occurred, e=", e);
                    }
                    f = -1.0f;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                    }
                    return f;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
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
        return f;
    }
}
