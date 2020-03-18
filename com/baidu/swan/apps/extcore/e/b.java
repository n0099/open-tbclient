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
/* loaded from: classes11.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.extcore.c.a> mCallbacks;

    public b(@NonNull T t) {
        super(t);
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public long Se() {
        return h.afu().getLong(this.buQ.RZ(), 0L);
    }

    public void ag(long j) {
        h.afu().putLong(this.buQ.RZ(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File RQ() {
        return new File(super.RQ(), "preset");
    }

    @NonNull
    public ExtensionCore Sf() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Se = Se();
        extensionCore.extensionCoreVersionCode = Se;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.ah(Se);
        extensionCore.extensionCorePath = af(Se).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.bvu)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
                return false;
            }
            return false;
        }
        long hP = com.baidu.swan.apps.extcore.g.a.hP(aVar.versionName);
        if (c.cj(aVar.bvu, af(hP).getPath())) {
            com.baidu.swan.apps.extcore.g.a.a(RQ(), hP);
            ag(hP);
            com.baidu.swan.apps.extcore.g.a.q(this.buQ.Sd(), false);
            return true;
        } else if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(new Exception()));
            return false;
        } else {
            return false;
        }
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.g.a.eT(this.buQ.Sd())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a = a.a(this.buQ);
        long Se = Se();
        long hP = com.baidu.swan.apps.extcore.g.a.hP(a.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + Se + " newVer: " + hP);
        }
        return Se < hP;
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
                    a a = a.a(b.this.buQ);
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = a.extensionCoreVersionName;
                    aVar2.bvu = b.this.buQ.Sb();
                    b.this.b(aVar2);
                    b.this.Qi();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.mCallbacks.add(aVar);
        }
    }

    public void RR() {
        if (isNeedUpdate()) {
            a a = a.a(this.buQ);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a.extensionCoreVersionName;
            aVar.bvu = this.buQ.Sb();
            b(aVar);
            Qi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi() {
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
                    aVar.RL();
                }
            });
        }
    }
}
