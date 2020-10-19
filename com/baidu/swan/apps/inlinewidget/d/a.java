package com.baidu.swan.apps.inlinewidget.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.d.a.d;
import com.baidu.swan.apps.inlinewidget.d.a.e;
import com.baidu.swan.apps.inlinewidget.d.c;
/* loaded from: classes10.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cIk = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.d.a.1
            @Override // com.baidu.swan.apps.inlinewidget.d.c.a
            public void arz() {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onConfirmBtnClick", null);
                }
            }
        };
        cVar.a(this.cIk);
        this.cHx.a(new d());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.d.a.c());
        this.cHx.a(new e());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.d.a.a());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.d.a.b());
    }
}
