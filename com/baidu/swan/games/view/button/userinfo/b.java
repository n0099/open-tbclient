package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.v.d;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.f.b bVar) {
        super(jsObject, bVar);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.aVB() != null) {
                    b.this.dUF = new UserInfoButton(com.baidu.swan.games.view.c.aVB(), b.this);
                    b.this.dUF.setType(b.this.type);
                    b.this.dUF.setButtonText(b.this.text);
                    b.this.dUF.setImageUrl(b.this.image);
                    b.this.dUF.setApiButtonStyle(b.this.style);
                    b.this.aVV();
                    b.this.aVZ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVZ() {
        if (!d.aUD()) {
            com.baidu.swan.games.v.c.xn("Button shows early.");
        }
    }
}
