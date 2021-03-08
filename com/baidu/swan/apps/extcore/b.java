package com.baidu.swan.apps.extcore;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b hk(int i) {
        return i == 1 ? c.auw() : a.aut();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        hk(i).n(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return hk(i).a(t);
    }

    public static ExtensionCore hl(int i) {
        return hk(i).asE();
    }

    public static String hm(int i) {
        ExtensionCore asE = hk(i).asE();
        if (asE != null) {
            String str = asE.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void ag(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            a aut = a.aut();
            aut.auA().ck(0L);
            aut.auz().ck(0L);
            com.baidu.swan.apps.extcore.f.a.z(0, true);
            com.baidu.swan.apps.extcore.f.a.z(1, true);
        }
    }
}
