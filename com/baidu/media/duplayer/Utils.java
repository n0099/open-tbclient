package com.baidu.media.duplayer;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.Map;
/* loaded from: classes.dex */
public class Utils {
    public static String a = "filecache-Utils";
    public static int b = 536870912;
    public static String c = ".video_cache";

    public static long a() {
        long j = -1;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                String path = Environment.getExternalStorageDirectory().getPath();
                if (path == null || path.length() <= 0) {
                    CyberLog.w(a, "External path is null, so SDCard no free space");
                } else {
                    StatFs statFs = new StatFs(path);
                    j = statFs.getAvailableBlocks() * statFs.getBlockSize();
                }
            }
        } catch (Exception e) {
            CyberLog.d(a, "SDCard no free space");
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
        } catch (Exception e) {
        }
        return str;
    }

    public static void a(String str) {
        nativeSetFileacheWorkDirectory(str);
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
        String str = a(context) + File.separator + "baidu" + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + "duplayer" + File.separator + context.getPackageName();
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
        if (a() < Config.FULL_TRACE_LOG_LIMIT) {
            str = str2;
        }
        new File(str).mkdirs();
        return str + File.separator + "video_session_log_" + CyberPlayerManager.getCoreVersion() + ".log";
    }

    public static void b(byte[] bArr, int i, byte[] bArr2) {
        nativeKernelEncrypt(bArr, i, bArr2);
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
        } catch (Exception e) {
            e.printStackTrace();
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
        String packageName = context.getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName.equals(packageName);
            }
        }
        return false;
    }

    public static String e() {
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        File filesDir = applicationContext.getFilesDir();
        return filesDir != null ? filesDir.getAbsolutePath() : "/data/data/" + applicationContext.getPackageName() + "/files";
    }

    public static synchronized void f() {
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

    private static native long nativeCaculateFolderSize();

    private static native void nativeCleanFilecache();

    private static native void nativeKernelEncrypt(byte[] bArr, int i, byte[] bArr2);

    private static native void nativeSetFileacheWorkDirectory(String str);

    private static native void nativeUpdateCfgOpts(String[] strArr, String[] strArr2);
}
