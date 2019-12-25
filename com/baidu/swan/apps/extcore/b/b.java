package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.extcore.e.b;
import com.baidu.swan.apps.extcore.f.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes9.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.e.b, R extends com.baidu.swan.apps.extcore.f.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P bpF;
    @NonNull
    private R bpG;

    @Nullable
    public abstract ExtensionCore Of();

    public b(@NonNull P p, @NonNull R r) {
        this.bpF = p;
        this.bpG = r;
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.bpF.b(aVar);
    }

    public void Pc() {
        this.bpF.Pc();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.bpG.b(t);
    }

    @NonNull
    public R Pd() {
        return this.bpG;
    }

    @NonNull
    public ExtensionCore Pe() {
        String path;
        int Po = this.bpF.bpE.Po();
        if (com.baidu.swan.apps.extcore.g.a.eE(Po)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.aa(0L);
            if (Po == 1) {
                path = com.baidu.swan.games.g.a.b.Ph().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.d.b.Ph().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore Pq = this.bpF.Pq();
        ExtensionCore Pq2 = this.bpG.Pq();
        if (Pq.extensionCoreVersionCode >= Pq2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Pq.toString());
                return Pq;
            }
            return Pq;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Pq2.toString());
        }
        return Pq2;
    }
}
