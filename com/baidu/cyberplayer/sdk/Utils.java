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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.YalogWrap;
import com.baidu.cyberplayer.sdk.utils.MD5Utils;
import com.baidu.mobads.sdk.internal.cl;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.kuaishou.weapon.p0.bk;
import com.kuaishou.weapon.p0.g;
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
public class Utils {
    public static final String BAIDU_APP_PACKAGE_NAME = "com.baidu.searchbox";
    public static final long DEFAULT_CRITICAL_THRESHOLD = 83886080;
    public static final long DEFAULT_WARING_THRESHOLD = 62914560;
    public static final String EQUAL = "=";
    public static final String ITEM_SEPARATOR = "&";
    public static final String LAST_DISK_AUTO_CLEAN_TIME = "cyber_last_disk_auto_clean_time";
    public static String LAST_FILE_CACHE_TIME = "last_file_cache_time";
    public static final long NORMAL_SPACE = 104857600;
    public static final String TAG = "sdk_Utils";
    public static final long TIME_INTERVAL = 86400000;
    public static String VIDEO_CACHE = ".video_cache";
    public static volatile int s64Bit = -1;
    public static volatile int sMainProcess = -1;
    public static volatile String sProcessName;

    public static long allowFloderSize() {
        return CyberCfgManager.getInstance().getCfgLongValue(CyberCfgManager.KEY_INT_FILE_CACHE_MAX_SIZE, 104857600L);
    }

