package com.baidu.swan.apps.ap;

import android.app.Activity;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes25.dex */
public class o {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void P(Activity activity) {
        if (activity != null) {
            String str = "";
            try {
                str = Q(activity);
            } catch (Exception e) {
                if (DEBUG) {
                    throw e;
                }
                com.baidu.swan.apps.console.c.f("SwanAppEnvironmentUtils", "getExtraInfo error", e);
            }
            com.baidu.swan.apps.console.c.bt("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
            com.baidu.swan.apps.console.c.bt("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.azd().aiN());
        }
    }

    public static String Q(Activity activity) {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (activity == null || aJV == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int aie = aJV.aie();
        if (aie != -1) {
            b.a aJY = aJV.aJY();
            sb.append(lI(aie));
            sb.append("\n");
            if (aie == 0) {
                sb.append(lJ(aie));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.azd().hM(aie)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.aui().asG()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aJY.getVersion()) ? "" : aJY.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aJY.aAX());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aJY.getVersionCode()) ? "" : aJY.getVersionCode()).append("\n");
            String aWW = com.baidu.swan.games.c.d.aWN().aWW();
            if (!TextUtils.isEmpty(aWW)) {
                sb.append("app sconsole version: ").append(aWW).append("\n");
            }
            if (aJV.aKn()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long ako = com.baidu.swan.games.utils.so.d.ako();
            sb.append("v8 so version: ").append(ako).append(ako < 0 ? "(old)" : "(new)").append("\n");
            if (!aJV.aKn()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(D(0, com.baidu.swan.apps.core.turbo.d.aui().asG()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String lI(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion aBR = com.baidu.swan.apps.v.f.aCp().aBR();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(aBR, i));
        return sb.toString();
    }

    private static String lJ(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore auE = com.baidu.swan.apps.core.turbo.d.aui().auE();
            String str = "";
            int i2 = -1;
            if (auE != null) {
                str = auE.extensionCoreVersionName;
                i2 = auE.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String D(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aHt() ? i.C(i, true) : "";
        } else if (!i.aOM()) {
            return "";
        } else {
            return i.C(i, z);
        }
    }
}
