package com.baidu.searchbox.aideviceperformance.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.util.Log;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class HardwareInfoUtils {
    public static final String CPU_INFO_DIR = "/sys/devices/system/cpu/";
    public static final int INVALID_VALUE = -1;
    public static final String MEM_INFO_FILE = "/proc/meminfo";
    public static final String TAG = "HardwareInfoUtil";
    public static final boolean DEBUG = Config.isDebug();
    public static int sCoreNum = -1;
    public static float sTotalMemory = -1.0f;

    public static float[] getAllCpuFrequency() {
        float[] fArr = new float[getNumCores()];
        for (int i = 0; i < getNumCores(); i++) {
            fArr[i] = getSingleCpuFrequency(getCpuInfoFilePath(i));
        }
        return fArr;
    }

    public static String getAllCpuFrequencyString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getNumCores(); i++) {
            float singleCpuFrequency = getSingleCpuFrequency(getCpuInfoFilePath(i));
            sb.append(SevenZipUtils.FILE_SEP + singleCpuFrequency);
        }
        return sb.toString();
    }

    public static float getAveCpuFrequency() {
        int i = 0;
        float f = 0.0f;
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

    public static int getNumCores() {
        int length;
        FileFilter fileFilter = new FileFilter() { // from class: com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (Pattern.matches("cpu[0-9]", file.getName())) {
                    return true;
                }
                return false;
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

    public static float getTotalSDCardSize() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((((float) (statFs.getBlockCountLong() * statFs.getBlockSizeLong())) / 1024.0f) / 1024.0f) / 1024.0f;
            } catch (Error | Exception unused) {
            }
        }
        return -1.0f;
    }

    public static String getCpuInfoFilePath(int i) {
        return "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
    }

    public static int getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static String getScreenInfo(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        int i = displayMetrics.densityDpi;
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        return "densityDPI=" + i + "; screenWidth=" + i2 + "; screenHeight=" + i3;
    }

    public static long getScreenResolution(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels * displayMetrics.heightPixels;
    }

    public static float getScreenXdpi(Context context) {
        return context.getResources().getDisplayMetrics().xdpi;
    }

    public static float getScreenYdpi(Context context) {
        return context.getResources().getDisplayMetrics().ydpi;
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0043 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0072 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.io.FileReader */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.io.FileReader */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: java.io.FileReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.FileReader, java.io.Reader] */
    public static float getTotalMemory() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        Exception e;
        float f = sTotalMemory;
        FileReader fileReader = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (fileReader < 0) {
            try {
                try {
                    fileReader = new FileReader(MEM_INFO_FILE);
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    bufferedReader2 = new BufferedReader(fileReader, 8192);
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            String[] split = readLine.split("\\s+");
                            if (split.length >= 2) {
                                long parseLong = Long.parseLong(split[1]);
                                if (parseLong > 0) {
                                    sTotalMemory = (((float) parseLong) / 1024.0f) / 1024.0f;
                                }
                            }
                        }
                        float f2 = sTotalMemory;
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused) {
                        }
                        try {
                            fileReader.close();
                        } catch (IOException unused2) {
                        }
                        return f2;
                    } catch (Exception e2) {
                        e = e2;
                        if (DEBUG) {
                            Log.e(TAG, "getTotalMemory Exception occured,e=", e);
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (fileReader != 0) {
                            try {
                                fileReader.close();
                            } catch (IOException unused4) {
                            }
                        }
                        return -1.0f;
                    }
                } catch (Exception e3) {
                    bufferedReader2 = null;
                    e = e3;
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileReader != 0) {
                        try {
                            fileReader.close();
                        } catch (IOException unused6) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                bufferedReader2 = null;
                e = e4;
                fileReader = 0;
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                fileReader = 0;
            }
        } else {
            return f;
        }
    }
}
