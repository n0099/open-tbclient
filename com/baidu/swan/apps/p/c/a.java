package com.baidu.swan.apps.p.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.p.c.a.d;
import com.baidu.swan.apps.p.c.a.e;
import com.baidu.swan.apps.p.c.c;
/* loaded from: classes11.dex */
final class a extends com.baidu.swan.apps.p.b<c> {
    private final c.a cfN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cfN = new c.a() { // from class: com.baidu.swan.apps.p.c.a.1
            @Override // com.baidu.swan.apps.p.c.c.a
            public void aeu() {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.cfN);
        this.cfh.a(new d());
        this.cfh.a(new com.baidu.swan.apps.p.c.a.c());
        this.cfh.a(new e());
        this.cfh.a(new com.baidu.swan.apps.p.c.a.a());
        this.cfh.a(new com.baidu.swan.apps.p.c.a.b());
    }
}
