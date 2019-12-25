package com.baidu.swan.games.view.button.userinfo;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.u.d;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.games.view.button.base.b {
    public b(JsObject jsObject, com.baidu.swan.games.e.b bVar) {
        super(jsObject, bVar);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.button.userinfo.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.c.anI() != null) {
                    b.this.coQ = new UserInfoButton(com.baidu.swan.games.view.c.anI(), b.this);
                    b.this.coQ.setType(b.this.type);
                    b.this.coQ.setButtonText(b.this.text);
                    b.this.coQ.setImageUrl(b.this.image);
                    b.this.coQ.setApiButtonStyle(b.this.style);
                    b.this.aoc();
                    b.this.aog();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aog() {
        if (!d.amW()) {
            com.baidu.swan.games.u.c.pk("Button shows early.");
        }
    }
}
