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
    public final h<ResultDataT> djk = new h<>();
    private final Set<com.baidu.swan.apps.ap.e.b<h<ResultDataT>>> cEx = new HashSet();
    private final LinkedList<d> djl = new LinkedList<>();
    private boolean djm = false;
    private boolean djn = false;

    protected abstract void aET();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bL(JSONObject jSONObject) throws JSONException;

    private void aEM() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aEU() throws Exception {
                if (b.this.aEO()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aEV();
        this.djm = true;
    }

    private void aEN() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aEU() throws Exception {
                if (b.this.aEP()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aEV();
        this.djn = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aEO() {
        return true;
    }

    protected boolean aEP() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar) {
        if (this.djk.dkb.isCallbackAvailable()) {
            this.cEx.add(bVar);
        }
        return this;
    }

    private void aEQ() {
        for (final com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar : this.cEx) {
            c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.M(b.this.djk);
                    }
                }
            });
        }
    }

    @NonNull
    public b aER() {
        if (TaskState.INIT == aES()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aES() {
        return this.djk.dkb;
    }

    public void rE() {
        this.djk.dkb = TaskState.INIT;
        this.djm = false;
        this.djn = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.djl.offer(dVar);
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
        if (!TaskState.CALLING.equals(aES())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.djm) {
            aEM();
        } else if (!this.djl.isEmpty()) {
            this.djl.poll().aEV();
        } else if (!this.djn) {
            aEN();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aET();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(ResultDataT resultdatat) {
        this.djk.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.djk.dkb = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        v(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.djk.dkc = (OAuthException) exc;
        } else if (exc != null) {
            this.djk.dkc = new OAuthException(exc, 10001);
        }
        if (!this.djk.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aEQ();
        this.cEx.clear();
    }
}
