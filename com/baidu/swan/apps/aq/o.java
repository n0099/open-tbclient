package com.baidu.swan.apps.aq;

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
            com.baidu.swan.apps.console.c.aW("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
            com.baidu.swan.apps.console.c.aW("SwanAppEnvironmentUtils", "sid = " + com.baidu.swan.apps.t.a.ahm().SD());
        }
    }

    public static String Q(Activity activity) {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (activity == null || arw == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int RU = arw.RU();
        if (RU != -1) {
            b.a arz = arw.arz();
            sb.append(id(RU));
            sb.append("\n");
            if (RU == 0) {
                sb.append(ie(RU));
                sb.append("\n");
            }
            sb.append("host version : ").append(al.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable code cache: ").append(com.baidu.swan.apps.t.a.ahm().et(RU)).append("\n");
            sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.adw().adL()).append("\n");
            sb.append("aps version: ").append(TextUtils.isEmpty(arz.getVersion()) ? "" : arz.getVersion()).append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), arz.aiZ());
            StringBuilder append = sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            append.append(formatFileSize).append("\n");
            sb.append("app bundle version: ").append(TextUtils.isEmpty(arz.getVersionCode()) ? "" : arz.getVersionCode()).append("\n");
            String aDW = com.baidu.swan.games.c.d.aDN().aDW();
            if (!TextUtils.isEmpty(aDW)) {
                sb.append("app sconsole version: ").append(aDW).append("\n");
            }
            if (arw.arO()) {
                sb.append("game engine version: ").append("1.3.1.14").append("\n");
            }
            long TW = com.baidu.swan.games.utils.so.d.TW();
            sb.append("v8 so version: ").append(TW).append(TW < 0 ? "(old)" : "(new)").append("\n");
            if (!arw.arO()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(A(0, com.baidu.swan.apps.core.turbo.d.adw().adL()))).append("\n");
            }
        }
        return sb.toString();
    }

    private static String id(int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        SwanCoreVersion ajT = com.baidu.swan.apps.v.f.akr().ajT();
        if (i == 1) {
            str = "game-core";
        } else {
            str = "swan-js";
        }
        sb.append(str).append(" version : ").append(com.baidu.swan.apps.swancore.b.a(ajT, i));
        return sb.toString();
    }

    private static String ie(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            ExtensionCore adR = com.baidu.swan.apps.core.turbo.d.adw().adR();
            String str = "";
            int i2 = -1;
            if (adR != null) {
                str = adR.extensionCoreVersionName;
                i2 = adR.extensionCoreType;
            }
            sb.append("extension-js version : ").append(str).append("   type：").append(i2);
        }
        return sb.toString();
    }

    private static String A(int i, boolean z) {
        return DEBUG ? com.baidu.swan.apps.ae.a.a.apj() ? i.z(i, true) : "" : (i.awq() && com.baidu.swan.apps.t.a.ahm().SE()) ? i.z(i, z) : "";
    }
}
