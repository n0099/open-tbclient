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
                if (com.baidu.swan.games.view.c.aDE() != null) {
                    b.this.dic = new UserInfoButton(com.baidu.swan.games.view.c.aDE(), b.this);
                    b.this.dic.setType(b.this.type);
                    b.this.dic.setButtonText(b.this.text);
                    b.this.dic.setImageUrl(b.this.image);
                    b.this.dic.setApiButtonStyle(b.this.style);
                    b.this.aDX();
                    b.this.aEb();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEb() {
        if (!d.aCR()) {
            com.baidu.swan.games.v.c.sA("Button shows early.");
        }
    }
}
