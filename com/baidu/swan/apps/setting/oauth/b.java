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
    public final h<ResultDataT> csh = new h<>();
    private final Set<com.baidu.swan.apps.as.d.b<h<ResultDataT>>> ciP = new HashSet();
    private final LinkedList<d> csi = new LinkedList<>();
    private boolean csj = false;
    private boolean csk = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT aY(JSONObject jSONObject) throws JSONException;

    protected abstract void amr();

    private void amk() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean ams() throws Exception {
                if (b.this.amm()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).amt();
        this.csj = true;
    }

    private void aml() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean ams() throws Exception {
                if (b.this.amn()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).amt();
        this.csk = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean amm() {
        return true;
    }

    protected boolean amn() {
        return true;
    }

    public b<ResultDataT> h(com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar) {
        if (this.csh.csU.isCallbackAvailable()) {
            this.ciP.add(bVar);
        }
        return this;
    }

    private void amo() {
        for (final com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar : this.ciP) {
            c.j(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.F(b.this.csh);
                    }
                }
            });
        }
    }

    @NonNull
    public b amp() {
        if (TaskState.INIT == amq()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState amq() {
        return this.csh.csU;
    }

    public void pC() {
        this.csh.csU = TaskState.INIT;
        this.csj = false;
        this.csk = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.csi.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            l(dVar.getException());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(amq())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.csj) {
            amk();
        } else if (!this.csi.isEmpty()) {
            this.csi.poll().amt();
        } else if (!this.csk) {
            aml();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        amr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(ResultDataT resultdatat) {
        this.csh.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.csh.csU = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        l(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.csh.csV = (OAuthException) exc;
        } else if (exc != null) {
            this.csh.csV = new OAuthException(exc, 10001);
        }
        if (!this.csh.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        amo();
        this.ciP.clear();
    }
}
