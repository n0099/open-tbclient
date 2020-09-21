package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.v.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.f.b bVar) {
        super(jsObject, bVar);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.aQY() != null) {
                    b.this.dAh = new UserInfoButton(com.baidu.swan.games.view.c.aQY(), b.this);
                    b.this.dAh.setType(b.this.type);
                    b.this.dAh.setButtonText(b.this.text);
                    b.this.dAh.setImageUrl(b.this.image);
                    b.this.dAh.setApiButtonStyle(b.this.style);
                    b.this.aRs();
                    b.this.aRw();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRw() {
        if (!d.aQa()) {
            com.baidu.swan.games.v.c.wi("Button shows early.");
        }
    }
}
