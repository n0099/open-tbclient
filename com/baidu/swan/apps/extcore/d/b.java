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
    private CopyOnWriteArrayList<com.baidu.swan.apps.ao.e.b<Exception>> cZx;

    public b(@NonNull T t) {
        super(t);
        this.cZx = new CopyOnWriteArrayList<>();
    }

    public long aum() {
        return h.aLO().getLong(this.cYR.auh(), 0L);
    }

    public void ce(long j) {
        h.aLO().putLong(this.cYR.auh(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File atW() {
        return new File(super.atW(), "preset");
    }

    @NonNull
    public ExtensionCore aun() {
        ExtensionCore extensionCore = new ExtensionCore();
        long aum = aum();
        extensionCore.extensionCoreVersionCode = aum;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cf(aum);
        extensionCore.extensionCorePath = cd(aum).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.cZt)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long nz = com.baidu.swan.apps.extcore.f.a.nz(aVar.versionName);
        if (d.dD(aVar.cZt, cd(nz).getPath())) {
            com.baidu.swan.apps.extcore.f.a.a(atW(), nz);
            ce(nz);
            com.baidu.swan.apps.extcore.f.a.z(this.cYR.aul(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.cZt);
        if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            return exc;
        }
        return exc;
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.hm(this.cYR.aul())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a2 = a.a(this.cYR);
        long aum = aum();
        long nz = com.baidu.swan.apps.extcore.f.a.nz(a2.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + aum + " newVer: " + nz);
        }
        return aum < nz;
    }

    @SuppressLint({"SwanNewThread"})
    public void o(@Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        c.br("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!isNeedUpdate()) {
            c.br("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            a(bVar, (Exception) null);
            return;
        }
        if (this.cZx.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    c.br("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    a a2 = a.a(b.this.cYR);
                    com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                    aVar.versionName = a2.extensionCoreVersionName;
                    aVar.cZt = b.this.cYR.auj();
                    b.this.u(b.this.b(aVar));
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.cZx.add(bVar);
        }
    }

    public void atX() {
        if (isNeedUpdate()) {
            a a2 = a.a(this.cYR);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a2.extensionCoreVersionName;
            aVar.cZt = this.cYR.auj();
            u(b(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        Iterator<com.baidu.swan.apps.ao.e.b<Exception>> it = this.cZx.iterator();
        while (it.hasNext()) {
            a(it.next(), exc);
        }
        this.cZx.clear();
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
