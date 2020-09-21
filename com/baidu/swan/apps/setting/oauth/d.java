package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class d {
    private Exception Qt;
    private b cXh;

    protected abstract boolean aCl() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.Qt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.cXh = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.Qt == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d aCm() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.aCl()) {
                        d.this.aCn();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.w(e);
                }
            }
        });
        return this;
    }

    public void aCn() {
        w(null);
    }

    public void w(@Nullable Exception exc) {
        this.Qt = exc;
        c.h(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cXh.b(d.this);
            }
        });
    }
}
