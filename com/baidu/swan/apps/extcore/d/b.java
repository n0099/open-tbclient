package com.baidu.swan.apps.extcore.d;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.ao.e.b<Exception>> den;

    public b(@NonNull T t) {
        super(t);
        this.den = new CopyOnWriteArrayList<>();
    }

    public long ayf() {
        return h.aPH().getLong(this.ddH.aya(), 0L);
    }

    public void ce(long j) {
        h.aPH().putLong(this.ddH.aya(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File axP() {
        return new File(super.axP(), "preset");
    }

    @NonNull
    public ExtensionCore ayg() {
        ExtensionCore extensionCore = new ExtensionCore();
        long ayf = ayf();
        extensionCore.extensionCoreVersionCode = ayf;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.cf(ayf);
        extensionCore.extensionCorePath = cd(ayf).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.dej)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long oM = com.baidu.swan.apps.extcore.f.a.oM(aVar.versionName);
        if (d.dE(aVar.dej, cd(oM).getPath())) {
            com.baidu.swan.apps.extcore.f.a.a(axP(), oM);
            ce(oM);
            com.baidu.swan.apps.extcore.f.a.z(this.ddH.aye(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.dej);
        if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            return exc;
        }
        return exc;
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.iS(this.ddH.aye())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a2 = a.a(this.ddH);
        long ayf = ayf();
        long oM = com.baidu.swan.apps.extcore.f.a.oM(a2.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + ayf + " newVer: " + oM);
        }
        return ayf < oM;
    }

    @SuppressLint({"SwanNewThread"})
    public void o(@Nullable com.baidu.swan.apps.ao.e.b<Exception> bVar) {
        c.bs("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!isNeedUpdate()) {
            c.bs("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            a(bVar, (Exception) null);
            return;
        }
        if (this.den.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    c.bs("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    a a2 = a.a(b.this.ddH);
                    com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                    aVar.versionName = a2.extensionCoreVersionName;
                    aVar.dej = b.this.ddH.ayc();
                    b.this.u(b.this.b(aVar));
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.den.add(bVar);
        }
    }

    public void axQ() {
        if (isNeedUpdate()) {
            a a2 = a.a(this.ddH);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a2.extensionCoreVersionName;
            aVar.dej = this.ddH.ayc();
            u(b(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        Iterator<com.baidu.swan.apps.ao.e.b<Exception>> it = this.den.iterator();
        while (it.hasNext()) {
            a(it.next(), exc);
        }
        this.den.clear();
    }

    private void a(@Nullable final com.baidu.swan.apps.ao.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.L(exc);
                }
            });
        }
    }
}
