package com.baidu.swan.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> bOU = new h<>();
    private final Set<com.baidu.swan.apps.as.d.b<h<ResultDataT>>> bFH = new HashSet();
    private final LinkedList<d> bOV = new LinkedList<>();
    private boolean bOW = false;
    private boolean bOX = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT aN(JSONObject jSONObject) throws JSONException;

    protected abstract void abU();

    private void abN() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean abV() throws Exception {
                if (b.this.abP()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).abW();
        this.bOW = true;
    }

    private void abO() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean abV() throws Exception {
                if (b.this.abQ()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).abW();
        this.bOX = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean abP() {
        return true;
    }

    protected boolean abQ() {
        return true;
    }

    public b<ResultDataT> h(com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar) {
        if (this.bOU.bPH.isCallbackAvailable()) {
            this.bFH.add(bVar);
        }
        return this;
    }

    private void abR() {
        for (final com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar : this.bFH) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.B(b.this.bOU);
                    }
                }
            });
        }
    }

    @NonNull
    public b abS() {
        if (TaskState.INIT == abT()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState abT() {
        return this.bOU.bPH;
    }

    public void kJ() {
        this.bOU.bPH = TaskState.INIT;
        this.bOW = false;
        this.bOX = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.bOV.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            k(dVar.getException());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(abT())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.bOW) {
            abN();
        } else if (!this.bOV.isEmpty()) {
            this.bOV.poll().abW();
        } else if (!this.bOX) {
            abO();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        abU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(ResultDataT resultdatat) {
        this.bOU.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.bOU.bPH = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        k(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.bOU.bPI = (OAuthException) exc;
        } else if (exc != null) {
            this.bOU.bPI = new OAuthException(exc, 10001);
        }
        if (!this.bOU.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        abR();
        this.bFH.clear();
    }
}
