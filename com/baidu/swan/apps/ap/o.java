package com.baidu.swan.apps.ap;

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

    public static void N(Activity activity) {
        if (activity != null) {
            String str = "";
            try {
                str = O(activity);
            } catch (Exception e) {
                if (DEBUG) {
                    throw e;
                }
                com.baidu.swan.apps.console.c.f("SwanAppEnvironmentUtils", "getExtraInfo error", e);
            }
            com.baidu.swan.apps.console.c.bb("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
            com.baidu.swan.apps.console.c.bb("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.aoM().Yy());
        }
    }

    public static String O(Activity activity) {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (activity == null || azJ == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int XP = azJ.XP();
        if (XP != -1) {
            b.a azM = azJ.azM();
            sb.append(kl(XP));
            sb.append("\n");
            if (XP == 0) {
                sb.append(km(XP));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.aoM().gr(XP)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.ajS().aiq()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(azM.getVersion()) ? "" : azM.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), azM.aqG());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(azM.getVersionCode()) ? "" : azM.getVersionCode()).append("\n");
            String aML = com.baidu.swan.games.c.d.aMC().aML();
            if (!TextUtils.isEmpty(aML)) {
                sb.append("app sconsole version: ").append(aML).append("\n");
            }
            if (azJ.aAb()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long ZZ = com.baidu.swan.games.utils.so.d.ZZ();
            sb.append("v8 so version: ").append(ZZ).append(ZZ < 0 ? "(old)" : "(new)").append("\n");
            if (!azJ.aAb()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(B(0, com.baidu.swan.apps.core.turbo.d.ajS().aiq()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String kl(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion arA = com.baidu.swan.apps.v.f.arY().arA();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(arA, i));
        return sb.toString();
    }

    private static String km(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore ako = com.baidu.swan.apps.core.turbo.d.ajS().ako();
            String str = "";
            int i2 = -1;
            if (ako != null) {
                str = ako.extensionCoreVersionName;
                i2 = ako.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String B(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.axf() ? i.A(i, true) : "";
        } else if (!i.aEA()) {
            return "";
        } else {
            return i.A(i, z);
        }
    }
}
