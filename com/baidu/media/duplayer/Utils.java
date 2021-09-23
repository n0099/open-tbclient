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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.PathUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes5.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f42677a = "filecache-Utils";

    /* renamed from: b  reason: collision with root package name */
    public static int f42678b = 536870912;

    /* renamed from: c  reason: collision with root package name */
    public static String f42679c = ".video_cache";

    /* renamed from: d  reason: collision with root package name */
    public static volatile int f42680d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static volatile int f42681e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static volatile int f42682f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static volatile String f42683g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(302187854, "Lcom/baidu/media/duplayer/Utils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(302187854, "Lcom/baidu/media/duplayer/Utils;");
        }
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    String path = Environment.getExternalStorageDirectory().getPath();
                    if (path == null || path.length() <= 0) {
                        CyberLog.w(f42677a, "External path is null, so SDCard no free space");
                        return -1L;
                    }
                    StatFs statFs = new StatFs(path);
                    return statFs.getBlockSize() * statFs.getAvailableBlocks();
                }
                return -1L;
            } catch (Exception unused) {
                CyberLog.d(f42677a, "SDCard no free space");
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str = null;
            try {
                if (p(context)) {
                    str = Environment.getExternalStorageDirectory().getAbsolutePath();
                } else if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                    str = context.getExternalCacheDir().getPath();
                }
            } catch (Exception unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            nativeSetMaxConcurrentOperationCount(i2);
        }
    }

    public static void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2) == null) {
            nativeCleanFilecacheWithTimeExpired(j2);
        }
    }

    public static void e(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file) == null) {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        e(file2);
                    }
                }
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                CyberLog.w(f42677a, e2.toString());
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            nativeSetFileacheWorkDirectory(str);
        }
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            nativeVideoSRInit(str, str2);
        }
    }

    public static void h(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, str, z) == null) {
            try {
                String str2 = Build.DISPLAY;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "sdk-" + Build.VERSION.SDK_INT;
                }
                nativeMonitorInit(str, str2, z);
            } catch (Exception unused) {
            }
        }
    }

    public static void i(byte[] bArr, int i2, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, bArr, i2, bArr2) == null) {
            nativeKernelEncrypt(bArr, i2, bArr2);
        }
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            String b2 = b(context);
            if (TextUtils.isEmpty(b2)) {
                str = null;
            } else {
                str = b2 + File.separator + PathUtils.DIRCTORY_BAIDU + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + "duplayer" + File.separator + context.getPackageName();
            }
            String str2 = context.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
            CyberLog.i(f42677a, "Utils.getExternalStorageSpace():" + a());
            if (a() < 10485760 || str == null) {
                str = str2;
            }
            new File(str).mkdirs();
            if (!r(context)) {
                str = str + File.separator + "remote";
            }
            CyberLog.i(f42677a, "getVideoStatisticsPath folder:" + str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65548, null, j2) == null) {
            nativeUpdateStorageQuota(j2);
        }
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            nativeStrategyOptimizeInit(str);
        }
    }

    public static long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? nativeCaculateFolderSize() : invokeV.longValue;
    }

    public static native long nativeCaculateFolderSize();

    public static native void nativeCleanFilecache();

    public static native void nativeCleanFilecacheWithTimeExpired(long j2);

    public static native void nativeDecodeModeOptimizeInit(String str);

    public static native void nativeKernelEncrypt(byte[] bArr, int i2, byte[] bArr2);

    public static native void nativeMonitorInit(String str, String str2, boolean z);

    public static native void nativeSetFileacheWorkDirectory(String str);

    public static native void nativeSetMaxConcurrentOperationCount(int i2);

    public static native void nativeStrategyOptimizeInit(String str);

    public static native void nativeUpdateCfgOpts(String[] strArr, String[] strArr2);

    public static native void nativeUpdateStorageQuota(long j2);

    public static native void nativeVideoSRInit(String str, String str2);

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, str) == null) {
            nativeDecodeModeOptimizeInit(str);
        }
    }

    public static boolean p(Context context) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            if (context != null && (packageManager = context.getPackageManager()) != null) {
                try {
                    if (Build.VERSION.SDK_INT < 30) {
                        return packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", context.getPackageName()) == 0 && packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0;
                    }
                    CyberLog.i(f42677a, "android 11 no ExternalStorage Permission!");
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, null) == null) {
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
    }

    public static boolean r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (f42680d < 0) {
                if (context.getPackageName().equals(v(context))) {
                    f42680d = 1;
                } else {
                    f42680d = 0;
                }
            }
            return f42680d == 1;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            if (f42682f < 0) {
                f42682f = Build.VERSION.SDK_INT >= 23 ? Process.is64Bit() : ((BaseDexClassLoader) CyberPlayerManager.getApplicationContext().getClassLoader()).findLibrary("c").contains("lib64");
            }
            return f42682f == 1 ? "arm64-v8a" : "armeabi-v7a";
        }
        return (String) invokeV.objValue;
    }

    public static boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (f42681e < 0) {
                if ((context.getPackageName() + ":media").equals(v(context))) {
                    f42681e = 1;
                } else {
                    f42681e = 0;
                }
            }
            return f42681e == 1;
        }
        return invokeL.booleanValue;
    }

    public static String u() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65569, null)) != null) {
            return (String) invokeV.objValue;
        }
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

    public static String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            if (TextUtils.isEmpty(f42683g)) {
                f42683g = w(context);
                if (TextUtils.isEmpty(f42683g)) {
                    f42683g = u();
                }
                return f42683g;
            }
            return f42683g;
        }
        return (String) invokeL.objValue;
    }

    public static String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
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
        return (String) invokeL.objValue;
    }
}
