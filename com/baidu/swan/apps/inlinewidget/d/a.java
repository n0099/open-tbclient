package com.baidu.swan.apps.inlinewidget.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d.a.d;
import com.baidu.swan.apps.inlinewidget.d.a.e;
import com.baidu.swan.apps.inlinewidget.d.c;
/* loaded from: classes3.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cwe = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.d.a.1
            @Override // com.baidu.swan.apps.inlinewidget.d.c.a
            public void aoN() {
                if (a.this.cvr != null) {
                    a.this.cvr.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.cwe);
        this.cvq.a(new d());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.d.a.c());
        this.cvq.a(new e());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.d.a.a());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.d.a.b());
    }
}
