package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class d {
    private Exception FP;
    private b aVl;

    protected abstract boolean DU() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception Nv() {
        return this.FP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.aVl = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.FP == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d Nw() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.DU()) {
                        d.this.Nx();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.m(e);
                }
            }
        });
        return this;
    }

    public void Nx() {
        m(null);
    }

    public void m(@Nullable Exception exc) {
        this.FP = exc;
        c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.aVl.b(d.this);
            }
        });
    }
}
