package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.extcore.d.b;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes11.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.b, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P ccW;
    @NonNull
    private R ccX;

    @Nullable
    public abstract ExtensionCore abH();

    public b(@NonNull P p, @NonNull R r) {
        this.ccW = p;
        this.ccX = r;
    }

    public void f(@Nullable com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        this.ccW.g(bVar);
    }

    public void acF() {
        this.ccW.acF();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> Exception a(T t) {
        return t == null ? new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo") : this.ccX.b(t);
    }

    @NonNull
    public R acG() {
        return this.ccX;
    }

    @NonNull
    public ExtensionCore acH() {
        String path;
        int acR = this.ccW.ccV.acR();
        if (com.baidu.swan.apps.extcore.f.a.fl(acR)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aS(0L);
            if (acR == 1) {
                path = com.baidu.swan.games.h.a.b.acK().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.c.b.acK().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore acT = this.ccW.acT();
        ExtensionCore acT2 = this.ccX.acT();
        if (acT.extensionCoreVersionCode >= acT2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + acT.toString());
                return acT;
            }
            return acT;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + acT2.toString());
        }
        return acT2;
    }
}
