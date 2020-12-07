package com.baidu.swan.apps.inlinewidget.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes25.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a dbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.dbg = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void ic(int i) {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void anz() {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void pe(String str) {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void ayd() {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.dbg);
        this.daY.a(new e());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.daY.a(new d());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
