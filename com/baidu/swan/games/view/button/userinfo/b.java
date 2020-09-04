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
                    b.this.dyg = new UserInfoButton(com.baidu.swan.games.view.c.aQm(), b.this);
                    b.this.dyg.setType(b.this.type);
                    b.this.dyg.setButtonText(b.this.text);
                    b.this.dyg.setImageUrl(b.this.image);
                    b.this.dyg.setApiButtonStyle(b.this.style);
                    b.this.aQG();
                    b.this.aQK();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQK() {
        if (!d.aPp()) {
            com.baidu.swan.games.v.c.vP("Button shows early.");
        }
    }
}
