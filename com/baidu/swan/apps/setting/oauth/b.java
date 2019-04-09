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
    public final g<ResultDataT> aRe = new g<>();
    private final Set<com.baidu.swan.apps.an.c.a<g<ResultDataT>>> aQH = new HashSet();
    private final LinkedList<d> aRf = new LinkedList<>();
    private boolean aRg = false;
    private boolean aRh = false;

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
        this.aRg = true;
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
        this.aRh = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Cc() {
        return true;
    }

    protected boolean Cd() {
        return true;
    }

    public b<ResultDataT> c(com.baidu.swan.apps.an.c.a<g<ResultDataT>> aVar) {
        if (this.aRe.aRu.isCallbackAvailable()) {
            this.aQH.add(aVar);
        }
        return this;
    }

    private void JZ() {
        for (final com.baidu.swan.apps.an.c.a<g<ResultDataT>> aVar : this.aQH) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        aVar.D(b.this.aRe);
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
        return this.aRe.aRu;
    }

    public void qf() {
        this.aRe.aRu = TaskState.INIT;
        this.aRg = false;
        this.aRh = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.aRf.offer(dVar);
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
        } else if (!this.aRg) {
            JX();
        } else if (!this.aRf.isEmpty()) {
            this.aRf.poll().Kd();
        } else if (!this.aRh) {
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
        this.aRe.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.aRe.aRu = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        l(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.aRe.aRv = (OAuthException) exc;
        } else if (exc != null) {
            this.aRe.aRv = new OAuthException(exc, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        }
        if (!this.aRe.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.a(toString(), (Boolean) false);
        JZ();
        this.aQH.clear();
    }
}
