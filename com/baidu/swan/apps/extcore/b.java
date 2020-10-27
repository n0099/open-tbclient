package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b in(int i) {
        return i == 1 ? c.arv() : a.ars();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        in(i).n(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return in(i).a(t);
    }

    public static ExtensionCore io(int i) {
        return in(i).apE();
    }

    public static String ip(int i) {
        ExtensionCore apE = in(i).apE();
        if (apE != null) {
            String str = apE.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void am(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            a ars = a.ars();
            ars.arz().bi(0L);
            ars.ary().bi(0L);
            com.baidu.swan.apps.extcore.f.a.z(0, true);
            com.baidu.swan.apps.extcore.f.a.z(1, true);
        }
    }
}
