package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes7.dex */
public abstract class d {
    private Exception Pr;
    private b cMh;

    protected abstract boolean att() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.Pr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.cMh = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.Pr == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d atu() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.att()) {
                        d.this.atv();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.t(e);
                }
            }
        });
        return this;
    }

    public void atv() {
        t(null);
    }

    public void t(@Nullable Exception exc) {
        this.Pr = exc;
        c.k(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cMh.b(d.this);
            }
        });
    }
}
