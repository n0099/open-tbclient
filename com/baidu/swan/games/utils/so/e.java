package com.baidu.swan.games.utils.so;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.storage.c.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipFile;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String dUq = com.baidu.swan.apps.r.d.atQ() + "/v8_so/";
    private static final boolean dUr = com.baidu.swan.apps.t.a.auR().afp();
    private static final String[] dUs = com.baidu.swan.apps.t.a.auR().afq();
    private static String dUt = null;

    public static f a(@NonNull Context context, @NonNull SoLoader soLoader) {
        if (b(context, soLoader)) {
            xG("loadV8EngineBySystemMethod:success.");
            return f.aVz();
        }
        f c = c(context, soLoader);
        if (c.isSuccess()) {
            xG("loadV8EngineSoWithSystemPath:success.");
            return c;
        }
        f d = d(context, soLoader);
        if (!d.isSuccess()) {
            SoUtils.onEvent(SoUtils.SO_EVENT_ID_V8_SO, soLoader.getErrorLog());
            return d;
        }
        xG("loadV8EngineSoWithCustomPath:success.");
        return d;
    }

    private static boolean b(@NonNull Context context, @NonNull SoLoader soLoader) {
        if (dUr) {
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, "com.baidu.zeus");
            if (findSoFilesInLibrary == null || findSoFilesInLibrary.length() == 0) {
                return false;
            }
            dUt = findSoFilesInLibrary.getAbsolutePath();
            xG("loadV8EngineSo: v8 dependentFile:" + dUt);
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
        boolean b;
        boolean z = true;
        if (dUs != null && dUs.length != 0) {
            String[] strArr = dUs;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                if (hashMap == null) {
                    b = a(str, soLoader);
                } else {
                    b = b(hashMap.get(str), soLoader);
                }
                i++;
                z = !b ? false : z;
            }
        }
        return z;
    }

    private static f c(@NonNull Context context, @NonNull SoLoader soLoader) {
        dUt = null;
        HashMap hashMap = new HashMap();
        Iterator<String> it = aVv().iterator();
        while (it.hasNext()) {
            String next = it.next();
            File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, next);
            hashMap.put(next, findSoFilesInLibrary != null && findSoFilesInLibrary.exists() && (findSoFilesInLibrary.length() > 0L ? 1 : (findSoFilesInLibrary.length() == 0L ? 0 : -1)) != 0 ? findSoFilesInLibrary.getAbsolutePath() : null);
        }
        return b(hashMap, soLoader);
    }

    private static f b(@NonNull HashMap<String, String> hashMap, @NonNull SoLoader soLoader) {
        xG("loadV8EngineSoByMap:" + hashMap);
        String str = hashMap.get("com.baidu.zeus");
        if (dUr && str == null) {
            return f.u(false, false);
        }
        boolean b = b(hashMap.get("zeusv8"), soLoader);
        boolean a2 = a(hashMap, soLoader);
        boolean b2 = b(hashMap.get("v8.engine"), soLoader);
        if (b2) {
            dUt = str;
        }
        return f.u(b, a2 && b2);
    }

    private static f d(@NonNull Context context, @NonNull SoLoader soLoader) {
        dUt = null;
        HashMap hashMap = new HashMap();
        String versionName = ak.getVersionName();
        File file = new File(dUq, versionName);
        Iterator<String> it = aVv().iterator();
        while (it.hasNext()) {
            String next = it.next();
            File file2 = new File(file, SoUtils.getFullName(next));
            hashMap.put(next, file2.exists() && (file2.length() > 0L ? 1 : (file2.length() == 0L ? 0 : -1)) != 0 ? file2.getAbsolutePath() : null);
        }
        if (!hashMap.containsValue(null)) {
            return b(hashMap, soLoader);
        }
        String str = "swan_v8so_unzip_times_" + versionName;
        int i = h.aIs().getInt(str, 0);
        if (i >= 3) {
            soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:reach max unzip times.");
            return c(context, soLoader);
        }
        h.aIs().putInt(str, i + 1);
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
    private static ArrayList<String> aVv() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("v8.engine");
        arrayList.add("zeusv8");
        if (dUr) {
            arrayList.add("com.baidu.zeus");
        }
        if (dUs != null && dUs.length != 0) {
            arrayList.addAll(Arrays.asList(dUs));
        }
        return arrayList;
    }

    private static void xG(String str) {
        if (DEBUG) {
            Log.d("V8InnerSoLoader", str);
        }
    }

    public static void aVw() {
        File[] listFiles;
        File file = new File(dUq);
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
        if (dUr) {
            return dUt;
        }
        return null;
    }

    public static String aVx() {
        return "v8.engine";
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static void aVw() {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.games.utils.so.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    e.aVw();
                }
            }, "V8SoCleaner", 3);
        }
    }
}
