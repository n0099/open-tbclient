package com.baidu.live.tbadk.core.frameworkdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
/* loaded from: classes10.dex */
public class MultiDexHelper {
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String PREFS_FILE = "multidex.version";
    private static final String SECONDARY_FOLDER_NAME = "code_cache" + File.separator + "secondary-dexes";
    public static final String SUFFIX = "Initialize";

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    public static List<String> getSourcePaths(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        File file2 = new File(applicationInfo.dataDir, SECONDARY_FOLDER_NAME);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + EXTRACTED_NAME_EXT;
        int i = getMultiDexPreferences(context).getInt(KEY_DEX_NUMBER, 1);
        for (int i2 = 2; i2 <= i; i2++) {
            File file3 = new File(file2, str + i2 + ".zip");
            if (file3.isFile()) {
                arrayList.add(file3.getAbsolutePath());
            } else {
                throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
            }
        }
        return arrayList;
    }

    public static List<String> getAllClasses(Context context) throws PackageManager.NameNotFoundException, IOException {
        DexFile dexFile;
        ArrayList arrayList = new ArrayList();
        for (String str : getSourcePaths(context)) {
            try {
                if (str.endsWith(".zip")) {
                    dexFile = DexFile.loadDex(str, str + ".tmp", 0);
                } else {
                    dexFile = new DexFile(str);
                }
                Enumeration<String> entries = dexFile.entries();
                while (entries.hasMoreElements()) {
                    arrayList.add(entries.nextElement());
                }
            } catch (IOException e) {
                throw new IOException("Error at loading dex file '" + str + "'");
            }
        }
        return arrayList;
    }

    public static void loadStaticClass(Context context) throws PackageManager.NameNotFoundException, IOException {
        DexFile dexFile;
        for (String str : getSourcePaths(context)) {
            try {
                if (str.endsWith(".zip")) {
                    dexFile = DexFile.loadDex(str, str + ".tmp", 0);
                } else {
                    dexFile = new DexFile(str);
                }
                Enumeration<String> entries = dexFile.entries();
                while (entries.hasMoreElements()) {
                    String nextElement = entries.nextElement();
                    if (nextElement.endsWith(SUFFIX)) {
                        Class.forName(nextElement);
                    }
                }
            } catch (IOException e) {
                throw new IOException("Error at loading dex file '" + str + "'");
            }
        }
    }
}
