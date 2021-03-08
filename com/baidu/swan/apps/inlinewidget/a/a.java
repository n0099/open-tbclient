package com.baidu.swan.apps.inlinewidget.a;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes8.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a dfb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.dfb = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void gu(int i) {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void als() {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void ok(String str) {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void awc() {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.dfb);
        this.deT.a(new e());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.deT.a(new d());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
