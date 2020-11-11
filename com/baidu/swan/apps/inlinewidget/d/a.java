package com.baidu.swan.apps.inlinewidget.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d.a.d;
import com.baidu.swan.apps.inlinewidget.d.a.e;
import com.baidu.swan.apps.inlinewidget.d.c;
/* loaded from: classes10.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cWz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cWz = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.d.a.1
            @Override // com.baidu.swan.apps.inlinewidget.d.c.a
            public void avU() {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.cWz);
        this.cVM.a(new d());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.d.a.c());
        this.cVM.a(new e());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.d.a.a());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.d.a.b());
    }
}
