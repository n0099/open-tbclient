package com.baidu.swan.apps.ao;

import android.app.Activity;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes8.dex */
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
            com.baidu.swan.apps.console.c.bl("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.axc().agD());
        }
    }

    public static String L(Activity activity) {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (activity == null || aIO == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int frameType = aIO.getFrameType();
        if (frameType != -1) {
            b.a aIR = aIO.aIR();
            sb.append(kl(frameType));
            sb.append("\n");
            if (frameType == 0) {
                sb.append(km(frameType));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.ap(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.axc().gd(frameType)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.ash().aqE()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aIR.getVersion()) ? "" : aIR.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aIR.ayW());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aIR.getVersionCode()) ? "" : aIR.getVersionCode()).append("\n");
            String aVM = com.baidu.swan.games.c.d.aVD().aVM();
            if (!TextUtils.isEmpty(aVM)) {
                sb.append("app sconsole version: ").append(aVM).append("\n");
            }
            if (aIO.aJg()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long aie = com.baidu.swan.games.utils.so.d.aie();
            sb.append("v8 so version: ").append(aie).append(aie < 0 ? "(old)" : "(new)").append("\n");
            if (!aIO.aJg()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(D(0, com.baidu.swan.apps.core.turbo.d.ash().aqE()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String kl(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion azQ = com.baidu.swan.apps.v.f.aAo().azQ();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(azQ, i));
        return sb.toString();
    }

    private static String km(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore asE = com.baidu.swan.apps.core.turbo.d.ash().asE();
            String str = "";
            int i2 = -1;
            if (asE != null) {
                str = asE.extensionCoreVersionName;
                i2 = asE.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String D(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aFr() ? i.C(i, true) : "";
        } else if (!i.aNG()) {
            return "";
        } else {
            return i.C(i, z);
        }
    }
}
