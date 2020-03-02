package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.extcore.e.b;
import com.baidu.swan.apps.extcore.f.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes11.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.e.b, R extends com.baidu.swan.apps.extcore.f.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P buE;
    @NonNull
    private R buF;

    @Nullable
    public abstract ExtensionCore QR();

    public b(@NonNull P p, @NonNull R r) {
        this.buE = p;
        this.buF = r;
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.buE.b(aVar);
    }

    public void RO() {
        this.buE.RO();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.buF.b(t);
    }

    @NonNull
    public R RP() {
        return this.buF;
    }

    @NonNull
    public ExtensionCore RQ() {
        String path;
        int Sa = this.buE.buD.Sa();
        if (com.baidu.swan.apps.extcore.g.a.eV(Sa)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.ah(0L);
            if (Sa == 1) {
                path = com.baidu.swan.games.g.a.b.RT().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.d.b.RT().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore Sc = this.buE.Sc();
        ExtensionCore Sc2 = this.buF.Sc();
        if (Sc.extensionCoreVersionCode >= Sc2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Sc.toString());
                return Sc;
            }
            return Sc;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Sc2.toString());
        }
        return Sc2;
    }
}
