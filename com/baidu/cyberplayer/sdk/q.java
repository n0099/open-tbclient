package com.baidu.cyberplayer.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.kuaishou.weapon.p0.k1;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes3.dex */
public class q {
    public static String a = ".video_cache";
    public static String b = "last_file_cache_time";
    public static volatile int c = -1;
    public static volatile int d = -1;
    public static volatile String e;

    public static long a(Boolean bool) {
        long j = 0;
        if (!bool.booleanValue() && !t()) {
            return 0L;
        }
        long j2 = f.j();
        if (!bool.booleanValue()) {
            j = CyberCfgManager.getInstance().getCfgLongValue(CyberCfgManager.KEY_FILE_LRU_EXPIRED_DURATION, 600L);
        }
        f.a(j);
        long j3 = f.j();
        CyberCfgManager.getInstance().setPrefLong(b, System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append("delete file success,  beforeSpace = ");
        sb.append(j2);
        sb.append(" afterSpace = ");
        sb.append(j3);
        sb.append(" deleteSpaceSize = ");
        long j4 = j2 - j3;
        sb.append(j4);
        CyberLog.i("sdk_Utils", sb.toString());
        return j4;
    }

    public static Bitmap a(Bitmap bitmap) {
        if (bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, -1.0f);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void b(String str) {
        File file = new File(str);
        try {
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
        } catch (Exception unused) {
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            try {
                Integer.parseInt(split[i]);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return true;
    }

    public static String a() {
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        File filesDir = applicationContext.getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath();
        }
        return "/data/data/" + applicationContext.getPackageName() + "/files";
    }

    public static String b() {
        return a() + File.separator + "cybermedia";
    }

    public static String d() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public static long e() {
        return CyberPlayerManager.getApplicationContext().getFilesDir().getUsableSpace();
    }

    public static void h() {
        SharedPreferences.Editor edit = CyberPlayerManager.getApplicationContext().getSharedPreferences(VideoCloudSetting.PREF_NAME, 0).edit();
        edit.putString(VideoCloudSetting.PREF_KEY_CYBER_SDK_VERSION, SDKVersion.VERSION);
        edit.putString(VideoCloudSetting.PREF_KEY_CYBER_CORE_VERSION, CyberVersion.getCoreVersionInternal());
        edit.commit();
    }

    public static boolean j() {
        String i = i();
        if (!TextUtils.isEmpty(i) && !i.equals("Disconnect") && !i.equals("N/A")) {
            return true;
        }
        return false;
    }

    public static void k() {
        CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.q.1
            @Override // java.lang.Runnable
            public void run() {
                q.a(Boolean.FALSE);
            }
        });
    }

    public static long l() {
        return CyberCfgManager.getInstance().getCfgLongValue("file_cache_delete_interval", 86400000L);
    }

    public static long m() {
        return f.j();
    }

    public static String n() {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        e = u();
        if (TextUtils.isEmpty(e)) {
            e = v();
        }
        return e;
    }

    public static boolean o() {
        if (c < 0) {
            Context applicationContext = CyberPlayerManager.getApplicationContext();
            if (applicationContext == null) {
                c = 1;
            } else if (applicationContext.getPackageName().equals(n())) {
                c = 1;
            } else {
                c = 0;
            }
        }
        if (c != 1) {
            return false;
        }
        return true;
    }

    public static boolean p() {
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) applicationContext.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (packageName.equals(runningAppProcessInfo.processName)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long s() {
        return CyberCfgManager.getInstance().getCfgLongValue("file_cache_max_size", 104857600L);
    }

    public static String u() {
        int myPid = Process.myPid();
        try {
            ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        String str = null;
        try {
            if (!c(context)) {
                if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                    str = context.getExternalCacheDir().getPath();
                }
            } else {
                str = Environment.getExternalStorageDirectory().getAbsolutePath();
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static String a(byte[] bArr, String str) {
        try {
            byte[] bytes = str.getBytes();
            byte[] bArr2 = new byte[256];
            for (int i = 0; i < 256; i++) {
                bArr2[i] = (byte) i;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                i3 = ((bytes[i2] & 255) + bArr2[i4] + i3) & 255;
                byte b2 = bArr2[i4];
                bArr2[i4] = bArr2[i3];
                bArr2[i3] = b2;
                i2 = (i2 + 1) % bytes.length;
            }
            int length = bArr.length;
            byte[] bArr3 = new byte[length];
            int length2 = bArr.length;
            if (length2 <= length) {
                int i5 = 0;
                int i6 = 0;
                for (int i7 = 0; i7 < length2; i7++) {
                    i5 = (i5 + 1) & 255;
                    i6 = (bArr2[i5] + i6) & 255;
                    byte b3 = bArr2[i5];
                    bArr2[i5] = bArr2[i6];
                    bArr2[i6] = b3;
                    bArr3[i7] = (byte) (bArr[i7] ^ bArr2[(bArr2[i5] + bArr2[i6]) & 255]);
                }
                return new String(bArr3, "utf-8");
            }
            throw new RuntimeException("output buffer too short");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        String str = map.get("User-Agent");
        if (TextUtils.isEmpty(str)) {
            str = "dumedia/7.39.93.45";
        } else if (str.indexOf("dumedia") == -1) {
            str = str + " dumedia/" + SDKVersion.VERSION;
        }
        map.put("User-Agent", str);
        return map;
    }

    public static Map<String, String> c(String str) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                CyberLog.d("sdk_Utils", "setCloudSettings parserData JSONTokener error " + th);
            }
        }
        return hashMap;
    }

    public static void a(long j) {
        f.c(j);
    }

    public static void a(Surface surface) {
        if (surface != null) {
            try {
                if (surface.isValid()) {
                    EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                    int[] iArr = new int[2];
                    EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1);
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    EGL14.eglChooseConfig(eglGetDisplay, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                    EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surface, new int[]{12344}, 0);
                    EGL14.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16384);
                    EGL14.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                    EGL14.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                    EGL14.eglMakeCurrent(eglGetDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
                    EGL14.eglDestroyContext(eglGetDisplay, eglCreateContext);
                    EGL14.eglTerminate(eglGetDisplay);
                }
            } catch (Error | Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(File file) {
        if (file == null) {
            return;
        }
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
            CyberLog.w("sdk_Utils", e2.toString());
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(new File(str));
    }

    public static void a(String str, ArrayList<String> arrayList) {
        if (str != null && arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                a(str + File.separator + arrayList.get(i));
            }
        }
    }

    public static void a(StringBuilder sb, String str, long j) {
        if (sb.length() > 0) {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
        sb.append(j);
    }

    public static void a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
    }

    public static boolean a(String str, String str2) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str2);
            if (file.exists()) {
                String a2 = com.baidu.cyberplayer.sdk.utils.b.a(file);
                CyberLog.d("sdk_Utils", str2 + "---->MD5\n" + str + "\n" + a2);
                if (!str.equalsIgnoreCase(a2)) {
                    return false;
                }
                return true;
            }
            throw new Exception(file.getName() + " is not exists");
        }
        throw null;
    }

    public static String b(Context context) {
        String str = null;
        if (context == null) {
            CyberLog.e("sdk_Utils", "getVideoStatisticsPath ctx = null");
            return null;
        }
        String a2 = a(context);
        if (!TextUtils.isEmpty(a2)) {
            str = a2 + File.separator + "baidu" + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + "duplayer" + File.separator + context.getPackageName();
        }
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
        CyberLog.i("sdk_Utils", "Utils.getExternalStorageSpace():" + f());
        if (f() < Config.FULL_TRACE_LOG_LIMIT || str == null) {
            str = str2;
        }
        new File(str).mkdirs();
        if (!o()) {
            str = str + File.separator + "remote";
        }
        CyberLog.i("sdk_Utils", "getVideoStatisticsPath folder:" + str);
        return str;
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost != null && defaultHost.length() > 0 && defaultPort >= 0 && defaultPort <= 65535) {
            sb.append(defaultHost);
            sb.append(":");
            sb.append(String.valueOf(defaultPort));
            return sb.toString();
        }
        return null;
    }

