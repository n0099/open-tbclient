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
    public final h<ResultDataT> cEd = new h<>();
    private final Set<com.baidu.swan.apps.aq.e.b<h<ResultDataT>>> cus = new HashSet();
    private final LinkedList<d> cEe = new LinkedList<>();
    private boolean cEf = false;
    private boolean cEg = false;

    protected abstract void aqu();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bh(JSONObject jSONObject) throws JSONException;

    private void aqn() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aqv() throws Exception {
                if (b.this.aqp()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aqw();
        this.cEf = true;
    }

    private void aqo() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aqv() throws Exception {
                if (b.this.aqq()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aqw();
        this.cEg = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aqp() {
        return true;
    }

    protected boolean aqq() {
        return true;
    }

    public b<ResultDataT> q(com.baidu.swan.apps.aq.e.b<h<ResultDataT>> bVar) {
        if (this.cEd.cEQ.isCallbackAvailable()) {
            this.cus.add(bVar);
        }
        return this;
    }

    private void aqr() {
        for (final com.baidu.swan.apps.aq.e.b<h<ResultDataT>> bVar : this.cus) {
            c.k(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.H(b.this.cEd);
                    }
                }
            });
        }
    }

    @NonNull
    public b aqs() {
        if (TaskState.INIT == aqt()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aqt() {
        return this.cEd.cEQ;
    }

    public void pI() {
        this.cEd.cEQ = TaskState.INIT;
        this.cEf = false;
        this.cEg = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.cEe.offer(dVar);
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
        if (!TaskState.CALLING.equals(aqt())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.cEf) {
            aqn();
        } else if (!this.cEe.isEmpty()) {
            this.cEe.poll().aqw();
        } else if (!this.cEg) {
            aqo();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aqu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(ResultDataT resultdatat) {
        this.cEd.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.cEd.cEQ = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        s(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.cEd.cER = (OAuthException) exc;
        } else if (exc != null) {
            this.cEd.cER = new OAuthException(exc, 10001);
        }
        if (!this.cEd.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aqr();
        this.cus.clear();
    }
}
