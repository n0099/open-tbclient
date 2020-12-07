package com.baidu.swan.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> dCW = new h<>();
    private final Set<com.baidu.swan.apps.ap.e.b<h<ResultDataT>>> cXV = new HashSet();
    private final LinkedList<d> dCX = new LinkedList<>();
    private boolean dCY = false;
    private boolean dCZ = false;

    protected abstract void aLN();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bQ(JSONObject jSONObject) throws JSONException;

    private void aLG() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aLO() throws Exception {
                if (b.this.aLI()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aLP();
        this.dCY = true;
    }

    private void aLH() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aLO() throws Exception {
                if (b.this.aLJ()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aLP();
        this.dCZ = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aLI() {
        return true;
    }

    protected boolean aLJ() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar) {
        if (this.dCW.dDN.isCallbackAvailable()) {
            this.cXV.add(bVar);
        }
        return this;
    }

    private void aLK() {
        for (final com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar : this.cXV) {
            c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.M(b.this.dCW);
                    }
                }
            });
        }
    }

    @NonNull
    public b aLL() {
        if (TaskState.INIT == aLM()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aLM() {
        return this.dCW.dDN;
    }

    public void rG() {
        this.dCW.dDN = TaskState.INIT;
        this.dCY = false;
        this.dCZ = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.dCX.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            v(dVar.getException());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(aLM())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.dCY) {
            aLG();
        } else if (!this.dCX.isEmpty()) {
            this.dCX.poll().aLP();
        } else if (!this.dCZ) {
            aLH();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aLN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(ResultDataT resultdatat) {
        this.dCW.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.dCW.dDN = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        v(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.dCW.dDO = (OAuthException) exc;
        } else if (exc != null) {
            this.dCW.dDO = new OAuthException(exc, 10001);
        }
        if (!this.dCW.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aLK();
        this.cXV.clear();
    }
}
