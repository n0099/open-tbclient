package com.baidu.swan.apps.ap;

import android.app.Activity;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes3.dex */
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
            com.baidu.swan.apps.console.c.bb("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
            com.baidu.swan.apps.console.c.bb("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.apx().Zh());
        }
    }

    public static String Q(Activity activity) {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (activity == null || aAs == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int Yy = aAs.Yy();
        if (Yy != -1) {
            b.a aAv = aAs.aAv();
            sb.append(kw(Yy));
            sb.append("\n");
            if (Yy == 0) {
                sb.append(kx(Yy));
                sb.append("\n");
            }
            sb.append("host version : ").append(ak.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.apx().gA(Yy)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.akC().aja()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(aAv.getVersion()) ? "" : aAv.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aAv.arq());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(aAv.getVersionCode()) ? "" : aAv.getVersionCode()).append("\n");
            String aNw = com.baidu.swan.games.c.d.aNn().aNw();
            if (!TextUtils.isEmpty(aNw)) {
                sb.append("app sconsole version: ").append(aNw).append("\n");
            }
            if (aAs.aAK()) {
                sb.append("game engine version: ").append("1.3.1.15").append("\n");
            }
            long aaI = com.baidu.swan.games.utils.so.d.aaI();
            sb.append("v8 so version: ").append(aaI).append(aaI < 0 ? "(old)" : "(new)").append("\n");
            if (!aAs.aAK()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(B(0, com.baidu.swan.apps.core.turbo.d.akC().aja()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String kw(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion ask = com.baidu.swan.apps.v.f.asJ().ask();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(ask, i));
        return sb.toString();
    }

    private static String kx(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore akY = com.baidu.swan.apps.core.turbo.d.akC().akY();
            String str = "";
            int i2 = -1;
            if (akY != null) {
                str = akY.extensionCoreVersionName;
                i2 = akY.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String B(int i, boolean z) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.axO() ? i.A(i, true) : "";
        } else if (!i.aFk()) {
            return "";
        } else {
            return i.A(i, z);
        }
    }
}
