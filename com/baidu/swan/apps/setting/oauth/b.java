package com.baidu.swan.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> bOk = new h<>();
    private final Set<com.baidu.swan.apps.as.d.b<h<ResultDataT>>> bEW = new HashSet();
    private final LinkedList<d> bOl = new LinkedList<>();
    private boolean bOm = false;
    private boolean bOn = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT aN(JSONObject jSONObject) throws JSONException;

    protected abstract void abx();

    private void abq() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aby() throws Exception {
                if (b.this.abs()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).abz();
        this.bOm = true;
    }

    private void abr() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aby() throws Exception {
                if (b.this.abt()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).abz();
        this.bOn = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean abs() {
        return true;
    }

    protected boolean abt() {
        return true;
    }

    public b<ResultDataT> h(com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar) {
        if (this.bOk.bOX.isCallbackAvailable()) {
            this.bEW.add(bVar);
        }
        return this;
    }

    private void abu() {
        for (final com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar : this.bEW) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.B(b.this.bOk);
                    }
                }
            });
        }
    }

    @NonNull
    public b abv() {
        if (TaskState.INIT == abw()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState abw() {
        return this.bOk.bOX;
    }

    public void kI() {
        this.bOk.bOX = TaskState.INIT;
        this.bOm = false;
        this.bOn = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.bOl.offer(dVar);
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
        if (!TaskState.CALLING.equals(abw())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.bOm) {
            abq();
        } else if (!this.bOl.isEmpty()) {
            this.bOl.poll().abz();
        } else if (!this.bOn) {
            abr();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        abx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(ResultDataT resultdatat) {
        this.bOk.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.bOk.bOX = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        k(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.bOk.bOY = (OAuthException) exc;
        } else if (exc != null) {
            this.bOk.bOY = new OAuthException(exc, 10001);
        }
        if (!this.bOk.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        abu();
        this.bEW.clear();
    }
}
