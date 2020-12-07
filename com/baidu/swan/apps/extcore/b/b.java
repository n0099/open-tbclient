package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.extcore.d.b;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes25.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.b, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P cYM;
    @NonNull
    private R cYN;

    @Nullable
    public abstract ExtensionCore auE();

    public b(@NonNull P p, @NonNull R r) {
        this.cYM = p;
        this.cYN = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.cYM.o(bVar);
    }

    public void awy() {
        this.cYM.awy();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.cYN.b(t);
    }

    @NonNull
    public P awz() {
        return this.cYM;
    }

    @NonNull
    public R awA() {
        return this.cYN;
    }

    @NonNull
    public ExtensionCore awB() {
        String path;
        int awM = this.cYM.cYL.awM();
        if (com.baidu.swan.apps.extcore.f.a.iZ(awM)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.ce(0L);
            if (awM == 1) {
                path = com.baidu.swan.games.h.a.b.awF().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.awF().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore awO = this.cYM.awO();
        ExtensionCore awO2 = this.cYN.awO();
        if (awO.extensionCoreVersionCode >= awO2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + awO.toString());
                return awO;
            }
            return awO;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + awO2.toString());
        }
        return awO2;
    }
}
