package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.f.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes2.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.e.a, R extends com.baidu.swan.apps.extcore.f.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P avy;
    @NonNull
    private R avz;

    public b(@NonNull P p, @NonNull R r) {
        this.avy = p;
        this.avz = r;
    }

    public void B(int i, int i2) {
        if (DEBUG) {
            Log.d("ExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.g.a.bb(true);
        }
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.avy.b(aVar);
    }

    public void Bk() {
        this.avy.Bk();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.avz.b(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public ExtensionCore Bl() {
        if (DEBUG && com.baidu.swan.apps.extcore.g.a.BB()) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.avP = 0L;
            extensionCore.avQ = com.baidu.swan.apps.extcore.g.a.v(0L);
            extensionCore.avR = com.baidu.swan.apps.extcore.d.b.Bo().getPath();
            extensionCore.avO = 2;
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            return extensionCore;
        }
        ExtensionCore Bx = this.avy.Bx();
        ExtensionCore Bx2 = this.avz.Bx();
        if (Bx.avP >= Bx2.avP) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Bx.toString());
                return Bx;
            }
            return Bx;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Bx2.toString());
        }
        return Bx2;
    }
}
