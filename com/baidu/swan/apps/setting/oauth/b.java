package com.baidu.swan.apps.setting.oauth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> dGO = new h<>();
    private final Set<com.baidu.swan.apps.ao.e.b<h<ResultDataT>>> cYb = new HashSet();
    private final LinkedList<d> dGP = new LinkedList<>();
    private boolean dGQ = false;
    private boolean dGR = false;

    protected abstract void aKk();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bY(JSONObject jSONObject) throws JSONException;

    private void aKd() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aKl() throws Exception {
                if (b.this.aKf()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aKm();
        this.dGQ = true;
    }

    private void aKe() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aKl() throws Exception {
                if (b.this.aKg()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aKm();
        this.dGR = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aKf() {
        return true;
    }

    protected boolean aKg() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ao.e.b<h<ResultDataT>> bVar) {
        if (this.dGO.dHF.isCallbackAvailable()) {
            this.cYb.add(bVar);
        }
        return this;
    }

    private void aKh() {
        for (final com.baidu.swan.apps.ao.e.b<h<ResultDataT>> bVar : this.cYb) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.L(b.this.dGO);
                    }
                }
            });
        }
    }

    @NonNull
    public b aKi() {
        if (TaskState.INIT == aKj()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aKj() {
        return this.dGO.dHF;
    }

    public void rh() {
        this.dGO.dHF = TaskState.INIT;
        this.dGQ = false;
        this.dGR = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.dGP.offer(dVar);
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
        if (!TaskState.CALLING.equals(aKj())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.dGQ) {
            aKd();
        } else if (!this.dGP.isEmpty()) {
            this.dGP.poll().aKm();
        } else if (!this.dGR) {
            aKe();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aKk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(ResultDataT resultdatat) {
        this.dGO.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.dGO.dHF = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        w(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.dGO.dHG = (OAuthException) exc;
        } else if (exc != null) {
            this.dGO.dHG = new OAuthException(exc, 10001);
        }
        if (!this.dGO.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aKh();
        this.cYb.clear();
    }
}
