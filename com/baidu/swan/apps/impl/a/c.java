package com.baidu.swan.apps.impl.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.c.d;
import java.io.File;
/* loaded from: classes10.dex */
public class c {
    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final c cHi = new c();
    }

    public static c arc() {
        return a.cHi;
    }

    public boolean nS(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.swan.apps.impl.a.a.ara().nR("installSwanApp start, appKey = " + str);
        File are = com.baidu.swan.apps.impl.a.a.a.are();
        if (are == null || !are.exists()) {
            return false;
        }
        File file = new File(are, com.baidu.swan.apps.impl.a.a.a.cHv);
        if (!file.exists()) {
            com.baidu.swan.apps.impl.a.a.ara().nR("installSwanApp clone_zipFiles file not exists");
            return false;
        }
        File b = b.b(d.L(file), are);
        if (b == null || !b.exists()) {
            com.baidu.swan.apps.impl.a.a.ara().nR("installSwanApp cloneZip.zip file not exists");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.cHm);
        if (file2.exists()) {
            d.safeDeleteFile(file2);
        }
        if (!d.ensureDirectoryExist(file2)) {
            com.baidu.swan.apps.impl.a.a.ara().nR("installSwanApp root cache dir create fail");
            return false;
        }
        boolean z = d.dr(b.getAbsolutePath(), com.baidu.swan.apps.impl.a.a.a.cHm) == null;
        if (z) {
            d.deleteFile(file);
            d.deleteFile(b);
        }
        com.baidu.swan.apps.impl.a.a.ara().nR("unzip file status = " + z);
        File file3 = new File(com.baidu.swan.apps.impl.a.a.a.cHm);
        String[] list = file3.list();
        if (list == null || list.length == 0) {
            com.baidu.swan.apps.impl.a.a.ara().nR("installSwanApp unzip file length invalid");
            return false;
        }
        int length = list.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str2 = null;
                break;
            }
            str2 = list[i];
            if (TextUtils.isEmpty(str2) || !str2.startsWith(com.baidu.swan.apps.impl.a.a.a.cHn)) {
                i++;
            } else {
                str3 = str2.substring(com.baidu.swan.apps.impl.a.a.a.cHn.length());
                break;
            }
        }
        if (!TextUtils.equals(str, str3) || TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.impl.a.a.ara().nR("installSwanApp install appKey not match zip file appKey");
            return false;
        }
        File file4 = new File(com.baidu.swan.apps.impl.a.a.a.cHm, str2);
        com.baidu.swan.apps.impl.a.a.ara().nR("installSwanPkg = " + g(str, file4) + " ; installCore = " + h(str, file4) + " ; installSp = " + i(str, file4) + " ; installDb = " + j(str, file4) + " ; installAbTest = " + nT(str) + " ; installDynamicLib = " + k(str, file4));
        return d.deleteFile(file3);
    }

    public boolean g(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return j(new File(file, com.baidu.swan.apps.impl.a.a.a.cHp), com.baidu.swan.apps.impl.a.a.a.cHj);
    }

    public boolean h(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return j(new File(file, com.baidu.swan.apps.impl.a.a.a.cHq), com.baidu.swan.apps.impl.a.a.a.cHj);
    }

    public boolean i(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            return false;
        }
        return x(new File(file, com.baidu.swan.apps.impl.a.a.a.cHs));
    }

    private boolean x(@NonNull File file) {
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/");
            File file3 = new File(AppRuntime.getAppContext().getFilesDir(), "swan_prefs");
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return false;
            }
            d.ensureDirectoryExist(file2);
            d.ensureDirectoryExist(file3);
            File file4 = null;
            for (File file5 : listFiles) {
                String name = file5.getName();
                if (!TextUtils.isEmpty(name)) {
                    if (name.endsWith(".xml")) {
                        file4 = new File(file2, name);
                    } else if (name.endsWith(".kv")) {
                        file4 = new File(file3, name);
                    }
                    if (file4 != null) {
                        if (file4.exists()) {
                            d.safeDeleteFile(file4);
                        }
                        if (file5.isFile()) {
                            d.createNewFileSafely(file4);
                            d.copyFile(file5, file4);
                        } else {
                            d.l(file5, file4);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean j(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean j = j(new File(file, com.baidu.swan.apps.impl.a.a.a.cHt), new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, NgWebView.APP_DATABASE_PATH));
        SwanAppDbControl.cd(AppRuntime.getAppContext()).release();
        com.baidu.swan.pms.database.provider.a.aWV().release();
        return j;
    }

    public boolean nT(String str) {
        return true;
    }

    public boolean k(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return j(new File(file, com.baidu.swan.apps.impl.a.a.a.cHr), AppRuntime.getAppContext().getFilesDir());
    }

    private boolean j(File file, File file2) {
        if (file == null || !file.exists() || file2 == null) {
            return false;
        }
        if (!file2.exists()) {
            d.ensureDirectoryExist(file2);
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                File file3 = new File(file, str);
                if (file3.exists()) {
                    boolean isFile = file3.isFile();
                    File file4 = new File(file2, str);
                    if (file4.exists()) {
                        d.deleteFile(file4);
                    }
                    if (isFile) {
                        d.createNewFileSafely(file4);
                        d.copyFile(file3, file4);
                    } else if (file3.isDirectory()) {
                        d.l(file3, file4);
                    }
                }
            }
        }
        return true;
    }
}
