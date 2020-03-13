package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class a {
    public static File bwh = e.TN();
    public static String bwi = "swan_core";
    public static String bwj = "extension_core";
    public static String bwk = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String bwl = "cloneFolder_";
    public static String bwm = bwk + File.separator + bwl;
    public static String bwn = "clone_pkg_folder";
    public static String bwo = "clone_core_folder";
    public static String bwp = "clone_sp_folder";
    public static String bwq = "clone_db_folder";
    public static String bwr = "cloneZip.zip";

    public static File Tr() {
        File file = new File(b.afg());
        if (c.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
