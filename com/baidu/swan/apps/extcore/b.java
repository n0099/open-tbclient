package com.baidu.swan.apps.extcore;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b fq(int i) {
        return i == 1 ? c.adJ() : a.adG();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        fq(i).f(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return fq(i).a(t);
    }

    public static ExtensionCore fr(int i) {
        return fq(i).acN();
    }

    public static String fs(int i) {
        ExtensionCore acN = fq(i).acN();
        if (acN != null) {
            String str = acN.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void ah(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.f.a.w(0, true);
            com.baidu.swan.apps.extcore.f.a.w(1, true);
        }
    }
}
