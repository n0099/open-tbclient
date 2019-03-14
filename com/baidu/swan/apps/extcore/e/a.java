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
    private CopyOnWriteArrayList<com.baidu.swan.apps.extcore.c.a> avP;

    public a(@NonNull T t) {
        super(t);
        this.avP = new CopyOnWriteArrayList<>();
    }

    public long By() {
        return f.KL().getLong(this.avt.Bu(), 0L);
    }

    public void u(long j) {
        f.KL().putLong(this.avt.Bu(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File Bl() {
        return new File(super.Bl(), "preset");
    }

    @NonNull
    public ExtensionCore Bz() {
        ExtensionCore extensionCore = new ExtensionCore();
        long By = By();
        extensionCore.avL = By;
        extensionCore.avM = com.baidu.swan.apps.extcore.g.a.v(By);
        extensionCore.avN = t(By).getPath();
        extensionCore.avK = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.avO)) {
            Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            return false;
        }
        long eH = com.baidu.swan.apps.extcore.g.a.eH(aVar.versionName);
        if (com.baidu.swan.c.b.bm(aVar.avO, t(eH).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(eH));
            com.baidu.swan.apps.extcore.g.a.a(Bl(), arrayList);
            u(eH);
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
        if (!com.baidu.swan.apps.extcore.g.a.BC()) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        b eD = b.eD(this.avt.Bx());
        long By = By();
        long eH = com.baidu.swan.apps.extcore.g.a.eH(eD.avM);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + By + " newVer: " + eH);
        }
        return By < eH;
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
        if (this.avP.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    }
                    b eD = b.eD(a.this.avt.Bx());
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = eD.avM;
                    aVar2.avO = a.this.avt.Bw();
                    a.this.b(aVar2);
                    a.this.BA();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.avP.add(aVar);
        }
    }

    public void Bm() {
        if (isNeedUpdate()) {
            b eD = b.eD(this.avt.Bx());
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = eD.avM;
            aVar.avO = this.avt.Bw();
            b(aVar);
            BA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BA() {
        Iterator<com.baidu.swan.apps.extcore.c.a> it = this.avP.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.avP.clear();
    }

    private void c(@Nullable final com.baidu.swan.apps.extcore.c.a aVar) {
        if (aVar != null) {
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.e.a.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.uL();
                }
            });
        }
    }
}
