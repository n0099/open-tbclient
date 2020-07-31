package com.baidu.swan.apps.p.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.p.d.a.d;
import com.baidu.swan.apps.p.d.a.e;
import com.baidu.swan.apps.p.d.c;
/* loaded from: classes7.dex */
final class a extends com.baidu.swan.apps.p.b<c> {
    private final c.a cmG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cmG = new c.a() { // from class: com.baidu.swan.apps.p.d.a.1
            @Override // com.baidu.swan.apps.p.d.c.a
            public void agL() {
                if (a.this.clZ != null) {
                    a.this.clZ.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.cmG);
        this.clY.a(new d());
        this.clY.a(new com.baidu.swan.apps.p.d.a.c());
        this.clY.a(new e());
        this.clY.a(new com.baidu.swan.apps.p.d.a.a());
        this.clY.a(new com.baidu.swan.apps.p.d.a.b());
    }
}
