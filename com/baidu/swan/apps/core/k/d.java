package com.baidu.swan.apps.core.k;

import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.File;
/* loaded from: classes11.dex */
public class d {
    public static void k(String str, String str2, boolean z) {
        if (!z) {
            try {
                System.loadLibrary(str);
                return;
            } catch (Throwable th) {
            }
        }
        try {
            System.load(str2 + File.separator + "lib" + str + PluginInstallerService.APK_LIB_SUFFIX);
        } catch (Throwable th2) {
        }
    }
}
