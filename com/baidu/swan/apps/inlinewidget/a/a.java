package com.baidu.swan.apps.inlinewidget.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes10.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cQb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cQb = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void hy(int i) {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void aiz() {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void op(String str) {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void atd() {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.cQb);
        this.cPT.a(new e());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.cPT.a(new d());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
