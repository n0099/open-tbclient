package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b eS(int i) {
        return i == 1 ? c.ZD() : a.ZA();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        eS(i).a(aVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> boolean a(int i, T t) {
        return eS(i).a((com.baidu.swan.apps.extcore.b.b) t);
    }

    public static ExtensionCore eT(int i) {
        return eS(i).YI();
    }

    public static String eU(int i) {
        ExtensionCore YI = eS(i).YI();
        if (YI != null) {
            String str = YI.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void ac(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.g.a.u(0, true);
            com.baidu.swan.apps.extcore.g.a.u(1, true);
        }
    }
}
