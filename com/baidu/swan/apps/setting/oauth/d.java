package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes10.dex */
public abstract class d {
    private b bPe;
    private Exception vs;

    protected abstract boolean abV() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.vs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.bPe = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.vs == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d abW() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.abV()) {
                        d.this.abX();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.l(e);
                }
            }
        });
        return this;
    }

    public void abX() {
        l(null);
    }

    public void l(@Nullable Exception exc) {
        this.vs = exc;
        c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.bPe.b(d.this);
            }
        });
    }
}
