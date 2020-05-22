package com.baidu.swan.apps.impl.a;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.e.d;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final b ceU = new b();
    }

    public static b aeh() {
        return a.ceU;
    }

    public boolean ku(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.swan.apps.impl.a.a.aef().kt("installSwanApp start, appKey = " + str);
        File aej = com.baidu.swan.apps.impl.a.a.a.aej();
        if (aej == null || !aej.exists()) {
            return false;
        }
        File file = new File(aej, com.baidu.swan.apps.impl.a.a.a.cff);
        if (!file.exists()) {
            com.baidu.swan.apps.impl.a.a.aef().kt("installSwanApp cloneZip.zip file not exists");
            return false;
        }
        File file2 = new File(com.baidu.swan.apps.impl.a.a.a.ceY);
        if (file2.exists()) {
            d.safeDeleteFile(file2);
        }
        if (!d.ensureDirectoryExist(file2)) {
            com.baidu.swan.apps.impl.a.a.aef().kt("installSwanApp root cache dir create fail");
            return false;
        }
        boolean z = d.cR(file.getAbsolutePath(), com.baidu.swan.apps.impl.a.a.a.ceY) == null;
        if (z) {
            d.deleteFile(file);
        }
        com.baidu.swan.apps.impl.a.a.aef().kt("unzip file status = " + z);
        File file3 = new File(com.baidu.swan.apps.impl.a.a.a.ceY);
        String[] list = file3.list();
        if (list == null || list.length == 0) {
            com.baidu.swan.apps.impl.a.a.aef().kt("installSwanApp unzip file length invalid");
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
            if (TextUtils.isEmpty(str2) || !str2.startsWith(com.baidu.swan.apps.impl.a.a.a.ceZ)) {
                i++;
            } else {
                str3 = str2.substring(com.baidu.swan.apps.impl.a.a.a.ceZ.length());
                break;
            }
        }
        if (!TextUtils.equals(str, str3) || TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.impl.a.a.aef().kt("installSwanApp install appKey not match zip file appKey");
            return false;
        }
        File file4 = new File(com.baidu.swan.apps.impl.a.a.a.ceY, str2);
        com.baidu.swan.apps.impl.a.a.aef().kt("installSwanPkg = " + g(str, file4) + " ; installCore = " + h(str, file4) + " ; installSp = " + i(str, file4) + " ; installDb = " + j(str, file4) + " ; installAbTest = " + kv(str));
        return d.deleteFile(file3);
    }

    public boolean g(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return h(new File(file, com.baidu.swan.apps.impl.a.a.a.cfb), com.baidu.swan.apps.impl.a.a.a.ceV);
    }

    public boolean h(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return h(new File(file, com.baidu.swan.apps.impl.a.a.a.cfc), com.baidu.swan.apps.impl.a.a.a.ceV);
    }

    public boolean i(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            return false;
        }
        return h(new File(file, com.baidu.swan.apps.impl.a.a.a.cfd), new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"));
    }

    public boolean j(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean h = h(new File(file, com.baidu.swan.apps.impl.a.a.a.cfe), new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, NgWebView.APP_DATABASE_PATH));
        SwanAppDbControl.bN(AppRuntime.getAppContext()).release();
        com.baidu.swan.pms.database.provider.a.aGc().release();
        return h;
    }

    public boolean kv(String str) {
        return true;
    }

    private boolean h(File file, File file2) {
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
                        d.j(file3, file4);
                    }
                }
            }
        }
        return true;
    }
}
