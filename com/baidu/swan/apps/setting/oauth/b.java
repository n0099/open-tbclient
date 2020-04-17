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
    public final h<ResultDataT> csb = new h<>();
    private final Set<com.baidu.swan.apps.as.d.b<h<ResultDataT>>> ciJ = new HashSet();
    private final LinkedList<d> csc = new LinkedList<>();
    private boolean csd = false;
    private boolean cse = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT aY(JSONObject jSONObject) throws JSONException;

    protected abstract void ams();

    private void aml() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean amt() throws Exception {
                if (b.this.amn()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).amu();
        this.csd = true;
    }

    private void amm() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean amt() throws Exception {
                if (b.this.amo()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).amu();
        this.cse = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean amn() {
        return true;
    }

    protected boolean amo() {
        return true;
    }

    public b<ResultDataT> h(com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar) {
        if (this.csb.csO.isCallbackAvailable()) {
            this.ciJ.add(bVar);
        }
        return this;
    }

    private void amp() {
        for (final com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar : this.ciJ) {
            c.j(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.E(b.this.csb);
                    }
                }
            });
        }
    }

    @NonNull
    public b amq() {
        if (TaskState.INIT == amr()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState amr() {
        return this.csb.csO;
    }

    public void pC() {
        this.csb.csO = TaskState.INIT;
        this.csd = false;
        this.cse = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.csc.offer(dVar);
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
        if (!TaskState.CALLING.equals(amr())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.csd) {
            aml();
        } else if (!this.csc.isEmpty()) {
            this.csc.poll().amu();
        } else if (!this.cse) {
            amm();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        ams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(ResultDataT resultdatat) {
        this.csb.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.csb.csO = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        k(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.csb.csP = (OAuthException) exc;
        } else if (exc != null) {
            this.csb.csP = new OAuthException(exc, 10001);
        }
        if (!this.csb.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        amp();
        this.ciJ.clear();
    }
}
