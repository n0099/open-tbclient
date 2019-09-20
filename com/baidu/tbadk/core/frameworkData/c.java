package com.baidu.tbadk.core.frameworkData;

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
/* loaded from: classes.dex */
public class c {
    private static final String bPA = "code_cache" + File.separator + "secondary-dexes";

    private static SharedPreferences cp(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    public static List<String> cq(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        File file2 = new File(applicationInfo.dataDir, bPA);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + ".classes";
        int i = cp(context).getInt("dex.number", 1);
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

    public static void cr(Context context) throws PackageManager.NameNotFoundException, IOException {
        DexFile dexFile;
        for (String str : cq(context)) {
            try {
                if (str.endsWith(".zip")) {
                    dexFile = DexFile.loadDex(str, str + ".tmp", 0);
                } else {
                    dexFile = new DexFile(str);
                }
                Enumeration<String> entries = dexFile.entries();
                while (entries.hasMoreElements()) {
                    String nextElement = entries.nextElement();
                    if (nextElement.endsWith("Static")) {
                        Class.forName(nextElement);
                    }
                }
            } catch (IOException e) {
                throw new IOException("Error at loading dex file '" + str + "'");
            }
        }
    }
}
