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
import com.baidu.android.util.io.PathUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.mobstat.Config;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes2.dex */
public class Utils {

    /* renamed from: a  reason: collision with root package name */
    public static String f7992a = "filecache-Utils";

    /* renamed from: b  reason: collision with root package name */
    public static int f7993b = 536870912;

    /* renamed from: c  reason: collision with root package name */
    public static String f7994c = ".video_cache";

    /* renamed from: d  reason: collision with root package name */
    public static volatile int f7995d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f7996e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static volatile int f7997f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f7998g;

    public static long a() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                String path = Environment.getExternalStorageDirectory().getPath();
                if (path == null || path.length() <= 0) {
                    CyberLog.w(f7992a, "External path is null, so SDCard no free space");
                    return -1L;
                }
                StatFs statFs = new StatFs(path);
                return statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
            return -1L;
        } catch (Exception unused) {
            CyberLog.d(f7992a, "SDCard no free space");
            return -1L;
        }
    }

    public static String b(Context context) {
        String str = null;
        try {
            if (l(context)) {
                str = Environment.getExternalStorageDirectory().getAbsolutePath();
            } else if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                str = context.getExternalCacheDir().getPath();
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static void c(int i2) {
        nativeSetMaxConcurrentOperationCount(i2);
    }

    public static void d(File file) {
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    d(file2);
                }
            }
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            CyberLog.w(f7992a, e2.toString());
        }
    }

    public static void e(String str) {
        nativeSetFileacheWorkDirectory(str);
    }

    public static void f(String str, String str2) {
        nativeVideoSRInit(str, str2);
    }

    public static void g(String str, boolean z) {
        try {
            String str2 = Build.DISPLAY;
            if (TextUtils.isEmpty(str2)) {
                str2 = "sdk-" + Build.VERSION.SDK_INT;
            }
            nativeMonitorInit(str, str2, z);
        } catch (Exception unused) {
        }
    }

    public static void h(byte[] bArr, int i2, byte[] bArr2) {
        nativeKernelEncrypt(bArr, i2, bArr2);
    }

    public static String i() {
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

    public static String j(Context context) {
        String str;
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            str = null;
        } else {
            str = b2 + File.separator + PathUtils.DIRCTORY_BAIDU + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + "duplayer" + File.separator + context.getPackageName();
        }
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
        CyberLog.i(f7992a, "Utils.getExternalStorageSpace():" + a());
        if (a() < Config.FULL_TRACE_LOG_LIMIT || str == null) {
            str = str2;
        }
        new File(str).mkdirs();
        if (!n(context)) {
            str = str + File.separator + "remote";
        }
        CyberLog.i(f7992a, "getVideoStatisticsPath folder:" + str);
        return str;
    }

    public static void k() {
        nativeCleanFilecache();
    }

    public static boolean l(Context context) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            try {
                if (packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", context.getPackageName()) == 0) {
                    return packageManager.checkPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION, context.getPackageName()) == 0;
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static long m() {
        return nativeCaculateFolderSize();
    }

    public static boolean n(Context context) {
        if (context == null) {
            return false;
        }
        if (f7995d < 0) {
            if (context.getPackageName().equals(r(context))) {
                f7995d = 1;
            } else {
                f7995d = 0;
            }
        }
        return f7995d == 1;
    }

    public static native long nativeCaculateFolderSize();

    public static native void nativeCleanFilecache();

    public static native void nativeKernelEncrypt(byte[] bArr, int i2, byte[] bArr2);

    public static native void nativeMonitorInit(String str, String str2, boolean z);

    public static native void nativeSetFileacheWorkDirectory(String str);

    public static native void nativeSetMaxConcurrentOperationCount(int i2);

    public static native void nativeUpdateCfgOpts(String[] strArr, String[] strArr2);

    public static native void nativeVideoSRInit(String str, String str2);

    public static synchronized void o() {
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

    public static boolean p(Context context) {
        if (context == null) {
            return false;
        }
        if (f7996e < 0) {
            if ((context.getPackageName() + ":media").equals(r(context))) {
                f7996e = 1;
            } else {
                f7996e = 0;
            }
        }
        return f7996e == 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static String q() {
        if (f7997f < 0) {
            f7997f = Build.VERSION.SDK_INT >= 23 ? Process.is64Bit() : ((BaseDexClassLoader) CyberPlayerManager.getApplicationContext().getClassLoader()).findLibrary("c").contains("lib64");
        }
        return f7997f == 1 ? "arm64-v8a" : "armeabi-v7a";
    }

    public static String r(Context context) {
        if (TextUtils.isEmpty(f7998g)) {
            f7998g = t(context);
            if (TextUtils.isEmpty(f7998g)) {
                f7998g = s();
            }
            return f7998g;
        }
        return f7998g;
    }

    public static String s() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String t(Context context) {
        int myPid = Process.myPid();
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
