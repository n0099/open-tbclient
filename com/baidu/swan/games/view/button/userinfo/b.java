package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.u.d;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.e.b bVar) {
        super(jsObject, bVar);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.aqr() != null) {
                    b.this.ctf = new UserInfoButton(com.baidu.swan.games.view.c.aqr(), b.this);
                    b.this.ctf.setType(b.this.type);
                    b.this.ctf.setButtonText(b.this.text);
                    b.this.ctf.setImageUrl(b.this.image);
                    b.this.ctf.setApiButtonStyle(b.this.style);
                    b.this.aqL();
                    b.this.aqP();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqP() {
        if (!d.apF()) {
            com.baidu.swan.games.u.c.pC("Button shows early.");
        }
    }
}
