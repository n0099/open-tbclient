package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class d {
    private b bnX;
    private Exception sB;

    protected abstract boolean IP() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception Sn() {
        return this.sB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.bnX = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.sB == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d So() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.IP()) {
                        d.this.Sp();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.l(e);
                }
            }
        });
        return this;
    }

    public void Sp() {
        l(null);
    }

    public void l(@Nullable Exception exc) {
        this.sB = exc;
        c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.bnX.b(d.this);
            }
        });
    }
}
