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
    private P buD;
    @NonNull
    private R buE;

    @Nullable
    public abstract ExtensionCore QP();

    public b(@NonNull P p, @NonNull R r) {
        this.buD = p;
        this.buE = r;
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.buD.b(aVar);
    }

    public void RM() {
        this.buD.RM();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.buE.b(t);
    }

    @NonNull
    public R RN() {
        return this.buE;
    }

    @NonNull
    public ExtensionCore RO() {
        String path;
        int RY = this.buD.buC.RY();
        if (com.baidu.swan.apps.extcore.g.a.eV(RY)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.ah(0L);
            if (RY == 1) {
                path = com.baidu.swan.games.g.a.b.RR().getPath();
            } else {
                path = com.baidu.swan.apps.extcore.d.b.RR().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore Sa = this.buD.Sa();
        ExtensionCore Sa2 = this.buE.Sa();
        if (Sa.extensionCoreVersionCode >= Sa2.extensionCoreVersionCode) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Sa.toString());
                return Sa;
            }
            return Sa;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Sa2.toString());
        }
        return Sa2;
    }
}
