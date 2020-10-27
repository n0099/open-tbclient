package com.baidu.swan.apps.inlinewidget.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d.a.d;
import com.baidu.swan.apps.inlinewidget.d.a.e;
import com.baidu.swan.apps.inlinewidget.d.c;
/* loaded from: classes10.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cQG = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.d.a.1
            @Override // com.baidu.swan.apps.inlinewidget.d.c.a
            public void atu() {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.cQG);
        this.cPT.a(new d());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.d.a.c());
        this.cPT.a(new e());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.d.a.a());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.d.a.b());
    }
}
