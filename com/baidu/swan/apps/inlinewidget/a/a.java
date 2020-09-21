package com.baidu.swan.apps.inlinewidget.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes3.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a cvy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cvy = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void gQ(int i) {
                if (a.this.cvr != null) {
                    a.this.cvr.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void adU() {
                if (a.this.cvr != null) {
                    a.this.cvr.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void ni(String str) {
                if (a.this.cvr != null) {
                    a.this.cvr.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void aow() {
                if (a.this.cvr != null) {
                    a.this.cvr.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.cvy);
        this.cvq.a(new e());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.cvq.a(new d());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
