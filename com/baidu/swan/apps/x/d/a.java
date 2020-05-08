package com.baidu.swan.apps.x.d;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.games.k.a;
import com.baidu.swan.pms.c.d.c;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.Locale;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean kd(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return i(com.baidu.swan.pms.database.a.aBI().rA(str));
    }

    public static boolean i(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.versionCode == 0) {
            return false;
        }
        if (pMSAppInfo.appCategory == 1) {
            return a.c.aT(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).exists();
        }
        return e.q(e.d.aT(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)));
    }

    public static boolean a(PMSAppInfo pMSAppInfo, String str) {
        if (pMSAppInfo == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String oe = ag.oe(str);
        if (oe.lastIndexOf(File.separator) != -1) {
            oe = oe.substring(0, oe.lastIndexOf(File.separator));
        }
        return e.z(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), oe).exists();
    }

    public static void G(@NonNull Bundle bundle) {
        if (DEBUG) {
            Log.i("SwanAppLaunchUtils", "asyncUpdatePkg: swanAsyncUpdate -> 异步更新小程序包 开始");
        }
        String string = bundle.getString("mAppId");
        if (!TextUtils.isEmpty(string)) {
            int i = bundle.getInt("appFrameType");
            if (1 != i) {
                i = 0;
            }
            c cVar = new c(string, i);
            if (bundle.containsKey("pms_update_expect_pkg_ver")) {
                cVar.iQ(bundle.getInt("pms_update_expect_pkg_ver"));
            }
            if (DEBUG) {
                Log.i("SwanAppLaunchUtils", String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i), Integer.valueOf(cVar.aCA())));
            }
            cVar.rO("4");
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.e(string) { // from class: com.baidu.swan.apps.x.d.a.1
                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void aE(String str, String str2) {
                    super.aE(str, str2);
                    if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.bOC != null) {
                        this.bOC.add(new UbcFlowEvent(str2));
                    }
                }
            });
        }
    }
}
