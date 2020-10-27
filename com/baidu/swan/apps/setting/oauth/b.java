package com.baidu.swan.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> drK = new h<>();
    private final Set<com.baidu.swan.apps.ap.e.b<h<ResultDataT>>> cMT = new HashSet();
    private final LinkedList<d> drL = new LinkedList<>();
    private boolean drM = false;
    private boolean drN = false;

    protected abstract void aGN();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bO(JSONObject jSONObject) throws JSONException;

    private void aGG() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aGO() throws Exception {
                if (b.this.aGI()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aGP();
        this.drM = true;
    }

    private void aGH() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aGO() throws Exception {
                if (b.this.aGJ()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aGP();
        this.drN = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aGI() {
        return true;
    }

    protected boolean aGJ() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar) {
        if (this.drK.dsC.isCallbackAvailable()) {
            this.cMT.add(bVar);
        }
        return this;
    }

    private void aGK() {
        for (final com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar : this.cMT) {
            c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.M(b.this.drK);
                    }
                }
            });
        }
    }

    @NonNull
    public b aGL() {
        if (TaskState.INIT == aGM()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aGM() {
        return this.drK.dsC;
    }

    public void rE() {
        this.drK.dsC = TaskState.INIT;
        this.drM = false;
        this.drN = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.drL.offer(dVar);
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
        if (!TaskState.CALLING.equals(aGM())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.drM) {
            aGG();
        } else if (!this.drL.isEmpty()) {
            this.drL.poll().aGP();
        } else if (!this.drN) {
            aGH();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aGN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(ResultDataT resultdatat) {
        this.drK.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.drK.dsC = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        v(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.drK.dsD = (OAuthException) exc;
        } else if (exc != null) {
            this.drK.dsD = new OAuthException(exc, 10001);
        }
        if (!this.drK.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aGK();
        this.cMT.clear();
    }
}
