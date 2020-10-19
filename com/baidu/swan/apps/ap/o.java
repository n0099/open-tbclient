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
            com.baidu.swan.apps.console.c.bg("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
            com.baidu.swan.apps.console.c.bg("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.asi().abT());
        }
    }

    public static String R(Activity activity) {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (activity == null || aDb == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int abk = aDb.abk();
        if (abk != -1) {
            b.a aDe = aDb.aDe();
            sb.append(kT(abk));
            sb.append("\n");
            if (abk == 0) {
                sb.append(kU(abk));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.asi().gX(abk)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.ann().alL()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aDe.getVersion()) ? "" : aDe.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aDe.auc());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aDe.getVersionCode()) ? "" : aDe.getVersionCode()).append("\n");
            String aQf = com.baidu.swan.games.c.d.aPW().aQf();
            if (!TextUtils.isEmpty(aQf)) {
                sb.append("app sconsole version: ").append(aQf).append("\n");
            }
            if (aDb.aDt()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long adu = com.baidu.swan.games.utils.so.d.adu();
            sb.append("v8 so version: ").append(adu).append(adu < 0 ? "(old)" : "(new)").append("\n");
            if (!aDb.aDt()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(D(0, com.baidu.swan.apps.core.turbo.d.ann().alL()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String kT(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion auW = com.baidu.swan.apps.v.f.avu().auW();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(auW, i));
        return sb.toString();
    }

    private static String kU(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore anJ = com.baidu.swan.apps.core.turbo.d.ann().anJ();
            String str = "";
            int i2 = -1;
            if (anJ != null) {
                str = anJ.extensionCoreVersionName;
                i2 = anJ.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String D(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aAz() ? i.C(i, true) : "";
        } else if (!i.aHT()) {
            return "";
        } else {
            return i.C(i, z);
        }
    }
}
