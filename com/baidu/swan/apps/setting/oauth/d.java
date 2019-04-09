package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class d {
    private Exception HZ;
    private b aRp;

    protected abstract boolean Cf() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.HZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.aRp = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.HZ == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d Kd() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.Cf()) {
                        d.this.Ke();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.m(e);
                }
            }
        });
        return this;
    }

    public void Ke() {
        m(null);
    }

    public void m(@Nullable Exception exc) {
        this.HZ = exc;
        c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.aRp.b(d.this);
            }
        });
    }
}
