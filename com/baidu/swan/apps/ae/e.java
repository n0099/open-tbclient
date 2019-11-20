package com.baidu.swan.apps.ae;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.b.a;
import com.baidu.swan.apps.process.messaging.client.a;
/* loaded from: classes2.dex */
public final class e extends ContextWrapper {
    private static e bjX = new e();
    public final a<b> bjY;
    public final a<? extends com.baidu.swan.apps.process.messaging.client.a> bjZ;
    public final a<com.baidu.swan.apps.b.a> bka;

    private e() {
        super(AppRuntime.getApplication());
        this.bjY = new a<>();
        this.bjZ = new a().a(new a.c());
        this.bka = new a().a(new a.C0162a());
    }

    public static e Rt() {
        return bjX;
    }

    public synchronized boolean p(final com.baidu.swan.apps.v.b.b bVar) {
        boolean z;
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.getAppId())) {
                if (this.bjY.get() == null || !TextUtils.equals(bVar.getAppId(), this.bjY.get().id)) {
                    terminate();
                    this.bjY.b(new b.a() { // from class: com.baidu.swan.apps.ae.e.1
                        @Override // com.baidu.swan.apps.ae.b.a
                        String Rq() {
                            return bVar.getAppId();
                        }
                    });
                }
                this.bjY.get().o(bVar);
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void terminate() {
        if (this.bjY.get() != null) {
            this.bjY.get().release();
            this.bjY.QY();
        }
    }
}
