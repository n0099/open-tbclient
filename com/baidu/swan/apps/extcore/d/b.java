package com.baidu.swan.apps.extcore.d;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.ap.e.b<Exception>> mCallbacks;

    public b(@NonNull T t) {
        super(t);
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public long aun() {
        return h.aKS().getLong(this.cTC.aui(), 0L);
    }

    public void bE(long j) {
        h.aKS().putLong(this.cTC.aui(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File atX() {
        return new File(super.atX(), "preset");
    }

    @NonNull
    public ExtensionCore auo() {
        ExtensionCore extensionCore = new ExtensionCore();
        long aun = aun();
        extensionCore.extensionCoreVersionCode = aun;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.bF(aun);
        extensionCore.extensionCorePath = bD(aun).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.cUe)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long os = com.baidu.swan.apps.extcore.f.a.os(aVar.versionName);
        if (d.dz(aVar.cUe, bD(os).getPath())) {
            com.baidu.swan.apps.extcore.f.a.a(atX(), os);
            bE(os);
            com.baidu.swan.apps.extcore.f.a.z(this.cTC.aum(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.cUe);
        if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            return exc;
        }
        return exc;
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.iD(this.cTC.aum())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a2 = a.a(this.cTC);
        long aun = aun();
        long os = com.baidu.swan.apps.extcore.f.a.os(a2.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + aun + " newVer: " + os);
        }
        return aun < os;
    }

    @SuppressLint({"SwanNewThread"})
    public void o(@Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        c.bn("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!isNeedUpdate()) {
            c.bn("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            a(bVar, (Exception) null);
            return;
        }
        if (this.mCallbacks.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    c.bn("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    a a2 = a.a(b.this.cTC);
                    com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                    aVar.versionName = a2.extensionCoreVersionName;
                    aVar.cUe = b.this.cTC.auk();
                    b.this.t(b.this.b(aVar));
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.mCallbacks.add(bVar);
        }
    }

    public void atY() {
        if (isNeedUpdate()) {
            a a2 = a.a(this.cTC);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a2.extensionCoreVersionName;
            aVar.cUe = this.cTC.auk();
            t(b(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            a(it.next(), exc);
        }
        this.mCallbacks.clear();
    }

    private void a(@Nullable final com.baidu.swan.apps.ap.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.M(exc);
                }
            });
        }
    }
}
