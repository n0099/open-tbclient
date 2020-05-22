package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.games.v.d;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.f.b bVar) {
        super(jsObject, bVar);
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.aCy() != null) {
                    b.this.ddr = new UserInfoButton(com.baidu.swan.games.view.c.aCy(), b.this);
                    b.this.ddr.setType(b.this.type);
                    b.this.ddr.setButtonText(b.this.text);
                    b.this.ddr.setImageUrl(b.this.image);
                    b.this.ddr.setApiButtonStyle(b.this.style);
                    b.this.aCR();
                    b.this.aCV();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCV() {
        if (!d.aBL()) {
            com.baidu.swan.games.v.c.ss("Button shows early.");
        }
    }
}
