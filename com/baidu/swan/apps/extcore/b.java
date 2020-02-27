package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b eN(int i) {
        return i == 1 ? c.RK() : a.RH();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        eN(i).a(aVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> boolean a(int i, T t) {
        return eN(i).a((com.baidu.swan.apps.extcore.b.b) t);
    }

    public static ExtensionCore eO(int i) {
        return eN(i).QP();
    }

    public static String eP(int i) {
        ExtensionCore QP = eN(i).QP();
        if (QP != null) {
            String str = QP.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void Z(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.g.a.q(0, true);
            com.baidu.swan.apps.extcore.g.a.q(1, true);
        }
    }
}
