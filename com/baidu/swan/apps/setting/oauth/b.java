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
    public final h<ResultDataT> dxE = new h<>();
    private final Set<com.baidu.swan.apps.ap.e.b<h<ResultDataT>>> cSM = new HashSet();
    private final LinkedList<d> dxF = new LinkedList<>();
    private boolean dxG = false;
    private boolean dxH = false;

    protected abstract void aJn();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bU(JSONObject jSONObject) throws JSONException;

    private void aJg() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aJo() throws Exception {
                if (b.this.aJi()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aJp();
        this.dxG = true;
    }

    private void aJh() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aJo() throws Exception {
                if (b.this.aJj()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aJp();
        this.dxH = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aJi() {
        return true;
    }

    protected boolean aJj() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar) {
        if (this.dxE.dyv.isCallbackAvailable()) {
            this.cSM.add(bVar);
        }
        return this;
    }

    private void aJk() {
        for (final com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar : this.cSM) {
            c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.M(b.this.dxE);
                    }
                }
            });
        }
    }

    @NonNull
    public b aJl() {
        if (TaskState.INIT == aJm()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aJm() {
        return this.dxE.dyv;
    }

    public void rE() {
        this.dxE.dyv = TaskState.INIT;
        this.dxG = false;
        this.dxH = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.dxF.offer(dVar);
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
        if (!TaskState.CALLING.equals(aJm())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.dxG) {
            aJg();
        } else if (!this.dxF.isEmpty()) {
            this.dxF.poll().aJp();
        } else if (!this.dxH) {
            aJh();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aJn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(ResultDataT resultdatat) {
        this.dxE.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.dxE.dyv = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        v(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.dxE.dyw = (OAuthException) exc;
        } else if (exc != null) {
            this.dxE.dyw = new OAuthException(exc, 10001);
        }
        if (!this.dxE.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aJk();
        this.cSM.clear();
    }
}
