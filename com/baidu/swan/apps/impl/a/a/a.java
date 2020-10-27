package com.baidu.swan.apps.impl.a.a;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.storage.b;
import java.io.File;
/* loaded from: classes10.dex */
public class a {
    public static File cPF = d.atQ();
    public static String cPG = "swan_core";
    public static String cPH = "extension_core";
    public static String cPI = AppRuntime.getAppContext().getCacheDir() + File.separator + "cloneSwanApp";
    public static String cPJ = "cloneFolder_";
    public static String cPK = cPI + File.separator + cPJ;
    public static String cPL = "clone_pkg_folder";
    public static String cPM = "clone_core_folder";
    public static String cPN = "clone_dynamic_lib_folder";
    public static String cPO = "clone_sp_folder";
    public static String cPP = "clone_db_folder";
    public static String cPQ = "cloneZip.zip";
    public static String cPR = "clone_zipFiles";

    public static File asZ() {
        File file = new File(b.aIa());
        if (com.baidu.swan.c.d.ensureDirectoryExist(file)) {
            return file;
        }
        return null;
    }
}
