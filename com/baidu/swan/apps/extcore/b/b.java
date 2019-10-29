package com.baidu.swan.apps.extcore.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.d.a;
import com.baidu.swan.apps.extcore.e.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
/* loaded from: classes2.dex */
public abstract class b<P extends com.baidu.swan.apps.extcore.d.a, R extends com.baidu.swan.apps.extcore.e.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @NonNull
    private P aQj;
    @NonNull
    private R aQk;

    public b(@NonNull P p, @NonNull R r) {
        this.aQj = p;
        this.aQk = r;
    }

    public void I(int i, int i2) {
        if (DEBUG) {
            Log.d("ExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
            com.baidu.swan.apps.extcore.f.a.bA(true);
        }
    }

    public void a(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        this.aQj.b(aVar);
    }

    public void HU() {
        this.aQj.HU();
    }

    public <T extends com.baidu.swan.apps.extcore.model.a> boolean a(T t) {
        return t != null && this.aQk.b(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public ExtensionCore HV() {
        if (DEBUG && com.baidu.swan.apps.extcore.f.a.Ik()) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.aQE = 0L;
            extensionCore.aQF = com.baidu.swan.apps.extcore.f.a.X(0L);
            extensionCore.aQG = com.baidu.swan.apps.extcore.debug.b.HY().getPath();
            extensionCore.aQD = 2;
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            return extensionCore;
        }
        ExtensionCore Ig = this.aQj.Ig();
        ExtensionCore Ig2 = this.aQk.Ig();
        if (Ig.aQE >= Ig2.aQE) {
            if (DEBUG) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + Ig.toString());
                return Ig;
            }
            return Ig;
        }
        if (DEBUG) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + Ig2.toString());
        }
        return Ig2;
    }
}
