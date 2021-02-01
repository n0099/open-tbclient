package com.baidu.swan.apps.ao;

import android.app.Activity;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes9.dex */
public class o {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void K(Activity activity) {
        if (activity != null) {
            String str = "";
            try {
                str = L(activity);
            } catch (Exception e) {
                if (DEBUG) {
                    throw e;
                }
                com.baidu.swan.apps.console.c.g("SwanAppEnvironmentUtils", "getExtraInfo error", e);
            }
            com.baidu.swan.apps.console.c.bl("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
            com.baidu.swan.apps.console.c.bl("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.awZ().agA());
        }
    }

    public static String L(Activity activity) {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (activity == null || aIL == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int frameType = aIL.getFrameType();
        if (frameType != -1) {
            b.a aIO = aIL.aIO();
            sb.append(kk(frameType));
            sb.append("\n");
            if (frameType == 0) {
                sb.append(kl(frameType));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.ap(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.awZ().gc(frameType)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.ase().aqB()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aIO.getVersion()) ? "" : aIO.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aIO.ayT());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aIO.getVersionCode()) ? "" : aIO.getVersionCode()).append("\n");
            String aVJ = com.baidu.swan.games.c.d.aVA().aVJ();
            if (!TextUtils.isEmpty(aVJ)) {
                sb.append("app sconsole version: ").append(aVJ).append("\n");
            }
            if (aIL.aJd()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long aib = com.baidu.swan.games.utils.so.d.aib();
            sb.append("v8 so version: ").append(aib).append(aib < 0 ? "(old)" : "(new)").append("\n");
            if (!aIL.aJd()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(D(0, com.baidu.swan.apps.core.turbo.d.ase().aqB()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String kk(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion azN = com.baidu.swan.apps.v.f.aAl().azN();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(azN, i));
        return sb.toString();
    }

    private static String kl(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore asB = com.baidu.swan.apps.core.turbo.d.ase().asB();
            String str = "";
            int i2 = -1;
            if (asB != null) {
                str = asB.extensionCoreVersionName;
                i2 = asB.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String D(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aFo() ? i.C(i, true) : "";
        } else if (!i.aND()) {
            return "";
        } else {
            return i.C(i, z);
        }
    }
}
