package com.baidu.swan.apps.impl.a;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes9.dex */
public class b {
    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final b brg = new b();
    }

    public static b QD() {
        return a.brg;
    }

    public boolean hH(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.swan.apps.impl.a.a.QB().hG("installSwanApp start, appKey = " + str);
        File QF = com.baidu.swan.apps.impl.a.a.a.QF();
        if (QF == null || !QF.exists()) {
            return false;
        }
        File file = new File(QF, com.baidu.swan.apps.impl.a.a.a.brr);
        if (!file.exists()) {
            com.baidu.swan.apps.impl.a.a.QB().hG("installSwanApp cloneZip.zip file not exists");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.brk);
        if (file2.exists()) {
            c.safeDeleteFile(file2);
        }
        if (!c.ensureDirectoryExist(file2)) {
            com.baidu.swan.apps.impl.a.a.QB().hG("installSwanApp root cache dir create fail");
            return false;
        }
        boolean z = c.bZ(file.getAbsolutePath(), com.baidu.swan.apps.impl.a.a.a.brk) == null;
        if (z) {
            c.deleteFile(file);
        }
        com.baidu.swan.apps.impl.a.a.QB().hG("unzip file status = " + z);
        File file3 = new File(com.baidu.swan.apps.impl.a.a.a.brk);
        String[] list = file3.list();
        if (list == null || list.length == 0) {
            com.baidu.swan.apps.impl.a.a.QB().hG("installSwanApp unzip file length invalid");
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
            if (TextUtils.isEmpty(str2) || !str2.startsWith(com.baidu.swan.apps.impl.a.a.a.brl)) {
                i++;
            } else {
                str3 = str2.substring(com.baidu.swan.apps.impl.a.a.a.brl.length());
                break;
            }
        }
        if (!TextUtils.equals(str, str3) || TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.impl.a.a.QB().hG("installSwanApp install appKey not match zip file appKey");
            return false;
        }
        File file4 = new File(com.baidu.swan.apps.impl.a.a.a.brk, str2);
        com.baidu.swan.apps.impl.a.a.QB().hG("installSwanPkg = " + h(str, file4) + " ; installCore = " + i(str, file4) + " ; installSp = " + j(str, file4) + " ; installDb = " + k(str, file4) + " ; installAbTest = " + hI(str));
        return c.deleteFile(file3);
    }

    public boolean h(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return g(new File(file, com.baidu.swan.apps.impl.a.a.a.brn), com.baidu.swan.apps.impl.a.a.a.brh);
    }

    public boolean i(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return g(new File(file, com.baidu.swan.apps.impl.a.a.a.bro), com.baidu.swan.apps.impl.a.a.a.brh);
    }

    public boolean j(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            return false;
        }
        return g(new File(file, com.baidu.swan.apps.impl.a.a.a.brp), new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"));
    }

    public boolean k(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean g = g(new File(file, com.baidu.swan.apps.impl.a.a.a.brq), new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, NgWebView.APP_DATABASE_PATH));
        SwanAppDbControl.bX(AppRuntime.getAppContext()).release();
        com.baidu.swan.pms.database.provider.a.aqT().release();
        return g;
    }

    public boolean hI(String str) {
        return true;
    }

    private boolean g(File file, File file2) {
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
                        c.i(file3, file4);
                    }
                }
            }
        }
        return true;
    }
}
