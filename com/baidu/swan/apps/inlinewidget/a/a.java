package com.baidu.swan.apps.inlinewidget.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes8.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cto;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cto = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void gH(int i) {
                if (a.this.cth != null) {
                    a.this.cth.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void adl() {
                if (a.this.cth != null) {
                    a.this.cth.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void mO(String str) {
                if (a.this.cth != null) {
                    a.this.cth.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void anM() {
                if (a.this.cth != null) {
                    a.this.cth.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.cto);
        this.ctg.a(new e());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.ctg.a(new d());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
