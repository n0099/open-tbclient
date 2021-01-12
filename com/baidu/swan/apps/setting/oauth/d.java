package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
public abstract class d {
    private Exception RG;
    private b dGV;

    protected abstract boolean aKl() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.RG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.dGV = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.RG == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d aKm() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.aKl()) {
                        d.this.aKn();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.x(e);
                }
            }
        });
        return this;
    }

    public void aKn() {
        x(null);
    }

    public void x(@Nullable Exception exc) {
        this.RG = exc;
        c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dGV.b(d.this);
            }
        });
    }
}
