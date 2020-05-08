package com.baidu.swan.apps.r.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.r.a.a.d;
import com.baidu.swan.apps.r.a.a.e;
import com.baidu.swan.apps.r.a.c;
/* loaded from: classes11.dex */
class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bUZ = new c.a() { // from class: com.baidu.swan.apps.r.a.a.1
            @Override // com.baidu.swan.apps.r.a.c.a
            public void el(int i) {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void SH() {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void jo(String str) {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void abm() {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.bUZ);
        this.bUR.a(new e());
        this.bUR.a(new com.baidu.swan.apps.r.a.a.a());
        this.bUR.a(new d());
        this.bUR.a(new com.baidu.swan.apps.r.a.a.c());
        this.bUR.a(new com.baidu.swan.apps.r.a.a.b());
    }
}
