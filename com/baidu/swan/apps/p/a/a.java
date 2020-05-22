package com.baidu.swan.apps.p.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.p.a.a.d;
import com.baidu.swan.apps.p.a.a.e;
import com.baidu.swan.apps.p.a.c;
/* loaded from: classes11.dex */
class a extends com.baidu.swan.apps.p.b<c> {
    private final c.a cfp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.cfp = new c.a() { // from class: com.baidu.swan.apps.p.a.a.1
            @Override // com.baidu.swan.apps.p.a.c.a
            public void eu(int i) {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.a.c.a
            public void Vs() {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.p.a.c.a
            public void kw(String str) {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.p.a.c.a
            public void aen() {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.cfp);
        this.cfh.a(new e());
        this.cfh.a(new com.baidu.swan.apps.p.a.a.a());
        this.cfh.a(new d());
        this.cfh.a(new com.baidu.swan.apps.p.a.a.c());
        this.cfh.a(new com.baidu.swan.apps.p.a.a.b());
    }
}
