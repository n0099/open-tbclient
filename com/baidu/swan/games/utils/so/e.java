package com.baidu.swan.games.utils.so;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.storage.c.h;
import java.io.File;
import java.util.HashMap;
import java.util.zip.ZipFile;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String dhR = com.baidu.swan.apps.r.e.afO() + "/v8_so/";
    private static final String[] dhS = {"v8.engine", "zeusv8"};
    private static String dhT = null;

    public static boolean a(@NonNull Context context, @NonNull SoLoader soLoader) {
        boolean z = true;
        File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, "com.baidu.zeus");
        boolean z2 = findSoFilesInLibrary != null && findSoFilesInLibrary.length() > 0;
        if (DEBUG) {
            Log.i("V8InnerSoLoader", "loadV8EngineSo: v8 dependentFile:" + (z2 ? findSoFilesInLibrary.getAbsolutePath() : null));
        }
        if (!z2 || !a(soLoader, findSoFilesInLibrary)) {
            d.aDw();
            if (!b(context, soLoader) && !(z = c(context, soLoader))) {
                SoUtils.sendLog(soLoader.getErrorLog());
            }
        }
        return z;
    }

    private static boolean a(@NonNull SoLoader soLoader, @NonNull File file) {
        try {
            System.loadLibrary("v8.engine");
            dhT = file.getAbsolutePath();
            return true;
        } catch (Throwable th) {
            soLoader.appendErrorLog("loadV8EngineSo: " + th.getMessage());
            return false;
        }
    }

    private static boolean b(@NonNull Context context, @NonNull SoLoader soLoader) {
        String[] strArr;
        dhT = null;
        HashMap hashMap = new HashMap();
        for (String str : dhS) {
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, str);
            hashMap.put(str, findSoFilesInLibrary != null && findSoFilesInLibrary.exists() && (findSoFilesInLibrary.length() > 0L ? 1 : (findSoFilesInLibrary.length() == 0L ? 0 : -1)) != 0 ? findSoFilesInLibrary.getAbsolutePath() : null);
        }
        return a(hashMap, soLoader);
    }

    private static boolean a(@NonNull HashMap<String, String> hashMap, @NonNull SoLoader soLoader) {
        String str = hashMap.get("v8.engine");
        String str2 = hashMap.get("zeusv8");
        if (DEBUG) {
            Log.d("V8InnerSoLoader", "loadV8EngineSoByMap:" + hashMap);
        }
        if (str2 == null || str == null) {
            return false;
        }
        try {
            System.load(str2);
        } catch (Throwable th) {
            soLoader.appendErrorLog("loadZeusError:" + th.getMessage());
        }
        try {
            System.load(str);
            return true;
        } catch (Throwable th2) {
            soLoader.appendErrorLog("loadV8Error:" + th2.getMessage());
            return false;
        }
    }

    private static boolean c(@NonNull Context context, @NonNull SoLoader soLoader) {
        String[] strArr;
        dhT = null;
        HashMap hashMap = new HashMap();
        String versionName = aj.getVersionName();
        File file = new File(dhR, versionName);
        for (String str : dhS) {
            File file2 = new File(file, SoUtils.getFullName(str));
            hashMap.put(str, file2.exists() && (file2.length() > 0L ? 1 : (file2.length() == 0L ? 0 : -1)) != 0 ? file2.getAbsolutePath() : null);
        }
        if (!hashMap.containsValue(null)) {
            return a(hashMap, soLoader);
        }
        String str2 = "swan_v8so_unzip_times_" + versionName;
        int i = h.asV().getInt(str2, 0);
        if (i >= 3) {
            soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:reach max unzip times.");
            return false;
        }
        h.asV().putInt(str2, i + 1);
        String str3 = "lib" + File.separator + SoUtils.getCurrentCpuAbi();
        ZipFile apkZipFile = soLoader.getApkZipFile(context);
        try {
        } catch (Exception e) {
            soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:" + e.getMessage());
            if (DEBUG) {
                Log.e("V8InnerSoLoader", "loadV8EngineSoWithCustomPath:" + e);
            }
        } finally {
            com.baidu.swan.e.d.closeSafely(apkZipFile);
        }
        if (apkZipFile == null) {
            soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:zipFile is null.");
            return false;
        }
        for (String str4 : hashMap.keySet()) {
            if (hashMap.get(str4) == null) {
                String fullName = SoUtils.getFullName(str4);
                File file3 = new File(file, fullName);
                if (soLoader.executeRelease(apkZipFile, fullName, str3, file3)) {
                    hashMap.put(str4, file3.getAbsolutePath());
                }
            }
        }
        return a(hashMap, soLoader);
    }

    public static void aDB() {
        final File file = new File(dhR);
        if (file.exists()) {
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.games.utils.so.e.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        String versionName = aj.getVersionName();
                        for (File file2 : listFiles) {
                            if (!TextUtils.equals(file2.getName(), versionName)) {
                                com.baidu.swan.e.d.safeDeleteFile(file2);
                            }
                        }
                    }
                }
            }, "V8InnerSoLoader");
        }
    }

    public static String getV8SoDependentFilePath() {
        return dhT;
    }

    public static String aDC() {
        return "v8.engine";
    }
}
