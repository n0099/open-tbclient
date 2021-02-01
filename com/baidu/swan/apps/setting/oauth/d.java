package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public abstract class d {
    private Exception RE;
    private b dIZ;

    protected abstract boolean aKE() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.RE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.dIZ = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.RE == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d aKF() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.aKE()) {
                        d.this.aKG();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.x(e);
                }
            }
        });
        return this;
    }

    public void aKG() {
        x(null);
    }

    public void x(@Nullable Exception exc) {
        this.RE = exc;
        c.f(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dIZ.b(d.this);
            }
        });
    }
}
