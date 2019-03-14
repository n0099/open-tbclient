package com.baidu.swan.apps.ae;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.b.a;
import com.baidu.swan.apps.process.messaging.client.a;
/* loaded from: classes2.dex */
public final class e extends ContextWrapper {
    private static e aNW = new e();
    public final a<b> aNX;
    public final a<? extends com.baidu.swan.apps.process.messaging.client.a> aNY;
    public final a<com.baidu.swan.apps.b.a> aNZ;

    private e() {
        super(AppRuntime.getApplication());
        this.aNX = new a<>();
        this.aNY = new a().a(new a.c());
        this.aNZ = new a().a(new a.C0115a());
    }

    public static e Jo() {
        return aNW;
    }

    public synchronized boolean p(final com.baidu.swan.apps.v.b.b bVar) {
        boolean z;
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.mAppId)) {
                if (this.aNX.get() == null || !bVar.mAppId.equals(this.aNX.get().id)) {
                    terminate();
                    this.aNX.b(new b.a() { // from class: com.baidu.swan.apps.ae.e.1
                        @Override // com.baidu.swan.apps.ae.b.a
                        String id() {
                            return bVar.mAppId;
                        }
                    });
                }
                this.aNX.get().o(bVar);
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized void terminate() {
        if (this.aNX.get() != null) {
            this.aNX.get().release();
            this.aNX.IV();
        }
    }
}
