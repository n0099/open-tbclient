package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    public static File deF = d.awP();
    public static String deG = "swan_core";
    public static String deH = "extension_core";
    public static String deI = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String deJ = "cloneFolder_";
    public static String deK = deI + File.separator + deJ;
    public static String deL = "clone_pkg_folder";
    public static String deM = "clone_core_folder";
    public static String deN = "clone_dynamic_lib_folder";
    public static String deO = "clone_sp_folder";
    public static String deP = "clone_db_folder";
    public static String deQ = "cloneZip.zip";
    public static String deR = "clone_zipFiles";

    public static File avY() {
        File file = new File(b.aLS());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
