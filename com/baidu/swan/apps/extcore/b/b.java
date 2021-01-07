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
    private P ddI;
    @NonNull
    private R ddJ;

    @Nullable
    public abstract ExtensionCore avX();

    public b(@NonNull P p, @NonNull R r) {
        this.ddI = p;
        this.ddJ = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.ddI.o(bVar);
    }

    public void axR() {
        this.ddI.axR();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.ddJ.b(t);
    }

    @NonNull
    public P axS() {
        return this.ddI;
    }

    @NonNull
    public R axT() {
        return this.ddJ;
    }

    @NonNull
    public ExtensionCore axU() {
        String path;
        int ayf = this.ddI.ddH.ayf();
        if (com.baidu.swan.apps.extcore.f.a.iU(ayf)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cf(0L);
            if (ayf == 1) {
                path = com.baidu.swan.games.h.a.b.axY().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.axY().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore ayh = this.ddI.ayh();
        ExtensionCore ayh2 = this.ddJ.ayh();
        if (ayh.extensionCoreVersionCode >= ayh2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + ayh.toString());
                return ayh;
            }
            return ayh;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + ayh2.toString());
        }
        return ayh2;
    }
}
