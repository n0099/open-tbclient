package com.baidu.swan.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> cXa = new h<>();
    private final Set<com.baidu.swan.apps.ap.e.b<h<ResultDataT>>> csm = new HashSet();
    private final LinkedList<d> cXb = new LinkedList<>();
    private boolean cXc = false;
    private boolean cXd = false;

    protected abstract void aCk();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bE(JSONObject jSONObject) throws JSONException;

    private void aCd() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aCl() throws Exception {
                if (b.this.aCf()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aCm();
        this.cXc = true;
    }

    private void aCe() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aCl() throws Exception {
                if (b.this.aCg()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aCm();
        this.cXd = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aCf() {
        return true;
    }

    protected boolean aCg() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar) {
        if (this.cXa.cXR.isCallbackAvailable()) {
            this.csm.add(bVar);
        }
        return this;
    }

    private void aCh() {
        for (final com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar : this.csm) {
            c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.J(b.this.cXa);
                    }
                }
            });
        }
    }

    @NonNull
    public b aCi() {
        if (TaskState.INIT == aCj()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aCj() {
        return this.cXa.cXR;
    }

    public void rE() {
        this.cXa.cXR = TaskState.INIT;
        this.cXc = false;
        this.cXd = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.cXb.offer(dVar);
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
        if (!TaskState.CALLING.equals(aCj())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.cXc) {
            aCd();
        } else if (!this.cXb.isEmpty()) {
            this.cXb.poll().aCm();
        } else if (!this.cXd) {
            aCe();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aCk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(ResultDataT resultdatat) {
        this.cXa.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.cXa.cXR = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        v(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.cXa.cXS = (OAuthException) exc;
        } else if (exc != null) {
            this.cXa.cXS = new OAuthException(exc, 10001);
        }
        if (!this.cXa.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aCh();
        this.csm.clear();
    }
}
