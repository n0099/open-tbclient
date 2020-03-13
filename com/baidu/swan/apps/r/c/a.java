package com.baidu.swan.apps.r.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.c.a.d;
import com.baidu.swan.apps.r.c.a.e;
import com.baidu.swan.apps.r.c.c;
/* loaded from: classes11.dex */
final class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bwZ = new c.a() { // from class: com.baidu.swan.apps.r.c.a.1
            @Override // com.baidu.swan.apps.r.c.c.a
            public void TC() {
                if (a.this.bwu != null) {
                    a.this.bwu.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.bwZ);
        this.bwt.a(new d());
        this.bwt.a(new com.baidu.swan.apps.r.c.a.c());
        this.bwt.a(new e());
        this.bwt.a(new com.baidu.swan.apps.r.c.a.a());
        this.bwt.a(new com.baidu.swan.apps.r.c.a.b());
    }
}
