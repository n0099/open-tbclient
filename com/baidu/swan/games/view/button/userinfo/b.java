package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.v.d;
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.f.b bVar) {
        super(jsObject, bVar);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.aQm() != null) {
                    b.this.dyc = new UserInfoButton(com.baidu.swan.games.view.c.aQm(), b.this);
                    b.this.dyc.setType(b.this.type);
                    b.this.dyc.setButtonText(b.this.text);
                    b.this.dyc.setImageUrl(b.this.image);
                    b.this.dyc.setApiButtonStyle(b.this.style);
                    b.this.aQG();
                    b.this.aQK();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQK() {
        if (!d.aPp()) {
            com.baidu.swan.games.v.c.vO("Button shows early.");
        }
    }
}
