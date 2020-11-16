package com.baidu.swan.apps.inlinewidget.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes7.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cUk = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void hE(int i) {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void akr() {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void ox(String str) {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void auV() {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.cUk);
        this.cUc.a(new e());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.cUc.a(new d());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
