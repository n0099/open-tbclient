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
    private CopyOnWriteArrayList<com.baidu.swan.apps.extcore.c.a> awq;

    public a(@NonNull T t) {
        super(t);
        this.awq = new CopyOnWriteArrayList<>();
    }

    public long Cy() {
        return f.Ni().getLong(this.avQ.Cu(), 0L);
    }

    public void D(long j) {
        f.Ni().putLong(this.avQ.Cu(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File Cm() {
        return new File(super.Cm(), "preset");
    }

    @NonNull
    public ExtensionCore Cz() {
        ExtensionCore extensionCore = new ExtensionCore();
        long Cy = Cy();
        extensionCore.awm = Cy;
        extensionCore.awn = com.baidu.swan.apps.extcore.f.a.E(Cy);
        extensionCore.awo = C(Cy).getPath();
        extensionCore.awl = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Z */
    public boolean b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.awp)) {
            Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            return false;
        }
        long ex = com.baidu.swan.apps.extcore.f.a.ex(aVar.versionName);
        if (com.baidu.swan.c.a.bu(aVar.awp, C(ex).getPath())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(ex));
            com.baidu.swan.apps.extcore.f.a.a(Cm(), arrayList);
            D(ex);
            com.baidu.swan.apps.extcore.f.a.bf(false);
            return true;
        } else if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(new Exception()));
            return false;
        } else {
            return false;
        }
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.CC()) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        b et = b.et(this.avQ.Cx());
        long Cy = Cy();
        long ex = com.baidu.swan.apps.extcore.f.a.ex(et.awn);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + Cy + " newVer: " + ex);
        }
        return Cy < ex;
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
        if (this.awq.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    }
                    b et = b.et(a.this.avQ.Cx());
                    com.baidu.swan.apps.extcore.model.a aVar2 = new com.baidu.swan.apps.extcore.model.a();
                    aVar2.versionName = et.awn;
                    aVar2.awp = a.this.avQ.Cw();
                    a.this.b(aVar2);
                    a.this.CA();
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (aVar != null) {
            this.awq.add(aVar);
        }
    }

    public void Cn() {
        if (isNeedUpdate()) {
            b et = b.et(this.avQ.Cx());
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = et.awn;
            aVar.awp = this.avQ.Cw();
            b(aVar);
            CA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CA() {
        Iterator<com.baidu.swan.apps.extcore.c.a> it = this.awq.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.awq.clear();
    }

    private void c(@Nullable final com.baidu.swan.apps.extcore.c.a aVar) {
        if (aVar != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    aVar.vu();
                }
            });
        }
    }
}
