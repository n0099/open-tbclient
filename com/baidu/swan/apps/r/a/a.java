package com.baidu.swan.apps.r.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.r.a.a.d;
import com.baidu.swan.apps.r.a.a.e;
import com.baidu.swan.apps.r.a.c;
/* loaded from: classes10.dex */
class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bsp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bsp = new c.a() { // from class: com.baidu.swan.apps.r.a.a.1
            @Override // com.baidu.swan.apps.r.a.c.a
            public void dQ(int i) {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void Iz() {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void hM(String str) {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void Rf() {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.bsp);
        this.bsh.a(new e());
        this.bsh.a(new com.baidu.swan.apps.r.a.a.a());
        this.bsh.a(new d());
        this.bsh.a(new com.baidu.swan.apps.r.a.a.c());
        this.bsh.a(new com.baidu.swan.apps.r.a.a.b());
    }
}
