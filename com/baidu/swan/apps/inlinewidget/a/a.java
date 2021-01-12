package com.baidu.swan.apps.inlinewidget.a;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes8.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a dbm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.dbm = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void gq(int i) {
                if (a.this.dbf != null) {
                    a.this.dbf.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void akR() {
                if (a.this.dbf != null) {
                    a.this.dbf.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void nK(String str) {
                if (a.this.dbf != null) {
                    a.this.dbf.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void avB() {
                if (a.this.dbf != null) {
                    a.this.dbf.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.dbm);
        this.dbe.a(new e());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.dbe.a(new d());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
