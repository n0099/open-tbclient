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
    private CopyOnWriteArrayList<com.baidu.swan.apps.extcore.c.a> aQq;

    public a(@NonNull T t) {
        super(t);
        this.aQq = new CopyOnWriteArrayList<>();
    }

    public long Ig() {
        return f.ST().getLong(this.aPQ.Ic(), 0L);
    }

    public void V(long j) {
        f.ST().putLong(this.aPQ.Ic(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File HU() {
        return new File(super.HU(), "preset");
    }

    @NonNull
    public ExtensionCore Ih() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Ig = Ig();
        extensionCore.aQm = Ig;
        extensionCore.aQn = com.baidu.swan.apps.extcore.f.a.W(Ig);
        extensionCore.aQo = U(Ig).getPath();
        extensionCore.aQl = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.aQp)) {
            Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            return false;
        }
        long fk = com.baidu.swan.apps.extcore.f.a.fk(aVar.versionName);
        if (com.baidu.swan.c.a.bB(aVar.aQp, U(fk).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(fk));
            com.baidu.swan.apps.extcore.f.a.a(HU(), arrayList);
            V(fk);
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
        if (!com.baidu.swan.apps.extcore.f.a.Ik()) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        b fg = b.fg(this.aPQ.If());
        long Ig = Ig();
        long fk = com.baidu.swan.apps.extcore.f.a.fk(fg.aQn);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + Ig + " newVer: " + fk);
        }
        return Ig < fk;
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
        if (this.aQq.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    }
                    b fg = b.fg(a.this.aPQ.If());
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = fg.aQn;
                    aVar2.aQp = a.this.aPQ.Ie();
                    a.this.b(aVar2);
                    a.this.Ii();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.aQq.add(aVar);
        }
    }

    public void HV() {
        if (isNeedUpdate()) {
            b fg = b.fg(this.aPQ.If());
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = fg.aQn;
            aVar.aQp = this.aPQ.Ie();
            b(aVar);
            Ii();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii() {
        Iterator<com.baidu.swan.apps.extcore.c.a> it = this.aQq.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.aQq.clear();
    }

    private void c(@Nullable final com.baidu.swan.apps.extcore.c.a aVar) {
        if (aVar != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.AU();
                }
            });
        }
    }
}
