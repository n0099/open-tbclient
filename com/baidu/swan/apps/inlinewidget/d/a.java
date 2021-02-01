package com.baidu.swan.apps.inlinewidget.d;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d.a.d;
import com.baidu.swan.apps.inlinewidget.d.a.e;
import com.baidu.swan.apps.inlinewidget.d.c;
/* loaded from: classes9.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a dee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.dee = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.d.a.1
            @Override // com.baidu.swan.apps.inlinewidget.d.c.a
            public void awq() {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.dee);
        this.ddq.a(new d());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.d.a.c());
        this.ddq.a(new e());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.d.a.a());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.d.a.b());
    }
}
