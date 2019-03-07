package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class d {
    private Exception HZ;
    private b aRk;

    protected abstract boolean Ch() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.HZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.aRk = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.HZ == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d Kf() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.Ch()) {
                        d.this.Kg();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.m(e);
                }
            }
        });
        return this;
    }

    public void Kg() {
        m(null);
    }

    public void m(@Nullable Exception exc) {
        this.HZ = exc;
        c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.aRk.b(d.this);
            }
        });
    }
}
