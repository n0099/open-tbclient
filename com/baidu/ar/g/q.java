package com.baidu.ar.g;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class q {
    public static String xs = "";
    public static String name = "";
    public static String value = "";

    /* loaded from: classes10.dex */
    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long A(Context context) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        long j = 0;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("/proc/meminfo"), Charset.forName("utf-8"));
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
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            inputStreamReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            String[] split = readLine.split("\\s+");
            int length = split.length;
            for (int i = 0; i < length; i++) {
                Log.i("bdar:", readLine + ", " + split[i] + "\t");
            }
            j = Integer.parseInt(split[1]);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace(System.out);
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace(System.out);
                }
            }
        } catch (Exception e5) {
            e = e5;
            inputStreamReader2 = inputStreamReader;
            try {
                e.printStackTrace(System.out);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace(System.out);
                    }
                }
                if (inputStreamReader2 != null) {
                    try {
                        inputStreamReader2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace(System.out);
                    }
                }
                return j / 1024;
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = inputStreamReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        e8.printStackTrace(System.out);
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e9) {
                        e9.printStackTrace(System.out);
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            throw th;
        }
        return j / 1024;
    }

    public static long B(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public static boolean C(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null;
    }

    public static boolean D(Context context) {
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && ("RLIAN00".equalsIgnoreCase(Build.MODEL) || "RLIN29".equalsIgnoreCase(Build.MODEL) || "TAH-AN00".equalsIgnoreCase(Build.MODEL) || "TAHN29".equalsIgnoreCase(Build.MODEL) || "TAH-AN00m".equalsIgnoreCase(Build.MODEL) || "RLI-AN00".equalsIgnoreCase(Build.MODEL) || "RLI-N29".equalsIgnoreCase(Build.MODEL) || "TAH-AN00m".equalsIgnoreCase(Build.MODEL) || "TAH-N29".equalsIgnoreCase(Build.MODEL) || "RHA-AN00m".equalsIgnoreCase(Build.MODEL))) {
            return true;
        }
        return context != null && "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && context.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture");
    }

    public static long[] gC() {
        StatFs statFs;
        long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
        return new long[]{(statFs.getBlockCount() * blockSize) / 1048576, (statFs.getAvailableBlocks() * blockSize) / 1048576};
    }

    public static long gD() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (statFs.getBlockCount() * statFs.getBlockSize()) / 1048576;
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace(System.out);
            return 0L;
        }
    }

    public static long gE() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576;
            } catch (Exception e) {
                e.printStackTrace(System.out);
                return 0L;
            }
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String gF() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        Throwable th;
        String str = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("/proc/cpuinfo"), Charset.forName("utf-8"));
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    try {
                        String[] split = bufferedReader.readLine().split(":\\s+", 2);
                        for (int i = 0; i < split.length; i++) {
                        }
                        str = split[1];
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                e.printStackTrace(System.out);
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace(System.out);
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace(System.out);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace(System.out);
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e5) {
                                e5.printStackTrace(System.out);
                            }
                        }
                        return str;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            e6.printStackTrace(System.out);
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e7) {
                            e7.printStackTrace(System.out);
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
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
            inputStreamReader = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            inputStreamReader = null;
            th = th4;
        }
        return str;
    }

    public static int gG() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            Log.d("bdar", "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            Log.d("bdar", "CPU Count: Failed.");
            e.printStackTrace(System.out);
            return 1;
        }
    }

    public static String gH() {
        String str;
        byte[] bArr;
        String str2 = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str2 = str2 + new String(bArr, "utf-8");
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception e) {
            str = "N/A";
        }
        return str.trim();
    }

    public static boolean gI() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static String gJ() {
        String str;
        byte[] bArr;
        String str2 = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str2 = str2 + new String(bArr, "utf-8");
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            str = "N/A";
        }
        return String.valueOf(str);
    }

    public static String gK() {
        InputStreamReader inputStreamReader;
        Exception exc;
        String str;
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"), Charset.forName("utf-8"));
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    try {
                        try {
                            String trim = bufferedReader2.readLine().trim();
                            try {
                                str = String.valueOf(Integer.parseInt(trim.trim()) / 1000);
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e) {
                                        e.printStackTrace(System.out);
                                    }
                                }
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace(System.out);
                                    }
                                }
                            } catch (Exception e3) {
                                str = trim;
                                bufferedReader = bufferedReader2;
                                exc = e3;
                                exc.printStackTrace(System.out);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace(System.out);
                                    }
                                }
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace(System.out);
                                    }
                                }
                                return str;
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace(System.out);
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace(System.out);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e8) {
                        bufferedReader = bufferedReader2;
                        exc = e8;
                        str = "N/A";
                    }
                } catch (Exception e9) {
                    exc = e9;
                    str = "N/A";
                }
            } catch (Throwable th2) {
                th = th2;
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

    public static boolean gL() {
        return "Nexus 6P".equals(Build.MODEL) || "AOSP on angler".equals(Build.MODEL);
    }

    public static boolean gM() {
        return "Nexus 5X".equals(Build.MODEL);
    }
}
