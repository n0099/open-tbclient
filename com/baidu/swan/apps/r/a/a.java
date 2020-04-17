package com.baidu.swan.apps.r.a;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import com.baidu.swan.apps.r.a.a.d;
import com.baidu.swan.apps.r.a.a.e;
import com.baidu.swan.apps.r.a.c;
/* loaded from: classes11.dex */
class a extends com.baidu.swan.apps.r.b<c> {
    private final c.a bUT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull c cVar) {
        super(cVar);
        this.bUT = new c.a() { // from class: com.baidu.swan.apps.r.a.a.1
            @Override // com.baidu.swan.apps.r.a.c.a
            public void el(int i) {
                if (a.this.bUM != null) {
                    a.this.bUM.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void SI() {
                if (a.this.bUM != null) {
                    a.this.bUM.onCallback(a.this, "onCustomKeyboardHide", null);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void jo(String str) {
                if (a.this.bUM != null) {
                    a.this.bUM.onCallback(a.this, "committext", str);
                }
            }

            @Override // com.baidu.swan.apps.r.a.c.a
            public void abn() {
                if (a.this.bUM != null) {
                    a.this.bUM.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
                }
            }
        };
        cVar.a(this.bUT);
        this.bUL.a(new e());
        this.bUL.a(new com.baidu.swan.apps.r.a.a.a());
        this.bUL.a(new d());
        this.bUL.a(new com.baidu.swan.apps.r.a.a.c());
        this.bUL.a(new com.baidu.swan.apps.r.a.a.b());
    }
}