    public static void cleanFilecacheAsyn() {
        CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.Utils.1
            @Override // java.lang.Runnable
            public void run() {
                Utils.cleanFilecache(Boolean.FALSE);
            }
        });
    }

    public static String formatNowDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public static long getCacheInterval() {
        return CyberCfgManager.getInstance().getCfgLongValue(CyberCfgManager.KEY_INT_FILE_CACHE_DELETE_INTERVAL, 86400000L);
    }

    public static String getCyberMediaPath() {
        return getInternalStorageFilesPath() + File.separator + "cybermedia";
    }

    public static String getInternalStorageFilesPath() {
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        File filesDir = applicationContext.getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath();
        }
        return "/data/data/" + applicationContext.getPackageName() + "/files";
    }

    public static long getInternalStorageSpace() {
        return CyberPlayerManager.getApplicationContext().getFilesDir().getUsableSpace();
    }

    public static String getProcessName() {
        if (!TextUtils.isEmpty(sProcessName)) {
            return sProcessName;
        }
        sProcessName = getProcessNameFromContext();
        if (TextUtils.isEmpty(sProcessName)) {
            sProcessName = getProcessNameFromFile();
        }
        return sProcessName;
    }

    public static String getProcessNameFromContext() {
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

    public static long getVideoCacheSize() {
        return CyberPlayerCoreInvoker.caculateFolderSize();
    }

    public static boolean isMainProcess() {
        if (sMainProcess < 0) {
            Context applicationContext = CyberPlayerManager.getApplicationContext();
            if (applicationContext == null) {
                sMainProcess = 1;
            } else if (applicationContext.getPackageName().equals(getProcessName())) {
                sMainProcess = 1;
            } else {
                sMainProcess = 0;
            }
        }
        if (sMainProcess != 1) {
            return false;
        }
        return true;
    }

    public static boolean isMainProcessAlive() {
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

    public static boolean isNetWorkCanUse() {
        String networkStatus = getNetworkStatus();
        if (!TextUtils.isEmpty(networkStatus) && !networkStatus.equals("Disconnect") && !networkStatus.equals("N/A")) {
            return true;
        }
        return false;
    }

    public static void saveFilecacheConfig() {
        CyberLog.i(TAG, "saveFilecacheConfig");
        CyberPlayerCoreInvoker.filecacheConfigSave();
    }

    public static void updateCyberVersionInfo() {
        SharedPreferences.Editor edit = CyberPlayerManager.getApplicationContext().getSharedPreferences("video_cfg_", 0).edit();
        edit.putString(VideoCloudSetting.PREF_KEY_CYBER_SDK_VERSION, SDKVersion.VERSION);
        edit.putString(VideoCloudSetting.PREF_KEY_CYBER_CORE_VERSION, CyberVersion.getCoreVersionInternal());
        edit.commit();
    }

    public static Map<String, String> JSONToMap(String str) {
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
                CyberLog.d(TAG, "setCloudSettings parserData JSONTokener error " + th);
            }
        }
        return hashMap;
    }

    public static Map<String, String> appendDuMediaUA(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        String str = map.get("User-Agent");
        if (TextUtils.isEmpty(str)) {
            str = "dumedia/7.41.99.35";
        } else if (str.indexOf(YalogWrap.YALOG_SPACE) == -1) {
            str = str + " dumedia/" + SDKVersion.VERSION;
        }
        map.put("User-Agent", str);
        return map;
    }

    public static boolean hasExternalStoragePermission(Context context) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    CyberLog.i(TAG, "android 11 no ExternalStorage Permission!");
                    return false;
                } else if (packageManager.checkPermission(g.i, context.getPackageName()) != 0 || packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) != 0) {
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isGrayRelease(String str) {
        if (str != null) {
            String[] split = str.split("\\.");
            if (split.length > 0) {
                try {
                    if (Integer.parseInt(split[split.length - 1]) >= 10) {
                        return false;
                    }
                    return true;
                } catch (NumberFormatException e) {
                    CyberLog.e(TAG, "appVersion is error: version: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + e.getMessage());
                }
            }
        }
        return false;
    }

    public static String RC4Decoder2String(byte[] bArr, String str) {
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
                byte b = bArr2[i4];
                bArr2[i4] = bArr2[i3];
                bArr2[i3] = b;
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
                    byte b2 = bArr2[i5];
                    bArr2[i5] = bArr2[i6];
                    bArr2[i6] = b2;
                    bArr3[i7] = (byte) (bArr[i7] ^ bArr2[(bArr2[i5] + bArr2[i6]) & 255]);
                }
                return new String(bArr3, "utf-8");
            }
            throw new RuntimeException("output buffer too short");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addRawLogItem(StringBuilder sb, String str, long j) {
        if (sb.length() > 0) {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
        sb.append(j);
    }

    public static void addRawLogItem(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("&");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
    }

    public static boolean checkFileMd5(String str, String str2) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str2);
            if (file.exists()) {
                String computeMD5Hash = MD5Utils.computeMD5Hash(file);
                CyberLog.d(TAG, str2 + "---->MD5\n" + str + "\n" + computeMD5Hash);
                if (!str.equalsIgnoreCase(computeMD5Hash)) {
                    return false;
                }
                return true;
            }
            throw new Exception(file.getName() + " is not exists");
        }
        throw null;
    }

    public static boolean checkFirstThreeVersionMatch(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        if (split.length < 3 || split2.length < 3 || !split[0].equals(split2[0]) || !split[1].equals(split2[1]) || !split[2].equals(split2[2])) {
            return false;
        }
        return true;
    }

    public static long cleanFilecache(Boolean bool) {
        long j = 0;
        if (!bool.booleanValue() && !needDeleteDirectory()) {
            return 0L;
        }
        long caculateFolderSize = CyberPlayerCoreInvoker.caculateFolderSize();
        if (!bool.booleanValue()) {
            j = CyberCfgManager.getInstance().getCfgLongValue(CyberCfgManager.KEY_FILE_LRU_EXPIRED_DURATION, 600L);
        }
        CyberPlayerCoreInvoker.cleanFilecacheWithTimeExpired(j);
        long caculateFolderSize2 = CyberPlayerCoreInvoker.caculateFolderSize();
        CyberCfgManager.getInstance().setPrefLong(LAST_FILE_CACHE_TIME, System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append("delete file success,  beforeSpace = ");
        sb.append(caculateFolderSize);
        sb.append(" afterSpace = ");
        sb.append(caculateFolderSize2);
        sb.append(" deleteSpaceSize = ");
        long j2 = caculateFolderSize - caculateFolderSize2;
        sb.append(j2);
        CyberLog.i(TAG, sb.toString());
        return j2;
    }

    public static void clearSurface(Surface surface) {
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
            } catch (Error | Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteFile(File file) {
        if (file == null) {
            return;
        }
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteFile(file2);
                }
            }
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            CyberLog.w(TAG, e.toString());
        }
    }

    public static String getCoreVersion(Context context) {
        if (context == null) {
            return SDKVersion.VERSION;
        }
        return context.getSharedPreferences("video_cfg_", 0).getString(VideoCloudSetting.PREF_KEY_CYBER_CORE_VERSION, SDKVersion.VERSION);
    }

    public static String getExternalStorageCacheDirectory(Context context) {
        String str = null;
        try {
            if (!hasExternalStoragePermission(context)) {
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

    public static boolean isVaildVersionFormat(String str) {
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

    public static void makeSureFolderExists(String str) {
        File file = new File(str);
        try {
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
        } catch (Exception unused) {
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, -1.0f);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void updateStorageQuota(long j) {
        CyberPlayerCoreInvoker.updateStorageQuota(j);
    }

    public static void deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        deleteFile(new File(str));
    }

    public static void deleteFiles(String str, ArrayList<String> arrayList) {
        if (str != null && arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                deleteFile(str + File.separator + arrayList.get(i));
            }
        }
    }

    public static int removeFilecacheReserveUrl(String str, boolean z) {
        CyberLog.i(TAG, "removeFilecacheReserveUrl");
        return CyberPlayerCoreInvoker.filecacheRemoveReserveUrl(str, z);
    }

    public static String getCpuString() {
        if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
            return "Intel";
        }
        String str = "";
        try {
            byte[] bArr = new byte[1024];
            RandomAccessFile randomAccessFile = new RandomAccessFile(bk.a, "r");
            randomAccessFile.read(bArr);
            String str2 = new String(bArr);
            int indexOf = str2.indexOf(0);
            if (indexOf != -1) {
                str = str2.substring(0, indexOf);
            } else {
                str = str2;
            }
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static long getExternalStorageSpace() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return -1L;
            }
            String path = Environment.getExternalStorageDirectory().getPath();
            if (path != null && path.length() > 0) {
                StatFs statFs = new StatFs(path);
                return statFs.getBlockSize() * statFs.getAvailableBlocks();
            }
            CyberLog.w(TAG, "External path is null, so SDCard no free space");
            return -1L;
        } catch (Exception unused) {
            CyberLog.w(TAG, "SDCard no free space");
            return -1L;
        }
    }

    public static String getLoadLibsABI() {
        if (s64Bit < 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                s64Bit = Process.is64Bit() ? 1 : 0;
            } else {
                s64Bit = ((BaseDexClassLoader) CyberPlayerManager.getApplicationContext().getClassLoader()).findLibrary("c").contains("lib64") ? 1 : 0;
            }
        }
        if (s64Bit == 1) {
            return "arm64-v8a";
        }
        return PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
    }

    public static String getSystemHttpProxy() {
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

    public static String getCpuType() {
        String cpuString = getCpuString();
        if (TextUtils.isEmpty(cpuString)) {
            return Build.CPU_ABI;
        }
        String str = "AArch64";
        if (cpuString.contains("ARMv5")) {
            str = "armv5";
        } else if (cpuString.contains("ARMv6")) {
            str = "armv6";
        } else {
            if (!cpuString.contains("ARMv7")) {
                if (cpuString.contains("Intel")) {
                    str = "x86";
                } else if (!cpuString.contains("AArch64")) {
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
        if (cpuString.contains("neon")) {
            return str + "-neon";
        } else if (cpuString.contains("vfpv3")) {
            return str + "-vfpv3";
        } else if (cpuString.contains(" vfp")) {
            return str + "-vfp";
        } else {
            return str + "-none";
        }
    }

    public static String getNetworkStatus() {
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

    public static String getProcessNameFromFile() {
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

    public static String getVideoStatisticsPath(Context context) {
        String str = null;
        if (context == null) {
            CyberLog.e(TAG, "getVideoStatisticsPath ctx = null");
            return null;
        }
        String externalStorageCacheDirectory = getExternalStorageCacheDirectory(context);
        if (!TextUtils.isEmpty(externalStorageCacheDirectory)) {
            str = externalStorageCacheDirectory + File.separator + "baidu" + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + "duplayer" + File.separator + context.getPackageName();
        }
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
        CyberLog.i(TAG, "Utils.getExternalStorageSpace():" + getExternalStorageSpace());
        if (getExternalStorageSpace() < Config.FULL_TRACE_LOG_LIMIT || str == null) {
            str = str2;
        }
        new File(str).mkdirs();
        if (!isMainProcess()) {
            str = str + File.separator + cl.b;
        }
        CyberLog.i(TAG, "getVideoStatisticsPath folder:" + str);
        return str;
    }

    public static boolean needDeleteDirectory() {
        boolean z;
        boolean z2;
        try {
            long prefLong = CyberCfgManager.getInstance().getPrefLong(LAST_FILE_CACHE_TIME, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (prefLong > 0) {
                if (currentTimeMillis - prefLong > getCacheInterval()) {
                    z = true;
                } else {
                    z = false;
                }
                long caculateFolderSize = CyberPlayerCoreInvoker.caculateFolderSize();
                if (caculateFolderSize > allowFloderSize()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                CyberLog.i(TAG, "needDeleteDirectory(),  currentDiskCacheSize = " + caculateFolderSize + " allowMaxSize = " + allowFloderSize());
                if (z || z2) {
                    return true;
                }
                return false;
            }
            CyberCfgManager.getInstance().setPrefLong(LAST_FILE_CACHE_TIME, currentTimeMillis);
            return false;
        } catch (Exception | OutOfMemoryError unused) {
            return true;
        }
    }
}
