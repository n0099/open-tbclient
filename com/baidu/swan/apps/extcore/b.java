package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b it(int i) {
        return i == 1 ? c.ato() : a.atl();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        it(i).n(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return it(i).a(t);
    }

    public static ExtensionCore iu(int i) {
        return it(i).arw();
    }

    public static String iv(int i) {
        ExtensionCore arw = it(i).arw();
        if (arw != null) {
            String str = arw.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void am(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            a atl = a.atl();
            atl.ats().bE(0L);
            atl.atr().bE(0L);
            com.baidu.swan.apps.extcore.f.a.z(0, true);
            com.baidu.swan.apps.extcore.f.a.z(1, true);
        }
    }
}
