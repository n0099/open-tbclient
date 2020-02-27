package com.baidu.swan.apps.r.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.c.a.d;
import com.baidu.swan.apps.r.c.a.e;
import com.baidu.swan.apps.r.c.c;
/* loaded from: classes11.dex */
final class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bwX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bwX = new c.a() { // from class: com.baidu.swan.apps.r.c.a.1
            @Override // com.baidu.swan.apps.r.c.c.a
            public void TA() {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.bwX);
        this.bwr.a(new d());
        this.bwr.a(new com.baidu.swan.apps.r.c.a.c());
        this.bwr.a(new e());
        this.bwr.a(new com.baidu.swan.apps.r.c.a.a());
        this.bwr.a(new com.baidu.swan.apps.r.c.a.b());
    }
}
