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
    public final h<ResultDataT> bTb = new h<>();
    private final Set<com.baidu.swan.apps.as.d.b<h<ResultDataT>>> bJO = new HashSet();
    private final LinkedList<d> bTc = new LinkedList<>();
    private boolean bTd = false;
    private boolean bTe = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT aN(JSONObject jSONObject) throws JSONException;

    protected abstract void aek();

    private void aed() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean ael() throws Exception {
                if (b.this.aef()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aem();
        this.bTd = true;
    }

    private void aee() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean ael() throws Exception {
                if (b.this.aeg()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aem();
        this.bTe = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aef() {
        return true;
    }

    protected boolean aeg() {
        return true;
    }

    public b<ResultDataT> h(com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar) {
        if (this.bTb.bTO.isCallbackAvailable()) {
            this.bJO.add(bVar);
        }
        return this;
    }

    private void aeh() {
        for (final com.baidu.swan.apps.as.d.b<h<ResultDataT>> bVar : this.bJO) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.D(b.this.bTb);
                    }
                }
            });
        }
    }

    @NonNull
    public b aei() {
        if (TaskState.INIT == aej()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aej() {
        return this.bTb.bTO;
    }

    public void kY() {
        this.bTb.bTO = TaskState.INIT;
        this.bTd = false;
        this.bTe = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.bTc.offer(dVar);
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
        if (!TaskState.CALLING.equals(aej())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.bTd) {
            aed();
        } else if (!this.bTc.isEmpty()) {
            this.bTc.poll().aem();
        } else if (!this.bTe) {
            aee();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aek();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(ResultDataT resultdatat) {
        this.bTb.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.bTb.bTO = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        k(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.bTb.bTP = (OAuthException) exc;
        } else if (exc != null) {
            this.bTb.bTP = new OAuthException(exc, 10001);
        }
        if (!this.bTb.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aeh();
        this.bJO.clear();
    }
}
