package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class d {
    private b bop;
    private Exception tb;

    protected abstract boolean IO() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception Sl() {
        return this.tb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.bop = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.tb == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d Sm() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.IO()) {
                        d.this.Sn();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.m(e);
                }
            }
        });
        return this;
    }

    public void Sn() {
        m(null);
    }

    public void m(@Nullable Exception exc) {
        this.tb = exc;
        c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.bop.b(d.this);
            }
        });
    }
}
