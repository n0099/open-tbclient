package com.baidu.swan.apps.ae;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.b.a;
import com.baidu.swan.apps.process.messaging.client.a;
/* loaded from: classes2.dex */
public final class e extends ContextWrapper {
    private static e aNV = new e();
    public final a<b> aNW;
    public final a<? extends com.baidu.swan.apps.process.messaging.client.a> aNX;
    public final a<com.baidu.swan.apps.b.a> aNY;

    private e() {
        super(AppRuntime.getApplication());
        this.aNW = new a<>();
        this.aNX = new a().a(new a.c());
        this.aNY = new a().a(new a.C0085a());
    }

    public static e Jo() {
        return aNV;
    }

    public synchronized boolean p(final com.baidu.swan.apps.v.b.b bVar) {
        boolean z;
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.mAppId)) {
                if (this.aNW.get() == null || !bVar.mAppId.equals(this.aNW.get().id)) {
                    terminate();
                    this.aNW.b(new b.a() { // from class: com.baidu.swan.apps.ae.e.1
                        @Override // com.baidu.swan.apps.ae.b.a
                        String id() {
                            return bVar.mAppId;
                        }
                    });
                }
                this.aNW.get().o(bVar);
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void terminate() {
        if (this.aNW.get() != null) {
            this.aNW.get().release();
            this.aNW.IV();
        }
    }
}
