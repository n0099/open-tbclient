package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes10.dex */
public class a {
    public static File brV = e.Rx();
    public static String brW = "swan_core";
    public static String brX = "extension_core";
    public static String brY = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String brZ = "cloneFolder_";
    public static String bsa = brY + File.separator + brZ;
    public static String bsb = "clone_pkg_folder";
    public static String bsc = "clone_core_folder";
    public static String bsd = "clone_sp_folder";
    public static String bse = "clone_db_folder";
    public static String bsf = "cloneZip.zip";

    public static File Rb() {
        File file = new File(b.acQ());
        if (c.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
