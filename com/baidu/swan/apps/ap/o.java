package com.baidu.swan.apps.ap;

import android.app.Activity;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes10.dex */
public class o {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void Q(Activity activity) {
        if (activity != null) {
            String str = "";
            try {
                str = R(activity);
            } catch (Exception e) {
                if (DEBUG) {
                    throw e;
                }
                com.baidu.swan.apps.console.c.f("SwanAppEnvironmentUtils", "getExtraInfo error", e);
            }
            com.baidu.swan.apps.console.c.bn("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
            com.baidu.swan.apps.console.c.bn("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.awD().agn());
        }
    }

    public static String R(Activity activity) {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (activity == null || aHv == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int afE = aHv.afE();
        if (afE != -1) {
            b.a aHy = aHv.aHy();
            sb.append(lo(afE));
            sb.append("\n");
            if (afE == 0) {
                sb.append(lp(afE));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.awD().hs(afE)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.arI().aqg()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aHy.getVersion()) ? "" : aHy.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aHy.ayw());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aHy.getVersionCode()) ? "" : aHy.getVersionCode()).append("\n");
            String aUz = com.baidu.swan.games.c.d.aUq().aUz();
            if (!TextUtils.isEmpty(aUz)) {
                sb.append("app sconsole version: ").append(aUz).append("\n");
            }
            if (aHv.aHN()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long ahO = com.baidu.swan.games.utils.so.d.ahO();
            sb.append("v8 so version: ").append(ahO).append(ahO < 0 ? "(old)" : "(new)").append("\n");
            if (!aHv.aHN()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(D(0, com.baidu.swan.apps.core.turbo.d.arI().aqg()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String lo(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion azq = com.baidu.swan.apps.v.f.azO().azq();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(azq, i));
        return sb.toString();
    }

    private static String lp(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore ase = com.baidu.swan.apps.core.turbo.d.arI().ase();
            String str = "";
            int i2 = -1;
            if (ase != null) {
                str = ase.extensionCoreVersionName;
                i2 = ase.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String D(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aET() ? i.C(i, true) : "";
        } else if (!i.aMn()) {
            return "";
        } else {
            return i.C(i, z);
        }
    }
}