    public static long f() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return -1L;
            }
            String path = Environment.getExternalStorageDirectory().getPath();
            if (path != null && path.length() > 0) {
                StatFs statFs = new StatFs(path);
                return statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
            CyberLog.w("sdk_Utils", "External path is null, so SDCard no free space");
            return -1L;
        } catch (Exception unused) {
            CyberLog.w("sdk_Utils", "SDCard no free space");
            return -1L;
        }
    }

    public static String q() {
        if (d < 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                d = Process.is64Bit() ? 1 : 0;
            } else {
                d = ((BaseDexClassLoader) CyberPlayerManager.getApplicationContext().getClassLoader()).findLibrary("c").contains("lib64") ? 1 : 0;
            }
        }
        if (d == 1) {
            return "arm64-v8a";
        }
        return PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
    }

    public static String r() {
        if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
            return "Intel";
        }
        String str = "";
        try {
            byte[] bArr = new byte[1024];
            RandomAccessFile randomAccessFile = new RandomAccessFile(k1.a, "r");
            randomAccessFile.read(bArr);
            String str2 = new String(bArr);
            int indexOf = str2.indexOf(0);
            if (indexOf != -1) {
                str = str2.substring(0, indexOf);
            } else {
                str = str2;
            }
            randomAccessFile.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public static boolean c(Context context) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    CyberLog.i("sdk_Utils", "android 11 no ExternalStorage Permission!");
                    return false;
                } else if (packageManager.checkPermission(com.kuaishou.weapon.p0.h.i, context.getPackageName()) != 0 || packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) != 0) {
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static String g() {
        String r = r();
        if (TextUtils.isEmpty(r)) {
            return Build.CPU_ABI;
        }
        String str = "AArch64";
        if (r.contains("ARMv5")) {
            str = "armv5";
        } else if (r.contains("ARMv6")) {
            str = "armv6";
        } else {
            if (!r.contains("ARMv7")) {
                if (r.contains("Intel")) {
                    str = "x86";
                } else if (!r.contains("AArch64")) {
                    if (!TextUtils.isEmpty(Build.CPU_ABI)) {
                        if (!Build.CPU_ABI.equals(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A)) {
                            str = Build.CPU_ABI;
                        }
                    } else {
                        str = "unknown";
                    }
                }
            }
            str = "armv7";
        }
        if (r.contains("neon")) {
            return str + "-neon";
        } else if (r.contains("vfpv3")) {
            return str + "-vfpv3";
        } else if (r.contains(" vfp")) {
            return str + "-vfp";
        } else {
            return str + "-none";
        }
    }

    public static String i() {
        WifiInfo connectionInfo;
        int rssi;
        try {
            Context applicationContext = CyberPlayerManager.getApplicationContext();
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return "Disconnect";
                }
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    if (TextUtils.isEmpty(activeNetworkInfo.getExtraInfo())) {
                        return "Disconnect";
                    }
                    return "mobile_connect";
                } else if (type == 1) {
                    WifiManager wifiManager = (WifiManager) applicationContext.getSystemService("wifi");
                    if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && (rssi = connectionInfo.getRssi()) > -127) {
                        return "wifi:" + rssi;
                    }
                    return "Disconnect";
                }
            }
        } catch (Exception unused) {
        }
        return "N/A";
    }

    public static String v() {
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

    public static boolean t() {
        boolean z;
        boolean z2;
        try {
            long prefLong = CyberCfgManager.getInstance().getPrefLong(b, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (prefLong > 0) {
                if (currentTimeMillis - prefLong > l()) {
                    z = true;
                } else {
                    z = false;
                }
                long j = f.j();
                if (j > s()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                CyberLog.i("sdk_Utils", "needDeleteDirectory(),  currentDiskCacheSize = " + j + " allowMaxSize = " + s());
                if (z || z2) {
                    return true;
                }
                return false;
            }
            CyberCfgManager.getInstance().setPrefLong(b, currentTimeMillis);
            return false;
        } catch (Exception | OutOfMemoryError unused) {
            return true;
        }
    }
}
