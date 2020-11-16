package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes7.dex */
public class a {
    public static File cTO = d.avI();
    public static String cTP = "swan_core";
    public static String cTQ = "extension_core";
    public static String cTR = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String cTS = "cloneFolder_";
    public static String cTT = cTR + File.separator + cTS;
    public static String cTU = "clone_pkg_folder";
    public static String cTV = "clone_core_folder";
    public static String cTW = "clone_dynamic_lib_folder";
    public static String cTX = "clone_sp_folder";
    public static String cTY = "clone_db_folder";
    public static String cTZ = "cloneZip.zip";
    public static String cUa = "clone_zipFiles";

    public static File auR() {
        File file = new File(b.aJS());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
