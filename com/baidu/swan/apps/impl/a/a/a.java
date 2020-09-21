package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes3.dex */
public class a {
    public static File cvc = d.apk();
    public static String cvd = "swan_core";
    public static String cve = "extension_core";
    public static String cvf = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String cvg = "cloneFolder_";
    public static String cvh = cvf + File.separator + cvg;
    public static String cvi = "clone_pkg_folder";
    public static String cvj = "clone_core_folder";
    public static String cvk = "clone_dynamic_lib_folder";
    public static String cvl = "clone_sp_folder";
    public static String cvm = "clone_db_folder";
    public static String cvn = "cloneZip.zip";
    public static String cvo = "clone_zipFiles";

    public static File aos() {
        File file = new File(b.aDx());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
