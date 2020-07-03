package com.baidu.swan.apps.p.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.p.a.a.d;
import com.baidu.swan.apps.p.a.a.e;
import com.baidu.swan.apps.p.a.c;
/* loaded from: classes11.dex */
class a extends com.baidu.swan.apps.p.b<c> {
    private final c.a ckd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.ckd = new c.a() { // from class: com.baidu.swan.apps.p.a.a.1
            @Override // com.baidu.swan.apps.p.a.c.a
            public void eH(int i) {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.a.c.a
            public void Wy() {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.p.a.c.a
            public void kE(String str) {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.p.a.c.a
            public void aft() {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.ckd);
        this.cjV.a(new e());
        this.cjV.a(new com.baidu.swan.apps.p.a.a.a());
        this.cjV.a(new d());
        this.cjV.a(new com.baidu.swan.apps.p.a.a.c());
        this.cjV.a(new com.baidu.swan.apps.p.a.a.b());
    }
}
