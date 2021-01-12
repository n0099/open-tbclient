package com.baidu.media.duplayer;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Proxy;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes14.dex */
public class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static String f3196a = "filecache-Utils";

    /* renamed from: b  reason: collision with root package name */
    public static int f3197b = 536870912;
    public static String c = ".video_cache";
    private static volatile int d = -1;
    private static volatile int e = -1;
    private static volatile int f = -1;
    private static volatile String g = null;

    public static long a() {
        long j = -1;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                String path = Environment.getExternalStorageDirectory().getPath();
                if (path == null || path.length() <= 0) {
                    CyberLog.w(f3196a, "External path is null, so SDCard no free space");
                } else {
                    StatFs statFs = new StatFs(path);
                    j = statFs.getAvailableBlocks() * statFs.getBlockSize();
                }
            }
        } catch (Exception e2) {
            CyberLog.d(f3196a, "SDCard no free space");
        }
        return j;
    }

    public static String a(Context context) {
        String str = null;
        try {
            if (c(context)) {
                str = Environment.getExternalStorageDirectory().getAbsolutePath();
            } else if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                str = context.getExternalCacheDir().getPath();
            }
        } catch (Exception e2) {
        }
        return str;
    }

    public static void a(int i) {
        nativeSetMaxConcurrentOperationCount(i);
    }

    public static void a(File file) {
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    a(file2);
                }
            }
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            CyberLog.w(f3196a, e2.toString());
        }
    }

    public static void a(String str) {
        nativeSetFileacheWorkDirectory(str);
    }

    public static void a(String str, String str2) {
        nativeVideoSRInit(str, str2);
    }

    public static void a(String str, boolean z) {
        try {
            String str2 = Build.DISPLAY;
            if (TextUtils.isEmpty(str2)) {
                str2 = "sdk-" + Build.VERSION.SDK_INT;
            }
            nativeMonitorInit(str, str2, z);
        } catch (Exception e2) {
        }
    }

    public static void a(byte[] bArr, int i, byte[] bArr2) {
        nativeKernelEncrypt(bArr, i, bArr2);
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost == null || defaultHost.length() <= 0 || defaultPort < 0 || defaultPort > 65535) {
            return null;
        }
        sb.append(defaultHost);
        sb.append(":");
        sb.append(String.valueOf(defaultPort));
        return sb.toString();
    }

    public static String b(Context context) {
        String a2 = a(context);
        String str = TextUtils.isEmpty(a2) ? null : a2 + File.separator + "baidu" + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + "duplayer" + File.separator + context.getPackageName();
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
        CyberLog.i(f3196a, "Utils.getExternalStorageSpace():" + a());
        if (a() < 10485760 || str == null) {
            str = str2;
        }
        new File(str).mkdirs();
        if (!d(context)) {
            str = str + File.separator + "remote";
        }
        CyberLog.i(f3196a, "getVideoStatisticsPath folder:" + str);
        return str;
    }

    public static void c() {
        nativeCleanFilecache();
    }

    public static boolean c(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            if (packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", context.getPackageName()) == 0) {
                return packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static long d() {
        return nativeCaculateFolderSize();
    }

    public static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        if (d < 0) {
            if (context.getPackageName().equals(f(context))) {
                d = 1;
            } else {
                d = 0;
            }
        }
        return d == 1;
    }

    public static synchronized void e() {
        synchronized (Utils.class) {
            Map<String, String> cfgMap = CyberCfgManager.getInstance().getCfgMap();
            if (cfgMap != null && cfgMap.size() > 0) {
                String[] strArr = (String[]) cfgMap.keySet().toArray(new String[0]);
                String[] strArr2 = (String[]) cfgMap.values().toArray(new String[0]);
                if (strArr != null && strArr2 != null && strArr.length == strArr2.length) {
                    nativeUpdateCfgOpts(strArr, strArr2);
                }
            }
        }
    }

    public static boolean e(Context context) {
        if (context == null) {
            return false;
        }
        if (e < 0) {
            if ((context.getPackageName() + ":media").equals(f(context))) {
                e = 1;
            } else {
                e = 0;
            }
        }
        return e == 1;
    }

    public static String f() {
        if (f < 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                f = Process.is64Bit() ? 1 : 0;
            } else {
                f = ((BaseDexClassLoader) CyberPlayerManager.getApplicationContext().getClassLoader()).findLibrary("c").contains("lib64") ? 1 : 0;
            }
        }
        return f == 1 ? "arm64-v8a" : "armeabi-v7a";
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(g)) {
            g = g(context);
            if (TextUtils.isEmpty(g)) {
                g = g();
            }
            return g;
        }
        return g;
    }

    private static String g() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            bufferedReader2 = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
        } catch (Exception e2) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader2.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                readLine = readLine.trim();
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                    return readLine;
                } catch (IOException e3) {
                    return readLine;
                }
            }
            return readLine;
        } catch (Exception e4) {
            bufferedReader = bufferedReader2;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader3 = bufferedReader2;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e6) {
                }
            }
            throw th;
        }
    }

    private static String g(Context context) {
        int myPid = Process.myPid();
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e2) {
        }
        return null;
    }

    private static native long nativeCaculateFolderSize();

    private static native void nativeCleanFilecache();

    private static native void nativeKernelEncrypt(byte[] bArr, int i, byte[] bArr2);

    private static native void nativeMonitorInit(String str, String str2, boolean z);

    private static native void nativeSetFileacheWorkDirectory(String str);

    private static native void nativeSetMaxConcurrentOperationCount(int i);

    private static native void nativeUpdateCfgOpts(String[] strArr, String[] strArr2);

    private static native void nativeVideoSRInit(String str, String str2);
}
