package com.baidu.swan.apps.extcore.d;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.ao.e.b<Exception>> ddl;

    public b(@NonNull T t) {
        super(t);
        this.ddl = new CopyOnWriteArrayList<>();
    }

    public long auN() {
        return h.aMk().getLong(this.dcF.auI(), 0L);
    }

    public void ck(long j) {
        h.aMk().putLong(this.dcF.auI(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File aux() {
        return new File(super.aux(), "preset");
    }

    @NonNull
    public ExtensionCore auO() {
        ExtensionCore extensionCore = new ExtensionCore();
        long auN = auN();
        extensionCore.extensionCoreVersionCode = auN;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cl(auN);
        extensionCore.extensionCorePath = cj(auN).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.ddh)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long nY = com.baidu.swan.apps.extcore.f.a.nY(aVar.versionName);
        if (d.dx(aVar.ddh, cj(nY).getPath())) {
            com.baidu.swan.apps.extcore.f.a.a(aux(), nY);
            ck(nY);
            com.baidu.swan.apps.extcore.f.a.z(this.dcF.auM(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.ddh);
        if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            return exc;
        }
        return exc;
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.hq(this.dcF.auM())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a2 = a.a(this.dcF);
        long auN = auN();
        long nY = com.baidu.swan.apps.extcore.f.a.nY(a2.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + auN + " newVer: " + nY);
        }
        return auN < nY;
    }

    @SuppressLint({"SwanNewThread"})
    public void o(@Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        c.bl("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!isNeedUpdate()) {
            c.bl("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            a(bVar, (Exception) null);
            return;
        }
        if (this.ddl.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    c.bl("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    a a2 = a.a(b.this.dcF);
                    com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                    aVar.versionName = a2.extensionCoreVersionName;
                    aVar.ddh = b.this.dcF.auK();
                    b.this.u(b.this.b(aVar));
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.ddl.add(bVar);
        }
    }

    public void auy() {
        if (isNeedUpdate()) {
            a a2 = a.a(this.dcF);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a2.extensionCoreVersionName;
            aVar.ddh = this.dcF.auK();
            u(b(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        Iterator<com.baidu.swan.apps.ao.e.b<Exception>> it = this.ddl.iterator();
        while (it.hasNext()) {
            a(it.next(), exc);
        }
        this.ddl.clear();
    }

    private void a(@Nullable final com.baidu.swan.apps.ao.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.N(exc);
                }
            });
        }
    }
}
