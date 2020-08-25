package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    public static File csS = d.aoz();
    public static String csT = "swan_core";
    public static String csU = "extension_core";
    public static String csV = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String csW = "cloneFolder_";
    public static String csX = csV + File.separator + csW;
    public static String csY = "clone_pkg_folder";
    public static String csZ = "clone_core_folder";
    public static String cta = "clone_dynamic_lib_folder";
    public static String ctb = "clone_sp_folder";
    public static String ctc = "clone_db_folder";
    public static String ctd = "cloneZip.zip";
    public static String cte = "clone_zipFiles";

    public static File anI() {
        File file = new File(b.aCN());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
