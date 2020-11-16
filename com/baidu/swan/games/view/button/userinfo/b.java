package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.v.d;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.f.b bVar) {
        super(jsObject, bVar);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.aXt() != null) {
                    b.this.dYP = new UserInfoButton(com.baidu.swan.games.view.c.aXt(), b.this);
                    b.this.dYP.setType(b.this.type);
                    b.this.dYP.setButtonText(b.this.text);
                    b.this.dYP.setImageUrl(b.this.image);
                    b.this.dYP.setApiButtonStyle(b.this.style);
                    b.this.aXO();
                    b.this.aXS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXS() {
        if (!d.aWv()) {
            com.baidu.swan.games.v.c.xw("Button shows early.");
        }
    }
}
