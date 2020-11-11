package com.baidu.swan.apps.inlinewidget.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes10.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cVU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cVU = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void hI(int i) {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void akZ() {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void oD(String str) {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void avD() {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.cVU);
        this.cVM.a(new e());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.cVM.a(new d());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
