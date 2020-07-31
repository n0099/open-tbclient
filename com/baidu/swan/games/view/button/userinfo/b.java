package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.games.v.d;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.f.b bVar) {
        super(jsObject, bVar);
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.aHu() != null) {
                    b.this.dnZ = new UserInfoButton(com.baidu.swan.games.view.c.aHu(), b.this);
                    b.this.dnZ.setType(b.this.type);
                    b.this.dnZ.setButtonText(b.this.text);
                    b.this.dnZ.setImageUrl(b.this.image);
                    b.this.dnZ.setApiButtonStyle(b.this.style);
                    b.this.aHQ();
                    b.this.aHU();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHU() {
        if (!d.aGy()) {
            com.baidu.swan.games.v.c.ty("Button shows early.");
        }
    }
}
