package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes25.dex */
public abstract class d {
    private Exception RF;
    private b dDd;

    protected abstract boolean aLO() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.RF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.dDd = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.RF == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d aLP() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.aLO()) {
                        d.this.aLQ();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.w(e);
                }
            }
        });
        return this;
    }

    public void aLQ() {
        w(null);
    }

    public void w(@Nullable Exception exc) {
        this.RF = exc;
        c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dDd.b(d.this);
            }
        });
    }
}
