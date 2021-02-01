package com.baidu.swan.apps.inlinewidget.a;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.a.a.d;
import com.baidu.swan.apps.inlinewidget.a.a.e;
import com.baidu.swan.apps.inlinewidget.a.c;
/* loaded from: classes9.dex */
class a extends com.baidu.swan.apps.inlinewidget.b<c> {
    private final c.a ddz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.ddz = new c.a() { // from class: com.baidu.swan.apps.inlinewidget.a.a.1
            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void gt(int i) {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void alp() {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void oc(String str) {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.a.c.a
            public void avZ() {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.ddz);
        this.ddq.a(new e());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.a.a.a());
        this.ddq.a(new d());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.a.a.c());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.a.a.b());
    }
}
