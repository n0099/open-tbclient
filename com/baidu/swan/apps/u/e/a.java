package com.baidu.swan.apps.u.e;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.c.d.c;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.Locale;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;

    public static boolean lY(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m(com.baidu.swan.pms.database.a.aKS().uq(str));
    }

    public static boolean a(@Nullable PMSAppInfo pMSAppInfo, @Nullable Bundle bundle) {
        String str;
        boolean z;
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.versionCode == 0 || bundle == null || pMSAppInfo.appCategory == 1) {
            return false;
        }
        File bq = d.C0380d.bq(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
        if (bq.exists()) {
            String string = bundle.getString("mPage");
            if (TextUtils.isEmpty(string)) {
                return new File(bq, "app.json").exists();
            }
            String qH = aj.qH(string);
            int lastIndexOf = qH.lastIndexOf(File.separator);
            if (lastIndexOf >= 0) {
                qH = qH.substring(0, lastIndexOf);
            }
            boolean exists = new File(bq, qH).exists();
            if (exists) {
                int lastIndexOf2 = qH.lastIndexOf(File.separator);
                while (true) {
                    if (lastIndexOf2 < 0) {
                        str = qH;
                        z = false;
                        break;
                    }
                    qH = qH.substring(0, lastIndexOf2);
                    if (new File(bq, qH + File.separator + "app.json").exists()) {
                        str = qH;
                        z = true;
                        break;
                    }
                    lastIndexOf2 = qH.lastIndexOf(File.separator);
                }
                if (DEBUG) {
                    Log.d("SwanAppLaunchUtils", "isInDependentPkg=" + z + ", pagePath=" + str);
                }
                if (z && !TextUtils.isEmpty(str)) {
                    bundle.putBoolean("swan_app_independent", true);
                    bundle.putString("swan_app_sub_root_path", str);
                }
            }
            return exists;
        }
        return false;
    }

    public static boolean m(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.versionCode == 0) {
            return false;
        }
        if (pMSAppInfo.appCategory == 1) {
            return a.c.bq(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).exists();
        }
        return d.v(d.C0380d.bq(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)));
    }

    public static boolean a(PMSAppInfo pMSAppInfo, String str) {
        if (pMSAppInfo == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String qH = aj.qH(str);
        if (qH.lastIndexOf(File.separator) != -1) {
            qH = qH.substring(0, qH.lastIndexOf(File.separator));
        }
        return d.D(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), qH).exists();
    }

    public static String b(PMSAppInfo pMSAppInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String qH = aj.qH(str);
        String str2 = qH;
        int lastIndexOf = qH.lastIndexOf(File.separator);
        while (lastIndexOf != -1) {
            str2 = str2.substring(0, lastIndexOf);
            if (!d.E(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), str2)) {
                lastIndexOf = str2.lastIndexOf(File.separator);
            } else {
                return str2;
            }
        }
        return !d.E(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), str2) ? "" : str2;
    }

    public static void K(@NonNull Bundle bundle) {
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
                cVar.jM(bundle.getInt("pms_update_expect_pkg_ver"));
            }
            if (DEBUG) {
                Log.i("SwanAppLaunchUtils", String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i), Integer.valueOf(cVar.aLN())));
            }
            cVar.uE("4");
            com.baidu.swan.pms.c.a(cVar, new e(string) { // from class: com.baidu.swan.apps.u.e.a.1
                @Override // com.baidu.swan.pms.a.g, com.baidu.swan.pms.a.d
                public void aY(String str, String str2) {
                    super.aY(str, str2);
                    if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.ceb != null) {
                        this.ceb.add(new UbcFlowEvent(str2));
                    }
                }
            }.fn(3));
        }
    }
}
