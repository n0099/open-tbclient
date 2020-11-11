package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b ix(int i) {
        return i == 1 ? c.atW() : a.atT();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        ix(i).n(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return ix(i).a(t);
    }

    public static ExtensionCore iy(int i) {
        return ix(i).ase();
    }

    public static String iz(int i) {
        ExtensionCore ase = ix(i).ase();
        if (ase != null) {
            String str = ase.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void am(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            a atT = a.atT();
            atT.aua().bE(0L);
            atT.atZ().bE(0L);
            com.baidu.swan.apps.extcore.f.a.z(0, true);
            com.baidu.swan.apps.extcore.f.a.z(1, true);
        }
    }
}
