package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b ew(int i) {
        return i == 1 ? c.Pa() : a.OX();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        ew(i).a(aVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> boolean a(int i, T t) {
        return ew(i).a((com.baidu.swan.apps.extcore.b.b) t);
    }

    public static ExtensionCore ex(int i) {
        return ew(i).Of();
    }

    public static String ey(int i) {
        ExtensionCore Of = ew(i).Of();
        if (Of != null) {
            String str = Of.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void V(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.g.a.q(0, true);
            com.baidu.swan.apps.extcore.g.a.q(1, true);
        }
    }
}
