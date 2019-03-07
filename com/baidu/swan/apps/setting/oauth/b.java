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
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public final g<ResultDataT> aQZ = new g<>();
    private final Set<com.baidu.swan.apps.an.c.a<g<ResultDataT>>> aQC = new HashSet();
    private final LinkedList<d> aRa = new LinkedList<>();
    private boolean aRb = false;
    private boolean aRc = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT C(JSONObject jSONObject) throws JSONException;

    protected abstract void Ke();

    private void JZ() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean Ch() throws Exception {
                if (!b.this.Ce()) {
                    throw new OAuthException("initialPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).Kf();
        this.aRb = true;
    }

    private void Ka() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean Ch() throws Exception {
                if (!b.this.Cf()) {
                    throw new OAuthException("finalPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).Kf();
        this.aRc = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ce() {
        return true;
    }

    protected boolean Cf() {
        return true;
    }

    public b<ResultDataT> c(com.baidu.swan.apps.an.c.a<g<ResultDataT>> aVar) {
        if (this.aQZ.aRp.isCallbackAvailable()) {
            this.aQC.add(aVar);
        }
        return this;
    }

    private void Kb() {
        for (final com.baidu.swan.apps.an.c.a<g<ResultDataT>> aVar : this.aQC) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        aVar.D(b.this.aQZ);
                    }
                }
            });
        }
    }

    @NonNull
    public b Kc() {
        if (TaskState.INIT == Kd()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState Kd() {
        return this.aQZ.aRp;
    }

    public void qf() {
        this.aQZ.aRp = TaskState.INIT;
        this.aRb = false;
        this.aRc = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.aRa.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            l(dVar.getException());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(Kd())) {
            if (DEBUG) {
                c.a("IllegalState on prepare", (Boolean) false);
            }
        } else if (!this.aRb) {
            JZ();
        } else if (!this.aRa.isEmpty()) {
            this.aRa.poll().Kf();
        } else if (!this.aRc) {
            Ka();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        Ke();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(ResultDataT resultdatat) {
        this.aQZ.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.aQZ.aRp = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        l(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.aQZ.aRq = (OAuthException) exc;
        } else if (exc != null) {
            this.aQZ.aRq = new OAuthException(exc, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        }
        if (!this.aQZ.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.a(toString(), (Boolean) false);
        Kb();
        this.aQC.clear();
    }
}
