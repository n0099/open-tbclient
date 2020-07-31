package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.extcore.d.b;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes7.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.b, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P cjJ;
    @NonNull
    private R cjK;

    @Nullable
    public abstract ExtensionCore adR();

    public b(@NonNull P p, @NonNull R r) {
        this.cjJ = p;
        this.cjK = r;
    }

    public void g(@Nullable com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        this.cjJ.h(bVar);
    }

    public void afb() {
        this.cjJ.afb();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.cjK.b(t);
    }

    @NonNull
    public R afc() {
        return this.cjK;
    }

    @NonNull
    public ExtensionCore afd() {
        String path;
        int afo = this.cjJ.cjI.afo();
        if (com.baidu.swan.apps.extcore.f.a.fH(afo)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aV(0L);
            if (afo == 1) {
                path = com.baidu.swan.games.h.a.b.afh().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.afh().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore afq = this.cjJ.afq();
        ExtensionCore afq2 = this.cjK.afq();
        if (afq.extensionCoreVersionCode >= afq2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + afq.toString());
                return afq;
            }
            return afq;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + afq2.toString());
        }
        return afq2;
    }
}
