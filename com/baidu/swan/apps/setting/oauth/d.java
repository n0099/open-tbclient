package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public abstract class d {
    private Exception RI;
    private b dLH;

    protected abstract boolean aOe() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.RI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.dLH = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.RI == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d aOf() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.aOe()) {
                        d.this.aOg();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.x(e);
                }
            }
        });
        return this;
    }

    public void aOg() {
        x(null);
    }

    public void x(@Nullable Exception exc) {
        this.RI = exc;
        c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dLH.b(d.this);
            }
        });
    }
}
