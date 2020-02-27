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

    public long RZ() {
        return h.afp().getLong(this.buC.RU(), 0L);
    }

    public void ag(long j) {
        h.afp().putLong(this.buC.RU(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File RL() {
        return new File(super.RL(), "preset");
    }

    @NonNull
    public ExtensionCore Sa() {
        ExtensionCore extensionCore = new ExtensionCore();
        long RZ = RZ();
        extensionCore.extensionCoreVersionCode = RZ;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.g.a.ah(RZ);
        extensionCore.extensionCorePath = af(RZ).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.bvg)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
                return false;
            }
            return false;
        }
        long hQ = com.baidu.swan.apps.extcore.g.a.hQ(aVar.versionName);
        if (c.ck(aVar.bvg, af(hQ).getPath())) {
            com.baidu.swan.apps.extcore.g.a.a(RL(), hQ);
            ag(hQ);
            com.baidu.swan.apps.extcore.g.a.q(this.buC.RY(), false);
            return true;
        } else if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(new Exception()));
            return false;
        } else {
            return false;
        }
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.g.a.eT(this.buC.RY())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a = a.a(this.buC);
        long RZ = RZ();
        long hQ = com.baidu.swan.apps.extcore.g.a.hQ(a.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + RZ + " newVer: " + hQ);
        }
        return RZ < hQ;
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
                    a a = a.a(b.this.buC);
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = a.extensionCoreVersionName;
                    aVar2.bvg = b.this.buC.RW();
                    b.this.b(aVar2);
                    b.this.Qd();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.mCallbacks.add(aVar);
        }
    }

    public void RM() {
        if (isNeedUpdate()) {
            a a = a.a(this.buC);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a.extensionCoreVersionName;
            aVar.bvg = this.buC.RW();
            b(aVar);
            Qd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qd() {
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
                    aVar.RG();
                }
            });
        }
    }
}
