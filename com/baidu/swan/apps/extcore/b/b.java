package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.extcore.d.b;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes8.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.b, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P cqW;
    @NonNull
    private R cqX;

    @Nullable
    public abstract ExtensionCore ako();

    public b(@NonNull P p, @NonNull R r) {
        this.cqW = p;
        this.cqX = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cqW.o(bVar);
    }

    public void amh() {
        this.cqW.amh();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.cqX.b(t);
    }

    @NonNull
    public P ami() {
        return this.cqW;
    }

    @NonNull
    public R amj() {
        return this.cqX;
    }

    @NonNull
    public ExtensionCore amk() {
        String path;
        int amv = this.cqW.cqV.amv();
        if (com.baidu.swan.apps.extcore.f.a.hE(amv)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aY(0L);
            if (amv == 1) {
                path = com.baidu.swan.games.h.a.b.amo().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.amo().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore amx = this.cqW.amx();
        ExtensionCore amx2 = this.cqX.amx();
        if (amx.extensionCoreVersionCode >= amx2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + amx.toString());
                return amx;
            }
            return amx;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + amx2.toString());
        }
        return amx2;
    }
}
