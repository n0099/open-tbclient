package com.baidu.swan.apps.process;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final FileFilter aGw = new FileFilter() { // from class: com.baidu.swan.apps.process.b.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i = 3; i < name.length(); i++) {
                    if (!Character.isDigit(name.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };

    public static float bo(Context context) {
        float bp = (bp(context) + Iv()) / 2.0f;
        if (DEBUG) {
            Log.d("SwanPerformanceEvaluation", "deviceLevel -> " + bp);
        }
        return bp;
    }

    private static float Iv() {
        float f;
        float f2;
        int Iy = Iy();
        int Iw = Iw();
        if (DEBUG) {
            Log.d("SwanPerformanceEvaluation", "cpu max freqKHz -> " + Iy);
            Log.d("SwanPerformanceEvaluation", "cpu max cores -> " + Iw);
        }
        if (Iy != -1) {
            float f3 = ((Iy / 1000.0f) - 1200.0f) / 1600.0f;
            if (f3 <= 0.0f) {
                f3 = 0.0f;
            }
            if (f3 >= 1.0f) {
                f3 = 1.0f;
            }
            if (DEBUG) {
                Log.d("SwanPerformanceEvaluation", "freqLevel -> " + f3);
            }
            f = f3;
        } else {
            f = 0.5f;
        }
        if (Iw != -1) {
            float f4 = ((Iw - 2) * 1.0f) / 6.0f;
            if (f4 <= 0.0f) {
                f4 = 0.0f;
            }
            f2 = f4 < 1.0f ? f4 : 1.0f;
            if (DEBUG) {
                Log.d("SwanPerformanceEvaluation", "coresLevel -> " + f2);
            }
        } else {
            f2 = 0.5f;
        }
        return (f + f2) / 2.0f;
    }

    private static float bp(Context context) {
        long bq = bq(context);
        if (DEBUG) {
            Log.d("SwanPerformanceEvaluation", "mem in byte -> " + bq);
        }
        if (bq == -1) {
            return 0.5f;
        }
        float f = ((((float) bq) / 1048576.0f) - 1000.0f) / 7000.0f;
        float f2 = f > 0.0f ? f : 0.0f;
        float f3 = f2 < 1.0f ? f2 : 1.0f;
        if (DEBUG) {
            Log.d("SwanPerformanceEvaluation", "memLevel -> " + f3);
            return f3;
        }
        return f3;
    }

    public static int Iw() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int gd = gd("/sys/devices/system/cpu/possible");
            if (gd == -1) {
                gd = gd("/sys/devices/system/cpu/present");
            }
            if (gd == -1) {
                return Ix();
            }
            return gd;
        } catch (NullPointerException | SecurityException e) {
            return -1;
        }
    }

    private static int gd(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (IOException e) {
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            int ge = ge(readLine);
            com.baidu.swan.c.a.c(fileInputStream);
            return ge;
        } catch (IOException e2) {
            com.baidu.swan.c.a.c(fileInputStream);
            return -1;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.swan.c.a.c(fileInputStream);
            throw th;
        }
    }

    private static int ge(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private static int Ix() {
        return new File("/sys/devices/system/cpu/").listFiles(aGw).length;
    }

    public static int Iy() {
        int i;
        try {
            int Iw = Iw();
            i = -1;
            for (int i2 = 0; i2 < Iw; i2++) {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i3 = 0;
                        while (Character.isDigit(bArr[i3]) && i3 < bArr.length) {
                            i3++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                        if (valueOf.intValue() > i) {
                            i = valueOf.intValue();
                        }
                        fileInputStream.close();
                    } catch (NumberFormatException e) {
                        fileInputStream.close();
                    }
                }
            }
            if (i == -1) {
                FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
                int a = a("cpu MHz", fileInputStream2) * 1000;
                if (a > i) {
                    i = a;
                }
                fileInputStream2.close();
            }
        } catch (IOException e2) {
            i = -1;
        }
        if (i <= 0) {
            return -1;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0026, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    for (int i2 = i; i2 < read; i2++) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return e(bArr, i2);
                        }
                    }
                    continue;
                }
                i++;
            }
        } catch (IOException e) {
        } catch (NumberFormatException e2) {
        }
        return -1;
    }

    private static int e(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (Character.isDigit(bArr[i])) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long bq(Context context) {
        long j;
        FileInputStream fileInputStream;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                j = memoryInfo.totalMem;
            } else {
                j = -1;
            }
            if (j != -1) {
                return j;
            }
        } else {
            j = -1;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            try {
                j = a("MemTotal", fileInputStream) * 1024;
                com.baidu.swan.c.a.c(fileInputStream);
            } catch (FileNotFoundException e) {
                com.baidu.swan.c.a.c(fileInputStream);
                return j > 0 ? j : -1L;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                com.baidu.swan.c.a.c(fileInputStream2);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return j > 0 ? j : -1L;
    }
}
