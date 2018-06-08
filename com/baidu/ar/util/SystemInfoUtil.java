package com.baidu.ar.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class SystemInfoUtil {
    public static final String COLON = ":";
    public static final String COMMA = ",";
    public static final String LINE_END = "\r\n";
    public static final String NA = "N/A";
    public static String log = "";
    public static String name = "";
    public static String value = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static boolean checkFlashFeature(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public static List<String> getAllInfos(Context context, GL10 gl10) {
        log = "";
        name = "";
        value = "";
        long[] romMemroy = getRomMemroy();
        long sDCardTotalSize = getSDCardTotalSize();
        long sDAvailableSizeByM = getSDAvailableSizeByM();
        log += "基本信息：\n";
        getBaseInfo(context);
        log += "\n存储：\n";
        log += getLogStr("可用/内存大小", getAvailMemory(context) + "/" + getRamMemory(context) + "MB");
        log += getLogStr("可用/ROM存储", romMemroy[1] + "/" + romMemroy[0] + "MB");
        log += getLogStr("可用/SDCard存储", sDAvailableSizeByM + "/" + sDCardTotalSize + "MB");
        log += getLogStr("Heap Size", ((int) (Runtime.getRuntime().maxMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) + "MB");
        log += "\nCPU信息：\n";
        log += getLogStr("CPU名称", getCpuName());
        log += getLogStr("核心数", String.valueOf(getNumCores()));
        log += getLogStr("最低频率", getMinCpuFreq() + "MHz");
        log += getLogStr("最高频率", getMaxCpuFreq() + "MHz");
        log += getLogStr("当前频率", getCurCpuFreq() + "MHz");
        log += "\nGPU信息：\n";
        getGPUInfo(gl10);
        ArrayList arrayList = new ArrayList();
        arrayList.add(log);
        arrayList.add(name);
        arrayList.add(value);
        return arrayList;
    }

    public static String getAppName(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long getAvailMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0189 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getBaseInfo(Context context) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        InputStreamReader inputStreamReader2 = null;
        String[] strArr = {"null", "null", "null", "null"};
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("/proc/version"), Charset.forName(IoUtils.UTF_8));
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
            } catch (Exception e) {
                e = e;
                bufferedReader = null;
                inputStreamReader2 = inputStreamReader;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
        }
        try {
            strArr[0] = bufferedReader.readLine().split("\\s+")[2];
            bufferedReader.close();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e = e5;
            inputStreamReader2 = inputStreamReader;
            try {
                e.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (inputStreamReader2 != null) {
                    try {
                        inputStreamReader2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                strArr[1] = Build.VERSION.RELEASE;
                strArr[2] = Build.MODEL;
                strArr[3] = Build.DISPLAY;
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                log += getLogStr("手机厂商", Build.BRAND);
                log += getLogStr("手机型号", Build.MODEL);
                log += getLogStr("SDK版本", Build.VERSION.SDK);
                log += getLogStr("系统版本", Build.VERSION.RELEASE);
                log += getLogStr("屏幕分辨率", displayMetrics.widthPixels + "*" + displayMetrics.heightPixels);
                log += getLogStr("屏幕密度", context.getResources().getDisplayMetrics().densityDpi + "dpi");
                return "";
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = inputStreamReader2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
            }
            if (inputStreamReader != null) {
            }
            throw th;
        }
        strArr[1] = Build.VERSION.RELEASE;
        strArr[2] = Build.MODEL;
        strArr[3] = Build.DISPLAY;
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        log += getLogStr("手机厂商", Build.BRAND);
        log += getLogStr("手机型号", Build.MODEL);
        log += getLogStr("SDK版本", Build.VERSION.SDK);
        log += getLogStr("系统版本", Build.VERSION.RELEASE);
        log += getLogStr("屏幕分辨率", displayMetrics2.widthPixels + "*" + displayMetrics2.heightPixels);
        log += getLogStr("屏幕密度", context.getResources().getDisplayMetrics().densityDpi + "dpi");
        return "";
    }

    public static String getCpuName() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader2;
        String str = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream("/proc/cpuinfo"), Charset.forName(IoUtils.UTF_8));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            e = e;
            bufferedReader2 = null;
            inputStreamReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            inputStreamReader = null;
            th = th3;
        }
        try {
            bufferedReader2 = new BufferedReader(inputStreamReader);
            try {
                String[] split = bufferedReader2.readLine().split(":\\s+", 2);
                for (int i = 0; i < split.length; i++) {
                }
                str = split[1];
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return str;
            }
        } catch (Exception e7) {
            e = e7;
            bufferedReader2 = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            throw th;
        }
        return str;
    }

    public static String getCurCpuFreq() {
        InputStreamReader inputStreamReader;
        Exception exc;
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"), Charset.forName(IoUtils.UTF_8));
            try {
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e) {
                    exc = e;
                    str = "N/A";
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    String trim = bufferedReader.readLine().trim();
                    try {
                        str = String.valueOf(Integer.parseInt(trim.trim()) / 1000);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Exception e4) {
                        str = trim;
                        bufferedReader2 = bufferedReader;
                        exc = e4;
                        exc.printStackTrace();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return str;
                    }
                } catch (Exception e7) {
                    bufferedReader2 = bufferedReader;
                    exc = e7;
                    str = "N/A";
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            exc = e10;
            inputStreamReader = null;
            str = "N/A";
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
        return str;
    }

    public static void getGPUInfo(GL10 gl10) {
        log += getLogStr("GL_VENDOR", gl10.glGetString(7936));
        log += getLogStr("GL_RENDERER", gl10.glGetString(7937));
        log += getLogStr("GL_VERSION", gl10.glGetString(7938));
    }

    public static String getLogStr(String str, String str2) {
        if (!TextUtils.isEmpty(name)) {
            name += ",";
        }
        name += (TextUtils.isEmpty(str) ? "N/A" : str);
        if (!TextUtils.isEmpty(value)) {
            value += ",";
        }
        value += (TextUtils.isEmpty(str2) ? "N/A" : str2);
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "N/A";
        }
        StringBuilder append = sb.append(str).append(": ");
        if (TextUtils.isEmpty(str2)) {
            str2 = "N/A";
        }
        return append.append(str2).append("\n").toString();
    }

    public static String getMaxCpuFreq() {
        String str;
        byte[] bArr;
        String str2 = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str2 = str2 + new String(bArr, IoUtils.UTF_8);
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
            str = "N/A";
        }
        return String.valueOf(str);
    }

    public static String getMinCpuFreq() {
        String str;
        byte[] bArr;
        String str2 = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str2 = str2 + new String(bArr, IoUtils.UTF_8);
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception e) {
            str = "N/A";
        }
        return str.trim();
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            ARLog.d("CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            ARLog.d("CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getRamMemory(Context context) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        long j = 0;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("/proc/meminfo"), Charset.forName(IoUtils.UTF_8));
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
            } catch (Exception e) {
                e = e;
                bufferedReader = null;
                inputStreamReader2 = inputStreamReader;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                String[] split = readLine.split("\\s+");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    ARLog.i(readLine + ", " + split[i] + "\t");
                }
                j = Integer.parseInt(split[1]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e = e4;
                inputStreamReader2 = inputStreamReader;
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return j / 1024;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader = inputStreamReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                }
                if (inputStreamReader != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            inputStreamReader = null;
        }
        return j / 1024;
    }

    public static long[] getRomMemroy() {
        StatFs statFs;
        long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
        return new long[]{(statFs.getBlockCount() * blockSize) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, (statFs.getAvailableBlocks() * blockSize) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED};
    }

    public static long getSDAvailableSizeByM() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public static long getSDCardTotalSize() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long blockSize = statFs.getBlockSize();
                long blockCount = statFs.getBlockCount();
                statFs.getAvailableBlocks();
                return (blockSize * blockCount) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return 0L;
        } catch (Error e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static boolean isHasGyroscope(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null;
    }

    public static boolean isNexus6P() {
        return "Nexus 6P".equals(Build.MODEL) || "AOSP on angler".equals(Build.MODEL);
    }

    public static boolean isScreenOrientationLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
