package com.baidu.swan.apps.ae;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.b.a;
import com.baidu.swan.apps.process.messaging.client.a;
/* loaded from: classes2.dex */
public final class e extends ContextWrapper {
    private static e aRl = new e();
    public final a<b> aRm;
    public final a<? extends com.baidu.swan.apps.process.messaging.client.a> aRn;
    public final a<com.baidu.swan.apps.b.a> aRo;

    private e() {
        super(AppRuntime.getApplication());
        this.aRm = new a<>();
        this.aRn = new a().a(new a.c());
        this.aRo = new a().a(new a.C0130a());
    }

    public static e Mz() {
        return aRl;
    }

    public synchronized boolean p(final com.baidu.swan.apps.v.b.b bVar) {
        boolean z;
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.getAppId())) {
                if (this.aRm.get() == null || !TextUtils.equals(bVar.getAppId(), this.aRm.get().id)) {
                    terminate();
                    this.aRm.b(new b.a() { // from class: com.baidu.swan.apps.ae.e.1
                        @Override // com.baidu.swan.apps.ae.b.a
                        String Mw() {
                            return bVar.getAppId();
                        }
                    });
                }
                this.aRm.get().o(bVar);
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void terminate() {
        if (this.aRm.get() != null) {
            this.aRm.get().release();
            this.aRm.Mf();
        }
    }
}
