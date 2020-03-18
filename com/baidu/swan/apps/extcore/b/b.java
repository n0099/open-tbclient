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
    private P buR;
    @NonNull
    private R buS;

    @Nullable
    public abstract ExtensionCore QU();

    public b(@NonNull P p, @NonNull R r) {
        this.buR = p;
        this.buS = r;
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.buR.b(aVar);
    }

    public void RR() {
        this.buR.RR();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.buS.b(t);
    }

    @NonNull
    public R RS() {
        return this.buS;
    }

    @NonNull
    public ExtensionCore RT() {
        String path;
        int Sd = this.buR.buQ.Sd();
        if (com.baidu.swan.apps.extcore.g.a.eV(Sd)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.ah(0L);
            if (Sd == 1) {
                path = com.baidu.swan.games.g.a.b.RW().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.d.b.RW().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore Sf = this.buR.Sf();
        ExtensionCore Sf2 = this.buS.Sf();
        if (Sf.extensionCoreVersionCode >= Sf2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Sf.toString());
                return Sf;
            }
            return Sf;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Sf2.toString());
        }
        return Sf2;
    }
}
