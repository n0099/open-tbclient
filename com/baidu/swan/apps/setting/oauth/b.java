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
    public final h<ResultDataT> dvX = new h<>();
    private final Set<com.baidu.swan.apps.ap.e.b<h<ResultDataT>>> cRc = new HashSet();
    private final LinkedList<d> dvY = new LinkedList<>();
    private boolean dvZ = false;
    private boolean dwa = false;

    protected abstract void aIF();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT bO(JSONObject jSONObject) throws JSONException;

    private void aIy() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.1
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aIG() throws Exception {
                if (b.this.aIA()) {
                    return true;
                }
                c.c("initialPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aIH();
        this.dvZ = true;
    }

    private void aIz() {
        new d() { // from class: com.baidu.swan.apps.setting.oauth.b.2
            @Override // com.baidu.swan.apps.setting.oauth.d
            protected boolean aIG() throws Exception {
                if (b.this.aIB()) {
                    return true;
                }
                c.c("finalPrepare failed", true);
                throw new OAuthException(10001);
            }
        }.a(this).aIH();
        this.dwa = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aIA() {
        return true;
    }

    protected boolean aIB() {
        return true;
    }

    public b<ResultDataT> A(com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar) {
        if (this.dvX.dwO.isCallbackAvailable()) {
            this.cRc.add(bVar);
        }
        return this;
    }

    private void aIC() {
        for (final com.baidu.swan.apps.ap.e.b<h<ResultDataT>> bVar : this.cRc) {
            c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar != null) {
                        bVar.M(b.this.dvX);
                    }
                }
            });
        }
    }

    @NonNull
    public b aID() {
        if (TaskState.INIT == aIE()) {
            a(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState aIE() {
        return this.dvX.dwO;
    }

    public void rE() {
        this.dvX.dwO = TaskState.INIT;
        this.dvZ = false;
        this.dwa = false;
    }

    public b a(@NonNull d dVar) {
        dVar.a(this);
        this.dvY.offer(dVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (dVar.isOk()) {
            prepare();
        } else {
            v(dVar.getException());
        }
    }

    private void prepare() {
        if (!TaskState.CALLING.equals(aIE())) {
            if (DEBUG) {
                c.c("IllegalState on prepare", false);
            }
        } else if (!this.dvZ) {
            aIy();
        } else if (!this.dvY.isEmpty()) {
            this.dvY.poll().aIH();
        } else if (!this.dwa) {
            aIz();
        } else {
            exec();
        }
    }

    private synchronized void exec() {
        aIF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(ResultDataT resultdatat) {
        this.dvX.mData = resultdatat;
    }

    private void a(TaskState taskState) {
        this.dvX.dwO = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        v(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.dvX.dwP = (OAuthException) exc;
        } else if (exc != null) {
            this.dvX.dwP = new OAuthException(exc, 10001);
        }
        if (!this.dvX.isOk() && DEBUG && exc != null) {
            exc.printStackTrace();
        }
        a(TaskState.FINISHED);
        c.c(toString(), false);
        aIC();
        this.cRc.clear();
    }
}
