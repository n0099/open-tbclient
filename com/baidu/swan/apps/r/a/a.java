package com.baidu.swan.apps.r.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.r.a.a.d;
import com.baidu.swan.apps.r.a.a.e;
import com.baidu.swan.apps.r.a.c;
/* loaded from: classes9.dex */
class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a brB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.brB = new c.a() { // from class: com.baidu.swan.apps.r.a.a.1
            @Override // com.baidu.swan.apps.r.a.c.a
            public void dP(int i) {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void Id() {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void hJ(String str) {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void QJ() {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.brB);
        this.brt.a(new e());
        this.brt.a(new com.baidu.swan.apps.r.a.a.a());
        this.brt.a(new d());
        this.brt.a(new com.baidu.swan.apps.r.a.a.c());
        this.brt.a(new com.baidu.swan.apps.r.a.a.b());
    }
}
