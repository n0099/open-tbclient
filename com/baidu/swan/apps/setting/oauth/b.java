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
    public final h<ResultDataT> bTm = new h<>();
    private final Set<com.baidu.swan.apps.as.d.b<h<ResultDataT>>> bJZ = new HashSet();
    private final LinkedList<d> bTn = new LinkedList<>();
    private boolean bTo = false;
    private boolean bTp = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT aN(JSONObject jSONObject) throws JSONException;

    protected abstract void aen();

    private void aeg() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aeo() throws Exception {
                if (b.this.aei()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aep();
        this.bTo = true;
    }

    private void aeh() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aeo() throws Exception {
                if (b.this.aej()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aep();
        this.bTp = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aei() {
        return true;
    }

    protected boolean aej() {
        return true;
    }

    public b<ResultDataT> h(com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar) {
        if (this.bTm.bTZ.isCallbackAvailable()) {
            this.bJZ.add(bVar);
        }
        return this;
    }

    private void aek() {
        for (final com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar : this.bJZ) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.D(b.this.bTm);
                    }
                }
            });
        }
    }

    @NonNull
    public b ael() {
        if (TaskState.INIT == aem()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aem() {
        return this.bTm.bTZ;
    }

    public void kY() {
        this.bTm.bTZ = TaskState.INIT;
        this.bTo = false;
        this.bTp = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.bTn.offer(dVar);
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
        if (!TaskState.CALLING.equals(aem())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.bTo) {
            aeg();
        } else if (!this.bTn.isEmpty()) {
            this.bTn.poll().aep();
        } else if (!this.bTp) {
            aeh();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(ResultDataT resultdatat) {
        this.bTm.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.bTm.bTZ = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        k(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.bTm.bUa = (OAuthException) exc;
        } else if (exc != null) {
            this.bTm.bUa = new OAuthException(exc, 10001);
        }
        if (!this.bTm.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aek();
        this.bJZ.clear();
    }
}
