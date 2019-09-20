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
    private CopyOnWriteArrayList<com.baidu.swan.apps.extcore.c.a> axt;

    public a(@NonNull T t) {
        super(t);
        this.axt = new CopyOnWriteArrayList<>();
    }

    public long Dl() {
        return f.Ob().getLong(this.awT.Dh(), 0L);
    }

    public void D(long j) {
        f.Ob().putLong(this.awT.Dh(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File CZ() {
        return new File(super.CZ(), "preset");
    }

    @NonNull
    public ExtensionCore Dm() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Dl = Dl();
        extensionCore.axp = Dl;
        extensionCore.axq = com.baidu.swan.apps.extcore.f.a.E(Dl);
        extensionCore.axr = C(Dl).getPath();
        extensionCore.axo = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.axs)) {
            Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            return false;
        }
        long eD = com.baidu.swan.apps.extcore.f.a.eD(aVar.versionName);
        if (com.baidu.swan.c.a.bu(aVar.axs, C(eD).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(eD));
            com.baidu.swan.apps.extcore.f.a.a(CZ(), arrayList);
            D(eD);
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
        if (!com.baidu.swan.apps.extcore.f.a.Dp()) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        b ez = b.ez(this.awT.Dk());
        long Dl = Dl();
        long eD = com.baidu.swan.apps.extcore.f.a.eD(ez.axq);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + Dl + " newVer: " + eD);
        }
        return Dl < eD;
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
        if (this.axt.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    }
                    b ez = b.ez(a.this.awT.Dk());
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = ez.axq;
                    aVar2.axs = a.this.awT.Dj();
                    a.this.b(aVar2);
                    a.this.Dn();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.axt.add(aVar);
        }
    }

    public void Da() {
        if (isNeedUpdate()) {
            b ez = b.ez(this.awT.Dk());
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = ez.axq;
            aVar.axs = this.awT.Dj();
            b(aVar);
            Dn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dn() {
        Iterator<com.baidu.swan.apps.extcore.c.a> it = this.axt.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.axt.clear();
    }

    private void c(@Nullable final com.baidu.swan.apps.extcore.c.a aVar) {
        if (aVar != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.vZ();
                }
            });
        }
    }
}
