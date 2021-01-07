package com.baidu.swan.apps.extcore;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static com.baidu.swan.apps.extcore.b.b iM(int i) {
        return i == 1 ? c.axP() : a.axM();
    }

    public static void a(int i, @Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        iM(i).n(bVar);
    }

    public static <T extends com.baidu.swan.apps.extcore.model.a> Exception a(int i, T t) {
        return iM(i).a(t);
    }

    public static ExtensionCore iN(int i) {
        return iM(i).avX();
    }

    public static String iO(int i) {
        ExtensionCore avX = iM(i).avX();
        if (avX != null) {
            String str = avX.extensionCoreVersionName;
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return "";
    }

    public static void aj(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            a axM = a.axM();
            axM.axT().ce(0L);
            axM.axS().ce(0L);
            com.baidu.swan.apps.extcore.f.a.z(0, true);
            com.baidu.swan.apps.extcore.f.a.z(1, true);
        }
    }
}
