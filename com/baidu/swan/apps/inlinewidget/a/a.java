package com.baidu.swan.apps.inlinewidget.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes10.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cHF = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void hn(int i) {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void agF() {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void nU(String str) {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void ari() {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.cHF);
        this.cHx.a(new e());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.cHx.a(new d());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
