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

    public long arM() {
        return h.aIs().getLong(this.cNJ.arH(), 0L);
    }

    public void bi(long j) {
        h.aIs().putLong(this.cNJ.arH(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File arw() {
        return new File(super.arw(), "preset");
    }

    @NonNull
    public ExtensionCore arN() {
        ExtensionCore extensionCore = new ExtensionCore();
        long arM = arM();
        extensionCore.extensionCoreVersionCode = arM;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.bj(arM);
        extensionCore.extensionCorePath = bh(arM).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.cOl)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long oc = com.baidu.swan.apps.extcore.f.a.oc(aVar.versionName);
        if (d.dz(aVar.cOl, bh(oc).getPath())) {
            com.baidu.swan.apps.extcore.f.a.a(arw(), oc);
            bi(oc);
            com.baidu.swan.apps.extcore.f.a.z(this.cNJ.arL(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.cOl);
        if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            return exc;
        }
        return exc;
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.it(this.cNJ.arL())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a2 = a.a(this.cNJ);
        long arM = arM();
        long oc = com.baidu.swan.apps.extcore.f.a.oc(a2.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + arM + " newVer: " + oc);
        }
        return arM < oc;
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
                    a a2 = a.a(b.this.cNJ);
                    com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                    aVar.versionName = a2.extensionCoreVersionName;
                    aVar.cOl = b.this.cNJ.arJ();
                    b.this.t(b.this.b(aVar));
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.mCallbacks.add(bVar);
        }
    }

    public void arx() {
        if (isNeedUpdate()) {
            a a2 = a.a(this.cNJ);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a2.extensionCoreVersionName;
            aVar.cOl = this.cNJ.arJ();
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
