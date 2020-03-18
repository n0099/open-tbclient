package com.baidu.swan.apps.r.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.r.a.a.d;
import com.baidu.swan.apps.r.a.a.e;
import com.baidu.swan.apps.r.a.c;
/* loaded from: classes11.dex */
class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bwN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bwN = new c.a() { // from class: com.baidu.swan.apps.r.a.a.1
            @Override // com.baidu.swan.apps.r.a.c.a
            public void eg(int i) {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void KT() {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void ia(String str) {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void Ty() {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.bwN);
        this.bwF.a(new e());
        this.bwF.a(new com.baidu.swan.apps.r.a.a.a());
        this.bwF.a(new d());
        this.bwF.a(new com.baidu.swan.apps.r.a.a.c());
        this.bwF.a(new com.baidu.swan.apps.r.a.a.b());
    }
}
