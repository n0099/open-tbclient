package com.baidu.swan.apps.inlinewidget.d;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d.a.d;
import com.baidu.swan.apps.inlinewidget.d.a.e;
import com.baidu.swan.apps.inlinewidget.d.c;
/* loaded from: classes8.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a dfG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.dfG = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.d.a.1
            @Override // com.baidu.swan.apps.inlinewidget.d.c.a
            public void awt() {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.dfG);
        this.deT.a(new d());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.d.a.c());
        this.deT.a(new e());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.d.a.a());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.d.a.b());
    }
}
