package com.baidu.swan.apps.setting.oauth;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
public abstract class d {
    private Exception Td;
    private b dKA;

    protected abstract boolean aKH() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.Td;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(b bVar) {
        this.dKA = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.Td == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d aKI() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (d.this.aKH()) {
                        d.this.aKJ();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    d.this.x(e);
                }
            }
        });
        return this;
    }

    public void aKJ() {
        x(null);
    }

    public void x(@Nullable Exception exc) {
        this.Td = exc;
        c.e(new Runnable() { // from class: com.baidu.swan.apps.setting.oauth.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dKA.b(d.this);
            }
        });
    }
}
