package com.baidu.ar.h;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.statistic.DeviceInfoUtil;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.kuaishou.weapon.p0.bk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class q {
    public static String name = "";
    public static String value = "";
    public static String yh = "";

    /* loaded from: classes.dex */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00a1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.BufferedReader] */
    public static long B(Context context) {
        InputStreamReader inputStreamReader;
        Throwable th;
        Exception e;
        BufferedReader bufferedReader;
        long j;
        ?? r10 = HardwareInfoUtils.MEM_INFO_FILE;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(HardwareInfoUtils.MEM_INFO_FILE), Charset.forName("utf-8"));
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    String[] split = readLine.split("\\s+");
                    for (String str : split) {
                        Log.i("bdar:", readLine + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + "\t");
                    }
                    j = Integer.parseInt(split[1]);
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace(System.out);
                    }
                    try {
                        inputStreamReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace(System.out);
                    }
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace(System.out);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            e5.printStackTrace(System.out);
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e6) {
                            e6.printStackTrace(System.out);
                        }
                    }
                    j = 0;
                    return j / 1024;
                }
            } catch (Exception e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                r10 = 0;
                if (r10 != 0) {
                    try {
                        r10.close();
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
        } catch (Exception e10) {
            inputStreamReader = null;
            e = e10;
            bufferedReader = null;
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            r10 = 0;
        }
        return j / 1024;
    }

    public static long C(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public static boolean D(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null;
    }

    public static boolean E(Context context) {
        return "RLIAN00".equalsIgnoreCase(Build.MODEL) || "RLIN29".equalsIgnoreCase(Build.MODEL) || "TAH-AN00".equalsIgnoreCase(Build.MODEL) || "TAHN29".equalsIgnoreCase(Build.MODEL) || "TAH-AN00m".equalsIgnoreCase(Build.MODEL) || "RLI-N29".equalsIgnoreCase(Build.MODEL) || "TAH-N29".equalsIgnoreCase(Build.MODEL) || "RHA-AN00m".equalsIgnoreCase(Build.MODEL);
    }

    public static long[] gC() {
        StatFs statFs;
        long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
        return new long[]{(statFs.getBlockCount() * blockSize) / 1048576, (blockSize * statFs.getAvailableBlocks()) / 1048576};
    }

    public static long gD() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (statFs.getBlockSize() * statFs.getBlockCount()) / 1048576;
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
                return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1048576;
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return 0L;
    }

    public static String gF() {
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader2;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(bk.a), Charset.forName("utf-8"));
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                bufferedReader2 = new BufferedReader(inputStreamReader);
                try {
                    String[] split = bufferedReader2.readLine().split(":\\s+", 2);
                    for (int i = 0; i < split.length; i++) {
                    }
                    String str = split[1];
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                    }
                    try {
                        inputStreamReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace(System.out);
                    }
                    return str;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace(System.out);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
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
                    return null;
                }
            } catch (Exception e6) {
                e = e6;
                bufferedReader2 = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        e7.printStackTrace(System.out);
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e8) {
                        e8.printStackTrace(System.out);
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            inputStreamReader = null;
            bufferedReader2 = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            inputStreamReader = null;
        }
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
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            String str2 = "";
            while (inputStream.read(new byte[24]) != -1) {
                str2 = str2 + new String(bArr, "utf-8");
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception unused) {
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
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            String str2 = "";
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

    /* JADX WARN: Removed duplicated region for block: B:46:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0040 -> B:54:0x006c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String gK() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Exception e;
        String str = "N/A";
        BufferedReader bufferedReader2 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(DeviceInfoUtil.CurPath), Charset.forName("utf-8"));
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        try {
                            str = String.valueOf(Integer.parseInt(bufferedReader.readLine().trim().trim()) / 1000);
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace(System.out);
                            }
                            inputStreamReader.close();
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
                                inputStreamReader.close();
                            }
                            return str;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace(System.out);
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e6) {
                                e6.printStackTrace(System.out);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    bufferedReader = null;
                    e = e7;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader2 != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e8.printStackTrace(System.out);
            }
        } catch (Exception e9) {
            bufferedReader = null;
            e = e9;
            inputStreamReader = null;
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
