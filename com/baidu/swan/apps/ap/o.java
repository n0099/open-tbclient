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
            com.baidu.swan.apps.console.c.bn("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.aud().adN());
        }
    }

    public static String R(Activity activity) {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (activity == null || aEV == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int ade = aEV.ade();
        if (ade != -1) {
            b.a aEY = aEV.aEY();
            sb.append(le(ade));
            sb.append("\n");
            if (ade == 0) {
                sb.append(lf(ade));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.aud().hi(ade)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.aph().anF()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aEY.getVersion()) ? "" : aEY.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aEY.avW());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aEY.getVersionCode()) ? "" : aEY.getVersionCode()).append("\n");
            String aRZ = com.baidu.swan.games.c.d.aRQ().aRZ();
            if (!TextUtils.isEmpty(aRZ)) {
                sb.append("app sconsole version: ").append(aRZ).append("\n");
            }
            if (aEV.aFn()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long afo = com.baidu.swan.games.utils.so.d.afo();
            sb.append("v8 so version: ").append(afo).append(afo < 0 ? "(old)" : "(new)").append("\n");
            if (!aEV.aFn()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(D(0, com.baidu.swan.apps.core.turbo.d.aph().anF()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String le(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion awQ = com.baidu.swan.apps.v.f.axo().awQ();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(awQ, i));
        return sb.toString();
    }

    private static String lf(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore apE = com.baidu.swan.apps.core.turbo.d.aph().apE();
            String str = "";
            int i2 = -1;
            if (apE != null) {
                str = apE.extensionCoreVersionName;
                i2 = apE.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String D(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aCt() ? i.C(i, true) : "";
        } else if (!i.aJN()) {
            return "";
        } else {
            return i.C(i, z);
        }
    }
}
