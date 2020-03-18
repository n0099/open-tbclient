package com.baidu.swan.apps.r.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.c.a.d;
import com.baidu.swan.apps.r.c.a.e;
import com.baidu.swan.apps.r.c.c;
/* loaded from: classes11.dex */
final class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bxl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bxl = new c.a() { // from class: com.baidu.swan.apps.r.c.a.1
            @Override // com.baidu.swan.apps.r.c.c.a
            public void TF() {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.bxl);
        this.bwF.a(new d());
        this.bwF.a(new com.baidu.swan.apps.r.c.a.c());
        this.bwF.a(new e());
        this.bwF.a(new com.baidu.swan.apps.r.c.a.a());
        this.bwF.a(new com.baidu.swan.apps.r.c.a.b());
    }
}
