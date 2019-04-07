package com.baidu.swan.apps.ae;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.b.a;
import com.baidu.swan.apps.process.messaging.client.a;
/* loaded from: classes2.dex */
public final class e extends ContextWrapper {
    private static e aNZ = new e();
    public final a<b> aOa;
    public final a<? extends com.baidu.swan.apps.process.messaging.client.a> aOb;
    public final a<com.baidu.swan.apps.b.a> aOc;

    private e() {
        super(AppRuntime.getApplication());
        this.aOa = new a<>();
        this.aOb = new a().a(new a.c());
        this.aOc = new a().a(new a.C0115a());
    }

    public static e Jm() {
        return aNZ;
    }

    public synchronized boolean p(final com.baidu.swan.apps.v.b.b bVar) {
        boolean z;
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.mAppId)) {
                if (this.aOa.get() == null || !bVar.mAppId.equals(this.aOa.get().id)) {
                    terminate();
                    this.aOa.b(new b.a() { // from class: com.baidu.swan.apps.ae.e.1
                        @Override // com.baidu.swan.apps.ae.b.a
                        String id() {
                            return bVar.mAppId;
                        }
                    });
                }
                this.aOa.get().o(bVar);
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void terminate() {
        if (this.aOa.get() != null) {
            this.aOa.get().release();
            this.aOa.IT();
        }
    }
}
