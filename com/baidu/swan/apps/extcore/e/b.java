package com.baidu.swan.apps.extcore.e;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.d.c;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.extcore.c.a> bmu;

    public b(@NonNull T t) {
        super(t);
        this.bmu = new CopyOnWriteArrayList<>();
    }

    public long Pp() {
        return h.acE().getLong(this.bpE.Pk(), 0L);
    }

    public void Z(long j) {
        h.acE().putLong(this.bpE.Pk(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File Pb() {
        return new File(super.Pb(), "preset");
    }

    @NonNull
    public ExtensionCore Pq() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Pp = Pp();
        extensionCore.extensionCoreVersionCode = Pp;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.aa(Pp);
        extensionCore.extensionCorePath = Y(Pp).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.bqi)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
                return false;
            }
            return false;
        }
        long hy = com.baidu.swan.apps.extcore.g.a.hy(aVar.versionName);
        if (c.ca(aVar.bqi, Y(hy).getPath())) {
            com.baidu.swan.apps.extcore.g.a.a(Pb(), hy);
            Z(hy);
            com.baidu.swan.apps.extcore.g.a.q(this.bpE.Po(), false);
            return true;
        } else if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(new Exception()));
            return false;
        } else {
            return false;
        }
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.g.a.eC(this.bpE.Po())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a = a.a(this.bpE);
        long Pp = Pp();
        long hy = com.baidu.swan.apps.extcore.g.a.hy(a.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + Pp + " newVer: " + hy);
        }
        return Pp < hy;
    }

    @SuppressLint({"SwanNewThread"})
    public void b(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "tryUpdateAsync: start");
        }
        if (!isNeedUpdate()) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "tryUpdateAsync: finish with isNeedUpdate " + isNeedUpdate());
            }
            c(aVar);
            return;
        }
        if (this.bmu.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.DEBUG) {
                        Log.d("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    }
                    a a = a.a(b.this.bpE);
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = a.extensionCoreVersionName;
                    aVar2.bqi = b.this.bpE.Pm();
                    b.this.b(aVar2);
                    b.this.Nt();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.bmu.add(aVar);
        }
    }

    public void Pc() {
        if (isNeedUpdate()) {
            a a = a.a(this.bpE);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a.extensionCoreVersionName;
            aVar.bqi = this.bpE.Pm();
            b(aVar);
            Nt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nt() {
        Iterator<com.baidu.swan.apps.extcore.c.a> it = this.bmu.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.bmu.clear();
    }

    private void c(@Nullable final com.baidu.swan.apps.extcore.c.a aVar) {
        if (aVar != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.OW();
                }
            });
        }
    }
}
