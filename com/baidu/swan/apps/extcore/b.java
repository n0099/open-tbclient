package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b iR(int i) {
        return i == 1 ? c.aww() : a.awt();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        iR(i).n(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return iR(i).a(t);
    }

    public static ExtensionCore iS(int i) {
        return iR(i).auE();
    }

    public static String iT(int i) {
        ExtensionCore auE = iR(i).auE();
        if (auE != null) {
            String str = auE.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void ao(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            a awt = a.awt();
            awt.awA().cd(0L);
            awt.awz().cd(0L);
            com.baidu.swan.apps.extcore.f.a.z(0, true);
            com.baidu.swan.apps.extcore.f.a.z(1, true);
        }
    }
}
