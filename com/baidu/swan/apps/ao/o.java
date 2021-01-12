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

    public static void Q(Activity activity) {
        if (activity != null) {
            String str = "";
            try {
                str = R(activity);
            } catch (Exception e) {
                if (DEBUG) {
                    throw e;
                }
                com.baidu.swan.apps.console.c.g("SwanAppEnvironmentUtils", "getExtraInfo error", e);
            }
            com.baidu.swan.apps.console.c.br("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
            com.baidu.swan.apps.console.c.br("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.awB().agc());
        }
    }

    public static String R(Activity activity) {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (activity == null || aIs == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int afr = aIs.afr();
        if (afr != -1) {
            b.a aIv = aIs.aIv();
            sb.append(kh(afr));
            sb.append("\n");
            if (afr == 0) {
                sb.append(ki(afr));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.ar(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.awB().fZ(afr)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.arG().aqd()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aIv.getVersion()) ? "" : aIv.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aIv.ayv());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aIv.getVersionCode()) ? "" : aIv.getVersionCode()).append("\n");
            String aVx = com.baidu.swan.games.c.d.aVo().aVx();
            if (!TextUtils.isEmpty(aVx)) {
                sb.append("app sconsole version: ").append(aVx).append("\n");
            }
            if (aIs.aIK()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long ahD = com.baidu.swan.games.utils.so.d.ahD();
            sb.append("v8 so version: ").append(ahD).append(ahD < 0 ? "(old)" : "(new)").append("\n");
            if (!aIs.aIK()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(D(0, com.baidu.swan.apps.core.turbo.d.arG().aqd()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String kh(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion azp = com.baidu.swan.apps.v.f.azN().azp();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(azp, i));
        return sb.toString();
    }

    private static String ki(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore asc = com.baidu.swan.apps.core.turbo.d.arG().asc();
            String str = "";
            int i2 = -1;
            if (asc != null) {
                str = asc.extensionCoreVersionName;
                i2 = asc.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String D(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aET() ? i.C(i, true) : "";
        } else if (!i.aNk()) {
            return "";
        } else {
            return i.C(i, z);
        }
    }
}
