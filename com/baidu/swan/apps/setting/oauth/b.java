package com.baidu.swan.apps.setting.oauth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> dLA = new h<>();
    private final Set<com.baidu.swan.apps.ao.e.b<h<ResultDataT>>> dcQ = new HashSet();
    private final LinkedList<d> dLB = new LinkedList<>();
    private boolean dLC = false;
    private boolean dLD = false;

    protected abstract void aOe();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bY(JSONObject jSONObject) throws JSONException;

    private void aNX() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aOf() throws Exception {
                if (b.this.aNZ()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aOg();
        this.dLC = true;
    }

    private void aNY() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aOf() throws Exception {
                if (b.this.aOa()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aOg();
        this.dLD = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aNZ() {
        return true;
    }

    protected boolean aOa() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ao.e.b<h<ResultDataT>> bVar) {
        if (this.dLA.dMr.isCallbackAvailable()) {
            this.dcQ.add(bVar);
        }
        return this;
    }

    private void aOb() {
        for (final com.baidu.swan.apps.ao.e.b<h<ResultDataT>> bVar : this.dcQ) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.L(b.this.dLA);
                    }
                }
            });
        }
    }

    @NonNull
    public b aOc() {
        if (TaskState.INIT == aOd()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aOd() {
        return this.dLA.dMr;
    }

    public void rh() {
        this.dLA.dMr = TaskState.INIT;
        this.dLC = false;
        this.dLD = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.dLB.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            w(dVar.getException());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(aOd())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.dLC) {
            aNX();
        } else if (!this.dLB.isEmpty()) {
            this.dLB.poll().aOg();
        } else if (!this.dLD) {
            aNY();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aOe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(ResultDataT resultdatat) {
        this.dLA.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.dLA.dMr = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        w(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.dLA.dMs = (OAuthException) exc;
        } else if (exc != null) {
            this.dLA.dMs = new OAuthException(exc, 10001);
        }
        if (!this.dLA.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aOb();
        this.dcQ.clear();
    }
}
