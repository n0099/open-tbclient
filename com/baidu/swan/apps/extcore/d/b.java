package com.baidu.swan.apps.extcore.d;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.e.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.aq.e.b<Exception>> mCallbacks;

    public b(@NonNull T t) {
        super(t);
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public long adY() {
        return h.asV().getLong(this.chJ.adT(), 0L);
    }

    public void aR(long j) {
        h.asV().putLong(this.chJ.adT(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File adK() {
        return new File(super.adK(), "preset");
    }

    @NonNull
    public ExtensionCore adZ() {
        ExtensionCore extensionCore = new ExtensionCore();
        long adY = adY();
        extensionCore.extensionCoreVersionCode = adY;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aS(adY);
        extensionCore.extensionCorePath = aQ(adY).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.cio)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long ks = com.baidu.swan.apps.extcore.f.a.ks(aVar.versionName);
        if (d.cU(aVar.cio, aQ(ks).getPath())) {
            com.baidu.swan.apps.extcore.f.a.a(adK(), ks);
            aR(ks);
            com.baidu.swan.apps.extcore.f.a.w(this.chJ.adX(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.cio);
        if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            return exc;
        }
        return exc;
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.fw(this.chJ.adX())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a = a.a(this.chJ);
        long adY = adY();
        long ks = com.baidu.swan.apps.extcore.f.a.ks(a.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + adY + " newVer: " + ks);
        }
        return adY < ks;
    }

    @SuppressLint({"SwanNewThread"})
    public void g(@Nullable com.baidu.swan.apps.aq.e.b<Exception> bVar) {
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
                    a a = a.a(b.this.chJ);
                    com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                    aVar.versionName = a.extensionCoreVersionName;
                    aVar.cio = b.this.chJ.adV();
                    b.this.q(b.this.b(aVar));
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.mCallbacks.add(bVar);
        }
    }

    public void adL() {
        if (isNeedUpdate()) {
            a a = a.a(this.chJ);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a.extensionCoreVersionName;
            aVar.cio = this.chJ.adV();
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
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.H(exc);
                }
            });
        }
    }
}
