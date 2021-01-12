package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    public static File daQ = d.awo();
    public static String daR = "swan_core";
    public static String daS = "extension_core";
    public static String daT = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String daU = "cloneFolder_";
    public static String daV = daT + File.separator + daU;
    public static String daW = "clone_pkg_folder";
    public static String daX = "clone_core_folder";
    public static String daY = "clone_dynamic_lib_folder";
    public static String daZ = "clone_sp_folder";
    public static String dba = "clone_db_folder";
    public static String dbb = "cloneZip.zip";
    public static String dbc = "clone_zipFiles";

    public static File avx() {
        File file = new File(b.aLw());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
