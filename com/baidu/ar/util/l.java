package com.baidu.ar.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.sapi2.base.network.Apn;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class l {
    public static String a = "";
    public static String b = "";
    public static String c = "";

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

    /* JADX WARN: Removed duplicated region for block: B:53:0x017e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        FileReader fileReader2 = null;
        String[] strArr = {"null", "null", "null", "null"};
        try {
            fileReader = new FileReader("/proc/version");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    strArr[0] = bufferedReader.readLine().split("\\s+")[2];
                    bufferedReader.close();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileReader2 = fileReader;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        strArr[1] = Build.VERSION.RELEASE;
                        strArr[2] = Build.MODEL;
                        strArr[3] = Build.DISPLAY;
                        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        a += a("手机厂商", Build.BRAND);
                        a += a("手机型号", Build.MODEL);
                        a += a("SDK版本", Build.VERSION.SDK);
                        a += a("系统版本", Build.VERSION.RELEASE);
                        a += a("屏幕分辨率", displayMetrics.widthPixels + "*" + displayMetrics.heightPixels);
                        a += a("屏幕密度", context.getResources().getDisplayMetrics().densityDpi + "dpi");
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                    }
                    if (fileReader != null) {
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                bufferedReader = null;
                fileReader2 = fileReader;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e9) {
            e = e9;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
        }
        strArr[1] = Build.VERSION.RELEASE;
        strArr[2] = Build.MODEL;
        strArr[3] = Build.DISPLAY;
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        a += a("手机厂商", Build.BRAND);
        a += a("手机型号", Build.MODEL);
        a += a("SDK版本", Build.VERSION.SDK);
        a += a("系统版本", Build.VERSION.RELEASE);
        a += a("屏幕分辨率", displayMetrics2.widthPixels + "*" + displayMetrics2.heightPixels);
        a += a("屏幕密度", context.getResources().getDisplayMetrics().densityDpi + "dpi");
        return "";
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(b)) {
            b += com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        b += (TextUtils.isEmpty(str) ? Apn.APN_UNKNOWN : str);
        if (!TextUtils.isEmpty(c)) {
            c += com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        c += (TextUtils.isEmpty(str2) ? Apn.APN_UNKNOWN : str2);
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = Apn.APN_UNKNOWN;
        }
        StringBuilder append = sb.append(str).append(": ");
        if (TextUtils.isEmpty(str2)) {
            str2 = Apn.APN_UNKNOWN;
        }
        return append.append(str2).append("\n").toString();
    }

    public static List<String> a(Context context, GL10 gl10) {
        a = "";
        b = "";
        c = "";
        long[] a2 = a();
        long[] b2 = b();
        a += "基本信息：\n";
        a(context);
        a += "\n存储：\n";
        a += a("可用/内存大小", c(context) + "/" + b(context) + "MB");
        a += a("可用/ROM存储", a2[1] + "/" + a2[0] + "MB");
        a += a("可用/SDCard存储", b2[1] + "/" + b2[0] + "MB");
        a += a("Heap Size", ((int) (Runtime.getRuntime().maxMemory() / 1048576)) + "MB");
        a += "\nCPU信息：\n";
        a += a("CPU名称", c());
        a += a("核心数", String.valueOf(d()));
        a += a("最低频率", e() + "MHz");
        a += a("最高频率", f() + "MHz");
        a += a("当前频率", g() + "MHz");
        a += "\nGPU信息：\n";
        a(gl10);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        return arrayList;
    }

    public static void a(GL10 gl10) {
        a += a("GL_VENDOR", gl10.glGetString(7936));
        a += a("GL_RENDERER", gl10.glGetString(7937));
        a += a("GL_VERSION", gl10.glGetString(7938));
    }

    public static long[] a() {
        StatFs statFs;
        long blockSize = new StatFs(Environment.getDataDirectory().getPath()).getBlockSize();
        return new long[]{(statFs.getBlockCount() * blockSize) / 1048576, (statFs.getAvailableBlocks() * blockSize) / 1048576};
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b(Context context) {
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
                        b.b(readLine + ", " + split[i] + "\t");
                    }
                    j = Integer.parseInt(split[1]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileReader2 = fileReader;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return j / 1024;
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                    }
                    if (fileReader != null) {
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                bufferedReader = null;
                fileReader2 = fileReader;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e9) {
            e = e9;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
        }
        return j / 1024;
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

    public static long c(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1048576;
    }

    public static String c() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader2;
        String str = null;
        try {
            try {
                fileReader = new FileReader("/proc/cpuinfo");
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            e = e;
            bufferedReader2 = null;
            fileReader = null;
        } catch (Throwable th3) {
            bufferedReader = null;
            fileReader = null;
            th = th3;
        }
        try {
            bufferedReader2 = new BufferedReader(fileReader);
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
                if (fileReader != null) {
                    try {
                        fileReader.close();
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
                if (fileReader != null) {
                    try {
                        fileReader.close();
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
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            throw th;
        }
        return str;
    }

    public static int d() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            b.a("CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            b.a("CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }

    public static boolean d(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null;
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
            e.printStackTrace();
            str = Apn.APN_UNKNOWN;
        }
        return str.trim();
    }

    public static String e(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
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
            e.printStackTrace();
            str = Apn.APN_UNKNOWN;
        }
        return String.valueOf(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        Exception exc;
        String str;
        String trim;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    try {
                        trim = bufferedReader.readLine().trim();
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    bufferedReader2 = bufferedReader;
                    exc = e3;
                    str = Apn.APN_UNKNOWN;
                }
                try {
                    str = String.valueOf(Integer.parseInt(trim.trim()) / 1000);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Exception e6) {
                    str = trim;
                    bufferedReader2 = bufferedReader;
                    exc = e6;
                    try {
                        exc.printStackTrace();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                        }
                        if (fileReader != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e9) {
                exc = e9;
                str = Apn.APN_UNKNOWN;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e10) {
            exc = e10;
            fileReader = null;
            str = Apn.APN_UNKNOWN;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
        }
        return str;
    }
}
