package com.baidu.swan.apps.r.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.c.a.d;
import com.baidu.swan.apps.r.c.a.e;
import com.baidu.swan.apps.r.c.c;
/* loaded from: classes11.dex */
final class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bVr = new c.a() { // from class: com.baidu.swan.apps.r.c.a.1
            @Override // com.baidu.swan.apps.r.c.c.a
            public void abu() {
                if (a.this.bUM != null) {
                    a.this.bUM.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.bVr);
        this.bUL.a(new d());
        this.bUL.a(new com.baidu.swan.apps.r.c.a.c());
        this.bUL.a(new e());
        this.bUL.a(new com.baidu.swan.apps.r.c.a.a());
        this.bUL.a(new com.baidu.swan.apps.r.c.a.b());
    }
}
