package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class a {
    public static File bwg = e.TN();
    public static String bwh = "swan_core";
    public static String bwi = "extension_core";
    public static String bwj = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String bwk = "cloneFolder_";
    public static String bwl = bwj + File.separator + bwk;
    public static String bwm = "clone_pkg_folder";
    public static String bwn = "clone_core_folder";
    public static String bwo = "clone_sp_folder";
    public static String bwp = "clone_db_folder";
    public static String bwq = "cloneZip.zip";

    public static File Tr() {
        File file = new File(b.afg());
        if (c.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
