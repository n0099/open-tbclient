package com.baidu.swan.apps.ap;

import android.app.Activity;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes7.dex */
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
            com.baidu.swan.apps.console.c.bm("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
            com.baidu.swan.apps.console.c.bm("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.avV().afF());
        }
    }

    public static String Q(Activity activity) {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (activity == null || aGN == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int aeW = aGN.aeW();
        if (aeW != -1) {
            b.a aGQ = aGN.aGQ();
            sb.append(lk(aeW));
            sb.append("\n");
            if (aeW == 0) {
                sb.append(ll(aeW));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.avV().ho(aeW)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.ara().apy()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aGQ.getVersion()) ? "" : aGQ.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aGQ.axO());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aGQ.getVersionCode()) ? "" : aGQ.getVersionCode()).append("\n");
            String aTR = com.baidu.swan.games.c.d.aTI().aTR();
            if (!TextUtils.isEmpty(aTR)) {
                sb.append("app sconsole version: ").append(aTR).append("\n");
            }
            if (aGN.aHf()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long ahg = com.baidu.swan.games.utils.so.d.ahg();
            sb.append("v8 so version: ").append(ahg).append(ahg < 0 ? "(old)" : "(new)").append("\n");
            if (!aGN.aHf()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(D(0, com.baidu.swan.apps.core.turbo.d.ara().apy()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String lk(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion ayI = com.baidu.swan.apps.v.f.azg().ayI();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(ayI, i));
        return sb.toString();
    }

    private static String ll(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore arw = com.baidu.swan.apps.core.turbo.d.ara().arw();
            String str = "";
            int i2 = -1;
            if (arw != null) {
                str = arw.extensionCoreVersionName;
                i2 = arw.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String D(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aEl() ? i.C(i, true) : "";
        } else if (!i.aLF()) {
            return "";
        } else {
            return i.C(i, z);
        }
    }
}
