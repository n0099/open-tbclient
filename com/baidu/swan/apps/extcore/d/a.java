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
    private CopyOnWriteArrayList<com.baidu.swan.apps.extcore.c.a> aQI;

    public a(@NonNull T t) {
        super(t);
        this.aQI = new CopyOnWriteArrayList<>();
    }

    public long If() {
        return f.SR().getLong(this.aQi.Ib(), 0L);
    }

    public void W(long j) {
        f.SR().putLong(this.aQi.Ib(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File HT() {
        return new File(super.HT(), "preset");
    }

    @NonNull
    public ExtensionCore Ig() {
        ExtensionCore extensionCore = new ExtensionCore();
        long If = If();
        extensionCore.aQE = If;
        extensionCore.aQF = com.baidu.swan.apps.extcore.f.a.X(If);
        extensionCore.aQG = V(If).getPath();
        extensionCore.aQD = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.aQH)) {
            Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            return false;
        }
        long fk = com.baidu.swan.apps.extcore.f.a.fk(aVar.versionName);
        if (com.baidu.swan.c.a.bB(aVar.aQH, V(fk).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(fk));
            com.baidu.swan.apps.extcore.f.a.a(HT(), arrayList);
            W(fk);
            com.baidu.swan.apps.extcore.f.a.bA(false);
            return true;
        } else if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(new Exception()));
            return false;
        } else {
            return false;
        }
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.Ij()) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        b fg = b.fg(this.aQi.Ie());
        long If = If();
        long fk = com.baidu.swan.apps.extcore.f.a.fk(fg.aQF);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + If + " newVer: " + fk);
        }
        return If < fk;
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
        if (this.aQI.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    }
                    b fg = b.fg(a.this.aQi.Ie());
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = fg.aQF;
                    aVar2.aQH = a.this.aQi.Id();
                    a.this.b(aVar2);
                    a.this.Ih();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.aQI.add(aVar);
        }
    }

    public void HU() {
        if (isNeedUpdate()) {
            b fg = b.fg(this.aQi.Ie());
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = fg.aQF;
            aVar.aQH = this.aQi.Id();
            b(aVar);
            Ih();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih() {
        Iterator<com.baidu.swan.apps.extcore.c.a> it = this.aQI.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.aQI.clear();
    }

    private void c(@Nullable final com.baidu.swan.apps.extcore.c.a aVar) {
        if (aVar != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.AT();
                }
            });
        }
    }
}
