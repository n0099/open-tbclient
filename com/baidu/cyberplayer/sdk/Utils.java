package com.baidu.cyberplayer.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class Utils {
    public static String a = ".video_cache";
    public static String b = "last_file_cache_time";
    public static long c = 86400000;
    public static long d = IjkMediaMeta.AV_CH_STEREO_LEFT;

    public static long a(Boolean bool) {
        if (bool.booleanValue() || m()) {
            long g = c.g();
            c.d();
            long g2 = c.g();
            CyberCfgManager.getInstance().setPrefLong(b, System.currentTimeMillis());
            CyberLog.i("sdk_Utils", "delete file success,  beforeSpace = " + g + " afterSpace = " + g2 + " deleteSpaceSize = " + (g - g2));
            return g - g2;
        }
        return 0L;
    }

    public static Bitmap a(Bitmap bitmap) {
        if (bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, -1.0f);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String a() {
        Context applicationContext = CyberPlayerManager.getApplicationContext();
        File filesDir = applicationContext.getFilesDir();
        return filesDir != null ? filesDir.getAbsolutePath() : "/data/data/" + applicationContext.getPackageName() + "/files";
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
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
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
                        arrayList.add(nextElement.getName());
                        if (nextElement.isDirectory()) {
                            new File(str + File.separator + nextElement.getName()).mkdir();
                        } else {
                            File file3 = new File(str, nextElement.getName());
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

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return context.getPackageName().equals(b(context));
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
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static void b(File file) {
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    b(file2);
                }
            }
            file.delete();
        } catch (Exception e) {
            CyberLog.w("sdk_Utils", e.toString());
        }
    }

    public static void b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static String c() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
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
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
            if (packageName.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }

    public static long d() {
        return CyberPlayerManager.getApplicationContext().getFilesDir().getUsableSpace();
    }

    @Keep
    public static void deleteMismatchChildFile(String str, String str2, String str3) {
        File[] listFiles;
        File file = new File(str, str2);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (!listFiles[i].getName().equals(str3)) {
                b(listFiles[i]);
            }
        }
    }

    public static long e() {
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
        } catch (Exception e) {
            CyberLog.w("sdk_Utils", "SDCard no free space");
        }
        return j;
    }

    public static String f() {
        String k = k();
        if (TextUtils.isEmpty(k)) {
            return Build.CPU_ABI;
        }
        String str = k.contains("ARMv5") ? "armv5" : k.contains("ARMv6") ? "armv6" : k.contains("ARMv7") ? "armv7" : k.contains("Intel") ? PassBiometricUtil.CPU_TYPE_X86 : k.contains("AArch64") ? "AArch64" : !TextUtils.isEmpty(Build.CPU_ABI) ? Build.CPU_ABI.equals(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A) ? "armv7" : Build.CPU_ABI : "unknown";
        return k.contains("neon") ? str + "-neon" : k.contains("vfpv3") ? str + "-vfpv3" : k.contains(" vfp") ? str + "-vfp" : str + "-none";
    }

    public static void g() {
        SharedPreferences.Editor edit = CyberPlayerManager.getApplicationContext().getSharedPreferences("video_cfg_", 0).edit();
        edit.putString("video_cyber_sdk_version", SDKVersion.VERSION);
        edit.putString("video_cyber_core_version", CyberPlayerManager.getCoreVersion());
        edit.commit();
    }

    public static String h() {
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
        } catch (Exception e) {
            return "N/A";
        }
    }

    public static void i() {
        CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.Utils.1
            @Override // java.lang.Runnable
            public void run() {
                Utils.a((Boolean) false);
            }
        });
    }

    public static long j() {
        return c.g();
    }

    private static String k() {
        String str;
        IOException e;
        if (Build.CPU_ABI.equalsIgnoreCase(PassBiometricUtil.CPU_TYPE_X86)) {
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
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return str;
            }
        } catch (IOException e3) {
            str = "";
            e = e3;
        }
    }

    private static long l() {
        return CyberCfgManager.getInstance().getCfgLongValue("file_cache_max_size", d);
    }

    private static boolean m() {
        boolean z = false;
        try {
            long prefLong = CyberCfgManager.getInstance().getPrefLong(b, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (prefLong > 0) {
                boolean z2 = currentTimeMillis - prefLong > n();
                boolean z3 = c.g() > l();
                if (z2 || z3) {
                    z = true;
                }
            } else {
                CyberCfgManager.getInstance().setPrefLong(b, currentTimeMillis);
            }
            return z;
        } catch (Exception e) {
            return true;
        } catch (OutOfMemoryError e2) {
            return true;
        }
    }

    private static long n() {
        return CyberCfgManager.getInstance().getCfgLongValue("file_cache_delete_interval", c);
    }
}
