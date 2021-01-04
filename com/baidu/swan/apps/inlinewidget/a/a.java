package com.baidu.swan.apps.inlinewidget.a;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes9.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a dgb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.dgb = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void hW(int i) {
                if (a.this.dfU != null) {
                    a.this.dfU.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void aoK() {
                if (a.this.dfU != null) {
                    a.this.dfU.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void oX(String str) {
                if (a.this.dfU != null) {
                    a.this.dfU.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void azu() {
                if (a.this.dfU != null) {
                    a.this.dfU.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.dgb);
        this.dfT.a(new e());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.dfT.a(new d());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
