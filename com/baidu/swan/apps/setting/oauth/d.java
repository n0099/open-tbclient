package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes11.dex */
public abstract class d {
    private Exception OC;
    private b csl;

    protected abstract boolean amt() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.OC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.csl = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.OC == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d amu() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.amt()) {
                        d.this.amv();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.l(e);
                }
            }
        });
        return this;
    }

    public void amv() {
        l(null);
    }

    public void l(@Nullable Exception exc) {
        this.OC = exc;
        c.j(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.csl.b(d.this);
            }
        });
    }
}
