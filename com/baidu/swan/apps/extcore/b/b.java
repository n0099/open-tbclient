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
    private P awU;
    @NonNull
    private R awV;

    public b(@NonNull P p, @NonNull R r) {
        this.awU = p;
        this.awV = r;
    }

    public void C(int i, int i2) {
        if (DEBUG) {
            Log.d("ExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.f.a.bi(true);
        }
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.awU.b(aVar);
    }

    public void Da() {
        this.awU.Da();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.awV.b(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public ExtensionCore Db() {
        if (DEBUG && com.baidu.swan.apps.extcore.f.a.Dq()) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.axp = 0L;
            extensionCore.axq = com.baidu.swan.apps.extcore.f.a.E(0L);
            extensionCore.axr = com.baidu.swan.apps.extcore.debug.b.De().getPath();
            extensionCore.axo = 2;
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            return extensionCore;
        }
        ExtensionCore Dm = this.awU.Dm();
        ExtensionCore Dm2 = this.awV.Dm();
        if (Dm.axp >= Dm2.axp) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Dm.toString());
                return Dm;
            }
            return Dm;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Dm2.toString());
        }
        return Dm2;
    }
}
