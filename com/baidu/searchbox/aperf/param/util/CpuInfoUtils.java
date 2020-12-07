package com.baidu.searchbox.aperf.param.util;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/* loaded from: classes19.dex */
public class CpuInfoUtils {
    private static final String CPU_INFO_DIR = "/sys/devices/system/cpu/";
    private static final int INVALID_VALUE = -1;
    private static final String TAG = "CpuInfoUtils";
    private static final boolean DEBUG = AppConfig.isDebug();
    private static int sCoreNum = -1;

    public static int getNumCores() {
        FileFilter fileFilter = new FileFilter() { // from class: com.baidu.searchbox.aperf.param.util.CpuInfoUtils.1
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
        float f = 0.0f;
        int i = 0;
        for (int i2 = 0; i2 < getNumCores(); i2++) {
            float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i2));
            if (singleCpuFrequency > 0.0f) {
                f += singleCpuFrequency;
                i++;
            }
        }
        if (i > 0) {
            return f / i;
        }
        return -1.0f;
    }

    private static String getCpuInfoFilePath(int i) {
        return "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static float getSingleCpuFrequency(String str) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        float f;
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    f = (((float) Long.parseLong(bufferedReader.readLine())) / 1000.0f) / 1000.0f;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "getCpuFrequency Exception occurred, e=", e);
                        }
                        f = -1.0f;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                            }
                        }
                        return f;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        bufferedReader2 = bufferedReader;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e7) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (fileInputStream != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                bufferedReader = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e9) {
            e = e9;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
        return f;
    }
}
