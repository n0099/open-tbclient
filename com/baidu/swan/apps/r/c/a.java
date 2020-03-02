package com.baidu.swan.apps.r.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.c.a.d;
import com.baidu.swan.apps.r.c.a.e;
import com.baidu.swan.apps.r.c.c;
/* loaded from: classes11.dex */
final class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bwY = new c.a() { // from class: com.baidu.swan.apps.r.c.a.1
            @Override // com.baidu.swan.apps.r.c.c.a
            public void TC() {
                if (a.this.bwt != null) {
                    a.this.bwt.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.bwY);
        this.bws.a(new d());
        this.bws.a(new com.baidu.swan.apps.r.c.a.c());
        this.bws.a(new e());
        this.bws.a(new com.baidu.swan.apps.r.c.a.a());
        this.bws.a(new com.baidu.swan.apps.r.c.a.b());
    }
}
