package com.baidu.swan.games.utils.so;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.zip.ZipFile;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cSh = null;

    public static boolean a(@NonNull Context context, @NonNull SoLoader soLoader) {
        boolean z = true;
        File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, "com.baidu.zeus");
        boolean z2 = findSoFilesInLibrary != null && findSoFilesInLibrary.length() > 0;
        if (DEBUG) {
            Log.i("V8InnerSoLoader", "loadV8EngineSo: v8 dependentFile:" + (z2 ? findSoFilesInLibrary.getAbsolutePath() : null));
        }
        if ((!z2 || !a(soLoader, findSoFilesInLibrary)) && !(z = b(context, soLoader))) {
            SoUtils.sendLog(soLoader.getErrorLog());
        }
        return z;
    }

    private static boolean a(@NonNull SoLoader soLoader, @NonNull File file) {
        try {
            System.loadLibrary("v8.engine");
            cSh = file.getAbsolutePath();
            return true;
        } catch (Throwable th) {
            soLoader.appendErrorLog("loadV8EngineSo: " + Log.getStackTraceString(th));
            return false;
        }
    }

    private static boolean b(@NonNull Context context, @NonNull SoLoader soLoader) {
        cSh = null;
        d.ayy();
        HashMap<String, String> a = a(context, soLoader, new String[]{"v8.engine", "zeusv8"});
        String str = a.get("v8.engine");
        String str2 = a.get("zeusv8");
        if (DEBUG) {
            Log.d("V8InnerSoLoader", "loadV8EngineSoWithAbsolutePath:" + a);
        }
        if (str2 == null || str == null) {
            return false;
        }
        try {
            System.load(str2);
        } catch (Throwable th) {
            soLoader.appendErrorLog("loadV8EngineSoWithAbsolutePath:" + th.getMessage());
        }
        try {
            System.load(str);
            return true;
        } catch (Throwable th2) {
            soLoader.appendErrorLog("loadV8EngineSoWithAbsolutePath:" + th2.getMessage());
            return false;
        }
    }

    private static HashMap<String, String> a(@NonNull Context context, @NonNull SoLoader soLoader, @NonNull String[] strArr) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : strArr) {
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, str);
            hashMap.put(str, findSoFilesInLibrary != null && findSoFilesInLibrary.exists() && (findSoFilesInLibrary.length() > 0L ? 1 : (findSoFilesInLibrary.length() == 0L ? 0 : -1)) != 0 ? findSoFilesInLibrary.getAbsolutePath() : null);
        }
        if (hashMap.containsValue(null)) {
            if (DEBUG) {
                Log.d("V8InnerSoLoader", "findValidSoPathsOrUnzipFromApk:" + hashMap);
            }
            String str2 = "lib" + File.separator + SoUtils.getCurrentCpuAbi();
            ZipFile apkZipFile = soLoader.getApkZipFile(context);
            if (apkZipFile == null) {
                return hashMap;
            }
            try {
                for (String str3 : hashMap.keySet()) {
                    if (hashMap.get(str3) == null) {
                        String fullName = SoUtils.getFullName(str3);
                        if (soLoader.executeRelease(context, apkZipFile, fullName, str2)) {
                            hashMap.put(str3, new File(SoLoader.getReleaseSoFilePath(context), fullName).getAbsolutePath());
                        }
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("V8InnerSoLoader", "findValidSoPathsOrUnzipFromApk:" + e);
                }
            } finally {
                com.baidu.swan.d.c.closeSafely(apkZipFile);
            }
            return hashMap;
        }
        return hashMap;
    }

    public static String getV8SoDependentFilePath() {
        return cSh;
    }

    public static String ayE() {
        return "v8.engine";
    }
}
