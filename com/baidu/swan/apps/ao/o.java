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
            com.baidu.swan.apps.console.c.bs("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.aAv().ajW());
        }
    }

    public static String R(Activity activity) {
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (activity == null || aMm == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int ajl = aMm.ajl();
        if (ajl != -1) {
            b.a aMp = aMm.aMp();
            sb.append(lN(ajl));
            sb.append("\n");
            if (ajl == 0) {
                sb.append(lO(ajl));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.ar(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.aAv().hG(ajl)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.avB().atY()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aMp.getVersion()) ? "" : aMp.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aMp.aCp());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aMp.getVersionCode()) ? "" : aMp.getVersionCode()).append("\n");
            String aZr = com.baidu.swan.games.c.d.aZi().aZr();
            if (!TextUtils.isEmpty(aZr)) {
                sb.append("app sconsole version: ").append(aZr).append("\n");
            }
            if (aMm.aME()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long alx = com.baidu.swan.games.utils.so.d.alx();
            sb.append("v8 so version: ").append(alx).append(alx < 0 ? "(old)" : "(new)").append("\n");
            if (!aMm.aME()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(D(0, com.baidu.swan.apps.core.turbo.d.avB().atY()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String lN(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion aDj = com.baidu.swan.apps.v.f.aDH().aDj();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(aDj, i));
        return sb.toString();
    }

    private static String lO(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore avX = com.baidu.swan.apps.core.turbo.d.avB().avX();
            String str = "";
            int i2 = -1;
            if (avX != null) {
                str = avX.extensionCoreVersionName;
                i2 = avX.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String D(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aIN() ? i.C(i, true) : "";
        } else if (!i.aRe()) {
            return "";
        } else {
            return i.C(i, z);
        }
    }
}
