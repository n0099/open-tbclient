package com.baidu.swan.apps.ae;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.b.a;
import com.baidu.swan.apps.process.messaging.client.a;
/* loaded from: classes2.dex */
public final class e extends ContextWrapper {
    private static e aQN = new e();
    public final a<b> aQO;
    public final a<? extends com.baidu.swan.apps.process.messaging.client.a> aQP;
    public final a<com.baidu.swan.apps.b.a> aQQ;

    private e() {
        super(AppRuntime.getApplication());
        this.aQO = new a<>();
        this.aQP = new a().a(new a.c());
        this.aQQ = new a().a(new a.C0116a());
    }

    public static e Mv() {
        return aQN;
    }

    public synchronized boolean p(final com.baidu.swan.apps.v.b.b bVar) {
        boolean z;
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.getAppId())) {
                if (this.aQO.get() == null || !TextUtils.equals(bVar.getAppId(), this.aQO.get().id)) {
                    terminate();
                    this.aQO.b(new b.a() { // from class: com.baidu.swan.apps.ae.e.1
                        @Override // com.baidu.swan.apps.ae.b.a
                        String Ms() {
                            return bVar.getAppId();
                        }
                    });
                }
                this.aQO.get().o(bVar);
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void terminate() {
        if (this.aQO.get() != null) {
            this.aQO.get().release();
            this.aQO.Mb();
        }
    }
}
