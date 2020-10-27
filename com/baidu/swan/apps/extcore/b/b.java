package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.extcore.d.b;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes10.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.b, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P cNK;
    @NonNull
    private R cNL;

    @Nullable
    public abstract ExtensionCore apE();

    public b(@NonNull P p, @NonNull R r) {
        this.cNK = p;
        this.cNL = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cNK.o(bVar);
    }

    public void arx() {
        this.cNK.arx();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.cNL.b(t);
    }

    @NonNull
    public P ary() {
        return this.cNK;
    }

    @NonNull
    public R arz() {
        return this.cNL;
    }

    @NonNull
    public ExtensionCore arA() {
        String path;
        int arL = this.cNK.cNJ.arL();
        if (com.baidu.swan.apps.extcore.f.a.iv(arL)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.bj(0L);
            if (arL == 1) {
                path = com.baidu.swan.games.h.a.b.arE().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.arE().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore arN = this.cNK.arN();
        ExtensionCore arN2 = this.cNL.arN();
        if (arN.extensionCoreVersionCode >= arN2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + arN.toString());
                return arN;
            }
            return arN;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + arN2.toString());
        }
        return arN2;
    }
}
