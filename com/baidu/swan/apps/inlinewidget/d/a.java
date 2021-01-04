package com.baidu.swan.apps.inlinewidget.d;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d.a.d;
import com.baidu.swan.apps.inlinewidget.d.a.e;
import com.baidu.swan.apps.inlinewidget.d.c;
/* loaded from: classes9.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a dgG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.dgG = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.d.a.1
            @Override // com.baidu.swan.apps.inlinewidget.d.c.a
            public void azL() {
                if (a.this.dfU != null) {
                    a.this.dfU.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.dgG);
        this.dfT.a(new d());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.d.a.c());
        this.dfT.a(new e());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.d.a.a());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.d.a.b());
    }
}
