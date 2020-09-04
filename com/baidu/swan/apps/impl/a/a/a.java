package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    public static File csW = d.aoz();
    public static String csX = "swan_core";
    public static String csY = "extension_core";
    public static String csZ = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String cta = "cloneFolder_";
    public static String ctb = csZ + File.separator + cta;
    public static String ctc = "clone_pkg_folder";
    public static String ctd = "clone_core_folder";
    public static String cte = "clone_dynamic_lib_folder";
    public static String ctf = "clone_sp_folder";
    public static String ctg = "clone_db_folder";
    public static String cth = "cloneZip.zip";
    public static String cti = "clone_zipFiles";

    public static File anI() {
        File file = new File(b.aCN());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
