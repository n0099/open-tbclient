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
    public final g<ResultDataT> aTS = new g<>();
    private final Set<com.baidu.swan.apps.an.d.a<g<ResultDataT>>> aTv = new HashSet();
    private final LinkedList<d> aTT = new LinkedList<>();
    private boolean aTU = false;
    private boolean aTV = false;

    protected abstract void MC();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT z(JSONObject jSONObject) throws JSONException;

    private void Mx() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean Dh() throws Exception {
                if (!b.this.De()) {
                    throw new OAuthException("initialPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).MD();
        this.aTU = true;
    }

    private void My() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean Dh() throws Exception {
                if (!b.this.Df()) {
                    throw new OAuthException("finalPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).MD();
        this.aTV = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean De() {
        return true;
    }

    protected boolean Df() {
        return true;
    }

    public b<ResultDataT> g(com.baidu.swan.apps.an.d.a<g<ResultDataT>> aVar) {
        if (this.aTS.aUj.isCallbackAvailable()) {
            this.aTv.add(aVar);
        }
        return this;
    }

    private void Mz() {
        for (final com.baidu.swan.apps.an.d.a<g<ResultDataT>> aVar : this.aTv) {
            c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        aVar.D(b.this.aTS);
                    }
                }
            });
        }
    }

    @NonNull
    public b MA() {
        if (TaskState.INIT == MB()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState MB() {
        return this.aTS.aUj;
    }

    public void pa() {
        this.aTS.aUj = TaskState.INIT;
        this.aTU = false;
        this.aTV = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.aTT.offer(dVar);
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
        if (!TaskState.CALLING.equals(MB())) {
            if (DEBUG) {
                c.a("IllegalState on prepare", (Boolean) false);
            }
        } else if (!this.aTU) {
            Mx();
        } else if (!this.aTT.isEmpty()) {
            this.aTT.poll().MD();
        } else if (!this.aTV) {
            My();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        MC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(ResultDataT resultdatat) {
        this.aTS.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.aTS.aUj = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        l(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.aTS.aUk = (OAuthException) exc;
        } else if (exc != null) {
            c.az("OAuthTask#finish", exc.getMessage());
            this.aTS.aUk = new OAuthException(exc, (int) SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE);
        }
        if (!this.aTS.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.a(toString(), (Boolean) false);
        Mz();
        this.aTv.clear();
    }
}
