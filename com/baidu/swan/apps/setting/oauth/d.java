package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes11.dex */
public abstract class d {
    private b bTj;
    private Exception vJ;

    protected abstract boolean aej() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.vJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.bTj = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.vJ == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d aek() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.aej()) {
                        d.this.ael();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.l(e);
                }
            }
        });
        return this;
    }

    public void ael() {
        l(null);
    }

    public void l(@Nullable Exception exc) {
        this.vJ = exc;
        c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.bTj.b(d.this);
            }
        });
    }
}
