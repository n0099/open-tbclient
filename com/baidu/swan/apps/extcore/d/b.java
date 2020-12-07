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
/* loaded from: classes25.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.ap.e.b<Exception>> cZr;

    public b(@NonNull T t) {
        super(t);
        this.cZr = new CopyOnWriteArrayList<>();
    }

    public long awN() {
        return h.aNr().getLong(this.cYL.awI(), 0L);
    }

    public void cd(long j) {
        h.aNr().putLong(this.cYL.awI(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File awx() {
        return new File(super.awx(), "preset");
    }

    @NonNull
    public ExtensionCore awO() {
        ExtensionCore extensionCore = new ExtensionCore();
        long awN = awN();
        extensionCore.extensionCoreVersionCode = awN;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.ce(awN);
        extensionCore.extensionCorePath = cc(awN).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.cZn)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long oT = com.baidu.swan.apps.extcore.f.a.oT(aVar.versionName);
        if (d.dF(aVar.cZn, cc(oT).getPath())) {
            com.baidu.swan.apps.extcore.f.a.a(awx(), oT);
            cd(oT);
            com.baidu.swan.apps.extcore.f.a.z(this.cYL.awM(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.cZn);
        if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            return exc;
        }
        return exc;
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.iX(this.cYL.awM())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a2 = a.a(this.cYL);
        long awN = awN();
        long oT = com.baidu.swan.apps.extcore.f.a.oT(a2.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + awN + " newVer: " + oT);
        }
        return awN < oT;
    }

    @SuppressLint({"SwanNewThread"})
    public void o(@Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        c.bt("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!isNeedUpdate()) {
            c.bt("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            a(bVar, (Exception) null);
            return;
        }
        if (this.cZr.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    c.bt("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    a a2 = a.a(b.this.cYL);
                    com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                    aVar.versionName = a2.extensionCoreVersionName;
                    aVar.cZn = b.this.cYL.awK();
                    b.this.t(b.this.b(aVar));
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.cZr.add(bVar);
        }
    }

    public void awy() {
        if (isNeedUpdate()) {
            a a2 = a.a(this.cYL);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a2.extensionCoreVersionName;
            aVar.cZn = this.cYL.awK();
            t(b(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it = this.cZr.iterator();
        while (it.hasNext()) {
            a(it.next(), exc);
        }
        this.cZr.clear();
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
