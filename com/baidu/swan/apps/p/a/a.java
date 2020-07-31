package com.baidu.swan.apps.p.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.p.a.a.d;
import com.baidu.swan.apps.p.a.a.e;
import com.baidu.swan.apps.p.a.c;
/* loaded from: classes7.dex */
class a extends com.baidu.swan.apps.p.b<c> {
    private final c.a cmh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cmh = new c.a() { // from class: com.baidu.swan.apps.p.a.a.1
            @Override // com.baidu.swan.apps.p.a.c.a
            public void eJ(int i) {
                if (a.this.clZ != null) {
                    a.this.clZ.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.a.c.a
            public void Xf() {
                if (a.this.clZ != null) {
                    a.this.clZ.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.p.a.c.a
            public void la(String str) {
                if (a.this.clZ != null) {
                    a.this.clZ.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.p.a.c.a
            public void agE() {
                if (a.this.clZ != null) {
                    a.this.clZ.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.cmh);
        this.clY.a(new e());
        this.clY.a(new com.baidu.swan.apps.p.a.a.a());
        this.clY.a(new d());
        this.clY.a(new com.baidu.swan.apps.p.a.a.c());
        this.clY.a(new com.baidu.swan.apps.p.a.a.b());
    }
}
