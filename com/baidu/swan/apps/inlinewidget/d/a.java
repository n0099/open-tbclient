package com.baidu.swan.apps.inlinewidget.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d.a.d;
import com.baidu.swan.apps.inlinewidget.d.a.e;
import com.baidu.swan.apps.inlinewidget.d.c;
/* loaded from: classes8.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a ctX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.ctX = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.d.a.1
            @Override // com.baidu.swan.apps.inlinewidget.d.c.a
            public void aod() {
                if (a.this.cth != null) {
                    a.this.cth.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.ctX);
        this.ctg.a(new d());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.d.a.c());
        this.ctg.a(new e());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.d.a.a());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.d.a.b());
    }
}
