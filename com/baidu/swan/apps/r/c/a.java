package com.baidu.swan.apps.r.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.c.a.d;
import com.baidu.swan.apps.r.c.a.e;
import com.baidu.swan.apps.r.c.c;
/* loaded from: classes11.dex */
final class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bVx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bVx = new c.a() { // from class: com.baidu.swan.apps.r.c.a.1
            @Override // com.baidu.swan.apps.r.c.c.a
            public void abt() {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.bVx);
        this.bUR.a(new d());
        this.bUR.a(new com.baidu.swan.apps.r.c.a.c());
        this.bUR.a(new e());
        this.bUR.a(new com.baidu.swan.apps.r.c.a.a());
        this.bUR.a(new com.baidu.swan.apps.r.c.a.b());
    }
}
