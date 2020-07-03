package com.baidu.swan.apps.v.d;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.c.d.c;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.Locale;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean lx(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return j(com.baidu.swan.pms.database.a.aHb().tn(str));
    }

    public static boolean j(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.versionCode == 0) {
            return false;
        }
        if (pMSAppInfo.appCategory == 1) {
            return a.c.bm(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).exists();
        }
        return e.u(e.d.bm(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)));
    }

    public static boolean a(PMSAppInfo pMSAppInfo, String str) {
        if (pMSAppInfo == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String pV = ah.pV(str);
        if (pV.lastIndexOf(File.separator) != -1) {
            pV = pV.substring(0, pV.lastIndexOf(File.separator));
        }
        return e.D(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), pV).exists();
    }

    public static void J(@NonNull Bundle bundle) {
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
                cVar.jt(bundle.getInt("pms_update_expect_pkg_ver"));
            }
            if (DEBUG) {
                Log.i("SwanAppLaunchUtils", String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i), Integer.valueOf(cVar.aHW())));
            }
            cVar.tB("4");
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.e(string) { // from class: com.baidu.swan.apps.v.d.a.1
                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void aW(String str, String str2) {
                    super.aW(str, str2);
                    if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.ccx != null) {
                        this.ccx.add(new UbcFlowEvent(str2));
                    }
                }
            });
        }
    }
}
