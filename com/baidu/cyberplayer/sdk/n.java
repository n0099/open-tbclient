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
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes12.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static String f1401a = ".video_cache";
    public static String b = "last_file_cache_time";
    public static long c = 86400000;
    public static long d = 536870912;
    private static volatile int e = -1;
    private static volatile int f = -1;
    private static volatile String g = null;

    public static long a(Boolean bool) {
        if (bool.booleanValue() || r()) {
            long i = d.i();
            d.f();
            long i2 = d.i();
            CyberCfgManager.getInstance().setPrefLong(b, System.currentTimeMillis());
            CyberLog.i("sdk_Utils", "delete file success,  beforeSpace = " + i + " afterSpace = " + i2 + " deleteSpaceSize = " + (i - i2));
            return i - i2;
        }
        return 0L;
    }

    public static Bitmap a(Bitmap bitmap) {
        if (bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, -1.0f);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String a() {
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        File filesDir = applicationContext.getFilesDir();
        return filesDir != null ? filesDir.getAbsolutePath() : "/data/data/" + applicationContext.getPackageName() + "/files";
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

    public static String a(File file) {
        if (file == null || !file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            fileInputStream.close();
            byte[] digest = messageDigest.digest();
            char[] charArray = "0123456789abcdef".toCharArray();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (int i = 0; i < digest.length; i++) {
                sb.append(charArray[(digest[i] >> 4) & 15]);
                sb.append(charArray[digest[i] & 15]);
            }
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr, 0, bArr.length);
            byte[] digest = messageDigest.digest();
            char[] charArray = "0123456789abcdef".toCharArray();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (int i = 0; i < digest.length; i++) {
                sb.append(charArray[(digest[i] >> 4) & 15]);
                sb.append(charArray[digest[i] & 15]);
            }
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr, String str) {
        try {
            byte[] bytes = str.getBytes();
            byte[] bArr2 = 0 == 0 ? new byte[256] : null;
            for (int i = 0; i < 256; i++) {
                bArr2[i] = (byte) i;
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                i2 = (i2 + (bytes[i3] & 255) + bArr2[i4]) & 255;
                byte b2 = bArr2[i4];
                bArr2[i4] = bArr2[i2];
                bArr2[i2] = b2;
                i3 = (i3 + 1) % bytes.length;
            }
            byte[] bArr3 = new byte[bArr.length];
            int length = bArr.length;
            if (length > bArr3.length) {
                throw new RuntimeException("output buffer too short");
            }
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                i6 = (i6 + 1) & 255;
                i5 = (i5 + bArr2[i6]) & 255;
                byte b3 = bArr2[i6];
                bArr2[i6] = bArr2[i5];
                bArr2[i5] = b3;
                bArr3[i7] = (byte) (bArr[i7] ^ bArr2[(bArr2[i6] + bArr2[i5]) & 255]);
            }
            return new String(bArr3, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> a(File file, String str) throws Exception {
        CyberLog.d("sdk_Utils", "unzipFile start");
        if (file == null) {
            throw new Exception("zip file is null");
        }
        if (file.exists()) {
            if (file.length() > 524288000) {
                throw new Exception("zip file too large");
            }
            if (str == null) {
                throw new Exception("unzipFolder is null");
            }
            File file2 = new File(str);
            if (file2.exists() && file2.isDirectory()) {
                ArrayList<String> arrayList = new ArrayList<>();
                ZipFile zipFile = new ZipFile(file);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                byte[] bArr = new byte[1024];
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.getName().contains("../")) {
                        File file3 = new File(str, nextElement.getName());
                        if (nextElement.isDirectory()) {
                            try {
                                if (!file3.exists()) {
                                    file3.mkdirs();
                                    arrayList.add(nextElement.getName());
                                }
                            } catch (Exception e2) {
                            }
                        } else {
                            try {
                                if (!file3.getParentFile().exists()) {
                                    file3.mkdirs();
                                }
                            } catch (Exception e3) {
                            }
                            arrayList.add(nextElement.getName());
                            CyberLog.d("sdk_Utils", "dstFile:" + file3.getAbsolutePath());
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(nextElement));
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 1024);
                                if (read == -1) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                        }
                    }
                }
                zipFile.close();
                CyberLog.w("sdk_Utils", "unzipFile success");
                return arrayList;
            }
            throw new Exception("directory not exist");
        }
        throw new Exception("zip file not exist");
    }

    public static Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        String str = map.get("User-Agent");
        if (TextUtils.isEmpty(str)) {
            str = "dumedia/7.12.2.49";
        } else if (str.indexOf("dumedia") == -1) {
            str = str + " dumedia/" + SDKVersion.VERSION;
        }
        map.put("User-Agent", str);
        return map;
    }

    public static void a(String str) {
        b(new File(str));
    }

    public static void a(String str, ArrayList<String> arrayList) {
        if (str == null || arrayList == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            a(str + File.separator + arrayList.get(i2));
            i = i2 + 1;
        }
    }

    public static void a(StringBuilder sb, String str, long j) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append(ETAG.EQUAL);
        sb.append(j);
    }

    public static void a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append(ETAG.EQUAL);
        sb.append(str2);
    }

    public static boolean a(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException();
        }
        File file = new File(str2);
        if (file.exists()) {
            String a2 = a(file);
            CyberLog.d("sdk_Utils", str2 + "---->MD5\n" + str + "\n" + a2);
            return str.equalsIgnoreCase(a2);
        }
        throw new Exception(file.getName() + " is not exists");
    }

    public static String b() {
        return a() + File.separator + "cybermedia";
    }

    public static String b(Context context) {
        if (context == null) {
            CyberLog.e("sdk_Utils", "getVideoStatisticsPath ctx = null");
        } else {
            String a2 = a(context);
            r0 = TextUtils.isEmpty(a2) ? null : a2 + File.separator + "baidu" + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + "duplayer" + File.separator + context.getPackageName();
            String str = context.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
            CyberLog.i("sdk_Utils", "Utils.getExternalStorageSpace():" + f());
            if (f() < 10485760 || r0 == null) {
                r0 = str;
            }
            new File(r0).mkdirs();
            if (!m()) {
                r0 = r0 + File.separator + "remote";
            }
            CyberLog.i("sdk_Utils", "getVideoStatisticsPath folder:" + r0);
        }
        return r0;
    }

    public static void b(File file) {
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    b(file2);
                }
            }
            file.delete();
        } catch (Exception e2) {
            CyberLog.w("sdk_Utils", e2.toString());
        }
    }

    public static void b(String str) {
        File file = new File(str);
        try {
            if (file.exists() && file.isDirectory()) {
                return;
            }
            file.mkdirs();
        } catch (Exception e2) {
        }
    }

    public static String c() {
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

    public static String d() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date(System.currentTimeMillis()));
    }

    public static long e() {
        return CyberPlayerManager.getApplicationContext().getFilesDir().getUsableSpace();
    }

    public static long f() {
        long j = -1;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                String path = Environment.getExternalStorageDirectory().getPath();
                if (path == null || path.length() <= 0) {
                    CyberLog.w("sdk_Utils", "External path is null, so SDCard no free space");
                } else {
                    StatFs statFs = new StatFs(path);
                    j = statFs.getAvailableBlocks() * statFs.getBlockSize();
                }
            }
        } catch (Exception e2) {
            CyberLog.w("sdk_Utils", "SDCard no free space");
        }
        return j;
    }

    public static String g() {
        String p = p();
        if (TextUtils.isEmpty(p)) {
            return Build.CPU_ABI;
        }
        String str = p.contains("ARMv5") ? "armv5" : p.contains("ARMv6") ? "armv6" : p.contains("ARMv7") ? "armv7" : p.contains("Intel") ? "x86" : p.contains("AArch64") ? "AArch64" : !TextUtils.isEmpty(Build.CPU_ABI) ? Build.CPU_ABI.equals("armeabi-v7a") ? "armv7" : Build.CPU_ABI : "unknown";
        return p.contains("neon") ? str + "-neon" : p.contains("vfpv3") ? str + "-vfpv3" : p.contains(" vfp") ? str + "-vfp" : str + "-none";
    }

    public static void h() {
        SharedPreferences.Editor edit = CyberPlayerManager.getApplicationContext().getSharedPreferences(VideoCloudSetting.PREF_NAME, 0).edit();
        edit.putString(VideoCloudSetting.PREF_KEY_CYBER_SDK_VERSION, SDKVersion.VERSION);
        edit.putString(VideoCloudSetting.PREF_KEY_CYBER_CORE_VERSION, CyberPlayerManager.getCoreVersion());
        edit.commit();
    }

    public static String i() {
        String str;
        try {
            Context applicationContext = CyberPlayerManager.getApplicationContext();
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    str = "Disconnect";
                } else {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        str = activeNetworkInfo.getExtraInfo();
                        if (TextUtils.isEmpty(str)) {
                            str = "Disconnect";
                        }
                    } else if (type == 1) {
                        WifiManager wifiManager = (WifiManager) applicationContext.getSystemService("wifi");
                        if (wifiManager != null) {
                            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                            if (connectionInfo != null) {
                                int rssi = connectionInfo.getRssi();
                                str = rssi <= -127 ? "Disconnect" : "wifi:" + rssi;
                            } else {
                                str = "Disconnect";
                            }
                        } else {
                            str = "Disconnect";
                        }
                    } else {
                        str = "N/A";
                    }
                }
            } else {
                str = "N/A";
            }
            return str;
        } catch (Exception e2) {
            return "N/A";
        }
    }

    public static void j() {
        CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.a((Boolean) false);
            }
        });
    }

    public static long k() {
        return d.i();
    }

    public static String l() {
        if (TextUtils.isEmpty(g)) {
            g = t();
            if (TextUtils.isEmpty(g)) {
                g = u();
            }
            return g;
        }
        return g;
    }

    public static boolean m() {
        if (e < 0) {
            Context applicationContext = CyberPlayerManager.getApplicationContext();
            if (applicationContext == null) {
                e = 1;
            } else if (applicationContext.getPackageName().equals(l())) {
                e = 1;
            } else {
                e = 0;
            }
        }
        return e == 1;
    }

    public static boolean n() {
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) applicationContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (packageName.equals(runningAppProcessInfo.processName)) {
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
        }
        return false;
    }

    public static String o() {
        if (f < 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                f = Process.is64Bit() ? 1 : 0;
            } else {
                f = ((BaseDexClassLoader) CyberPlayerManager.getApplicationContext().getClassLoader()).findLibrary("c").contains("lib64") ? 1 : 0;
            }
        }
        return f == 1 ? "arm64-v8a" : "armeabi-v7a";
    }

    private static String p() {
        String str;
        IOException e2;
        if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
            return "Intel";
        }
        try {
            byte[] bArr = new byte[1024];
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
            randomAccessFile.read(bArr);
            str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            try {
                randomAccessFile.close();
                return str;
            } catch (IOException e3) {
                e2 = e3;
                e2.printStackTrace();
                return str;
            }
        } catch (IOException e4) {
            str = "";
            e2 = e4;
        }
    }

    private static long q() {
        return CyberCfgManager.getInstance().getCfgLongValue("file_cache_max_size", d);
    }

    private static boolean r() {
        boolean z = false;
        try {
            long prefLong = CyberCfgManager.getInstance().getPrefLong(b, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (prefLong > 0) {
                boolean z2 = currentTimeMillis - prefLong > s();
                boolean z3 = d.i() > q();
                if (z2 || z3) {
                    z = true;
                }
            } else {
                CyberCfgManager.getInstance().setPrefLong(b, currentTimeMillis);
            }
            return z;
        } catch (Exception e2) {
            return true;
        } catch (OutOfMemoryError e3) {
            return true;
        }
    }

    private static long s() {
        return CyberCfgManager.getInstance().getCfgLongValue("file_cache_delete_interval", c);
    }

    private static String t() {
        int myPid = Process.myPid();
        try {
            ActivityManager activityManager = (ActivityManager) CyberPlayerManager.getApplicationContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e2) {
        }
        return null;
    }

    private static String u() {
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
}
