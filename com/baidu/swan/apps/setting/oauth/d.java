package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes10.dex */
public abstract class d {
    private Exception QL;
    private b drR;

    protected abstract boolean aGO() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.QL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.drR = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.QL == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d aGP() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.aGO()) {
                        d.this.aGQ();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.w(e);
                }
            }
        });
        return this;
    }

    public void aGQ() {
        w(null);
    }

    public void w(@Nullable Exception exc) {
        this.QL = exc;
        c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.drR.b(d.this);
            }
        });
    }
}
