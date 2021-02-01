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
/* loaded from: classes9.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.ao.e.b<Exception>> dbJ;

    public b(@NonNull T t) {
        super(t);
        this.dbJ = new CopyOnWriteArrayList<>();
    }

    public long auK() {
        return h.aMh().getLong(this.dbd.auF(), 0L);
    }

    public void ck(long j) {
        h.aMh().putLong(this.dbd.auF(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File auu() {
        return new File(super.auu(), "preset");
    }

    @NonNull
    public ExtensionCore auL() {
        ExtensionCore extensionCore = new ExtensionCore();
        long auK = auK();
        extensionCore.extensionCoreVersionCode = auK;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cl(auK);
        extensionCore.extensionCorePath = cj(auK).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.dbF)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long nR = com.baidu.swan.apps.extcore.f.a.nR(aVar.versionName);
        if (d.dx(aVar.dbF, cj(nR).getPath())) {
            com.baidu.swan.apps.extcore.f.a.a(auu(), nR);
            ck(nR);
            com.baidu.swan.apps.extcore.f.a.z(this.dbd.auJ(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.dbF);
        if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            return exc;
        }
        return exc;
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.hp(this.dbd.auJ())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a2 = a.a(this.dbd);
        long auK = auK();
        long nR = com.baidu.swan.apps.extcore.f.a.nR(a2.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + auK + " newVer: " + nR);
        }
        return auK < nR;
    }

    @SuppressLint({"SwanNewThread"})
    public void o(@Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        c.bl("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!isNeedUpdate()) {
            c.bl("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            a(bVar, (Exception) null);
            return;
        }
        if (this.dbJ.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    c.bl("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    a a2 = a.a(b.this.dbd);
                    com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                    aVar.versionName = a2.extensionCoreVersionName;
                    aVar.dbF = b.this.dbd.auH();
                    b.this.u(b.this.b(aVar));
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.dbJ.add(bVar);
        }
    }

    public void auv() {
        if (isNeedUpdate()) {
            a a2 = a.a(this.dbd);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a2.extensionCoreVersionName;
            aVar.dbF = this.dbd.auH();
            u(b(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        Iterator<com.baidu.swan.apps.ao.e.b<Exception>> it = this.dbJ.iterator();
        while (it.hasNext()) {
            a(it.next(), exc);
        }
        this.dbJ.clear();
    }

    private void a(@Nullable final com.baidu.swan.apps.ao.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.L(exc);
                }
            });
        }
    }
}
