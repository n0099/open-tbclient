package com.baidu.swan.apps.inlinewidget.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes8.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a ctt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.ctt = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void gH(int i) {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void adl() {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void mP(String str) {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void anM() {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.ctt);
        this.ctk.a(new e());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.ctk.a(new d());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
