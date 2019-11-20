package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.d.a;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes2.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.a, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P aPR;
    @NonNull
    private R aPS;

    public b(@NonNull P p, @NonNull R r) {
        this.aPR = p;
        this.aPS = r;
    }

    public void G(int i, int i2) {
        if (DEBUG) {
            Log.d("ExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.f.a.bA(true);
        }
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.aPR.b(aVar);
    }

    public void HV() {
        this.aPR.HV();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.aPS.b(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public ExtensionCore HW() {
        if (DEBUG && com.baidu.swan.apps.extcore.f.a.Il()) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.aQm = 0L;
            extensionCore.aQn = com.baidu.swan.apps.extcore.f.a.W(0L);
            extensionCore.aQo = com.baidu.swan.apps.extcore.debug.b.HZ().getPath();
            extensionCore.aQl = 2;
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            return extensionCore;
        }
        ExtensionCore Ih = this.aPR.Ih();
        ExtensionCore Ih2 = this.aPS.Ih();
        if (Ih.aQm >= Ih2.aQm) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Ih.toString());
                return Ih;
            }
            return Ih;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Ih2.toString());
        }
        return Ih2;
    }
}
