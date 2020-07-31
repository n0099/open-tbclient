package com.baidu.swan.apps.extcore.d;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.d.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.aq.e.b<Exception>> mCallbacks;

    public b(@NonNull T t) {
        super(t);
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public long afp() {
        return h.auW().getLong(this.cjI.afk(), 0L);
    }

    public void aU(long j) {
        h.auW().putLong(this.cjI.afk(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File afa() {
        return new File(super.afa(), "preset");
    }

    @NonNull
    public ExtensionCore afq() {
        ExtensionCore extensionCore = new ExtensionCore();
        long afp = afp();
        extensionCore.extensionCoreVersionCode = afp;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aV(afp);
        extensionCore.extensionCorePath = aT(afp).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.ckm)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long kO = com.baidu.swan.apps.extcore.f.a.kO(aVar.versionName);
        if (d.cX(aVar.ckm, aT(kO).getPath())) {
            com.baidu.swan.apps.extcore.f.a.a(afa(), kO);
            aU(kO);
            com.baidu.swan.apps.extcore.f.a.v(this.cjI.afo(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.ckm);
        if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            return exc;
        }
        return exc;
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.fF(this.cjI.afo())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a = a.a(this.cjI);
        long afp = afp();
        long kO = com.baidu.swan.apps.extcore.f.a.kO(a.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + afp + " newVer: " + kO);
        }
        return afp < kO;
    }

    @SuppressLint({"SwanNewThread"})
    public void h(@Nullable com.baidu.swan.apps.aq.e.b<Exception> bVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "tryUpdateAsync: start");
        }
        if (!isNeedUpdate()) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "tryUpdateAsync: finish with isNeedUpdate " + isNeedUpdate());
            }
            a(bVar, (Exception) null);
            return;
        }
        if (this.mCallbacks.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.DEBUG) {
                        Log.d("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    }
                    a a = a.a(b.this.cjI);
                    com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                    aVar.versionName = a.extensionCoreVersionName;
                    aVar.ckm = b.this.cjI.afm();
                    b.this.q(b.this.b(aVar));
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.mCallbacks.add(bVar);
        }
    }

    public void afb() {
        if (isNeedUpdate()) {
            a a = a.a(this.cjI);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a.extensionCoreVersionName;
            aVar.ckm = this.cjI.afm();
            q(b(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Exception exc) {
        Iterator<com.baidu.swan.apps.aq.e.b<Exception>> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            a(it.next(), exc);
        }
        this.mCallbacks.clear();
    }

    private void a(@Nullable final com.baidu.swan.apps.aq.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.H(exc);
                }
            });
        }
    }
}
