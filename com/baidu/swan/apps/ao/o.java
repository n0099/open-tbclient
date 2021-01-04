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
            com.baidu.swan.apps.console.c.bs("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
            com.baidu.swan.apps.console.c.bs("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.aAu().ajV());
        }
    }

    public static String R(Activity activity) {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (activity == null || aMl == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int ajk = aMl.ajk();
        if (ajk != -1) {
            b.a aMo = aMl.aMo();
            sb.append(lN(ajk));
            sb.append("\n");
            if (ajk == 0) {
                sb.append(lO(ajk));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.ar(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.aAu().hG(ajk)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.avA().atX()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aMo.getVersion()) ? "" : aMo.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aMo.aCo());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aMo.getVersionCode()) ? "" : aMo.getVersionCode()).append("\n");
            String aZq = com.baidu.swan.games.c.d.aZh().aZq();
            if (!TextUtils.isEmpty(aZq)) {
                sb.append("app sconsole version: ").append(aZq).append("\n");
            }
            if (aMl.aMD()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long alw = com.baidu.swan.games.utils.so.d.alw();
            sb.append("v8 so version: ").append(alw).append(alw < 0 ? "(old)" : "(new)").append("\n");
            if (!aMl.aMD()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(D(0, com.baidu.swan.apps.core.turbo.d.avA().atX()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String lN(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion aDi = com.baidu.swan.apps.v.f.aDG().aDi();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(aDi, i));
        return sb.toString();
    }

    private static String lO(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore avW = com.baidu.swan.apps.core.turbo.d.avA().avW();
            String str = "";
            int i2 = -1;
            if (avW != null) {
                str = avW.extensionCoreVersionName;
                i2 = avW.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String D(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aIM() ? i.C(i, true) : "";
        } else if (!i.aRd()) {
            return "";
        } else {
            return i.C(i, z);
        }
    }
}
