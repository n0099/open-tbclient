package com.baidu.swan.apps.u.f;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.pms.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.Locale;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean ql(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m(com.baidu.swan.pms.database.a.bdF().yO(str));
    }

    public static boolean a(@Nullable PMSAppInfo pMSAppInfo, @Nullable Bundle bundle) {
        String str;
        boolean z;
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.versionCode == 0 || bundle == null || pMSAppInfo.appCategory == 1) {
            return false;
        }
        File bT = d.C0474d.bT(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
        if (bT.exists()) {
            String string = bundle.getString("mPage");
            if (TextUtils.isEmpty(string)) {
                boolean exists = new File(bT, "app.json").exists();
                c.bt("SwanAppLaunchUtils", "checkSwanAppPageDirExist app.json exists: " + exists);
                return exists;
            }
            String uX = ai.uX(string);
            int lastIndexOf = uX.lastIndexOf(File.separator);
            if (lastIndexOf >= 0) {
                uX = uX.substring(0, lastIndexOf);
            }
            boolean exists2 = new File(bT, uX).exists();
            if (exists2) {
                if (new File(bT, "app.json").exists()) {
                    return true;
                }
                int lastIndexOf2 = uX.lastIndexOf(File.separator);
                while (true) {
                    if (lastIndexOf2 < 0) {
                        str = uX;
                        z = false;
                        break;
                    }
                    uX = uX.substring(0, lastIndexOf2);
                    if (new File(bT, uX + File.separator + "app.json").exists()) {
                        str = uX;
                        z = true;
                        break;
                    }
                    lastIndexOf2 = uX.lastIndexOf(File.separator);
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
            return a.c.bT(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).exists();
        }
        return d.y(d.C0474d.bT(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)));
    }

    public static boolean a(PMSAppInfo pMSAppInfo, String str) {
        if (pMSAppInfo == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String uX = ai.uX(str);
        if (uX.lastIndexOf(File.separator) != -1) {
            uX = uX.substring(0, uX.lastIndexOf(File.separator));
        }
        return d.P(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), uX).exists();
    }

    public static String b(PMSAppInfo pMSAppInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String uX = ai.uX(str);
        String str2 = uX;
        int lastIndexOf = uX.lastIndexOf(File.separator);
        while (lastIndexOf != -1) {
            str2 = str2.substring(0, lastIndexOf);
            if (!d.Q(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), str2)) {
                lastIndexOf = str2.lastIndexOf(File.separator);
            } else {
                return str2;
            }
        }
        return !d.Q(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), str2) ? "" : str2;
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
                cVar.nq(bundle.getInt("pms_update_expect_pkg_ver"));
            }
            if (DEBUG) {
                Log.i("SwanAppLaunchUtils", String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i), Integer.valueOf(cVar.bey())));
            }
            cVar.zc("4");
            com.baidu.swan.pms.c.a(cVar, new e(string) { // from class: com.baidu.swan.apps.u.f.a.1
                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void bx(String str, String str2) {
                    super.bx(str, str2);
                    if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.cSm != null) {
                        this.cSm.add(new UbcFlowEvent(str2));
                    }
                }
            }.iE(3));
        }
    }
}
