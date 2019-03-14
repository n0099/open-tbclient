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
    public final g<ResultDataT> aRa = new g<>();
    private final Set<com.baidu.swan.apps.an.c.a<g<ResultDataT>>> aQD = new HashSet();
    private final LinkedList<d> aRb = new LinkedList<>();
    private boolean aRc = false;
    private boolean aRd = false;

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
        this.aRc = true;
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
        this.aRd = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ce() {
        return true;
    }

    protected boolean Cf() {
        return true;
    }

    public b<ResultDataT> c(com.baidu.swan.apps.an.c.a<g<ResultDataT>> aVar) {
        if (this.aRa.aRq.isCallbackAvailable()) {
            this.aQD.add(aVar);
        }
        return this;
    }

    private void Kb() {
        for (final com.baidu.swan.apps.an.c.a<g<ResultDataT>> aVar : this.aQD) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        aVar.D(b.this.aRa);
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
        return this.aRa.aRq;
    }

    public void qf() {
        this.aRa.aRq = TaskState.INIT;
        this.aRc = false;
        this.aRd = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.aRb.offer(dVar);
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
        } else if (!this.aRc) {
            JZ();
        } else if (!this.aRb.isEmpty()) {
            this.aRb.poll().Kf();
        } else if (!this.aRd) {
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
        this.aRa.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.aRa.aRq = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        l(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.aRa.aRr = (OAuthException) exc;
        } else if (exc != null) {
            this.aRa.aRr = new OAuthException(exc, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        }
        if (!this.aRa.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.a(toString(), (Boolean) false);
        Kb();
        this.aQD.clear();
    }
}
