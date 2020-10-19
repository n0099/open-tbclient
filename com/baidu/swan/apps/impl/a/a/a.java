package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes10.dex */
public class a {
    public static File cHj = d.arV();
    public static String cHk = "swan_core";
    public static String cHl = "extension_core";
    public static String cHm = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String cHn = "cloneFolder_";
    public static String cHo = cHm + File.separator + cHn;
    public static String cHp = "clone_pkg_folder";
    public static String cHq = "clone_core_folder";
    public static String cHr = "clone_dynamic_lib_folder";
    public static String cHs = "clone_sp_folder";
    public static String cHt = "clone_db_folder";
    public static String cHu = "cloneZip.zip";
    public static String cHv = "clone_zipFiles";

    public static File are() {
        File file = new File(b.aGg());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
