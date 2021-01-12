package com.baidu.swan.apps.inlinewidget.d;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d.a.d;
import com.baidu.swan.apps.inlinewidget.d.a.e;
import com.baidu.swan.apps.inlinewidget.d.c;
/* loaded from: classes8.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a dbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.dbR = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.d.a.1
            @Override // com.baidu.swan.apps.inlinewidget.d.c.a
            public void avS() {
                if (a.this.dbf != null) {
                    a.this.dbf.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.dbR);
        this.dbe.a(new d());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.d.a.c());
        this.dbe.a(new e());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.d.a.a());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.d.a.b());
    }
}
