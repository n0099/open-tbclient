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
                if (com.baidu.swan.games.view.c.aYb() != null) {
                    b.this.eax = new UserInfoButton(com.baidu.swan.games.view.c.aYb(), b.this);
                    b.this.eax.setType(b.this.type);
                    b.this.eax.setButtonText(b.this.text);
                    b.this.eax.setImageUrl(b.this.image);
                    b.this.eax.setApiButtonStyle(b.this.style);
                    b.this.aYv();
                    b.this.aYz();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYz() {
        if (!d.aXd()) {
            com.baidu.swan.games.v.c.xB("Button shows early.");
        }
    }
}
