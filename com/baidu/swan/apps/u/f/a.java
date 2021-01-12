package com.baidu.swan.apps.u.f;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.pms.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.Locale;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean oT(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m(com.baidu.swan.pms.database.a.bci().xC(str));
    }

    public static boolean a(@Nullable PMSAppInfo pMSAppInfo, @Nullable Bundle bundle) {
        boolean z;
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.versionCode == 0 || bundle == null || pMSAppInfo.appCategory == 1) {
            return false;
        }
        File bR = d.C0449d.bR(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
        if (bR.exists()) {
            String string = bundle.getString("mPage");
            if (TextUtils.isEmpty(string)) {
                boolean exists = new File(bR, "app.json").exists();
                c.br("SwanAppLaunchUtils", "checkSwanAppPageDirExist app.json exists: " + exists);
                return exists;
            }
            String tL = ai.tL(string);
            int lastIndexOf = tL.lastIndexOf(File.separator);
            if (lastIndexOf >= 0) {
                tL = tL.substring(0, lastIndexOf);
            }
            boolean exists2 = new File(bR, tL).exists();
            if (exists2) {
                if (new File(bR, "app.json").exists()) {
                    return true;
                }
                int lastIndexOf2 = tL.lastIndexOf(File.separator);
                String str = tL;
                while (true) {
                    if (lastIndexOf2 < 0) {
                        z = false;
                        break;
                    }
                    str = str.substring(0, lastIndexOf2);
                    if (new File(bR, str + File.separator + "app.json").exists()) {
                        z = true;
                        break;
                    }
                    lastIndexOf2 = str.lastIndexOf(File.separator);
                }
                if (DEBUG) {
                    Log.d("SwanAppLaunchUtils", "isInDependentPkg=" + z + ", pagePath=" + str);
                }
                if (z && !TextUtils.isEmpty(str)) {
                    bundle.putBoolean("swan_app_independent", true);
                    bundle.putString("swan_app_sub_root_path", str);
                }
            }
            return exists2;
        }
        return false;
    }

    public static boolean m(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.versionCode == 0) {
            return false;
        }
        if (pMSAppInfo.appCategory == 1) {
            return a.c.bR(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).exists();
        }
        return d.A(d.C0449d.bR(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)));
    }

    public static boolean a(PMSAppInfo pMSAppInfo, String str) {
        if (pMSAppInfo == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String tL = ai.tL(str);
        if (tL.lastIndexOf(File.separator) != -1) {
            tL = tL.substring(0, tL.lastIndexOf(File.separator));
        }
        return d.R(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), tL).exists();
    }

    public static String b(PMSAppInfo pMSAppInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String tL = ai.tL(str);
        int lastIndexOf = tL.lastIndexOf(File.separator);
        while (lastIndexOf != -1) {
            tL = tL.substring(0, lastIndexOf);
            if (!d.S(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), tL)) {
                lastIndexOf = tL.lastIndexOf(File.separator);
            } else {
                return tL;
            }
        }
        return !d.S(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), tL) ? "" : tL;
    }

    public static void I(@NonNull Bundle bundle) {
        if (DEBUG) {
            Log.i("SwanAppLaunchUtils", "asyncUpdatePkg: swanAsyncUpdate -> 异步更新小程序包 开始");
        }
        String string = bundle.getString("mAppId");
        if (!TextUtils.isEmpty(string)) {
            int i = bundle.getInt("appFrameType");
            if (1 != i) {
                i = 0;
            }
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(string, i);
            if (bundle.containsKey("pms_update_expect_pkg_ver")) {
                cVar.lT(bundle.getInt("pms_update_expect_pkg_ver"));
            }
            if (DEBUG) {
                Log.i("SwanAppLaunchUtils", String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i), Integer.valueOf(cVar.bda())));
            }
            cVar.xQ("4");
            com.baidu.swan.pms.c.a(cVar, new e(string) { // from class: com.baidu.swan.apps.u.f.a.1
                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void bv(String str, String str2) {
                    super.bv(str, str2);
                    if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.cSx != null) {
                        this.cSx.add(new UbcFlowEvent(str2));
                    }
                }
            }.gT(3));
        }
    }
}
