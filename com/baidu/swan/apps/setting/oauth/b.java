package com.baidu.swan.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> cIN = new h<>();
    private final Set<com.baidu.swan.apps.aq.e.b<h<ResultDataT>>> cze = new HashSet();
    private final LinkedList<d> cIO = new LinkedList<>();
    private boolean cIP = false;
    private boolean cIQ = false;

    protected abstract void arA();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bo(JSONObject jSONObject) throws JSONException;

    private void art() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean arB() throws Exception {
                if (b.this.arv()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).arC();
        this.cIP = true;
    }

    private void aru() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean arB() throws Exception {
                if (b.this.arw()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).arC();
        this.cIQ = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean arv() {
        return true;
    }

    protected boolean arw() {
        return true;
    }

    public b<ResultDataT> q(com.baidu.swan.apps.aq.e.b<h<ResultDataT>> bVar) {
        if (this.cIN.cJA.isCallbackAvailable()) {
            this.cze.add(bVar);
        }
        return this;
    }

    private void arx() {
        for (final com.baidu.swan.apps.aq.e.b<h<ResultDataT>> bVar : this.cze) {
            c.k(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.H(b.this.cIN);
                    }
                }
            });
        }
    }

    @NonNull
    public b ary() {
        if (TaskState.INIT == arz()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState arz() {
        return this.cIN.cJA;
    }

    public void pZ() {
        this.cIN.cJA = TaskState.INIT;
        this.cIP = false;
        this.cIQ = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.cIO.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            s(dVar.getException());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(arz())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.cIP) {
            art();
        } else if (!this.cIO.isEmpty()) {
            this.cIO.poll().arC();
        } else if (!this.cIQ) {
            aru();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        arA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(ResultDataT resultdatat) {
        this.cIN.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.cIN.cJA = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        s(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.cIN.cJB = (OAuthException) exc;
        } else if (exc != null) {
            this.cIN.cJB = new OAuthException(exc, 10001);
        }
        if (!this.cIN.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        arx();
        this.cze.clear();
    }
}
