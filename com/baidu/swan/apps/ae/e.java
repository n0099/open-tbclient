package com.baidu.swan.apps.ae;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.b.a;
import com.baidu.swan.apps.process.messaging.client.a;
/* loaded from: classes2.dex */
public final class e extends ContextWrapper {
    private static e bkp = new e();
    public final a<b> bkq;
    public final a<? extends com.baidu.swan.apps.process.messaging.client.a> bkr;
    public final a<com.baidu.swan.apps.b.a> bks;

    private e() {
        super(AppRuntime.getApplication());
        this.bkq = new a<>();
        this.bkr = new a().a(new a.c());
        this.bks = new a().a(new a.C0162a());
    }

    public static e Rr() {
        return bkp;
    }

    public synchronized boolean p(final com.baidu.swan.apps.v.b.b bVar) {
        boolean z;
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.getAppId())) {
                if (this.bkq.get() == null || !TextUtils.equals(bVar.getAppId(), this.bkq.get().id)) {
                    terminate();
                    this.bkq.b(new b.a() { // from class: com.baidu.swan.apps.ae.e.1
                        @Override // com.baidu.swan.apps.ae.b.a
                        String Ro() {
                            return bVar.getAppId();
                        }
                    });
                }
                this.bkq.get().o(bVar);
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void terminate() {
        if (this.bkq.get() != null) {
            this.bkq.get().release();
            this.bkq.QX();
        }
    }
}
