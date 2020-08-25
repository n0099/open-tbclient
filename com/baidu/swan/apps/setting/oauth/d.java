package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes8.dex */
public abstract class d {
    private Exception Qb;
    private b cVd;

    protected abstract boolean aBB() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.Qb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.cVd = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.Qb == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d aBC() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.aBB()) {
                        d.this.aBD();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.w(e);
                }
            }
        });
        return this;
    }

    public void aBD() {
        w(null);
    }

    public void w(@Nullable Exception exc) {
        this.Qb = exc;
        c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cVd.b(d.this);
            }
        });
    }
}
