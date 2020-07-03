package com.baidu.swan.apps.p.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.p.c.a.d;
import com.baidu.swan.apps.p.c.a.e;
import com.baidu.swan.apps.p.c.c;
/* loaded from: classes11.dex */
final class a extends com.baidu.swan.apps.p.b<c> {
    private final c.a ckB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.ckB = new c.a() { // from class: com.baidu.swan.apps.p.c.a.1
            @Override // com.baidu.swan.apps.p.c.c.a
            public void afA() {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.ckB);
        this.cjV.a(new d());
        this.cjV.a(new com.baidu.swan.apps.p.c.a.c());
        this.cjV.a(new e());
        this.cjV.a(new com.baidu.swan.apps.p.c.a.a());
        this.cjV.a(new com.baidu.swan.apps.p.c.a.b());
    }
}
