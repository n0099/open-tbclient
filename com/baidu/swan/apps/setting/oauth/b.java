package com.baidu.swan.apps.setting.oauth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> dKt = new h<>();
    private final Set<com.baidu.swan.apps.ao.e.b<h<ResultDataT>>> dbO = new HashSet();
    private final LinkedList<d> dKu = new LinkedList<>();
    private boolean dKv = false;
    private boolean dKw = false;

    protected abstract void aKG();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bX(JSONObject jSONObject) throws JSONException;

    private void aKz() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aKH() throws Exception {
                if (b.this.aKB()) {
                    return true;
                }
                c.d("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aKI();
        this.dKv = true;
    }

    private void aKA() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aKH() throws Exception {
                if (b.this.aKC()) {
                    return true;
                }
                c.d("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aKI();
        this.dKw = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aKB() {
        return true;
    }

    protected boolean aKC() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ao.e.b<h<ResultDataT>> bVar) {
        if (this.dKt.dLk.isCallbackAvailable()) {
            this.dbO.add(bVar);
        }
        return this;
    }

    private void aKD() {
        for (final com.baidu.swan.apps.ao.e.b<h<ResultDataT>> bVar : this.dbO) {
            c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.N(b.this.dKt);
                    }
                }
            });
        }
    }

    @NonNull
    public b aKE() {
        if (TaskState.INIT == aKF()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aKF() {
        return this.dKt.dLk;
    }

    public void rf() {
        this.dKt.dLk = TaskState.INIT;
        this.dKv = false;
        this.dKw = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.dKu.offer(dVar);
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
        if (!TaskState.CALLING.equals(aKF())) {
            if (DEBUG) {
                c.d("IllegalState on prepare", false);
            }
        } else if (!this.dKv) {
            aKz();
        } else if (!this.dKu.isEmpty()) {
            this.dKu.poll().aKI();
        } else if (!this.dKw) {
            aKA();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aKG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac(ResultDataT resultdatat) {
        this.dKt.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.dKt.dLk = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        w(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.dKt.dLl = (OAuthException) exc;
        } else if (exc != null) {
            this.dKt.dLl = new OAuthException(exc, 10001);
        }
        if (!this.dKt.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.d(toString(), false);
        aKD();
        this.dbO.clear();
    }
}
