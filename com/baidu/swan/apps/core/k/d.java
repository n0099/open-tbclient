package com.baidu.swan.apps.core.k;

import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.File;
/* loaded from: classes8.dex */
public class d {
    public static boolean o(String str, String str2, boolean z) {
        if (!z) {
            try {
                System.loadLibrary(str);
                return true;
            } catch (Throwable th) {
            }
        }
        try {
            System.load(str2 + File.separator + "lib" + str + PluginInstallerService.APK_LIB_SUFFIX);
            return true;
        } catch (Throwable th2) {
            return false;
        }
    }
}
