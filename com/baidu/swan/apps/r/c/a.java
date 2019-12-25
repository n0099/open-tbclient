package com.baidu.swan.apps.r.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.c.a.d;
import com.baidu.swan.apps.r.c.a.e;
import com.baidu.swan.apps.r.c.c;
/* loaded from: classes9.dex */
final class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a brZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.brZ = new c.a() { // from class: com.baidu.swan.apps.r.c.a.1
            @Override // com.baidu.swan.apps.r.c.c.a
            public void QQ() {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.brZ);
        this.brt.a(new d());
        this.brt.a(new com.baidu.swan.apps.r.c.a.c());
        this.brt.a(new e());
        this.brt.a(new com.baidu.swan.apps.r.c.a.a());
        this.brt.a(new com.baidu.swan.apps.r.c.a.b());
    }
}
