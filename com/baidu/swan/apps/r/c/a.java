package com.baidu.swan.apps.r.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.c.a.d;
import com.baidu.swan.apps.r.c.a.e;
import com.baidu.swan.apps.r.c.c;
/* loaded from: classes10.dex */
final class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bsN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bsN = new c.a() { // from class: com.baidu.swan.apps.r.c.a.1
            @Override // com.baidu.swan.apps.r.c.c.a
            public void Rm() {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.bsN);
        this.bsh.a(new d());
        this.bsh.a(new com.baidu.swan.apps.r.c.a.c());
        this.bsh.a(new e());
        this.bsh.a(new com.baidu.swan.apps.r.c.a.a());
        this.bsh.a(new com.baidu.swan.apps.r.c.a.b());
    }
}
