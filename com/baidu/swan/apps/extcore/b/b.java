package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.extcore.d.b;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes3.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.b, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P ctd;
    @NonNull
    private R cte;

    @Nullable
    public abstract ExtensionCore akY();

    public b(@NonNull P p, @NonNull R r) {
        this.ctd = p;
        this.cte = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        this.ctd.o(bVar);
    }

    public void amR() {
        this.ctd.amR();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.cte.b(t);
    }

    @NonNull
    public P amS() {
        return this.ctd;
    }

    @NonNull
    public R amT() {
        return this.cte;
    }

    @NonNull
    public ExtensionCore amU() {
        String path;
        int anf = this.ctd.ctc.anf();
        if (com.baidu.swan.apps.extcore.f.a.hN(anf)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aZ(0L);
            if (anf == 1) {
                path = com.baidu.swan.games.h.a.b.amY().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.amY().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore anh = this.ctd.anh();
        ExtensionCore anh2 = this.cte.anh();
        if (anh.extensionCoreVersionCode >= anh2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + anh.toString());
                return anh;
            }
            return anh;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + anh2.toString());
        }
        return anh2;
    }
}
