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
    private P bTd;
    @NonNull
    private R bTe;

    @Nullable
    public abstract ExtensionCore YI();

    public b(@NonNull P p, @NonNull R r) {
        this.bTd = p;
        this.bTe = r;
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.bTd.b(aVar);
    }

    public void ZF() {
        this.bTd.ZF();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.bTe.b(t);
    }

    @NonNull
    public R ZG() {
        return this.bTe;
    }

    @NonNull
    public ExtensionCore ZH() {
        String path;
        int ZR = this.bTd.bTc.ZR();
        if (com.baidu.swan.apps.extcore.g.a.fa(ZR)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.aL(0L);
            if (ZR == 1) {
                path = com.baidu.swan.games.g.a.b.ZK().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.d.b.ZK().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore ZT = this.bTd.ZT();
        ExtensionCore ZT2 = this.bTe.ZT();
        if (ZT.extensionCoreVersionCode >= ZT2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + ZT.toString());
                return ZT;
            }
            return ZT;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + ZT2.toString());
        }
        return ZT2;
    }
}
