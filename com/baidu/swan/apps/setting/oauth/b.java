package com.baidu.swan.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> cVa = new h<>();
    private final Set<com.baidu.swan.apps.ap.e.b<h<ResultDataT>>> cqj = new HashSet();
    private final LinkedList<d> cVb = new LinkedList<>();
    private boolean cVc = false;
    private boolean cVd = false;

    protected abstract void aBA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bB(JSONObject jSONObject) throws JSONException;

    private void aBt() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aBB() throws Exception {
                if (b.this.aBv()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aBC();
        this.cVc = true;
    }

    private void aBu() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aBB() throws Exception {
                if (b.this.aBw()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aBC();
        this.cVd = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aBv() {
        return true;
    }

    protected boolean aBw() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar) {
        if (this.cVa.cVR.isCallbackAvailable()) {
            this.cqj.add(bVar);
        }
        return this;
    }

    private void aBx() {
        for (final com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar : this.cqj) {
            c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.I(b.this.cVa);
                    }
                }
            });
        }
    }

    @NonNull
    public b aBy() {
        if (TaskState.INIT == aBz()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aBz() {
        return this.cVa.cVR;
    }

    public void rz() {
        this.cVa.cVR = TaskState.INIT;
        this.cVc = false;
        this.cVd = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.cVb.offer(dVar);
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
        if (!TaskState.CALLING.equals(aBz())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.cVc) {
            aBt();
        } else if (!this.cVb.isEmpty()) {
            this.cVb.poll().aBC();
        } else if (!this.cVd) {
            aBu();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aBA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(ResultDataT resultdatat) {
        this.cVa.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.cVa.cVR = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        v(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.cVa.cVS = (OAuthException) exc;
        } else if (exc != null) {
            this.cVa.cVS = new OAuthException(exc, 10001);
        }
        if (!this.cVa.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aBx();
        this.cqj.clear();
    }
}
