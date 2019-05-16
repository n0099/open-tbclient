package com.baidu.swan.apps.ae;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.b.a;
import com.baidu.swan.apps.process.messaging.client.a;
/* loaded from: classes2.dex */
public final class e extends ContextWrapper {
    private static e aQd = new e();
    public final a<b> aQe;
    public final a<? extends com.baidu.swan.apps.process.messaging.client.a> aQf;
    public final a<com.baidu.swan.apps.b.a> aQg;

    private e() {
        super(AppRuntime.getApplication());
        this.aQe = new a<>();
        this.aQf = new a().a(new a.c());
        this.aQg = new a().a(new a.C0119a());
    }

    public static e LH() {
        return aQd;
    }

    public synchronized boolean p(final com.baidu.swan.apps.v.b.b bVar) {
        boolean z;
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.getAppId())) {
                if (this.aQe.get() == null || !TextUtils.equals(bVar.getAppId(), this.aQe.get().id)) {
                    terminate();
                    this.aQe.b(new b.a() { // from class: com.baidu.swan.apps.ae.e.1
                        @Override // com.baidu.swan.apps.ae.b.a
                        String id() {
                            return bVar.getAppId();
                        }
                    });
                }
                this.aQe.get().o(bVar);
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void terminate() {
        if (this.aQe.get() != null) {
            this.aQe.get().release();
            this.aQe.Lo();
        }
    }
}
