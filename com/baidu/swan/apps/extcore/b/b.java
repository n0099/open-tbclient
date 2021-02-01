package com.baidu.swan.apps.extcore.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.d.b;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes9.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.b, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P dbe;
    @NonNull
    private R dbf;

    @Nullable
    public abstract ExtensionCore asB();

    public b(@NonNull P p, @NonNull R r) {
        this.dbe = p;
        this.dbf = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.dbe.o(bVar);
    }

    public void auv() {
        this.dbe.auv();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.dbf.b(t);
    }

    @NonNull
    public P auw() {
        return this.dbe;
    }

    @NonNull
    public R aux() {
        return this.dbf;
    }

    @NonNull
    public ExtensionCore auy() {
        String path;
        int auJ = this.dbe.dbd.auJ();
        if (com.baidu.swan.apps.extcore.f.a.hr(auJ)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cl(0L);
            if (auJ == 1) {
                path = com.baidu.swan.games.h.a.b.auC().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.auC().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore auL = this.dbe.auL();
        ExtensionCore auL2 = this.dbf.auL();
        if (auL.extensionCoreVersionCode >= auL2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + auL.toString());
                return auL;
            }
            return auL;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + auL2.toString());
        }
        return auL2;
    }
}
