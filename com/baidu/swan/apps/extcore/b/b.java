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
    private P bSX;
    @NonNull
    private R bSY;

    @Nullable
    public abstract ExtensionCore YJ();

    public b(@NonNull P p, @NonNull R r) {
        this.bSX = p;
        this.bSY = r;
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.bSX.b(aVar);
    }

    public void ZG() {
        this.bSX.ZG();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.bSY.b(t);
    }

    @NonNull
    public R ZH() {
        return this.bSY;
    }

    @NonNull
    public ExtensionCore ZI() {
        String path;
        int ZS = this.bSX.bSW.ZS();
        if (com.baidu.swan.apps.extcore.g.a.fa(ZS)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.aL(0L);
            if (ZS == 1) {
                path = com.baidu.swan.games.g.a.b.ZL().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.d.b.ZL().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore ZU = this.bSX.ZU();
        ExtensionCore ZU2 = this.bSY.ZU();
        if (ZU.extensionCoreVersionCode >= ZU2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + ZU.toString());
                return ZU;
            }
            return ZU;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + ZU2.toString());
        }
        return ZU2;
    }
}
