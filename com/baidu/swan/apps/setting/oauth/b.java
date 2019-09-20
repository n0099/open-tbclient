package com.baidu.swan.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.sapi2.utils.SapiGIDEvent;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b<ResultDataT> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final g<ResultDataT> aVa = new g<>();
    private final Set<com.baidu.swan.apps.an.d.a<g<ResultDataT>>> aUD = new HashSet();
    private final LinkedList<d> aVb = new LinkedList<>();
    private boolean aVc = false;
    private boolean aVd = false;

    protected abstract void Nu();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT z(JSONObject jSONObject) throws JSONException;

    private void Np() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean DU() throws Exception {
                if (!b.this.DR()) {
                    throw new OAuthException("initialPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).Nw();
        this.aVc = true;
    }

    private void Nq() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean DU() throws Exception {
                if (!b.this.DS()) {
                    throw new OAuthException("finalPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).Nw();
        this.aVd = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DR() {
        return true;
    }

    protected boolean DS() {
        return true;
    }

    public b<ResultDataT> g(com.baidu.swan.apps.an.d.a<g<ResultDataT>> aVar) {
        if (this.aVa.aVr.isCallbackAvailable()) {
            this.aUD.add(aVar);
        }
        return this;
    }

    private void Nr() {
        for (final com.baidu.swan.apps.an.d.a<g<ResultDataT>> aVar : this.aUD) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        aVar.D(b.this.aVa);
                    }
                }
            });
        }
    }

    @NonNull
    public b Ns() {
        if (TaskState.INIT == Nt()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState Nt() {
        return this.aVa.aVr;
    }

    public void pw() {
        this.aVa.aVr = TaskState.INIT;
        this.aVc = false;
        this.aVd = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.aVb.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            l(dVar.Nv());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(Nt())) {
            if (DEBUG) {
                c.a("IllegalState on prepare", (Boolean) false);
            }
        } else if (!this.aVc) {
            Np();
        } else if (!this.aVb.isEmpty()) {
            this.aVb.poll().Nw();
        } else if (!this.aVd) {
            Nq();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        Nu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(ResultDataT resultdatat) {
        this.aVa.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.aVa.aVr = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        l(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.aVa.aVs = (OAuthException) exc;
        } else if (exc != null) {
            c.az("OAuthTask#finish", exc.getMessage());
            this.aVa.aVs = new OAuthException(exc, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        }
        if (!this.aVa.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.a(toString(), (Boolean) false);
        Nr();
        this.aUD.clear();
    }
}
