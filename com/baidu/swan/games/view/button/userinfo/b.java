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
                if (com.baidu.swan.games.view.c.aqu() != null) {
                    b.this.ctq = new UserInfoButton(com.baidu.swan.games.view.c.aqu(), b.this);
                    b.this.ctq.setType(b.this.type);
                    b.this.ctq.setButtonText(b.this.text);
                    b.this.ctq.setImageUrl(b.this.image);
                    b.this.ctq.setApiButtonStyle(b.this.style);
                    b.this.aqO();
                    b.this.aqS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqS() {
        if (!d.apI()) {
            com.baidu.swan.games.u.c.pB("Button shows early.");
        }
    }
}
