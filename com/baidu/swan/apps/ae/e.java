package com.baidu.swan.apps.ae;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.b.a;
import com.baidu.swan.apps.process.messaging.client.a;
/* loaded from: classes2.dex */
public final class e extends ContextWrapper {
    private static e aOa = new e();
    public final a<b> aOb;
    public final a<? extends com.baidu.swan.apps.process.messaging.client.a> aOc;
    public final a<com.baidu.swan.apps.b.a> aOd;

    private e() {
        super(AppRuntime.getApplication());
        this.aOb = new a<>();
        this.aOc = new a().a(new a.c());
        this.aOd = new a().a(new a.C0115a());
    }

    public static e Jm() {
        return aOa;
    }

    public synchronized boolean p(final com.baidu.swan.apps.v.b.b bVar) {
        boolean z;
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.mAppId)) {
                if (this.aOb.get() == null || !bVar.mAppId.equals(this.aOb.get().id)) {
                    terminate();
                    this.aOb.b(new b.a() { // from class: com.baidu.swan.apps.ae.e.1
                        @Override // com.baidu.swan.apps.ae.b.a
                        String id() {
                            return bVar.mAppId;
                        }
                    });
                }
                this.aOb.get().o(bVar);
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void terminate() {
        if (this.aOb.get() != null) {
            this.aOb.get().release();
            this.aOb.IT();
        }
    }
}
