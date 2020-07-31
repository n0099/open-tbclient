package com.baidu.swan.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final h<ResultDataT> cLZ = new h<>();
    private final Set<com.baidu.swan.apps.aq.e.b<h<ResultDataT>>> cBE = new HashSet();
    private final LinkedList<d> cMa = new LinkedList<>();
    private boolean cMb = false;
    private boolean cMc = false;

    protected abstract void ats();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bt(JSONObject jSONObject) throws JSONException;

    private void atl() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean att() throws Exception {
                if (b.this.atn()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).atu();
        this.cMb = true;
    }

    private void atm() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean att() throws Exception {
                if (b.this.ato()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).atu();
        this.cMc = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean atn() {
        return true;
    }

    protected boolean ato() {
        return true;
    }

    public b<ResultDataT> t(com.baidu.swan.apps.aq.e.b<h<ResultDataT>> bVar) {
        if (this.cLZ.cMR.isCallbackAvailable()) {
            this.cBE.add(bVar);
        }
        return this;
    }

    private void atp() {
        for (final com.baidu.swan.apps.aq.e.b<h<ResultDataT>> bVar : this.cBE) {
            c.k(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.H(b.this.cLZ);
                    }
                }
            });
        }
    }

    @NonNull
    public b atq() {
        if (TaskState.INIT == atr()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState atr() {
        return this.cLZ.cMR;
    }

    public void qa() {
        this.cLZ.cMR = TaskState.INIT;
        this.cMb = false;
        this.cMc = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.cMa.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            s(dVar.getException());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(atr())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.cMb) {
            atl();
        } else if (!this.cMa.isEmpty()) {
            this.cMa.poll().atu();
        } else if (!this.cMc) {
            atm();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        ats();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(ResultDataT resultdatat) {
        this.cLZ.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.cLZ.cMR = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        s(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.cLZ.cMS = (OAuthException) exc;
        } else if (exc != null) {
            this.cLZ.cMS = new OAuthException(exc, 10001);
        }
        if (!this.cLZ.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        atp();
        this.cBE.clear();
    }
}
