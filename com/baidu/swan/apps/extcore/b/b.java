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
    private P aww;
    @NonNull
    private R awx;

    public b(@NonNull P p, @NonNull R r) {
        this.aww = p;
        this.awx = r;
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
        this.aww.b(aVar);
    }

    public void CW() {
        this.aww.CW();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.awx.b(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public ExtensionCore CX() {
        if (DEBUG && com.baidu.swan.apps.extcore.f.a.Dm()) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.awR = 0L;
            extensionCore.awS = com.baidu.swan.apps.extcore.f.a.E(0L);
            extensionCore.awT = com.baidu.swan.apps.extcore.debug.b.Da().getPath();
            extensionCore.awQ = 2;
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            return extensionCore;
        }
        ExtensionCore Di = this.aww.Di();
        ExtensionCore Di2 = this.awx.Di();
        if (Di.awR >= Di2.awR) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Di.toString());
                return Di;
            }
            return Di;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Di2.toString());
        }
        return Di2;
    }
}
