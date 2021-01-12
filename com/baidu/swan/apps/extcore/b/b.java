package com.baidu.swan.apps.extcore.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.d.b;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes8.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.b, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P cYS;
    @NonNull
    private R cYT;

    @Nullable
    public abstract ExtensionCore asc();

    public b(@NonNull P p, @NonNull R r) {
        this.cYS = p;
        this.cYT = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.cYS.o(bVar);
    }

    public void atX() {
        this.cYS.atX();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.cYT.b(t);
    }

    @NonNull
    public P atY() {
        return this.cYS;
    }

    @NonNull
    public R atZ() {
        return this.cYT;
    }

    @NonNull
    public ExtensionCore aua() {
        String path;
        int aul = this.cYS.cYR.aul();
        if (com.baidu.swan.apps.extcore.f.a.ho(aul)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cf(0L);
            if (aul == 1) {
                path = com.baidu.swan.games.h.a.b.aue().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.aue().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore aun = this.cYS.aun();
        ExtensionCore aun2 = this.cYT.aun();
        if (aun.extensionCoreVersionCode >= aun2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + aun.toString());
                return aun;
            }
            return aun;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + aun2.toString());
        }
        return aun2;
    }
}
