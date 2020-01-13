package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.extcore.e.b;
import com.baidu.swan.apps.extcore.f.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes10.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.e.b, R extends com.baidu.swan.apps.extcore.f.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P bqt;
    @NonNull
    private R bqu;

    @Nullable
    public abstract ExtensionCore OB();

    public b(@NonNull P p, @NonNull R r) {
        this.bqt = p;
        this.bqu = r;
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.bqt.b(aVar);
    }

    public void Py() {
        this.bqt.Py();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.bqu.b(t);
    }

    @NonNull
    public R Pz() {
        return this.bqu;
    }

    @NonNull
    public ExtensionCore PA() {
        String path;
        int PK = this.bqt.bqs.PK();
        if (com.baidu.swan.apps.extcore.g.a.eF(PK)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.ad(0L);
            if (PK == 1) {
                path = com.baidu.swan.games.g.a.b.PD().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.d.b.PD().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore PM = this.bqt.PM();
        ExtensionCore PM2 = this.bqu.PM();
        if (PM.extensionCoreVersionCode >= PM2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + PM.toString());
                return PM;
            }
            return PM;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + PM2.toString());
        }
        return PM2;
    }
}
