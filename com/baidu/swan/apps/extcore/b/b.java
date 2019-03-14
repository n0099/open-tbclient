package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.f.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes2.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.e.a, R extends com.baidu.swan.apps.extcore.f.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P avu;
    @NonNull
    private R avv;

    public b(@NonNull P p, @NonNull R r) {
        this.avu = p;
        this.avv = r;
    }

    public void B(int i, int i2) {
        if (DEBUG) {
            Log.d("ExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.g.a.bb(true);
        }
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.avu.b(aVar);
    }

    public void Bm() {
        this.avu.Bm();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.avv.b(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public ExtensionCore Bn() {
        if (DEBUG && com.baidu.swan.apps.extcore.g.a.BD()) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.avL = 0L;
            extensionCore.avM = com.baidu.swan.apps.extcore.g.a.v(0L);
            extensionCore.avN = com.baidu.swan.apps.extcore.d.b.Bq().getPath();
            extensionCore.avK = 2;
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            return extensionCore;
        }
        ExtensionCore Bz = this.avu.Bz();
        ExtensionCore Bz2 = this.avv.Bz();
        if (Bz.avL >= Bz2.avL) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Bz.toString());
                return Bz;
            }
            return Bz;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Bz2.toString());
        }
        return Bz2;
    }
}
