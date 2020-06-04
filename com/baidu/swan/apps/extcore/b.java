package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b ff(int i) {
        return i == 1 ? c.acD() : a.acA();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        ff(i).f(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return ff(i).a(t);
    }

    public static ExtensionCore fg(int i) {
        return ff(i).abH();
    }

    public static String fh(int i) {
        ExtensionCore abH = ff(i).abH();
        if (abH != null) {
            String str = abH.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void af(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.f.a.v(0, true);
            com.baidu.swan.apps.extcore.f.a.v(1, true);
        }
    }
}
