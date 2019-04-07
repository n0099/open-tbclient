package com.baidu.swan.apps.extcore.e;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.b.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public abstract class a<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.extcore.c.a> avS;

    public a(@NonNull T t) {
        super(t);
        this.avS = new CopyOnWriteArrayList<>();
    }

    public long Bw() {
        return f.KJ().getLong(this.avw.Bs(), 0L);
    }

    public void u(long j) {
        f.KJ().putLong(this.avw.Bs(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File Bj() {
        return new File(super.Bj(), "preset");
    }

    @NonNull
    public ExtensionCore Bx() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Bw = Bw();
        extensionCore.avO = Bw;
        extensionCore.avP = com.baidu.swan.apps.extcore.g.a.v(Bw);
        extensionCore.avQ = t(Bw).getPath();
        extensionCore.avN = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.avR)) {
            Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            return false;
        }
        long eI = com.baidu.swan.apps.extcore.g.a.eI(aVar.versionName);
        if (com.baidu.swan.c.b.bm(aVar.avR, t(eI).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(eI));
            com.baidu.swan.apps.extcore.g.a.a(Bj(), arrayList);
            u(eI);
            com.baidu.swan.apps.extcore.g.a.bb(false);
            return true;
        } else if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(new Exception()));
            return false;
        } else {
            return false;
        }
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.g.a.BA()) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        b eE = b.eE(this.avw.Bv());
        long Bw = Bw();
        long eI = com.baidu.swan.apps.extcore.g.a.eI(eE.avP);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + Bw + " newVer: " + eI);
        }
        return Bw < eI;
    }

    public void b(@Nullable com.baidu.swan.apps.extcore.c.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "tryUpdateAsync: start");
        }
        if (!isNeedUpdate()) {
            Log.d("ExtCore-PresetControl", "tryUpdateAsync: finish with isNeedUpdate " + isNeedUpdate());
            c(aVar);
            return;
        }
        if (this.avS.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    }
                    b eE = b.eE(a.this.avw.Bv());
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = eE.avP;
                    aVar2.avR = a.this.avw.Bu();
                    a.this.b(aVar2);
                    a.this.By();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.avS.add(aVar);
        }
    }

    public void Bk() {
        if (isNeedUpdate()) {
            b eE = b.eE(this.avw.Bv());
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = eE.avP;
            aVar.avR = this.avw.Bu();
            b(aVar);
            By();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void By() {
        Iterator<com.baidu.swan.apps.extcore.c.a> it = this.avS.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.avS.clear();
    }

    private void c(@Nullable final com.baidu.swan.apps.extcore.c.a aVar) {
        if (aVar != null) {
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.uK();
                }
            });
        }
    }
}
