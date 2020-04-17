package com.baidu.swan.apps.impl.a;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final b bUy = new b();
    }

    public static b abh() {
        return a.bUy;
    }

    public boolean jm(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.swan.apps.impl.a.a.abf().jl("installSwanApp start, appKey = " + str);
        File abj = com.baidu.swan.apps.impl.a.a.a.abj();
        if (abj == null || !abj.exists()) {
            return false;
        }
        File file = new File(abj, com.baidu.swan.apps.impl.a.a.a.bUJ);
        if (!file.exists()) {
            com.baidu.swan.apps.impl.a.a.abf().jl("installSwanApp cloneZip.zip file not exists");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.bUC);
        if (file2.exists()) {
            c.safeDeleteFile(file2);
        }
        if (!c.ensureDirectoryExist(file2)) {
            com.baidu.swan.apps.impl.a.a.abf().jl("installSwanApp root cache dir create fail");
            return false;
        }
        boolean z = c.ct(file.getAbsolutePath(), com.baidu.swan.apps.impl.a.a.a.bUC) == null;
        if (z) {
            c.deleteFile(file);
        }
        com.baidu.swan.apps.impl.a.a.abf().jl("unzip file status = " + z);
        File file3 = new File(com.baidu.swan.apps.impl.a.a.a.bUC);
        String[] list = file3.list();
        if (list == null || list.length == 0) {
            com.baidu.swan.apps.impl.a.a.abf().jl("installSwanApp unzip file length invalid");
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
            if (TextUtils.isEmpty(str2) || !str2.startsWith(com.baidu.swan.apps.impl.a.a.a.bUD)) {
                i++;
            } else {
                str3 = str2.substring(com.baidu.swan.apps.impl.a.a.a.bUD.length());
                break;
            }
        }
        if (!TextUtils.equals(str, str3) || TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.impl.a.a.abf().jl("installSwanApp install appKey not match zip file appKey");
            return false;
        }
        File file4 = new File(com.baidu.swan.apps.impl.a.a.a.bUC, str2);
        com.baidu.swan.apps.impl.a.a.abf().jl("installSwanPkg = " + g(str, file4) + " ; installCore = " + h(str, file4) + " ; installSp = " + i(str, file4) + " ; installDb = " + j(str, file4) + " ; installAbTest = " + jn(str));
        return c.deleteFile(file3);
    }

    public boolean g(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return h(new File(file, com.baidu.swan.apps.impl.a.a.a.bUF), com.baidu.swan.apps.impl.a.a.a.bUz);
    }

    public boolean h(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return h(new File(file, com.baidu.swan.apps.impl.a.a.a.bUG), com.baidu.swan.apps.impl.a.a.a.bUz);
    }

    public boolean i(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            return false;
        }
        return h(new File(file, com.baidu.swan.apps.impl.a.a.a.bUH), new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"));
    }

    public boolean j(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean h = h(new File(file, com.baidu.swan.apps.impl.a.a.a.bUI), new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, NgWebView.APP_DATABASE_PATH));
        SwanAppDbControl.bO(AppRuntime.getAppContext()).release();
        com.baidu.swan.pms.database.provider.a.aBP().release();
        return h;
    }

    public boolean jn(String str) {
        return true;
    }

    private boolean h(File file, File file2) {
        if (file == null || !file.exists() || file2 == null) {
            return false;
        }
        if (!file2.exists()) {
            c.ensureDirectoryExist(file2);
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
                        c.deleteFile(file4);
                    }
                    if (isFile) {
                        c.createNewFileSafely(file4);
                        c.copyFile(file3, file4);
                    } else if (file3.isDirectory()) {
                        c.j(file3, file4);
                    }
                }
            }
        }
        return true;
    }
}
