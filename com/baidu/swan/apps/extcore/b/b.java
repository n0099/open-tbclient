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
    private P cFo;
    @NonNull
    private R cFp;

    @Nullable
    public abstract ExtensionCore anJ();

    public b(@NonNull P p, @NonNull R r) {
        this.cFo = p;
        this.cFp = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cFo.o(bVar);
    }

    public void apD() {
        this.cFo.apD();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.cFp.b(t);
    }

    @NonNull
    public P apE() {
        return this.cFo;
    }

    @NonNull
    public R apF() {
        return this.cFp;
    }

    @NonNull
    public ExtensionCore apG() {
        String path;
        int apR = this.cFo.cFn.apR();
        if (com.baidu.swan.apps.extcore.f.a.ik(apR)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.bh(0L);
            if (apR == 1) {
                path = com.baidu.swan.games.h.a.b.apK().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.apK().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore apT = this.cFo.apT();
        ExtensionCore apT2 = this.cFp.apT();
        if (apT.extensionCoreVersionCode >= apT2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + apT.toString());
                return apT;
            }
            return apT;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + apT2.toString());
        }
        return apT2;
    }
}
