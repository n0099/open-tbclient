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
/* loaded from: classes10.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.extcore.c.a> mCallbacks;

    public b(@NonNull T t) {
        super(t);
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public long PL() {
        return h.adb().getLong(this.bqs.PG(), 0L);
    }

    public void ac(long j) {
        h.adb().putLong(this.bqs.PG(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File Px() {
        return new File(super.Px(), "preset");
    }

    @NonNull
    public ExtensionCore PM() {
        ExtensionCore extensionCore = new ExtensionCore();
        long PL = PL();
        extensionCore.extensionCoreVersionCode = PL;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.ad(PL);
        extensionCore.extensionCorePath = ab(PL).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.bqW)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
                return false;
            }
            return false;
        }
        long hB = com.baidu.swan.apps.extcore.g.a.hB(aVar.versionName);
        if (c.cb(aVar.bqW, ab(hB).getPath())) {
            com.baidu.swan.apps.extcore.g.a.a(Px(), hB);
            ac(hB);
            com.baidu.swan.apps.extcore.g.a.q(this.bqs.PK(), false);
            return true;
        } else if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(new Exception()));
            return false;
        } else {
            return false;
        }
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.g.a.eD(this.bqs.PK())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a = a.a(this.bqs);
        long PL = PL();
        long hB = com.baidu.swan.apps.extcore.g.a.hB(a.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + PL + " newVer: " + hB);
        }
        return PL < hB;
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
        if (this.mCallbacks.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.DEBUG) {
                        Log.d("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    }
                    a a = a.a(b.this.bqs);
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = a.extensionCoreVersionName;
                    aVar2.bqW = b.this.bqs.PI();
                    b.this.b(aVar2);
                    b.this.NP();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.mCallbacks.add(aVar);
        }
    }

    public void Py() {
        if (isNeedUpdate()) {
            a a = a.a(this.bqs);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a.extensionCoreVersionName;
            aVar.bqW = this.bqs.PI();
            b(aVar);
            NP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NP() {
        Iterator<com.baidu.swan.apps.extcore.c.a> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.mCallbacks.clear();
    }

    private void c(@Nullable final com.baidu.swan.apps.extcore.c.a aVar) {
        if (aVar != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.Ps();
                }
            });
        }
    }
}
