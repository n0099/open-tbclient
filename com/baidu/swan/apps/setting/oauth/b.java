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
    public final h<ResultDataT> bSZ = new h<>();
    private final Set<com.baidu.swan.apps.as.d.b<h<ResultDataT>>> bJM = new HashSet();
    private final LinkedList<d> bTa = new LinkedList<>();
    private boolean bTb = false;
    private boolean bTc = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT aN(JSONObject jSONObject) throws JSONException;

    protected abstract void aei();

    private void aeb() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aej() throws Exception {
                if (b.this.aed()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aek();
        this.bTb = true;
    }

    private void aec() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aej() throws Exception {
                if (b.this.aee()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aek();
        this.bTc = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aed() {
        return true;
    }

    protected boolean aee() {
        return true;
    }

    public b<ResultDataT> h(com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar) {
        if (this.bSZ.bTM.isCallbackAvailable()) {
            this.bJM.add(bVar);
        }
        return this;
    }

    private void aef() {
        for (final com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar : this.bJM) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.D(b.this.bSZ);
                    }
                }
            });
        }
    }

    @NonNull
    public b aeg() {
        if (TaskState.INIT == aeh()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aeh() {
        return this.bSZ.bTM;
    }

    public void kY() {
        this.bSZ.bTM = TaskState.INIT;
        this.bTb = false;
        this.bTc = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.bTa.offer(dVar);
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
        if (!TaskState.CALLING.equals(aeh())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.bTb) {
            aeb();
        } else if (!this.bTa.isEmpty()) {
            this.bTa.poll().aek();
        } else if (!this.bTc) {
            aec();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aei();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(ResultDataT resultdatat) {
        this.bSZ.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.bSZ.bTM = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        k(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.bSZ.bTN = (OAuthException) exc;
        } else if (exc != null) {
            this.bSZ.bTN = new OAuthException(exc, 10001);
        }
        if (!this.bSZ.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aef();
        this.bJM.clear();
    }
}
