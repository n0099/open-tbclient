package com.baidu.swan.apps.r.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.r.a.a.d;
import com.baidu.swan.apps.r.a.a.e;
import com.baidu.swan.apps.r.a.c;
/* loaded from: classes11.dex */
class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bwz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bwz = new c.a() { // from class: com.baidu.swan.apps.r.a.a.1
            @Override // com.baidu.swan.apps.r.a.c.a
            public void eg(int i) {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void KO() {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void ib(String str) {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void Tt() {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.bwz);
        this.bwr.a(new e());
        this.bwr.a(new com.baidu.swan.apps.r.a.a.a());
        this.bwr.a(new d());
        this.bwr.a(new com.baidu.swan.apps.r.a.a.c());
        this.bwr.a(new com.baidu.swan.apps.r.a.a.b());
    }
}
