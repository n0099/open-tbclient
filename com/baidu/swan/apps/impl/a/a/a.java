package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes9.dex */
public class a {
    public static File ddc = d.awM();
    public static String ddd = "swan_core";
    public static String dde = "extension_core";
    public static String ddf = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String ddg = "cloneFolder_";
    public static String ddh = ddf + File.separator + ddg;
    public static String ddi = "clone_pkg_folder";
    public static String ddj = "clone_core_folder";
    public static String ddk = "clone_dynamic_lib_folder";
    public static String ddl = "clone_sp_folder";
    public static String ddm = "clone_db_folder";
    public static String ddn = "cloneZip.zip";
    public static String ddo = "clone_zipFiles";

    public static File avV() {
        File file = new File(b.aLP());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
