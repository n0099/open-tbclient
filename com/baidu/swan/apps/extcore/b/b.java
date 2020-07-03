package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.extcore.d.b;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes11.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.b, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P chK;
    @NonNull
    private R chL;

    @Nullable
    public abstract ExtensionCore acN();

    public b(@NonNull P p, @NonNull R r) {
        this.chK = p;
        this.chL = r;
    }

    public void f(@Nullable com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        this.chK.g(bVar);
    }

    public void adL() {
        this.chK.adL();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.chL.b(t);
    }

    @NonNull
    public R adM() {
        return this.chL;
    }

    @NonNull
    public ExtensionCore adN() {
        String path;
        int adX = this.chK.chJ.adX();
        if (com.baidu.swan.apps.extcore.f.a.fy(adX)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aS(0L);
            if (adX == 1) {
                path = com.baidu.swan.games.h.a.b.adQ().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.adQ().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore adZ = this.chK.adZ();
        ExtensionCore adZ2 = this.chL.adZ();
        if (adZ.extensionCoreVersionCode >= adZ2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + adZ.toString());
                return adZ;
            }
            return adZ;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + adZ2.toString());
        }
        return adZ2;
    }
}
