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
    public final g<ResultDataT> aRd = new g<>();
    private final Set<com.baidu.swan.apps.an.c.a<g<ResultDataT>>> aQG = new HashSet();
    private final LinkedList<d> aRe = new LinkedList<>();
    private boolean aRf = false;
    private boolean aRg = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT C(JSONObject jSONObject) throws JSONException;

    protected abstract void Kc();

    private void JX() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean Cf() throws Exception {
                if (!b.this.Cc()) {
                    throw new OAuthException("initialPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).Kd();
        this.aRf = true;
    }

    private void JY() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean Cf() throws Exception {
                if (!b.this.Cd()) {
                    throw new OAuthException("finalPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).Kd();
        this.aRg = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Cc() {
        return true;
    }

    protected boolean Cd() {
        return true;
    }

    public b<ResultDataT> c(com.baidu.swan.apps.an.c.a<g<ResultDataT>> aVar) {
        if (this.aRd.aRt.isCallbackAvailable()) {
            this.aQG.add(aVar);
        }
        return this;
    }

    private void JZ() {
        for (final com.baidu.swan.apps.an.c.a<g<ResultDataT>> aVar : this.aQG) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        aVar.D(b.this.aRd);
                    }
                }
            });
        }
    }

    @NonNull
    public b Ka() {
        if (TaskState.INIT == Kb()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState Kb() {
        return this.aRd.aRt;
    }

    public void qf() {
        this.aRd.aRt = TaskState.INIT;
        this.aRf = false;
        this.aRg = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.aRe.offer(dVar);
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
        if (!TaskState.CALLING.equals(Kb())) {
            if (DEBUG) {
                c.a("IllegalState on prepare", (Boolean) false);
            }
        } else if (!this.aRf) {
            JX();
        } else if (!this.aRe.isEmpty()) {
            this.aRe.poll().Kd();
        } else if (!this.aRg) {
            JY();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        Kc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(ResultDataT resultdatat) {
        this.aRd.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.aRd.aRt = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        l(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.aRd.aRu = (OAuthException) exc;
        } else if (exc != null) {
            this.aRd.aRu = new OAuthException(exc, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        }
        if (!this.aRd.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.a(toString(), (Boolean) false);
        JZ();
        this.aQG.clear();
    }
}
