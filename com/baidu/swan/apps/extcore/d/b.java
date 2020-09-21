package com.baidu.swan.apps.extcore.d;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.extcore.model.b.a;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.c.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public abstract class b<T extends com.baidu.swan.apps.extcore.model.b.a> extends com.baidu.swan.apps.extcore.b.a<T> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CopyOnWriteArrayList<com.baidu.swan.apps.ap.e.b<Exception>> mCallbacks;

    public b(@NonNull T t) {
        super(t);
        this.mCallbacks = new CopyOnWriteArrayList<>();
    }

    public long ang() {
        return h.aDP().getLong(this.ctc.anb(), 0L);
    }

    public void aY(long j) {
        h.aDP().putLong(this.ctc.anb(), j);
    }

    @Override // com.baidu.swan.apps.extcore.b.a
    public File amQ() {
        return new File(super.amQ(), "preset");
    }

    @NonNull
    public ExtensionCore anh() {
        ExtensionCore extensionCore = new ExtensionCore();
        long ang = ang();
        extensionCore.extensionCoreVersionCode = ang;
        extensionCore.extensionCoreVersionName = com.baidu.swan.apps.extcore.f.a.aZ(ang);
        extensionCore.extensionCorePath = aX(ang).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/swan/apps/extcore/model/a;>(TT;)Ljava/lang/Exception; */
    public Exception b(@NonNull com.baidu.swan.apps.extcore.model.a aVar) {
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.ctG)) {
            if (DEBUG) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long mX = com.baidu.swan.apps.extcore.f.a.mX(aVar.versionName);
        if (d.dn(aVar.ctG, aX(mX).getPath())) {
            com.baidu.swan.apps.extcore.f.a.a(amQ(), mX);
            aY(mX);
            com.baidu.swan.apps.extcore.f.a.x(this.ctc.anf(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.ctG);
        if (DEBUG) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
            return exc;
        }
        return exc;
    }

    private boolean isNeedUpdate() {
        if (!com.baidu.swan.apps.extcore.f.a.hL(this.ctc.anf())) {
            if (DEBUG) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                return false;
            }
            return false;
        }
        a a = a.a(this.ctc);
        long ang = ang();
        long mX = com.baidu.swan.apps.extcore.f.a.mX(a.extensionCoreVersionName);
        if (DEBUG) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + ang + " newVer: " + mX);
        }
        return ang < mX;
    }

    @SuppressLint({"SwanNewThread"})
    public void o(@Nullable com.baidu.swan.apps.ap.e.b<Exception> bVar) {
        c.bb("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!isNeedUpdate()) {
            c.bb("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            a(bVar, (Exception) null);
            return;
        }
        if (this.mCallbacks.isEmpty()) {
            new Thread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    c.bb("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                    a a = a.a(b.this.ctc);
                    com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
                    aVar.versionName = a.extensionCoreVersionName;
                    aVar.ctG = b.this.ctc.and();
                    b.this.t(b.this.b(aVar));
                }
            }, "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.mCallbacks.add(bVar);
        }
    }

    public void amR() {
        if (isNeedUpdate()) {
            a a = a.a(this.ctc);
            com.baidu.swan.apps.extcore.model.a aVar = new com.baidu.swan.apps.extcore.model.a();
            aVar.versionName = a.extensionCoreVersionName;
            aVar.ctG = this.ctc.and();
            t(b(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        Iterator<com.baidu.swan.apps.ap.e.b<Exception>> it = this.mCallbacks.iterator();
        while (it.hasNext()) {
            a(it.next(), exc);
        }
        this.mCallbacks.clear();
    }

    private void a(@Nullable final com.baidu.swan.apps.ap.e.b<Exception> bVar, final Exception exc) {
        if (bVar != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.extcore.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    bVar.J(exc);
                }
            });
        }
    }
}
