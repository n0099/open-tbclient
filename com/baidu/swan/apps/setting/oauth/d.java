package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes11.dex */
public abstract class d {
    private Exception OP;
    private b cEn;

    protected abstract boolean aqv() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.OP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.cEn = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.OP == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d aqw() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.aqv()) {
                        d.this.aqx();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.t(e);
                }
            }
        });
        return this;
    }

    public void aqx() {
        t(null);
    }

    public void t(@Nullable Exception exc) {
        this.OP = exc;
        c.k(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cEn.b(d.this);
            }
        });
    }
}
