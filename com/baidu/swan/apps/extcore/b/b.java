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
    private P cRT;
    @NonNull
    private R cRU;

    @Nullable
    public abstract ExtensionCore arw();

    public b(@NonNull P p, @NonNull R r) {
        this.cRT = p;
        this.cRU = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cRT.o(bVar);
    }

    public void atq() {
        this.cRT.atq();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.cRU.b(t);
    }

    @NonNull
    public P atr() {
        return this.cRT;
    }

    @NonNull
    public R ats() {
        return this.cRU;
    }

    @NonNull
    public ExtensionCore att() {
        String path;
        int atE = this.cRT.cRS.atE();
        if (com.baidu.swan.apps.extcore.f.a.iB(atE)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.bF(0L);
            if (atE == 1) {
                path = com.baidu.swan.games.h.a.b.atx().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.atx().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore atG = this.cRT.atG();
        ExtensionCore atG2 = this.cRU.atG();
        if (atG.extensionCoreVersionCode >= atG2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + atG.toString());
                return atG;
            }
            return atG;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + atG2.toString());
        }
        return atG2;
    }
}
