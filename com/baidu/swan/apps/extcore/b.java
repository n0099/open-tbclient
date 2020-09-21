package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b hF(int i) {
        return i == 1 ? c.amP() : a.amM();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        hF(i).n(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return hF(i).a(t);
    }

    public static ExtensionCore hG(int i) {
        return hF(i).akY();
    }

    public static String hH(int i) {
        ExtensionCore akY = hF(i).akY();
        if (akY != null) {
            String str = akY.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void am(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            a amM = a.amM();
            amM.amT().aY(0L);
            amM.amS().aY(0L);
            com.baidu.swan.apps.extcore.f.a.x(0, true);
            com.baidu.swan.apps.extcore.f.a.x(1, true);
        }
    }
}
