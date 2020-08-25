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
    public final h<ResultDataT> cUW = new h<>();
    private final Set<com.baidu.swan.apps.ap.e.b<h<ResultDataT>>> cqf = new HashSet();
    private final LinkedList<d> cUX = new LinkedList<>();
    private boolean cUY = false;
    private boolean cUZ = false;

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
        this.cUY = true;
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
        this.cUZ = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aBv() {
        return true;
    }

    protected boolean aBw() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar) {
        if (this.cUW.cVN.isCallbackAvailable()) {
            this.cqf.add(bVar);
        }
        return this;
    }

    private void aBx() {
        for (final com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar : this.cqf) {
            c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.I(b.this.cUW);
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
        return this.cUW.cVN;
    }

    public void rz() {
        this.cUW.cVN = TaskState.INIT;
        this.cUY = false;
        this.cUZ = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.cUX.offer(dVar);
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
        } else if (!this.cUY) {
            aBt();
        } else if (!this.cUX.isEmpty()) {
            this.cUX.poll().aBC();
        } else if (!this.cUZ) {
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
        this.cUW.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.cUW.cVN = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        v(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.cUW.cVO = (OAuthException) exc;
        } else if (exc != null) {
            this.cUW.cVO = new OAuthException(exc, 10001);
        }
        if (!this.cUW.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aBx();
        this.cqf.clear();
    }
}
