package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class a {
    public static File bwf = e.TL();
    public static String bwg = "swan_core";
    public static String bwh = "extension_core";
    public static String bwi = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String bwj = "cloneFolder_";
    public static String bwk = bwi + File.separator + bwj;
    public static String bwl = "clone_pkg_folder";
    public static String bwm = "clone_core_folder";
    public static String bwn = "clone_sp_folder";
    public static String bwo = "clone_db_folder";
    public static String bwp = "cloneZip.zip";

    public static File Tp() {
        File file = new File(b.afe());
        if (c.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
