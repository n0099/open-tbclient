package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class d {
    private Exception FI;
    private b aUd;

    protected abstract boolean Dh() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.FI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.aUd = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.FI == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d MD() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.Dh()) {
                        d.this.ME();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.m(e);
                }
            }
        });
        return this;
    }

    public void ME() {
        m(null);
    }

    public void m(@Nullable Exception exc) {
        this.FI = exc;
        c.g(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.aUd.b(d.this);
            }
        });
    }
}
