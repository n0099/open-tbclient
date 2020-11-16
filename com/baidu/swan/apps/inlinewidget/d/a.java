package com.baidu.swan.apps.inlinewidget.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d.a.d;
import com.baidu.swan.apps.inlinewidget.d.a.e;
import com.baidu.swan.apps.inlinewidget.d.c;
/* loaded from: classes7.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cUP = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.d.a.1
            @Override // com.baidu.swan.apps.inlinewidget.d.c.a
            public void avm() {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.cUP);
        this.cUc.a(new d());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.d.a.c());
        this.cUc.a(new e());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.d.a.a());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.d.a.b());
    }
}
