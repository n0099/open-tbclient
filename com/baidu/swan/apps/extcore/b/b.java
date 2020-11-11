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
    private P cTD;
    @NonNull
    private R cTE;

    @Nullable
    public abstract ExtensionCore ase();

    public b(@NonNull P p, @NonNull R r) {
        this.cTD = p;
        this.cTE = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cTD.o(bVar);
    }

    public void atY() {
        this.cTD.atY();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.cTE.b(t);
    }

    @NonNull
    public P atZ() {
        return this.cTD;
    }

    @NonNull
    public R aua() {
        return this.cTE;
    }

    @NonNull
    public ExtensionCore aub() {
        String path;
        int aum = this.cTD.cTC.aum();
        if (com.baidu.swan.apps.extcore.f.a.iF(aum)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.bF(0L);
            if (aum == 1) {
                path = com.baidu.swan.games.h.a.b.auf().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.auf().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore auo = this.cTD.auo();
        ExtensionCore auo2 = this.cTE.auo();
        if (auo.extensionCoreVersionCode >= auo2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + auo.toString());
                return auo;
            }
            return auo;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + auo2.toString());
        }
        return auo2;
    }
}
