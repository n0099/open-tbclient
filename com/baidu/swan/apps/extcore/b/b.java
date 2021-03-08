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
    private P dcG;
    @NonNull
    private R dcH;

    @Nullable
    public abstract ExtensionCore asE();

    public b(@NonNull P p, @NonNull R r) {
        this.dcG = p;
        this.dcH = r;
    }

    public void n(@Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        this.dcG.o(bVar);
    }

    public void auy() {
        this.dcG.auy();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.dcH.b(t);
    }

    @NonNull
    public P auz() {
        return this.dcG;
    }

    @NonNull
    public R auA() {
        return this.dcH;
    }

    @NonNull
    public ExtensionCore auB() {
        String path;
        int auM = this.dcG.dcF.auM();
        if (com.baidu.swan.apps.extcore.f.a.hs(auM)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cl(0L);
            if (auM == 1) {
                path = com.baidu.swan.games.h.a.b.auF().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.auF().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore auO = this.dcG.auO();
        ExtensionCore auO2 = this.dcH.auO();
        if (auO.extensionCoreVersionCode >= auO2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + auO.toString());
                return auO;
            }
            return auO;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + auO2.toString());
        }
        return auO2;
    }
}
