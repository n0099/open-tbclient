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
    public final g<ResultDataT> aUC = new g<>();
    private final Set<com.baidu.swan.apps.an.d.a<g<ResultDataT>>> aUf = new HashSet();
    private final LinkedList<d> aUD = new LinkedList<>();
    private boolean aUE = false;
    private boolean aUF = false;

    protected abstract void Nq();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT z(JSONObject jSONObject) throws JSONException;

    private void Nl() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean DQ() throws Exception {
                if (!b.this.DN()) {
                    throw new OAuthException("initialPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).Ns();
        this.aUE = true;
    }

    private void Nm() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean DQ() throws Exception {
                if (!b.this.DO()) {
                    throw new OAuthException("finalPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).Ns();
        this.aUF = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DN() {
        return true;
    }

    protected boolean DO() {
        return true;
    }

    public b<ResultDataT> g(com.baidu.swan.apps.an.d.a<g<ResultDataT>> aVar) {
        if (this.aUC.aUT.isCallbackAvailable()) {
            this.aUf.add(aVar);
        }
        return this;
    }

    private void Nn() {
        for (final com.baidu.swan.apps.an.d.a<g<ResultDataT>> aVar : this.aUf) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        aVar.D(b.this.aUC);
                    }
                }
            });
        }
    }

    @NonNull
    public b No() {
        if (TaskState.INIT == Np()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState Np() {
        return this.aUC.aUT;
    }

    public void pv() {
        this.aUC.aUT = TaskState.INIT;
        this.aUE = false;
        this.aUF = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.aUD.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            l(dVar.Nr());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(Np())) {
            if (DEBUG) {
                c.a("IllegalState on prepare", (Boolean) false);
            }
        } else if (!this.aUE) {
            Nl();
        } else if (!this.aUD.isEmpty()) {
            this.aUD.poll().Ns();
        } else if (!this.aUF) {
            Nm();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        Nq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(ResultDataT resultdatat) {
        this.aUC.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.aUC.aUT = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        l(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.aUC.aUU = (OAuthException) exc;
        } else if (exc != null) {
            c.az("OAuthTask#finish", exc.getMessage());
            this.aUC.aUU = new OAuthException(exc, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        }
        if (!this.aUC.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.a(toString(), (Boolean) false);
        Nn();
        this.aUf.clear();
    }
}
