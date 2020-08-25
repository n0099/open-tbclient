package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b hw(int i) {
        return i == 1 ? c.amf() : a.amc();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        hw(i).n(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return hw(i).a(t);
    }

    public static ExtensionCore hx(int i) {
        return hw(i).ako();
    }

    public static String hy(int i) {
        ExtensionCore ako = hw(i).ako();
        if (ako != null) {
            String str = ako.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void am(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            a amc = a.amc();
            amc.amj().aX(0L);
            amc.ami().aX(0L);
            com.baidu.swan.apps.extcore.f.a.x(0, true);
            com.baidu.swan.apps.extcore.f.a.x(1, true);
        }
    }
}
