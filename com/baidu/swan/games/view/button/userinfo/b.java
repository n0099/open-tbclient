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
                if (com.baidu.swan.games.view.c.aTH() != null) {
                    b.this.dMi = new UserInfoButton(com.baidu.swan.games.view.c.aTH(), b.this);
                    b.this.dMi.setType(b.this.type);
                    b.this.dMi.setButtonText(b.this.text);
                    b.this.dMi.setImageUrl(b.this.image);
                    b.this.dMi.setApiButtonStyle(b.this.style);
                    b.this.aUb();
                    b.this.aUf();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUf() {
        if (!d.aSJ()) {
            com.baidu.swan.games.v.c.wU("Button shows early.");
        }
    }
}
