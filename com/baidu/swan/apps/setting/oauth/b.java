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
    public final g<ResultDataT> bnM = new g<>();
    private final Set<com.baidu.swan.apps.an.d.a<g<ResultDataT>>> bnp = new HashSet();
    private final LinkedList<d> bnN = new LinkedList<>();
    private boolean bnO = false;
    private boolean bnP = false;

    protected abstract void Sm();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT Y(JSONObject jSONObject) throws JSONException;

    private void Sh() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean IP() throws Exception {
                if (!b.this.IM()) {
                    throw new OAuthException("initialPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).So();
        this.bnO = true;
    }

    private void Si() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean IP() throws Exception {
                if (!b.this.IN()) {
                    throw new OAuthException("finalPrepare failed", 10001);
                }
                return true;
            }
        }.a(this).So();
        this.bnP = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean IM() {
        return true;
    }

    protected boolean IN() {
        return true;
    }

    public b<ResultDataT> g(com.baidu.swan.apps.an.d.a<g<ResultDataT>> aVar) {
        if (this.bnM.bod.isCallbackAvailable()) {
            this.bnp.add(aVar);
        }
        return this;
    }

    private void Sj() {
        for (final com.baidu.swan.apps.an.d.a<g<ResultDataT>> aVar : this.bnp) {
            c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        aVar.B(b.this.bnM);
                    }
                }
            });
        }
    }

    @NonNull
    public b Sk() {
        if (TaskState.INIT == Sl()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState Sl() {
        return this.bnM.bod;
    }

    public void kr() {
        this.bnM.bod = TaskState.INIT;
        this.bnO = false;
        this.bnP = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.bnN.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            k(dVar.Sn());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(Sl())) {
            if (DEBUG) {
                c.a("IllegalState on prepare", (Boolean) false);
            }
        } else if (!this.bnO) {
            Sh();
        } else if (!this.bnN.isEmpty()) {
            this.bnN.poll().So();
        } else if (!this.bnP) {
            Si();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        Sm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(ResultDataT resultdatat) {
        this.bnM.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.bnM.bod = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        k(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.bnM.boe = (OAuthException) exc;
        } else if (exc != null) {
            c.aH("OAuthTask#finish", exc.getMessage());
            this.bnM.boe = new OAuthException(exc, 11001);
        }
        if (!this.bnM.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.a(toString(), (Boolean) false);
        Sj();
        this.bnp.clear();
    }
}
