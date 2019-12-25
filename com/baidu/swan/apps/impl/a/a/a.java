package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.storage.b;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import java.io.File;
/* loaded from: classes9.dex */
public class a {
    public static File brh = e.Rb();
    public static String bri = "swan_core";
    public static String brj = "extension_core";
    public static String brk = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String brl = "cloneFolder_";
    public static String brm = brk + File.separator + brl;
    public static String brn = "clone_pkg_folder";
    public static String bro = "clone_core_folder";
    public static String brp = "clone_sp_folder";
    public static String brq = "clone_db_folder";
    public static String brr = "cloneZip.zip";

    public static File QF() {
        File file = new File(b.act());
        if (c.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
