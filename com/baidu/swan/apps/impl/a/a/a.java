package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes11.dex */
public class a {
    public static File bUz = e.abF();
    public static String bUA = "swan_core";
    public static String bUB = "extension_core";
    public static String bUC = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String bUD = "cloneFolder_";
    public static String bUE = bUC + File.separator + bUD;
    public static String bUF = "clone_pkg_folder";
    public static String bUG = "clone_core_folder";
    public static String bUH = "clone_sp_folder";
    public static String bUI = "clone_db_folder";
    public static String bUJ = "cloneZip.zip";

    public static File abj() {
        File file = new File(b.ano());
        if (c.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
