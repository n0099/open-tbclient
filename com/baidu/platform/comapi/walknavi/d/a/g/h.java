package com.baidu.platform.comapi.walknavi.d.a.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static String f10010a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f10011b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f10012c = "";

    public static long a(Context context) {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        long j;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    String[] split = readLine.split("\\s+");
                    for (String str : split) {
                        a.a(readLine + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + TrackUI.SEPERATOR);
                    }
                    j = Integer.parseInt(split[1]);
                    try {
                        bufferedReader.close();
                    } catch (IOException unused) {
                    }
                    try {
                        fileReader.close();
                    } catch (IOException unused2) {
                        return j / 1024;
                    }
                } catch (Exception unused3) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    j = 0;
                    return j / 1024;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused8) {
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception unused9) {
            fileReader = null;
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    public static long b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public static String c() {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    String[] split = bufferedReader.readLine().split(":\\s+", 2);
                    for (int i = 0; i < split.length; i++) {
                    }
                    String str = split[1];
                    try {
                        bufferedReader.close();
                    } catch (IOException unused) {
                    }
                    try {
                        fileReader.close();
                    } catch (IOException unused2) {
                    }
                    return str;
                } catch (Exception unused3) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused8) {
                bufferedReader = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Exception unused9) {
            fileReader = null;
            bufferedReader = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            fileReader = null;
        }
    }

    public static int d() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new i());
            a.a("CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception unused) {
            a.a("CPU Count: Failed.");
            return 1;
        }
    }

    public static String e() {
        String str;
        byte[] bArr;
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            String str2 = "";
            while (inputStream.read(new byte[24]) != -1) {
                str2 = str2 + new String(bArr);
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception unused) {
            str = "N/A";
        }
        return str.trim();
    }

    public static String f() {
        String str;
        byte[] bArr;
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            String str2 = "";
            while (inputStream.read(new byte[24]) != -1) {
                str2 = str2 + new String(bArr);
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception unused) {
            str = "N/A";
        }
        return String.valueOf(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
        if (r2 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g() {
        FileReader fileReader;
        String str = "N/A";
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                try {
                    str = String.valueOf(Integer.parseInt(bufferedReader2.readLine().trim().trim()) / 1000);
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused7) {
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (IOException unused8) {
            return str;
        }
    }

    public static long[] b() {
        StatFs statFs;
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            long blockSize = new StatFs(Environment.getExternalStorageDirectory().getPath()).getBlockSize();
            jArr[0] = (statFs.getBlockCount() * blockSize) / 1048576;
            jArr[1] = (blockSize * statFs.getAvailableBlocks()) / 1048576;
        }
        return jArr;
    }

    public static long[] a() {
        StatFs statFs;
        long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
        return new long[]{(statFs.getBlockCount() * blockSize) / 1048576, (blockSize * statFs.getAvailableBlocks()) / 1048576};
    }
}
