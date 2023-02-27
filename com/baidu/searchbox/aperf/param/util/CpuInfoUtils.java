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
/* loaded from: classes2.dex */
public class CpuInfoUtils {
    public static final String CPU_INFO_DIR = "/sys/devices/system/cpu/";
    public static final int INVALID_VALUE = -1;
    public static final String TAG = "CpuInfoUtils";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static int sCoreNum = -1;

    public static float getAveCpuFrequency() {
        float f;
        int numCores = getNumCores();
        int i = 0;
        if (numCores > 0) {
            int i2 = 0;
            f = 0.0f;
            while (i < numCores) {
                float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i));
                if (singleCpuFrequency > 0.0f) {
                    f += singleCpuFrequency;
                    i2++;
                }
                i++;
            }
            i = i2;
        } else {
            f = 0.0f;
        }
        if (i > 0 && f > 0.0f) {
            return f / i;
        }
        return -1.0f;
    }

    public static float getMaxCpuFrequency() {
        float f;
        int numCores = getNumCores();
        if (numCores > 0) {
            f = 0.0f;
            for (int i = 0; i < numCores; i++) {
                float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i));
                if (singleCpuFrequency > 0.0f && singleCpuFrequency > f) {
                    f = singleCpuFrequency;
                }
            }
        } else {
            f = 0.0f;
        }
        if (f <= 0.0f) {
            return -1.0f;
        }
        return f;
    }

    public static int getNumCores() {
        int length;
        FileFilter fileFilter = new FileFilter() { // from class: com.baidu.searchbox.aperf.param.util.CpuInfoUtils.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]", file.getName());
            }
        };
        if (sCoreNum <= 0) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(fileFilter);
                if (listFiles == null) {
                    length = -1;
                } else {
                    length = listFiles.length;
                }
                sCoreNum = length;
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e(TAG, "getNumCores exception occurred, e= ", e);
                }
                sCoreNum = -1;
            }
        }
        return sCoreNum;
    }

    public static String getCpuInfoFilePath(int i) {
        return "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
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
        Exception e;
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
                    } catch (Exception e2) {
                        e = e2;
                        if (DEBUG) {
                            Log.e(TAG, "getCpuFrequency Exception occurred, e=", e);
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
            } catch (Exception e3) {
                e = e3;
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
        } catch (Exception e4) {
            fileInputStream = null;
            e = e4;
            bufferedReader = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            bufferedReader = null;
        }
    }
}
