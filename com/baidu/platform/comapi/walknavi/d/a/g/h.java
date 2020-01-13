package com.baidu.platform.comapi.walknavi.d.a.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class h {
    public static String a = "";
    public static String b = "";
    public static String c = "";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [222=4] */
    public static long a(Context context) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        FileReader fileReader2 = null;
        long j = 0;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    String readLine = bufferedReader.readLine();
                    String[] split = readLine.split("\\s+");
                    int length = split.length;
                    for (int i = 0; i < length; i++) {
                        a.a(readLine + ", " + split[i] + "\t");
                    }
                    j = Integer.parseInt(split[1]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Exception e3) {
                    fileReader2 = fileReader;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (IOException e5) {
                        }
                    }
                    return j / 1024;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                bufferedReader = null;
                fileReader2 = fileReader;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Exception e9) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileReader = null;
        }
        return j / 1024;
    }

    public static long b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public static long[] a() {
        StatFs statFs;
        long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
        return new long[]{(statFs.getBlockCount() * blockSize) / 1048576, (statFs.getAvailableBlocks() * blockSize) / 1048576};
    }

    public static long[] b() {
        StatFs statFs;
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            long blockSize = new StatFs(Environment.getExternalStorageDirectory().getPath()).getBlockSize();
            jArr[0] = (statFs.getBlockCount() * blockSize) / 1048576;
            jArr[1] = (statFs.getAvailableBlocks() * blockSize) / 1048576;
        }
        return jArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [314=4] */
    public static String c() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        String str = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Exception e) {
                bufferedReader = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
        } catch (Exception e2) {
            bufferedReader = null;
            fileReader = null;
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String[] split = bufferedReader.readLine().split(":\\s+", 2);
            for (int i = 0; i < split.length; i++) {
            }
            str = split[1];
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e4) {
                }
            }
        } catch (Exception e5) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e7) {
                }
            }
            return str;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e8) {
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e9) {
                }
            }
            throw th;
        }
        return str;
    }

    public static int d() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new i());
            a.a("CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            a.a("CPU Count: Failed.");
            return 1;
        }
    }

    public static String e() {
        String str;
        byte[] bArr;
        String str2 = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str2 = str2 + new String(bArr);
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception e) {
            str = "N/A";
        }
        return str.trim();
    }

    public static String f() {
        String str;
        byte[] bArr;
        String str2 = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str2 = str2 + new String(bArr);
            }
            inputStream.close();
            str = String.valueOf(Integer.parseInt(str2.trim()) / 1000);
        } catch (Exception e) {
            str = "N/A";
        }
        return String.valueOf(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [432=4] */
    public static String g() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        String str;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    try {
                        try {
                            str = String.valueOf(Integer.parseInt(bufferedReader.readLine().trim().trim()) / 1000);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e2) {
                                }
                            }
                        } catch (Exception e3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e5) {
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
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e7) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    str = "N/A";
                }
            } catch (Exception e9) {
                bufferedReader = null;
                str = "N/A";
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Exception e10) {
            bufferedReader = null;
            fileReader = null;
            str = "N/A";
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
        }
        return str;
    }
}
