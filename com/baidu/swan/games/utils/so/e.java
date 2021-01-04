package com.baidu.swan.games.utils.so;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.storage.c.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipFile;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String eoB = com.baidu.swan.apps.r.d.aAh() + "/v8_so/";
    private static final boolean eoC = com.baidu.swan.apps.t.a.aBi().alx();
    private static final String[] eoD = com.baidu.swan.apps.t.a.aBi().aly();
    private static String eoE = null;

    public static f a(@NonNull Context context, @NonNull SoLoader soLoader) {
        if (b(context, soLoader)) {
            yv("loadV8EngineBySystemMethod:success.");
            return f.bcQ();
        }
        f c = c(context, soLoader);
        if (c.isSuccess()) {
            yv("loadV8EngineSoWithSystemPath:success.");
            return c;
        }
        f d = d(context, soLoader);
        if (!d.isSuccess()) {
            SoUtils.onEvent(SoUtils.SO_EVENT_ID_V8_SO, soLoader.getErrorLog());
            return d;
        }
        yv("loadV8EngineSoWithCustomPath:success.");
        return d;
    }

    private static boolean b(@NonNull Context context, @NonNull SoLoader soLoader) {
        if (eoC) {
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, "com.baidu.zeus");
            if (findSoFilesInLibrary == null || findSoFilesInLibrary.length() == 0) {
                return false;
            }
            eoE = findSoFilesInLibrary.getAbsolutePath();
            yv("loadV8EngineSo: v8 dependentFile:" + eoE);
        }
        return a((HashMap<String, String>) null, soLoader) && a("v8.engine", soLoader);
    }

    private static boolean a(@Nullable String str, @NonNull SoLoader soLoader) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            soLoader.appendErrorLog("loadLibsSo: " + th.getMessage());
            return false;
        }
    }

    private static boolean b(@Nullable String str, @NonNull SoLoader soLoader) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.load(str);
            return true;
        } catch (Throwable th) {
            soLoader.appendErrorLog("loadSoByPath: " + th.getMessage());
            return false;
        }
    }

    private static boolean a(@Nullable HashMap<String, String> hashMap, @NonNull SoLoader soLoader) {
        boolean b2;
        boolean z = true;
        if (eoD != null && eoD.length != 0) {
            String[] strArr = eoD;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                if (hashMap == null) {
                    b2 = a(str, soLoader);
                } else {
                    b2 = b(hashMap.get(str), soLoader);
                }
                i++;
                z = !b2 ? false : z;
            }
        }
        return z;
    }

    private static f c(@NonNull Context context, @NonNull SoLoader soLoader) {
        eoE = null;
        HashMap hashMap = new HashMap();
        Iterator<String> it = bcM().iterator();
        while (it.hasNext()) {
            String next = it.next();
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, next);
            hashMap.put(next, findSoFilesInLibrary != null && findSoFilesInLibrary.exists() && (findSoFilesInLibrary.length() > 0L ? 1 : (findSoFilesInLibrary.length() == 0L ? 0 : -1)) != 0 ? findSoFilesInLibrary.getAbsolutePath() : null);
        }
        return b(hashMap, soLoader);
    }

    private static f b(@NonNull HashMap<String, String> hashMap, @NonNull SoLoader soLoader) {
        yv("loadV8EngineSoByMap:" + hashMap);
        String str = hashMap.get("com.baidu.zeus");
        if (eoC && str == null) {
            return f.u(false, false);
        }
        boolean b2 = b(hashMap.get("zeusv8"), soLoader);
        boolean a2 = a(hashMap, soLoader);
        boolean b3 = b(hashMap.get("v8.engine"), soLoader);
        if (b3) {
            eoE = str;
        }
        return f.u(b2, a2 && b3);
    }

    private static f d(@NonNull Context context, @NonNull SoLoader soLoader) {
        eoE = null;
        HashMap hashMap = new HashMap();
        String versionName = ak.getVersionName();
        File file = new File(eoB, versionName);
        Iterator<String> it = bcM().iterator();
        while (it.hasNext()) {
            String next = it.next();
            File file2 = new File(file, SoUtils.getFullName(next));
            hashMap.put(next, file2.exists() && (file2.length() > 0L ? 1 : (file2.length() == 0L ? 0 : -1)) != 0 ? file2.getAbsolutePath() : null);
        }
        if (!hashMap.containsValue(null)) {
            return b(hashMap, soLoader);
        }
        String str = "swan_v8so_unzip_times_" + versionName;
        int i = h.aPH().getInt(str, 0);
        if (i >= 3) {
            soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:reach max unzip times.");
            return c(context, soLoader);
        }
        h.aPH().putInt(str, i + 1);
        String str2 = "lib" + File.separator + SoUtils.getCurrentCpuAbi();
        ZipFile apkZipFile = soLoader.getApkZipFile(context);
        if (apkZipFile == null) {
            soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:zipFile is null.");
            return c(context, soLoader);
        }
        try {
            for (String str3 : hashMap.keySet()) {
                if (hashMap.get(str3) == null) {
                    String fullName = SoUtils.getFullName(str3);
                    File file3 = new File(file, fullName);
                    if (soLoader.executeRelease(apkZipFile, fullName, str2, file3)) {
                        hashMap.put(str3, file3.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e) {
            soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:" + e.getMessage());
            if (DEBUG) {
                Log.e("V8InnerSoLoader", "loadV8EngineSoWithCustomPath:" + e);
            }
        } finally {
            com.baidu.swan.c.d.closeSafely(apkZipFile);
        }
        return b(hashMap, soLoader);
    }

    @NonNull
    private static ArrayList<String> bcM() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("v8.engine");
        arrayList.add("zeusv8");
        if (eoC) {
            arrayList.add("com.baidu.zeus");
        }
        if (eoD != null && eoD.length != 0) {
            arrayList.addAll(Arrays.asList(eoD));
        }
        return arrayList;
    }

    private static void yv(String str) {
        if (DEBUG) {
            Log.d("V8InnerSoLoader", str);
        }
    }

    public static void bcN() {
        File[] listFiles;
        File file = new File(eoB);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            String versionName = ak.getVersionName();
            for (File file2 : listFiles) {
                if (!TextUtils.equals(file2.getName(), versionName)) {
                    com.baidu.swan.c.d.safeDeleteFile(file2);
                }
            }
        }
    }

    public static String getV8SoDependentFilePath() {
        if (eoC) {
            return eoE;
        }
        return null;
    }

    public static String bcO() {
        return "v8.engine";
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static void bcN() {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.games.utils.so.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    e.bcN();
                }
            }, "V8SoCleaner", 3);
        }
    }
}
