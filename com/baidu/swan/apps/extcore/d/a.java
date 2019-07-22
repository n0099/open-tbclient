package com.baidu.swan.apps.extcore.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.ac;
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
    private CopyOnWriteArrayList<com.baidu.swan.apps.extcore.c.a> awV;

    public a(@NonNull T t) {
        super(t);
        this.awV = new CopyOnWriteArrayList<>();
    }

    public long Dh() {
        return f.NX().getLong(this.awv.Dd(), 0L);
    }

    public void D(long j) {
        f.NX().putLong(this.awv.Dd(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File CV() {
        return new File(super.CV(), "preset");
    }

    @NonNull
    public ExtensionCore Di() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Dh = Dh();
        extensionCore.awR = Dh;
        extensionCore.awS = com.baidu.swan.apps.extcore.f.a.E(Dh);
        extensionCore.awT = C(Dh).getPath();
        extensionCore.awQ = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.awU)) {
            Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            return false;
        }
        long eB = com.baidu.swan.apps.extcore.f.a.eB(aVar.versionName);
        if (com.baidu.swan.c.a.bu(aVar.awU, C(eB).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(eB));
            com.baidu.swan.apps.extcore.f.a.a(CV(), arrayList);
            D(eB);
            com.baidu.swan.apps.extcore.f.a.bi(false);
            return true;
        } else if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(new Exception()));
            return false;
        } else {
            return false;
        }
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.Dl()) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        b ex = b.ex(this.awv.Dg());
        long Dh = Dh();
        long eB = com.baidu.swan.apps.extcore.f.a.eB(ex.awS);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + Dh + " newVer: " + eB);
        }
        return Dh < eB;
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
        if (this.awV.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    }
                    b ex = b.ex(a.this.awv.Dg());
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = ex.awS;
                    aVar2.awU = a.this.awv.Df();
                    a.this.b(aVar2);
                    a.this.Dj();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.awV.add(aVar);
        }
    }

    public void CW() {
        if (isNeedUpdate()) {
            b ex = b.ex(this.awv.Dg());
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = ex.awS;
            aVar.awU = this.awv.Df();
            b(aVar);
            Dj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dj() {
        Iterator<com.baidu.swan.apps.extcore.c.a> it = this.awV.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.awV.clear();
    }

    private void c(@Nullable final com.baidu.swan.apps.extcore.c.a aVar) {
        if (aVar != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.vV();
                }
            });
        }
    }
}
