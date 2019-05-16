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
    private P avR;
    @NonNull
    private R avS;

    public b(@NonNull P p, @NonNull R r) {
        this.avR = p;
        this.avS = r;
    }

    public void z(int i, int i2) {
        if (DEBUG) {
            Log.d("ExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.f.a.bf(true);
        }
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.avR.b(aVar);
    }

    public void Cn() {
        this.avR.Cn();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.avS.b(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public ExtensionCore Co() {
        if (DEBUG && com.baidu.swan.apps.extcore.f.a.CD()) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.awm = 0L;
            extensionCore.awn = com.baidu.swan.apps.extcore.f.a.E(0L);
            extensionCore.awo = com.baidu.swan.apps.extcore.debug.b.Cr().getPath();
            extensionCore.awl = 2;
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            return extensionCore;
        }
        ExtensionCore Cz = this.avR.Cz();
        ExtensionCore Cz2 = this.avS.Cz();
        if (Cz.awm >= Cz2.awm) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Cz.toString());
                return Cz;
            }
            return Cz;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Cz2.toString());
        }
        return Cz2;
    }
}
