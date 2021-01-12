package com.baidu.swan.apps.extcore;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b hg(int i) {
        return i == 1 ? c.atV() : a.atS();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        hg(i).n(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return hg(i).a(t);
    }

    public static ExtensionCore hh(int i) {
        return hg(i).asc();
    }

    public static String hi(int i) {
        ExtensionCore asc = hg(i).asc();
        if (asc != null) {
            String str = asc.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void aj(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            a atS = a.atS();
            atS.atZ().ce(0L);
            atS.atY().ce(0L);
            com.baidu.swan.apps.extcore.f.a.z(0, true);
            com.baidu.swan.apps.extcore.f.a.z(1, true);
        }
    }
}
