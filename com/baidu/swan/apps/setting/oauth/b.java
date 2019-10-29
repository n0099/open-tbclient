package com.baidu.swan.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final g<ResultDataT> boe = new g<>();
    private final Set<com.baidu.swan.apps.an.d.a<g<ResultDataT>>> bnH = new HashSet();
    private final LinkedList<d> bof = new LinkedList<>();
    private boolean bog = false;
    private boolean boh = false;

    protected abstract void Sk();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT X(JSONObject jSONObject) throws JSONException;

    private void Sf() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean IO() throws Exception {
                if (!b.this.IL()) {
                    throw new OAuthException("initialPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).Sm();
        this.bog = true;
    }

    private void Sg() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean IO() throws Exception {
                if (!b.this.IM()) {
                    throw new OAuthException("finalPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).Sm();
        this.boh = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean IL() {
        return true;
    }

    protected boolean IM() {
        return true;
    }

    public b<ResultDataT> g(com.baidu.swan.apps.an.d.a<g<ResultDataT>> aVar) {
        if (this.boe.bov.isCallbackAvailable()) {
            this.bnH.add(aVar);
        }
        return this;
    }

    private void Sh() {
        for (final com.baidu.swan.apps.an.d.a<g<ResultDataT>> aVar : this.bnH) {
            c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        aVar.B(b.this.boe);
                    }
                }
            });
        }
    }

    @NonNull
    public b Si() {
        if (TaskState.INIT == Sj()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState Sj() {
        return this.boe.bov;
    }

    public void kr() {
        this.boe.bov = TaskState.INIT;
        this.bog = false;
        this.boh = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.bof.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            l(dVar.Sl());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(Sj())) {
            if (DEBUG) {
                c.a("IllegalState on prepare", (Boolean) false);
            }
        } else if (!this.bog) {
            Sf();
        } else if (!this.bof.isEmpty()) {
            this.bof.poll().Sm();
        } else if (!this.boh) {
            Sg();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        Sk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(ResultDataT resultdatat) {
        this.boe.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.boe.bov = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        l(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.boe.bow = (OAuthException) exc;
        } else if (exc != null) {
            c.aH("OAuthTask#finish", exc.getMessage());
            this.boe.bow = new OAuthException(exc, 11001);
        }
        if (!this.boe.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.a(toString(), (Boolean) false);
        Sh();
        this.bnH.clear();
    }
}
