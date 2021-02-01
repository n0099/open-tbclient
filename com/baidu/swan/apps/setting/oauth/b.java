package com.baidu.swan.apps.setting.oauth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> dIS = new h<>();
    private final Set<com.baidu.swan.apps.ao.e.b<h<ResultDataT>>> dal = new HashSet();
    private final LinkedList<d> dIT = new LinkedList<>();
    private boolean dIU = false;
    private boolean dIV = false;

    protected abstract void aKD();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bV(JSONObject jSONObject) throws JSONException;

    private void aKw() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aKE() throws Exception {
                if (b.this.aKy()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aKF();
        this.dIU = true;
    }

    private void aKx() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aKE() throws Exception {
                if (b.this.aKz()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aKF();
        this.dIV = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aKy() {
        return true;
    }

    protected boolean aKz() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ao.e.b<h<ResultDataT>> bVar) {
        if (this.dIS.dJJ.isCallbackAvailable()) {
            this.dal.add(bVar);
        }
        return this;
    }

    private void aKA() {
        for (final com.baidu.swan.apps.ao.e.b<h<ResultDataT>> bVar : this.dal) {
            c.f(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.L(b.this.dIS);
                    }
                }
            });
        }
    }

    @NonNull
    public b aKB() {
        if (TaskState.INIT == aKC()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aKC() {
        return this.dIS.dJJ;
    }

    public void rf() {
        this.dIS.dJJ = TaskState.INIT;
        this.dIU = false;
        this.dIV = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.dIT.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            w(dVar.getException());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(aKC())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.dIU) {
            aKw();
        } else if (!this.dIT.isEmpty()) {
            this.dIT.poll().aKF();
        } else if (!this.dIV) {
            aKx();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aKD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aa(ResultDataT resultdatat) {
        this.dIS.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.dIS.dJJ = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        w(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.dIS.dJK = (OAuthException) exc;
        } else if (exc != null) {
            this.dIS.dJK = new OAuthException(exc, 10001);
        }
        if (!this.dIS.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aKA();
        this.dal.clear();
    }
}
